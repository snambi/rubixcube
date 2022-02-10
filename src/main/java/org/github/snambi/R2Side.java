package org.github.snambi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Each side of the Rubix cube is made up of 9 indiviuals sides from the sub-cubes.
 *
 * It involves, 4 sides from corner cubes, 4 from edge cubes and 1 from center cube.
 */
public class R2Side{

    public char cornerSide1, edgeSide1, cornerSide2;
    public char edgeSide2,  centerSide,  edgeSide3;
    public char cornerSide3,  edgeSide4, cornerSide4;

    public R2Side(char cornerSide1, char edgeSide1, char cornerSide2,
                     char edgeSide2, char centerSide, char edgeSide3,
                     char cornerSide3, char edgeSide4, char cornerSide4 ) {

        this.cornerSide1 = cornerSide1;
        this.edgeSide1 = edgeSide1;
        this.cornerSide2 = cornerSide2;

        this.edgeSide2 = edgeSide2;
        this.centerSide = centerSide;
        this.edgeSide3 = edgeSide3;

        this.cornerSide3 = cornerSide3;
        this.edgeSide4 = edgeSide4;
        this.cornerSide4 = cornerSide4;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append( this.cornerSide1);
        sb.append(" ");
        sb.append( this.edgeSide1);
        sb.append(" ");
        sb.append( this.cornerSide2);
        sb.append("\n");

        sb.append( this.edgeSide2);
        sb.append(" ");
        sb.append( this.centerSide);
        sb.append(" ");
        sb.append( this.edgeSide3);
        sb.append("\n");

        sb.append( this.cornerSide3);
        sb.append(" ");
        sb.append( this.edgeSide3);
        sb.append(" ");
        sb.append( this.cornerSide4);
        sb.append("\n");

        return sb.toString();
    }

    public String getFirstRow(){
        StringBuilder sb = new StringBuilder();

        sb.append(this.cornerSide1);
        sb.append(" ");
        sb.append(this.edgeSide1);
        sb.append(" ");
        sb.append(this.cornerSide2);

        return sb.toString();
    }

    public String getSecondRow(){
        StringBuilder sb = new StringBuilder();

        sb.append(this.edgeSide2);
        sb.append(" ");
        sb.append(this.centerSide);
        sb.append(" ");
        sb.append(this.edgeSide3);

        return sb.toString();
    }

    public String getThirdRow(){
        StringBuilder sb = new StringBuilder();

        sb.append(this.cornerSide3);
        sb.append(" ");
        sb.append(this.edgeSide4);
        sb.append(" ");
        sb.append(this.cornerSide4);

        return sb.toString();
    }


    public static R2Side readFromFile(final String fileName ) throws IOException, URISyntaxException {

        List<Character> chars = RubixUtils.readFromFile(fileName);

        R2Side side = new R2Side(chars.get(0), chars.get(1), chars.get(2),
                chars.get(3), chars.get(4), chars.get(5),
                chars.get(6), chars.get(7), chars.get(8) );

        return side;
    }
}
