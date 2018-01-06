package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

/**
 * Created by ryankoo on 12/21/17.
 */

@Autonomous(name = "Jewel_Test", group = "tests")
public class Auto_Check_Color extends LinearOpMode {


    private Movement movement;
    private Hardware hardware;
    HardwareMap hwMap = null;

    private HardwarePushbot_TEST robot = new HardwarePushbot_TEST();
    private ElapsedTime runtime = new ElapsedTime();

    private double armLowered = 0.7;
    private double armRaised = 0.5;


    public int blue() {
        return robot.colorSensor.blue();
    }

    public int red() {
        return robot.colorSensor.red();
    }

    public void test_init() {

        try {
            HardwareBuilder hb = new HardwareBuilder(hardwareMap);
            hb.setMotorConfig(Hardware.MotorMode.TWO_MOTORS, DcMotor.Direction.FORWARD)
                    .addMotorFL("motor_l")
                    .addMotorFR("motor_r");
            this.hardware = hb.build();
            hb = null;
            // initialize robot parts
            hardware.init();
            // initialize servos *EDIT* TEST: not initializing servos
            //****
            robot.init(hardwareMap);
            //****
            movement = new Movement(hardware, this);
            movement.setVerbose(true);
        } catch (Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {

        try {

            test_init();

            telemetry.addData("Status", "Testing color sensor");
            telemetry.update();

            waitForStart();

            if (opModeIsActive()) {

                int blue = blue();
                int red = red();

                // Lower arm, knock enemy jewel off
                robot.colorSensor.enableLed(true);

                robot.knocker.setPosition(armLowered);

                if (blue > red) {

                    telemetry.addData("Status:", "Turned (right) to hit red jewel off");
                    telemetry.update();

                    movement.directTankDrive(-5, 5);
                    runtime.reset();
                    while (opModeIsActive() && (runtime.seconds() < 0.5)) {
                        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                        telemetry.update();
                    }

                    movement.directTankDrive(5, -5);
                    runtime.reset();
                    while (opModeIsActive() && (runtime.seconds() < 0.5)) {
                        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                        telemetry.update();
                    }
                } else if (red > blue) {
                    telemetry.addData("Status:", "Turned (right) to hit red jewel off");
                    telemetry.update();

                    movement.directTankDrive(5, -5);
                    runtime.reset();
                    while (opModeIsActive() && (runtime.seconds() < 0.5)) {
                        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                        telemetry.update();
                    }
                    movement.directTankDrive(-5, -5);
                    runtime.reset();
                    while (opModeIsActive() && (runtime.seconds() < 0.5)) {
                        telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                        telemetry.update();
                    }
                } else {
                    telemetry.addData("Status:", "No color found");
                    telemetry.update();
                }

                robot.knocker.setPosition(armRaised);

                sleep(5000);


            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
