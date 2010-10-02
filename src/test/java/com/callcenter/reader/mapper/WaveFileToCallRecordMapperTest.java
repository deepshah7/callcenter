package com.callcenter.reader.mapper;

import com.callcenter.domain.CallRecord;
import com.callcenter.reader.model.WaveFile;
import mockit.NonStrict;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 *
 * @author deep
 */
public class WaveFileToCallRecordMapperTest {

    @Test
    public void shouldCreateANewCallRecordAndMapItWithProperties(@NonStrict final WaveFile waveFile,
                                                                 @NonStrict final CallRecord callRecord) {
        new NonStrictExpectations() {

            {
                new CallRecord();
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
        mapper.mapToCallRecord(waveFile, "HelloFileName");

        new Verifications() {
            {
                callRecord.setOutgoing(true);
                callRecord.setCallerId("HelloCaller");
                callRecord.setDisplayInfo("HelloDisplay");
                callRecord.setCalledId("HelloCalled");
                callRecord.setTargetId("HelloTarget");
                callRecord.setCallingPartyName("HelloCallingParty");
                callRecord.setCalledPartyName("HelloCalledParty");
                callRecord.setInternal(true);
            }
        };
    }
}
