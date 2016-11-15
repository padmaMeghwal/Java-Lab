/*
 *Name:-Padma Ram Meg 
 *Roll No:-1301CS30
 *Date of creation:-20/10/2014
 *
 */
//Aim:-Create a Binary tree and do some operation upon it.
import java.util.Scanner;
import java.util.*;
class Node
{
  int data;
  Node left;
  Node right;
 
  public Node()
  {
  }
  public Node(int data)
  {
     this.data=data;
  }
}

//New class BinaryTree

class BinaryTree
{
  Node root;
 
  //Method add() to add Nodes in a Binary tree.
  public void add(int data) 
  {
    Node node=new Node(data);
    if(root==null)
    {
       root=node;
    }
    
    Traverse(root,node);
  }//Method add() ends here;

  //Traverse()
  private void Traverse(Node traverse,Node node)
  {
   if(node.data<traverse.data)
   {
      if(traverse.left==null)
      {
          traverse.left=node;
      }
      else
      {
         Traverse(traverse.left,node);
      }
   }
   else if(node.data>traverse.data)
   {  
      if(traverse.right==null)      
      {
         traverse.right=node;
      }
      else
      {
         Traverse(traverse.right,node);
      }
   }  
  }//Traverse() method here.

  //Method Traverse
  public void Traversal()
  {
     if(root!=null)
     {
         Node nodeTraverse=root;
         
         if(nodeTraverse.left==null&&nodeTraverse.right==null)
         {
            System.out.println(nodeTraverse.data);
         }
         else
         {
              
                   System.out.println("*****************************");
                   System.out.println("*****In order traversal :****\n");
                   inOrder(nodeTraverse);
         }
     }
     
  }
  //Method to display inOrder Binary Tree;
  private void inOrder(Node node)
  {
     
     if(node.left!=null)
     {
         inOrder(node.left);
     }

      System.out.println(node.data);

     if(node.right!=null)
     {
         inOrder(node.right);
     }     
  }
}//BinaryTree class ends here.

//Main class 
public class assign8
{
 public static void main(String[] args)
 {
    int data;
    char c;
    Scanner in = new Scanner(System.in);
    BinaryTree tree = new BinaryTree();

    do
    {
      System.out.println("Do you want to add node type y/n (use only small letters)");
      c=in.next().charAt(0);
      if(c=='y')
      {
           System.out.println("Enter node character");
           data=in.nextInt();
           tree.add(data);
           System.out.println();
      }
      
    }while(c!='n');
    System.out.println();
    System.out.println();
    tree.Traversal();
    System.out.println(); 
    System.out.println("*****************************");
    System.out.println("*****************************");
 }//main method ends here.
}//main class ends here.  

