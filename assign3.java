/*
 * Implimenting a very  basic student database management 
*/



import java.util.*;
import java.util.Scanner;


class Student
{
	/*
	 * Will define the department and help check for existing department
      	 */
	public int index;

	/*
 	 *input from user
 	 */
	
	public String dptid;
	public String name; 
	public String sex;
	public String dob;
	public String email;
	public String prog;
	public String supervisor;
	public String q_degree;
	public String is_spons;
	public String cpi;
	
	/*
	 * roll is the roll number 
  	 */

	public String roll;

	/*
	 * Defining constructor.
	 */
	public Student()
	{
	}
	public Student(String s , int r)
	{
		
		dptid=s;
		Scanner in=new Scanner(System.in);		
		System.out.println("Enter name");
		name=in.nextLine();
		System.out.println("Enter date of birth (dd/mm/yyyy)");
		dob=in.nextLine();	
		System.out.println("Enter sex (M/F)");
		sex=in.nextLine();
		System.out.println("email: (example@iitp.ac.in)");
		email=in.nextLine();
		
		System.out.println("Select program");
		System.out.println("1. Btech");
		System.out.println("2. Mtech");
		System.out.println("3. PhD");

		
		while (true)
		{
			index=in.nextInt();
                        in.nextLine();
			if(index==1)
			{
				prog="B.Tech";
				roll="BT";
				supervisor="0";
				q_degree="0";
				is_spons="0";
				break;
			}
				
			else if (index==2)
			{
				prog="M.Tech";
				roll="MT";
				supervisor="0";
				System.out.println("Exter Qualification degree");
				q_degree=in.nextLine();
				System.out.println("Are you sponsored candidate (yes/no)");
				is_spons=in.nextLine();
				break;
			}
			
			else if(index ==3)
			{
				prog="PhD";
				roll="PD";
				System.out.println("Enter your supervisors name");
				supervisor=in.nextLine();
				System.out.println("Exter Qualification degree");
				q_degree=in.nextLine();
				System.out.println("Are you sponsored candidate (yes/no)");
				is_spons=in.nextLine();
				break;
			}
		
		else 	System.out.println("Unknown choice: ENTER AGAIN");
							
			
		}
		
		System.out.println("What is your CPI?");
		cpi=in.nextLine();
		get_roll(r);
		System.out.println("Your roll is "+roll+" ");
		System.out.println("Student DATA added");
	}
	/*
	 * Method to generate roll number
  	 */
	public void get_roll(int r)
	{
		roll=dptid+roll+String.valueOf(r);
	}
	
	/*
	 * Display
	*/

	public void disp()
	{
		System.out.println("STUDENT INFORMATION");
	
		System.out.println("Roll  : "+roll);
		System.out.println("Name  : "+name);
		System.out.println("Sex   : "+sex);
		System.out.println("Dob   : "+dob);
		System.out.println("Email : "+email);
		
		if(prog.equals("B.Tech"))
		{
			System.out.println(" ");
			System.out.println("Program : "+prog);
			System.out.println("CPI     : "+cpi);
		}
		else if(prog.equals("M.Tech"))
		{
			System.out.println(" ");
			System.out.println("Program       : "+prog);
			System.out.println("Qualification : "+q_degree);
 			System.out.println("CPI           : "+cpi);
		}
		
		else
		{
			System.out.println(" ");
			System.out.println("Program       : "+prog);
			System.out.println("Qualification : "+q_degree);
			System.out.println("Supervisor	  : "+supervisor);
 			System.out.println("CPI           : "+cpi);
		}
	}



