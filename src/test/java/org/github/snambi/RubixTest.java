package org.github.snambi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RubixTest {

    private static String contents;

    @BeforeAll
    public static void loadInputFiles(){

        String fileName = "cube-file.txt";

        try {
            URL fileUrl = RubixUtils.class.getClassLoader().getResource(fileName);
            Path pathToFile = Path.of(fileUrl.toURI());
            contents = Files.readString(pathToFile);
        }catch (IOException | URISyntaxException e){
            e.printStackTrace();
        }
    }


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

            System.out.println("\n======\n" +content + "\n======\n");
            System.out.println(cube);

        } catch (IOException | URISyntaxException | IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findCubesForSides(){
        try {
            Rubix rubix = Rubix.constructFromText(contents);

            List<Side> cubeSides = rubix.getCubeSides(1);
            List<AbstractCube> cubes = rubix.getCubes(1);

            System.out.println("Side 1: \n"+ rubix.getSide1() );
            for(Side c: cubeSides){
                System.out.println(c);
            }
            for(AbstractCube c: cubes){
                System.out.println(c);
            }
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }
}
