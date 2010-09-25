package com.callcenter.reader.model;

import org.codehaus.preon.annotation.Bound;

public class WavePrivateData {

    @Bound
    private PrivateDataHeader privateDataHeader;

    @Bound
    private PrivateDataOptions privateDataOptions;

    @Bound
    private CallInformation callInformation;


    public String getAlchemyString() {
        return privateDataHeader.getAlchemyString();
    }

    public String getSizeOfPrivateData() {
        return privateDataHeader.getSizeOfPrivateData();
    }

    public String getCompanyIdentity() {
        return privateDataHeader.getCompanyIdentity();
    }

    public Boolean isInternal() {
        return privateDataOptions.isInternal();
    }
    public String getCallerId() {
        return callInformation.getCallerId();
    }

    public String getDisplayInfo() {
        return callInformation.getDisplayInfo();
    }

    public String getCalledId() {
        return callInformation.getCalledId();
    }

    public String getTargetId() {
        return callInformation.getTargetId();
    }
    public String getCallingPartyName() {
        return callInformation.getCallingPartyName();
    }

    public String getCalledPartyName() {
        return callInformation.getCalledPartyName();
    }

    public boolean isOutgoing() {
        return callInformation.isOutgoing();
    }
}