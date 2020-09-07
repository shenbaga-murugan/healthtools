package org.shenba.healthtools.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.shenba.healthtools.enums.ActivityLevel;
import org.shenba.healthtools.enums.BMREquation;
import org.shenba.healthtools.enums.Gender;

/**
 * @author Shenbaga Murugan
 */
@Getter
@Setter
@ApiModel
public class BMRRequest {
    private int age;
    @ApiModelProperty(dataType = "String", example = "M")
    private Gender gender;
    private float weight;
    private float height;
    private float fatPercentage;
    @ApiModelProperty(dataType = "String", example = "H")
    private BMREquation bmrEquation;
    @ApiModelProperty(dataType = "String", example = "A")
    private ActivityLevel activityLevel;
}
