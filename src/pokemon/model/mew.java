package pokemon.model;
import java.util.Random;
public class mew extends Pokemon implements Psychic
{
	public mew(boolean kgb)
	{
		super(kgb);
	}
	public boolean KGBBrainwash()
	{
		Random rand = new Random();
		int n = rand.nextInt(1);
		if (n == 1)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	
}
