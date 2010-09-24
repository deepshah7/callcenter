package com.callcenter.external;

import com.callcenter.external.model.Directory;
import com.callcenter.util.Constants;
import mockit.Mocked;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
import mockit.internal.expectations.Expectation;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
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

    @Before
    public void setUp() {
        pathFinder = new WaveFileDirectoryPathFinder();
    }

    @Test
    public void shouldGetThePathOfTheWaveFileDirectoryFromTheUserPreferences(
            final @NonStrict Preferences userPreferences, final @NonStrict Directory directory) {
        new NonStrictExpectations() {
            {
                Preferences.userRoot(); returns(userPreferences);
                userPreferences.get(Constants.Registery.WAVE_FILE_REGISTERY_KEY,
                    Constants.Registery.WAVE_FILE_REGISTERY_KEY + " not found!"); returns("helloDirectory");
                new Directory("helloDirectory");
                directory.isValid(); returns(true);
            }
        };
        pathFinder.initWaveFileDirectory();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionIfDirectoryIsNotAValidWaveFileDirectory(final @NonStrict Preferences userPreferences,
                                                                                        final @NonStrict Directory directory) {
        new NonStrictExpectations() {
            {
                Preferences.userRoot(); returns(userPreferences);
                userPreferences.get(Constants.Registery.WAVE_FILE_REGISTERY_KEY,
                    Constants.Registery.WAVE_FILE_REGISTERY_KEY + " not found!"); returns("helloDirectory");
                new Directory("helloDirectory");
                directory.isValid(); returns(false);
            }
        };
        pathFinder.initWaveFileDirectory();
    }
}
