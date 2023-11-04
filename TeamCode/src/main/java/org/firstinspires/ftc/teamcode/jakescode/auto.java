package org.firstinspires.ftc.teamcode.jakescode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Robot: Auto Drive By Time", group="Robot")
public class auto extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor         frontLeftDrive   = null;
    private DcMotor         frontRightDrive  = null;
    private DcMotor         backLeftDrive   = null;
    private DcMotor         backRightDrive  = null;

    private ElapsedTime     runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() {

        frontLeftDrive  = hardwareMap.get(DcMotor.class, "fl");
        frontRightDrive = hardwareMap.get(DcMotor.class, "fr");
        backLeftDrive  = hardwareMap.get(DcMotor.class, "bl");
        backRightDrive = hardwareMap.get(DcMotor.class, "br");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        setAllMotors(0.5);

        sleep(1000);

        setAllMotors(0);

        sleep(1000);
    }
    public void setAllMotors(double power){
        frontLeftDrive.setPower(power);
        frontRightDrive.setPower(power);
        backLeftDrive.setPower(power);
        backRightDrive.setPower(power);
    }
}
