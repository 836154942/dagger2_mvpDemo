package com.spc.model;


import com.spc.OnClick2;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;

/**
 * Created by JokAr on 16/8/8.
 */
public class OnClickMethod {
    private ExecutableElement mExecutableElement;
    private int[] resIds;
    private Name mMethodName;

    public OnClickMethod(Element element) throws IllegalArgumentException {
        if (element.getKind() != ElementKind.METHOD) {
            throw new IllegalArgumentException(
                    String.format("Only methods can be annotated with @%s",
                            OnClick2.class.getSimpleName()));
        }

        mExecutableElement = (ExecutableElement) element;

        resIds = mExecutableElement.getAnnotation(OnClick2.class).value();

        if (resIds == null) {
            throw new IllegalArgumentException(String.format("Must set valid ids for @%s",
                    OnClick2.class.getSimpleName()));
        } else {
            for (int id : resIds) {
                if (id < 0) {
                    throw new IllegalArgumentException(String.format("Must set valid id for @%s",
                            OnClick2.class.getSimpleName()));
                }
            }
        }
        mMethodName = mExecutableElement.getSimpleName();
        List<? extends VariableElement> parameters = mExecutableElement.getParameters();

        if (parameters.size() > 0) {
            throw new IllegalArgumentException(
                    String.format("The method annotated with @%s must have no parameters",
                            OnClick2.class.getSimpleName()));
        }
    }

    /**
     * 获取方法名称
     * @return
     */
    public Name getMethodName() {
        return mMethodName;
    }

    /**
     * 获取id数组
     * @return
     */
    public int[] getResIds() {
        return resIds;
    }
}
