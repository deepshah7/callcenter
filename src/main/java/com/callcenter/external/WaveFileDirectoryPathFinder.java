package com.callcenter.external;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.prefs.Preferences;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component
public class WaveFileDirectoryPathFinder implements InitializingBean {

    private static final Logger logger = Logger.getLogger(WaveFileDirectoryPathFinder.class);

    private String waveFileDirectory;

    @Override
    public void afterPropertiesSet() throws Exception {
        final String PREF_KEY = "wavefile.path";
        //
        // Write Preferences information to HKCU (HKEY_CURRENT_USER),
        // HKCU\Software\JavaSoft\Prefs\wavefile.path
        //
        final Preferences userPref = Preferences.userRoot();
        waveFileDirectory = userPref.get(PREF_KEY, PREF_KEY + " not found!");
        logger.info("The wave file direcotry path: " + waveFileDirectory);
    }

    public String getWaveFileDirectory() {
        return waveFileDirectory;
    }
}
