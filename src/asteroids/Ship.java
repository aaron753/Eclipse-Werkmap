package asteroids;

public class Ship implements IShip {

	private double xPos;	//all aspects related to  position -> defensively
	private double yPos;
	private double xVel;	//all aspects related to velocity -> total manner
	private double yVel;
	private double maxVel = 300000; //zie tekst
	private double angle;   //all aspects related to direction -> nominally
	private double radius; 			//zie tekst
		
	public Ship(double xPos, double yPos, double xVel, double yVel, double radius, double angle) {
		xPos = this.xPos;
		yPos = this.yPos;
		xVel = this.xVel;
		yVel = this.yVel;
		radius = this.radius;
		angle = this.angle;
	}
		
	public void move(double dt){
		xPos = xPos + xVel*dt;
		yPos = yPos + yVel*dt;
	}
		
	public void turn(double hoek){
		angle = angle + hoek;
	}
		
	public void thrust(double a){
		xVel = xVel + a*java.lang.Math.cos(angle);
		yVel = yVel + a*java.lang.Math.sin(angle);
	}
		
	public double getXPos(){
		return xPos;
	}
	
	public double getYPos(){	
		return yPos;
	}
		
	public double getXVel(){
		return xVel;
	}
		
	public double getYVel(){
		return yVel;
	}
		
	public double getMaxVel(){
		return maxVel;
	}
		
	public double getAngle(){
		return angle;
	}
		
	public double getRadius(){
		return radius;	
	}
}