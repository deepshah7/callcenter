package com.callcenter.external.model;

import com.callcenter.wavefile.processor.WaveFileNamingStrategy;
import mockit.Mocked;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import org.junit.Test;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class FileTest {

    @NonStrict WaveFileNamingStrategy waveFileNamingStrategy;

    @Mocked java.io.File file;

    @Test
    public void shouldRenameTheFileInTheBeforeProcessPhase() {

        new NonStrictExpectations() {
            {
                file.getName(); returns("helloFile");
                waveFileNamingStrategy.generateNewFileName("helloFile"); returns("newHelloFile");
            }
        };

        final File waveFile = new File(file);
        waveFile.beforeProcess(waveFileNamingStrategy);

        new Verifications() {
            {
                new java.io.File("newHelloFile");
                file.renameTo((java.io.File)any);
            }
        };
    }
}
