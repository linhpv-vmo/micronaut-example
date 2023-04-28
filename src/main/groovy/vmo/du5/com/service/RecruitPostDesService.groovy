package vmo.du5.com.service

import io.reactivex.rxjava3.core.Single
import vmo.du5.com.dto.response.RecruitPostResponse

interface RecruitPostDesService {

    Single<List<RecruitPostResponse>> getList()
}