package org.firstinspires.ftc.teamcode.ARCHIVED;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by ryankoo on 11/28/17.
 */

@Disabled
public class SafetyZone_SHORT {

    private Movement movement;
    private Hardware hardware;

    private HardwarePushbot robot = new HardwarePushbot();
    private LinearOpMode ctx;

    private ElapsedTime runtime = new ElapsedTime();


    private double FORWARD_SPEED = 0.37;

    private double clawOffset = 0.1;

    private double ARM_UP_POWER = -0.35;
    private double ARM_DOWN_POWER = 0.35;




    public void autoinit() throws Exception {
        try {
            HardwareBuilder hb = new HardwareBuilder(ctx.hardwareMap);
            hb.setMotorConfig(Hardware.MotorMode.TWO_MOTORS, DcMotor.Direction.FORWARD)
                    .addMotorFL("motor_l")
                    .addMotorFR("motor_r");
            this.hardware = hb.build();
            hb = null;
            // initialize robot parts
            hardware.init();
            // initialize servos
            robot.init(ctx.hardwareMap);
            movement = new Movement(hardware, this.ctx);
            movement.setVerbose(true);
        } catch(Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this.ctx);
        }
    }


    public void run() {

        try {

            autoinit();

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
            while (ctx.opModeIsActive() && (runtime.seconds() < 0.5)) {
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
