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
public record Rubix( RubixSide side1, RubixSide side2, RubixSide side3,
                     RubixSide side4, RubixSide side5, RubixSide side6) {

    public static void main(String... args) {
        System.out.println("Hello World");
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

        RubixSide s1 = new RubixSide( sd1.get(0), sd1.get(1), sd1.get(2),
                sd1.get(3), sd1.get(4), sd1.get(5),
                sd1.get(6), sd1.get(7), sd1.get(8));


        // Read the next 4 sides
        List<Character> f = rearrange( chars.subList(9,45));

        RubixSide s2 = new RubixSide(f.get(0), f.get(1), f.get(2),
                                        f.get(3), f.get(4), f.get(5),
                                        f.get(6), f.get(7), f.get(8));

        RubixSide s3 = new RubixSide(f.get(9), f.get(10), f.get(11),
                                        f.get(12), f.get(13), f.get(14),
                                        f.get(15), f.get(16), f.get(17));

        RubixSide s4 = new RubixSide(f.get(18), f.get(19), f.get(20),
                                        f.get(21), f.get(22), f.get(23),
                                        f.get(24), f.get(25), f.get(26));

        RubixSide s5 = new RubixSide(f.get(27), f.get(28), f.get(29),
                                        f.get(30), f.get(31), f.get(32),
                                        f.get(33), f.get(34), f.get(35));

        // read the last side
        RubixSide s6 = new RubixSide( chars.get(45), chars.get(46), chars.get(47),
                                        chars.get(48), chars.get(49), chars.get(50),
                                        chars.get(51), chars.get(52), chars.get(53));

        Rubix cube = new Rubix(s1, s2, s3, s4, s5, s6);
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

    @Override
    public String toString() {

        var sb = new StringBuilder();

        sb.append( this.side1().toString());

        sb.append( this.side2().getFirstRow());
        sb.append( " ");
        sb.append( this.side3().getFirstRow());
        sb.append( " ");
        sb.append( this.side4().getFirstRow());
        sb.append( " ");
        sb.append( this.side5().getFirstRow());
        sb.append( "\n");

        sb.append( this.side2().getSecondRow());
        sb.append( " ");
        sb.append( this.side3().getSecondRow());
        sb.append( " ");
        sb.append( this.side4().getSecondRow());
        sb.append( " ");
        sb.append( this.side5().getSecondRow());
        sb.append( "\n");

        sb.append( this.side2().getThirdRow());
        sb.append( " ");
        sb.append( this.side3().getThirdRow());
        sb.append( " ");
        sb.append( this.side4().getThirdRow());
        sb.append( " ");
        sb.append( this.side5().getThirdRow());
        sb.append( "\n");

        sb.append( this.side6().toString());

        return sb.toString();
    }
}

