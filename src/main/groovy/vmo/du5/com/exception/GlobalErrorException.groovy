package vmo.du5.com.exception

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Produces
import io.micronaut.http.hateoas.JsonError
import io.micronaut.http.hateoas.Link
import vmo.du5.com.dto.ResponseModel

import javax.validation.ConstraintViolationException

@Produces
@Controller
class GlobalExceptionHandler {

    @Error(global = true)
    HttpResponse handleException(Exception exception) {
        // String errorResponse = "Internal Server Error: ${exception.getMessage()}"
        return HttpResponse.serverError(exception)
    }

    @Error(global = true, exception = ConstraintViolationException)
    HttpResponse<ResponseModel<?>> handleValidationErrors(ConstraintViolationException exception) {
        return HttpResponse.badRequest(ResponseModel.fail(Utilities.violationsMessages(exception.getConstraintViolations())))
    }

    @Error(global = true, status = HttpStatus.METHOD_NOT_ALLOWED)
    HttpResponse methodNotAllow(HttpRequest request) {
        JsonError error = new JsonError("Method Not Allowed")
                .link(Link.SELF, Link.of(request.getUri()));

        return HttpResponse.<JsonError> notAllowed()
                .body(error)
    }

    @Error(global = true, exception = BusinessException)
    HttpResponse<ResponseModel<?>> handleBusinessException(BusinessException exception) {
        Map<String, String> errorResponse = new HashMap<>()
        errorResponse.put("errorMessage", exception.getErrorMessage())

        return HttpResponse.badRequest(ResponseModel.businessFail(errorResponse))
    }
}