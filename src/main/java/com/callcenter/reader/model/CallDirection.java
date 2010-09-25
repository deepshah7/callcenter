package com.callcenter.reader.model;

import org.codehaus.preon.annotation.Bound;
import org.codehaus.preon.annotation.BoundString;
import org.codehaus.preon.annotation.Purpose;

@Purpose("Flags (ulong) (bit-0 - 0-Incoming\\1-Outgoing) ")
public class CallDirection {

    @BoundString(size = "3")
    private String currentlyNothing;

    @Bound
    private boolean outgoing;

    public boolean isOutgoing() {
        return outgoing;
    }
}