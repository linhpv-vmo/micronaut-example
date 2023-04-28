package vmo.du5.com.entity

import io.micronaut.serde.annotation.Serdeable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull

@Serdeable
@Embeddable
class RecruitBasicRequirement implements Serializable {

    @NotNull
    @Column(name = 'job_title', nullable = false)
    private String jobTitle

    @NotNull
    @Column(name = 'job_location', nullable = false, length = 300)
    private String jobLocation

    @NotNull
    @Column(name = 'company_name', nullable = false)
    private String companyName

    RecruitBasicRequirement(String jobTitle, String jobLocation, String companyName) {
        this.jobTitle = jobTitle
        this.jobLocation = jobLocation
        this.companyName = companyName
    }

    RecruitBasicRequirement() {

    }

    String getJobTitle() {
        return jobTitle
    }

    void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle
    }

    String getJobLocation() {
        return jobLocation
    }

    void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation
    }

    String getCompanyName() {
        return companyName
    }

    void setCompanyName(String companyName) {
        this.companyName = companyName
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        RecruitBasicRequirement that = (RecruitBasicRequirement) o

        if (companyName != that.companyName) return false
        if (jobLocation != that.jobLocation) return false
        if (jobTitle != that.jobTitle) return false

        return true
    }

    int hashCode() {
        int result
        result = jobTitle.hashCode()
        result = 31 * result + jobLocation.hashCode()
        result = 31 * result + companyName.hashCode()
        return result
    }
}
