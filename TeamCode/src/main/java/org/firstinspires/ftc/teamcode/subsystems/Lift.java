package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@Config
public class Lift extends SubsystemBase {

    MotorEx liftMotor;
    Servo eject;
    TouchSensor liftDown;

    public Lift(MotorEx lift, Servo eject, TouchSensor liftDown) {

        liftMotor = lift;
        liftMotor.stopMotor(); // Make sure motor is stopped at initialization
        liftMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        liftMotor.setInverted(false); // Set direction such that forward is up and reverse is down

        eject = eject;
        eject.setPosition(0);

        liftDown = liftDown;
    }

    public void setPID(double kP) {
        liftMotor.setRunMode(Motor.RunMode.PositionControl);

        liftMotor.setPositionCoefficient(kP);
    }

    public void resetLift() {
        liftMotor.stopMotor();
        liftMotor.encoder.reset();
    }

    public void stop() {
        liftMotor.stopMotor();
    }

    public void home() {
        liftMotor.setTargetPosition(0);
    }


}
