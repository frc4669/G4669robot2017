package org.usfirst.frc.team4669.robot.commands;

import org.usfirst.frc.team4669.robot.Robot;
import org.usfirst.frc.team4669.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveMotionMagic extends Command {

	private double distanceToTravel;
	private double distance;
	private double rotationToTravel;

	public DriveMotionMagic(double distance) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.distance = distance;
        distanceToTravel = distance / RobotMap.encoderCountConstant;
        rotationToTravel = distance / (4*RobotMap.wheelCircumference);
        requires(Robot.driveTrain);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.driveMotionMagic(rotationToTravel);    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.driveTrain.setPID(
//    			SmartDashboard.getNumber("PID_P_LEFT", OI.DEFAULT_PID_P), 
//    			SmartDashboard.getNumber("PID_I_LEFT", OI.DEFAULT_PID_I),
//    			SmartDashboard.getNumber("PID_D_LEFT", OI.DEFAULT_PID_D),
//    			SmartDashboard.getNumber("PID_P_RIGHT", OI.DEFAULT_PID_P),
//    			SmartDashboard.getNumber("PID_I_RIGHT", OI.DEFAULT_PID_I),
//    			SmartDashboard.getNumber("PID_D_RIGHT", OI.DEFAULT_PID_D),
//    			SmartDashboard.getNumber("PID_F_LEFT", OI.DEFAULT_PID_F),
//    			SmartDashboard.getNumber("PID_F_RIGHT", OI.DEFAULT_PID_F)
//    	);
//    	Robot.driveTrain.driveMotionMagic(distanceToTravel);
//    	Robot.driveTrain.changeControlMode(TalonControlMode.Speed);
//    	Robot.driveTrain.setSpeed(SmartDashboard.getNumber("IntakeRPM", 0));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.driveTrain.getLeftEncoder()) > distanceToTravel 
        		&& Math.abs(Robot.driveTrain.getRightEncoder()) > distanceToTravel ;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
