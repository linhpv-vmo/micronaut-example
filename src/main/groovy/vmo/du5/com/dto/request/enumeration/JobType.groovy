package vmo.du5.com.dto.request.enumeration

enum JobType {
    CHIEF_TECHNOLOGY_OFFICER('Chief Technology Officer'),
    DATA_ARCHITECT('Data Architect'),
    IT_DIRECTOR('IT Director'),
    CLOUD_SOLUTIONS_ARCHITECT('Cloud Solutions Architect'),
    SENIOR_SOFTWARE_ENGINEER('Senior Software Engineer')

    private final String value

    JobType(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }

    static JobType getEnumFromString(String value) {
        for (JobType e : JobType.values()) {
            if (e.getValue() == value) {
                return e
            }
        }
        return null
    }
}
