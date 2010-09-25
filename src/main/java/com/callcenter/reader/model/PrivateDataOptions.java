package com.callcenter.reader.model;

import org.codehaus.preon.annotation.BoundString;

public class PrivateDataOptions {
    @BoundString(size = "1")
    private String option0;

    @BoundString(size = "1")
    private String option1;

    @BoundString(size = "2")
    private String option2And3;

    public Boolean isInternal() {
        return option1.equals("I");
    }

}