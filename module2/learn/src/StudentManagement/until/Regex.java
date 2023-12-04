package caseStudy.untils;

public interface Regex {
    String IDSERVICE_REGEX = "^SV(VL|HO|RO)-\\d{4}$";
    String SERVICENAME_REGEX = "^[A-Z][a-z]*$";
    String AREA_REGEX = "^([3-9]\\d(\\.\\d+)?| [1-9]\\d{2,}(\\.\\d+)?)$";
    String FEE_REGEX = "^[1-9]\\d*$";
    String NUMPEOPLE_REGEX = "^([1-9]|1\\d)$";
}
