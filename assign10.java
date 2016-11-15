/*
 *Name:-Padma Ram meg
 *1301CS30
 *Date of Creation:-
 */
 
/*Aim:-Bank related operation in which customer are supposed to stand in queue and to wait.
 *
 */
import java.util.*;
import java.util.ArrayList;
public class assign10a
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Bank b=new Bank();
		int choice;
		String s;
		int i;
		do
		{
			System.out.println("Do you want to add transaction ?");
			System.out.println("1:YES");
			System.out.println("2:NO");
			i=in.nextInt();
			switch(i)
			{
				case 1:
					b.transact();
					break;
				case 2:
					break;
				default :
					System.out.println("INVALID INPUT");
					break;
			}	
		}while(i!=2);
		do
		{
			System.out.println("Enter choice ");
			System.out.println("1:Add customer");
			System.out.println("2:First cum first serve");
			System.out.println("3:Shortest job first");
			System.out.println("4:Exit");
			choice=in.nextInt();
			switch(choice)
			{
				case 1:
					b.push();
					break;
				case 2:
					b.first_cum();
					break;
				case 3:
					b.insert();
					break;
				
				default :
					System.out.println("INVALID INPUT. Try again\n");
					break;
				case 4:
					System.out.println("Successfully exit");
					break;	
			}
		}while(choice!=4);	
	}
}//Main class ends here.
//Write a Customer class so that we can store all customers details.
class Customer
{
	String ID;
	int time;
	String type;
	Customer next;
	String name;
	int tr;
	int t_s;
	int pr;
	public Customer()
	{
	
	}
	public Customer(String ID,int time,String type,int pr)
	{
		this.ID=ID;
		this.time=time;
		this.type=type;
		this.next=null;
		this.pr=pr;
	}
	public Customer(String name,int tr)
	{
		this.name=name;
		this.tr=tr;
	}
}//Customer class ends here.
class Bank
{
 	ArrayList<Customer> cus=new ArrayList<Customer>();
 	ArrayList<Customer> ts=new ArrayList<>();
        static Customer[] a1=new Customer[1000];
 	private static Customer[] a;
 	static int n;
 	private static int left;
        private static int right;
        private static int largest;
    
    
    
  	Scanner inp=new Scanner(System.in);
 	String ID;
 	int time;
 	String type;
 	Customer cst;
 	String name;
 	int tr;
 	static int t_p=0;
 	static int t1=0;
 	static int f_t=0;
 	static int sum=0;
 	//Write a method to define new transaction of the bank.
 	public void transact()
 	{
 		System.out.println("Enter transaction type");
 		name=inp.nextLine();
 		System.out.println("Enter time required time (in hours)");
 		tr=inp.nextInt();
 		inp.nextLine();
 		cst=new Customer(name,tr);
 		ts.add(cst);
 	}
 	//Write a method to add new customer in the row.
 	public void push()
 	{
 		System.out.println("Enter name of the person");
 		ID=inp.nextLine();
 		System.out.println("Enter arrival time of the person");
 		time=inp.nextInt();
 		Suystem.out.println("Enter priority");
 		int pr=inp.nextInt();
 		inp.nextLine();
 		System.out.println("Enter Type of the transaction");
 		type=inp.nextLine();
 		boolean check=false;
 		for(int i=0;i<ts.size();i++)
 		{
 			if(type.equals(ts.get(i).name))
 			{	
 				check=true;
 				break;
 			}
 			else
 			{
 				check=false;
 			}
   		}
   		if(check==false)
   		{
   			System.out.println("****************************");
   			System.out.println("INVALID type of transaction.There is not available this type of transaction in bank.\n");
   			System.out.println("Do you want to exit (y/n)");
   			String s =inp.nextLine();
   			if(s.equalsIgnoreCase("y"))
   			{
   				System.exit(0);
   			}
   			push();
   		}
   		else if(check==true)
   		{
 			cst=new Customer(ID,time,type,pr);
 			cus.add(cst);
 		}
 	}//Method push() ends here.
 	
 	//Method first_cum() for First-Cum-first-serve.
 	public void first_cum()
 	{
 		boolean flag=false;
 		for(int i=0;i<cus.size();i++)
 		{
 			for(int j=0;j<ts.size();j++)
 			{
 				if(cus.get(i).type.equals(ts.get(j).name))
 				{
 					t_p=ts.get(j).tr;
 					flag=true;
 					break;	
 				}
 			}	
 			if(flag==true)
 			{
 				System.out.println("ID              :"+cus.get(i).ID);
 				System.out.println("Arrival time    :"+cus.get(i).time);
 				System.out.println("Transaction     :"+cus.get(i).type);
 				System.out.println("Processing time :"+t_p);
 				if(i==0)
 				{
 					System.out.println("Start time      :"+cus.get(i).time);
 					System.out.println("Finish time	    :"+(cus.get(i).time+t_p));
 					f_t=cus.get(i).time+t_p;
 				}
 				else
 				{
 					if(f_t<=cus.get(i).time)
 					{
 						System.out.println("Start time      :"+cus.get(i).time);
 						System.out.println("Finish time	    :"+(cus.get(i).time+t_p));
						f_t=cus.get(i).time+t_p;
 					}
 					else if(f_t>cus.get(i).time)
 					{
 						System.out.println("Start time      :"+f_t);
 						System.out.println("Finish time     :"+(f_t+t_p));
 						f_t=f_t+t_p;
 						sum=sum+f_t-cus.get(i).time;
 					}
 					
 				}
 				System.out.println();				
 			}
 		}
 		System.out.println("Average waiting time is :"+sum/cus.size());
 			
 	}//Method first_cum() ends here.
 	
 	
 	
 	
}//class ends here.


   
