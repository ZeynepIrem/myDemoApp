package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


import java.util.ArrayList; 
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    

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


    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");



        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
		  String input2 = req.queryParams("input2");
		  String input3 = req.queryParams("input3");
		  String input4 = req.queryParams("input4");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
		  java.util.Scanner sc2 = new java.util.Scanner(input2);
		  java.util.Scanner sc3 = new java.util.Scanner(input3);
          java.util.Scanner sc4 = new java.util.Scanner(input4);
		  sc1.useDelimiter("[;\r\n]+");
		  sc2.useDelimiter("[;\r\n]+");
		  sc3.useDelimiter("[;\r\n]+");
 		  sc4.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
		  java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
		  java.util.ArrayList<Integer> inputList3 = new java.util.ArrayList<>();
		  java.util.ArrayList<Integer> inputList4 = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList1.add(value);
          }
		  while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
		  while (sc3.hasNext())
          {
            int value = Integer.parseInt(sc3.next().replaceAll("\\s",""));
            inputList3.add(value);
          }
		  while (sc4.hasNext())
          {
            int value = Integer.parseInt(sc4.next().replaceAll("\\s",""));
            inputList4.add(value);
          }
          System.out.println(inputList1);
		  System.out.println(inputList2);
		  System.out.println(inputList3);
		  System.out.println(inputList4);


		Integer[] inputL1 = (Integer[])inputList1.toArray(new Integer[inputList1.size()]);
		int[] i1 = new int[inputL1.length];
		for(int i=0; i<inputL1.length; i++)
			i1[i] = (int)inputL1[i];
			
		Integer[] inputL2 =  (Integer[])inputList2.toArray(new Integer[inputList2.size()]);
		int[] i2 = new int[inputL2.length];
		for(int i=0; i<inputL2.length; i++)
			i2[i] = (int)inputL2[i];

		Integer[] inputL3 =  (Integer[])inputList3.toArray(new Integer[inputList3.size()]);
		int[] i3 = new int[inputL3.length];
		for(int i=0; i<inputL3.length; i++)
			i3[i] = inputL3[i];

		Integer[] inputL4 =  (Integer[])inputList4.toArray(new Integer[inputList4.size()]);
		int[] i4 = new int[inputL4.length];
		for(int i=0; i<inputL4.length; i++)
			i4[i] = inputL4[i];


          int result = App.sortedMin(i1, i2, i3, i4);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

