package Domain.GameObjects.Powerups;

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import Domain.Controllers.GameController;
import Domain.Game.Location;
import javax.swing.ImageIcon;
import java.awt.Image;

public class BottlePowerup implements IPowerup {

    public String type;
	public String imagePath;
	public Location location;
    private int width, height, size;
	public GameController game;
    
    public BottlePowerup() {
        type = "bottle";
    	game = GameController.getInstance();
        width = game.getGameState().width;
        height = game.getGameState().height;
        size = game.getGameState().gridSize;
        location = game.getAvailableLocation(); 
        imagePath = "EscapeFromKoc/src/UI/Utilities/Images/bottlePowerup.png";
    }	

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(double x, double y, int width, int height) {
        location.updateLocation(x, y);
    }

    @Override
    public String getImagePath() {
		return imagePath;
	}

    @Override
    public void draw(Graphics g) {
        Location loc = this.location;
        Image image = new ImageIcon(imagePath).getImage();
        g.drawImage(image, (int)loc.getXLocation(), (int)loc.getYLocation(), size, size, null);
    }
}
