package org.shenba.healthtools.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.shenba.healthtools.model.BMIRequest;
import org.shenba.healthtools.model.BMIResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Shenbaga Murugan
 */
@RestController
@RequestMapping(path = "/bmi")
public class BMIController {

    /**
     * @param height in metre
     * @param weight in kg
     * @return BMI for provided height and weight
     */
    @GetMapping(path = "")
    public float computeBMI(@RequestParam(name = "height", required = true) float height,
                            @RequestParam(name = "weight", required = true) float weight){
        return weight / (height * height);
    }

    /**
     * @param height in metre
     * @param weight in kg
     * @return BMI for provided height and weight in HATEOAS JSON
     */
    @GetMapping(path = "/v2")
    public BMIResponse computeBMIV2(@RequestParam(name = "height", required = true) float height,
                                  @RequestParam(name = "weight", required = true) float weight){
        BMIResponse bmiResponse = new BMIResponse(weight / (height * height));
        bmiResponse.add(linkTo(methodOn(BMIController.class).computeBMIV2(height, weight)).withSelfRel());
        return bmiResponse;
    }

    /**
     * @param bmiRequest it contains height in metre, weight in kg and age (nearest whole number)
     * @return BMI for given information
     */
    @PostMapping(path = "")
    public float computeBMI(@Valid @RequestBody BMIRequest bmiRequest) {
        return bmiRequest.getWeight() / (bmiRequest.getHeight() * bmiRequest.getHeight());
    }

}
