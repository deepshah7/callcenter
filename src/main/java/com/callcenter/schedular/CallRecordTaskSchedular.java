package com.callcenter.schedular;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component("callRecordTaskSchedular")
public class CallRecordTaskSchedular {

    private static final Logger logger = Logger.getLogger(CallRecordTaskSchedular.class);

    public void checkIfCallRecordAvailable() {
        logger.error("Polling for the call record now -- START");
        logger.error("Polling for the call record now -- END");
    }
}
