package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class Intake extends SubsystemBase {

    Motor intakeMotor;
    ColorSensor cargo;

    enum FREIGHT_TYPE {
        BLOCK,
        BALL,
        UNKNOWN,
        EMPTY
    }

    public Intake(Motor intake, ColorSensor cargoSensor) {

        intakeMotor = intake;
        intakeMotor.stopMotor(); // Make sure motor is stopped at initialization
        intakeMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setInverted(true); // Set direction such that forward is intake and reverse is expel

        cargo = cargoSensor;
        cargo.enableLed(true);
    }

    public void run() {
        intakeMotor.set(0.5);
    }

    public void run(double customSpeed) {
        intakeMotor.set(customSpeed);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }

    public FREIGHT_TYPE getCargoType(){ // Will read color values to determine type of freight
        return FREIGHT_TYPE.UNKNOWN;
    }

    public boolean getCargoState() { // Will use existing getCargoType method to determine if freight is present.
        return false;
    }


}
