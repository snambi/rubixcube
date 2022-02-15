package org.github.snambi;

public class Side {
    Color color = Color.U;

    private AbstractCube cube;

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
}
