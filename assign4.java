/*
 *Padma Ram Meg
 *Roll No.1301CS30
 *Creation of date 
 *27/08/2014
 */

/*Aim of this program
 *is to find some area related 
 *information of some geometric shapes
 */





import java.util.Scanner;
   


class shape
{
   
    double [][] p1=new double[4][2];
    public String point;
    double[][] p=new double[3][2];
    double area1;
    double area2;                       
    double area3; 
    double area4;
    double angle1;
    double angle2;
    double angle3;
    double angle4;
    public void getArea()
    {}
    public void getLargest()
    {}
    public void isInside()
    {   }
    
    
}




//Create a new Triangle class

class Triangle extends shape
{  


    int i=0;
    int j=0;
    double area;
    double m1;
    double m2;
    double m3;
    double total;                     // Total of the area of the three consecutive triangles; 
    double []sides=new double[3];     
    double a;
    double b;
    double c;
    double max;   // Maximum value of the angle  inside the triangle;
    
    //To read from user;
    Scanner in=new Scanner(System.in);
     
    // method to enter points and store them in 2D array;
    public void EnterPoint()
    {                                                                                                              
    System.out.println("Enter points in proper order");   
   

    for(i=0;i<3;i++)    
    {

     for(j=0;j<2;j++)
     {

       p[i][j]=in.nextInt();

      }

    }
    
    }
    
  //to get area of triangles

      public  void getArea()
      {
         for(int c=0;c<3;c++)
         {
            sides[c]=Math.sqrt((Math.pow((p[c][0]-p[(c+1)%3][0]),2))+Math.pow((p[c][1]-p[(c+1)%3][1]),2));
         }
         
         
         area=(p[0][0]*(p[1][1]-p[2][1])+p[1][0]*(p[2][1]-p[0][1])+p[2][0]*(p[0][1]-p[1][1]))/2;
         if(area<0)
          { 
            area=-area;
          }
         if(area==0)
      	 {
		System.out.println("Invalid input");
		EnterPoint();
	 }
	 else
         {
           System.out.println("It is a valid triangle");
           System.out.println();
           System.out.println("Area :"+area);
         }
      }
    

     //To get the largest angle inside the triangle;
      public void getLargestAngle()
      {
   
       m1=(p[1][1]-p[0][1])/(p[1][0]-p[0][0]);
       m2=(p[2][1]-p[1][1])/(p[2][0]-p[1][0]);
       m3=(p[0][1]-p[2][1])/(p[0][0]-p[2][0]);
       //find the angles between the sides of the triangle
      /* double l1=(m2-m1)/(1+m1*m2);
       double l2=(m3-m2)/(1+m3*m2);
       double l3=(m1-m3)/(1+m3*m1);
       */
       a=Math.pow((p[2][1]-p[1][1]),2)+Math.pow((p[2][0]-p[1][0]),2);
       b=Math.pow((p[2][1]-p[0][1]),2)+Math.pow((p[2][0]-p[0][0]),2);
       c=Math.pow((p[1][1]-p[0][1]),2)+Math.pow((p[1][0]-p[0][0]),2);
       double s=Math.sqrt(a);
       double t=Math.sqrt(b);
       double r=Math.sqrt(c);
       /*if(l1<0)
       {
        l1=-l1;
       }
         
       
       if(l2<0)
       {
         l2=-l2;
       }
         
       if(l3<0)
       {
         l3=-l3;
       }
       */

       double l1=(a*a+b*b-c*c)/(2*a*b);
        double l2=(b*b+c*c-a*a)/(2*b*c);
        double l3=(c*c+a*a-b*b)/(2*a*c);


        angle1=Math.toDegrees(Math.acos(l1));
        angle2=Math.toDegrees(Math.acos(l2));
        angle3=Math.toDegrees(Math.acos(l3));
        max=angle1;
      
  
       //compare three angles to find minimum value of the angle
       //so that we can find the maximum value of
        if(angle2>angle1)
        {
         max=angle2;
         System.out.println("Largest angle is the :"+max);
        }
        else if(angle3>angle1)
        {
         max=angle3; 
         System.out.println("Largest angle is the :"+max);
        }
        else
        {
         System.out.println("and Largest angle is the :"+max);
        }
      
      }


//Check whether a given point is inside the triangle or not?

