package abstractDayAtTheRaces;

/*
Skeleton class for a Motorcycle Ver 1.0
You Li 2017-08-10
*/


public class Motorcycle extends abstractAuto{

	public Motorcycle() {
		numberOfWheels = 2;
		speed = 0;
		maxSpeed = 100;
		acceleration = 20;
		position = 0;
		raceProgress = 0;
	}
	
	
	public Motorcycle(float maxSpeedIn) {
		numberOfWheels = 4;
		speed = 0;
		maxSpeed = maxSpeedIn;
		acceleration = 20;
		position = 0;
		raceProgress = 0;
	}

	@Override
	void accelerate() {
		// TODO Auto-generated method stub
		speed += acceleration * 1.00;
		
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "Motorcycle ";
	
	}

}
