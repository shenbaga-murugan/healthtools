package org.shenba.healthtools.model;

import lombok.Getter;
import lombok.Setter;
import org.shenba.healthtools.enums.BMREquation;
import org.shenba.healthtools.enums.Gender;

/**
 * @author Shenbaga Murugan
 */
@Getter
@Setter
public class BMRRequest {
    private int age;
    private Gender gender;
    private float weight;
    private float height;
    private float fatPercentage;
    private BMREquation bmrEquation;
}
