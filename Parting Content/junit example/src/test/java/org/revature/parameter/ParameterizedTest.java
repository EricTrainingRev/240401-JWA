package org.revature.parameter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameters
    public static Collection<Object[]> inputs(){
        return Arrays.asList(
                new Object[][]{
                    {10,true},
                    {9,false}
                }
        );
    }

    @Parameter // defaults to first value in collection
    public int number;
    @Parameter(1)
    public boolean isEven;

    @Test
    public void isEvenPositiveAndNegative(){
        Assert.assertEquals(isEven, number%2==0);
    }

}
