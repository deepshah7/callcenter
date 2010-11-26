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
}
