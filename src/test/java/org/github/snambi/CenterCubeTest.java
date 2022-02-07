package org.github.snambi;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;

public class CenterCubeTest {

    @Test
    public void testColors(){

        char[] x = {'R'};
        CenterCube cc = new CenterCube(x);

        System.out.println("CenterCube = "+ cc);
        Assert.isNonEmpty(cc);
    }
}
