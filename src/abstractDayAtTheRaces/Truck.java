package abstractDayAtTheRaces;
/*
	Skeleton class for a Truck 
	Author: Mike King, 2013
*/


public class Truck extends abstractAuto{

	public Truck() {
		numberOfWheels = 8;
		speed = 0;
		maxSpeed = 80;
		acceleration = 5;
		position = 0;
		raceProgress = 0;
	}
	
	
	

	@Override
	void accelerate() {
		// TODO Auto-generated method stub
		speed += acceleration * 0.40;
		
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "Truck ";
	
	}

}
