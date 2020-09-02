package org.shenba.healthtools.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
public enum Ethnicity {

    @JsonProperty("C")
    CAUCASIAN("C"),
    @JsonProperty("A")
    AFRICAN("A"),
    @JsonProperty("S")
    SOUTH_ASIAN("S"),
    @JsonProperty("O")
    OTHERS("O");

    private String code;
    private static Map<String, Ethnicity> ethnicityMap;

    /**
     * default constructor
     * @param code
     */
    Ethnicity(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
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
