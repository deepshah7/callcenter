package com.callcenter.schedular;

import com.callcenter.external.WaveFileDirectoryPathFinder;
import com.callcenter.external.model.Directory;
import com.callcenter.reader.WaveFileReader;
import mockit.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class CallRecordTaskSchedularTest {

    @Mocked
    private WaveFileDirectoryPathFinder waveFileDirectoryPathFinder;

    @Mocked
    private WaveFileReader waveFileReader;

    private CallRecordTaskSchedular schedular;


    @Before
    public void setUp() {
        schedular = new CallRecordTaskSchedular();
        schedular.setWaveFileDirectoryPathFinder(waveFileDirectoryPathFinder);
    }

    @Test
    public void shouldGetTheDirectoryPathAndProcessTheFileIfAnyFileIsAvailable(
            @NonStrict final Directory waveFileDirectory, @NonStrict final File file1, @NonStrict final File file2) {
        final List<File> files = new ArrayList<File>();
        files.add(file1);
        files.add(file2);
        new NonStrictExpectations() {
            {
                waveFileDirectoryPathFinder.getWaveFileDirectory();
                returns(waveFileDirectory);
                waveFileDirectory.list();
                returns(files);
            }
        };

        schedular.checkIfCallRecordAvailable();

        new Verifications() {
            {
            }
        };
    }

    @Test
    public void shouldDeleteTheFileAfterReadingIt(
            @NonStrict final Directory waveFileDirectory, @NonStrict final File file1) {
        final List<File> files = new ArrayList<File>();
        files.add(file1);
        new NonStrictExpectations() {
            {
                waveFileDirectoryPathFinder.getWaveFileDirectory();
                returns(waveFileDirectory);
                waveFileDirectory.list();
                returns(files);
            }
        };

        schedular.checkIfCallRecordAvailable();

        new VerificationsInOrder() {
            {
                file1.delete();
            }
        };
    }
}
