package org.firstinspires.ftc.teamcode.opmodes.modes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by ryankoo on 11/27/17.
 */

public class SafetyZone_LONG {

    private Movement movement;
    private Hardware hardware;
    private HardwarePushbot robot;
    private LinearOpMode ctx;

    private ElapsedTime runtime = new ElapsedTime();

    private double FORWARD_SPEED = 0.39;

    private double clawOffset = 0.1;

    private double ARM_UP_POWER = -0.35;
    private double ARM_DOWN_POWER = 0.35;

    public SafetyZone_LONG(Hardware hw, Movement movement, HardwarePushbot rb, LinearOpMode lom) {
        this.hardware = hw;
        this.movement = movement;
        this.robot = rb;
        this.ctx = lom;
    }

    public void run() {

        try {

            // Robot runs on time and power, hope for the best xd
            // close claws


            clawOffset = Range.clip(clawOffset, -0.5, 0.5);
            robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);
            robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);

            // Move Arm up
            robot.leftArm.setPower(ARM_UP_POWER);
            robot.rightArm.setPower(ARM_UP_POWER);
            runtime.reset();
            while (ctx.opModeIsActive() && (runtime.seconds() < 1.0)) {
                ctx.telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                ctx.telemetry.update();
            }

            // 3: Move forward SLIGHTLY
            movement.directTankDrive(FORWARD_SPEED, FORWARD_SPEED);
            runtime.reset();
            while (ctx.opModeIsActive() && (runtime.seconds() < 1.0)) {
                ctx.telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                ctx.telemetry.update();
            }

            // Move arm down, claw releases crypto block
            robot.leftArm.setPower(ARM_DOWN_POWER);
            robot.rightArm.setPower(ARM_DOWN_POWER);
            runtime.reset();
            while (ctx.opModeIsActive() && (runtime.seconds() < 1.0)) {
                ctx.telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                ctx.telemetry.update();
            }

            ctx.telemetry.addData("Status", "Complete");
            ctx.telemetry.update();

            ctx.idle();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
