package org.github.snambi;

import java.util.ArrayList;

public class CornerCube {

    private ArrayList<Color> colors = new ArrayList<>(3);

    public CornerCube(char[] clrs){
        if( clrs == null ){
            throw new IllegalArgumentException("colors cannot be null");
        }

        if( clrs.length != 3 ){
            throw new IllegalArgumentException("only 3 colors are allowed");
        }

        for( char c : clrs ){
            if( !Color.isValid(c)  ){
                String msg = "Invalid color "+ c + " found in ["+ String.valueOf(clrs) + "]";
                System.out.println(msg);
                throw new IllegalArgumentException(msg);
            }

            // construct colors
            colors.add( Color.get(c));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for( Color c : colors ){
            sb.append(c.name());
        }
        sb.append("]");

        return sb.toString();
    }
}
