package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class Bertha_Intake_Subsys extends SubsystemBase {

    Motor intakeMotor;
    ColorSensor cargo;

    public Bertha_Intake_Subsys(Motor intake, ColorSensor cargo) {

        intakeMotor = intake;
        intakeMotor.stopMotor(); // Make sure motor is stopped at initialization
        intakeMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setInverted(true); // Set direction such that forward is intake and reverse is expel

        cargo = cargo;
    }

    public void intakeOne() {

    }

    public void intakeContinuous() {

    }


}
