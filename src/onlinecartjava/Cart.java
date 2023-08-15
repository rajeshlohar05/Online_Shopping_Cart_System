package onlinecartjava;

public class Cart extends Shop {

	public static boolean addToCart(int productId) {
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
			cartList.add(productList.get(idx));
			return true;
		}
		
		return false;
	}

	public static boolean removeCart(int productId) {
		int idx=-1;
		for(Products list:cartList)
		{
			if(list.productId==productId) {
				idx=cartList.indexOf(list);
				break;
			}
		}
		if(idx!=-1)
		{
			cartList.remove(idx);
			return true;
		}
		return false;
	}

	public static void cartList() {
		if(cartList.isEmpty())
		{
			System.out.println("No Product Available in Cart!!");
		}
		else
		{
			System.out.println("Cart List");
			for(Products list:cartList) {
				System.out.println("Product Id : "+list.productId+", Product Name : "+list.productName
						+ ", Product Price : "+list.productPrice+", Product Quality : "+list.productCompany+", Product Warrenty : "
								+list.productWarrenty+", Product Material : "+list.productMaterial);
			}
		}
		
	}
}