      boolean isInside(double x,double y)
      {
        area1=((p[0][0]*p[1][1]-p[0][1]*p[1][0])+(p[1][0]*y-p[1][1]*x)+(x*p[0][1]-y*p[0][0]))/2;
        area2=(p[1][0]*p[2][1]-p[1][1]*p[2][0]+p[2][0]*y-p[2][1]*x+x*p[1][1]-y*p[1][0])/2;
        area3=(p[0][0]*p[2][1]-p[0][1]*p[2][0]+p[2][0]*y-p[2][1]*x+x*p[0][1]-y*p[0][0])/2;
       
        if(area1<0)
        {
        
          area1=-area1;
        }
        if(area2<0)
        {
         area2=-area2;
        }
        if(area3<0)
        {
          area3=-area3;
        }
        

        if(area1+area2+area3==area)
        {
          return true; 
        }
        else
        {
          return false; 
        }
      }
}



//This is Rectangle class which will handle the processes related to the rectangles;
class Rectangle extends shape
{   
   
    double length1;
    double length2;
    double length3;
    double length4;
    double area1;
    double area2;
    double area3;
    double area4;
    double m1;  // slope of the line of the rectangle
    double m2;  //slope of the other line of the same rectangle
    double m3;
    double m4;  // same for other lines also
    double area;
    String yes;
    //To read from user;
    Scanner in=new Scanner(System.in);
     
    // method to enter points and store them in 2D array;
    public void EnterPoint()
    {                                                                                                              
      System.out.println("Enter points in proper order");   
   

      for(int i=0;i<4;i++)    
      {

        for(int j=0;j<2;j++)
        {

         p1[i][j]=in.nextDouble();

        }
      }
    
     // Check whether the rectangle is valid or not?
     double x=(p1[0][0]+p1[1][0]+p1[2][0]+p1[3][0])/4;
     double y=(p[0][1]+p1[1][1]+p1[2][1]+p1[3][1])/4;
     m1=(p1[1][1]-p1[0][1])/(p1[1][0]-p1[0][0]);
     m2=(p1[2][1]-p1[1][1])/(p1[2][0]-p1[1][0]);
     m3=(p1[3][1]-p1[2][1])/(p1[3][0]-p1[3][0]);
     m4=(p1[3][1]-p1[0][1])/(p1[3][0]-p1[0][0]);
     length1=Math.pow((x-p1[0][0]),2)+Math.pow((y-p1[0][1]),2);
     length2=Math.pow((x-p1[1][0]),2)+Math.pow((y-p1[1][1]),2);
     length3=Math.pow((x-p1[2][0]),2)+Math.pow((y-p1[2][1]),2);
     length4=Math.pow((x-p1[3][0]),2)+Math.pow((y-p1[3][1]),2);
     if((length1==length2)&&(length2==length3)&&(length3==length4)&&(length4==length1))
     {
       
       System.out.println("It is a valid Rectangle");     
       getArea();
     }
     
     else
     {
       System.out.println("It is not a valid Rectangle shape"+" Try again");
       EnterPoint();   
     }
    

   }

  //a method to find the area of the rectangles geometries
  public void getArea()
  {
    area=0;
    length1=Math.sqrt((Math.pow((p1[1][0]-p1[0][0]),2))+Math.pow((p1[1][1]-p1[0][1]),2));
    length2=Math.sqrt((Math.pow((p1[2][0]-p1[1][0]),2))+Math.pow((p1[2][1]-p1[1][1]),2));  
    area=length1*length2;
    System.out.println("The area is :"+area+"unit"+" and the largest angle inside the Rectangle is 90 degree");
  }

  //Check whether a given point is inside the rectangles or not?
  boolean isInside(double x1,double y1)
  {
   
     
      area1=(p1[0][0]*(p1[1][1]-y1)+p1[1][0]*(y1-p1[0][1])+x1*(p1[0][1]-p1[1][1]))/2;
      area2=(x1*(p1[1][1]-p1[2][1])+p1[1][0]*(p1[2][1]-y1)+p1[2][0]*(y1-p1[1][1]))/2;
      area3=(x1*(p1[2][1]-p1[3][1])+p1[2][0]*(p1[3][1]-y1)+p1[3][0]*(y1-p1[2][1]))/2;
      area4=(x1*(p1[0][1]-p1[3][1])+p1[0][0]*(p1[3][1]-y1)+p1[3][0]*(y1-p1[0][1]))/2;
         if(area1<0)
         {
           area1=-area1;
         }
         else if(area2<0)
         {
           area2=-area2;
         }
         else if(area3<0)
         {
           area3=-area3;
         }
         else if(area4<0)
         {
           area4=-area4;
         }


       if((area1+area2+area3+area4)==area)
       {
        return true;
       }
       else
       {
        return false;
       }
  }
      
     
 
 
}



