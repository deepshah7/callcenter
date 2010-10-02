package com.callcenter.external;

import com.callcenter.util.ApplicationProperties;
import com.callcenter.util.Constants;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WindowsRegistryTest {

    private WindowsRegistry windowsRegistry;

    @Before
    public void setUp() {
        windowsRegistry = new WindowsRegistry();
    }

    @Test
    public void shouldReadTheCurrentVersionValueOfIE() {
        assertTrue(
                windowsRegistry.readLocalMachineKey("SOFTWARE\\Microsoft\\Internet Explorer", "Version").startsWith("8.0"));
    }

    @Test
    public void shouldReadThePathOfWaveFileFromRegistry() {
        assertEquals(ApplicationProperties.getInstance().get("app.waveFile.read.default.dir"),
                windowsRegistry.readCurrentUserKey(Constants.Registery.WAVE_FILE_REGISTRY_PATH,
                        Constants.Registery.WAVE_FILE_REGISTRY_PROPERTY));
    }
}
