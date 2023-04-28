package vmo.du5.com.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import io.reactivex.rxjava3.core.Single
import jakarta.inject.Inject
import vmo.du5.com.dto.ResponseModel
import vmo.du5.com.dto.response.RecruitPostResponse
import vmo.du5.com.exception.BusinessException
import vmo.du5.com.service.RecruitPostDesService

@Validated
@Produces
@Controller("/job-description")
class RecruitPostDesController {

    RecruitPostDesService buildJobDescriptionService

    @Inject
    RecruitPostDesController(RecruitPostDesService buildJobDescriptionService) {
        this.buildJobDescriptionService = buildJobDescriptionService
    }

    /**
     * Get list of recruit post already generated
     * @return {@link ResponseModel} of {@link RecruitPostResponse} data
     */
    @Get
    Single<ResponseModel<RecruitPostResponse>> getList() {
        return buildJobDescriptionService
                .getList()
                .doOnError(v -> HttpResponse.badRequest(ResponseModel.businessFail(new BusinessException(v.getMessage()))))
                .map(data -> ResponseModel.success(data))
    }
}
