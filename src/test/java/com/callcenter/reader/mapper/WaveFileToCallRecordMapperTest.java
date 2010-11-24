package com.callcenter.reader.mapper;

import java.util.Calendar;

import com.callcenter.domain.CallRecord;
import com.callcenter.reader.model.WaveFile;
import com.callcenter.util.DateConverter;
import mockit.Mocked;
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
    @Mocked
    private DateConverter dateConverter;

    @Test
    public void shouldCreateANewCallRecordAndMapItWithProperties(@NonStrict final WaveFile waveFile,
                                                                 @NonStrict final CallRecord callRecord) {
        final byte[] expectedTime = {(byte) 0xc9};
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
                waveFile.getRecordingTime();
                returns(expectedTime);
                dateConverter.getCallTime(expectedTime);
                                returns(Calendar.getInstance());
            }

        };
        final WaveFileToCallRecordMapper mapper = new WaveFileToCallRecordMapper();
        mapper.setDateConverter(dateConverter);
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
