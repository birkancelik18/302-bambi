package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

import Domain.Controller.GameController;
import Domain.Controller.PlayerController;



public class RunningModeFrame extends JFrame{
	private static final String BACKGROUND_IMAGE_ADDRESS = "src/images/background.png";
	private static final long serialVersionUID = 1L;
	public int clockMiliSeconds;
	private int gameStatus = 0;
    GameController game;	
    
    public RunningModeFrame() {
		super("Running Mode");

		game = GameController.getInstance();
		game.setPlayer(new PlayerController());
		clockMiliSeconds = 20;

		//initialize frame
		setBounds(300,200, (4*1000)/3, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);


		//add game panel
		final LayoutPanel gamePanel = new LayoutPanel("Running Mode");
		gamePanel.setOpaque(false);
		add(gamePanel);
		

		setVisible(true); 
		pack();

		//timer tick
		ActionListener tickListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!game.isOver()) {
					gamePanel.repaint();
				}else {
					if(gameStatus==0) {
						gameStatus=1;
						dispose();			
					}
				}

			}

		};

		Timer timer = new Timer(clockMiliSeconds, tickListener);
		timer.start();

		addKeyListener(new GameKeyListener(game));
	}

}