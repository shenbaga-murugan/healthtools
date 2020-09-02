package org.shenba.healthtools.service;

import org.shenba.healthtools.model.THRRequest;
import org.shenba.healthtools.model.THRResponse;
import org.springframework.stereotype.Service;

/**
 * @author Shenbaga Murugan
 */
@Service
public class THRService {
    /**
     * Calculates target heart rate for given age and resting hear rate
     * for both moderate and vigorous physical activities
     * @param thrRequest
     * @return
     */
    public THRResponse computeTHR(THRRequest thrRequest) {
        THRResponse thrResponse = new THRResponse();
        int restingHR = thrRequest.getRestingHR();
        int maxHearRate = 220 - thrRequest.getAge();
        int hrr = maxHearRate - restingHR;
        thrResponse.setMaxHR(maxHearRate);
        thrResponse.setModerateHRMin((hrr * .5f) + restingHR);
        thrResponse.setModerateHRMax((hrr * .7f) + restingHR);
        thrResponse.setVigorousHRMin(thrResponse.getModerateHRMax());
        thrResponse.setVigorousHRMax((hrr * .85f) + restingHR);
        return thrResponse;
    }
}
