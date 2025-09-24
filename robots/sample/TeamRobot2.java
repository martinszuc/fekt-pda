package sample;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class TeamRobot2 extends Robot {

	
	boolean peek; // Don't turn if there's a robot there
	double moveAmount; // How much to move
	int count = 0; // Keeps track of how long we've
	// been searching for our target
	double gunTurnAmt; // How much to turn our gun when searching
	String trackName; // Name of the robot we're currently tracking
	/**
	 * MyFirstRobot's run method - Seesaw
	 */
	public void run() {

		
		
		setBodyColor(Color.pink);
		setGunColor(Color.pink);
		setRadarColor(Color.pink);
		setBulletColor(Color.pink);
		setScanColor(Color.pink);
		
		// Initialize moveAmount to the maximum possible for this battlefield.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		// Initialize peek to false
		peek = false;
		
		// Prepare gun
				trackName = null; // Initialize to not tracking anyone
				setAdjustGunForRobotTurn(true); // Keep the gun still when we turn
				gunTurnAmt = 10; // Initialize gunTurn to 10

				// Loop forever
				while (true) {
					// turn the Gun (looks for enemy)
					turnGunRight(gunTurnAmt);
					// Keep track of how long we've been looking
					count++;
					// If we've haven't seen our target for 2 turns, look left
					if (count > 2) {
						gunTurnAmt = -10;
					}
					// If we still haven't seen our target for 5 turns, look right
					if (count > 5) {
						gunTurnAmt = 10;
					}
					// If we *still* haven't seen our target after 10 turns, find another target
					if (count > 11) {
						trackName = null;
					}
					
				}
		}
	
	
	public void onHitRobot(HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(150);
		} // else he's in back of us, so set ahead a bit.
		else {
			ahead(150);
		}
	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(3);
		// Note that scan is called automatically when the robot is moving.
		// By calling it manually here, we make sure we generate another scan event if there's a robot on the next
		// wall, so that we do not start moving up it until it's gone.
		if (peek) {
			scan();
		}
	}
}
