package vmo.du5.com.dto.request.enumeration

enum SkillRequirement {
    ENTRY_LEVEL('Entry-level'),
    MID_LEVEL('Mid-level'),
    SENIOR_LEVEL('Senior-level'),
    MANAGEMENT('Management')

    private final String value

    SkillRequirement(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }

    static SkillRequirement getEnumFromString(String value) {
        for (SkillRequirement e : SkillRequirement.values()) {
            if (e.getValue() == value) {
                return e
            }
        }
        return null
    }

}