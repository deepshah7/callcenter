package com.callcenter.reader.mapper;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.callcenter.domain.CallRecord;
import com.callcenter.reader.model.WaveFile;
import com.callcenter.util.DateConverter;

@Component
public class WaveFileToCallRecordMapper {
    @Autowired
    DateConverter dateConverter;

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
        callRecord.setCallTime(dateConverter.getCallTime(waveFile.getRecordingTime()));
        return callRecord;
    }

    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }
}
