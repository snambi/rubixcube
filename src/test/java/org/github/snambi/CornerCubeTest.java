package org.github.snambi;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CornerCubeTest {

    @Test
    public void testColors(){

        CornerCube cc = new CornerCube("GRB".toCharArray());

        System.out.println("CornerCube = "+ cc);
        Assert.isNonEmpty(cc);
    }

}