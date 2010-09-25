package com.callcenter.domain;

import java.util.Calendar;

import javax.persistence.Entity;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class CallRecord {

    //"Incoming Internal– Calling Ext, Incoming External – CLI of Caller,Outgoing– Calling Ext"
    private String callerId;

    private String displayInfo;

    //"Number of Seconds Since Midnight 1st Jan 1901. ULONG".
    // Need to decide the format of storage. not sure of its usage.
    private Calendar callTime;

    //"Incoming – No that took the Call, Outgoing – No that was called."
    private String calledId;

    //"DDI/Group. The number that was called"
    private String targetId;

    //"IP address of the switch from which the recording is made". Not sure if this needs to be used.
    private String ipAddress;

    private String callingPartyName;

    private String calledPartyName;

    // Whether this is a outgoing or incoming call
    private Boolean outgoing;

    private Boolean internal;
}
