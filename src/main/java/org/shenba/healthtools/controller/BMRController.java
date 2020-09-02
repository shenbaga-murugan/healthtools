package org.shenba.healthtools.controller;

import org.shenba.healthtools.model.BMRRequest;
import org.shenba.healthtools.service.BMRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shenbaga Murugan
 */
@RestController
@RequestMapping(path = "/bmr")
public class BMRController {

    @Autowired
    private BMRService bmrService;

    /**
     * This method computes BMR for given inputs using the selected equation
     * @param bmrRequest
     * @return
     */
    @PostMapping(path = "")
    public float getBMR(@RequestBody BMRRequest bmrRequest) {
        switch (bmrRequest.getBmrEquation()) {
            case HARRIS_BENEDICT:
                return bmrService.computeHarrisBenedict(bmrRequest);
            case KATCH_MC_ARDLE:
                return bmrService.computeKatchMcArdle(bmrRequest);
            case MIFFLIN_ST_JEOR:
                return bmrService.computeMifflinJeor(bmrRequest);
            default:
                return 0;
        }
    }

}
