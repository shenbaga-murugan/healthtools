package org.shenba.healthtools.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
public enum BMREquation {

    @JsonProperty("M")
    MIFFLIN_ST_JEOR("M"),
    @JsonProperty("H")
    HARRIS_BENEDICT("H"),
    @JsonProperty("K")
    KATCH_MC_ARDLE("K");

    private String code;
    private static Map<String, BMREquation> bmrEquationMap;

    /**
     * default constructor
     * @param code
     */
    BMREquation(String code) {
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
    public static BMREquation getBMREquation(int code) {
        if (bmrEquationMap == null) {
            bmrEquationMap = new HashMap<String, BMREquation>();
            bmrEquationMap.put(BMREquation.MIFFLIN_ST_JEOR.getCode(), BMREquation.MIFFLIN_ST_JEOR);
            bmrEquationMap.put(BMREquation.HARRIS_BENEDICT.getCode(), BMREquation.HARRIS_BENEDICT);
            bmrEquationMap.put(BMREquation.KATCH_MC_ARDLE.getCode(), BMREquation.KATCH_MC_ARDLE);
        }
        return bmrEquationMap.get(code);
    }
}
