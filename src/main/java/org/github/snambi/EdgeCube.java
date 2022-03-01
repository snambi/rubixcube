package org.github.snambi;

public class EdgeCube extends AbstractCube {


    public EdgeCube(char[] clrs){
        super(2, clrs, "Edge");
    }

    public EdgeCube(char[] clrs, int[] coordinates){
        super(2, clrs, "Edge", coordinates);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
