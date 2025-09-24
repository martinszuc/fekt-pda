package sample;

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.AdvancedRobot;

public class TeamRobot1 extends Robot {
	
	/**
	 * MyFirstRobot's run method - Seesaw
	 */
	public void run() {

		while (true) {
			ahead(100);
			turnRight(90);
			ahead(100);
			turnRight(90);
			ahead(100);
			turnRight(90);
			ahead(100);
			turnRight(90);
			
		}
	}

	/**
	 * Fire when we see a robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}

	/**
	 * We were hit!  Turn perpendicular to the bullet,
	 * so our seesaw might avoid a future shot.
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(90 - e.getBearing());
	}
}