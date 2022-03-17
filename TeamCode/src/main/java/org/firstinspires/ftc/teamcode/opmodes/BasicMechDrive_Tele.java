package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.utils.BerthaIMU;

@Config
@TeleOp(name="BerthaDrive", group = "PITS")
public class BasicMechDrive_Tele extends OpMode {
    boolean FIELD_CENTRIC_DRIVE = true;

    Motor frontLeft, frontRight, backLeft, backRight;
    BerthaIMU imu;
    MecanumDrive drive;
    GamepadEx driver;

    public void init() {

        driver = new GamepadEx(gamepad1);

        frontLeft = new Motor(hardwareMap, "fL");
        frontRight = new Motor(hardwareMap, "fR");
        backLeft = new Motor(hardwareMap, "bL");
        backRight = new Motor(hardwareMap, "bR");

        imu = new BerthaIMU(hardwareMap, "chIMU");
        imu.init();

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);

        telemetry.addData("Status","Initialized");

    }

    public void init_loop() {
        telemetry.addLine("Press the left stick button to change drive mode");

        if (driver.wasJustPressed(GamepadKeys.Button.LEFT_STICK_BUTTON)){
            FIELD_CENTRIC_DRIVE = !FIELD_CENTRIC_DRIVE;
        }

        telemetry.addData("Drive Mode", FIELD_CENTRIC_DRIVE ? "Field Centric" : "Robot Centric");
    }

    public void loop() {
        telemetry.addData("Drive Mode", FIELD_CENTRIC_DRIVE ? "Field Centric" : "Robot Centric");

        double[] angles = imu.getAngles();
        double horizHeading = Math.toDegrees(angles[1]); // Get Y axis as heading; Control Hub mounted vertically

        if (FIELD_CENTRIC_DRIVE) {
            drive.driveFieldCentric(
                    driver.getLeftX(),
                    driver.getLeftY(),
                    driver.getRightX(),
                    imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
                    false
            );
        } else {
            drive.driveRobotCentric(
                    driver.getLeftX(),
                    driver.getLeftY(),
                    driver.getRightX(),
                    false
            );
        }
    }
}
