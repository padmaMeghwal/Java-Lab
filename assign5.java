/*Name:-Padma Ram
 *Roll No.
 *1301CS30
 *Date of creation 06/09/2014
 */
//To generate background and put block into it


import java.util.Scanner;
import java.util.ArrayList;
//main class 

class assign5
{
	
 static int countBlock=0;
 static String i;
 public static void main(String[] args)
 {
   
   int j;
   int count=1;
   int H=0;
   int w=0;
   String c;
   
   Scanner in=new Scanner(System.in);   // input from user
   Background bk = null;     //Create object of Background.
  
 
 //do while loop;
   do{
   System.out.println("Enter choice:");
   System.out.println("1:Generate Background");
   System.out.println("2:Add Block");
   System.out.println("3:Print");
   System.out.println("4:Delete a row/column from a block");
   System.out.println("5:Swap two blocks");
   System.out.println("x:Exit");
   
   i=in.nextLine();
   switch(i){

    case "1":
    {
      System.out.println("Generating background");
      System.out.println("Enter Height");
      H=in.nextInt();
      System.out.println("Enter width");
      w=in.nextInt();
      System.out.println("Enter character ");
      c=in.next();   
      bk=new Background(H,w,c.charAt(0)); 
      System.out.println("Background is created");
      System.out.println();
      bk.createBack();
      break;
    }
    case "2":
     
      bk.AddBlock(count);
      break;

    case "3":
    
    
      bk.print();
      break;
    
    case "4":
     
      bk.DeleteRow_Column();
      
      break;
    case "x":
    
     System.out.println();
     System.out.println("Succesful exit");
     System.out.println();
     break;
    case "5":
     
     bk.swap();
     break;
 
    default :
       //System.out.println("Not a valid input");
       break;
   }
 
} while(i.equalsIgnoreCase("x")!=true);
 }
};


//Create a new class
class Background 
{
 int x=0;
 int r1,r2,cl1,c2;
 static int []bw=new int[1000];
 static int []bh=new int[1000];
 static int []bT=new int[1000];
 static int []bL=new int[1000];
 //input from user
 Scanner in=new Scanner(System.in); 
 //Define 2D array
 int width,Height;
 int widthb;
 int Heightb;
 char c;
 int i,j;
 int Top;
 int Left;
 char s;
 char count;
 static int counter=1;
 char counter1;
 char [][] p ;
 int l;
 int row;
 int column;
 static int seq_no;
 char c1;
 static int countert=0;
  
 //Constructor Background;
 public Background(int H,int w,char c1)
 {
 Height=H;
 width=w;
 c=c1;
 this.p = new char[Height][width];


   for(int r=0;r<100;r++)
   {
     this.bw[r]=0;
     this.bh[r]=0;
     this.bT[r]=0;
     this.bL[r]=0;
   }
     bw[0]=0;
     bh[0]=0;
     bL[0]=0;
     bT[0]=0;
 }
 
