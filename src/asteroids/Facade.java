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
	@Override
	public IShip createShip() {
		IShip ship = new Ship(0,0,0,0,10,0);
		return ship;
	}

	/**
	 * Create a new non-null ship with the given position, velocity, radius and
	 * angle (in radians).
	 */
	@Override
	public IShip createShip(double x, double y, double xVelocity,
			double yVelocity, double radius, double angle) {
		IShip ship = new Ship(x,y,xVelocity,yVelocity,radius,angle);
		return ship;
	}

	/**
	  * Return the x-coordinate of <code>ship</code>.
	  */
	@Override
	public double getX(IShip ship) {
		return ((Ship)ship).getXPos();
	}

	/**
	  * Return the y-coordinate of <code>ship</code>.
	  */
	@Override
	public double getY(IShip ship) {
		return ((Ship)ship).getYPos();
	}

	/**
	  * Return the velocity of <code>ship</code> along the X-axis.
	  */
	@Override
	public double getXVelocity(IShip ship) {
		return ((Ship)ship).getXVel();
	}

	/**
	  * Return the velocity of <code>ship</code> along the Y-axis.
	  */
	@Override
	public double getYVelocity(IShip ship) {
		return ((Ship)ship).getYVel();
	}

	/**
	  * Return the radius of <code>ship</code>.
	  */
	@Override
	public double getRadius(IShip ship) {
		return ((Ship)ship).getRadius();
	}

	/**
	  * Return the direction of <code>ship</code> (in radians).
	  */
	@Override
	public double getDirection(IShip ship) {
		return ((Ship)ship).getAngle();
	}

	/**
	  * Update <code>ship</code>'s position, assuming it moves <code>dt</code>
	  * seconds at its current velocity.
	  */
	@Override
	public void move(IShip ship, double dt) {
		((Ship)ship).move(dt);
	}

	/**
	  * Update <code>ship</code>'s velocity based on its current velocity, its
	  * direction and the given <code>amount</code>.
	  */
	@Override
	public void thrust(IShip ship, double amount) {
		((Ship)ship).thrust(amount);
	}

	/**
	  * Update the direction of <code>ship</code> by adding <code>angle</code> (in
	  * radians) to its current direction. <code>angle</code> may be negative.
	  */
	@Override
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
	@Override
	public double getDistanceBetween(IShip ship1, IShip ship2) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	  * Check whether <code>ship1</code> and <code>ship2</code> overlap. A ship
	  * always overlaps with itself.
	  */
	@Override
	public boolean overlap(IShip ship1, IShip ship2) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	  * Return the number of seconds until the first collision between
	  * <code>ship1</code> and <code>ship2</code>, or Double.POSITIVE_INFINITY if
	  * they never collide. A ship never collides with itself.
	  */
	@Override
	public double getTimeToCollision(IShip ship1, IShip ship2) {
		// TODO Auto-generated method stub
		return 0;
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
	@Override
	public double[] getCollisionPosition(IShip ship1, IShip ship2) {
		// TODO Auto-generated method stub
		return null;
	}

}
