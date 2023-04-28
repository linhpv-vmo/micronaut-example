package vmo.du5.com.entity

import io.micronaut.serde.annotation.Serdeable

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.ManyToOne
import javax.persistence.Table

@Serdeable
@Entity
@Table(name = "recruit_post_content")
class RecruitPostContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id

    @Column(name = 'html_content', length = 5000)
    private String content

    @Column(name = 'ai_role', length = 50)
    private String AIRole

    @Column(name = 'create_time')
    private Long createdTime

    @ManyToOne
    @JoinColumns([
            @JoinColumn(name = "jobTitle", referencedColumnName = "job_title"),
            @JoinColumn(name = "jobLocation", referencedColumnName = "job_location"),
            @JoinColumn(name = "companyName", referencedColumnName = "company_name")
    ])
    RecruitPostRequirement recruitPostRequirement

    RecruitPostContent() {

    }

    RecruitPostContent(Long id, String content, String AIRole, Long createdTime, RecruitPostRequirement recruitPostRequirement) {
        this.id = id
        this.content = content
        this.AIRole = AIRole
        this.createdTime = createdTime
        this.recruitPostRequirement = recruitPostRequirement
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getContent() {
        return content
    }

    void setContent(String content) {
        this.content = content
    }

    String getAIRole() {
        return AIRole
    }

    void setAIRole(String AIRole) {
        this.AIRole = AIRole
    }

    Long getCreatedTime() {
        return createdTime
    }

    void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime
    }

    RecruitPostRequirement getRecruitPostRequirement() {
        return recruitPostRequirement
    }

    void setRecruitPostRequirement(RecruitPostRequirement recruitPostRequirement) {
        this.recruitPostRequirement = recruitPostRequirement
    }
}
