package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class Simple_Dpad extends OpMode {

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
        boolean up = gamepad1.dpad_up;
        boolean down = gamepad1.dpad_down;
        boolean left = gamepad1.dpad_left;
        boolean right = gamepad1.dpad_right;

        if(up)
        {
            motor_Front_Right.setPower(1.0);
            motor_Front_Left.setPower(1.0);
            motor_Back_Right.setPower(1.0);
            motor_Back_Left.setPower(1.0);
        }

        else if(down)
        {
            motor_Front_Right.setPower(-1.0);
            motor_Front_Left.setPower(-1.0);
            motor_Back_Right.setPower(-1.0);
            motor_Back_Left.setPower(-1.0);
        }

        else if(left)
        {
            motor_Front_Right.setPower(-1.0);
            motor_Front_Left.setPower(1.0);
            motor_Back_Right.setPower(-1.0);
            motor_Back_Left.setPower(1.0);
        }

        else if(right)
        {
            motor_Front_Right.setPower(1.0);
            motor_Front_Left.setPower(-1.0);
            motor_Back_Right.setPower(1.0);
            motor_Back_Left.setPower(-1.0);
        }

        else
        {
            motor_Front_Right.setPower(0.0);
            motor_Front_Left.setPower(0.0);
            motor_Back_Right.setPower(0.0);
            motor_Back_Left.setPower(0.0);
        }

    }
}