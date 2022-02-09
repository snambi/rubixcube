package org.github.snambi;

/**
 * Represents a Rubix Cube
 *
 */
public class Rubix {

    private RubixSide side1;
    private RubixSide side2;
    private RubixSide side3;
    private RubixSide side4;
    private RubixSide side5;
    private RubixSide side6;

    public static void main(String... args) {
        System.out.println("Hello World");
    }

    public RubixSide getSide1() {
        return side1;
    }

    public void setSide1(RubixSide side1) {
        this.side1 = side1;
    }

    public RubixSide getSide2() {
        return side2;
    }

    public void setSide2(RubixSide side2) {
        this.side2 = side2;
    }

    public RubixSide getSide3() {
        return side3;
    }

    public void setSide3(RubixSide side3) {
        this.side3 = side3;
    }

    public RubixSide getSide4() {
        return side4;
    }

    public void setSide4(RubixSide side4) {
        this.side4 = side4;
    }

    public RubixSide getSide5() {
        return side5;
    }

    public void setSide5(RubixSide side5) {
        this.side5 = side5;
    }

    public RubixSide getSide6() {
        return side6;
    }

    public void setSide6(RubixSide side6) {
        this.side6 = side6;
    }
}

