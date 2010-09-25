package com.callcenter.reader.model;

import org.codehaus.preon.annotation.BoundString;

public class PrivateDataHeader {
    @BoundString(size = "4")
    private String alchemyString;

    @BoundString(size = "4")
    private String sizeOfPrivateData;

    @BoundString(size = "28")
    private String companyIdentity;

    public String getAlchemyString() {
        return alchemyString;
    }

    public String getSizeOfPrivateData() {
        return sizeOfPrivateData;
    }

    public String getCompanyIdentity() {
        return companyIdentity;
    }
}