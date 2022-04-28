package com.supercode.app.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderDecoder {

    private List<String> header = new ArrayList<>();

    private static final String FIRST_BYTE = "89";
    private static final String BYTE_P = "50";
    private static final String BYTE_N = "4E";
    private static final String BYTE_G = "47";

    private static final String DOS_STYLE_LINE_ENDING_1 = "0D";
    private static final String DOS_STYLE_LINE_ENDING_2 = "0A";
    private static final String STOPPING_BYTE = "1A";
    private static final String LINE_ENDING = "0A";



    public HeaderDecoder(){
        header.add(FIRST_BYTE);
        header.add(BYTE_P);
        header.add(BYTE_N);
        header.add(BYTE_G);
        header.add(DOS_STYLE_LINE_ENDING_1);
        header.add(DOS_STYLE_LINE_ENDING_2);
        header.add(STOPPING_BYTE);
        header.add(LINE_ENDING);

    }

    public void decode (List<Byte> bytesAsHex) throws UnsupportedEncodingException {
        List<Byte> characters = bytesAsHex.subList(0, 8);
        List<String> first8BytesAsHex = characters.stream().map(aByte -> String.format("%02X", aByte)).collect(Collectors.toList());

        if (first8BytesAsHex.equals(header)){
            System.out.println("match");
        }
        else{
            System.out.println("error!");
        }

    }

}
