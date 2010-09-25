package com.callcenter.reader.model;

import org.codehaus.preon.annotation.BoundString;
import org.codehaus.preon.annotation.Purpose;

public class WaveHeader {
    @BoundString(size = "4", match = "RIFF")
    private String RIFFHeader;

    @BoundString(size = "4")
    private String chunkHeaderSize;

    @BoundString(size = "4", match="WAVE")
    private String RIFFType;

    @Purpose("The space matter after fmt.")
    @BoundString(size = "4", match="fmt ")
    private String fmtChunkId;

    @BoundString(size = "20")
    private String fmtChunkData;

    public String getRIFFCChunkId() {
        return RIFFHeader;
    }

    public String getRIFFType() {
        return RIFFType;
    }

    public String getFmtChunkId() {
        return fmtChunkId;
    }
}