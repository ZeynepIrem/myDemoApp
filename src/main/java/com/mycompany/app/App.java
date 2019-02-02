package com.mycompany.app;
import java.util.ArrayList; 
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    // Function to merge array in sorted order 
    public static int sortedMin(int a[], int b[], int c[], int d[]) 
    { 

		
		if((a==null || a.length==0) && (b==null || b.length==0) && (c==null|| c.length==0) && (d==null|| d.length==0))
			return -1;


	//At least one array is emptyn or null		
		if((a==null || a.length==0) || (b==null || b.length==0) || (c==null|| c.length==0) || (d==null|| d.length==0)){

				int min=-1;
		
				if(a==null || a.length==0);
					
				else{
						Arrays.sort(a);
						min = a[0];				
					}


				if(b==null || b.length==0 );
				else{
					Arrays.sort(b);
			
					if(min==-1)
					min = b[0];
					else
						if(b[0] < min)
						min = b[0];
				}

				if(c==null || c.length==0 );
				else{
					Arrays.sort(c);
			
					if(min==-1)
					min = c[0];
					else
						if(c[0] < min)
						min = c[0];
				}

				if(d==null || d.length==0 );
				else{
					Arrays.sort(d);
					if(min==-1)
					min = d[0];
					else
						if(d[0] < min)
						min = d[0];
				}

			return min;
			}


		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		Arrays.sort(d);


		if(a[0]<=b[0] && a[0]<=c[0] & a[0]<=d[0]) 
			return a[0];

		else if(b[0]<=a[0] && b[0]<=c[0] & b[0]<=d[0])
          	return b[0];

		else if(c[0]<=a[0] && c[0]<=b[0] & c[0]<=d[0])
       		return c[0];
		else
			return d[0];
      } 




}
