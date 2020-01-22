package com.BiddingMachine;

import java.util.Scanner;

public class Handler {
	int option;
	
	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	
	void createOptionmenu(Handler obj)
	{ 
		Scanner scn=new Scanner(System.in);
		String uname;
		String pass;
		do
		{
		System.out.println("Enter 1 to login as Admin");
		System.out.println("Enter 2 to Login as Customer");
		System.out.println("New to app?? Enter 3 to Signup!");
		
		System.out.println("Enter 4 to Exit");
		
		obj.setOption(scn.nextInt());
		if(obj.getOption()==1) //Login as Admin Code
		{ 
			System.out.println("Enter Admin username");
			uname=scn.next();
			
			System.out.println("Enter Admin password");
			pass=scn.next();
			
			Admin admin=new Admin(uname,pass);

			admin.login(uname,pass);
		}
		else if(obj.getOption()==2)//Login Code
		{ 
			
			System.out.println("Enter Username");
			uname=scn.next();
			System.out.println("Enter Password");
			pass=scn.next();
			Users user=new Users();
			user.login(uname,pass);
			
		}
		else if(obj.getOption()==3)//Sign Up code
		{ 
			
			System.out.println("Enter Username");
			uname=scn.next();
			System.out.println("Enter Password");
			pass=scn.next();
			Users user=new Users();
			user.Signup(uname,pass);
			
		}
	
			
		}while(obj.getOption()!=4);
	
	
		
	}
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Handler handle=new Handler();
		handle.createOptionmenu(handle);
		
		
		
	}

}
