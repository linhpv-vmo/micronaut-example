package vmo.du5.com.dto.request.enumeration

enum CompanyIndustry {
    HEALTHCARE('Healthcare'),
    TECHNOLOGY('Technology'),
    FINANCE('Finance'),
    RETAIL('Retail')

    private final String value

    CompanyIndustry(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }

    static CompanyIndustry getEnumFromString(String value) {
        for (CompanyIndustry e : CompanyIndustry.values()) {
            if (e.getValue() == value) {
                return e
            }
        }
        return null
    }
}
