
public abstract class Worker 
{
	
	public Worker()
	{
		
	}
	public abstract void execute();
	
	
	public abstract ECommerce.ProductType getProduct() ;
	public abstract int getQuantity();
	public abstract double getCost() ;
	public abstract String getTransaction() ;
	public abstract int getInventory();
	public abstract double getProfits();
}
