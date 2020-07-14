package org.firstinspires.ftc.teamcode.ftc16072.Util;

import com.qualcomm.hardware.bosch.BNO055IMU;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp(name="right turn", group="imu exercise")

public class gyroturnright extends LinearOpMode {
    DcMotor fl, fr, bl, br;
    BNO055IMU imu;
    Orientation headingangle = new Orientation();

    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(DcMotor.class, "front_left_motor");
        fr = hardwareMap.get(DcMotor.class, "front_right_motor");
        bl = hardwareMap.get(DcMotor.class, "back_left_motor");
        br = hardwareMap.get(DcMotor.class, "back_right_motor");
        imu = hardwareMap.get(BNO055IMU.class, "imu");


        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        bl.setDirection((DcMotorSimple.Direction.REVERSE));

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.loggingEnabled = false;

        imu.initialize(parameters);
        boolean ial = true;
        waitForStart();
        double setangle = 0;
        while (opModeIsActive()) {
            headingangle = imu.getAngularOrientation(
                    AxesReference.INTRINSIC,
                    AxesOrder.ZYX,
                    AngleUnit.DEGREES
            );

           /*if (headingangle.firstAngle == setangle) {
               ial=false;
               fl.setPower(0.0);
               fr.setPower(0.0);
               bl.setPower(0.0);
               br.setPower(0.0);
           }
           if (headingangle.firstAngle != setangle && ial == true) {



               fl.setPower(0.1);
               fr.setPower(0);
               bl.setPower(0.1);
               br.setPower(0);
               telemetry.addData("angle", headingangle.firstAngle);
               telemetry.update();





           }


           double lefty = gamepad1.left_stick_y*-1;
           fl.setPower(lefty *0.5);
           fr.setPower(lefty *0.5);
           bl.setPower(lefty *0.5);
           br.setPower(lefty *0.5);
           if (gamepad1.a) {
               ial = true;
               if(setangle == 0){
                   setangle = -90;

                   sleep(100);
               }else if(setangle == -90){
                   setangle = 180;
                   sleep(100);
               }else if( setangle == 180) {
                   setangle = 90;
                   sleep(100);
               }else if(setangle == 90){
                   setangle = 0;
                   sleep(100);
               }

               telemetry.addData("setangle", setangle);
               telemetry.update();






           }*/

            double lefty = gamepad1.left_stick_y * -1;
            fl.setPower(lefty * 0.5);
            fr.setPower(lefty * 0.5);
            bl.setPower(lefty * 0.5);
            br.setPower(lefty * 0.5);
            if (gamepad1.a) {

                if (setangle == 0) {
                    setangle = -90;

                    sleep(100);
                } else if (setangle == -90) {
                    setangle = 180;
                    sleep(100);
                } else if (setangle == 180) {
                    setangle = 90;
                    sleep(100);
                } else if (setangle == 90) {
                    setangle = 0;
                    sleep(100);
                }
            }
            telemetry.addData("setangle:",setangle);
            telemetry.update();
                if(setangle ==-90) {
                    if (headingangle.firstAngle >= setangle) {
                        fl.setPower(0.2);
                        bl.setPower(0.2);
                        fr.setPower(0);
                        br.setPower(0);
                    }else{
                        fl.setPower(0);
                        bl.setPower(0);
                        fr.setPower(0);
                        br.setPower(0);
                    }
                }
                if(setangle == 180) {
                       if (headingangle.firstAngle <= setangle) {

                            fl.setPower(0.2);
                            bl.setPower(0.2);
                            fr.setPower(0);
                            br.setPower(0);



                        }else{
                           fl.setPower(0);
                           bl.setPower(0);
                           fr.setPower(0);
                           br.setPower(0);

                       }
                    }
                if(setangle ==90) {
                        if (headingangle.firstAngle >= setangle) {
                            fl.setPower(0.2);
                            bl.setPower(0.2);
                            fr.setPower(0);
                            br.setPower(0);
                        }else{
                            fl.setPower(0);
                            bl.setPower(0);
                            fr.setPower(0);
                            br.setPower(0);
                        }
                    }
                if(setangle == 0) {
                        if (headingangle.firstAngle >= setangle) {
                            fl.setPower(0.2);
                            bl.setPower(0.2);
                            fr.setPower(0);
                            br.setPower(0);
                        }else{
                            fl.setPower(0);
                            bl.setPower(0);
                            fr.setPower(0);
                            br.setPower(0);
                        }
                    }


                }
            }


        }







