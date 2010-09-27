package com.callcenter.reader;

import com.callcenter.external.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.callcenter.domain.CallRecord;
import com.callcenter.reader.mapper.WaveFileToCallRecordMapper;
import com.callcenter.reader.model.WaveFile;
import org.codehaus.preon.Codec;
import org.codehaus.preon.Codecs;
import org.codehaus.preon.DecodingException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
@Component
public class WaveFileReader {

    private static final Logger logger = Logger.getLogger(WaveFileReader.class);

    @Autowired
    private WaveFileToCallRecordMapper waveFileToCallRecordMapper;

    public void read(final File file) {
        try {
            Codec<WaveFile> codec = Codecs.create(WaveFile.class);
            WaveFile waveFile = Codecs.decode(codec, file.getFileToProcess());
            CallRecord callRecord = waveFileToCallRecordMapper.mapToCallRecord(waveFile, file.getName());
            callRecord.persist();
            codec = null;
            System.gc();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (DecodingException e) {
            logger.error(e.getMessage(), e);
        }

    }
}
