public class SellGoods extends Worker 
{

	public int quantity;
	public double cost;
	public String transaction;
	public ECommerce.ProductType product;
	public int inventory;
	public double profits;
	
	public SellGoods(ECommerce.ProductType product, int quantity, double cost, int inventory, double profits)
	{
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
		this.inventory = inventory;
		this.profits = profits;
	}
	
	
	@Override
	public void execute()
	{
		inventory -= quantity;
		profits-=cost;
		if(product == ECommerce.ProductType.apples)
		{
			transaction = "Sold "+ quantity + " apples for $"+cost;
		}
		else if(product == ECommerce.ProductType.oranges)
		{
			transaction = "Sold "+ quantity + " oranges for $"+cost;
		}
		else if(product == ECommerce.ProductType.bananas)
		{
			transaction = "Sold "+ quantity + " bananas for $"+cost;
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public double getCost() {
		return cost;
	}

	public String getTransaction() {
		return transaction;
	}

	public ECommerce.ProductType getProduct() {
		return product;
	}
	
	public int getInventory()
	{
		return inventory;
	}
	public double getProfits()
	{
		return profits;
	}
}
