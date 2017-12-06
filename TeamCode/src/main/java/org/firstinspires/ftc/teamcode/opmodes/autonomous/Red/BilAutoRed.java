package org.firstinspires.ftc.teamcode.opmodes.autonomous.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.HardwareBuilder;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

import org.firstinspires.ftc.teamcode.HardwarePushbot;
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_SHORT;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "redShort", group = "robot")
public class BilAutoRed extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;
    private HardwarePushbot robot;
    private LinearOpMode ctx;

    public SafetyZone_SHORT safetyZone;
<<<<<<< HEAD
=======

>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f

    @Override
    public void runOpMode() {

<<<<<<< HEAD
        try {
            robot.init(hardwareMap);

            safetyZone = new SafetyZone_SHORT(hardware, movement, robot, ctx);

=======
            robot.init(hardwareMap);
            safetyZone = new SafetyZone_SHORT(hardware, movement, robot, ctx);
>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f

            telemetry.addData("Status", "Ready to start");
            telemetry.update();

            waitForStart();

            safetyZone.run();
<<<<<<< HEAD
        } catch (Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }
=======
>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f

    }
}

