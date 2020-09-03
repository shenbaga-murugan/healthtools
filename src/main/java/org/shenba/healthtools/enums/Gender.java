package org.shenba.healthtools.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

    @JsonProperty("M")
    MALE("M", "Male"),
    @JsonProperty("F")
    FEMALE("F", "Female");

    private String code;
    private String displayValue;
    private static Map<String, Gender> genders;

    /**
     * default constructor
     * @param code
     */
    Gender(String code, String displayValue) {
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
    public static Gender getGender(int code) {
        if (genders == null) {
            genders = new HashMap<String, Gender>();
            genders.put(Gender.MALE.getCode(), Gender.MALE);
            genders.put(Gender.FEMALE.getCode(), Gender.FEMALE);
        }
        return genders.get(code);
    }
}
