package org.shenba.healthtools.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BMREquation {

    @JsonProperty("M")
    MIFFLIN_ST_JEOR("M", "Miller-St Jeor"),
    @JsonProperty("H")
    HARRIS_BENEDICT("H", "Harris-Benedict"),
    @JsonProperty("K")
    KATCH_MC_ARDLE("K", "Katch-Mc Ardle");

    private String code;
    private String displayValue;
    private static Map<String, BMREquation> bmrEquationMap;

    /**
     * default constructor
     * @param code
     */
    BMREquation(String code, String displayValue) {
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
     * returns the BMR Equation enum for given string code
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
