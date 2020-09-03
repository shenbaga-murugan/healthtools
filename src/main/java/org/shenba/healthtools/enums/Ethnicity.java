package org.shenba.healthtools.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Ethnicity {

    @JsonProperty("C")
    CAUCASIAN("C", "Caucasian"),
    @JsonProperty("A")
    AFRICAN("A", "African"),
    @JsonProperty("S")
    SOUTH_ASIAN("S", "South Asian"),
    @JsonProperty("O")
    OTHERS("O", "Others");

    private String code;
    private String displayValue;
    private static Map<String, Ethnicity> ethnicityMap;

    /**
     * default constructor
     * @param code
     */
    Ethnicity(String code, String displayValue) {
        this.code = code;
        this.displayValue = displayValue;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    /**
     * returns the Gender enum for given string code
     * @param code
     * @return
     */
    public static Ethnicity getEthnicity(int code) {
        if (ethnicityMap == null) {
            ethnicityMap = new HashMap<String, Ethnicity>();
            ethnicityMap.put(Ethnicity.CAUCASIAN.getCode(), Ethnicity.CAUCASIAN);
            ethnicityMap.put(Ethnicity.AFRICAN.getCode(), Ethnicity.AFRICAN);
            ethnicityMap.put(Ethnicity.SOUTH_ASIAN.getCode(), Ethnicity.SOUTH_ASIAN);
            ethnicityMap.put(Ethnicity.OTHERS.getCode(), Ethnicity.OTHERS);
        }
        return ethnicityMap.get(code);
    }
}
