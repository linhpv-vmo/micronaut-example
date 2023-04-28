package vmo.du5.com.entity

import io.micronaut.serde.annotation.Serdeable
import vmo.du5.com.dto.request.enumeration.*

import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table

@Serdeable
@Entity
@Table(name = "recruit_post_requirement")
class RecruitPostRequirement {

    @EmbeddedId
    private RecruitBasicRequirement recruitBasicRequirement

    @Enumerated(value = EnumType.STRING)
    @Column(name = 'domain')
    private CompanyIndustry companyIndustry

    @Column(name = 'salary_from')
    private Long salaryRangeFrom

    @Column(name = 'salary_to')
    private Long salaryRangeTo

    @Column(name = 'year_of_exp')
    private Double yearOfExperience

    @Enumerated(value = EnumType.STRING)
    @Column(name = 'education')
    private MinimumEducation minimumEducation

    @Enumerated(value = EnumType.STRING)
    @Column(name = 'competency')
    private SkillRequirement skillRequirement

    @Enumerated(value = EnumType.STRING)
    @Column(name = 'benefit')
    private CompanyBenefit companyBenefit

    @Enumerated(value = EnumType.STRING)
    @Column(name = 'position')
    private JobType jobType

    @Column(name = 'email')
    private String companyEmail

    @OneToMany(fetch = FetchType.LAZY, mappedBy = 'recruitPostRequirement', orphanRemoval = true)
    private Set<RecruitPostContent> postContents

    RecruitPostRequirement() {}

    RecruitPostRequirement(RecruitBasicRequirement recruitBasicRequirement, CompanyIndustry companyIndustry, Long salaryRangeFrom, Long salaryRangeTo, Double yearOfExperience, MinimumEducation minimumEducation, SkillRequirement skillRequirement, CompanyBenefit companyBenefit, JobType jobType, String companyEmail, Set<RecruitPostContent> postContents) {
        this.recruitBasicRequirement = recruitBasicRequirement
        this.companyIndustry = companyIndustry
        this.salaryRangeFrom = salaryRangeFrom
        this.salaryRangeTo = salaryRangeTo
        this.yearOfExperience = yearOfExperience
        this.minimumEducation = minimumEducation
        this.skillRequirement = skillRequirement
        this.companyBenefit = companyBenefit
        this.jobType = jobType
        this.companyEmail = companyEmail
        this.postContents = postContents
    }

    RecruitBasicRequirement getRecruitBasicRequirement() {
        return recruitBasicRequirement
    }

    void setRecruitBasicRequirement(RecruitBasicRequirement recruitBasicRequirement) {
        this.recruitBasicRequirement = recruitBasicRequirement
    }

    CompanyIndustry getCompanyIndustry() {
        return companyIndustry
    }

    void setCompanyIndustry(CompanyIndustry companyIndustry) {
        this.companyIndustry = companyIndustry
    }

    Long getSalaryRangeFrom() {
        return salaryRangeFrom
    }

    void setSalaryRangeFrom(Long salaryRangeFrom) {
        this.salaryRangeFrom = salaryRangeFrom
    }

    Long getSalaryRangeTo() {
        return salaryRangeTo
    }

    void setSalaryRangeTo(Long salaryRangeTo) {
        this.salaryRangeTo = salaryRangeTo
    }

    Double getYearOfExperience() {
        return yearOfExperience
    }

    void setYearOfExperience(Double yearOfExperience) {
        this.yearOfExperience = yearOfExperience
    }

    MinimumEducation getMinimumEducation() {
        return minimumEducation
    }

    void setMinimumEducation(MinimumEducation minimumEducation) {
        this.minimumEducation = minimumEducation
    }

    SkillRequirement getSkillRequirement() {
        return skillRequirement
    }

    void setSkillRequirement(SkillRequirement skillRequirement) {
        this.skillRequirement = skillRequirement
    }

    CompanyBenefit getCompanyBenefit() {
        return companyBenefit
    }

    void setCompanyBenefit(CompanyBenefit companyBenefit) {
        this.companyBenefit = companyBenefit
    }

    JobType getJobType() {
        return jobType
    }

    void setJobType(JobType jobType) {
        this.jobType = jobType
    }

    String getCompanyEmail() {
        return companyEmail
    }

    void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail
    }

    Set<RecruitPostContent> getPostContents() {
        return postContents
    }

    void setPostContents(Set<RecruitPostContent> postContents) {
        this.postContents = postContents
    }
}
