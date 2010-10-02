package com.callcenter.external;

import com.callcenter.external.model.Directory;
import com.callcenter.util.Constants;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.util.prefs.Preferences;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WaveFileDirectoryPathFinderTest {

    private WaveFileDirectoryPathFinder pathFinder;

    @NonStrict
    private WindowsRegistry windowsRegistry;

    @Before
    public void setUp() {
        pathFinder = new WaveFileDirectoryPathFinder();
        pathFinder.setWindowsRegistry(windowsRegistry);
    }

    @Test
    public void shouldGetThePathOfTheWaveFileDirectoryFromTheWindowsRegistry() {
        new NonStrictExpectations() {
            @NonStrict Directory waveFileDirectory;
            {
                windowsRegistry.readLocalMachineKey(Constants.Registery.WAVE_FILE_REGISTRY_PATH,
                        Constants.Registery.WAVE_FILE_REGISTRY_PROPERTY); returns("helloDirectory");
                new Directory("helloDirectory");
                waveFileDirectory.isValid(); returns(true);
            }
        };
        pathFinder.initWaveFileDirectory();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionIfDirectoryIsNotAValidWaveFileDirectory() {
        new NonStrictExpectations() {
            @NonStrict Directory waveFileDirectory;
            {
                windowsRegistry.readLocalMachineKey(Constants.Registery.WAVE_FILE_REGISTRY_PATH,
                        Constants.Registery.WAVE_FILE_REGISTRY_PROPERTY); returns("helloDirectory");
                new Directory("helloDirectory");
                waveFileDirectory.isValid(); returns(false);
            }
        };
        pathFinder.initWaveFileDirectory();
    }
}
