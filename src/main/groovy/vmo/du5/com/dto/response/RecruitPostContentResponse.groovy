package vmo.du5.com.dto.response

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
class RecruitPostContentResponse {

    @Schema(type = "string", example = "assistant")
    private String role

    @Schema(type = "string",
            description = "the html content",
            example = "<h2>Join Our Team as a Nurse in HaNoi, VietNam</h2>")
    private String content

    @Schema(type = "number", description = "the create time in number",
            example = '1682093022')
    private Long createTime

    RecruitPostContentResponse() {

    }

    RecruitPostContentResponse(String role, String content) {
        this.role = role
        this.content = content
    }

    RecruitPostContentResponse(String role, String content, Long createTime) {
        this.role = role
        this.content = content
        this.createTime = createTime
    }

    String getRole() {
        return role
    }

    void setRole(String role) {
        this.role = role
    }

    String getContent() {
        return content
    }

    void setContent(String content) {
        this.content = content
    }

    Long getCreateTime() {
        return createTime
    }

    void setCreateTime(Long createTime) {
        this.createTime = createTime
    }
}
