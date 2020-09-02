package org.shenba.healthtools.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * @author Shenbaga Murugan
 */
@Getter
@Setter
public class BMIRequest {
    private float height;
    private float weight;
    @Min(18)
    private int age;
}
