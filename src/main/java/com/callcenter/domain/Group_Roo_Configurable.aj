package com.callcenter.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Group_Roo_Configurable {
    
    declare @type: Group: @Configurable;
    
}
