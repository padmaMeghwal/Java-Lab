/*Name:-Padma Ram Meghwal
 *Roll No.
 *1301CS30
 *Date of creation 04/10/2014
 */
//To generate background and to change position of any block.


import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
//main class

class assign6
{

 static int countBlock=0;
 static String i;
 public static void main(String[] args)
 {

   int j;
   int count=0;
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
   System.out.println("6:Rotate any block");
   System.out.println("7:Reposition of any block block");
   System.out.println("8:Change the character of any ");
   System.out.println("x:Exit");

   i=in.nextLine();
   switch(i){

    case "1":
    {
      System.out.println("Generating background\n");
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
    case "6":
     bk.Rotate_block();
     break;
    case "7":
     bk.Reposition();
     break;
    case "8":
     bk.Change_Character();
     break;
    default :
       //System.out.println("Not a valid input");
       break;
   }

} while(i.equalsIgnoreCase("x")!=true);
 }
}


//Create a new class
class Background
{
 int x=0;
 static int r1,r2,cl1,c2;
 static int []bw=new int[1000];
 static int []bh=new int[1000];
 static int []bT=new int[1000];
 static int []bL=new int[1000];
 static char[]bchar=new char[1000];
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
 System.out.println("Print the whole background with embedded blocks\n");
 for(int i=0;i<Height;i++)
 {
  for(int j=0;j<width;j++)
  {
   System.out.print(p[i][j]+" ");
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
          System.out.println("Block is added\n");
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
  boolean flag=false;
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
           flag=false;
         }
         else
         {
            flag=true;
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
}//DeleteRow_Column() method ends here.


 char [][]p1=new char[200][200];
 char [][]p2=new char[2000][2000];
//Create a method to swap to two blocks;
public void swap()
{

  int nc=1;
  int newcount= 0;
  int newcount1=0;
  boolean flag =false;
  boolean flag1=false;
  boolean flag3=false;
  boolean flag4=false;
  boolean flag5=false;
  boolean flag6=false;
  System.out.println("Enter block number of first block");
  int b1=in.nextInt();
  System.out.println("Enter block number of second block");
  int b2=in.nextInt();
  System.out.println("\n");
  int l1=bL[b1];
  int l2=bL[b2];
  int t1=bT[b1];
  int t2=bT[b2];
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
    r1  = (int)Math.ceil((double)bh[b1]/2);
    r2  = (int)Math.ceil((double)bh[b2]/2);
    cl1 = (int)Math.ceil((double)bw[b1]/2);
    c2  = (int)Math.ceil((double)bw[b2]/2);

 //if place available

 if((((c2-1)<=bL[b1])||((cl1-1)>=bL[b2])||((c2-1)>=bL[b1])||((cl1-1)<=bL[b2]))&&(((r1-1)>=bT[b1])||((r2-1)>=bT[b2])||((r1-1)<=bT[b1])||((r2-1)<=bT[b2])))
 {
  // if(((r1-1)>=bT[b1])||((r2-1)>=bT[b2])||((r1-1)<=bT[b1])||((r2-1)<=bT[b2]))
  // {


       r1  = (int)Math.ceil((double)bh[b1]/2)+bT[b1]-1;
       r2  = (int)Math.ceil((double)bh[b2]/2)+bT[b2]-1;
       cl1 = (int)Math.ceil((double)bw[b1]/2)+bL[b1]-1;
       c2  = (int)Math.ceil((double)bw[b2]/2)+bL[b2]-1;
       for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
       {
         for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
         {
           p[i][j]=c;

         }
       }

       for(int i=bT[b2];i<(bT[b2]+bh[b2]);i++)
       {
         for(int j=bL[b2];j<(bL[b2]+bw[b2]);j++)
         {
           p[i][j]=c;

         }
       }


       //New attributes after swapping two blocks;
       bT[b1]= r2-(int)Math.ceil((double)bh[b1]/2)+1;
       bT[b2]= r1-(int)Math.ceil((double)bh[b2]/2)+1;
       bL[b1]= c2-(int)Math.ceil((double)bw[b1]/2)+1;
       bL[b2]=cl1-(int)Math.ceil((double)bw[b2]/2)+1;

       for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
       {
         for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
         {
           if((bT[b1]>=0)&&(bL[b1]>=0)&&(i<=Height)&&(j<=width))
           {
             if(p[i][j]==c)
             {
               newcount=newcount+nc;
             }
           }
           else
           {
              flag5=true;
              break;
           }
         }
           if(flag5==true)
           {
             break;
           }
       }

       for(int i1=bT[b2];i1<(bT[b2]+bh[b2]);i1++)
       {
         for(int j1=bL[b2];j1<bL[b2]+bw[b2];j1++)
         {
           if(bT[b2]>=0&&bL[b2]>=0&&i1<=Height&&j1<=width)
           {
              if(p[i1][j1]==c)
              {
                 newcount1=newcount1+nc;
              }
           }
           else
           {
                 flag6=false;
                 break;
           }
         }
         if(flag6==true)
         {
             break;
         }
       }

        if((newcount==bw[b1]*bh[b1])&&(newcount1==bw[b2]*bh[b2]))
        {


         for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
         {
           for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
           {
              if(bL[b1]>=0&&bL[b2]>=0&&bT[b1]>=0&&bT[b2]>=0)
              {
                 flag3=true;
              }
              else
              {
                flag1=true;
                break;
              }
           }
           if(flag1==true)
           {
             break;
           }
         }
         for(int k=bT[b2];k<(bT[b2]+bh[b2]);k++)
         {
           for(int l=bL[b2];l<(bL[b2]+bw[b2]);l++)
           {
                 if(bL[b1]>=0&&bL[b2]>=0&&bT[b1]>=0&&bT[b2]>=0)
                 {
                     flag4=true;
                 }
                 else
                 {
                    flag=true;
                    break;
                 }
           }
            if(flag==true)
            {
              break;
            }
         }

       }
       else
       {
          //write again blocks.
          bL[b1]=l1;
          bL[b2]=l2;
          bT[b1]=t1;
          bT[b2]=t2;
          for(int m1=bT[b1];m1<(bT[b1]+bh[b1]);m1++)
          {
             for(int n1=bL[b1];n1<(bL[b1]+bw[b1]);n1++)
             {
                p[m1][n1]=p1[m1-bT[b1]][n1-bL[b1]];
             }
          }
          for(int m2=bT[b2];m2<(bT[b2]+bh[b2]);m2++)
          {
             for(int n2=bL[b2];n2<(bL[b2]+bw[b2]);n2++)
             {
                p[m2][n2]=p2[m2-bT[b2]][n2-bL[b2]];
             }
          }
          System.out.println("*****Blocks cannot be overlapped*****\n");
       }
   //}
 }
 else
 {
   //write some codes to print again.
          bL[b1]=l1;
          bL[b2]=l2;
          bT[b1]=t1;
          bT[b2]=t2;
          for(int m1=bT[b1];m1<(bT[b1]+bh[b1]);m1++)
          {
             for(int n1=bL[b1];n1<(bL[b1]+bw[b1]);n1++)
             {
                p[m1][n1]=p1[m1-bT[b1]][n1-bL[b1]];
             }
          }
          for(int m2=bT[b2];m2<(bT[b2]+bh[b2]);m2++)
          {
             for(int n2=bL[b2];n2<(bL[b2]+bw[b2]);n2++)
             {
                p[m2][n2]=p2[m2-bT[b2]][n2-bL[b2]];
             }
          }
          System.out.println("*****Blocks cannot be swapped*****");
 }
  //if all apropriate conditions satisfy
  if((flag3==true)&&(flag4==true))
  {
         for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
         {
           for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
           {
                 p[i][j]=p1[i-bT[b1]][j-bL[b1]];
           }
         }
         for(int k=bT[b2];k<(bT[b2]+bh[b2]);k++)
         {
           for(int l=bL[b2];l<(bL[b2]+bw[b2]);l++)
           {
              p[k][l]=p2[(k-bT[b2])][(l-bL[b2])];
           }
         }
  }
  else
  {
          bL[b1]=l1;
          bL[b2]=l2;
          bT[b1]=t1;
          bT[b2]=t2;
          for(int m1=bT[b1];m1<(bT[b1]+bh[b1]);m1++)
          {
             for(int n1=bL[b1];n1<(bL[b1]+bw[b1]);n1++)
             {
                p[m1][n1]=p1[m1-bT[b1]][n1-bL[b1]];
             }
          }
          for(int m2=bT[b2];m2<(bT[b2]+bh[b2]);m2++)
          {
             for(int n2=bL[b2];n2<(bL[b2]+bw[b2]);n2++)
             {
                p[m2][n2]=p2[m2-bT[b2]][n2-bL[b2]];
             }
          }
          System.out.println("*****Blocks cannot be swapped*****");
  }


  if(flag5==true||flag6==true)
  {
          bL[b1]=l1;
          bL[b2]=l2;
          bT[b1]=t1;
          bT[b2]=t2;
          for(int m1=bT[b1];m1<(bT[b1]+bh[b1]);m1++)
          {
             for(int n1=bL[b1];n1<(bL[b1]+bw[b1]);n1++)
             {
                p[m1][n1]=p1[m1-bT[b1]][n1-bL[b1]];
             }
          }
          for(int m2=bT[b2];m2<(bT[b2]+bh[b2]);m2++)
          {
             for(int n2=bL[b2];n2<(bL[b2]+bw[b2]);n2++)
             {
                p[m2][n2]=p2[m2-bT[b2]][n2-bL[b2]];
             }
          }
          System.out.println("*****Blocks cannot be swapped*****");
  }
 }//Ends method swap() here.\

 //find character of any perticular block;
 public char char_find(int b1)
 {


  if(bh[b1]==1)
  {
     bchar[0]=p[bT[b1]][bL[b1]+1];
     char bch=bchar[0];
     return bch;
  }
  else if(bw[b1]==1)
  {
     bchar[0]=p[bT[b1]+1][bL[b1]];
     char bch=bchar[0];
     return bch;
  }
  else
  {
    bchar[0]=p[bT[b1]][bL[b1]+1];
    char bch=bchar[0];
    return bch;
  }

 }



 //Check space to rotate any block;
 public boolean Check(int b1,char bch,char seq)
 {
   int y1=bT[b1];
   int t=r1+(bL[b1]-cl1);
   int l=cl1-(y1+bh[b1]-r1-1);
   int cnt=0;
   int cnt1=1;


    for(int i1=bT[b1];i1<(bT[b1]+bh[b1]);i1++)
    {
      for(int j1=bL[b1];j1<(bL[b1]+bw[b1]);j1++)
      {
         p[i1][j1]=c;
      }
    }

    for(int i=t;i<(t+bw[b1]);i++)
    {
     for(int j=l;j<(l+bh[b1]);j++)
     {
       if(p[i][j]==c)
       {
         cnt=cnt+cnt1;
       }
     }
    }

    if(cnt==(bh[b1])*(bw[b1]))
    {
       return true;
    }




    else
    {
     for(int i2=bT[b1];i2<(bT[b1]+bh[b1]);i2++)
     {
      for(int j2=bL[b1];j2<(bL[b1]+bw[b1]);j2++)
      {
         p[i2][j2]=bch;
         if(i2==bT[b1]&&j2==bL[b1])
         {
           p[i2][j2]=seq;
         }

      }
     }
        return false;
   }

}



 //Create a method to rotate any block by 90 degree around it's center;
 public void Rotate_block()
 {
   boolean yes=false;
   System.out.println("Enter the block number of block ");
   int b1=in.nextInt();
   char bch= char_find(b1);
   char seq_no1=(char)(b1+48);
   r1  = (int)Math.ceil((double)bh[b1]/2)+bT[b1]-1;
   cl1 = (int)Math.ceil((double)bw[b1]/2)+bL[b1]-1;
   int x1=bL[b1];
   int y1=bT[b1];
   int t=r1+(bL[b1]-cl1);
   int l=cl1-(y1+bh[b1]-r1-1);
   if(t>=0&&l>=0)
   {
      yes =Check(b1,bch,seq_no1);
   }

   if(yes==true)
   {
     for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
     {
       for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
       {
         p[i][j]=c;
       }
     }

      bT[b1]=r1+(bL[b1]-cl1);
      bL[b1]=cl1-(y1+bh[b1]-r1-1);
      for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
      {
        for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
        {
          p[i][j]=bch;
        }
      }
       p[bT[b1]][bL[b1]]=seq_no1;

   }
   else
   {
     System.out.println("***********************\n");
     System.out.println("Block cannot be rotated\n");
     System.out.println("***********************\n");
   }



 }


 //Check space for reposition of any block;
 public void Check_Reposition(char bch,int b1,int x,int l)
 {
  int seq=0;
  char c1=(char)(b1+48);
  int cnt=0;
  int cnt1=1;
  char sq='0';
  boolean flag5=false;
  boolean f2=false;
  boolean flag2=false;
  boolean flag=false;
  boolean flag1=true;
  boolean flag4=false;
  boolean exceed=false;
  for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
  {
    for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
    {
     p[i][j]=c;
    }
  }

  for(int i1=0;i1<(bT[b1]+bh[b1]);i1++)
  {
    for(int j1=bL[b1]+x;j1<(bL[b1]+x+bw[b1]);j1++)
    {
      if(p[i1][j1]!=c)
      {
          sq=p[i1][j1];
          flag=false;
          flag2=true;
          break;
      }
      else
      {
          flag=true;
          flag2=false;

      }

    }
    if(flag2==true)
    {
          break;
    }
  }

   if(flag==true)
   {
     for(int d1=bT[b1];d1<(bT[b1]+bh[b1]);d1++)
     {
       for(int d2=l;d2<(l+bw[b1]);d2++)
       {
         p[d1][d2]=bch;
       }
     }
      p[bT[b1]][l]=c1;
      bL[b1]=bL[b1]+x;;
   }
  boolean loop=false;
  if(flag2==true)//Check for next block;
  {
   while(loop==false)
   {
    seq=(int)(sq-48);
    if((width-bL[b1]-bw[b1])>=bw[b1]&&bL[seq]+bw[seq]+bw[b1]<=width)
    {

    for(int d=0;d<(bT[b1]+bh[b1]);d++)
    {
      for(int h=bL[seq]+bw[seq];h<(bL[seq]+bw[seq]+bw[b1]);h++)
      {
        if(p[d][h]!=c)
        {
          sq=p[d][h];
          f2=true;
          loop=false;
          flag4=false;
          break;
        }

        else
        {
          loop=true;
          flag4=true;
        }
      }
      if(f2==true)
      {
        break;
      }
     }
    }
    else
    {
     flag5=true;
     break;
    }
   } //ends while loop


  }

   if(flag5==true)
   {
        for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
        {
         for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
         {
           p[i][j]=bch;
         }
        }
        p[bT[b1]][bL[b1]]=c1;
        System.out.println("**********************************************\n");
        System.out.println("*******Blcok cannot be transfered*************\n");
   }

   if(flag4==true)
   {
    for(int m=bT[b1];m<(bT[b1]+bh[b1]);m++)
    {
       for(int n=bL[seq]+bw[seq];n<(bL[seq]+bw[seq]+bw[b1]);n++)
       {
         p[m][n]=bch;
       }
    }
    p[(bT[b1])][(bL[seq]+bw[seq])]=c1;
    bL[b1]=bL[seq]+bw[seq];
   }

}//Check_Rposition() method ends here;

 //Reposition any block;
 public void Reposition()
 {
    boolean yes=false;
    int d=0;
    int count1=0;
    int count2=1;
    int b1;
    char sq=0;
    System.out.println("Enter the block number");
    b1=in.nextInt();
    System.out.println("Enter the number of cells to reposition the block");
    int x=in.nextInt();
    int l=bL[b1]+x;
    char char1=char_find(b1);
    if((width-l-bw[b1])>=0)
    {
         Check_Reposition(char1,b1,x,l);
    }
    else
    {
         System.out.println("**********************************************\n");
         System.out.println("*******Blcok cannot be transfered*************\n");
    }
 }//Reposition method ends here.


  //Method for changing the chaaracters of any block.
  public void Change_Character()
  {
    int b1;
    char num=97;
    char char1;
    char ch;
    System.out.println("");
    System.out.println("Enter the block number of block");
    b1=in.nextInt();
    System.out.println("\n");
    char b2=(char)(b1+48);
    System.out.println("Enter background character");
    char1=in.next().charAt(0);
    System.out.println("\n");
    ch=Random1(char1);
    for(int i=0;i<Height;i++)
    {
      for(int j=0;j<width;j++)
      {
        if((p[i][j]==char1))
        {
           p[i][j]=ch;
        }
      }
    }
    for(int i=bT[b1];i<(bT[b1]+bh[b1]);i++)
    {
      for(int j=bL[b1];j<(bL[b1]+bw[b1]);j++)
      {
        p[i][j]=char1;
      }
    }
     p[bT[b1]][bL[b1]]=b2;


  }//Method Change_Character() ends here.

 //Method to create random character.
 public char Random1(char char1)
 {
   Random rand=new Random();
   int y=rand.nextInt(26)+97;
   char ch =(char)(y);
   for(int i=0;i<Height;i++)
   {
     for(int j=0;j<width;j++)
     {
       if(p[i][j]==ch)
       {
          Random1(char1);
       }
       else
       {
         return ch;
       }
     }
   }
   return ch;
 }//Method Random() ends here.
}//Background class ends here.
