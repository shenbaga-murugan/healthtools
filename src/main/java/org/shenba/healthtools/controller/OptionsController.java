package org.shenba.healthtools.controller;

import org.shenba.healthtools.enums.BMREquation;
import org.shenba.healthtools.enums.Ethnicity;
import org.shenba.healthtools.enums.Gender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shenbaga Murugan
 */
@RestController
@RequestMapping(path = "/options")
public class OptionsController {

    /**
     * returns all genders
     * @return
     */
    @GetMapping(path = "/gender")
    public Gender[] getGenderOptions() {
        return Gender.values();
    }

    /**
     * returns all ethnicities
     * @return
     */
    @GetMapping(path = "/ethnicity")
    public Ethnicity[] getEthnicityOptions() {
        return Ethnicity.values();
    }

    /**
     * returns all BMR formulae
     * @return
     */
    @GetMapping(path = "/bmr-equation")
    public BMREquation[] getBMREquationsOptions() {
        return BMREquation.values();
    }
}
