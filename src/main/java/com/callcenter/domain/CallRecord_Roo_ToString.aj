package com.callcenter.domain;

import java.lang.String;

privileged aspect CallRecord_Roo_ToString {
    
    public String CallRecord.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
