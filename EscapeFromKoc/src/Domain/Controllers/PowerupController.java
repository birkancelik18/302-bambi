package Domain.Controllers;

import Domain.GameObjects.Powerups.IPowerup;
import Domain.GameObjects.Powerups.PowerupFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PowerupController {
    PowerupFactory factory;
    IPowerup powerup;

    public PowerupController() {
        factory = new PowerupFactory();
    }

    public IPowerup getPowerup(){
        return powerup;
    }

    public void setPowerup(IPowerup powerup){
        this.powerup = powerup;
    }

    public void deletePowerup(){
        this.powerup = null;
    }

    public IPowerup createPowerupRandomly() {
        List<String> powerupTypeList = Arrays.asList("time", "hint", "vest", "bottle", "life");
        int randomTypeIndex = ThreadLocalRandom.current().nextInt(powerupTypeList.size()) % powerupTypeList.size();
        String randomType = powerupTypeList.get(randomTypeIndex);
        IPowerup powerup = factory.createPowerup(randomType);
        System.out.println(randomType);
        return powerup;
    }
}
