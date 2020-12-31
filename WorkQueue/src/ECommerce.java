
public class ECommerce
{
	public enum ProductType
	{
		apples,
		oranges,
		bananas
	}
	
	//Queue<ProductType> requests = new Queue<ProductType>();
	Queue<String> transactionLog = new Queue<String>();
	Queue<Worker> requests = new Queue<Worker>();
	
	int[] inventoryProducts = new int[3];
	double[] profitProducts = new double[3];
	
	double totalProfitApples;
	double totalProfitOranges;
	double totalProfitBananas;
	
	double totalCostApples;
	double totalCostOranges;
	double totalCostBananas;
	
	public ECommerce()
	{
		
	}
	public void processRequests()
	{
		while(!requests.isEmpty())
		{
			Worker action = requests.dequeue();
			action.execute();
			if(action.getProduct() == ECommerce.ProductType.apples)
			{
				inventoryProducts[0] = action.getInventory();
				profitProducts[0] = action.getProfits();
				transactionLog.enqueue(action.getTransaction());
				totalCostApples+=action.getCost();
			}
			else if (action.getProduct() == ECommerce.ProductType.oranges)
			{
				inventoryProducts[1] = action.getInventory();
				profitProducts[1] = action.getProfits();
				transactionLog.enqueue(action.getTransaction());
				totalCostApples+=action.getCost();
			}
			else
			{
				inventoryProducts[2] = action.getInventory();
				profitProducts[2] = action.getProfits();
				transactionLog.enqueue(action.getTransaction());
				totalCostApples+=action.getCost();
			}
		}
	}
	public void recieveGoods(ProductType product, int quantity, double cost)
	{
		RecieveGoods recieved;
		if(product == ProductType.apples)
		{
			recieved = new RecieveGoods(product, quantity, cost, inventoryProducts[0], profitProducts[0]);
			totalProfitApples+=cost;
		}
		else if(product == ProductType.oranges)
		{
			recieved = new RecieveGoods(product, quantity, cost, inventoryProducts[1], profitProducts[1]);
			totalProfitOranges+=cost;
		}
		else
		{
			recieved = new RecieveGoods(product, quantity, cost, inventoryProducts[2], profitProducts[2]);
			totalProfitBananas+=cost;
		}
		requests.enqueue(recieved);
	}
	public void sellGoods(ProductType product, int quantity, double cost)
	{
		RecieveGoods sold;
		if(product == ProductType.apples)
		{
			sold = new RecieveGoods(product, quantity, cost, inventoryProducts[0], profitProducts[0]);
			totalCostApples+=cost;
		}
		else if(product == ProductType.oranges)
		{
			sold = new RecieveGoods(product, quantity, cost, inventoryProducts[1], profitProducts[1]);
			totalCostOranges+=cost;
		}
		else
		{
			sold = new RecieveGoods(product, quantity, cost, inventoryProducts[2], profitProducts[2]);
			totalCostBananas+=cost;
		}
		requests.enqueue(sold);
	}
	public void printInventory()
	{
		System.out.println("apples in stock: "+ inventoryProducts[0]);
		System.out.println("oranges in stock: "+ inventoryProducts[1]);
		System.out.println("bananas in stock: "+ inventoryProducts[2]);

	}
	public void printFinancials()
	{
		System.out.println("Cost of apples: "+ totalCostApples);
		System.out.println("Recieved for apples sold: "+ totalProfitApples);
		
		System.out.println("Cost of oranges: "+ totalCostOranges);
		System.out.println("Recieved for oranges sold: "+ totalProfitOranges);
		
		System.out.println("Cost of bananas: "+ totalCostBananas);
		System.out.println("Recieved for bananas sold: "+ totalProfitBananas);
		
		System.out.println("Total cost: "+ (totalCostApples+totalCostOranges+totalCostBananas));
		System.out.println("Total recieved: "+ (totalProfitApples+totalProfitOranges+totalProfitBananas));
		System.out.println("Net Profit: "+ (profitProducts[0]+profitProducts[1]+profitProducts[2]));
		
	}
	

}
