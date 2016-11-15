/*
 *Name:-Padma Ram Meg
 *Roll No:-1301CS30
 *Date of creation:-
 *01/11/2014
 */
 
//Aim:-To create a binary search to store,delete,find the detail and for some basic operation of  employee's database .

import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class assign9
{
   public static void main(String[] args)
   {
   	Scanner in=new Scanner(System.in);
   	Binarytree tree=new Binarytree();
   	int i;
   	do
   	{
    	    System.out.println("Enter choice");
    	    System.out.println("1:add new employee");
    	    System.out.println("2:Display the record of an employee");
    	    System.out.println("3:Display all records present in the database");
    	    System.out.println("4:Print levelorder");
    	    System.out.println("5:Delete any node");
    	    System.out.println("6:exit");
   	  
   	  
            System.out.println();
   	    i=in.nextInt();
   	  
   	    switch(i)
   	    {
   		case 1:
   	  		tree.add();
   	  		break;
   	  	case 2:
   	  		if(tree.root!=null)
   	  		{
   	  			tree.display();
   	  			break;
   	  		}
   	  		else
   	  		{
   	  			System.out.println("\n\nBinary tree does not exist\n\n");
   	  			in.nextLine();
   	  			break;
   	  		}
   	  	case 3:
   	  		if(tree.root!=null)
			{
   	  			System.out.println("All records of employees present in database are :");
   	  			tree.Display(tree.root);
   	  			break;
   	  		}
   	  		else
   	  		{
   	  			System.out.println("\n\nBinary tree does not exist\n\n");
   	  			break;
   	  		}
   	  	case 4:
   	  		if(tree.root!=null)
   	  		{
   	  			tree.levelorder();
   	  			break;
   	  		}
   	  		else
   	  		{
   	  			System.out.println("\n\nBinary tree does not exist\n\n");
   	  			break;	
   	  		}
   	  	case 6:
   	  		System.out.println("Successfully exit\n\n");
   	  		break;
   	  	case 5:
   	  		if(tree.root!=null)
   	  		{
   	  			tree.Delete();
   	  			break;
   	  		}
   	  		else
   	  		{
   	  			System.out.println("\n\nBinary tree does not exist\n\n");
   	  			break;
   	  		}
   	  	default:
   	  		System.out.println("INVALID input");
   	  		break;
   	  }
   	}while(i!=6);
   }    //Main method ends here.
}   //Main class ends here.

//New class Node
class Node
{
	Node left;
	Node right;
	Node parent;
	int emp;
	String name;
	String sex;
	int age;
	int emp1;
	//costructor	
	public Node()
	{
	
	}
	public Node(int emp,String name,String sex,int age)
	{		
		this.emp=emp;
		this.name=name;
		this.sex=sex;
		this.age=age;
		
	}
}//Node class ends here.	

//New class Binarytee
class Binarytree
{
	Scanner in=new Scanner(System.in);
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int m=0;
	static int n=0;
	int emp;
	String name;
	String sex;
	int age;
	Node root;
	Node curr=new Node();;
	public void empid()
	{
		Random rand=new Random();
   	        emp=rand.nextInt(8999)+1000;
	}
	//Method add() for adding new nodes in Binary search tree.
	public void add()
	{
		empid();
		System.out.println("Enter name of the employee");
		name=in.nextLine();
		System.out.println("Enter sex of the employee");	
		sex=in.nextLine();
		System.out.println("Enter age of the employee");
		age=in.nextInt();
		Node nodeToadd=new Node(emp,name,sex,age);
		in.nextLine();
		if(root==null) //if Binary search tree is empty. 
		{
			root=nodeToadd;				
		}
		traverse(root,nodeToadd);	
	}
	private void traverse(Node node,Node nodeToadd)
	{
		if(emp<node.emp)
		{
			if(node.left==null) //if left child of any node is null.
			{
				nodeToadd.parent=node;
				node.left=nodeToadd;
			}
			else
			{
				traverse(node.left,nodeToadd); //if left child is non empty.
			}
		}
		else if(emp>node.emp)
		{
			if(node.right==null) //if right child of any node is null.
			{
				nodeToadd.parent=node;
				node.right=nodeToadd;
			}
			else
			{
				traverse(node.right,nodeToadd);//if right child is non empty.
			} 
		}
	}//Method traverse() ends here.
	
	//Method to display record of an employee.
	public void display()
	{
		int emp_number;
		boolean flag=false;
		System.out.println();
		System.out.println("Added emp number in database:");
		System.out.println();
		System.out.println("Enter emp number of any employee which is printed above");
		emp_number=in.nextInt();
		Node searchnode=searchNode(root,emp_number);
		in.nextLine();
		if(searchnode!=null)
		{
			print(searchnode);	
		}
		else if(searchnode==null)
		{	
			/*
		 	 * A clear screen hack
			*/			
			System.out.print("\033[H\033[2J");
			System.out.flush();

			System.out.println("********************************");
			System.out.println("Given emp number does not exist.");
			System.out.println("********************************");
		}
		
		
	}
	private void record(Node node,int em)
	{	
		if(em==node.emp)
		{
			print(node);
		}
		else if(em<node.emp)
		{
			record(node.left,em);
		}
		else if(em>node.emp)
		{	
			record(node.right,em);
		}
		
	}//Method record() ends here.
	
