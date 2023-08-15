package onlinecartjava;

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
	void customerConnect(String loginCustomerId,String customerPassward) {
		
		if(customerLogin.containsKey(loginCustomerId) && customerLogin.get(customerId).compareToIgnoreCase((String)customerPassward)==0) {
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
								System.out.println("Add to Cart Successfully");
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
