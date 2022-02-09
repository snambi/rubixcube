package org.github.snambi;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.URISyntaxException;

public class RubixTest {

    @Test
    public void createCube(){
        try {

            var cube = Rubix.readFromFile("side-1.txt");

            System.out.println(cube);

        } catch (IOException | URISyntaxException | IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }
}
