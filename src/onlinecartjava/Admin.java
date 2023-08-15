package onlinecartjava;

import java.util.Scanner;

public class Admin extends Shop  {
	
	
	String adminUserId;
	String adminPassward;
	
	public Admin()
	{
		adminUserId="Admin";
		adminPassward="root";
	}
	
	public void adminConnect(String adminUserId,String adminPassward) {
		
		if(this.adminUserId.compareToIgnoreCase(adminUserId)==0 && this.adminPassward.compareToIgnoreCase(adminPassward)==0)
		{
			Products product;
			Scanner sc=new Scanner(System.in);
			System.out.println("Admin Login Successfull.\n");
			char ch;
			do {
				
				System.out.println("WELCOME TO ADMIN PANEL..");
				
				System.out.println("*************************************");
				
				System.out.println("1. Add New Product\n"
						+ "2. Remove Product\n"
						+ "3. View Prodcut List.");
				
				System.out.println("Enter Your Choice :- ");
				int choice=sc.nextInt();
				
		
				switch(choice) {
					case 1:System.out.println("Enter Products Details like Id, Name, Price, Company, Warrenty, Material :- ");
							int id=sc.nextInt();
							sc.nextLine();
							
							System.out.println("Name");
							String name=sc.nextLine();
							
							System.out.println("price");
							double price=sc.nextDouble();
							
							System.out.println("Company");
							sc.nextLine();
							String company=sc.nextLine();
							
							System.out.println("warrenty");
							String warrenty=sc.nextLine();
							
							System.out.println("material");
							String material=sc.nextLine();
							
							product=new Products(id,name,price,company,warrenty,material);
							product=product.addProduct(product);
							System.out.println("New Product Added Succesfully..");
					break;
					case 2:System.out.println("Enter Id of the Product You want to Remove : -");
						id= sc.nextInt();
						if(Products.removeProduct(id))
						System.out.println("Product Deletion Succesfully..");
						else
							System.out.println("No such Product Available with id is :"+id);
					break;
					case 3:
					Products.productList();
					break;
					default:System.out.println("Invalid Choice!!!");
				}
				
				System.out.println("Do you want to continue as "+adminUserId+" press y/Y");
				ch=sc.next().charAt(0);
				
			}while(ch=='y' || ch=='Y');
		}
		else
		{
			System.out.println("Invalid Credential");
		}
	}

}
