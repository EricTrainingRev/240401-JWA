package org.revature.exceptions;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExceptionTesting {

    @Test
    public void exceptionTestingWithLambda(){
        IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, ()->{
            new ArrayList<Integer>().add(1,1);
        });
        assertEquals("Index: 1, Size: 0", e.getMessage());
    }

    @Test
    public void exceptionTestingWithoutLambda(){
        try{
            new ArrayList<Integer>().add(1,1);
            fail("this should not happen");
        } catch(IndexOutOfBoundsException e){
            assertEquals("Index: 1, Size: 0", e.getMessage());
        }
    }

}
