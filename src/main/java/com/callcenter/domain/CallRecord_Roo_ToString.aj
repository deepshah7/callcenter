package com.callcenter.domain;

import java.lang.String;

privileged aspect CallRecord_Roo_ToString {
    
    public String CallRecord.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("CallerId: ").append(getCallerId()).append(", ");
        sb.append("DisplayInfo: ").append(getDisplayInfo()).append(", ");
        sb.append("DateAndTimeInSecond: ").append(getDateAndTimeInSecond()).append(", ");
        sb.append("CalledId: ").append(getCalledId()).append(", ");
        sb.append("TargetId: ").append(getTargetId()).append(", ");
        sb.append("IpAddress: ").append(getIpAddress()).append(", ");
        sb.append("CallingPartyName: ").append(getCallingPartyName()).append(", ");
        sb.append("CalledPartyName: ").append(getCalledPartyName()).append(", ");
        sb.append("Outgoing: ").append(getOutgoing());
        return sb.toString();
    }
    
}
