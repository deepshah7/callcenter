package com.callcenter.external;

import com.callcenter.external.model.Directory;
import com.callcenter.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component
public class WaveFileDirectoryPathFinder {

    private static final Logger logger = Logger.getLogger(WaveFileDirectoryPathFinder.class);

    private Directory waveFileDirectory;

    @Autowired
    private WindowsRegistry windowsRegistry;

    @PostConstruct
    public void initWaveFileDirectory() {
        final String directoryPath = windowsRegistry.readLocalMachineKey(Constants.Registery.WAVE_FILE_REGISTRY_PATH,
                Constants.Registery.WAVE_FILE_REGISTRY_PROPERTY);

        waveFileDirectory = new Directory(directoryPath);
        if(waveFileDirectory.isValid()) return;

        logger.error("The wave file direcotry path is invalid: " + waveFileDirectory.getAbsolutePath());
        logger.error("MAKE USER YOU SET the registery entry HKLM\\" + Constants.Registery.WAVE_FILE_REGISTRY_PATH + "\\"
                + Constants.Registery.WAVE_FILE_REGISTRY_PROPERTY + " to a valid directory path on your local system!");
        throw new IllegalStateException();
    }

    public Directory getWaveFileDirectory() {
        return waveFileDirectory;
    }

    public void setWindowsRegistry(final WindowsRegistry windowsRegistry) {
        this.windowsRegistry = windowsRegistry;
    }
}
