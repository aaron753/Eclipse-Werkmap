package asteroids;


public class Ship implements IShip {

	private double xPos;	//all aspects related to  position -> defensively
	private double yPos;
	private double xVel;	//all aspects related to velocity -> total manner
	private double yVel;
	final double maxVel = 300000; //zie tekst
	private double angle;   //all aspects related to direction -> nominally
	private double radius; 			//zie tekst
		
	public Ship(double xPos, double yPos, double xVel, double yVel, double radius, double angle) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = xVel;
		this.yVel = yVel;
		this.radius = radius;
		this.angle = angle;
	}
	
     /**
	 * Update <code>ship</code>'s position based on current position and velocity
	 * assuming it moves <code>dt</code> seconds at its current velocity
	 * @param dt  
	 *        the amount of seconds you want the ship to move
	 * @post  the ship will move in its current direction at its current velocity for 
	 *        <code>dt</code> amount of seconds
	 */
	public void move(double dt){
		xPos = xPos + xVel*dt;
		yPos = yPos + yVel*dt;
	}
	
	/**
	 * Update the direction of the <code>ship</code> by adding <code>hoek<code> (in radians) to its current angle of direction.
	 * The <code>hoek<code> may be negative
	 * @param hoek  
	 *        the amount of radians that is added to the current angle of direction
	 * @post  The direction of the ship will change
	 */
	public void turn(double hoek){
		angle = angle + hoek;
	}
	
	/**
	 * Update the position of <code>ship</code> based on its velocity, direction and the <code>a<code> seconds the thruster 
	 * is activated
	 * @param a 
	 *        the amount of seconds the thruster is active
	 * @post  the velocity and direction of the ship will change
	 */
	public void thrust(double a){
		xVel = xVel + a*java.lang.Math.cos(angle);
		yVel = yVel + a*java.lang.Math.sin(angle);
	}
	
	/**
	 * return the x-coordinate of the ship
	 */
	public double getXPos(){
		return xPos;
	}
	
	/**
	 * return the y-coordinate of the ship
	 */
	public double getYPos(){	
		return yPos;
	}
	
	/**
	 * return the current velocity of the ship along the X-axis
	 */	
	public double getXVel(){
		return xVel;
	}
	
	/**
	 * return the current velocity of the ship along the Y-axis
	 */	
	public double getYVel(){
		return yVel;
	}
	
	/**
	 * return the the maximum velocity of the ship
	 */	
	public double getMaxVel(){
		return maxVel;
	}
	
	/**
	 * return the angle of the ship
	 */	
	public double getAngle(){
		return angle;
	}
	
	/**
	 * return the direction of the ship
	 */	
	public double getRadius(){
		return radius;	
	}
	
	/**
	 * Return the distance between the ship and itself.
	 * The distance between a ship and itself is supposed to be 0
	 */
	public double getDistanceBetween(IShip ship){
		double xBetween = xPos - ((Ship)ship).getXPos();
		double yBetween = yPos - ((Ship)ship).getYPos();
		xBetween = xBetween*xBetween;
		yBetween = yBetween*yBetween;
		double distanceBetween = java.lang.Math.sqrt(xBetween + yBetween);
		distanceBetween = distanceBetween - radius - ((Ship)ship).getRadius();
		return distanceBetween;
	}
	
	/**
	 * Check if ship overlaps with itself, if true return "overlapping"
	 * A ship should always overlap with itself
	 */
	public boolean overlap(IShip ship){
		boolean overlapping = false;
		if (getDistanceBetween(ship) < 0){
			overlapping = true;
		}
		return overlapping;
	}
	
	/**
	 * Return the number of seconds until the first collision between ship and
	 * or return Double.POSITIVE_INFINITY if they never collide.
	 * A ship cannot collide with itself.
	 */
	public double getTimeToCollision(IShip ship){
		double timeToCollision;
		
		double deltaRx = xPos - ((Ship)ship).getXPos();
		double deltaRy = yPos - ((Ship)ship).getYPos();
		double deltaVx = xVel - ((Ship)ship).getXVel();
		double deltaVy = yVel - ((Ship)ship).getYVel();
		
		//d berekenen
		double regel1 = (deltaVx*deltaRx + deltaVy*deltaRy)*(deltaVx*deltaRx + deltaVy*deltaRy);
		double regel2 = (deltaVx*deltaVx + deltaVy*deltaVy);
		double regel3 = (deltaRx*deltaRx + deltaRy*deltaRy) - (radius + ((Ship)ship).getRadius())*(radius + ((Ship)ship).getRadius());
		double d = regel1 - (regel2*regel3);
		
		//formule delta t
		double regel4 = (deltaVx*deltaRx + deltaVy*deltaRy);
		double regel5 = java.lang.Math.sqrt(d);
		double regel6 = deltaVx*deltaVx + deltaVy*deltaVy;
		
		double e = (regel4 + regel5) / regel6;
		
		if ((deltaRx*deltaVx + deltaRy*deltaVy) >= 0){
			timeToCollision = Double.POSITIVE_INFINITY;
		}
		else if (d <= 0){
			timeToCollision = Double.POSITIVE_INFINITY;
		}
		else{
			timeToCollision = -e;
		}
		
		return timeToCollision;
	}
	
	public double[] getCollisionPosition(IShip ship){
		double endPointX1;
		double endPointY1;
		
		double endPointX2;
		double endPointY2;
		
		double[] positionArray = new double[2];
		
		endPointX1 = xPos + xVel*getTimeToCollision(ship);
		endPointY1 = yPos + yVel*getTimeToCollision(ship);
		
		endPointX2 = ((Ship)ship).getXPos() + ((Ship)ship).getXVel()*getTimeToCollision(ship);
		endPointY2 = ((Ship)ship).getYPos() + ((Ship)ship).getYVel()*getTimeToCollision(ship);
		
		double radiusRatio = (radius + ((Ship)ship).getRadius()) / radius;
		
		double endPointX = endPointX1 + (endPointX2 - endPointX1)/radiusRatio;
		double endPointY = endPointY1 + (endPointY2 - endPointY1)/radiusRatio;
		
		positionArray[0] = endPointX;
		positionArray[1] = endPointY;
		
		return positionArray;
		
	}
	
	
	
	
}