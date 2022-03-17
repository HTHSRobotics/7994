package org.firstinspires.ftc.teamcode.utils;


import com.arcrobotics.ftclib.hardware.RevIMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

public class BerthaIMU extends RevIMU {

    private AxesOrder axesOrder = AxesOrder.ZYX; // Swap the Z and X axes to account for vertical (USB port up) mounting

    private final BNO055IMU internalImu = getRevIMU();

    /**
     * Initialize new IMU with Default Axes Remapping (X, Y, Z) to (Z, Y, X)
     * @param hw hardwareMap object
     * @param imuName name of IMU in Configuration
     */
    public BerthaIMU(HardwareMap hw, String imuName) {
        super(hw, imuName);
    }


    public BerthaIMU(HardwareMap hw, String imuName, AxesOrder customAxes) {
        super(hw, imuName);
        axesOrder = customAxes;
    }

    /**
     * @return Absolute heading of the robot
     */
    @Override
    public double getAbsoluteHeading() {
        return internalImu.getAngularOrientation(AxesReference.INTRINSIC, axesOrder, AngleUnit.DEGREES).firstAngle;
    }


}
