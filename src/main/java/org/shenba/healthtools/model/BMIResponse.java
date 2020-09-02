package org.shenba.healthtools.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class BMIResponse extends RepresentationModel<BMIResponse> {
    private final float bmi;

    @JsonCreator
    public BMIResponse(@JsonProperty("bmi") float bmi) {
        this.bmi = bmi;
    }
}
