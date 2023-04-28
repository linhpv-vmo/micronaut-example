package vmo.du5.com.utils.annotation

import vmo.du5.com.utils.annotation.impl.EnumValidatorImpl

import javax.validation.Constraint
import javax.validation.Payload
import javax.validation.ReportAsSingleViolation
import java.lang.annotation.*

/**
 * Only use this annotation when the name and the value is the same in case insensitive.
 * For example: DATA('data')
 */
@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ReportAsSingleViolation
@interface EnumValidator {
    Class<? extends Enum<?>> enumClazz()

    String message() default "value is not valid"

    Class<?>[] groups() default []

    Class<? extends Payload>[] payload() default []
}
