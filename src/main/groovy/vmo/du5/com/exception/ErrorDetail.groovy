package vmo.du5.com.exception

import io.micronaut.serde.annotation.Serdeable

@Serdeable
class ErrorDetail {
    private String fieldError
    private String detail

    ErrorDetail(){

    }

    ErrorDetail(String fieldError, String detail) {
        this.fieldError = fieldError
        this.detail = detail
    }

    String getFieldError() {
        return fieldError
    }

    void setFieldError(String fieldError) {
        this.fieldError = fieldError
    }

    String getDetail() {
        return detail
    }

    void setDetail(String detail) {
        this.detail = detail
    }
}
