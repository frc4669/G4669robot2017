package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.OI;
import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveMotionMagic extends Command {

	private double distanceToTravel;

	public DriveMotionMagic(double distance) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        distanceToTravel = distance / RobotMap.encoderCountConstant;
        requires(Robot.driveTrain);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.driveMotionMagic(distanceToTravel);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	OI.TALON_P_LEFT.set(SmartDashboard.getNumber("PID_P_LEFT", OI.DEFAULT_PID_P));
    	OI.TALON_I_LEFT.set(SmartDashboard.getNumber("PID_I_LEFT", OI.DEFAULT_PID_I));
    	OI.TALON_D_LEFT.set(SmartDashboard.getNumber("PID_D_LEFT", OI.DEFAULT_PID_D));
    	OI.TALON_P_RIGHT.set(SmartDashboard.getNumber("PID_P_RIGHT", OI.DEFAULT_PID_P));
    	OI.TALON_I_RIGHT.set(SmartDashboard.getNumber("PID_I_RIGHT", OI.DEFAULT_PID_I));
    	OI.TALON_D_RIGHT.set(SmartDashboard.getNumber("PID_D_RIGHT", OI.DEFAULT_PID_D));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
