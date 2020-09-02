package org.shenba.healthtools.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.shenba.healthtools.model.BMIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shenbaga Murugan
 */
@RestController
@RequestMapping(path = "/bmi")
public class BMIController {

    @GetMapping(path = "")
    public float computeBMI(@RequestParam(name = "height", required = true) float height,
                            @RequestParam(name = "weight", required = true) float weight){
        return weight / (height * height);
    }

    @GetMapping(path = "/v2")
    public BMIResponse computeBMIV2(@RequestParam(name = "height", required = true) float height,
                                  @RequestParam(name = "weight", required = true) float weight){
        BMIResponse bmiResponse = new BMIResponse(weight / (height * height));
        bmiResponse.add(linkTo(methodOn(BMIController.class).computeBMIV2(height, weight)).withSelfRel());
        return bmiResponse;
    }
}
