package com.mycompany.app;
//import org.junit.Test;
import java.lang.annotation.Annotation;
import junit.framework.Test;
import java.util.*;

import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{

   
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

     
    public void testApp()
    {
        assertTrue( true );
    }
    
	 
	//Minimumu dogru bulma
    public void testMin() {
        int a[] = {1,2,3,1,9};
		int b[] = {5,13,9,6,4,6,11,33,9};
		int c[] = {4,6,1,66,5,2};
		int d[] = {2,1};
        assertEquals(new App().sortedMin(a,b,c,d), 1);
      }

	
   
	//Arrayler null ise
	  public void testForAllNull() {
		
        assertEquals(new App().sortedMin(null,null,null,null),-1);
	
		}
	//Arrayler empty ise
	 public void testForAllEmptyArrays() {
		int a[] = {};
		int b[] = {};
		int c[] = {};
		int d[] = {}; 
        assertEquals(new App().sortedMin(a,b,c,d),-1);
      }

	//Array lerden en az 1 tanesi bos ya da null ise 
	 public void testForAtLeastOneNullOrEmpty() {
		int a[] = {};
		int b[] = {4,6,1,66,5,2};
		int c[] = null;
		int d[] =  {2,5};
        assertEquals(new App().sortedMin(a,b,c,d),1);
      }

	//Duzgun sort edildi mi 1 (hepsi doluyken)
 	public void testSort1() {
		int a[] = {1,2,3,1,9};
		int b[] = {4,6,1,66,5,2};
		int c[] = {5,13,9,6,4,6,11,33,9};
		int d[] =  {2,5,0};
		App ap= new App();
		ap.sortedMin(a,b,c,d);
		assertTrue(Arrays.equals(a, new int[]{1,1,2,3,9}));
		assertTrue(Arrays.equals(b, new int[]{1,2,4,5,6,66}));
		assertTrue(Arrays.equals(c, new int[]{4,5,6,6,9,9,11,13,33}));
		assertTrue(Arrays.equals(d, new int[]{0,2,5}));
      }


	//Duzgun sort edildi mi
	 public void testSort2() {
		int a[] = {};
		int b[] = {4,6,1,66,5,2};
		int c[] = null;
		int d[] =  {2,5,0};
		App ap= new App();
		ap.sortedMin(a,b,c,d);
		assertTrue(Arrays.equals(a, new int[]{}));
		assertTrue(Arrays.equals(b, new int[]{1,2,4,5,6,66}));
		assertTrue(Arrays.equals(c, null));
		assertTrue(Arrays.equals(d, new int[]{0,2,5}));
      }
	



}
