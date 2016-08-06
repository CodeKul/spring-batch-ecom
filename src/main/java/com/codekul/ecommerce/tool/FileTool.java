package com.codekul.ecommerce.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by aniruddha on 6/8/16.
 */
public class FileTool {

    @Value("${codekul.filePath}")
    private String filePath;

    @Autowired
    private Environment environment;

    public void writeFile(String name, String data) throws IOException {

        //Path path = Paths.get(filePath+name);
        Path path = Paths.get(environment.getProperty("codekul.filePath")+name);
        Files.createFile(path);
        Files.write(path,data.getBytes());
    }
}
