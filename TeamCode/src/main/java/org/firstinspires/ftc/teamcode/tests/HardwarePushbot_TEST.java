/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwarePushbot_TEST

{
    /* Public OpMode members. */
//    public Servo leftClaw = null;
//    public Servo rightClaw = null;
    public Servo knocker;
//    public DcMotor leftArm = null;
//    public DcMotor rightArm = null;

    public ColorSensor colorSensor;

//    public static final double MID_SERVO = 0.5;
//    public static final double ARM_UP_POWER = -0.45;
//    public static final double ARM_DOWN_POWER = 0.45;

    /* local OpMode members. */
    HardwareMap hwMap = null;

    /* Constructor */
    public HardwarePushbot_TEST() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define installed Motors
//        rightArm = hwMap.get(DcMotor.class, "right_arm");
//        leftArm = hwMap.get(DcMotor.class, "left_arm");
        // Sets default power
//        rightArm.setPower(0);
//        leftArm.setPower(0);
        // Sets motors to run without encoders
//        rightArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        leftArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // Reverses the motors
        // Right one is not reversed
//        leftArm.setDirection(DcMotor.Direction.REVERSE);

        // Define and initialize ALL installed servos.
//        rightClaw = hwMap.get(Servo.class, "right_hand");
//        leftClaw = hwMap.get(Servo.class, "left_hand");
        knocker = hwMap.get(Servo.class, "knocker");
//        rightClaw.setPosition(MID_SERVO);
//        leftClaw.setPosition(MID_SERVO);

        // Define and initialize REV color sensor
        colorSensor = hwMap.get(ColorSensor.class, "color_sensor");

    }

}

