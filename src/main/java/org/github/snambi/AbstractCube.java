package org.github.snambi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractCube {

    protected int size;
    private Side side1;
    private Side side2;
    private Side side3;
    private int x;
    private int y;
    private int z;
    protected String name;

    public AbstractCube(int size, char[] clrs, String name){
        this(size, clrs, name, 0,0,0);
    }

    public AbstractCube(int size, char[] clrs, String name, int[] coordinates){
        this(size, clrs, name, coordinates[0], coordinates[1], coordinates[2] );
    }

    public AbstractCube(int size, char[] clrs, String name,  int x, int y, int z){

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

        this.name = name;

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

    public List<Side> getSides(){
        List<Side> sides = new ArrayList<>();

        if(side1 != null ){
            sides.add(side1);
        }
        if( side2 != null ){
            sides.add(side2);
        }
        if( side3 != null ){
            sides.add(side3);
        }

        return sides;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int L = -7;
        String n = String.format("%" + L + "s", getName());
        sb.append(n);
        sb.append(": ");
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

    public char[] toChars(){

        List<Character> chars = new ArrayList<>();

        char[] result = new char[getSize()];

        if( getSize() >= 1){
            result[0] = getSide1().getColor().name().charAt(0);
        }
        if( getSize() >= 2 ){
            result[1] = getSide2().getColor().name().charAt(0);
        }
        if( getSize() == 3 ){
            result[2] = getSide3().getColor().name().charAt(0);
        }

        return result;
    }

    public static AbstractCube copy(@NotNull  AbstractCube c){

        AbstractCube copy = null;

        // construct the cubes
        if( c instanceof CenterCube ){
            copy = new CenterCube( c.toChars(), c.getCoordinates());
        }
        if( c instanceof  CornerCube ){
            copy = new CornerCube(c.toChars(), c.getCoordinates());
        }
        if(c instanceof  EdgeCube ){
            copy = new EdgeCube(c.toChars(), c.getCoordinates());
        }

        // assign the sides.
        if( c.getSize() >= 1 ){
            copy.getSide1().setRubixSide( c.getSide1().getRubixSide() );
        }
        if( c.getSize() >= 2 ){
            copy.getSide2().setRubixSide( c.getSide2().getRubixSide() );
        }
        if( c.getSize() >= 3 ){
            copy.getSide3().setRubixSide( c.getSide3().getRubixSide() );
        }

        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCube that = (AbstractCube) o;
        return size == that.size && x == that.x && y == that.y && z == that.z && side1.equals(that.side1) && side2.equals(that.side2) && side3.equals(that.side3) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, side1, side2, side3, x, y, z, name);
    }
}