  //Create background method to create a background for blocks;
 public void createBack()
 {
  
  
  for(i=0;i<Height;i++)
  {
   for(j=0;j<width;j++)
   { 
   	p[i][j]=c;
   }
  }
    
 }

//Print a background with blocks
public void print()
{

 System.out.println();
 System.out.println("Print the whole background with embedded blocks");
 for(int i=0;i<Height;i++)
 {
  for(int j=0;j<width;j++)
  {
   System.out.print(p[i][j]);
  }
	System.out.println();
 }
  
}



 
 //Add blocks on backgorund;
 public void AddBlock(int counter2)
 {  
   System.out.println("Adding a block");
   boolean tr1=false;
   boolean tr=false;
   int newcount=0;
   int nc=1;
   System.out.println("Enter Left");
   Left=in.nextInt();
   System.out.println("Enter Top");
   Top=in.nextInt();
   System.out.println("Enter Width of the block");
   widthb=in.nextInt();
  
   System.out.print("Enter height of the block");
   System.out.println();
   Heightb=in.nextInt();
   System.out.println("Enter Block character");
   s=in.next().charAt(0);
   count=Integer.toString(counter).charAt(0);
   if(((Top+Heightb)<=Height)&&((Left+widthb)<=width))
   {
    for(int m=Top;m<(Top+Heightb);m++) 
    {
      for(int n=Left;n<(Left+widthb);n++)
      {
       if(p[m][n]==c)
       {
        
        newcount=newcount+nc;
 
       }

      }
 
   }

        if(widthb*Heightb==newcount)
        {
        
         for(int m=Top;m<(Top+Heightb);m++) 
         {
          for(int n=Left;n<(Left+widthb);n++)
          {
      //     count=Integer.toString(counter).charAt(0);
           
           
           bw[counter]=widthb;
           bh[counter]=Heightb;
           bT[counter]=Top;
           bL[counter]=Left;
           p[m][n]=s;
           
           if((m==Top)&&(n==Left))
           {
             p[m][n]=count;    
           }
           }counter2++;
       }


          System.out.println();
          System.out.println("Block is added");
        counter++;
       
      }
      
      else 
      {  
        System.out.println();
        System.out.println("Blocks cannot be overlapped");
        System.out.println();
      }

       }
      
       else
       {
         
         System.out.println("Blocks cannot be created ");
         // counter--;
       }
   
      
 }



public void  DeleteRow_Column()
{
 
  System.out.println("Deleting a row/column from a block");

  System.out.println("Enter sequential number to delete a row or column of that block");
  seq_no=in.nextInt();
  char g= Integer.toString(seq_no).charAt(0);  
  System.out.println("Enter row(1) Or column(2)");
  l=in.nextInt();
           
  switch(l)
  {

   case 1:
   
    System.out.println("Enter the row which will be deleted");
    row=in.nextInt();
    for(int i=0;i<Height;i++)
    {
     for(int j=0;j<width;j++)
     {
      if(p[i][j]==g)
      {  

         if(bh[seq_no]==1)
         {
           for(int y=(bL[seq_no]);y<(bL[seq_no]+bw[seq_no]);y++)
           { 
              p[i+row-1][y]=c;

             


           }
            
          
             System.out.println("Enter the character of the newly created block");
             s=in.next().charAt(0);
             for(int y=(i+row);y<(bT[seq_no]+bh[seq_no]);y++)
             {
              for(int w=j;w<(bL[seq_no]+bw[seq_no]);w++)
              {
                p[y][w]=s;
              }
             }


              bT[counter]=(bT[counter-1]+row);
              bL[counter]=bL[counter-1];
              bw[counter]=bw[counter-1];
              bh[counter]=(bh[counter-1]-row);
 
              counter--;
             
             // p[i+row][j]=(char)((counter-1)+48);
            
         
              System.out.println("Block as well as row is deleted");
              System.out.println("Deletion is complete");


         }

      

      
          else 
          {
           for(int y=(bL[seq_no]);y<(bL[seq_no]+bw[seq_no]);y++)
           { 
              p[i+row-1][y]=c;


           }
            
          
              System.out.println("Enter the character of the newly created block");
              s=in.next().charAt(0);
               
              for(int y=(i+row);y<(bT[seq_no]+bh[seq_no]);y++)
              {
               for(int w=j;w<(bL[seq_no]+bw[seq_no]);w++)
               {
                 p[y][w]=s;
               }
              }

           
              bT[counter]=(bT[counter-1]+row);
              bL[counter]=bL[counter-1];
              bw[counter]=bw[counter-1];
              bh[counter]=(bh[counter-1]-row);
              bT[seq_no]=bT[counter-1];
              bL[seq_no]=bL[counter-1];
              bw[seq_no]=bw[counter-1];
              bh[seq_no]=(bh[counter-1]-bh[counter]-1);
              counter++; 
             
             
             if(p[i+row][j]==c)
             {
              
             }
             else
             {
             
              
               p[i+row][j]=(char)((counter-1)+48);
              }
              System.out.println("Row is deleted");
              System.out.println("Deletion is complete");
              
             }
         
             
         }    
              
      }
      
     }
     
              
    

  break;




   case 2:
   
    System.out.println("Enter a column which will be deleted  ");
    column=in.nextInt();
    for(int i=0;i<Height;i++)
    {
     for(int j=0;j<width;j++)
     {
      if(p[i][j]==g)
      {  
         if((bh[seq_no]==1))
         {

           for(int c3=(bT[seq_no]);c3<(bT[seq_no]+bh[seq_no]);c3++)
           { 
            p[c3][j+column-1]=c;
           }
            System.out.println("Column is deleted");  
            System.out.println();
            System.out.println("Enter the character of the newly created block"); 
            char s3=in.next().charAt(0);
           for(int h=i;h<(bT[seq_no]+bh[seq_no]);h++)
           {
            for(int k=(j+column);k<(bL[seq_no]+bw[seq_no]);k++)
            {
            p[h][k]=s3;

            
            }
           }
              bT[counter]=bT[seq_no];
              bL[counter]=bL[seq_no]+column;
              bw[counter]=bw[seq_no]-column;
              bh[counter]=bh[seq_no];
              bT[seq_no]=bT[seq_no];
              bL[seq_no]=bL[seq_no];
              bw[seq_no]=(bw[seq_no]-bw[counter]-1);
              bh[seq_no]=bh[seq_no];




 
              counter++;
            
              p[i][j+column]=(char)((counter-1)+48);
 
              System.out.println("Column is deleted");
 
         }
         

         else if((bw[seq_no]==1)&&(column==1))          
         {
           System.out.println("Column as well as block is deleted");
        
           
            for(int q2=bT[seq_no];q2<=(bT[seq_no]+bh[seq_no]);q2++)  
            {
              
              
               p[q2][j]=c; 
             
              
            }
             




            --counter;  


          }   
          
     
         else 
         {  
           for(int z=(bT[seq_no]);z<(bT[seq_no]+bh[seq_no]);z++)
           {
             p[z][j+column-1]=c;
           }
             System.out.println("Enter the character of the newly created block");
             s=in.next().charAt(0);
             for(int c1=i;c1<(bT[seq_no]+bh[seq_no]);c1++)
             {
              for(int b1=(j+column);b1<(bL[seq_no]+bw[seq_no]);b1++)
              {
                p[c1][b1]=s;
              }
             }


              bT[counter]=bT[counter-1];
              bL[counter]=bL[counter-1]+column;
              bw[counter]=bw[counter-1]-column;
              bh[counter]=bh[counter-1];
              bT[seq_no]=bT[seq_no];
              bL[seq_no]=bL[seq_no];
              bw[seq_no]=(bw[seq_no]-bw[counter]-1);
              bh[seq_no]=bh[seq_no];
              counter++;
 
            if(p[i][j+column]==c)
            {}
            else
            {
             p[i][j+column]=(char)((counter-1)+48);
            }

         }  
         }
  
      }



   }


break;

  }
}

