package com.callcenter.external.model;

import com.callcenter.wavefile.processor.WaveFileNamingStrategy;
import mockit.Mocked;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class FileTest {

    @Test
    public void shouldRenameTheFileInTheBeforeProcessPhase(@Mocked final java.io.File file) {
        final File waveFile = new File(file);

        new NonStrictExpectations() {

            @NonStrict WaveFileNamingStrategy waveFileNamingStrategy;
            {
                file.getName(); returns("helloFile");
                waveFileNamingStrategy.generateNewFileName("helloFile"); returns("newHelloFile");
                file.renameTo(new java.io.File("newHelloFile"));
            }
        };

        waveFile.beforeProcess();

        new Verifications() {
            {
                file.renameTo(new java.io.File("newHelloFile"));
            }
        };
    }
}
