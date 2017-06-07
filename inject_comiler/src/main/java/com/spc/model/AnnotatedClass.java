package com.spc.model;


import com.spc.TypeUtil;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;


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
        // build inject method
        MethodSpec.Builder injectMethod = MethodSpec.methodBuilder(TypeUtil.METHOD_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(TypeName.get(mTypeElement.asType()), "activity", Modifier.FINAL);
        injectMethod.addStatement(TypeUtil.MAIN_ACTIVITY_PATH + ".$L.builder()\n.$L($L)\n" +
                        ".$L(new $L(activity))\n" +
                        ".build()\n.$L(activity)",
                "Dagger" + mTypeElement.getSimpleName() + "$$Component",
                TypeUtil.APP_Component_Name,
                TypeUtil.APPCOMPONENT_PROVIDE_PATH,
                TypeUtil.APP_ActivityModule_Name,
                TypeUtil.ACTIVITY_MODULE_PATH,
                TypeUtil.METHOD_NAME);

        //generaClass
        TypeSpec injectClass = TypeSpec.classBuilder(mTypeElement.getSimpleName() + "$$ActivityInject")
                .addModifiers(Modifier.PUBLIC)
//                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.INJET_NAME, TypeName.get(mTypeElement.asType())))
                .addMethod(injectMethod.build())
                .build();
        String packgeName = mElements.getPackageOf(mTypeElement).getQualifiedName().toString();
        return JavaFile.builder(packgeName, injectClass).build();
    }

    public JavaFile generateDaggerFile() {
        MethodSpec.Builder injectMethod = MethodSpec.methodBuilder(TypeUtil.METHOD_NAME)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addParameter(TypeName.get(mTypeElement.asType()), "activity");
        //generaClass
        TypeSpec injectClass = TypeSpec.interfaceBuilder(mTypeElement.getSimpleName() + "$$Component")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(TypeUtil.ACTIVITY_SCOPE_CLASSNAME)
                .addAnnotation(AnnotationSpec.builder(ClassName.get("dagger", "Component"))
                        .addMember("dependencies", "$L", TypeUtil.APP_COMPONENT_PATH + ".class")
                        .addMember("modules", "$L", TypeUtil.ACTIVITY_MODULE_PATH + ".class")
                        .build())
                .addMethod(injectMethod.build())
                .build();
        gradleLog("---->dagger   Component   buuild success");
        String packgeName = mElements.getPackageOf(mTypeElement).getQualifiedName().toString();
        return JavaFile.builder(packgeName, injectClass).build();
    }

    private void gradleLog(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, String.format(msg, args));
    }
}
