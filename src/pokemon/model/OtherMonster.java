package pokemon.model;

public class OtherMonster extends Pokemon implements Grass
{

	public OtherMonster(int num, String name)
	{
		super(num, name);
	}
	
	public void quickAttack()
	{
		
	}
	public int leafyAttack()
	{
		return 10;
	}
}
