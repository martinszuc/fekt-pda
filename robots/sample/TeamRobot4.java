package sample;

import java.awt.Color;

import robocode.HitByBulletEvent;

import robocode.HitRobotEvent;

import robocode.Robot;

import robocode.ScannedRobotEvent;

public class TeamRobot4 extends Robot {

	boolean peek; // Don't turn if there's a robot there

	double moveAmount; // How much to move

	/**
	 * 
	 * run: Move around the walls
	 * 
	 */

	public void run() {

		setBodyColor(Color.white);

		setGunColor(Color.black);

		setRadarColor(Color.white);

		setBulletColor(Color.black);

		setScanColor(Color.white);

		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());

		peek = false;

		turnLeft(getHeading() % 90);

		ahead(moveAmount);

		peek = true;

		turnGunRight(90);

		turnRight(90);

		while (true) {

			// Look before we turn when ahead() completes.

			peek = true;

			// Move up the wall

			ahead(moveAmount);

			// Don't look now

			peek = false;

			// Turn to the next wall

			turnRight(90);

		}

	}

	/**
	 * 
	 * onHitRobot: Move away a bit.
	 * 
	 */

	public void onHitRobot(HitRobotEvent e) {

		if (e.getBearing() > -90 && e.getBearing() < 90) {

			back(120);

		}

		else {

			ahead(120);

		}

	}

	/**
	 * 
	 * onScannedRobot: Fire!
	 * 
	 */

	public void onScannedRobot(ScannedRobotEvent e) {

		fire(5);

		if (peek) {

			scan();

		}

	}

}