//Trapezoid class to find out the properties of the trapezoid geometrices

class Trapezoid extends shape
{

 double max;     //Maximum angle inside the given trapezoid.
 double m1;  // slope of the line of the trapezoid;
 double m2;  //slope of the other line of the same trapzoid;
 double m3;  //slope of the other line of the same trapzoid;
 double m4;  // same for other lines also;
 double area;//area of trapezoid;
 double l1;
 double l2;
 double l3;
 double l4;
 double x1;
 double y1;
 double d1;
 double d2;

 //input from the user;
 Scanner in=new Scanner(System.in); 
  //Method to find the area of the trapezoid;
  public void EnterPoint()
  { 
   System.out.println("Enter points in proper order");   
   
      //store co-ordinates points in a 2D array p1[4][2];
   for(int i=0;i<4;i++)    
   {

        for(int j=0;j<2;j++)
        {

         p1[i][j]=in.nextDouble();

        }
   }
         m1=(p1[1][1]-p1[0][1])/(p1[1][0]-p1[0][0]);
         m2=(p1[2][1]-p1[1][1])/(p1[2][0]-p1[1][0]);
         m3=(p1[3][1]-p1[2][1])/(p1[3][0]-p1[2][0]);
         m4=(p1[3][1]-p1[0][1])/(p1[3][0]-p1[0][0]);

          if(m1==m3)
          {
           System.out.println("It is a valid Trapezoid");
           
          }
          else if(m2==m4)
          {
           System.out.println("It is a valid Trapezoid");
           
          }
         else
         {
          System.out.println("It is not a valid Trapezoid");
          EnterPoint();
         }
   }
  
 //Method to find out the area of any trapezoid

 public void getArea()
 {
  
   area=((p1[0][0]*p1[1][1]-p1[0][1]*p1[1][0])+(p1[1][0]*p1[2][1]-p1[1][1]*p1[2][0])+(p1[2][0]*p1[3][1]-p1[2][1]*p1[3][0])+(p1[3][0]*p1[0][1]-p1[3][1]*p1[0][0]))/2;
  
   if(area<0)
   {
    area=-area;
    System.out.println("The area is :"+area+ " unit");
   }
   else
   {
     System.out.println("The area is:"+ area+" unit");
   }
  }

 //Check the point if it is inside the trapezoid or not?
 




 //  Get largest angle inside the trapezoid.
 public void getLargestAngle()
 {
   

       double a=Math.pow((p1[2][1]-p1[1][1]),2)+Math.pow((p1[2][0]-p1[1][0]),2);
       double b=Math.pow((p1[2][1]-p1[0][1]),2)+Math.pow((p1[2][0]-p1[0][0]),2);
       double c=Math.pow((p1[3][1]-p1[2][1]),2)+Math.pow((p1[2][0]-p1[3][0]),2);
       double d=Math.pow((p1[3][1]-p1[0][1]),2)+Math.pow((p1[3][0]=p1[0][0]),2);
       d1=Math.pow((p1[3][1]-p1[1][1]),2)+Math.pow((p1[3][0]-p1[1][0]),2);
       d2=Math.pow((p1[2][1]-p1[0][1]),2)+Math.pow((p1[2][0]-p1[0][0]),2);
       double q1=Math.sqrt(a);
       double q2=Math.sqrt(b);
       double q3=Math.sqrt(c);
       double q4=Math.sqrt(d);
       double q5=Math.sqrt(d1);
       double q6=Math.sqrt(d2);  
       
       l1=(d+a-d1)/(2*q4*q1);
       l2=(a+b-d2)/(2*q1*q2);
       l3=(c+b-d1)/(2*q2*q3);
       l4=(d+c-d2)/(2*q4*q3);


    angle1=Math.toDegrees(Math.acos(l1));
    angle2=Math.toDegrees(Math.atan(l2));
    angle3=Math.toDegrees(Math.atan(l3));
    angle4=Math.toDegrees(Math.atan(l4));

    max=angle1;
     
    //compare three angles to find minimum value of the angle
    //so that we can find the maximum value of
     if(angle2>angle1)
     {
         max=angle2;
         System.out.println("Largest angle is the :"+max);
     }
     else if(angle3>angle1)
     {
         max=angle3; 
         System.out.println("Largest angle is the :"+max);
     }
     else if(angle4>angle1)
     {
         max=angle4;
         System.out.println("and Largest angle is the :"+max);
     }
     else
     {
         System.out.println("and largest angle is :"+max);
         
     }
 }


