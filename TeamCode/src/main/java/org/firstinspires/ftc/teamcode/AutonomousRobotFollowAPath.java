package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * This program will run autonomously when this OpMode is chosen -
 * i.e. it will run by itself without any user control
 *
 * In this program the robot will move forward, make a left turn, then make a right
 * turn to reach its destination
 *
 * If this activity takes more than 30 seconds the App will automatically stop the OpMode from running
 * If we have any while loops we should check if opModeIsActive() as it is automatically made INACTIVE
 * after 30 seconds by the App
 */
@Autonomous(name="AutonomousRobotFollowPath")

public class AutonomousRobotFollowAPath extends LinearOpMode
{

    //Declare the variables for the two motors
    private DcMotor motorLeft;
    private DcMotor motorRight;

    //Declare the constants we use in this class
    public static int TIME_TO_RUN_FOR_MAIN_PATH = 4000;

    @Override
    public void runOpMode()
    {
        // Code that runs when Init button is pressed by the driver
        // on the Driver Station phone

        //We have the name left_drive to the left motor in our robot when configuring it
        motorLeft = hardwareMap.dcMotor.get("left-drive");
        //We have the name right_drive to the right motor in our robot when configuring it
        motorRight = hardwareMap.dcMotor.get("right-drive");

        //We are reversing the right motor so that it will move the wheel in the same
        //direction as the left motor i.e forward
        motorRight.setDirection(DcMotor.Direction.REVERSE);

        //wait for the driver to press the Play button
        waitForStart();

        //Code that runs after the driver presses the Play button
        //This code will run for 30 seconds and stop after that

        // We check for OpModeIsActive because in Autonomous mode we want to stop as
        // soon as the App tells us after the 30 second limit

        int taskCount = 0;
        while (opModeIsActive() && taskCount <= 3) {

            taskCount = taskCount + 1;

            //Drive forward for 4 seconds at 100% power
            DriveRobot(1, 1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Turn left
            DriveRobot(-1, 1, 500);

            //Drive forward for 4 seconds at 100% power
            DriveRobot(1, 1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Turn right
            DriveRobot(1, -1, 500);

            //Drive forward for 4 seconds at 100% power
            DriveRobot(1, 1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Stop the robot
            DriveRobot(0, 0, 0);

            //Drive backward for 4 seconds at 100% power
            DriveRobot(-1, -1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Turn left going backward
            DriveRobot(-1, 1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Drive backward for 4 seconds at 100% power
            DriveRobot(-1, -1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Turn right going backward
            DriveRobot(1, -1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Drive forward for 4 seconds at 100% power
            DriveRobot(-1, -1, TIME_TO_RUN_FOR_MAIN_PATH);

            //Stop the robot
            DriveRobot(0, 0, 0);
        }


    }

    /* Method for the robot to Drive
    *This method takes three input parameters
    *   1. leftMotorPower - This is the power we want the left motor to run at
    *   2. rightMotorPower - This is the power we want the right motor to run at
    *   3. timeToRunInMilliseconds - This is the distance we want the robot to run based on time
    */
    public void DriveRobot(double leftMotorPower, double rightMotorPower, int timeToRunInMilliseconds)
    {
        motorLeft.setPower(leftMotorPower);
        motorRight.setPower(rightMotorPower);
        sleep(timeToRunInMilliseconds);
    }

}
