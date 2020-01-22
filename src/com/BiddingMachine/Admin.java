package com.BiddingMachine;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.*; 

public class Admin 
{

	String uname="admin";
	String password="password";
	 int count=0;
	static ArrayList<Item> itemlist = new ArrayList<Item>();
	
	Admin()
	{ 
		
	}
	Admin(String uname,String password)
	{ 
		uname=this.uname;
		password=this.password;
		
	}
	public void showItem()
	{ 
		for(int i=0;i<itemlist.size();i++)
		{
			System.out.println("ITEM NAME :"+itemlist.get(i).item);
			System.out.println("ITEM BASE PRICE :"+itemlist.get(i).Baseprice);
			System.out.println("ITEM END DATE :"+itemlist.get(i).End_Date);
			System.out.println("BID WINNER :"+itemlist.get(i).desc);
			System.out.println("BIDS :"); 
				for(Entry<String, Integer> entry : itemlist.get(i).bid_bidder.entrySet())
			    {   
					//print keys and values
			         System.out.println(entry.getKey() + " : " +entry.getValue());
			    }
		   System.out.println("________________________________________________________");		
				
			
			
		}
	}
	public void deleteitem() //function to delete item by admin
	
	{ 
		String name;
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter item Name to delete :");
		name=scn.next();
		int i;
		for(i=0;i<itemlist.size();i++)
		{ 
			if((itemlist.get(i).item).equals(name))
			{ 
				itemlist.remove(i);
				System.out.println("Item Removed Successfully!");
				break;
			}
		}
		if(i==itemlist.size())
		{ 
			System.out.println("Sorry! No such item found");
			
		}
		
		
	}

	public void addItems()
	{
		int i;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Scanner scn=new Scanner(System.in);
		Item items=new Item();
//		items.bid_bidder.put("","");
		items.desc="Undecided";
		System.out.println("Enter Item name");
		items.item=scn.next();
		System.out.println("Enter Base Price");
		items.Baseprice=scn.nextInt();
		System.out.println("Enter End Date in dd-MMM-yyyy format");
		String date = scn.next();
		try {
			items.End_Date = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(i=0;i<itemlist.size();i++)
		{
			if((itemlist.get(i).item).equals(items.item))
			{ 
				
				System.out.println("Such item already exists in system");
				
				break;
			}
			
		}
		itemlist.add(items);
		
		
		
	} 
	public void login(String uname,String pass)
	{ 
		Scanner scn=new Scanner(System.in);
		int choice;
		Admin ad=new Admin();
		if(uname.equals(this.uname) && pass.equals(this.password))
		{ 
			
			do
			{
			System.out.println("Successfully Logged in");
			System.out.println("MENU :");
			System.out.println("Press 1 to ADD ITEM ");
			System.out.println("Press 2 to SHOW ITEMS ");
		    System.out.println("Press 3 to DELETE ITEM ");
		    System.out.println("Press 4 to SHOW BIDDERS");
		    System.out.println("Press 5 to FINALIZE BIDDERS TILL CURRENT DATE");
		    
		    
		    System.out.println("Press anyother key to go back to previous Menu");
			choice=scn.nextInt();
			if(choice==1)
			{ 
			
				ad.addItems();
			}
			else if(choice==2)
			{
				ad.showItem();
				
			}
			else if(choice==3)
			{ 
			ad.deleteitem();	
			}
			else if(choice==5)
			{ 
				ad.finalize_items();
			}
			
			else
			{ 
				return;
			}
			
			}while(choice==1 || choice==2||choice==3||choice==4||choice==5);			
			
			
		}
		else
		{ 
			System.out.println("Incorrect Credentials");
			
			
		}
		
	}
	public void finalize_items()
	{ 
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date todayDate = null ;
		for(int i=0;i<itemlist.size();i++)
		{
			try {
				todayDate = dateFormatter.parse(dateFormatter.format(new Date() ));
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(itemlist.get(i).End_Date.compareTo(todayDate)>=0)//not expired
			{ 
				
				
			}
			else
			{ 
				int maxValue=-1;
				String maxkey="";
				for(Entry<String, Integer> entry : itemlist.get(i).bid_bidder.entrySet())
			    {   
				
			         
			         if(entry.getValue()>maxValue)
			         { 
			        	maxkey=entry.getKey();
			        	 maxValue=entry.getValue();
				         	 
			         }
			         
			         
			         itemlist.get(i).desc="WINNER IS "+maxkey;
			         
			    }
				
			}
		}
		
		
	}
	

	
}
