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
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		this.appController = appController;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(myButton);
		
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
