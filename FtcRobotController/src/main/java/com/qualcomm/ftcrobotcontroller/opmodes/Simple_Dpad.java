package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class Simple_Dpad extends OpMode {

    DcMotor frontr;
    DcMotor frontl;
    DcMotor backr;
    DcMotor backl;
    DcMotor height;
    DcMotor string;
    DcMotor boxa;
    DcMotor boxt;
    Servo boxr;
    Servo boxl;
    Servo arm;

    /*TODO
    * Maybe create a function that implements all of the simple if else logic. For example, just input the two different
    * types of buttons on teh controller and input the two values it is set to, else will be automatic. Actually nevermind setposition vs setpower to complicated to be worthwhile.
    *
    *
    *
    * */




    //height needs to lock
    //restrict box tilt
    //kill power 50%;
    //impliment smooth for box tilt

    double armposition;
    boolean armdelta;
    double armspeed;

    @Override
    public void init() {
        frontr = hardwareMap.dcMotor.get("frontr");
        frontl = hardwareMap.dcMotor.get("frontl");
        backr = hardwareMap.dcMotor.get("backr");
        backl = hardwareMap.dcMotor.get("backl");
        height = hardwareMap.dcMotor.get("height");
        string = hardwareMap.dcMotor.get("string");
        boxa = hardwareMap.dcMotor.get("boxa");
        boxt = hardwareMap.dcMotor.get("boxt");
        backl.setDirection(DcMotor.Direction.REVERSE);
        frontl.setDirection(DcMotor.Direction.REVERSE);

        armposition = 0;
        armspeed = 0.1;
        armdelta = true;

        //SERVOS
        boxr = hardwareMap.servo.get("boxr");
        boxl = hardwareMap.servo.get("boxl");
        arm = hardwareMap.servo.get("arm");

    }



    @Override
    public void loop() {
        boolean up = gamepad1.dpad_up;
        boolean down = gamepad1.dpad_down;
        boolean left = gamepad1.dpad_left;
        boolean right = gamepad1.dpad_right;
        double power;


        //Victory Dance

//        if(gamepad1.y)
//        {
//            frontr.setDirection(DcMotor.Direction.FORWARD);
//            frontl.setDirection(DcMotor.Direction.REVERSE);
//            telemetry.addData("", "VICTORY DANCE");
//        }
//        else
//        {
//            frontr.setDirection(DcMotor.Direction.REVERSE);
//            frontl.setDirection(DcMotor.Direction.FORWARD);
//        }

        //Reduce front power
        if(gamepad1.a)
        {
            power = 1.0;
        }
        else
        {
            power = 0.5;
        }

        if(up)
        {
            frontr.setPower(power);
            frontl.setPower(power);
            backr.setPower(power);
            backl.setPower(power);
        }

        else if(down)
        {
            frontr.setPower(-power);
            frontl.setPower(-power);
            backr.setPower(-power);
            backl.setPower(-power);
        }

        else if(left)
        {
            frontr.setPower(-power);
            frontl.setPower(power);
            backr.setPower(-power);
            backl.setPower(power);
        }

        else if(right)
        {

            frontr.setPower(power);
            frontl.setPower(-power);
            backr.setPower(power);
            backl.setPower(-power);
        }

        else {
            frontr.setPower(0.0);
            frontl.setPower(0.0);
            backl.setPower(0.0);
            backr.setPower(0.0);
        }

        /**
         * GAMEPAD 2:
         *
         * String = left and right bumpers.
         * roll of box = triggers
         * Hook = a
         * height = DPAD up/down
         * pitch of box = DPAD left/right
         * balls out = START
         *
         * ONLY DPAD DRIVE ON GAMEPAD 1.
         *
         * A = MORE POWER.
         * **/

        //Brainstorm for limiting the tilt of dc motors.



        //STRING
        if(gamepad2.left_bumper)
        {
            string.setPower(1.0);
        }
        else if(gamepad2.right_bumper)
        {
            string.setPower(-1.0);
        }
        else
        {
            string.setPower(0.0);
        }

        //HEIGHT
        if(gamepad2.dpad_down)
        {
            height.setPower(1.0);
        }
        else if(gamepad2.dpad_up)
        {
            height.setPower(-1.0);
        }
        else if(gamepad2.dpad_left)
        {
            boxa.setPower(1.0);
        }
        else if(gamepad2.dpad_right)
        {
            boxa.setPower(-1.0);
        }
        else
        {
            height.setPower(0.0);
            boxa.setPower(0.0);
        }

        //BOXT

        //TO reverse switch negatives or the left and right triggers.
        float power_decrease = 0.5f;

        if(gamepad2.left_trigger > 0)
        {
            boxt.setPower(power_decrease*gamepad2.left_trigger);
        }
        else if(gamepad2.right_trigger > 0)
        {
            boxt.setPower(-power_decrease*gamepad2.left_trigger);
        }
        else
        {
            boxt.setPower(0.0);
        }

        //ARM
        if(gamepad2.a)
        {
            arm.setPosition(0.0);
        }
        else
        {
            arm.setPosition(1.0);
        }


        //SERVO
        if(gamepad2.start) {
            boxr.setPosition(1.0);
            boxl.setPosition(1.0);
        }
        else
        {
            boxr.setPosition(0.0);
            boxl.setPosition(0.0);
        }
    }
}