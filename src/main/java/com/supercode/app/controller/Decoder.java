package com.supercode.app.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class Decoder {

    private HeaderDecoder headerDecoder = new HeaderDecoder();
    private ChunkDecoder chunkDecoder = new ChunkDecoder();

    public void decode (List<Byte> bytes) throws UnsupportedEncodingException {
        headerDecoder.decode(bytes);
        chunkDecoder.decodeNextChunk(bytes, 8);
    }

}
