package org.shenba.healthtools.controller;

import org.shenba.healthtools.model.THRRequest;
import org.shenba.healthtools.model.THRResponse;
import org.shenba.healthtools.service.THRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shenbaga Murugan
 */
@RestController
@RequestMapping(path = "/target-heart-rate")
public class THRController {

    @Autowired
    private THRService thrService;

    @PostMapping(path = "")
    public THRResponse getTargetHr(@RequestBody THRRequest thrRequest) {
        return thrService.computeTHR(thrRequest);
    }
}
