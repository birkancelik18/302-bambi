package Domain.Game;

public class Player {
	public Avatar avatar;
	public Inventory inventory;
	double score=0;
	double health=100;
	EscapeFromKocGame escapeFromKocGame;	
	
	public Player() {
		inventory = new Inventory();
		avatar = new Avatar(25);   //unitlength
		escapeFromKocGame = EscapeFromKocGame.getInstance();		
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public void moveAvatar(String direction) {
		avatar.move(direction);
	}

	public void catchPowerup() {
		Powerup activatedPowerup = avatar.activatePowerup();
		if(activatedPowerup!=null) {
			//inventory.increaseNumberOfPowerups();
		}
	}
	public void pickKey() {
		Key key = avatar.pickKey();		
	}

	public void pickPowerup(String type) {
	}

	public void incrementScore(double increment) {
		score+=increment;
	}

}
