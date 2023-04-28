package vmo.du5.com.dto.response

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
class RecruitPostResponse {

    @Schema(example = "Senior Java Web Developer")
    private String jobTitle

    @Schema(example = "1600 Amphitheatre Parkway in Mountain View, California")
    private String jobLocation

    @Schema(example = "Google Inc.")
    private String companyName

    @Schema(name = 'recruitPostContentResponseList')
    List<RecruitPostContentResponse> recruitPostContentResponseList

    RecruitPostResponse(String jobTitle, String jobLocation, String companyName, List<RecruitPostContentResponse> recruitPostContentResponseList) {
        this.jobTitle = jobTitle
        this.jobLocation = jobLocation
        this.companyName = companyName
        this.recruitPostContentResponseList = recruitPostContentResponseList
    }

    public String getJobTitle() {
        return jobTitle
    }

    void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle
    }

    public getJobLocation() {
        return jobLocation
    }

    void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation
    }

    public String getCompanyName() {
        return companyName
    }

    void setCompanyName(String companyName) {
        this.companyName = companyName
    }

    public List<RecruitPostContentResponse> getRecruitPostContentResponseList() {
        return recruitPostContentResponseList
    }

    void setRecruitPostContentResponseList(List<RecruitPostContentResponse> recruitPostContentResponseList) {
        this.recruitPostContentResponseList = recruitPostContentResponseList
    }
}
