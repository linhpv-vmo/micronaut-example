package vmo.du5.com.exception

import com.fasterxml.jackson.annotation.JsonInclude
import io.micronaut.serde.annotation.Serdeable

@JsonInclude(JsonInclude.Include.NON_NULL)
@Serdeable
class BusinessException extends RuntimeException {

    private String errorMessage

    private List<ErrorDetail> errorDetails

    BusinessException() {

    }

    BusinessException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    BusinessException(List<ErrorDetail> errorDetails) {
        this.errorDetails = errorDetails;
    }

    String getErrorMessage() {
        return errorMessage
    }

    void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage
    }

    List<ErrorDetail> getErrorDetails() {
        return errorDetails
    }

    void setErrorDetails(List<ErrorDetail> errorDetails) {
        this.errorDetails = errorDetails
    }
}
