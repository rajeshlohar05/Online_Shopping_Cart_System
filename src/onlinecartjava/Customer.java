package onlinecartjava;

import java.util.Random;
import java.util.Scanner;


public class Customer extends Shop {
	String customerId;
	String customerPassward;
	
	public Customer(String customerId,String customerPassward) {
		this.customerId=customerId;
		this.customerPassward=customerPassward;
		customerLogin.put(customerId, customerPassward);
		System.out.println("Customer Successfully Registered..");
	}
	void customerConnect(String loginCustomerId,String loginCustomerPassward) {
		
		System.out.println(customerLogin.containsKey((String)loginCustomerId));
		if(customerLogin.containsKey((String)loginCustomerId) && customerLogin.get(loginCustomerId).compareToIgnoreCase((String)loginCustomerPassward)==0) {
			System.out.println("Customer Login Succesfull");
			
			Scanner sc=new Scanner(System.in);
			char ch;
			do {
				
					System.out.println("WELCOME TO CUSTOMER PANEL");
					
					System.out.println("***********************************");
					
					System.out.println("1. View the List of Products.\n"
							+ "2. Add to Cart Product.\n"
							+ "3. Remove Product From Cart.\n"
							+ "4. View Cart List.");
					
					System.out.println("Enter Your Choice :- ");
					int choice=sc.nextInt();
					
					switch(choice) {
						case 1:System.out.println("Product list");
							Products.productList();
						break;
						
						case 2:System.out.println("Add to cart");
							System.out.println("Enter Product Id you wish to add to Cart :- ");
							int id=sc.nextInt();
							
							if(Cart.addToCart(id))
							{
								System.out.println("Add to Cart Successfully");
								System.out.println("To buy this Product Press y/Y");
								ch=sc.next().charAt(0);
								if(ch=='y'||ch=='Y') {
									int idx=-1;
									for(Products list:productList)
									{
										if(list.productId==id) {
											idx=productList.indexOf(list);
											break;
										}
									}
									Products ll=productList.get(idx);
									System.out.println("Your Product is :- \n");
									System.out.println("Name : "+ll.productName);
									System.out.println("Price :  "+ll.productPrice);
									Random r=new Random();
									int transaction_id=((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
									System.out.println("Transaction Id : "+transaction_id);
								}
							}
							else
							{
								System.out.println("No such Product Available with id : "+id);
							}
						break;
						
						case 3:
								System.out.println("Enter Product Id you wish to Remove from Cart :- ");
								id=sc.nextInt();
								if(Cart.removeCart(id))
									System.out.println("Remove Product From Cart Succesfully");
								else
									System.out.println("No such Product Available to remove from cart Whose id is :"+id);
						break;
						
						case 4:
							Cart.cartList();
						break;
						
						default:System.out.println("Invalid choice!!!");
					}
			System.out.println("Do you want to explore More as a Customer press y/Y ");
			ch=sc.next().charAt(0);
			
			}while(ch=='Y' ||ch=='y');
		}
		else
		{
			System.out.println("Invalid Credential");
		}
	}
	
}
