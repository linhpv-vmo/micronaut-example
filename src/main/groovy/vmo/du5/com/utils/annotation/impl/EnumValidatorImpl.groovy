package vmo.du5.com.utils.annotation.impl


import io.micronaut.serde.annotation.SerdeImport
import vmo.du5.com.utils.annotation.EnumValidator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.ValidationException

@SerdeImport(ValidationException.class)
class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {
    List<String> enumValueList = null

    @Override
    void initialize(EnumValidator constraintAnnotation) {
        enumValueList = new ArrayList<String>()
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz()

        Enum[] enumValArr = enumClass.getEnumConstants()
        for (Enum enumVal : enumValArr) {
            enumValueList.add(enumVal.name().replaceAll('[^0-9A-Za-z]', '').toLowerCase())
        }
    }

    @Override
    boolean isValid(String realVal, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(realVal)) {
            return true
        }
        return enumValueList.contains(realVal.replaceAll('[^0-9A-Za-z]', '').toLowerCase())
    }
}
