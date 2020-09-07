package org.shenba.healthtools.controller;

import org.shenba.healthtools.enums.ActivityLevel;
import org.shenba.healthtools.model.BMRRequest;
import org.shenba.healthtools.service.BMRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shenbaga Murugan
 */
@RestController
@RequestMapping(path = "/dcr")
public class DCRController {

    @Autowired
    private BMRService bmrService;

    /**
     * This method computes daily calorie requirement
     * for given inputs using the selected equation and activity level
     * @param bmrRequest
     * @return
     */
    @PostMapping(path = "")
    public float getDCR(@RequestBody BMRRequest bmrRequest) {
        return bmrService.computeBMR(bmrRequest) * bmrRequest.getActivityLevel().getMultiplier();
    }

    /**
     * This method computes BMR and daily calorie requirement
     * for given inputs using the selected equation and all activity levels
     * @param bmrRequest
     * @return
     */
    @PostMapping(path = "/all")
    public Map<String, Float> getAllDCR(@RequestBody BMRRequest bmrRequest) {
        Map<String, Float> allDCRs = new HashMap<String, Float>();
        allDCRs.put("BMR", bmrService.computeBMR(bmrRequest));
        for(ActivityLevel al : ActivityLevel.values()) {
            allDCRs.put(al.getDisplayValue(), bmrService.computeBMR(bmrRequest) * al.getMultiplier());
        }
        return allDCRs;
    }
}
