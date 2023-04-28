package vmo.du5.com.service.impl

import io.reactivex.rxjava3.core.Single
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import vmo.du5.com.dto.response.RecruitPostContentResponse
import vmo.du5.com.dto.response.RecruitPostResponse
import vmo.du5.com.entity.RecruitBasicRequirement
import vmo.du5.com.entity.RecruitPostRequirement
import vmo.du5.com.repository.RecruitPostRepository
import vmo.du5.com.service.RecruitPostDesService

import java.util.stream.Collectors

@Singleton
class RecruitPostDesServiceImpl implements RecruitPostDesService {

    private static final Logger logger = LoggerFactory.getLogger(RecruitPostDesServiceImpl.class)


    private RecruitPostRepository recruitPostRepository

    @Inject
    RecruitPostDesServiceImpl(RecruitPostRepository recruitPostRepository) {
        this.recruitPostRepository = recruitPostRepository
    }

    /**
     * Get list recruit post already render.
     * @return List {@link RecruitPostResponse>} response includes html content,
     */
    @Override
    Single<List<RecruitPostResponse>> getList() {
        List<RecruitPostRequirement> recruitPostRequirementList = recruitPostRepository.findAll()
        return Single.just(recruitPostRequirementList.stream()
                .map(recruitPostRequirement -> {
                    List<RecruitPostContentResponse> recruitPostContentResponseList =
                            new ArrayList<>(recruitPostRequirement.getPostContents())
                                    .stream().map(recruitPostContent ->
                                    new RecruitPostContentResponse(recruitPostContent.getAIRole(),
                                            recruitPostContent.getContent(),
                                            recruitPostContent.getCreatedTime()))
                                    .collect(Collectors.toList())
                    RecruitBasicRequirement recruitBasicRequirement = recruitPostRequirement.getRecruitBasicRequirement()
                    return new RecruitPostResponse(recruitBasicRequirement.getJobTitle(),
                            recruitBasicRequirement.getJobLocation(),
                            recruitBasicRequirement.getCompanyName(),
                            recruitPostContentResponseList)
                })
                .collect(Collectors.toList()))
    }

}
