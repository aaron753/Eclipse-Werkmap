/**
 * 
 */
package asteroids;

/**
 * @author Thibault
 *
 */
public class Facade implements IFacade {

	/**
	 * 
	 */
	public Facade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create a new ship with a default position, velocity, radius and direction.
	 * 
	 * Result is a unit circle centered on <code>(0, 0)</code> facing right. Its
	 * speed is zero.
	 */
	
	public IShip createShip() {
		return new Ship(0,0,0,0,15,0);
	}

	/**
	 * Create a new non-null ship with the given position, velocity, radius and
	 * angle (in radians).
	 */
	
	public IShip createShip(double x, double y, double xVelocity,
			double yVelocity, double radius, double angle) {
		return new Ship(x,y,xVelocity,yVelocity,radius,angle);
	}

	/**
	  * Return the x-coordinate of <code>ship</code>.
	  */
	
	public double getX(IShip ship) {
		return ((Ship)ship).getXPos();
	}

	/**
	  * Return the y-coordinate of <code>ship</code>.
	  */
	
	public double getY(IShip ship) {
		return ((Ship)ship).getYPos();
	}

	/**
	  * Return the velocity of <code>ship</code> along the X-axis.
	  */
	
	public double getXVelocity(IShip ship) {
		return ((Ship)ship).getXVel();
	}

	/**
	  * Return the velocity of <code>ship</code> along the Y-axis.
	  */
	
	public double getYVelocity(IShip ship) {
		return ((Ship)ship).getYVel();
	}

	/**
	  * Return the radius of <code>ship</code>.
	  */
	
	public double getRadius(IShip ship) {
		return ((Ship)ship).getRadius();
	}

	/**
	  * Return the direction of <code>ship</code> (in radians).
	  */
	
	public double getDirection(IShip ship) {
		return ((Ship)ship).getAngle();
	}

	/**
	  * Update <code>ship</code>'s position, assuming it moves <code>dt</code>
	  * seconds at its current velocity.
	  */
	
	public void move(IShip ship, double dt) {
		((Ship)ship).move(dt);
	}

	/**
	  * Update <code>ship</code>'s velocity based on its current velocity, its
	  * direction and the given <code>amount</code>.
	  */
	
	public void thrust(IShip ship, double amount) {
		((Ship)ship).thrust(amount);
	}

	/**
	  * Update the direction of <code>ship</code> by adding <code>angle</code> (in
	  * radians) to its current direction. <code>angle</code> may be negative.
	  */
	
	public void turn(IShip ship, double angle) {
		((Ship)ship).turn(angle);
	}

	/**
	  * Return the distance between <code>ship1</code> and <code>ship2</code>.
	  * 
	  * The absolute value of the result of this method is the minimum distance
	  * either ship should move such that both ships are adjacent. Note that the
	  * result must be negative if the ships overlap. The distance between a ship
	  * and itself is 0.
	  */
	
	public double getDistanceBetween(IShip ship1, IShip ship2) {
		return ((Ship)ship1).getDistanceBetween(ship2);
	}

	/**
	  * Check whether <code>ship1</code> and <code>ship2</code> overlap. A ship
	  * always overlaps with itself.
	  */
	
	public boolean overlap(IShip ship1, IShip ship2) {
		return ((Ship)ship1).overlap(ship2);
	}

	/**
	  * Return the number of seconds until the first collision between
	  * <code>ship1</code> and <code>ship2</code>, or Double.POSITIVE_INFINITY if
	  * they never collide. A ship never collides with itself.
	  */
	
	public double getTimeToCollision(IShip ship1, IShip ship2) {
		return ((Ship)ship1).getTimeToCollision(ship2);
	}

	/**
	  * Return the first position where <code>ship1</code> and <code>ship2</code>
	  * collide, or <code>null</code> if they never collide. A ship never collides
	  * with itself.
	  * 
	  * The result of this method is either null or an array of length 2, where the
	  * element at index 0 represents the x-coordinate and the element at index 1
	  * represents the y-coordinate.
	  */
	
	public double[] getCollisionPosition(IShip ship1, IShip ship2) {
		return ((Ship)ship1).getCollisionPosition(ship2);
	}

}
