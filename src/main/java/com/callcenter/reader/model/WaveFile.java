package com.callcenter.reader.model;

import java.util.Calendar;

import org.codehaus.preon.annotation.Bound;

public class WaveFile {

    @Bound
    private WaveHeader waveHeader;

    @Bound
    private WavePrivateData privateData;


    public String getRIFFCChunkId() {
        return waveHeader.getRIFFCChunkId();
    }

    public String getRIFFType() {
        return waveHeader.getRIFFType();
    }

    public String getFmtChunkId() {
        return waveHeader.getFmtChunkId();
    }

    public String getAlchemyString() {
        return privateData.getAlchemyString();
    }

    public String getSizeOfPrivateData() {
        return privateData.getSizeOfPrivateData();
    }

    public String getCompanyIdentity() {
        return privateData.getCompanyIdentity();
    }

    public Boolean isInternal() {
        return privateData.isInternal();
    }

    public String getCallerId() {
        return privateData.getCallerId();
    }

    public String getDisplayInfo() {
        return privateData.getDisplayInfo();
    }

    public String getCalledId() {
        return privateData.getCalledId();
    }

    public String getTargetId() {
        return privateData.getTargetId();
    }

    public String getCallingPartyName() {
        return privateData.getCallingPartyName();
    }

    public String getCalledPartyName() {
        return privateData.getCalledPartyName();
    }

    public boolean isOutgoing() {
        return privateData.isOutgoing();
    }

    public byte[] getRecordingTime() {
        return privateData.getRecordingTime();
    }


}