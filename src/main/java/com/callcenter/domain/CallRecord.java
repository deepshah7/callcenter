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

    private String callerId;

    private String displayInfo;

    private Calendar callTime;

    private String calledId;

    private String targetId;

    private String ipAddress;

    private String callingPartyName;

    private String calledPartyName;

    private Boolean outgoing;

    private Boolean internal;

    private String wavefilename;
}
