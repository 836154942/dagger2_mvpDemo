package com.spc.model;


import com.spc.TypeUtil;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by JokAr on 16/8/8.
 */
public class AnnotatedClass {

    private TypeElement mTypeElement;
    private Elements mElements;

    public AnnotatedClass(TypeElement typeElement, Elements elements) {
        mTypeElement = typeElement;
        mElements = elements;
    }


    public JavaFile generateFile() {
        MethodSpec.Builder injectMethod = MethodSpec.methodBuilder(TypeUtil.METHOD_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mTypeElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeName.OBJECT, "object");
        injectMethod.addStatement("android.widget.Toast.makeText(host, $L, android.widget.Toast.LENGTH_SHORT).show()", "\"build生成的toast\"")
                .addStatement("((com.spc.spc.myapplication.di.component.ActivityComponent)object).inject(host)");

        //generaClass

        TypeSpec injectClass = TypeSpec.classBuilder(mTypeElement.getSimpleName() + "$$ActivityInject")
                .addModifiers(Modifier.PUBLIC)
//                .addAnnotation(InjectActivity.class)
                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.INJET, TypeName.get(mTypeElement.asType())))
                .addMethod(injectMethod.build())
                .build();
        String packgeName = mElements.getPackageOf(mTypeElement).getQualifiedName().toString();
        return JavaFile.builder(packgeName, injectClass).build();
    }
}
