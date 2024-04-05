package org.revature.basic;

import org.junit.*;

public class BasicAnnotationTests {

    @BeforeClass
    public static void setup(){
        System.out.println("This runs before all tests");
    }

    @Before
    public void beforeEach(){
        System.out.println("This runs before each test");
    }

    @Test
    public void testOne(){
        System.out.println("testOne called");
        Assert.assertEquals(10,5+5);
    }

    @Test
    public void testTwo(){
        System.out.println("testTwo called");
        Assert.assertTrue(true);
    }

    @After
    public void afterEach(){
        System.out.println("This runs after each test");
    }

    @AfterClass
    public static void afterAll(){
        System.out.println("This runs after all tests");
    }
}
