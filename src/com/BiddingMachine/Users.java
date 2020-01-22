package com.BiddingMachine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Users 
{
	String uname;
	String password;
	static HashMap<String, String> map_user = new HashMap<>(); 
	
	Users()
	{ 
		
	}
	
	public Users(String user, String pass) 
	{
		this.uname=user;
		this.password=pass;
		
	}
	public void login(String user,String pass)
	{ 
		Scanner scn=new Scanner(System.in);
		int choice;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date todayDate = null ;
		String item_choice="";
		int money;
		if (map_user.containsKey(user))
		{
			String password=map_user.get(user);
			if(password.equals(pass))
			{ 
				System.out.println("Successfully Logged in");
				System.out.println("_______________________________");
				do
				{
				System.out.println("Enter 1 to show items");
				
				System.out.println("Enter 2 to bid items");
				
				System.out.println("Enter 3 to return from this menu");
				choice=scn.nextInt();
				Admin ad=new Admin();
				switch(choice)
				{ 
				case 1: ad.showItem();
						break;
				case 2: System.out.println("Enter item name to bid"); 
						item_choice=scn.next();
						System.out.println("Enter amount");
						money=scn.nextInt();
						int i;
					try {
						todayDate = dateFormatter.parse(dateFormatter.format(new Date() ));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						for(i=0;i<Admin.itemlist.size();i++)
						{
							if((Admin.itemlist.get(i).item).equals(item_choice))
							{ 
								
								if(Admin.itemlist.get(i).desc.equals("decided")||((Admin.itemlist.get(i).End_Date.compareTo(todayDate))<0))
								{ 
									System.out.println("This item is closed for bidding!");
									break;
								}
							else if(Admin.itemlist.get(i).Baseprice<=money)
								{
								Admin.itemlist.get(i).bid_bidder.put(user,money);
								System.out.println("BID PLACED");
								break;
								}
								else
								{ 
									System.out.println("BID Amount cannot be less than base price");
									break;
								}
								
								
							}
						}
						if(i==Admin.itemlist.size()||Admin.itemlist.size()==0)
						{ 
							System.out.println("Something went Wrong! No such item exists");
							
						}
						
						break;
				default:
				}
				}while(choice!=3);
				
			}
			
		}
		else
		{ 
			
			System.out.println("Login Failed! Try Again");
		}

	}
	public void Signup(String user,String pass)
	{
		if (map_user.containsKey(user))
		{
			System.out.println("Such user already exists in system");
		}
		else
		{
			map_user.put(user,pass);
			System.out.println("Successfully Registered! Login to continue");
			
		}
		
		
	}
	
	public void bid_item(String item_name)
	{ 
		
	}
	

}
