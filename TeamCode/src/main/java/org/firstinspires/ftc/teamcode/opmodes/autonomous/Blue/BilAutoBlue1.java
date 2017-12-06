package org.firstinspires.ftc.teamcode.opmodes.autonomous.Blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;
import com.vvftc.ninevolt.util.ExceptionHandling;

import org.firstinspires.ftc.teamcode.HardwarePushbot;
import org.firstinspires.ftc.teamcode.opmodes.modes.KnockJewel;
import org.firstinspires.ftc.teamcode.opmodes.modes.SafetyZone_LONG;

/**
 * Created by ryankoo on 9/19/17.
 */

@Autonomous(name = "blueLong", group = "robot")
public class BilAutoBlue1 extends LinearOpMode {

    private Movement movement;
    private Hardware hardware;
    private HardwarePushbot robot;
    private LinearOpMode ctx;

    public SafetyZone_LONG safetyZone;
    public KnockJewel knockJewel;

    @Override
    public void runOpMode() {
        try {

<<<<<<< HEAD

            robot.init(hardwareMap);
=======
        robot.init(hardwareMap);
        safetyZone = new SafetyZone_LONG(hardware,movement,robot,ctx);
>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f

            safetyZone = new SafetyZone_LONG(hardware, movement, robot, ctx);

            telemetry.addData("Status", "Ready to start");
            telemetry.update();

<<<<<<< HEAD
            waitForStart();
=======
        sleep(2000);
>>>>>>> 5170188fd42848495da837c25b165d8d58766f0f

            

            sleep(2000);

            safetyZone.run(); // move robot to safety zone

        } catch (Exception e) {
            ExceptionHandling.standardExceptionHandling(e, this);
        }

    }
}

