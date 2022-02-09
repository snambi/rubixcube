package org.github.snambi;

public class RubixSide {

    private Side corner1;
    private Side edge1;
    private Side corner2;
    private Side edge2;
    private Side center;
    private Side edge3;
    private Side corner3;
    private Side edge4;
    private Side corner4;

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
}
