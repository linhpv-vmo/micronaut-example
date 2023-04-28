package vmo.du5.com.utils.annotation

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.Target

import static java.lang.annotation.ElementType.CONSTRUCTOR
import static java.lang.annotation.ElementType.FIELD
import static java.lang.annotation.ElementType.METHOD
import static java.lang.annotation.RetentionPolicy.RUNTIME

@Target([METHOD, CONSTRUCTOR, FIELD])
@Retention(RUNTIME)
@Documented
@interface Description {
    String description() default ''

    String brief() default ''
}