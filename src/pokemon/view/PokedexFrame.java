package pokemon.view;

import javax.swing.JFrame;
import pokemon.controller.PokedexController;

public class PokedexFrame extends JFrame
{

	private PokedexController appController;
	private PokedexPanel appPanel;
	
	public PokedexFrame(PokedexController appController)
	{
		super();
		this.appController = appController;
		this.appPanel = new PokedexPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(800, 800);
		this.setTitle("My GUI");
		this.setResizable(true);
		this.setVisible(true);
	}
	
}
