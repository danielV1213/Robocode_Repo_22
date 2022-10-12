/*
 MultiBots 2022.
 */
package robotmultibots;

import robocode.*;
import java.awt.Color;

/**
 *
 * @author Daniel
 */
public class RobotMultiBots extends Robot {

    /**
     * run: RocketTank's default behavior
     */
    public void run() {
        //Set RocketTank colors
        setBodyColor(Color.blue);
        setGunColor(Color.gray);
        setRadarColor(Color.red);
        setAdjustGunForRobotTurn(false);
        setAdjustRadarForRobotTurn(false);

        while (true) {
            // Replace the next 4 lines with any behavior you would like
            ahead(150); // Move ahead 100
            turnGunRight(360); // Spin gun around
            back(150); // Move back 100
            turnGunLeft(360); // Spin gun around

        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        fire(6);
        if (e.getEnergy() < 15) {
            fire(9);
        }
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(100);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        turnLeft(180);
        ahead(20);
    }

    public void onHitRobot(HitRobotEvent e) {
        if (e.getBearing() > -90 && e.getBearing() < 90) {
            fire(5);
        }
        if (e.getEnergy() < 15) {
            turnGunRight(360);
            fire(10);
        }
    }

    public void onWin(WinEvent e) {
        // Victory dance
        turnRight(36000);
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
}

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
/**
 * RocketTank - a robot by Daniel Vélez.
 * Property of MultiBots - 2022.
 */
