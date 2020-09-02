package org.shenba.healthtools.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
public enum Gender {

    @JsonProperty("M")
    MALE("M"),
    @JsonProperty("F")
    FEMALE("F");

    private String code;
    private static Map<String, Gender> genders;

    /**
     * default constructor
     * @param code
     */
    Gender(String code) {
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
    public static Gender getGender(int code) {
        if (genders == null) {
            genders = new HashMap<String, Gender>();
            genders.put(Gender.MALE.getCode(), Gender.MALE);
            genders.put(Gender.FEMALE.getCode(), Gender.FEMALE);
        }
        return genders.get(code);
    }
}
