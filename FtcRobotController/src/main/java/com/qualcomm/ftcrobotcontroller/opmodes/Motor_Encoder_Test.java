package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class Motor_Encoder_Test extends OpMode {
    DcMotor motor_Front_Right;
    DcMotor motor_Front_Left;
    DcMotor motor_Back_Right;
    DcMotor motor_Back_Left;

    @Override
    public void init() {
        motor_Front_Right = hardwareMap.dcMotor.get("motor_Front_Right");
        motor_Front_Left = hardwareMap.dcMotor.get("motor__Front_Left");
        motor_Back_Right = hardwareMap.dcMotor.get("motor_Back_Right");
        motor_Back_Left = hardwareMap.dcMotor.get("motor_Back_Left");
    }

    @Override
    public void loop() {
        telemetry.addData("Front Right", motor_Back_Left.getCurrentPosition());
        telemetry.addData("Front Left", motor_Back_Right.getCurrentPosition());
        telemetry.addData("Back Right", motor_Front_Left.getCurrentPosition());
        telemetry.addData("Back Left", motor_Front_Right.getCurrentPosition());
    }
}
