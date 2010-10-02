package com.callcenter.reader.mapper;

import org.springframework.stereotype.Component;

import com.callcenter.domain.CallRecord;
import com.callcenter.reader.model.WaveFile;

@Component
public class WaveFileToCallRecordMapper {
    public CallRecord mapToCallRecord(final WaveFile waveFile, final String waveFileName) {
        CallRecord callRecord = new CallRecord();
        callRecord.setOutgoing(waveFile.isOutgoing());
        callRecord.setCallerId(waveFile.getCallerId());
        callRecord.setDisplayInfo(waveFile.getDisplayInfo());
        callRecord.setCalledId(waveFile.getCalledId());
        callRecord.setTargetId(waveFile.getTargetId());
        callRecord.setCallingPartyName(waveFile.getCallingPartyName());
        callRecord.setCalledPartyName(waveFile.getCalledPartyName());
        callRecord.setInternal(waveFile.isInternal());
        callRecord.setWaveFileName(waveFileName);
        return callRecord;
    }
}
