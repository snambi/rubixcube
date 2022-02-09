package org.github.snambi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RubixUtils {

    public static List<Character> readFromFile(String fileName ) throws URISyntaxException, IOException {

        List<Character> chars = new ArrayList<>();

        if(Objects.nonNull(fileName)) {
            URL fileUrl = RubixUtils.class.getClassLoader().getResource(fileName);

            if( Objects.nonNull(fileUrl)){

                Path pathToFile = Path.of(fileUrl.toURI());
                String content = Files.readString(pathToFile);

                String[] arr = content.split("\n");

                for ( String a : arr) {
                    String[] row = a.split(" ");

                    for( String r : row){
                        if( r.length() == 1 ){
                            chars.add( r.charAt(0) );
                        }
                    }
                }
            }
        }

        return chars;
    }
}
