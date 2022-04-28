package com.supercode.app.controller;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<Byte> readFile () throws IOException, URISyntaxException {
        URL res = getClass().getClassLoader().getResource("img.png");
        Path path = Paths.get(res.toURI());
        byte[] bytes = Files.readAllBytes(path);
        List<Byte> bytesList = new ArrayList<>();
        for (byte b: bytes){
            bytesList.add(b);
        }
        return bytesList;
    }

}
