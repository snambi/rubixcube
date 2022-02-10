package org.github.snambi;

import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Rubix Cube
 *
 */
public class Rubix {

    private RubixSide side1 = new RubixSide("side1");
    private RubixSide side2 = new RubixSide("side2");
    private RubixSide side3 = new RubixSide("side3");
    private RubixSide side4 = new RubixSide("side4");
    private RubixSide side5 = new RubixSide("side5");
    private RubixSide side6 = new RubixSide("side6");

    private ArrayList<CornerCube> cornerCubes = new ArrayList<>();
    private ArrayList<EdgeCube> edgeCubes = new ArrayList<>();
    private ArrayList<CenterCube> centerCubes = new ArrayList<>();

    public Rubix(){
    }

    public static void main(String... args) {
        System.out.println("Hello World");
    }

    public void constructCubes(R2Side s1, R2Side s2, R2Side s3,
                               R2Side s4, R2Side s5, R2Side s6 ){


        // create 8 corner cubes.
        // these cubes may change the position (coordinates), but colors of the sides will not change.

        CornerCube _000 = new CornerCube( new char[]{s1.cornerSide3(), s2.cornerSide1(),s5.cornerSide2()} );
        _000.setCoordinates(0,0,0);

        side1.setCorner3(_000.getSide1());
        side2.setCorner1(_000.getSide2());
        side5.setCorner2(_000.getSide3());

        cornerCubes.add(_000);

        CornerCube _200 = new CornerCube( new char[]{ s1.cornerSide4(), s2.cornerSide2(), s3.cornerSide1() });
        _200.setCoordinates(2, 0,0);

        side1.setCorner4(_200.getSide1());
        side2.setCorner2(_200.getSide2());
        side3.setCorner1(_200.getSide3());

        cornerCubes.add(_200);

        CornerCube _020 = new CornerCube( new char[]{ s2.cornerSide3(), s6.cornerSide1(), s5.cornerSide4() });
        _020.setCoordinates(0,2,0);

        side2.setCorner3(_020.getSide1());
        side6.setCorner1(_020.getSide2());
        side5.setCorner4(_020.getSide3());

        cornerCubes.add(_020);

        CornerCube _220 = new CornerCube(new char[]{s2.cornerSide4(), s3.cornerSide2(), s6.cornerSide2()});
        _220.setCoordinates(2,2,0);

        side2.setCorner4(_220.getSide1());
        side3.setCorner2(_220.getSide2());
        side6.setCorner2(_220.getSide3());

        cornerCubes.add(_220);

        CornerCube _002 = new CornerCube(new char[]{s1.cornerSide1(), s4.cornerSide2(), s5.cornerSide1()});
        _002.setCoordinates(0,0,2);

        side1.setCorner1(_002.getSide1());
        side4.setCorner2(_002.getSide2());
        side5.setCorner1(_002.getSide3());

        cornerCubes.add(_002);

        CornerCube _202 = new CornerCube( new char[]{s1.cornerSide2(),s3.cornerSide2(), s4.cornerSide1()});
        _202.setCoordinates(2,0,2);
        side1.setCorner2(_202.getSide1());
        side3.setCorner2(_202.getSide2());
        side4.setCorner1(_202.getSide3());

        cornerCubes.add(_202);

        CornerCube _222 = new CornerCube( new char[]{s4.cornerSide2(), s3.cornerSide4(), s6.cornerSide4()});
        _222.setCoordinates(2,2,2);
        side4.setCorner2(_222.getSide1());
        side3.setCorner4(_222.getSide2());
        side6.setCorner4(_222.getSide3());

        cornerCubes.add(_222);

        CornerCube _022 = new CornerCube( new char[]{s4.cornerSide4(), s5.cornerSide3(), s6.cornerSide3()});
        _022.setCoordinates(0,2,2);
        side4.setCorner4(_022.getSide1());
        side5.setCorner3(_022.getSide2());
        side6.setCorner3(_022.getSide3());

        cornerCubes.add(_022);


        // create 12 EDGE cubes.
        // these cubes may change the position (coordinates), but colors of the sides will not change.

        EdgeCube _100 = new EdgeCube( new char[]{s1.edgeSide3(), s2.edgeSide1()});
        _100.setCoordinates(1,0,0);

        side1.setEdge3(_100.getSide1());
        side2.setEdge1(_100.getSide2());

        edgeCubes.add(_100);

        EdgeCube _010 = new EdgeCube( new char[]{ s2.edgeSide2(), s4.edgeSide3()});
        _010.setCoordinates(0,1,0);

        side2.setEdge2(_010.getSide1());
        side4.setEdge3(_010.getSide2());

        edgeCubes.add(_010);

        EdgeCube _210 = new EdgeCube( new char[]{s2.edgeSide3(), s3.edgeSide2()} );
        _210.setCoordinates(2,1,0);

        side2.setEdge3(_210.getSide1());
        side2.setEdge2(_210.getSide2());

        edgeCubes.add(_210);

        EdgeCube _120 = new EdgeCube(new char[]{s2.edgeSide4(), s6.edgeSide1()});
        _120.setCoordinates(1,2,0);

        side2.setEdge4(_120.getSide1());
        side6.setEdge1(_120.getSide2());

        edgeCubes.add(_120);

        /*=====*/

        EdgeCube _102 = new EdgeCube(new char[]{s1.edgeSide1(), s4.edgeSide1()});
        _102.setCoordinates(1,0,2);

        side1.setEdge1(_102.getSide1());
        side4.setEdge1(_102.getSide2());

        edgeCubes.add(_102);

        EdgeCube _212 = new EdgeCube(new char[]{s4.edgeSide2(), s3.edgeSide3()});
        _212.setCoordinates(2,1,2);

        side4.setEdge2(_212.getSide1());
        side3.setEdge3(_212.getSide2());

        edgeCubes.add(_212);

        EdgeCube _012 = new EdgeCube(new char[]{s4.edgeSide3(), s5.edgeSide2()});
        _012.setCoordinates(0,1,2);

        side4.setEdge3(_012.getSide1());
        side5.setEdge2(_012.getSide2());

        edgeCubes.add(_012);

        EdgeCube _122 = new EdgeCube(new char[]{s4.edgeSide4(),s6.edgeSide4()});
        _122.setCoordinates(1,2,2);

        side4.setEdge4(_122.getSide1());
        side6.setEdge4(_122.getSide2());

        edgeCubes.add(_122);

        /* ==== */

        EdgeCube _001 = new EdgeCube(new char[]{s1.edgeSide2(), s5.edgeSide1() });
        _001.setCoordinates(0,0,1);

        side1.setEdge2(_001.getSide1());
        side5.setEdge1(_001.getSide2());

        edgeCubes.add(_001);

        EdgeCube _201 = new EdgeCube(new char[]{s1.edgeSide3(),s3.edgeSide1()});
        _201.setCoordinates(2,0,1);

        side1.setEdge3(_201.getSide1());
        side3.setEdge1(_201.getSide2());

        edgeCubes.add(_201);

        EdgeCube _021 = new EdgeCube(new char[]{s5.edgeSide4(),s6.edgeSide2()});
        _201.setCoordinates(2,0,1);

        side5.setEdge4(_201.getSide1());
        side6.setEdge2(_201.getSide2());

        edgeCubes.add(_201);

        EdgeCube _221 = new EdgeCube(new char[]{s3.edgeSide4(),s6.edgeSide3()});
        _221.setCoordinates(2,2,1);

        side3.setEdge4(_221.getSide1());
        side6.setEdge3(_221.getSide2());

        edgeCubes.add(_221);

        /**
         * Add 6 center cubes.
         */

        CenterCube _110 = new CenterCube(new char[]{s2.centerSide()});
        _110.setCoordinates(1,1,0);
        side2.setCenter(_110.getSide1());
        centerCubes.add(_110);

        CenterCube _211 = new CenterCube(new char[]{s3.centerSide()});
        _211.setCoordinates(2,1,1);
        side3.setCenter(_211.getSide1());
        centerCubes.add(_211);

        CenterCube _112 = new CenterCube(new char[]{s4.centerSide()});
        _112.setCoordinates(1,1,2);
        side4.setCenter(_112.getSide1());
        centerCubes.add(_112);

        CenterCube _011 = new CenterCube(new char[]{s5.centerSide()});
        _011.setCoordinates(0,1,1);
        side5.setCenter(_011.getSide1());
        centerCubes.add(_011);

        CenterCube _101 = new CenterCube(new char[]{s1.centerSide()});
        _101.setCoordinates(1,0,1);
        side1.setCenter(_101.getSide1());
        centerCubes.add(_101);

        CenterCube _121 = new CenterCube(new char[]{s6.centerSide()});
        _121.setCoordinates(1,2,1);
        side6.setCenter(_121.getSide1());
        centerCubes.add(_121);
    }

