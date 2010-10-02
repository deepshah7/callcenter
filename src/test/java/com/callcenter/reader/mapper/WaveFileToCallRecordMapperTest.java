package com.callcenter.reader.mapper;

import com.callcenter.domain.CallRecord;
import com.callcenter.reader.model.WaveFile;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WaveFileToCallRecordMapperTest {

    @Test
    public void shouldCreateANewCallRecordAndMapItWithProperties(@NonStrict final WaveFile waveFile) {
        new NonStrictExpectations() {
            {
                waveFile.isOutgoing(); returns(true);
                waveFile.getCallerId(); returns("HelloCaller");
                waveFile.getDisplayInfo(); returns("HelloDisplay");
                waveFile.getCalledId(); returns("HelloCalled");
                waveFile.getTargetId(); returns("HelloTarget");
                waveFile.getCallingPartyName(); returns("HelloCallingParty");
                waveFile.getCalledPartyName(); returns("HelloCalledParty");
                waveFile.isInternal(); returns(true);
            }

        };
        final WaveFileToCallRecordMapper mapper = new WaveFileToCallRecordMapper();
        final CallRecord callRecord = mapper.mapToCallRecord(waveFile, "HelloFileName");

        assertEquals("HelloFileName", callRecord.getWaveFileName());
        assertEquals("HelloCaller", callRecord.getCallerId());
        assertEquals("HelloDisplay", callRecord.getDisplayInfo());
        assertEquals("HelloCalled", callRecord.getCalledId());
        assertEquals("HelloTarget", callRecord.getTargetId());
        assertEquals("HelloCallingParty", callRecord.getCallingPartyName());
        assertEquals("HelloCalledParty", callRecord.getCalledPartyName());
        assertTrue(callRecord.getOutgoing());
        assertTrue(callRecord.getInternal());
    }
}
