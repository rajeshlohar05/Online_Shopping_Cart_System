package onlinecartjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//main class where project start
public class Shop {

	static List<Products> productList=new ArrayList<>();
	static Map<Integer,Customer> customerList=new HashMap<>();
	static Map<String,String> customerLogin=new HashMap<>();
	static List<Products> cartList=new ArrayList<>();
	
	public static void main(String []args) {
		
		
		Scanner sc=new Scanner(System.in); 
		
		char ch;
		System.out.println("WELCOME TO ONLINE SHOPPING CART SYSTEM\n");
		do {
			
			
			System.out.println("*********************************************");
			System.out.println("1. Login As a Admin.\n"
					+ "2. Login As a Customer\n"
					+ "3. Exit.\n");
			
			System.out.println("*********************************************");
			
			System.out.print("Enter your choice : ");
			int choice=sc.nextInt();
			String adminUserId="";
			switch(choice) {
				
				case 1:System.out.println("-----------------Admin---------------");
					  Admin admin=new Admin();
					  System.out.println("Enter User Name :- ");
					  sc.nextLine();
					  adminUserId=sc.nextLine();
					  
					  System.out.println("Enter Passward :- ");
					  String adminPassward=sc.nextLine();
					  
					  admin.adminConnect(adminUserId,adminPassward);
				break;
				case 2:System.out.println("--------------------Customer-----------------");
					
					 System.out.println("Register Customer Using Customer Id and Passward:-");
					 String customerId=sc.nextLine();
					 sc.nextLine();
					 String customerPassward=sc.nextLine();
					 Customer customer=new Customer(customerId,customerPassward);
					 
					 System.out.println("Enter Customer Login Credential");
					 System.out.println("Enter Customer Id :- ");
					
					 String loginCustomerId=sc.nextLine();
					 
					 System.out.println("Enter Passward : -");
					 
					 String loginCustomerPassward=sc.nextLine();
					 
					 customer.customerConnect(loginCustomerId, loginCustomerPassward);
				break;
				case 3:break;
				default:System.out.println("Wrong Choice!!");
			}
			
			
			System.out.println("Do you Want to Login Again press Y/y.");

			ch=sc.next().charAt(0);
		}while(ch=='y' || ch=='Y');
		System.out.println("Program Ends");
	}
}