 char [][]p1=new char[200][200];
 char [][]p2=new char[2000][2000];
//Create a method to swap to two blocks;
public void swap()
{
  System.out.println("Enter block number of first block");
  int b1=in.nextInt();
  System.out.println("Enter block number of second block");
  int b2=in.nextInt();
  for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
  {
   for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
   {
     
       p1[i-bT[b1]][j-bL[b1]]=p[i][j];
      
   }
  }
  for(int i=bT[b2];i<(bT[b2]+bh[b2]);i++)
  {
   for(int j=bL[b2];j<(bL[b2]+bw[b2]);j++)
   {
     p2[i-bT[b2]][j-bL[b2]]=p[i][j];
   }
  }
   
   System.out.println();
  
  if(bh[b1]%2==0)
  {
    r1=bh[b1]/2;
  }
  if(bh[b2]%2==0)
  {
    r2=bh[b2]/2;
  }
  if(bw[b1]%2==0)
  {
     cl1=bw[b1]/2;
  }
  if(bw[b2]%2==0)
  {
    c2=bw[b2]/2; 
  }
  else
  {
    r1=(bh[b1]/2)+1;
    r2=(bh[b2]/2)+1;
    cl1=(bw[b1]/2)+1;
    c2=(bw[b2]/2)+1;
  }


 //if place available
 
 if(((c2-1)<=bL[b1])||((cl1-1)>=bL[b2])||((c2-1)>=bL[b1])||((cl1-1)<=bL[b2]))
 {
   if(((r1-1)>=bT[b1])||((r2-1)>=bT[b2])||((r1-1)<=bT[b1])||((r2-1)<=bT[b2]))
    {     
     if((r1==r2)&&(cl1==c2))    
     {
        for(int i=bT[b1];i<(bT[b1]+bh[b2]);i++)
        {
         for(int j=bL[b1];j<(bL[b1]+bw[b2]);j++)
         {
          p[i][j]=p2[i-bT[b1]][j-bL[b1]];       
         
         }
        }
          
        for(int i=bT[b2];i<(bT[b2]+bh[b1]);i++)
        {
         for(int j=bL[b2];j<(bL[b2]+bw[b1]);j++)
         {
          p[i][j]=p1[i-bT[b2]][j-bL[b2]];
         }
        }
          int[]b=new int[200];  
          b[0]=bT[b1];
          bT[b1]=bT[b2];
          bT[b2]=b[0];
          int[]a=new int[200];
          a[0] =bL[b1];
          bL[b1]=bL[b2];
          bL[b2]=a[0];
 System.out.println();
 System.out.println();
 System.out.println("Passed");
 System.out.println();
 System.out.println();

     }
     else if(cl1==c2)
     {

      
       for(int i=(bT[b1]+r2-1);i<(bT[b1]+r2-1+bh[b2]);i++)
       {
        for(int j=bL[b1];j<(bL[b1]+bw[b2]);j++)
        {
          p[i][j]=p2[i-(bT[b1]+r2-1)][j-bL[b1]];
        }
     }
    } 
 }
 else
 {
   System.out.println("Blocks cannot be swapped");
 }
 
 
}

}
}














 

   


