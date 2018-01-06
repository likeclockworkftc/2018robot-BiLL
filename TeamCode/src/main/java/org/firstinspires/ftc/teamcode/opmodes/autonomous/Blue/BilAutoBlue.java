package org.firstinspires.ftc.teamcode.opmodes.autonomous.Blue;

import android.app.Activity;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "blueShort", group = "robot")
public class BilAutoBlue extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;
    private DeviceInterfaceModule cdim;

    private HardwarePushbot robot = new HardwarePushbot();
    private ElapsedTime runtime = new ElapsedTime();

    private double FORWARD_SPEED = 0.37;

    private double clawOffset = 0.1;

    private double ARM_UP_POWER = -0.35;
    private double ARM_DOWN_POWER = 0.35;

    private double armLowered = 0.5;
    private double armRaised = 0.5;

    int blue = robot.colorSensor.blue();
    int red = robot.colorSensor.red();


    public void autoinit() throws Exception {

        try {
            HardwareBuilder hb = new HardwareBuilder(hardwareMap);
            hb.setMotorConfig(Hardware.MotorMode.TWO_MOTORS, DcMotor.Direction.FORWARD)
                    .addMotorFL("motor_l")
                    .addMotorFR("motor_r");
            this.hardware = hb.build();
            hb = null;
            // initialize robot parts
            hardware.init();
            // initialize servos
            robot.init(hardwareMap);
            movement = new Movement(hardware, this);
            movement.setVerbose(true);
        } catch (Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }
    }


    @Override
    public void runOpMode() {

        try {

            autoinit();

            telemetry.addData("Status", "Ready to start");
            telemetry.update();

            waitForStart();

            if (opModeIsActive()) {

                // Lower arm, knock enemy jewel off

                robot.knocker.setPosition(armLowered);

                robot.colorSensor.enableLed(true);

                if (blue > red) {
                    // rotates to knock red off using directTankDrive()
                } else if (red > blue) {
                    // rotates to knock red off using directTankDrive()
                }

                robot.knocker.setPosition(armRaised);

                sleep(5000);

                // Start going to Safety Zone — put glyph in crypto box

                clawOffset = Range.clip(clawOffset, -0.5, 0.5);
                robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);
                robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);


                // Move Arm up
                robot.leftArm.setPower(ARM_UP_POWER);
                robot.rightArm.setPower(ARM_UP_POWER);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // 3: Move forward SLIGHTLY
                movement.directTankDrive(FORWARD_SPEED, FORWARD_SPEED);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 0.5)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                // Turn to face towards the box
                // movement.directTankDrive();

                // Move arm down, claw releases glyph
                robot.leftArm.setPower(ARM_DOWN_POWER);
                robot.rightArm.setPower(ARM_DOWN_POWER);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.0)) {
                    telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }

                sleep(1000);

                // Robot drives back slightly



                telemetry.addData("Status", "Complete");
                telemetry.update();

                idle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

