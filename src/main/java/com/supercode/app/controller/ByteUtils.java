package com.supercode.app.controller;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

public class ByteUtils {


    public static byte [] convertListToArray (List<Byte> bytes){
        Byte[] lengthBytesArray = bytes.toArray(new Byte[]{});
        return ArrayUtils.toPrimitive(lengthBytesArray);
    }

    public static int convertBytesToDecimalValue (List<Byte> bytes){
        byte[] bytesPrimitive = ByteUtils.convertListToArray(bytes);
        String imageWidthBytesHex = Hex.encodeHexString(bytesPrimitive);
        return Integer.parseInt(imageWidthBytesHex, 16);
    }

}
