package org.shenba.healthtools.service;

import org.shenba.healthtools.model.BMRRequest;
import org.springframework.stereotype.Service;

/**
 * @author Shenbaga Murugan
 */
@Service
public class BMRService {

    /**
     * Computes BMR using Revised Harris-Benedict Equation
     * @param bmrRequest
     * @return
     */
    public float computeHarrisBenedict(BMRRequest bmrRequest) {
        switch (bmrRequest.getGender()) {
            case FEMALE:
                return (13.397f * bmrRequest.getWeight())
                        + (479.9f * bmrRequest.getHeight())
                        - (567.7f * bmrRequest.getAge()) + 88.362f;
            case MALE:
                return (9.247f * bmrRequest.getWeight())
                        + (309.8f * bmrRequest.getHeight())
                        - (4.330f * bmrRequest.getAge()) + 447.593f;
            default:
                return 0;
        }
    }

    /**
     * Computes BMR using Mifflin-St Jeor Equation
     * @param bmrRequest
     * @return
     */
    public float computeMifflinJeor(BMRRequest bmrRequest) {
        switch (bmrRequest.getGender()) {
            case FEMALE:
                return (10f * bmrRequest.getWeight())
                        + (625f * bmrRequest.getHeight())
                        - (5f * bmrRequest.getAge()) + 5f;
            case MALE:
                return (10f * bmrRequest.getWeight())
                        + (625f * bmrRequest.getHeight())
                        - (5f * bmrRequest.getAge()) - 161f;
            default:
                return 0;
        }
    }

    /**
     * Computes BMR using Katch-Mc Ardle Equation
     * @param bmrRequest
     * @return
     */
    public float computeKatchMcArdle(BMRRequest bmrRequest) {
       return 370f + ((21.6f
               * (1 - (bmrRequest.getFatPercentage() / 100)))
                    * bmrRequest.getWeight());
    }

    /**
     * computes BMR for given information
     * @param bmrRequest
     * @return
     */
    public float computeBMR(BMRRequest bmrRequest) {
        switch (bmrRequest.getBmrEquation()) {
            case HARRIS_BENEDICT:
                return computeHarrisBenedict(bmrRequest);
            case KATCH_MC_ARDLE:
                return computeKatchMcArdle(bmrRequest);
            case MIFFLIN_ST_JEOR:
                return computeMifflinJeor(bmrRequest);
            default:
                return 0;
        }
    }

}
