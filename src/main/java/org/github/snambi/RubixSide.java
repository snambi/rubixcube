package org.github.snambi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Each side of the Rubix cube is made up of 9 indiviuals sides from the sub-cubes.
 *
 * It involves, 4 sides from corner cubes, 4 from edge cubes and 1 from center cube.
 */
public record RubixSide( char cornerSide1, char cornerSide2, char cornerSide3, char cornerSide4,
                         char edgeSide1, char edgeSide2, char edgeSide3, char edgeSide4,
                         char centerSide) {


    public static RubixSide readFile( final String fileName ) throws IOException, URISyntaxException {

        ArrayList<Character> chars = new ArrayList<>();

        if(Objects.nonNull(fileName)) {
            URL fileUrl = RubixSide.class.getClassLoader().getResource(fileName);

            if( Objects.nonNull(fileUrl)){
                Path pathToFile = Path.of(fileUrl.toURI());
                String content = Files.readString(pathToFile);

                String[] arr = content.split("\n");

                for ( String a : arr) {
                    //System.out.println(a);
                    String[] row = a.split(" ");

                    for( String r : row){
                        if( r.length() == 1 ){
                            chars.add( r.charAt(0) );
                        }
                    }
                }
            }
        }

        RubixSide side = new RubixSide(chars.get(0), chars.get(1), chars.get(2),
                                        chars.get(3), chars.get(4), chars.get(5),
                                        chars.get(6), chars.get(7), chars.get(8) );

        return side;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append( this.cornerSide1());
        sb.append(" ");
        sb.append( this.edgeSide1());
        sb.append(" ");
        sb.append( this.cornerSide2());
        sb.append("\n");

        sb.append( this.edgeSide2());
        sb.append(" ");
        sb.append( this.centerSide());
        sb.append(" ");
        sb.append( this.edgeSide3());
        sb.append("\n");

        sb.append( this.cornerSide3());
        sb.append(" ");
        sb.append( this.edgeSide3());
        sb.append(" ");
        sb.append( this.cornerSide4());
        sb.append("\n");

        return sb.toString();
    }
}
