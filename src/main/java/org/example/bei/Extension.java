package org.example.bei;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liushuaibiao
 * @date 2023/7/5 11:23
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Extension {
    String name() default "";

    ExtensionProperty[] properties();
}
