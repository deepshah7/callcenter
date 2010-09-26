package com.callcenter.domain;

import java.lang.Boolean;
import java.lang.String;
import java.util.Calendar;

privileged aspect CallRecord_Roo_JavaBean {
    
    public String CallRecord.getCallerId() {
        return this.callerId;
    }
    
    public void CallRecord.setCallerId(String callerId) {
        this.callerId = callerId;
    }
    
    public String CallRecord.getDisplayInfo() {
        return this.displayInfo;
    }
    
    public void CallRecord.setDisplayInfo(String displayInfo) {
        this.displayInfo = displayInfo;
    }
    
    public Calendar CallRecord.getCallTime() {
        return this.callTime;
    }
    
    public void CallRecord.setCallTime(Calendar callTime) {
        this.callTime = callTime;
    }
    
    public String CallRecord.getCalledId() {
        return this.calledId;
    }
    
    public void CallRecord.setCalledId(String calledId) {
        this.calledId = calledId;
    }
    
    public String CallRecord.getTargetId() {
        return this.targetId;
    }
    
    public void CallRecord.setTargetId(String targetId) {
        this.targetId = targetId;
    }
    
    public String CallRecord.getIpAddress() {
        return this.ipAddress;
    }
    
    public void CallRecord.setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public String CallRecord.getCallingPartyName() {
        return this.callingPartyName;
    }
    
    public void CallRecord.setCallingPartyName(String callingPartyName) {
        this.callingPartyName = callingPartyName;
    }
    
    public String CallRecord.getCalledPartyName() {
        return this.calledPartyName;
    }
    
    public void CallRecord.setCalledPartyName(String calledPartyName) {
        this.calledPartyName = calledPartyName;
    }
    
    public Boolean CallRecord.getOutgoing() {
        return this.outgoing;
    }
    
    public void CallRecord.setOutgoing(Boolean outgoing) {
        this.outgoing = outgoing;
    }
    
    public Boolean CallRecord.getInternal() {
        return this.internal;
    }
    
    public void CallRecord.setInternal(Boolean internal) {
        this.internal = internal;
    }
    
    public String CallRecord.getWavefilename() {
        return this.wavefilename;
    }
    
    public void CallRecord.setWavefilename(String wavefilename) {
        this.wavefilename = wavefilename;
    }
    
}
