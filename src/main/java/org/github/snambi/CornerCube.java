package org.github.snambi;

public class CornerCube extends AbstractCube {

    public CornerCube(char[] clrs){
        super(3, clrs, "Corner");
    }

    public CornerCube(char[] clrs, int[] coordinates){
        super(3, clrs, "Corner", coordinates);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
