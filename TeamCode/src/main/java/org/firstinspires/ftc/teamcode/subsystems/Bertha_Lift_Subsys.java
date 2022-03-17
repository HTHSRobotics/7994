package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class Bertha_Lift_Subsys extends SubsystemBase {

    Motor liftMotor;
    Servo eject;
    TouchSensor liftDown;

    public Bertha_Lift_Subsys(Motor lift, Servo eject, TouchSensor liftDown) {

        liftMotor = lift;
        liftMotor.stopMotor(); // Make sure motor is stopped at initialization
        liftMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        liftMotor.setInverted(false); // Set direction such that forward is up and reverse is down

        eject = eject;
        eject.setPosition(0);

        liftDown = liftDown;
    }

    public void homeLift() {
        if (liftDown.isPressed()) return; // If the lift is already homed, do not continue

        eject.setPosition(1); // Move eject servo out of the way


        while (true) {
            if (liftDown.isPressed()) break; // Check if lift is down

        }
    }


}
