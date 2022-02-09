package org.github.snambi;

import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Rubix Cube
 *
 */
public record Rubix( RubixSide side1, RubixSide side2, RubixSide side3,
                     RubixSide side4, RubixSide side5, RubixSide side6) {

    public static void main(String... args) {
        System.out.println("Hello World");
    }

    public static Rubix readFromFile( String filename )
            throws URISyntaxException, IOException, IllegalClassFormatException {

        List<Character> chars = RubixUtils.readFromFile(filename);

        // construct 6 sides from the characters read from the file
        if( chars.size() != 63){
            throw new IllegalClassFormatException("Cube must have 63 values. Only contains "+ chars.size());
        }

        // read the first 9 characters
        List<Character> sd1 = chars.subList(0, 8);
        RubixSide s1 = new RubixSide( sd1.get(0), sd1.get(1), sd1.get(2),
                sd1.get(3), sd1.get(4), sd1.get(5),
                sd1.get(6), sd1.get(7), sd1.get(8));


        // Read the next 4 sides
        List<Character> sd2 = new ArrayList<>();
        List<Character> sd3 = new ArrayList<>();
        List<Character> sd4 = new ArrayList<>();
        List<Character> sd5 = new ArrayList<>();
        for( int i=9; i<54 ; i++ ){

        }
        return null;
    }
}

