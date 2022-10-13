/*
 MultiBots 2022.
 Juan José Jiménez Solís y Daniel Andrés Vélez Vargas.
 */
package robotmultibots;

import robocode.*;
import java.awt.Color;

/**
 *
 * @author Daniel
 */
public class RobotMultiBots extends Robot {

    //Variables
    boolean peek;
    double moveAmount;

    /**
     * run: RocketTank's default behavior
     */
    public void run() {

        double bFWidth = getBattleFieldWidth(), bFHeight = getBattleFieldHeight();
        //Set RocketTank colors
        setBodyColor(Color.black);
        setGunColor(Color.blue);
        setRadarColor(Color.green);
        setBulletColor(Color.orange);
        setScanColor(Color.MAGENTA);

        moveAmount = Math.max(bFWidth / 3, bFHeight / 3);
        peek = false;

        turnLeft(getHeading() % 90);
        ahead(moveAmount);
        peek = true;
        turnGunRight(90);
        turnRight(90);

        while (true) {
            // Replace the next 4 lines with any behavior you would like
            /*
            ahead(150); // Move ahead 100
            turnGunRight(360); // Spin gun around
            back(150); // Move back 100
            turnGunLeft(360); // Spin gun around
             */

            //Part of Walls code
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

    public void onHitRobot(HitRobotEvent e) {
        /*
        if (e.getBearing() > -90 && e.getBearing() < 90) {
            fire(5);
        }
        if (e.getEnergy() < 15) {
            turnGunRight(360);
            fire(10);
        }
         */

        if (e.getBearing() > -90 && e.getBearing() < 90) {
            back(100);
            turnLeft(100);
        } // else he's in back of us, so set ahead a bit.
        else {
            ahead(100);
            turnRight(100);
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        /*
        fire(6);
        if (e.getEnergy() < 15) {
            fire(9);
        }
         */

        fire(6);
        // Note that scan is called automatically when the robot is moving.
        // By calling it manually here, we make sure we generate another scan event if there's a robot on the next
        // wall, so that we do not start moving up it until it's gone.
        if (peek) {
            scan();
        }
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(100);
        turnRight(100);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    /*
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        turnLeft(180);
        ahead(20);
    }
     */
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
 * Based on RocketTank - a robot by Daniel Vélez. Property of MultiBots - 2022.
 */
