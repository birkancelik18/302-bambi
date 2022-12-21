package Domain.GameObjects.Powerups;

import Domain.Game.Location;

import java.awt.*;

public interface IPowerup {
	public String getType();
	public int getWidth();
	public int getHeight();
	public Location getLocation();
	public void setLocation(double x , double y, int width, int height);
	public void draw(Graphics g);
	public String getImagePath();
}