    public static Rubix readFromFile( String filename )
            throws URISyntaxException, IOException, IllegalClassFormatException {

        List<Character> chars = RubixUtils.readFromFile(filename);

        // construct 6 sides from the characters read from the file
        if( chars.size() != 54){
            throw new IllegalClassFormatException("Cube must have 63 values. Only contains "+ chars.size());
        }

        // read the first 9 characters
        List<Character> sd1 = chars.subList(0, 9);

        R2Side s1 = new R2Side( sd1.get(0), sd1.get(1), sd1.get(2),
                sd1.get(3), sd1.get(4), sd1.get(5),
                sd1.get(6), sd1.get(7), sd1.get(8));


        // Read the next 4 sides
        List<Character> f = rearrange( chars.subList(9,45));

        R2Side s2 = new R2Side(f.get(0), f.get(1), f.get(2),
                                        f.get(3), f.get(4), f.get(5),
                                        f.get(6), f.get(7), f.get(8));

        R2Side s3 = new R2Side(f.get(9), f.get(10), f.get(11),
                                        f.get(12), f.get(13), f.get(14),
                                        f.get(15), f.get(16), f.get(17));

        R2Side s4 = new R2Side(f.get(18), f.get(19), f.get(20),
                                        f.get(21), f.get(22), f.get(23),
                                        f.get(24), f.get(25), f.get(26));

        R2Side s5 = new R2Side(f.get(27), f.get(28), f.get(29),
                                        f.get(30), f.get(31), f.get(32),
                                        f.get(33), f.get(34), f.get(35));

        // read the last side
        R2Side s6 = new R2Side( chars.get(45), chars.get(46), chars.get(47),
                                        chars.get(48), chars.get(49), chars.get(50),
                                        chars.get(51), chars.get(52), chars.get(53));

        Rubix cube = new Rubix();
        cube.constructCubes(s1, s2, s3, s4, s5, s6);

        return cube;
    }

