package org.github.snambi;

import java.util.ArrayList;

public abstract class AbstractCube {

    protected int size;
    private Color side1;
    private Color side2;
    private Color side3;

    public AbstractCube(int size, char[] clrs){

        validateInputs(size, clrs);

        // set size
        this.size = size;

        // set the colors
        if( size >= 1 ) {
            side1 = Color.get(clrs[0]);
        }
        if(size >=2 ){
            side2 = Color.get(clrs[1]);
        }
        if(size == 3){
            side3 = Color.get(clrs[2]);
        }
    }

    public void validateInputs(int size, char[] clrs ){
        if(size <1 || size > 3 ){
            throw new IllegalArgumentException("size cannot be less than 1 or greater 3");
        }

        if( clrs == null ){
            throw new IllegalArgumentException("colors cannot be null");
        }

        if( clrs.length != size ){
            throw new IllegalArgumentException("only "+ size +" colors are allowed");
        }

        for( char c : clrs ) {
            if (!Color.isValid(c)) {
                String msg = "Invalid color " + c + " found in [" + String.valueOf(clrs) + "]";
                System.out.println(msg);
                throw new IllegalArgumentException(msg);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Color getSide1() {
        return side1;
    }

    public void setSide1(Color s) {
        this.side1 = s;
    }

    public Color getSide2() {
        return side2;
    }

    public void setSide2(Color s) {
        this.side2 = s;
    }

    public Color getSide3() {
        return side3;
    }

    public void setSide3(Color s) {
        this.side3 = s;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if( size >= 1){
            sb.append(side1);
        }
        if( size >= 2){
            sb.append(side2);
        }
        if( size == 3){
            sb.append(side3);
        }
        sb.append("]");

        return sb.toString();
    }

}
