package Domain.GameObjects.Powerups;

import Domain.Game.Location;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class TimePowerup implements IPowerup {

    public String type;
    public String imagePath;
    public Location location;
    private int width;
    private int height;

    public TimePowerup() {
        type = "time";
        width = 25;
        height = 25;
        int Xloc = ((ThreadLocalRandom.current().nextInt(9) % 9)+1) * 50 + 10;
        int Yloc = ((ThreadLocalRandom.current().nextInt(9) % 9)+1) * 50 + 10;
        location = new Location(Xloc, Yloc); 
        imagePath = "EscapeFromKoc/src/UI/Utilities/Images/timePowerup.png";
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
        g.drawImage(image, (int)loc.getXLocation(), (int)loc.getYLocation(), 25, 25, null);
    }  
}
