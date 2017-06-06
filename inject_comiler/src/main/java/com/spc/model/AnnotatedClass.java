package com.spc.model;


import com.spc.InjectActivity;
import com.spc.TypeUtil;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by JokAr on 16/8/8.
 */
public class AnnotatedClass {

    private TypeElement mTypeElement;
    private ArrayList<ActivityInjectField> mFields;
    private ArrayList<OnClickMethod> mMethods;
    private Elements mElements;

    public AnnotatedClass(TypeElement typeElement, Elements elements) {
        mTypeElement = typeElement;
        mElements = elements;
        mFields = new ArrayList<>();
        mMethods = new ArrayList<>();
    }

    public String getFullClassName() {
        return mTypeElement.getQualifiedName().toString();
    }

    public void addField(ActivityInjectField field) {
        mFields.add(field);
    }

    public void addMethod(OnClickMethod method) {
        mMethods.add(method);
    }

    public JavaFile generateFile() {
        //generateMethod 生成方法签名
        MethodSpec.Builder injectMethod = MethodSpec.methodBuilder(TypeUtil.METHOD_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mTypeElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeName.OBJECT, "source")
                .addParameter(TypeUtil.PROVIDER, "provider");

        MethodSpec.Builder injectMethod2 = MethodSpec.methodBuilder(TypeUtil.METHOD_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mTypeElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeName.OBJECT, "source");
        injectMethod2.addStatement("android.widget.Toast.makeText(host, $L, android.widget.Toast.LENGTH_SHORT).show()", "\"asdjgasdgasdga\"")

                .addStatement("com.spc.spc.myapplication.di.component.DaggerActivityComponent.builder()\n" +
                        "                .appcomponent(com.spc.spc.myapplication.base.MyApplication.getInst().getAppComponent())\n" +
                        "                .activityModule(new com.spc.spc.myapplication.di.module.ActivityModule(host))\n" +
                        "                .build().inject(host)");

        for (ActivityInjectField field : mFields) {
            // find views  addStatement添加代码语句
            injectMethod.addStatement("String string = new String()");
//                    field.getFieldName(),
//                    ClassName.get(field.getFieldType()), field.getResId());
        }

        for (OnClickMethod method : mMethods) {
            TypeSpec listener = TypeSpec.anonymousClassBuilder("")
                    .addSuperinterface(TypeUtil.ANDROID_ON_CLICK_LISTENER)
                    .addMethod(MethodSpec.methodBuilder("onClick")
                            .addAnnotation(Override.class)
                            .addModifiers(Modifier.PUBLIC)
                            .returns(TypeName.VOID)
                            .addParameter(TypeUtil.ANDROID_VIEW, "view")
                            .addStatement("host.$N()", method.getMethodName())
                            .build())
                    .build();
            injectMethod.addStatement("View.OnClickListener listener = $L ", listener);
            for (int id : method.getResIds()) {
                // set listeners
                injectMethod.addStatement("provider.findView(source, $L).setOnClickListener(listener)", id);
            }
        }

        //generaClass
        TypeSpec injectClass = TypeSpec.classBuilder(mTypeElement.getSimpleName() + "$$ActivityInject")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(InjectActivity.class)
                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.INJET, TypeName.get(mTypeElement.asType())))
                .addMethod(injectMethod.build())
                .addMethod(injectMethod2.build())
                .build();

        String packgeName = mElements.getPackageOf(mTypeElement).getQualifiedName().toString();

        return JavaFile.builder(packgeName, injectClass).build();
    }
}
