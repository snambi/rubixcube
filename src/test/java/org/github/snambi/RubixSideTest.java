package org.github.snambi;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class RubixSideTest {

    @Test
    public void createSide(){

       //System.out.println(System.getProperties().get("java.class.path"));

        try {
            var side = RubixSide.readFromFile("side-1.txt");

            System.out.println(side);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
