package org.github.snambi;

public class CenterCube extends AbstractCube {
    public CenterCube(char[] clrs){
        super(1, clrs, "Center");
    }
    public CenterCube( char[] clrs, int[] coordinates){
        super(1, clrs, "Center", coordinates );
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
