package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.MotorType;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

import org.firstinspires.ftc.teamcode.HardwarePushbot;


/**
 * Created by ryankoo on 9/19/17.
 */

@TeleOp (name = "Bil", group = "robot")
public class BilTeleOp extends OpMode{

    private Hardware hardware;
    private Movement movement;

    private HardwareMap hwMap = null;
    private HardwarePushbot robot = new HardwarePushbot();

    public double clawOffset =  0.5;
    public double CLAW_SPEED = 0.02;


    @Override
    public void init() {
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
        } catch(Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }

    }

    @Override
    public void loop() {
        //robot moves from person 1's controller

        movement.directTankDrive(-gamepad1.left_stick_y, -gamepad1.right_stick_y);

        //person 2 controls robots arms/claws
        // Use game pad left & right Bumpers to open and close the claw

        if (gamepad2.right_bumper)
            clawOffset += CLAW_SPEED;
        else if (gamepad2.left_bumper)
            clawOffset -= CLAW_SPEED;

        while (gamepad2.x == true) {
            telemetry.addData("Claw Status: ", "Snail");
            telemetry.update();
            if (gamepad2.right_bumper)
                clawOffset += 0.005;
            else if (gamepad2.left_bumper)
                clawOffset -= 0.005;
        }
            telemetry.addData("Claw Status: ", "Normal");
            telemetry.update();

        // Servos should move in unison
        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);
        robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);

        telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        telemetry.update();

        // Motors should move in unison
        if (gamepad2.y) {
            robot.leftArm.setPower(robot.ARM_UP_POWER);
            robot.rightArm.setPower(robot.ARM_UP_POWER);
        }
        else if (gamepad2.a) {
            robot.leftArm.setPower(robot.ARM_DOWN_POWER);
            robot.rightArm.setPower(robot.ARM_DOWN_POWER);
        }
        else {
            robot.leftArm.setPower(0.0);
            robot.rightArm.setPower(0.0);
        }
    }
}
