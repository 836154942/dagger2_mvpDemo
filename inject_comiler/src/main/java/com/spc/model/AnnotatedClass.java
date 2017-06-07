package com.spc.model;


import com.spc.ActivityScope;
import com.spc.TypeUtil;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import dagger.Component;


/**
 * Created by spc on 17/6/6.
 */
public class AnnotatedClass {

    private TypeElement mTypeElement;//activity
    private Elements mElements;
    private Messager mMessager;//日志打印

    public AnnotatedClass(TypeElement typeElement, Elements elements, Messager messager) {
        mTypeElement = typeElement;
        mElements = elements;
        this.mMessager = messager;
    }


    public JavaFile generateFile() {
        waring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        waring("com.spc.spc.myapplication.ui.activity.&S.builder()", mTypeElement.getSimpleName()+"&&Component");
        MethodSpec.Builder injectMethod = MethodSpec.methodBuilder(TypeUtil.METHOD_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mTypeElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeName.OBJECT, "object");
        injectMethod.addStatement("android.widget.Toast.makeText(host, $L, android.widget.Toast.LENGTH_SHORT).show()", "\"build  toast\"")
//                 .addStatement("((com.spc.spc.myapplication.di.component.ActivityComponent)object).inject(host)");
                .addStatement("com.spc.spc.myapplication.ui.activity.$L.builder()" +
                        "                .appcomponent(com.spc.spc.myapplication.base.MyApplication.getInst().getAppComponent())\n" +
                        "                .activityModule(new com.spc.spc.myapplication.di.module.ActivityModule(host))\n" +
                        "                .build().inject(host)", "Dagger"+mTypeElement.getSimpleName()+"$$Component");
        waring("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        //generaClass
        TypeSpec injectClass = TypeSpec.classBuilder(mTypeElement.getSimpleName() + "$$ActivityInject")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.INJET, TypeName.get(mTypeElement.asType())))
                .addMethod(injectMethod.build())
                .build();
        String packgeName = mElements.getPackageOf(mTypeElement).getQualifiedName().toString();
        return JavaFile.builder(packgeName, injectClass).build();
    }

    public JavaFile generateDaggerFile() {
        MethodSpec.Builder injectMethod = MethodSpec.methodBuilder(TypeUtil.METHOD_NAME)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addParameter(TypeName.get(mTypeElement.asType()), "activity");
        waring("111111111111111111111111111111111111");
        //generaClass
        TypeSpec injectClass = TypeSpec.interfaceBuilder(mTypeElement.getSimpleName() + "$$Component")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(ActivityScope.class)
                .addAnnotation(AnnotationSpec.builder(Component.class)
                        .addMember("dependencies", "$L", "com.spc.spc.myapplication.di.component.Appcomponent.class")
                        .addMember("modules", "$L", "com.spc.spc.myapplication.di.module.ActivityModule.class")
                        .build())
                .addMethod(injectMethod.build())
                .build();
        waring("22222222222222222222222222222");
        String packgeName = mElements.getPackageOf(mTypeElement).getQualifiedName().toString();
        return JavaFile.builder(packgeName, injectClass).build();
    }

    private void waring(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.WARNING, String.format(msg, args));
    }
}