	//Method to display record based on emp number.
	public void print(Node node)
	{
		/*
	 	 * A clear screen hack
		*/			
		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.println("");
		System.out.println("Record of given employee:\n");
  		System.out.println("emp number:"+node.emp);
  		System.out.println("Name      :"+node.name);
  		System.out.println("sex       :"+node.sex);
  		System.out.println("age       :"+node.age);
  		System.out.println("********************");
	}
	
	//Method to display all records present in the database in sorted order of their employees.
	public void Display(Node node)
	{
		if(node!=null)
		{
			Display(node.left);
			print1(node);
			Display(node.right);
		}
	}//Display() method ends here.
	
	public void print1(Node node)
	{
		System.out.println("");
  		System.out.println("emp number:"+node.emp);
  		System.out.println("Name      :"+node.name);
  		System.out.println("sex       :"+node.sex);
  		System.out.println("age       :"+node.age);
  		System.out.println("********************");	
	}//Method to print all the employees ends here.
	
	//Write a method to print level wise nodes.
	public void levelorder()
	{
		LinkedList<Node> l=new LinkedList<>();
		Node tmp=new Node();
		tmp=root;
		l.add(tmp);
		int m=1;
		int n=0;
		int i=0;
		boolean flag=false;
		while(l.size()!=0)
		{
			tmp=l.removeFirst();
			m--;
			if(flag==false)
			{	
				System.out.println("Level-"+i);
			}
			
			flag=true;
		        print1(tmp);
			if(tmp.left!=null)
			{
				l.add(tmp.left);
				n++;
			}
			if(tmp.right!=null)
			{
				l.add(tmp.right);
				n++;
			}
			if(m==0)
			{
				System.out.println();
				m=n;
				n=0;
				flag=false;
				i++;	
			}
		}  
	}//Method levelorder() ends here.
	
	//Write a method to delete any node.
	public void Delete()
	{
		int emp_number;
		System.out.println("\nEnter any emp number to delete relative node");
		emp_number=in.nextInt();
		Node node1=searchNode(root,emp_number);
		in.nextLine();
		if(node1!=null)
		{
			DeleteNode(node1);	
		} 
		else if(node1==null)
		{	
			/*
		 	 * A clear screen hack
			*/			
			System.out.print("\033[H\033[2J");
			System.out.flush();
	
			System.out.println("********************************");
			System.out.println("Given emp number does not exist.");
			System.out.println("********************************");
		}
		
	}     
	//Write a method to search a perticular node.
	public Node searchNode(Node node,int value)
	{	if(node!=null)
		{
			if(value<node.emp)  //if given emp number is less than the current node's emp number ,go left of that node.
			{
				return searchNode(node.left,value);
			}		
			else if(value>node.emp)  //given emp number is greater than the current node's emp number ,go right of that node.
			{
				return searchNode(node.right,value);
			}
			else if(value==node.emp) //if emp number is found.
			{
				return node;
			}
			else
			{
				return null;
			}			
		}
		else
		{
			return null;
		}
	}     
	
	//Write a method to find out any node in binary tree.
	public void DeleteNode(Node node)
	{
		if(node==root)
		{
			if(root.left==null&&root.right==null)
			{
				root=null;
				/*
			 	 * A clear screen hack
				*/			
				System.out.print("\033[H\033[2J");
				System.out.flush();

				System.out.println("\n\n****Whole binary tree is deleted****\n\n");
			}
			else if(root.right==null)
			{
				root=node.left;	
			}
			else if(root.left==null)
			{
				root=node.right;
			}
			else if(root.right!=null&&root.left!=null)
			{
				Node tmp=minTraversal(root.right);
				DeleteCase2(tmp);
				//tmp.parent=null;
				tmp.left=root.left;
				tmp.right=root.right;
				root=tmp;	
			}
		}
		else
		{
			if(node.left==null&&node.right==null)
			{
				if(node.parent.left==node)
				{
					node.parent.left=null;
				}
				else if(node.parent.right==node)
				{
					node.parent.right=null;
				}		
			}	
			else if(node.left==null)//right child exists.
			{
				DeleteCase2(node);
			}
			else if(node.right==null)//left child exists.
			{
				DeleteCase2(node);
			}
			else   //left and right both childrens exists
			{
				DeleteCase3(node);	
			}
		}
	}//Method DeleteNode() ends here.
	
	//Write a method for any node which has only child whether it is left child or right child.
	private void DeleteCase2(Node node)
	{
		if(node.left==null)
		{
			if(node.parent.left==node)
			{
				node.parent.left=node.right;
			}
			else if(node.parent.right==node)
			{
				node.parent.right=node.right;
			}	
		}
		else if(node.right==null)
		{
			if(node.parent.left==node)
			{
				node.parent.left=node.left;	
			}
			else if(node.parent.right==node)
			{
				node.parent.right=node.left;
			}				
		}	
	}//Method DeleteCase2(Node node) ends here.
	
	//Write a method for any node except root node which has both left and right child.
	private void DeleteCase3(Node node)
	{
		Node tmp=minTraversal(node.right);
		DeleteCase2(tmp);
		tmp.parent=node.parent;
		tmp.left=node.left;
		tmp.right=node.right;
		
		if(node.parent.left==node)
		{
			node.parent.left=tmp;		
		}
		else if(node.parent.right==node)
		{
			node.parent.right=tmp;	
		}
	}
	private Node minTraversal(Node node)
	{
		if(node.left==null)
		{
			return node;
		}
		return minTraversal(node.left);
	}
	
	
	
} //Binarytree ends here.












