package com.callcenter.reader.model;

import org.codehaus.preon.annotation.Bound;
import org.codehaus.preon.annotation.BoundString;
import org.codehaus.preon.annotation.Purpose;

public class CallInformation {
    @Purpose("Incoming Internal– Calling Ext, Incoming External – CLI of Caller,Outgoing– Calling Ext")
    @BoundString(size = "32")
    private String callerId;

    @BoundString(size = "32")
    private String displayInfo;

    @Purpose("Number of Seconds Since Midnight 1st Jan 1901. ULONG")
    @BoundString(size = "4")
    private String dateAndTimeInSecond;

    @BoundString(size = "2")
    private String license;

    @Purpose("Incoming – No that took the Call, Outgoing – No that was called.")
    @BoundString(size = "32")
    private String calledId;

    @Purpose("DDI/Group. The number that was called")
    @BoundString(size = "32")
    private String targetId;

    @Purpose("IP address of the switch from which the recording is made")
    @BoundString(size = "4")
    private String ipAddress;

    @BoundString(size = "32")
    private String callingPartyName;

    @BoundString(size = "32")
    private String calledPartyName;

    @Bound
    private CallDirection callDirection;

    public String getCallerId() {
        return callerId.trim();
    }

    public String getDisplayInfo() {
        return displayInfo.trim();
    }

    public String getCalledId() {
        return calledId.trim();
    }

    public String getTargetId() {
        return targetId.trim();
    }
    public String getCallingPartyName() {
        return callingPartyName.trim();
    }

    public String getCalledPartyName() {
        return calledPartyName.trim();
    }

    public boolean isOutgoing() {
        return callDirection.isOutgoing();
    }
}