    public static List<Character> rearrange( List<Character> values ){

        List<Character> result = new ArrayList<>();

        if(values.size() == 36 ){

            result.addAll( values.subList(0,3));
            result.addAll( values.subList(12,15));
            result.addAll( values.subList(24,27));

            result.addAll( values.subList(3,6));
            result.addAll( values.subList(15,18));
            result.addAll( values.subList(27,30));

            result.addAll( values.subList(6,9));
            result.addAll( values.subList(18,21));
            result.addAll( values.subList(30,33));

            result.addAll( values.subList(9,12));
            result.addAll( values.subList(21,24));
            result.addAll( values.subList(33,36));
        }

        return result;
    }

    public void printCubes(){
        for(CornerCube c: cornerCubes ){
            System.out.println(c.toString());
        }
        for(EdgeCube e: edgeCubes){
            System.out.println(e);
        }
        for(CenterCube c: centerCubes){
            System.out.println(c);
        }
    }

    public void printSides(){
        System.out.println(side1);
        System.out.println(side2);
        System.out.println(side3);
        System.out.println(side4);
        System.out.println(side5);
        System.out.println(side6);

    }

    @Override
    public String toString() {

        var sb = new StringBuilder();

        sb.append( this.side1.toString());

        sb.append( this.side2.getFirstRow());
        sb.append( " ");
        sb.append( this.side3.getFirstRow());
        sb.append( " ");
        sb.append( this.side4.getFirstRow());
        sb.append( " ");
        sb.append( this.side5.getFirstRow());
        sb.append( "\n");

        sb.append( this.side2.getSecondRow());
        sb.append( " ");
        sb.append( this.side3.getSecondRow());
        sb.append( " ");
        sb.append( this.side4.getSecondRow());
        sb.append( " ");
        sb.append( this.side5.getSecondRow());
        sb.append( "\n");

        sb.append( this.side2.getThirdRow());
        sb.append( " ");
        sb.append( this.side3.getThirdRow());
        sb.append( " ");
        sb.append( this.side4.getThirdRow());
        sb.append( " ");
        sb.append( this.side5.getThirdRow());
        sb.append( "\n");

        sb.append( this.side6.toString());

        return sb.toString();
    }
}

