package com.callcenter.external;

import com.callcenter.external.model.Directory;
import com.callcenter.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.prefs.Preferences;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component
public class WaveFileDirectoryPathFinder {

    private static final Logger logger = Logger.getLogger(WaveFileDirectoryPathFinder.class);

    private Directory waveFileDirectory;

    /**
     * Write Preferences information to HKCU (HKEY_CURRENT_USER),
     * HKCU\Software\JavaSoft\Prefs\wavefile.path
     */
    @PostConstruct
    public void initWaveFileDirectory() {
        final Preferences userPref = Preferences.userRoot();
        final String directoryPath = userPref.get(Constants.Registery.WAVE_FILE_REGISTERY_KEY,
                Constants.Registery.WAVE_FILE_REGISTERY_KEY + " not found!");
        waveFileDirectory = new Directory(directoryPath);
        if(waveFileDirectory.isValid()) return;

        logger.error("The wave file direcotry path is invalid: " + waveFileDirectory.getAbsolutePath());
        logger.error("MAKE USER YOU SET the registery entry HKCU\\Software\\JavaSoft\\Prefs\\wavefile.path to a valid directory path on your local system!");
        throw new IllegalStateException();
    }

    public Directory getWaveFileDirectory() {
        return waveFileDirectory;
    }
}
