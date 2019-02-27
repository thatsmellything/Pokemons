package pokemon.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import pokemon.model.*;

public class PokedexController
{

	
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	private String saveFile = "backup.pokemon";
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
	
	public String [] getPokemonData(int index)
	{
		String [] data = new String [6];
		Pokemon current = pokemonList.get(index);
		data[0] = current .getAttackPoints() + "";
		data[1] = current .getEnhancementModifier() + "";
		data[2] = current .getHealthPoints() + "";
		data[3] = current .getName() + "";
		data[4] = current .isCanEvolve() + "";
		data[5] = current .getNumber() + "";
		return data;
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
	
	public void savePokedex()
	{
		try
		{
			FileOutputStream saveStream = new FileOutputStream(saveFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream);
			output.writeObject(pokemonList);;
			output.close();
			saveStream.close();
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, error.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadPokedex()
	{
		try
		{
			ArrayList<Pokemon> saved = new ArrayList<Pokemon>();
			FileInputStream inputStream = new FileInput Stream(saveFile);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			saved = (ArrayList<Pokemon>) input.readObject();
			input.close();
			pokemonList = saved;
		}
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, "No Save File", "Loading Pokemon", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (ClassNotFoundException pokemonError)
		{
			JOptionPane.showMessageDialog(appFrame, pokemonError.getMessage(), "Type Error", JOptionPane.ERROR_MESSAGE);
		}
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
	