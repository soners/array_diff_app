package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
     public void testFirstSetNull() {
       ArrayList<String> set = new ArrayList<>(Arrays.asList("soner","say"));
       assertEquals(new App().array_diff(null,set,true,0),null);
     }

     public void testSecondSetNull() {
       ArrayList<String> set = new ArrayList<>(Arrays.asList("soner","say"));
       assertEquals(new App().array_diff(set,null,true,0),null);
     }

     public void testWrongLimitValue() {
       ArrayList<String> set = new ArrayList<>(Arrays.asList("soner","say"));
       ArrayList<String> set2 = new ArrayList<>(Arrays.asList("1","2","3","4"));
       assertEquals(new App().array_diff(set,set2,true,-1),new ArrayList<String>());
     }

     public void testLimitValue() {
       ArrayList<String> set = new ArrayList<>(Arrays.asList("mercedes","bmw"));
       ArrayList<String> set2 = new ArrayList<>(Arrays.asList("ford","lamborghini","porsche","bmw","nissan","mercedes"));

       ArrayList<String> target = new ArrayList<>(Arrays.asList("ford","lamborghini"));
       assertEquals(new App().array_diff(set,set2,false,2),target);
     }

     public void testObjectsFoundCorrectlyInFirstSet() {
       ArrayList<String> set = new ArrayList<>(Arrays.asList("java","python","ruby","c"));
       ArrayList<String> set2 = new ArrayList<>(Arrays.asList("fortran","python"));
       ArrayList<String> target = new ArrayList<>(Arrays.asList("java","ruby","c"));
       assertEquals(new App().array_diff(set,set2,true,10),target);
     }

     public void testObjectsFoundCorrectlyInSecondSet() {
       ArrayList<String> set = new ArrayList<>(Arrays.asList("mercedes","bmw"));
       ArrayList<String> set2 = new ArrayList<>(Arrays.asList("ford","lamborghini","porsche","bmw","nissan","mercedes"));
       ArrayList<String> target = new ArrayList<>(Arrays.asList("ford","lamborghini","porsche","nissan"));
       assertEquals(new App().array_diff(set,set2,false,20),target);
     }

}
