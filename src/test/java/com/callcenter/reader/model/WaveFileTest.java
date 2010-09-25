package com.callcenter.reader.model;

import java.io.File;
import java.io.IOException;

import org.codehaus.preon.Codec;
import org.codehaus.preon.Codecs;
import org.codehaus.preon.DecodingException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WaveFileTest {
    @Test
    public void shouldReadTheFileHeaderForTest1WaveFile() throws DecodingException, IOException {
        testWaveParsing("test1.wav", true,"2001", "Extn2001", "2002", "2002", "Extn2001", "Extn2002");
    }

    @Test
    public void shouldReadTheFileHeaderForTest2WaveFile() throws DecodingException, IOException {
        testWaveParsing("test2.wav", true,"2001", "Extn2001", "2002", "2002", "Extn2001", "Extn2002");
    }

    @Test
    public void shouldReadTheFileHeaderForTest3WaveFile() throws DecodingException, IOException {
        testWaveParsing("test3.wav", true,"2009", "Extn2009", "2001", "2001", "Extn2009", "Extn2001");
    }

    private void testWaveParsing(String waveFileName, boolean isInterenal,String callerId, String displayInfo, String calledId, String targetId, String callingPartyName, String calledPartyName) throws IOException, DecodingException {
        Codec<WaveFile> codec = Codecs.create(WaveFile.class);
        File file = new File(WaveFileTest.class.getClassLoader().getResource(waveFileName).getFile());
        WaveFile waveFile = Codecs.decode(codec, file);
        assertThat(waveFile.getRIFFCChunkId(),is("RIFF"));
        assertThat(waveFile.getRIFFType(),is("WAVE"));
        assertThat(waveFile.getFmtChunkId().trim(),is("fmt"));
        assertThat(waveFile.getAlchemyString(),is("ALCH"));
        assertThat(waveFile.getCompanyIdentity().trim(),is("Avaya"));
        assertThat(waveFile.isInternal(),is(isInterenal));
        assertThat(waveFile.getCallerId(),is(callerId));
        assertThat(waveFile.getDisplayInfo(),is(displayInfo));
        assertThat(waveFile.getCalledId(),is(calledId));
        assertThat(waveFile.getTargetId(),is(targetId));
        assertThat(waveFile.getCallingPartyName(),is(callingPartyName));
        assertThat(waveFile.getCalledPartyName(),is(calledPartyName));
        assertThat(waveFile.isOutgoing(),is(false));
    }
}
