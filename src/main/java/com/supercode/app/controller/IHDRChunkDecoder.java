package com.supercode.app.controller;

import java.util.List;

public class IHDRChunkDecoder {

    public static final int NUMBER_OF_BYTES_FOR_IMAGE_WIDTH = 4;
    public static final int NUMBER_OF_BYTES_FOR_IMAGE_HEIGHT = 4;
    public static final int NUMBER_OF_BYTES_FOR_BIT_DEPTH = 1;
    public static final int NUMBER_OF_BYTES_FOR_COLOR_TYPE = 1;
    public static final int NUMBER_OF_BYTES_FOR_COMPRESSION_METHOD = 1;
    public static final int NUMBER_OF_BYTES_FOR_FILTER_METHOD = 1;
    public static final int NUMBER_OF_BYTES_FOR_INTERLACE_METHOD = 1;

    public void decodeChunkData (List<Byte> bytes, int nextByteIndex){
        int imageWidth = getValue(bytes, nextByteIndex, NUMBER_OF_BYTES_FOR_IMAGE_WIDTH);
        nextByteIndex += NUMBER_OF_BYTES_FOR_IMAGE_WIDTH;
        int imageHeight = getValue(bytes, nextByteIndex, NUMBER_OF_BYTES_FOR_IMAGE_HEIGHT);
        nextByteIndex += NUMBER_OF_BYTES_FOR_IMAGE_HEIGHT;
        int bitDepth = getValue(bytes, nextByteIndex, NUMBER_OF_BYTES_FOR_BIT_DEPTH);
        nextByteIndex += NUMBER_OF_BYTES_FOR_BIT_DEPTH;
        int colorType = getValue(bytes, nextByteIndex, NUMBER_OF_BYTES_FOR_COLOR_TYPE);
        nextByteIndex += NUMBER_OF_BYTES_FOR_COLOR_TYPE;
        int compressionMethod = getValue(bytes, nextByteIndex, NUMBER_OF_BYTES_FOR_COMPRESSION_METHOD);
        nextByteIndex += NUMBER_OF_BYTES_FOR_COMPRESSION_METHOD;
        int filterMethod = getValue(bytes, nextByteIndex, NUMBER_OF_BYTES_FOR_FILTER_METHOD);
        nextByteIndex += NUMBER_OF_BYTES_FOR_FILTER_METHOD;
        int interlaceMethod = getValue(bytes, nextByteIndex, NUMBER_OF_BYTES_FOR_INTERLACE_METHOD);
        nextByteIndex += NUMBER_OF_BYTES_FOR_INTERLACE_METHOD;
        System.out.println("image width: "+imageWidth);
        System.out.println("image height: "+imageHeight);
        System.out.println("bit depth: "+bitDepth);
        System.out.println("color type: "+colorType);
        System.out.println("compressionMethod: "+compressionMethod);
        System.out.println("filterMethod: "+filterMethod);
        System.out.println("interlaceMethod: "+interlaceMethod);
    }

    private int getValue(List<Byte> bytes, int nextByteIndex, int numberOfBytesForImageWidth) {
        List<Byte> imageWidthBytes = bytes.subList(nextByteIndex, nextByteIndex + numberOfBytesForImageWidth);
        int imageWidth = ByteUtils.convertBytesToDecimalValue(imageWidthBytes);
        return imageWidth;
    }

}
