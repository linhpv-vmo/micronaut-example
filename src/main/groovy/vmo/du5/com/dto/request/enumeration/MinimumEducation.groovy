package vmo.du5.com.dto.request.enumeration

enum MinimumEducation {
    BACHELOR_DEGREE('Bachelor Degree'),
    MASTER_DEGREE('Master Degree'),
    PHD_DEGREE('Phd Degree'),
    PROFESSOR_DEGREE('Professor Degree'),
    DOCTORATE_DEGREE('Doctorate Degree'),
    ENGINEERING_DEGREE('Engineering Degree')
    private final String value

    MinimumEducation(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }

    static MinimumEducation getEnumFromString(String value) {
        for (MinimumEducation e : MinimumEducation.values()) {
            if (e.getValue() == value) {
                return e
            }
        }
        return null
    }
}