	/*
	 * Update  
	*/
	void update()
	{
		//System.out.println("STUDENT DATA TO BE UPDATED");
		disp();
		Scanner inp=new Scanner(System.in);
		System.out.println("Do you want to update?(y/n)");
		String c=(inp.nextLine());
		if(c.equals("y"))	
		{
			System.out.println("Enter name");
			name=inp.nextLine();
			System.out.println("Enter date of birth (dd/mm/yyyy)");
			dob=inp.nextLine();	
			System.out.println("Enter sex (M/F)");
			sex=inp.nextLine();
			System.out.println("email: (example@iitp.ac.in)");
			email=inp.nextLine();
			
			System.out.println("Select program");
			System.out.println("1. Btech");
			System.out.println("2. Mtech");
			System.out.println("3. PhD");
		
			
			while (true)
			{
				index=inp.nextInt();
                                inp.nextLine();
					if(index==1)
				{
					prog="B.Tech";
					//roll="BT";
					supervisor="0";
					q_degree="0";
					is_spons="0";
					break;
				}
					
				else if (index==2)
				{
                                    prog="M.Tech";
                                  //  roll="MT";
                                    supervisor="0";
                                    System.out.println("Exter Qualification degree");
                                    q_degree=inp.nextLine();
                                    System.out.println("Are you sponsored candidate (yes/no)");
                                    is_spons=inp.nextLine();
                                    break;
				}
				
				else if(index ==3)
				{
					prog="PhD";
					//roll="PD";
					System.out.println("Enter your supervisors name");
					supervisor=inp.nextLine();
					System.out.println("Exter Qualification degree");
					q_degree=inp.nextLine();
					System.out.println("Are you sponsored candidate (yes/no)");
					is_spons=inp.nextLine();
                                    break;
				}
			
			else 	System.out.println("Unknown choice: ENTER AGAIN");
								
				
			}
			
			System.out.println("What is your CPI?");
			cpi=inp.nextLine();
                        /*
                         * Roll Number wont change as it is a constant reference
                                               
                        * get_roll(r);
			*/
                        System.out.println("Your roll is "+roll+" ");
			System.out.println("Student DATA updated");
		}
			
	}
		
}	


class Department
{	
	public int count=0;
        public int no_std=0;            
        public String dptid;
	public String dptname;
	public String hod;

	public Department()
	{
	}
		
	public Department(String s)
	{
		dptid=s;
		Scanner in=new Scanner(System.in);
				
		System.out.println("Enter Department Name");
		dptname=in.nextLine();		
		System.out.println("Enter H.O.D name");
		hod=in.nextLine();
	}
        
        public void display()
        {
               System.out.println("Department : "+dptname);
               System.out.println("Depar. ID  : "+dptid);
               System.out.println("H.o.D      : "+hod);
        }
};

	
	


