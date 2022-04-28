package com.supercode.app.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class FileParser {

    private FileReader fileReader = new FileReader();
    private Decoder decoder = new Decoder();

    public void parseFile () throws IOException, URISyntaxException {
        List<Byte> bytes = fileReader.readFile();
        decoder.decode(bytes);
    }

}
