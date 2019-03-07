package pokemon.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pokemon.view.PokedexFrame;
import pokemon.model.*;

public class PokedexController
{

	//data members
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	private String saveFile = "backup.pokemon";
	//constructor
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		this.appFrame = new PokedexFrame(this);
	}
	
	
	public void start()
	{
		
	}
	
	//getters
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return this.pokemonList;
	}
	
	public PokedexFrame getFrame()
	{
		return appFrame;
	}
	
	//methods
	
	private void addPokemon()
	{
		pokemonList.add(new pichu(172, "Pichu"));
		pokemonList.add(new pikachu(173, "Pikachu"));
		pokemonList.add(new turtwig(387, "Turtwig"));
		pokemonList.add(new grotle(388, "Grotle"));
		pokemonList.add(new torterra(388, "Torterra"));
		pokemonList.add(new charmander(4, "Charmander"));
		pokemonList.add(new charmeleon(5, "Charmeleon"));
		pokemonList.add(new charizard(6, "Charizard"));
		pokemonList.add(new squirtle(7, "Squirtle"));
		pokemonList.add(new wartortle(8, "Wartortle"));
		pokemonList.add(new blastoise(9, "Blastoise"));
		pokemonList.add(new mew(151, "Mew"));
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
			FileInputStream inputStream = new FileInputStream(saveFile);
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
	
	
	public String[] buildPokedexText()
	{
		String[] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
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
	
	public boolean isBoolean(String maybeBool)
	{
		boolean isValid = false;
		
		
		try
		{
			Boolean.parseBoolean(maybeBool);
			isValid = true;
		}
		catch(NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "you should type a boolean like true or false");
		}
		
		return isValid;
	 }
	
	
	
	
	
}
	