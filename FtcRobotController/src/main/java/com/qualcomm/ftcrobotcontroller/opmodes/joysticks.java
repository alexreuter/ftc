package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class joysticks extends OpMode {

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
        telemetry.addData("", "***Everything Loaded OK***");
    }

    @Override
    public void loop() {
        float y = gamepad1.left_stick_y;
        float x = gamepad1.left_stick_x;

        if(x>0)
        {
            //Turning right
            motor_Front_Right.setPower((1.0 - x)*y);
            motor_Front_Left.setPower(1.0*y);
            motor_Back_Right.setPower((1.0 - x)*y);
            motor_Back_Left.setPower(1.0*y);
        }
        else if(x<0)
        {
            //Turning right
            motor_Front_Left.setPower((-1.0 - x)*y);
            motor_Front_Right.setPower(1.0*y);
            motor_Back_Left.setPower((-1.0 - x)*y);
            motor_Back_Right.setPower(1.0*y);
        }
        else
        {
            //Straight, as powerful as forward.
            motor_Front_Left.setPower(y);
            motor_Front_Right.setPower(y);
            motor_Back_Left.setPower(y);
            motor_Back_Right.setPower(y);
        }
    }
}