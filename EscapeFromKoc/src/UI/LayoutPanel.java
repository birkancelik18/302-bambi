package UI;

import Domain.Alien.Alien;
import Domain.Controllers.GameController;
import Domain.Game.GameMouseListener;
import Domain.GameObjects.GameObject;
import Domain.GameObjects.Powerups.IPowerup;
import Domain.Player.Avatar;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class LayoutPanel extends JPanel {
    GameController game;
	public LayoutPanel(String title) {
        super();
        game = GameController.getInstance();
        setSize(1000, 800);
        setVisible(true);
        GameMouseListener mlisteners = new GameMouseListener(game);
		addMouseListener(mlisteners);		
    }

    public void repaint( Graphics g ) {  
		game.getPlayer().getAvatar().draw(g);
    } 
    public void paint( Graphics g ) {  
	    for (int x = 50; x <= 500; x += 50 ){
	        for (int y = 50; y <= 500; y += 50 ){
	            g.drawRect(x, y, 50, 50);
            }
        }
	    
    	LinkedList<GameObject> objectList = game.currentBuilding.getObjectList();
	    for(int i=0; i<objectList.size(); i++) { //Hardcoded
	    	GameObject obj = objectList.get(i);
	    	obj.draw(g);
	    }

        IPowerup powerup = game.getPowerupController().getPowerup();
        if(powerup != null){
            powerup.draw(g);
        }

        Alien alien = game.getAlienController().getAlien();
        if(alien != null){
            alien.draw(g);
        }
        
        Avatar avatar = game.getPlayer().getAvatar();
	    avatar.draw(g);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(900,600);
    }
}
