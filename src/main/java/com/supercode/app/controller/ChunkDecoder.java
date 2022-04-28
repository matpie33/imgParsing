package com.supercode.app.controller;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class ChunkDecoder {

    public static final int NUMBER_OF_BYTES_FOR_CHUNK_LENGTH = 4;
    public static final int NUMBER_OF_BYTES_FOR_CHUNK_NAME = 4;
    public static final String IHDR = "IHDR";
    public static final String UTF_8 = "UTF-8";
    private IHDRChunkDecoder ihdrChunkDecoder = new IHDRChunkDecoder();

    public void decodeNextChunk (List<Byte> bytes, int nextByteIndex) throws UnsupportedEncodingException {
        int chunkLength = getChunkLength(bytes, nextByteIndex);
        nextByteIndex += NUMBER_OF_BYTES_FOR_CHUNK_LENGTH;

        getChunkName(bytes, nextByteIndex);

    }

    private void getChunkName(List<Byte> bytes, int nextByteIndex) throws UnsupportedEncodingException {
        List<Byte> chunkTypeBytes = bytes.subList(nextByteIndex, nextByteIndex + NUMBER_OF_BYTES_FOR_CHUNK_NAME);
        byte[] primitiveBytes = ByteUtils.convertListToArray(chunkTypeBytes);
        String chunkType = new String(primitiveBytes, UTF_8);
        if (chunkType.equals(IHDR)){
            nextByteIndex += NUMBER_OF_BYTES_FOR_CHUNK_NAME;
            ihdrChunkDecoder.decodeChunkData(bytes, nextByteIndex);
        }
        System.out.println(chunkType);
    }

    private int getChunkLength(List<Byte> bytes, int nextByteIndex) {
        List<Byte> lengthBytes = bytes.subList(nextByteIndex, nextByteIndex + NUMBER_OF_BYTES_FOR_CHUNK_LENGTH);
        int chunkLength = ByteUtils.convertBytesToDecimalValue(lengthBytes);
        System.out.println("chunk length: "+chunkLength);
        return chunkLength;
    }

}
