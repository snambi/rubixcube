package org.github.snambi;

import java.util.ArrayList;

public abstract class AbstractCube {

    protected int size;
    protected ArrayList<Color> colors = new ArrayList<>(3);

    public AbstractCube(int size, char[] clrs){

        if(size <1 || size > 3 ){
            throw new IllegalArgumentException("size cannot be less than 1 or greater 3");
        }

        this.size = size;

        if( clrs == null ){
            throw new IllegalArgumentException("colors cannot be null");
        }

        if( clrs.length != this.size ){
            throw new IllegalArgumentException("only "+ this.size +" colors are allowed");
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
