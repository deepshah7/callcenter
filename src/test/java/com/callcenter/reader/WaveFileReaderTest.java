package com.callcenter.reader;

import com.callcenter.domain.CallRecord;
import com.callcenter.external.model.File;
import com.callcenter.reader.mapper.WaveFileToCallRecordMapper;
import com.callcenter.reader.model.WaveFile;
import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrict;
import mockit.Verifications;
import org.codehaus.preon.Codec;
import org.codehaus.preon.Codecs;
import org.codehaus.preon.DecodingException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WaveFileReaderTest {

    @Mocked(inverse = true, methods = "<clinit>")
    Codecs codecs = null;

    @Test
    public void shouldCreateANewCallRecordForTheWaveFile(
                    @NonStrict final File waveFile,
                    @NonStrict final WaveFileToCallRecordMapper mapper,
                    @NonStrict final CallRecord callRecord)
            throws DecodingException, IOException {
        new Expectations() {
            @NonStrict WaveFile waveFileObj;
            @Mocked Codec<WaveFile> codec;
            @Mocked java.io.File file;
            {
                Codecs.create(WaveFile.class); returns(codec);
                waveFile.getFileToProcess(); returns(file);
                Codecs.decode(codec, file); returns(waveFileObj);
                waveFile.getName(); returns("helloWaveFile");
                mapper.mapToCallRecord(waveFileObj, "helloWaveFile"); returns(callRecord);
            }
        };

        final WaveFileReader waveFileReader = new WaveFileReader();
        waveFileReader.setWaveFileToCallRecordMapper(mapper);
        waveFileReader.read(waveFile);

        new Verifications() {
            {
                callRecord.persist();
            }
        };
    }
}
