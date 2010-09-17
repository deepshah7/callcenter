package com.callcenter.domain;

import java.lang.String;

privileged aspect CallRecord_Roo_JavaBean {
    
    public String CallRecord.getCaller() {
        return this.caller;
    }
    
    public void CallRecord.setCaller(String caller) {
        this.caller = caller;
    }
    
    public String CallRecord.getCallee() {
        return this.callee;
    }
    
    public void CallRecord.setCallee(String callee) {
        this.callee = callee;
    }
    
}
