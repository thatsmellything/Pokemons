package pokemon.model;

public class pikachu extends Pokemon implements Electric
{
	public pikachu(int num, String name)
	{
		super(num, name);
	}

	
	public int tazer() 
	{
		return 30;
	}
	
	public double thunder()
	{
		return 100.00;
	}
}
