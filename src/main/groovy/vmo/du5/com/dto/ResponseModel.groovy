package vmo.du5.com.dto

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
class ResponseModel<T> {

    @Schema(example = '200')
    private Integer code

    @Schema(example = 'success')
    private String message

    @Schema(name = 'responseData')
    private T responseData

    ResponseModel(){

    }

    ResponseModel(Integer code, String message, T responseData) {
        this.code = code
        this.message = message
        this.responseData = responseData
    }

    ResponseModel(T responseData) {
        this.responseData = responseData
    }

    static <T> ResponseModel<T> success(T responseData) {
        return new ResponseModel<>(200, "success", responseData)
    }

    static <T> ResponseModel<T> fail(T responseData) {
        return new ResponseModel<>(400, "bad request", responseData)
    }

    static <T> ResponseModel<T> businessFail(T responseData) {
        return new ResponseModel<>(400, "business exception", responseData)
    }

    Integer getCode() {
        return code
    }

    void setCode(Integer code) {
        this.code = code
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }

    T getResponseData() {
        return responseData
    }

    void setResponseData(T responseData) {
        this.responseData = responseData
    }
}
