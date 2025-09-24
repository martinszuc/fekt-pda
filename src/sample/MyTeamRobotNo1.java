package sample;

import java.awt.Color;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.HitWallEvent;

/**
 * Task 5 & 6: MyTeamRobotNo1 - Custom robot with distinctive behavior
 * Features: Spiral movement pattern, adaptive firing, and collision avoidance
 */
public class MyTeamRobotNo1 extends Robot {
    
    // Task 7: Optimization parameters - tunable constants
    private double moveDistance = 150;      // Movement distance
    private double turnAngle = 30;          // Turn angle increment  
    private double firePower = 2.0;         // Bullet power
    private double scanAngle = 45;          // Radar scan angle
    private int spiralCounter = 0;          // Counter for spiral movement
    
    /**
     * Task 6: Main robot behavior with infinite loop
     */
    public void run() {
        // Task 5: Set distinctive colors for visual identification
        setBodyColor(Color.RED);        // Red body
        setGunColor(Color.BLACK);       // Black gun
        setRadarColor(Color.YELLOW);    // Yellow radar
        setBulletColor(Color.GREEN);    // Green bullets
        setScanColor(Color.GREEN);      // Green scan arc
        
        // Main behavior loop
        while (true) {
            // Implement spiral movement pattern for better battlefield coverage
            executeSpiraMovement();
            
            // Perform radar scan
            turnRadarRight(scanAngle);
            
            // Small pause to prevent overheating
            doNothing();
        }
    }
    
    /**
     * Custom spiral movement pattern for better battlefield positioning
     */
    private void executeSpiraMovement() {
        spiralCounter++;
        
        // Gradually increase movement distance in spiral
        double currentMoveDistance = moveDistance + (spiralCounter % 5) * 20;
        double currentTurnAngle = turnAngle + (spiralCounter % 3) * 10;
        
        // Move forward
        ahead(currentMoveDistance);
        
        // Turn to create spiral pattern
        turnRight(currentTurnAngle);
        
        // Spin gun independently for better target acquisition
        turnGunRight(360 / 8); // Divide full rotation into segments
    }
    
    /**
     * Task 6: Fire when we detect an enemy robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Adaptive firing based on enemy distance
        double distance = e.getDistance();
        double adaptivePower = firePower;
        
        // Adjust fire power based on distance
        if (distance > 300) {
            adaptivePower = 3.0; // Higher power for long range
        } else if (distance < 100) {
            adaptivePower = 1.0; // Lower power for close range (faster firing)
        }
        
        // Predictive aiming: lead the target slightly
        double bearingOffset = e.getVelocity() > 0 ? 5 : -5;
        turnGunRight(getHeading() - getGunHeading() + e.getBearing() + bearingOffset);
        
        fire(adaptivePower);
    }
    
    /**
     * Task 6: React to being hit by bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Evasive maneuver: turn perpendicular to bullet and move
        turnLeft(90 - e.getBearing());
        ahead(100);
        
        // Counter-attack: turn gun towards shooter and fire
        turnGunRight(e.getBearing());
        fire(firePower);
    }
    
    /**
     * Task 6: React to hitting a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Reverse direction and turn to avoid wall
        back(50);
        turnRight(90);
        
        // Reset spiral counter to restart pattern
        spiralCounter = 0;
    }
    
    /**
     * Task 6: React to hitting another robot
     */
    public void onHitRobot(HitRobotEvent e) {
        // If we hit a robot, back away and fire
        back(50);
        turnGunRight(e.getBearing());
        fire(firePower);
    }
    
    /**
     * Task 7: Method to update optimization parameters
     * Can be used for parameter tuning experiments
     */
    public void updateParameters(double moveDistance, double turnAngle, double firePower) {
        this.moveDistance = moveDistance;
        this.turnAngle = turnAngle;  
        this.firePower = firePower;
    }
}
