package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class Simple_Dpad extends OpMode {

    DcMotor motor_front_right;
    DcMotor motor_front_left;
    DcMotor motor_back_right;
    DcMotor motor_back_left;

    @Override
    public void init() {
        motor_front_right = hardwareMap.dcMotor.get("motor_front_right");
        motor_front_left = hardwareMap.dcMotor.get("motor_front_left");
        motor_back_right = hardwareMap.dcMotor.get("motor_back_right");
        motor_back_left = hardwareMap.dcMotor.get("motor_back_left");

//        motor_front_left.setDirection(DcMotor.Direction.REVERSE);
//        motor_back_left.setDirection(DcMotor.Direction.REVERSE);
        motor_back_right.setDirection(DcMotor.Direction.REVERSE);
        motor_front_right.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        boolean up = gamepad1.dpad_up;
        boolean down = gamepad1.dpad_down;
        boolean left = gamepad1.dpad_left;
        boolean right = gamepad1.dpad_right;

        if(up)
        {
            motor_front_right.setPower(1.0);
            motor_front_left.setPower(1.0);
            motor_back_right.setPower(1.0);
            motor_back_left.setPower(1.0);
        }

        else if(down)
        {
            motor_front_right.setPower(-1.0);
            motor_front_left.setPower(-1.0);
            motor_back_right.setPower(-1.0);
            motor_back_left.setPower(-1.0);
        }

        else if(left)
        {
            motor_front_right.setPower(-1.0);
            motor_front_left.setPower(1.0);
            motor_back_right.setPower(-1.0);
            motor_back_left.setPower(1.0);
        }

        else if(right)
        {

            motor_front_right.setPower(1.0);
            motor_front_left.setPower(-1.0);
            motor_back_right.setPower(1.0);
            motor_back_left.setPower(-1.0);
        }

        else {
            motor_front_right.setPower(0.0);
            motor_front_left.setPower(0.0);
            motor_back_right.setPower(0.0);
            motor_back_left.setPower(0.0);
        }
    }
}