package com.callcenter.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect CallRecord_Roo_Configurable {
    
    declare @type: CallRecord: @Configurable;
    
}
