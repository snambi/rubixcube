package org.github.snambi;

/**
 * A RubixCube side is made up of 9 sides from individual cubes.
 * Each side of the cube will have one of the 6 colors.
 */
public class RubixSide {

    private Side corner1 = new Side(Color.U);
    private Side edge1 = new Side(Color.U);
    private Side corner2 = new Side(Color.U);
    private Side edge2 = new Side(Color.U);
    private Side center = new Side(Color.U);
    private Side edge3 = new Side(Color.U);
    private Side corner3 = new Side(Color.U);
    private Side edge4 = new Side(Color.U);
    private Side corner4 = new Side(Color.U);

    private String name;

    public RubixSide(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Side getCorner1() {
        return corner1;
    }

    public void setCorner1(Side corner1) {
        this.corner1 = corner1;
    }

    public Side getEdge1() {
        return edge1;
    }

    public void setEdge1(Side edge1) {
        this.edge1 = edge1;
    }

    public Side getCorner2() {
        return corner2;
    }

    public void setCorner2(Side corner2) {
        this.corner2 = corner2;
    }

    public Side getEdge2() {
        return edge2;
    }

    public void setEdge2(Side edge2) {
        this.edge2 = edge2;
    }

    public Side getCenter() {
        return center;
    }

    public void setCenter(Side center) {
        this.center = center;
    }

    public Side getEdge3() {
        return edge3;
    }

    public void setEdge3(Side edge3) {
        this.edge3 = edge3;
    }

    public Side getCorner3() {
        return corner3;
    }

    public void setCorner3(Side corner3) {
        this.corner3 = corner3;
    }

    public Side getEdge4() {
        return edge4;
    }

    public void setEdge4(Side edge4) {
        this.edge4 = edge4;
    }

    public Side getCorner4() {
        return corner4;
    }

    public void setCorner4(Side corner4) {
        this.corner4 = corner4;
    }

    public String getFirstRow(){
        StringBuilder sb = new StringBuilder();

        sb.append( getCorner1().getColor().name());
        sb.append(" ");
        sb.append( getEdge1().getColor().name());
        sb.append(" ");
        sb.append( getCorner2().getColor().name());

        return sb.toString();
    }

    public String getSecondRow(){
        StringBuilder sb = new StringBuilder();

        sb.append( getEdge2().getColor().name());
        sb.append(" ");
        sb.append( getCenter().getColor().name());
        sb.append(" ");
        sb.append( getEdge3().getColor().name());

        return sb.toString();
    }

    public String getThirdRow(){
        StringBuilder sb = new StringBuilder();

        sb.append( getCorner3().getColor().name());
        sb.append(" ");
        sb.append( getEdge4().getColor().name());
        sb.append(" ");
        sb.append( getCorner4().getColor().name());

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getCorner1().getColor().name());
        sb.append(" ");
        sb.append(getEdge1().getColor().name());
        sb.append(" ");
        sb.append(getCorner2().getColor().name());
        sb.append("\n");

        sb.append(getEdge2().getColor().name());
        sb.append(" ");
        sb.append(getCenter().getColor().name());
        sb.append(" ");
        sb.append(getEdge3().getColor().name());
        sb.append("\n");

        sb.append(getCorner3().getColor().name());
        sb.append(" ");
        sb.append(getEdge4().getColor().name());
        sb.append(" ");
        sb.append(getCorner4().getColor().name());
        sb.append("\n");

        return  sb.toString();
    }
}
