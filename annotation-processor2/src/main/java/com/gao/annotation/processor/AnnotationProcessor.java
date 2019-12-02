package com.gao.annotation.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @Description: 编译时注解处理器
 *
 * @Auther: gaoshudian
 * @Date: 2018/12/16 21:50
 */

@SupportedAnnotationTypes(value = {"com.gao.annotation.processor.Test"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Log in AnnotationProcessor.process");
        for (TypeElement typeElement : annotations) {
            System.out.println(typeElement);
        }
        System.out.println(roundEnv);
        return true;
    }
}
