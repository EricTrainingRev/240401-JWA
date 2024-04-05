package org.revature.ignore;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestIgnore {

    @Ignore("you can say why you ignore a test")
    @Test
    public void ignoredTest(){
        Assert.fail("this test should not run");
    }
}
