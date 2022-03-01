package org.github.snambi;

import java.util.List;
import java.util.Objects;

public class Side {
    Color color = Color.U;

    private AbstractCube cube;
    private RubixSide rubixSide;

    public Side(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public AbstractCube getCube() {
        return cube;
    }

    public void setCube(AbstractCube cube) {
        this.cube = cube;
    }

    public RubixSide getRubixSide() {
        return rubixSide;
    }

    public void setRubixSide(RubixSide rubixSide) {
        this.rubixSide = rubixSide;
    }

    public List<Side> getOtherSides(){
        return null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        int L = -7;
        String n = String.format("%" + L + "s", getCube().getName());

        sb.append( n );
        sb.append(" ");
        for( int c: getCube().getCoordinates()){
            sb.append(c);
            sb.append(" ");
        }

        sb.append("[");
        sb.append( getColor().name());
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Side side = (Side) o;
        return color == side.color && cube.equals(side.cube) && rubixSide.equals(side.rubixSide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, cube, rubixSide);
    }
}
