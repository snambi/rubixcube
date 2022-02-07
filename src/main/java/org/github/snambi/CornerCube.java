package org.github.snambi;

import java.util.ArrayList;

public class CornerCube {

    private ArrayList<Color> colors = new ArrayList<>(3);

    public CornerCube(char[] colors){
        if( colors == null ){
            throw new IllegalArgumentException("colors cannot be null");
        }

        if( colors.length != 3 ){
            throw new IllegalArgumentException("only 3 colors are allowed");
        }

        for( char c : colors ){

        }

    }

}
