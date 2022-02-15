package org.github.snambi;

import java.util.ArrayList;

public abstract class AbstractCube {

    protected int size;
    private Side side1;
    private Side side2;
    private Side side3;
    private int x;
    private int y;
    private int z;
    protected String name;

    public AbstractCube(int size, char[] clrs){
        this(size, clrs, 0,0,0);
    }

    public AbstractCube(int size, char[] clrs, int x, int y, int z){

        validateInputs(size, clrs);

        // set size
        this.size = size;

        // set the colors
        if( size >= 1 ) {
            side1 = new Side( Color.get(clrs[0]) );
            side1.setCube(this);
        }
        if(size >=2 ){
            side2 = new Side( Color.get(clrs[1]) );
            side2.setCube(this);
        }
        if(size == 3){
            side3 = new Side( Color.get(clrs[2]) );
            side3.setCube(this);
        }

        if( ( x >=0 && x < 3 ) &&
                (y >= 0 && y < 3) &&
                (z >= 0 && z < 3 )){
            this.x = x;
            this.y = y;
            this.z = z;
        }else{
            throw new IllegalArgumentException("Coordinates must be 0,1 or 2. values x="+x+", y="+y+", z="+z);
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

    public Side getSide1() {
        return side1;
    }

    public void setSide1(Side s) {
        this.side1 = s;
    }

    public Side getSide2() {
        return side2;
    }

    public void setSide2(Side s) {
        this.side2 = s;
    }

    public Side getSide3() {
        return side3;
    }

    public void setSide3(Side s) {
        this.side3 = s;
    }

    public String getName() {
        return name;
    }

    public void setCoordinates(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int[] getCoordinates(){
        int[] coordinates = { this.x, this.y, this.z };
        return coordinates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for( int c: getCoordinates()){
            sb.append(c);
            sb.append(" ");
        }
        sb.append("[");
        if( size >= 1){
            sb.append(side1.getColor().name());
        }
        if( size >= 2){
            sb.append(side2.getColor().name());
        }
        if( size == 3){
            sb.append(side3.getColor().name());
        }
        sb.append("]");

        return sb.toString();
    }
}
