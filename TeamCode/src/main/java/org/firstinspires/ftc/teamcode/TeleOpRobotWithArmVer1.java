package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleOp RobotWithArmVer1")
public class TeleOpRobotWithArmVer1 extends LinearOpMode
{
    private DcMotor motorLeft; //DcMotor is an FTC class provided to us in the FTC library
    private DcMotor motorRight;

    private Servo armServo; //Servo is an FTC class provided to us in the FTC library

    //Constants for the positions of our arm
    private static final double ARM_RETRACTED_POSITION = 0.2; // 0.2 x 180 Degrees = 36 Degrees
    private static final double ARM_EXTENDED_POSITION = 0.8; // 0.8 x 180 Degrees = 144 Degrees

    @Override
    public void runOpMode() throws InterruptedException
    {
        //Code before waitForStart is run when Init button is pressed
        // on the Driver Station phone

        //We have the name left_drive to the left motor in our robot when configuring it
        motorLeft = hardwareMap.dcMotor.get("left-drive");
        //We have the name right_drive to the right motor in our robot when configuring it
        motorRight = hardwareMap.dcMotor.get("right-drive");

        //We are reversing the right motor so that it will move the wheel in the same
        //direction as the left motor i.e forward
        motorRight.setDirection(DcMotor.Direction.REVERSE);

        //In our robot configuration we named the motor for the arm as arm-drive
        armServo = hardwareMap.servo.get("arm-drive");

        //Start with the arm in RETRACTED position
        armServo.setPosition(ARM_RETRACTED_POSITION);

        waitForStart();
        //Code after waitForStart is run when the Start button is pressed

        while(opModeIsActive())
        {
            //Code intside this while is run till the Stop button is pressed

            //We put a negative sign (-) in front so that it will give positive
            //power when we push the stick up on the y axis (the stick sends a negative
            //value when we push the stick up)
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            //Servos can move the arm within a 180 Degree range, 0=0 Degrees, 1=180 Degrees
            //If button A has been pressed on GamePad 2
            if (gamepad2.a)
            {
                armServo.setPosition(ARM_EXTENDED_POSITION); // 0.8 x 180 Degrees = 144 Degrees
            }
            //If button B has been pressed on GamePad 2
            if (gamepad2.b)
            {
                armServo.setPosition(ARM_RETRACTED_POSITION); // 0.2 x 180 Degrees = 36 Degrees
            }

            idle(); //This gives the hardware time to catchup
        }
    }
}

