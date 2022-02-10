package org.github.snambi;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class RubixTest {

    @Test
    public void createCube(){

        String fileName = "cube-file.txt";

        try {
            URL fileUrl = RubixUtils.class.getClassLoader().getResource(fileName);
            Path pathToFile = Path.of(fileUrl.toURI());
            String content = Files.readString(pathToFile);

            System.out.println(content + "\n======\n");

            var cube = Rubix.readFromFile(fileName);

            cube.printCubes();

            cube.printSides();
            //System.out.println(cube);

        } catch (IOException | URISyntaxException | IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }
}
