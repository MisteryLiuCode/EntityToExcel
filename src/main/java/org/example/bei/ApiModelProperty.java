package org.example.bei;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author liushuaibiao
 * @date 2023/7/5 11:18
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModelProperty {
    String value() default "";

    String name() default "";

    String allowableValues() default "";

    String access() default "";

    String notes() default "";

    String dataType() default "";

    boolean required() default false;

    int position() default 0;

    boolean hidden() default false;

    String example() default "";

    /** @deprecated */
    @Deprecated
    boolean readOnly() default false;

    AccessMode accessMode() default ApiModelProperty.AccessMode.AUTO;

    String reference() default "";

    boolean allowEmptyValue() default false;

    Extension[] extensions() default {@Extension(
            properties = {@ExtensionProperty(
                    name = "",
                    value = ""
            )}
    )};

    public static enum AccessMode {
        AUTO,
        READ_ONLY,
        READ_WRITE;

        private AccessMode() {
        }
    }
}
