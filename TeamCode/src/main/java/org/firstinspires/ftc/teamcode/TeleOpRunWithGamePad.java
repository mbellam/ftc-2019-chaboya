package org.firstinspires.ftc.teamcode;
// Code modified by: Hy, Zia, Amaan
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TeleOp RunWithGamePad")
public class TeleOpRunWithGamePad extends LinearOpMode
{
    private DcMotor motorLeft;
    private DcMotor motorRight;

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

            idle(); //This gives the hardware time to catchup
        }
    }
}
