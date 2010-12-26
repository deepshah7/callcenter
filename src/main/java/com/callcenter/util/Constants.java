package com.callcenter.util;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class Constants {

    public static class Registery {
        public static final String WAVE_FILE_REGISTRY_PATH = "SOFTWARE\\Avaya\\Media Services\\Directories";

        public static final String WAVE_FILE_REGISTRY_PROPERTY = "VRLDir";
    }

    public static class WaveFile {
        public static final String CONTENT_TYPE = "audio/x-wav";
    }

    public static class Query {
        public static final String LIKE_OPERATOR = "%";
    }

    public static class Defaults {
        public static final Integer ROLE_TIMEOUT = 5*60;
        public static final String DATE_FORMAT = "MM/dd/yyyy";
    }

    public static class Role {

        public static final String ADD_GROUP_ROLE_NAME = "ROLE_ADD_GROUP";
        public static final String ADD_USER_ROLE_NAME = "ROLE_ADD_USER";
    }

    public class CallRecord {
        public static final String CALL_TIME_PROPERTY_NAME = "callTime";
        public static final String OUTGOING_PROPERTY_NAME = "outgoing";
        public static final String DURATION_PROPERTY_NAME = "callDuration";
        public static final String CALLED_ID_PROPERTY_NAME = "calledId";
        public static final String CALLER_ID_PROPERTY_NAME = "callerId";
    }
}
