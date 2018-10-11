package abstractDayAtTheRaces;

/*
Skeleton class for a Unicycle Ver 1.0
You Li 2017-08-10
*/


public class Unicycle extends abstractAuto{

	public Unicycle() {
		numberOfWheels = 2;
		speed = 0;
		maxSpeed = 20;
		acceleration = 5;
		position = 0;
		raceProgress = 0;
	}

	
	public Unicycle(float accelerationIn) {
		numberOfWheels = 4;
		speed = 0;
		maxSpeed = 100;
		acceleration = accelerationIn;
		position = 0;
		raceProgress = 0;
	}
	

	
	
	
	@Override
	void accelerate() {
		// TODO Auto-generated method stub
		speed += acceleration * 0.20;
		
	}

	
	
	
	
	
	
	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "Unicycle ";
	
	}
	
}
