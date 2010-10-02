package com.callcenter.external.model;

import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class DirectoryTest {

    @Test
    public void shouldReturnTheAbsolutePathOfTheFile() {
        new NonStrictExpectations() {
            @Mocked File file;
            {
                new File(".").getAbsolutePath(); returns("HelloAbsolutePath");
            }
        };
        assertEquals("HelloAbsolutePath", new Directory(".").getAbsolutePath());

        new Verifications() {
            @Mocked File file;
            {
                new File(".").getAbsolutePath();
            }
        };
    }

    @Test
    public void shouldReturnTrueIfPathPointsToADirectory(@NonStrict final File file) {
        new NonStrictExpectations() {
            {
                new File(".");
                file.isDirectory(); returns(true);
            }
        };
        assertTrue(new Directory(".").isValid());
    }

    @Test
    public void shouldReturnFalseIfPathDoesNotPointsToADirectory() {
        new NonStrictExpectations() {
            @Mocked File file;
            {
                new File(".").isDirectory(); returns(false);
            }
        };
        assertFalse(new Directory(".").isValid());
    }

    @Test
    public void shouldReturnAListOfFilesInTheDirectoryPointedByTheWaveFileDirectory() {
        new Expectations() {
            @Mocked
            File file1;

            @Mocked
            File file2;

            @Mocked
            com.callcenter.external.model.File file;

            final File[] value = {file1, file2};

            {
                new File("hellowavefiledirectory").listFiles();
                returns(value);
                new com.callcenter.external.model.File(file1);
                new com.callcenter.external.model.File(file2);
            }
        };
        final List<com.callcenter.external.model.File> files = new Directory("hellowavefiledirectory").list();
        assertEquals(2, files.size());
    }
}
