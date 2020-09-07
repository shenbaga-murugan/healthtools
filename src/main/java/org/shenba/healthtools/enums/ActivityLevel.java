package org.shenba.healthtools.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ActivityLevel {
    @JsonProperty("S")
    SEDENTARY("S", "Sedentary", 1.2f),
    @JsonProperty("L")
    LIGHTLY_ACTIVE("L", "Lightly Active", 1.375f),
    @JsonProperty("M")
    MODERATELY_ACTIVE("M", "Moderately Active", 1.465f),
    @JsonProperty("A")
    ACTIVE("A", "Active", 1.55f),
    @JsonProperty("V")
    VERY_ACTIVE("V", "Very Active", 1.725f),
    @JsonProperty("E")
    EXTRA_ACTIVE("E", "Extra Active", 1.9f);

    private String code;
    private String displayValue;
    private float multiplier;
    private static Map<String, ActivityLevel> activityLevels;

    /**
     * default constructor
     * @param code
     */
    ActivityLevel(String code, String displayValue, float multiplier) {
        this.code = code;
        this.displayValue = displayValue;
        this.multiplier = multiplier;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public float getMultiplier() {
        return this.multiplier;
    }

    /**
     * returns the Activity Level enum for given string code
     * @param code
     * @return
     */
    public static ActivityLevel getBMREquation(int code) {
        if (activityLevels == null) {
            activityLevels = new HashMap<String, ActivityLevel>();
            activityLevels.put(ActivityLevel.SEDENTARY.getCode(), ActivityLevel.SEDENTARY);
            activityLevels.put(ActivityLevel.LIGHTLY_ACTIVE.getCode(), ActivityLevel.LIGHTLY_ACTIVE);
            activityLevels.put(ActivityLevel.MODERATELY_ACTIVE.getCode(), ActivityLevel.MODERATELY_ACTIVE);
            activityLevels.put(ActivityLevel.ACTIVE.getCode(), ActivityLevel.ACTIVE);
            activityLevels.put(ActivityLevel.VERY_ACTIVE.getCode(), ActivityLevel.VERY_ACTIVE);
            activityLevels.put(ActivityLevel.EXTRA_ACTIVE.getCode(), ActivityLevel.EXTRA_ACTIVE);
        }
        return activityLevels.get(code);
    }
}
