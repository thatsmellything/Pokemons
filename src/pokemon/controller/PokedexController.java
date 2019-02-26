package pokemon.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import pokemon.model.*;

public class PokedexController
{

	
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		this.appFrame = new PokedexFrame(this);
	}
	
	private void addPokemon()
	{
		pokemonList.add(new pichu(172, "myPichu"));
		pokemonList.add(new pikachu(173, "myPikachu"));
		pokemonList.add(new turtwig(387, "myTurtwig"));
		pokemonList.add(new grotle(388, "myGrotle"));
		pokemonList.add(new torterra(388, "myTorterra"));
		pokemonList.add(new charmander(4, "myCharmander"));
		pokemonList.add(new charmeleon(5, "myCharmelion"));
		pokemonList.add(new charizard(6, "myCharizard"));
		pokemonList.add(new squirtle(7, "mySquirtle"));
		pokemonList.add(new wartortle(8, "myWartortle"));
		pokemonList.add(new blastoise(9, "myBlastoise"));
		pokemonList.add(new mew(151, "myMew"));
	}
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return pokemonList;
	}
	
	public void updatePokemon(int index, String[] data )
	{
		if (data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
		}
	}
	
	public String[] buildPokedexText()
	{
		String[] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}
	
	public PokedexFrame getFrame()
	{
		return appFrame;
	}
	
	public boolean isInt(String maybeInt)
	{
		boolean isValid = false;
		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch(NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null,  "Please type an int value: ");
		}
		return isValid;
		
	}
	
	
	public boolean isDouble(String maybeDouble)
	{
		boolean isValid = false;
		
		try
		{
			Double.parseDouble(maybeDouble);
			isValid = true;
		}
		catch(NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "Please type a number with a decimal in it :)");
		}
		
		return isValid;
}
	
	
	
	
	
	
}
	