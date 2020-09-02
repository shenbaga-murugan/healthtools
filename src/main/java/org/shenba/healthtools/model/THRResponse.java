package org.shenba.healthtools.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Shenbaga Murugan
 */
@Getter
@Setter
public class THRResponse {
    private float maxHR;
    private float moderateHRMin;
    private float moderateHRMax;
    private float vigorousHRMin;
    private float vigorousHRMax;
}