public class assign3
{
	public static void main(String args[])
	{
                int ind=0; //indicator variable
		//Defining an array list of departments
		ArrayList<Department> Dpt=new ArrayList<Department> ();
		
		//Defining an array list of students
		ArrayList<Student> Std=new ArrayList<Student> ();
             
		//display menue
		int opt=0;
		String dpt_id;
		String str_men= "    **************************************";
		String str_men2="    *****STUDENT DATABASE MANAGEMENT *****";
		String str_men3="    *************** v 1.0 ****************";
		Scanner in=new Scanner(System.in);
                int run=0;
		while(true)
		{
			
                        if(run!=0)
                        {
                            System.out.format("\nPress any key to continue");
                            in.nextLine();
                        }

			/*
		 	 * A clear screen hack
			*/			
			System.out.print("\033[H\033[2J");
			System.out.flush();

                        run=1;
			opt=0;
			System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men2,str_men3);
			System.out.println(" 1.Add department information");
			System.out.println(" 2.Add student information ");
			System.out.println(" 3.Display a student's information based on Roll");
			System.out.println(" 4.Update a student's information based on RollNo");
			System.out.println(" 5.Display a department's information based on the department ID");
			System.out.println(" 6.Display the information of all departments ");
			System.out.println(" 7.Display the BTech student who has got the highest CPI");
			System.out.println(" 8.Display the total number of students overall and specifically in BTech/MTech/PhD");
			System.out.println(" 9.Display the total number of sponsored PhD/MTech students");
			System.out.println("10.Display the number of students based on DeptID");
			System.out.println("11.Delete a student's information based on RollNo");
			System.out.println("12.Delete a department's information based on DeptID");
			System.out.println("13.Change the department of a BTech student. Assign the next");
			System.out.println("   possible RollNo and remove the present RollNo and update the");
			System.out.println("   student's department information.");
                        System.out.println(" 0.Exit");
			System.out.println("   ");
			System.out.println("Enter your choice");
                        System.out.format("Choice: ");
			opt=in.nextInt();
		//	System.out.println("choice " +opt);
                        in.nextLine();
                        /*
                         * To prevent a scanner skip problem. in.nextInt gets 
                         * the intiger and skips the newline character.
                         * The subsequent scanner first gets the newline
                         * character and terminates/
                         *
                         * We will have to clear screen here to 
                        */
                        
                        
			System.out.print("\033[H\033[2J");
			System.out.flush();
                        String str_men4="0";
                        
			switch (opt)
			{
                               
                                        
                                    
                                           
                
				case 0: return  ;

				case 1: {
                                                str_men4="    ************ ADD DEPARTMENT **********";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               //adding a new department
						System.out.println("Enter the department ID");
						dpt_id=in.nextLine();
						if(Dpt.size()==0)
						{
                                                                //System.out.println("else DBG");
                                                                Department temp=new Department(dpt_id);
                                                                Dpt.add(temp);
                                                                break;
                                                 }		

						//Check if department already exists	
                                                ind=0;
						for(Department d: Dpt)
						{
                                                        
							if(d.dptid.equals(dpt_id))
							{
								System.out.println("Department already exists");
                                                                ind=1;
								break;
							}
							
							
						}
                                                
                                                if(ind==0)
							{
								//System.out.println("else DBG");
								Department temp=new Department(dpt_id);
								Dpt.add(temp);
								break;
							}
						break;
					}

				case 2:{
                                                str_men4="    ************ ADD STUDENT *************";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                                /*
                                                 * adding a new student.
                                                 * this will happen only if a department
                                                 * exists.
                                                */
						System.out.println("Enter the department ID");
						dpt_id=in.nextLine();		
                                                
                                                //check if departments exist
                                                if(Dpt.size()==0)
						{
                                                                //System.out.println("else DBG");
                                                                System.out.println("No Department exists");
                                                                break;
                                                 }		

                                                ind=0;
						//Check if department already exists	
						for(Department d: Dpt)
						{
							if(d.dptid.equals(dpt_id))
							{
								d.count+=1;
                                                                d.no_std+=1;
								Student temp=new Student(dpt_id , d.count);
								Std.add(temp);	
                                                                ind=1;
                                                                break;
							}
							
							
						}
                                                if(ind==0) {
                                                                System.out.println("The department "+dpt_id+" does not exist. Add using option 1");
                                                                break;
                                                        }
							
						break;
					}
                                
                                case 3:{
                                                str_men4="    ************ Display (roll) **********";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                                // Display(roll_no)
                                                
                                                System.out.println("Enter the Roll");
						dpt_id=in.nextLine();		

						//Check if department already exists	
                                                ind=0;
						for(Student s:Std)
						{
							if(s.roll.equals(dpt_id))
							{
								s.disp();   
                                                                ind=1;
                                                                break;
							}
							
						}
                                                
                                                if(ind==0)
                                                {
                                                    System.out.println("The roll "+dpt_id+" does not exist");
                                                    break;
                                                }
							
						break;
                                        }
                                case 4:{    
                                            //Update(roll_no)
                                                
                                                str_men4="    ************ UPDATE (roll)  **********";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                                System.out.println("Enter the Roll");
						
						dpt_id=in.nextLine();		

						//Check if rollno already exists	
                                                ind=0;
						for(Student s:Std)
						{
							if(s.roll.equals(dpt_id))
							{
								s.update();   
                                                                ind=1;
                                                                break;
							}
							
						}
							
                                                
                                                if(ind==0) 
                                                {
                                                    System.out.println("The roll "+dpt_id+" does not exist");
                                                    break;
                                                }
						break;
                                        }
                                 case 5:{       
                                                str_men4="    ************DISPLAY (dpt_id)**********";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                                //dispaly(dptid)
                                                System.out.println("Enter the Department ID");
						dpt_id=in.nextLine();
						

						//Check if department already exists	
                                                ind=0;
						for(Department d:Dpt)
						{
							if(d.dptid.equals(dpt_id))
							{
								d.display();   
                                                                ind=1;
                                                                break;
							}
							
						}
							
                                                
                                                if(ind==0) 
                                                {
                                                    System.out.println("The department "+dpt_id+" does not exist");
                                                    break;
                                                }
						break;
                                        }
                                 case 6: {
                                                str_men4="    ******* DISPLAY ALL DEPARTMRNTS ******";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                            //display all departments
                                            System.out.println("Displaying all departments");
                                            
                                            for(Department d: Dpt)
                                            {
                                                d.display();
                                                System.out.println(" ");
                                            }
                                            if(Dpt.size()==0)
                                                System.out.println("No Department to display");
                                            break;
                                     
                                         }
                                 case 7: {
                                            /* 
                                             * Display btech student with highest CPI
                                             *
                                             * first check if student is btech
                                             * then loop to find highest cpi among all
                                             * Then display all students with this cpi
                                             */
                                                str_men4="    ************* HIGHEST CPI ************";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                     
                                     
                                            ind=0;
                                             int i=0;  
                                             Student temp =new Student() ;
                                             if(Std.size()==0) 
                                             {
                                                 System.out.println("No Student found");
                                                 break;
                                             }
                                                                                 
                                             
                                             for(Student s: Std)
                                               {
                                                   if(s.prog.equals("B.Tech"))
                                                   {
                                                     if(i==0)
                                                     {
                                                         temp=s;
                                                         i=1;                                                         
                                                     }
                                                     else if ( Float.valueOf(temp.cpi)<=Float.valueOf(s.cpi)) 
                                                             temp=s;
                                                   }
                                               }
                                             System.out.println("The student(s) with highest CPI are");
                                             for(Student s: Std)
                                             {
                                                 if(s.cpi.equals(temp.cpi))
                                                 {
                                                     s.disp();
                                                 }   
                                                 
                                             }
                                             break;
                                          
                                            }
                                 
                                 case 8:  
                                         {
                                        /* Display total number of students 
                                         * overall and specifically branchwise
                                         * we will use a count mech
                                         */
                                                str_men4="    ***************** TOTAL **************";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                          int btech=0;
                                          int mtech=0;
                                          int phd=0; 
                                          
                                           if(Std.size()==0) 
                                             {
                                                 System.out.println("No Student found");
                                                 break;
                                             }
                                           for(Student s:Std)
                                           {
                                               if(s.prog.equals("B.Tech")) btech++;
                                               else if(s.prog.equals("M.Tech")) mtech++;
                                               else phd++;
                                               
                                           }
                                 
                                           System.out.println("Count of students");
                                           System.out.println("B.Tech  : "+btech);
                                           System.out.println("M.Tech  : "+mtech);
                                           System.out.println("PhD     : "+phd);
                                           System.out.println("Total   : "+(btech+mtech+phd));
                                           
                                           break;
                                         }
                                 case 9: 
                                         {
                                                
                                                str_men4="    ************ TOTAL SPONSORED *********";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                            /*
                                            * Display total number of sponsored students
                                            * No count hence manual count mechanism
                                            */
                                            
                                            int mtech=0;
                                            int phd=0;
                                            int tot=0;
                                            
                                            
                                           if(Std.size()==0) 
                                             {
                                                 System.out.println("No Student found");
                                                 break;
                                             }
                                           for(Student s:Std)
                                           {
                                               if(s.prog.equals("M.Tech") && s.is_spons.equals("1")) mtech++;
                                               else if(s.prog.equals("PhD") && s.is_spons.equals("1") ) phd++;
                                                                                              
                                           }
                                           tot=mtech+phd;
                                            System.out.println("Count of Sponsored Students");
                                           System.out.println("M.Tech  : "+mtech);
                                           System.out.println("PhD     : "+phd);
                                           System.out.println("Total   : "+tot);
                                           break;
                                           
                                         }  
                                 case 10: 
                                         {
                                                
                                                str_men4="    ********* TOTAL per DEPARTMENT *******";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                             /* Display number of students based on 
                                              * Dpt id
                                              * count is being kept
                                             */
                                              if(Std.size()==0) 
                                             {
                                                 System.out.println("No Student found");
                                                 break;
                                             }
                                              System.out.println("Enter department Id");
                                              dpt_id=in.nextLine();
                                              int count=0;
                                              for(Department d: Dpt)
                                              {
                                                  if(d.dptid.equals(dpt_id))
                                                  {
                                                      count=d.no_std;
                                                      break;
                                                  }
                                              }
                                              
                                               System.out.println("No of students in "+dpt_id);
                                               System.out.println(count);
                                               break;
                                               
                                         }
                                 case 11:
                                         {
                                             /*
                                              * Delete a students information using his roll number
                                              * 
                                              * This will involve deleting the student data from the 
                                              * array list and decreasing count .
                                              * we will use a array list.remove(obj)
                                              * for this purpose
                                             */
                                              
                                                
                                                str_men4="    ************ DELETE(roll)  ***********";
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                       
                                            if(Std.size()==0) 
                                                 {
                                                     System.out.println("No Student found");
                                                     break;
                                                 }
                                            System.out.println("DELETE STUDENT");
                                            System.out.println("Enter the roll no: ");
                                            dpt_id=in.nextLine();
                                            for(Student s: Std)
                                                {
                                                    if(s.roll.equals(dpt_id))
                                                    {
                                                           s.disp();
                                                           System.out.println("");
                                                           System.out.println("Are you sure you want to delete");
                                                           String p;
                                                           if((p=in.nextLine())=="y")
                                                           {
                                                               for(Department d:Dpt)
                                                               {
                                                                   if(d.dptid.equals(s.dptid))
                                                                   {
                                                                       d.no_std--;
                                                                       break;
                                                                   }
                                                               }
                                                               Std.remove(s);
                                                               System.out.println("Element removed");
                                                               break;
                                                           }
                                                                   
                                                                   
                                                    }
                                                }
                                            break;
                                         }  
                                 
                                 case 12:
                                         {
                                             /*
                                              * Delete a department information using his roll number
                                              * 
                                              * This will involve deleting the student data from the 
                                              * array list and decreasing count .
                                              * we will use a array list.remove(obj)
                                              * for this purpose
                                              *
                                              * Question does not specify what happens to the
                                              * Student in the department after it has
                                              * been deleted.
                                             */
                                              
                                                str_men4="    ************* DELETE(dpt) ************";
                                                
                                                System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                               
                                       
                                            if(Dpt.size()==0) 
                                                 {
                                                     System.out.println("No Department found");
                                                     break;
                                                 }
                                            System.out.println("DELETE Department");
                                            System.out.println("Enter the Department ID: ");
                                            dpt_id=in.nextLine();
                                            for(Department s:Dpt)
                                                {
                                                    if(s.dptid.equals(dpt_id))
                                                    {
                                                           s.display();
                                                           System.out.println("");
                                                           System.out.println("Are you sure you want to delete (y/n)");
                                                           String p;
                                                           p=in.nextLine();
                                                           if((p.equals("y")))
                                                           {
                                                               Dpt.remove(s);
                                                               System.out.println("Element removed");
                                                               break;
                                                           }
                                                    }           
                                                }                  
                                                                          
                                            break;
                                         }
                                 
                                 case 13:
                                        {
                                     
                                            /*
                                             * Change the department of a student
                                             *
                                             * he will get a new department roll no as avalable
                                             * his current roll will be deleted
                                             
                                             * Change the departnet id variable of the 
                                             * student after checking the new department exists
                                             * this will in effect have changed the department
                                             * decrease the number of students in the previous department
                                             * increment the nos in new department
                                             * get new roll no
                                             
                                            */    
                                            str_men4="    *************** TRANSFER *************";
                                            System.out.format("\n\n\n%s\n%30s\n%s\n\n\nMenu\n\n",str_men,str_men4,str_men);
                                            String roll;
                                            String newdpt;
                                            System.out.println("Enter the student roll no");
                                            roll=in.nextLine();
                                            System.out.println("Enter the new department");
                                            newdpt=in.nextLine();
                                            
                                            /*
                                             * Check if department exists
                                            */
                                            
                                            Student s=new Student();
                                            Department d=new Department();
                                            
                                            ind=0;
                                            if(Dpt.size()==0) 
                                                 {
                                                     System.out.println("No Department found");
                                                     break;
                                                 }
                                            else for( Department d2:Dpt)
                                                {
                                                    if(d2.dptid.equals(newdpt))
                                                    {
                                                        ind=1;
                                                        d=d2;
                                                        break;
                                                    }
                                                }
                                            if(ind==0)
                                                {
                                                     System.out.println("No Department found");
                                                     break;
                                                }
                                            /*
                                             * check if student exists
                                            */
                                            ind=0;
                                            if(Std.size()==0) 
                                                 {
                                                     System.out.println("No Student found");
                                                     break;
                                                 }
                                            else for( Student s2:Std)
                                                {
                                                    if(s2.roll.equals(roll) && s2.prog.equals("B.Tech"))
                                                    {
                                                        ind=1;
                                                        s=s2;
                                                        /* 
                                                        * Since the student is found ,we will have
                                                        * to change the department details
                                                        * of the old department
                                                        */
                                                        for(Department d3:Dpt)
                                                        {
                                                            if(d3.dptid.equals(s2.dptid))
                                                            {
                                                                d3.no_std--;
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                            if(ind==0)
                                                {
                                                     System.out.println("No such student found");
                                                     break;
                                                }
                                            /*
                                             * if controll reaches here, it means student s
                                             * is to be transfered to department d
                                            */
                                            
                                            s.dptid=d.dptid;
                                            d.count+=1;
                                            s.roll="BT";
                                            s.get_roll(d.count);
                                            d.no_std+=1;
                                            
                                            /*
                                             * Updated student data and department data.
                                             */
                                            System.out.println("Transfer complete:");
                                            s.disp();
                                            break;                                           
                                            
                                        } 
                                 default : System.out.println("Please try again");
                                           break;
                                                  
                        }
                                            
			
		}
	}
}
