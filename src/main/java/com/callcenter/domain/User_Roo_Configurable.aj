package com.callcenter.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect User_Roo_Configurable {
    
    declare @type: User: @Configurable;
    
}
