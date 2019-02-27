package pokemon.view;

import javax.swing.*;
import pokemon.controller.PokedexController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokedexPanel extends JPanel
{

	private PokedexController appController;
	
	private SpringLayout appLayout;
	private JButton saveButton;
	private JButton changeButton;
	private JComboBox<String> pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		this.appController = appController;
		this.appLayout = new SpringLayout();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/pokeball.png"));
		
		numberField = new JTextField("0");
		
		nameField = new JTextField("pokename");
		
		evolveField = new JTextField("false");
		
		attackField = new JTextField("0");
		
		enhancementField = new JTextField("0");
		
		healthField = new JTextField("0");
		
		
		
		
		
		
		numberLabel = new JLabel("This pokemon number is");
		
		nameLabel = new JLabel("This pokemon name is");
		
		evolveLabel = new JLabel("This pokemon cannot evolve");
		
		attackLabel = new JLabel("This pokemon attack level is");
		
		enhanceLabel = new JLabel("This pokemon enhancements are");
		
		healthLabel = new JLabel("This pokemon health is");
		
		imageLabel = new JLabel("pokemon goes here", new ImageIcon(PokedexPanel.class.getResource("/pokemon/view/images/pokeball2.png")), JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 52, SpringLayout.WEST, this);
		
		
		changeButton = new JButton("Click here to change the pokevalues");
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -6, SpringLayout.NORTH, changeButton);
		
		
		pokedexDropdown = new JComboBox<String>();//stub
		
		
		
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupDropdown() 
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(appController.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		
		this.add(changeButton);
		this.add(pokedexDropdown);
		this.add(healthField);
		this.add(numberField);
		this.add(evolveField);
		this.add(enhancementField);
		this.add(attackField);
		this.add(nameField);
		
		
		
		this.add(healthLabel);
		this.add(numberLabel);
		this.add(evolveLabel);
		this.add(enhanceLabel);
		this.add(attackLabel);
		this.add(nameLabel);
		this.add(imageLabel);
		
		
		
		JButton saveButton = new JButton("Save Button");
		
		add(saveButton);
		
		
		
		
		
		
	}
	
	private void setupLayout()
	{
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, changeButton);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -41, SpringLayout.EAST, this);
		numberField.setHorizontalAlignment(SwingConstants.RIGHT);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 560, SpringLayout.WEST, this);
		evolveField.setHorizontalAlignment(SwingConstants.RIGHT);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, evolveField);
		attackField.setHorizontalAlignment(SwingConstants.RIGHT);
		enhancementField.setHorizontalAlignment(SwingConstants.RIGHT);
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, 0, SpringLayout.EAST, healthField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, numberField);
		healthField.setHorizontalAlignment(SwingConstants.RIGHT);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 10, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -170, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 55, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 27, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 6, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 30, SpringLayout.SOUTH, numberField);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 6, SpringLayout.EAST, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 33, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, enhanceLabel, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 28, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 29, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, -32, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, changeButton);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 4, SpringLayout.EAST, changeButton);
	}
	
	private void sendDataToController()
	{

		int index = pokedexDropdown.getSelectedIndex();
		
		if(appController.isInt(attackField.getText()) && appController.isDouble(enhancementField.getText()) && appController.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			
			//insert code here
			appController.updatePokemon(index, data);
		}

	};
	
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "pokeball";
		String extension = ".png";
		try 
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void updateFields(int index)
	{
		String [] data = appController.getPokemonData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				sendDataToController();
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.savePokedex();
			}

			
		});
				
		
		pokedexDropdown.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent selection)
					{
					String name = pokedexDropdown.getSelectedItem().toString();
					changeImageDisplay(name);
					}
				});
		
		
	}
}
