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
	
	private JButton myButton;
	private JComboBox pokedexDropdown;
	
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
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		this.appController = appController;
		
		numberField = new JTextField("0");
		nameField = new JTextField("pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		numberLabel = new JLabel("This pokemon number is");
		nameLabel = new JLabel("This pokemon health is");
		evolveLabel = new JLabel("This pokemon cannot evolve");
		attackLabel = new JLabel("This pokemon attack level is");
		enhanceLabel = new JLabel("This pokemon enhancements are");
		healthLabel = new JLabel("This pokemon health is");
		imageLabel = new JLabel("pokemon goes here");
		
		myButton = new JButton("Click here to change the pokevalues");
		pokedexDropdown = new JComboBox();//stub
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		
		this.add(myButton);
		this.add(pokedexDropdown);
		
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(healthLabel);
		
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, myButton,174, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, myButton,-135, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		myButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent mouseClick)
	{
		
	}
		});
	}
}
