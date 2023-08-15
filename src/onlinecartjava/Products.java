package onlinecartjava;

import java.util.List;

public class Products extends Shop {
	
	int productId;
	String productName;
	double productPrice;
	String productCompany;
	String productWarrenty;
	String productMaterial;
	
	public Products(){}
	Products(int productId,String productName,double productPrice,String productComapany,String productWarrenty,String productMaterial)
	{
		this.productId=productId;
		this.productName=productName;
		this.productPrice=productPrice;
		this.productCompany=productCompany;
		this.productWarrenty=productWarrenty;
		this.productMaterial=productMaterial;
	}
	
	
	public Products addProduct(Products product) {
		productList.add(product);
		return product;
	}
	
	public static boolean removeProduct(int productId) {
		int idx=-1;
		for(Products list:productList)
		{
			if(list.productId==productId) {
				idx=productList.indexOf(list);
				break;
			}
		}
		if(idx!=-1)
		{
			productList.remove(idx);
			return true;
		}
		return false;
	}

	public static void productList() {
		if(productList.isEmpty())
		{
			System.out.println("No product Available!!");
		}
		else {
			System.out.println("List of the Products");
			for(Products list:productList)
			{
				System.out.println("Product Id : "+list.productId+", Product Name : "+list.productName
						+ ", Product Price : "+list.productPrice+", Product Quality : "+list.productCompany+", Product Warrenty : "
								+list.productWarrenty+", Product Material : "+list.productMaterial);
			}
		}
		
	}
}
