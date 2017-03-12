package org.usfirst.frc.team4669.robot.subsystems;

import org.usfirst.frc.team4669.robot.OI;
import org.usfirst.frc.team4669.robot.RobotMap;
import org.usfirst.frc.team4669.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	private static final double kAngleSetpoint = 0.0;
	private static final double kP = 0.005;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon topLeftMotor;
	private CANTalon bottomLeftMotor;
	private CANTalon topRightMotor;
	private CANTalon bottomRightMotor;
	
//	private RobotDrive driveTrain;
	
	private Gyro analogGyro;
	
	public DriveTrain() {
		super();
		analogGyro = new ADXRS450_Gyro();
		
		topLeftMotor = new CANTalon(RobotMap.driveTrainTopLeft);
		bottomLeftMotor = new CANTalon(RobotMap.driveTrainBottomLeft);
		topRightMotor = new CANTalon(RobotMap.driveTrainTopRight);
		bottomRightMotor = new CANTalon(RobotMap.driveTrainBottomRight);
		
//		driveTrain = new RobotDrive(topLeftMotor, bottomLeftMotor, topRightMotor, bottomRightMotor);
		
//		setupLeftMotor(topLeftMotor);
////		setupLeftMotor(bottomLeftMotor);
//		setupRightMotor(topRightMotor);
////		setupRightMotor(bottomRightMotor);
		
		double velocity = 400.0;
		double accel = 100.0;
		
		topLeftMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		topLeftMotor.reverseSensor(false);
		topLeftMotor.configEncoderCodesPerRev(1440); // if using
		// FeedbackDevice.QuadEncoder
		// _talon.configPotentiometerTurns(XXX), // if using
		// FeedbackDevice.AnalogEncoder or AnalogPot

		/* set the peak and nominal outputs, 12V means full */
		topLeftMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		topLeftMotor.configPeakOutputVoltage(+12.0f, -12.0f);
		/* set closed loop gains in slot0 - see documentation */
		topLeftMotor.setProfile(0);
		topLeftMotor.setF(0.3739);
		topLeftMotor.setP(0.3);
		topLeftMotor.setI(0);
		topLeftMotor.setD(16);
		/* set acceleration and vcruise velocity - see documentation */
		topLeftMotor.setMotionMagicCruiseVelocity(velocity);
		topLeftMotor.setMotionMagicAcceleration(accel);
		topLeftMotor.setPosition(0);

		bottomLeftMotor.changeControlMode(TalonControlMode.Follower);
		bottomLeftMotor.set(topLeftMotor.getDeviceID());
		
		topRightMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		topRightMotor.reverseSensor(false);
//		topRightMotor.reverseOutput(true);
		topRightMotor.configEncoderCodesPerRev(1440); // if using
		// FeedbackDevice.QuadEncoder
		// _talon.configPotentiometerTurns(XXX), // if using
		// FeedbackDevice.AnalogEncoder or AnalogPot

		/* set the peak and nominal outputs, 12V means full */
		topRightMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		topRightMotor.configPeakOutputVoltage(+12.0f, -12.0f);
		/* set closed loop gains in slot0 - see documentation */
		topRightMotor.setProfile(0);
		topRightMotor.setF(0.3739);
		topRightMotor.setP(0.3);
		topRightMotor.setI(0);
		topRightMotor.setD(16);
		/* set acceleration and vcruise velocity - see documentation */
		topRightMotor.setMotionMagicCruiseVelocity(velocity); //855
		topRightMotor.setMotionMagicAcceleration(accel); //855
		topRightMotor.setPosition(0);
		
		bottomRightMotor.changeControlMode(TalonControlMode.Follower);
		bottomRightMotor.set(topRightMotor.getDeviceID());
		
	}
	
	public void setPID(
			double pLeft, 
			double iLeft, 
			double dLeft, 
			double pRight, 
			double iRight, 
			double dRight,
			double fLeft,
			double fRight) {
		topLeftMotor.setP(pLeft);
//		bottomLeftMotor.setP(pLeft);
		topRightMotor.setP(pRight);
//		bottomRightMotor.setP(pRight);
		topLeftMotor.setI(iLeft);
//		bottomLeftMotor.setI(iLeft);
		topRightMotor.setI(iRight);
//		bottomRightMotor.setI(iRight);
		topLeftMotor.setD(dLeft);
//		bottomLeftMotor.setD(dLeft);
		topRightMotor.setD(dRight);
//		bottomRightMotor.setD(dRight);
		topLeftMotor.setF(fLeft);
//		bottomLeftMotor.setF(fLeft);
		topRightMotor.setF(fRight);
//		bottomRightMotor.setF(fRight);
	}
	
	public void setupLeftMotor(CANTalon talon) {
//		talon.enable();
		talon.changeControlMode(TalonControlMode.PercentVbus);
//		talon.enableBrakeMode(false);
		talon.reverseOutput(!RobotMap.reverseOutputTrain);
		talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talon.configNominalOutputVoltage(+0.0f, -0.0f);
		talon.configPeakOutputVoltage(+12.0f, -12.0f);
//		talon.setProfile(0);
//		talon.setF(OI.TALON_F_LEFT.get());
//		talon.setP(OI.TALON_P_LEFT.get());
//		talon.setI(OI.TALON_I_LEFT.get());
//		talon.setD(OI.TALON_D_LEFT.get());
//		talon.setMotionMagicCruiseVelocity(937);
//		talon.setMotionMagicAcceleration(937);
	}
	
	public void setupRightMotor(CANTalon talon) {
//		talon.enable();
		talon.changeControlMode(TalonControlMode.PercentVbus);
//		talon.enableBrakeMode(false);
		talon.reverseOutput(RobotMap.reverseOutputTrain);
		talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		talon.configNominalOutputVoltage(+0.0f, -0.0f);
		talon.configPeakOutputVoltage(+12.0f, -12.0f);
//		talon.setProfile(0);
//		talon.setF(OI.TALON_F_RIGHT.get());
//		talon.setP(OI.TALON_P_RIGHT.get());
//		talon.setI(OI.TALON_I_RIGHT.get());
//		talon.setD(OI.TALON_D_RIGHT.get());
//		talon.setMotionMagicCruiseVelocity(937);
//		talon.setMotionMagicAcceleration(937);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
    
    public void driveForward(double speedLeft, double speedRight) {
//    	driveTrain.tankDrive(speedLeft, speedRight, false);
    	topLeftMotor.changeControlMode(TalonControlMode.PercentVbus);
    	topLeftMotor.set(speedLeft);
    	topRightMotor.changeControlMode(TalonControlMode.PercentVbus);
    	topRightMotor.set(speedRight);
    }
    
    public void drive(double outputMag, double outputCurv) {
//    	driveTrain.drive(outputMag, outputCurv);
    }
    
    public void setDrive(double speed, double turnrate) {
//    	driveTrain.drive(speed, turnrate);
    }
    
    public void setSpeed(double speed) {
    	topLeftMotor.changeControlMode(TalonControlMode.Speed);
    	topLeftMotor.set(speed);
    }
    
    public void stop() {
//    	driveTrain.tankDrive(0, 0);
    }
    
    public void calibrateGyro() {
    	analogGyro.calibrate();
    }
    
    public double getGyroAngle() {
    	return analogGyro.getAngle();
    }
    
    public double calculateTurningValue(double direction) {
    	double turningValue = kAngleSetpoint - analogGyro.getAngle() * kP;
    	turningValue = Math.copySign(turningValue, direction);
    	return turningValue;
    }
    
    public double getLeftEncoder() {
    	return topLeftMotor.getEncPosition();
    }
    
    public double getRightEncoder() {
    	return topRightMotor.getEncPosition();
    }
    
    public double getLeftEnconderSpeed() {
    	return topLeftMotor.getSpeed();
    }
    
    public double getRightEnconderSpeed() {
    	return topRightMotor.getSpeed();
    }
    
    public void zeroEncoders() {
    	topLeftMotor.setPosition(0);
    	topRightMotor.setPosition(0);
    }
    
    public void changeControlMode(TalonControlMode mode) {
    	topLeftMotor.changeControlMode(mode);
//    	bottomLeftMotor.changeControlMode(mode);
    	topRightMotor.changeControlMode(mode);
//    	bottomRightMotor.changeControlMode(mode);
    }
    
    public void driveMotionMagic(double targetEncPosition) {
    	changeControlMode(TalonControlMode.MotionMagic);
    	topLeftMotor.set(-targetEncPosition);
//    	bottomLeftMotor.set(-targetEncPosition);
    	topRightMotor.set(targetEncPosition);
//    	bottomRightMotor.set(targetEncPosition);
    }
    
    public void turn(double angle) {
		double d = RobotMap.wheelBase * Math.PI * angle / 360.0 / RobotMap.wheelDiameter / Math.PI * 360*4;
		changeControlMode(TalonControlMode.MotionMagic);
    	topLeftMotor.set(d);
    	topRightMotor.set(d);
	}
	
}
    
    


