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
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_LONG;
<<<<<<< HEAD
=======
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_SHORT;
>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "redLong", group = "robot")
public class BilAutoRed1 extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;
    private HardwarePushbot robot;
    private LinearOpMode ctx;

    private SafetyZone_LONG safetyZone;
<<<<<<< HEAD

=======
>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f

    @Override
    public void runOpMode() {

<<<<<<< HEAD
        try {
            robot.init(hardwareMap);

=======
            robot.init(hardwareMap);
>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f
            safetyZone = new SafetyZone_LONG(hardware, movement, robot, ctx);

            telemetry.addData("Status", "Ready to start");
            telemetry.update();

            waitForStart();

<<<<<<< HEAD
            sleep(2000);

            safetyZone.run(); // move robot to safety zone
        } catch (Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }
=======
            safetyZone.run();


>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f
    }
}

