package org.github.snambi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A RubixCube side is made up of 9 sides from individual cubes.
 * Each side of the cube will have one of the 6 colors.
 */
public class RubixSide {

    private Side center = new Side(Color.U);
    protected Map<Integer,Side> cornerSides = new HashMap<>();
    protected Map<Integer,Side> edgeSides = new HashMap<>();

    private String name;

    public RubixSide(String name){
        this.name = name;

        Side undefined = new Side(Color.U);

        setCornerSide(1, undefined);
        setCornerSide(2, undefined);
        setCornerSide(3, undefined);
        setCornerSide(4, undefined);

        setEdgeSide(1, undefined);
        setEdgeSide(2, undefined);
        setEdgeSide(3, undefined);
        setEdgeSide(4, undefined);
    }

    public String getName() {
        return name;
    }

    public Side getCorner1() {
        return getCornerSide(1);
    }

    public void setCorner1(Side corner1) {
        setCornerSide(1,corner1);
    }

    public Side getEdge1() {
        return getEdgeSide(1);
    }

    public void setEdge1(Side edge1) {
        setEdgeSide(1, edge1);
    }

    public Side getCorner2() {
        return getCornerSide(2);
    }

    public void setCorner2(Side corner2) {
        setCornerSide(2, corner2);
    }

    public Side getEdge2() {
        return getEdgeSide(2);
    }

    public void setEdge2(Side edge2) {
        setEdgeSide(2, edge2);
    }

    public Side getCenter() {
        return center;
    }

    public void setCenter(Side center) {
        this.center = center;
    }

    public Side getEdge3() {
        return getEdgeSide(3);
    }

    public void setEdge3(Side edge3) {
        setEdgeSide(3, edge3);
    }

    public Side getCorner3() {
        return getCornerSide(3);
    }

    public void setCorner3(Side corner3) {
        setCornerSide(3, corner3);
    }

    public Side getEdge4() {
        return getEdgeSide(4);
    }

    public void setEdge4(Side edge4) {
        setEdgeSide(4, edge4);
    }

    public Side getCorner4() {
        return getCornerSide(4);
    }

    public void setCorner4(Side corner4) {
        setCornerSide(4, corner4);
    }

    public Side getCornerSide(int number){
        return cornerSides.get(number);
    }

    public Side getEdgeSide( int number ){
        return edgeSides.get(number);
    }

    public Side setCornerSide(int number, Side side){
        cornerSides.put(number, side);
        side.setRubixSide(this);
        return side;
    }

    public Side setEdgeSide(int number, Side side){
        edgeSides.put(number, side);
        side.setRubixSide(this);
        return side;
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

    /**
     * Prints the full cubes of a side.
     *
     * Full cubes on a side would look as below,
     * |   | G | B | W |   |
     * | B | R | Y | O | W |
     * | Y | O | W | B | R |
     * | G | R | W | B | O |
     * |   | W | R | Y |   |
     *
     *  Simply printing a side will look as follows,
     *
     * |   |   |   |   |   |
     * |   | R | Y | O |   |
     * |   | O | W | B |   |
     * |   | R | W | B |   |
     * |   |   |   |   |   |
     *
     * That means it prints 5 rows with 5 elements each.
     *
     * @return
     */
    public String printSideWithFullCubes(){
        var sb = new StringBuilder();


        RubixSide topSide = otherSideOfEdgeCube(getEdge1().getCube());
        RubixSide leftSide = otherSideOfEdgeCube(getEdge2().getCube());
        RubixSide rightSide = otherSideOfEdgeCube(getEdge3().getCube());
        RubixSide bottomSide = otherSideOfEdgeCube(getEdge4().getCube());

        // Print the first row.
        // first char is " ", then 3 chars and then " "
        sb.append("  ");
        sb.append( getConnectedSide(topSide, getCornerSide(1).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(topSide, getEdgeSide(1).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(topSide, getCornerSide(2).getCube()).getColor().name() );
        sb.append("  \n");

        // Print second Row : 5 chars
        sb.append( getConnectedSide(leftSide, getCornerSide(1).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(this, getCornerSide(1).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(this, getEdgeSide(1).getCube()).getColor().name());
        sb.append(" ");
        sb.append( getConnectedSide(this, getCornerSide(2).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(rightSide, getCornerSide(2).getCube()).getColor().name() );
        sb.append("\n");


        // print third row : 5 chars
        sb.append( getConnectedSide(leftSide, getEdgeSide(2).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(this, getEdgeSide(2).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getCenter().getCube().getSide1().getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(this, getEdgeSide(3).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(rightSide, getEdgeSide(3).getCube()).getColor().name()  );
        sb.append("\n");

        // Print fourth Row : 5 chars
        sb.append( getConnectedSide(leftSide, getCornerSide(3).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(this, getCornerSide(3).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(this, getEdgeSide(4).getCube()).getColor().name());
        sb.append(" ");
        sb.append( getConnectedSide(this, getCornerSide(4).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(rightSide, getCornerSide(4).getCube()).getColor().name() );
        sb.append("\n");


        // print fifth row: 3 chars
        sb.append("  ");
        sb.append( getConnectedSide(bottomSide, getCornerSide(3).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(bottomSide, getEdgeSide(4).getCube()).getColor().name() );
        sb.append(" ");
        sb.append( getConnectedSide(bottomSide, getCornerSide(4).getCube()).getColor().name() );
        sb.append("  \n");

        return sb.toString();
    }

    private Side getConnectedSide( RubixSide rubixSide, AbstractCube cube){
        Side result=null;

        if( rubixSide == null ){
            throw new IllegalArgumentException("rubixSide is null");
        }
        if( cube == null ){
            throw new IllegalArgumentException("cube is null");
        }

        for( Side s : cube.getSides() ){
            if( s.getRubixSide() == rubixSide ){
                result =s;
                break;
            }
        }

        return result;
    }

    private RubixSide otherSideOfEdgeCube( AbstractCube cube){

        RubixSide other= null;

        if( cube == null || cube.getSides().size()!= 2){
            throw new IllegalArgumentException("Cube is null or not an edge cube");
        }

        for( Side side : cube.getSides() ){
            if( side.getRubixSide() != this ){
                other = side.getRubixSide();
            }
        }

        return other;
    }
}
