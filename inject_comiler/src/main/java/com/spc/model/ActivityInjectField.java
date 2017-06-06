package com.spc.model;


import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

/**
 * Created by JokAr on 16/8/8.
 */
public class ActivityInjectField {
    private TypeElement mVariableElement;

    public ActivityInjectField(Element element) throws IllegalArgumentException {
        if (element.getKind() != ElementKind.CLASS) {
            throw new IllegalArgumentException(String.format("Only fields can be annotated with "));
        }
//        mVariableElement =  element;

//        InjectActivity bindView = mVariableElement.getAnnotation(InjectActivity.class);
//        mresId = bindView.;
//        if (mresId < 0) {
//            throw new IllegalArgumentException(
//                    String.format("value() in %s for field %s is not valid !", InjectActivity.class.getSimpleName(),
//                            mVariableElement.getSimpleName()));
//        }
    }

    /**
     * 获取变量名称
     *
     * @return
     */
    public Name getFieldName() {
        return mVariableElement.getSimpleName();
    }



    /**
     * 获取变量类型
     *
     * @return
     */
    public TypeMirror getFieldType() {
        return mVariableElement.asType();
    }
}
