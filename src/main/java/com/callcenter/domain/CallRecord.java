package com.callcenter.domain;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
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

    private String waveFileName;

    public static List<CallRecord> findAllByExample(final CallRecord callRecord) {
        final Session session = (Session)entityManager().getDelegate();
        return session.createCriteria(CallRecord.class).add(Example.create(callRecord)).list();
    }

    public void nullifyEmptyValues() {
        if("".equals(getCalledId())) setCalledId(null);
        if("".equals(getCallerId())) setCallerId(null);
        if("".equals(getDisplayInfo())) setDisplayInfo(null);
        if("".equals(getTargetId())) setTargetId(null);
    }
}
