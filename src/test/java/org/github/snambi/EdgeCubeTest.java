package org.github.snambi;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;

public class EdgeCubeTest {

    @Test
    public void testColors(){

        EdgeCube ec = new EdgeCube("RB".toCharArray());

        System.out.println("EdgeCube = "+ ec);
        Assert.isNonEmpty(ec);
    }

}
