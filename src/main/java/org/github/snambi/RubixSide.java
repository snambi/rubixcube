package org.github.snambi;

import java.util.*;

/**
 * A RubixCube side is made up of 9 sides from individual cubes.
 * Each side of the cube will have one of the 6 colors.
 */
public class RubixSide {

//    private Side corner1 = new Side(Color.U);
//    private Side edge1 = new Side(Color.U);
//    private Side corner2 = new Side(Color.U);
//    private Side edge2 = new Side(Color.U);
//    private Side edge3 = new Side(Color.U);
//    private Side corner3 = new Side(Color.U);
//    private Side edge4 = new Side(Color.U);
//    private Side corner4 = new Side(Color.U);

    private Side center = new Side(Color.U);
    protected Map<Integer,Side> cornerSides = new HashMap<>();
    protected Map<Integer,Side> edgeSides = new HashMap<>();

    private String name;

    public RubixSide(String name){
        this.name = name;

        getCornerSides().put(1,new Side(Color.U) );
        getCornerSides().put(2,new Side(Color.U) );
        getCornerSides().put(3,new Side(Color.U) );
        getCornerSides().put(4,new Side(Color.U) );

        getEdgeSides().put(1, new Side(Color.U));
        getEdgeSides().put(2, new Side(Color.U));
        getEdgeSides().put(3, new Side(Color.U));
        getEdgeSides().put(4, new Side(Color.U));
    }

    public String getName() {
        return name;
    }

    public Side getCorner1() {
        return getCornerSides().get(1);
    }

    public void setCorner1(Side corner1) {
        this.getCornerSides().put(1,corner1 );
    }

    public Side getEdge1() {
        return getEdgeSides().get(1);
    }

    public void setEdge1(Side edge1) {
        getEdgeSides().put(1, edge1);
    }

    public Side getCorner2() {
        return getCornerSides().get(2);
    }

    public void setCorner2(Side corner2) {
        getCornerSides().put(2, corner2);
    }

    public Side getEdge2() {
        return getEdgeSides().get(2);
    }

    public void setEdge2(Side edge2) {
       getEdgeSides().put(2, edge2);
    }

    public Side getCenter() {
        return center;
    }

    public void setCenter(Side center) {
        this.center = center;
    }

    public Side getEdge3() {
        return getEdgeSides().get(3);
    }

    public void setEdge3(Side edge3) {
        getEdgeSides().put(3, edge3);
    }

    public Side getCorner3() {
        return getCornerSides().get(3);
    }

    public void setCorner3(Side corner3) {
       getCornerSides().put(3, corner3);
    }

    public Side getEdge4() {
        return getEdgeSides().get(4);
    }

    public void setEdge4(Side edge4) {
        getEdgeSides().put(4,edge4);
    }

    public Side getCorner4() {
        return getCornerSides().get(4);
    }

    public void setCorner4(Side corner4) {
        getCornerSides().put(4, corner4);
    }

    public Map<Integer, Side> getCornerSides() {
        return cornerSides;
    }

    public Map<Integer, Side> getEdgeSides() {
        return edgeSides;
    }

    public List<AbstractCube> getCubes(){
        List<AbstractCube> cubes = new ArrayList<>();

        cubes.add(getCorner1().getCube());
        cubes.add(getEdge1().getCube());
        cubes.add(getCorner2().getCube());
        cubes.add(getEdge2().getCube());
        cubes.add(getCenter().getCube());
        cubes.add(getEdge3().getCube());
        cubes.add(getCorner3().getCube());
        cubes.add(getEdge4().getCube());
        cubes.add(getCorner4().getCube());

        return cubes;
    }

    public List<Side> getCubeSides(){

        List<Side> sides = new ArrayList<>();

        sides.add(getCorner1());
        sides.add(getEdge1());
        sides.add(getCorner2());
        sides.add(getEdge2());
        sides.add(getCenter());
        sides.add(getEdge3());
        sides.add(getCorner3());
        sides.add(getEdge4());
        sides.add(getCorner4());

        return sides;
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

    public String getSideFullCubes(){
        var sb = new StringBuilder();




        return sb.toString();
    }
}