 //Method isInside(x,y) will detect whether a given point is inside the trapezoid or not
 boolean isInside(double x1,double y1)
 {
  area1=p1[0][0]*(p1[1][1]-y1)+p1[1][0]*(y1-p1[0][1])+x1*(p1[0][1]-p1[1][1])/2;
  area2=p1[1][0]*(p1[2][1]-y1)+p1[2][0]*(y1-p1[1][1])+x1*(p1[1][1]-p1[2][1])/2;
  area3=p1[2][0]*(p1[3][1]-y1)+p1[3][0]*(y1-p1[2][1])+x1*(p1[2][1]-p1[3][1])/2;
  area4=p1[3][0]*(p1[0][1]-y1)+p1[0][0]*(y1-p1[3][1])+x1*(p1[3][1]-p1[0][1])/2;
  if(area1<0)
  {
   area1=-area1;
  }
  if(area2<0)
  {
   area2=-area2;
  }
  if(area3<0)
  {
   area3=-area3;
  }
 
  if((area1+area2+area3+area4)==area)
  {
   return false;
  }
  else
  {
   return true;
  }
 }

}


//Create a main class;
class assign4
{  

  public static void main(String[] args)
  { 
    char c;
    String check;
    String shapes;
    boolean tr=true;
    boolean trp1;
    Scanner in=new Scanner(System.in);
    
    System.out.println("Enter the type of shape");
    
    shapes=in.nextLine();
   
    //Check whether the shape is type of triangle or rectangle or trapezoid;
    if(shapes.equalsIgnoreCase("Triangle"))
    {
     
     Triangle t=new Triangle();
     t.EnterPoint();
     t.getArea();
     t.getLargestAngle();
      
     do{
       System.out.println("Do you want to check whether a point belongs to the shape(y/n)?");
       c=in.next().charAt(0);
      
        if(c=='y')
        {
         
           System.out.println("Enter a point");
           double x1=in.nextDouble();
           double y1=in.nextDouble();
           tr=t.isInside(x1,y1);

            if(tr==true)
            {
             System.out.println("The given point is inside the triangle");
            }
            else
            {
             System.out.println("The given point is outside the triangle");
     
            }
        }
       }while(c!='n');
          
    }
    
    //if we want to know the propeties of the Rectangles;
    else if(shapes.equalsIgnoreCase("Rectangle"))
    {
     Rectangle r=new Rectangle();
     r.EnterPoint();
	
     do{
     System.out.println("Do you want to check whether a point belongs to the shape(y/n)?");
     c=in.next().charAt(0);
     System.out.println(c);
    if(c=='y'){
    System.out.println("Enter a point");
    double x1=in.nextDouble();
    double y1=in.nextDouble();
     tr=r.isInside(x1,y1);

     if(tr==true)
     {
       System.out.println("The given point is inside the rectangle");
     }
     else
     {
       System.out.println("The given point is outside the rectangle");
     
     }
      }}
	while(c!='n');
    
    } 


   //if we want to have a knowledge about trapezoid and its properties
   else if(shapes.equalsIgnoreCase("Trapezoid"))
   {
    Trapezoid trp=new Trapezoid();
    trp.EnterPoint();
    trp.getLargestAngle();
    trp.getArea();
     do
     {
        System.out.println("Do you want to check whether a point belongs to the shape(y/n)?");
        c=in.next().charAt(0);
          if(c=='y')
          {    

                System.out.println("Enter a point");
                double x1=in.nextDouble();
                double y1=in.nextDouble();
                trp1=trp.isInside(x1,y1);

            if(trp1==true)
            {
                System.out.println("The given point is inside the trapezoid");
            }
            else
            {
               System.out.println("The given point is outside the trapezoid");
     
            }
         }
     }
	while(c!='n');

    }


     else
     {
       System.out.println("Try again.");
     }
         

   }
 }

