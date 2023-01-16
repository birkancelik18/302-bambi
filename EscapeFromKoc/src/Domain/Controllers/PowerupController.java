package Domain.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;

import Domain.GameObjects.Powerups.PowerupFactory;
import Domain.Alien.TimeWastingAlien;
import Domain.Alien.TimeWastingStrategy;
import Domain.GameObjects.Powerups.IPowerup;

public class PowerupController {
    PowerupFactory factory;
    IPowerup powerup;
    private GameController game = GameController.getInstance();
    private final int powerupTimersec = 1000;
    private int PowerupCounterTime = 1;
    private boolean powerupBoolean = false;
    private int hintTime = 0;
    private int bottleTime = 0;
    
    ActionListener shooterActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!game.isPaused()) {
				if(PowerupCounterTime == 6){
					IPowerup powerupx = createPowerupRandomly();
					setPowerup(powerupx);
					PowerupCounterTime = 0;
					powerupBoolean = !powerupBoolean;
				}
				if(!powerupBoolean){
					setPowerup(null);
				}
				
				if(game.getGameState().getHintActive()){
					hintTime++;
				}
				if(hintTime == 10*1000/powerupTimersec) {
					game.getGameState().setHintActive(false);
					hintTime = 0;
				}
				
				if(game.getGameState().getIsBottlePowerupActive()){
					bottleTime++;
				}
				if(bottleTime == 10*1000/powerupTimersec) {
					game.getGameState().setIsBottlePowerupActive(false);
					bottleTime = 0;
				}
			}
			PowerupCounterTime++;
		}
	};
	
    private Timer powerupTimer = new Timer(powerupTimersec, shooterActionListener);

    public PowerupController() {
        factory = new PowerupFactory();
        System.out.println("powerup timer start");
        powerupTimer.start();
    }

    public IPowerup getPowerup(){
        return powerup;
    }

    public void setPowerup(IPowerup powerup){
        this.powerup = powerup;
    }

    public void deletePowerup(IPowerup powerup){
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
    
    public void resetPowerupTime() {
    	PowerupCounterTime = 1;
    }
}
