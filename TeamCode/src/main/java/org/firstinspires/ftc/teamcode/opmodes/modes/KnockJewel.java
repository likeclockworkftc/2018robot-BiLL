package org.firstinspires.ftc.teamcode.opmodes.modes;


import android.app.Activity;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.Servo;
import com.vvftc.ninevolt.core.hw.Hardware;
import com.vvftc.ninevolt.core.hw.drivetrain.standard.Movement;

import org.firstinspires.ftc.teamcode.HardwarePushbot;

/**
 * Created by ryankoo on 11/27/17.
 */

public class KnockJewel {

    private Movement movement;
    private Hardware hardware;
    private HardwarePushbot robot;
    private LinearOpMode ctx;

    private Servo knocker;
    ColorSensor colorSensor;
    DeviceInterfaceModule dim;


    private double armLowered = 0.5;
    private double armRaised = 0.5;

    public KnockJewel() {
        this.knocker = ctx.hardwareMap.get(Servo.class, "knocker");
        colorSensor = ctx.hardwareMap.get(ColorSensor.class, "color_sensor");
    }

//    public void showColor() {
//        int relativeLayoutId = ctx.hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id",
//                ctx.hardwareMap.appContext.getPackageName());
//        final View relativeLayout = ((Activity) ctx.hardwareMap.appContext).findViewById(relativeLayoutId);
//    }

    public void scanColor() {

    }



    public void setArmRaised() {
        knocker.setPosition(armRaised);
    }

    public void setArmLowered() {
        knocker.setPosition(armLowered);
    }






}
