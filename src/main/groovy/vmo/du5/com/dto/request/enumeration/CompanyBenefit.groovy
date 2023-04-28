package vmo.du5.com.dto.request.enumeration

enum CompanyBenefit {
    INCREASING_EFFICIENCY('Increasing Efficiency'),
    IMPROVEMENT_COMMUNICATION('Improvement Communication'),
    ENHANCEMENT_CUSTOMER_EXPERIENCE('Enhancement Customer Experience'),
    COSTING_SAVING('Costing Saving'),
    DATA_ANALYSIS('Data Analysis'),
    FLEXIBILITY('Flexibility'),
    COMPETITIVE_ADVANTAGE('Competitive Advantage'),
    INNOVATION('Innovation'),
    SUSTAINABILITY('Sustainability')

    private final String value

    CompanyBenefit(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }

    static CompanyBenefit getEnumFromString(String value) {
        for (CompanyBenefit e : CompanyBenefit.values()) {
            if (e.getValue() == value) {
                return e
            }
        }
        return null
    }
}
