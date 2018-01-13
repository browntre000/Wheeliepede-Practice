package frc.team829.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {

    ArrayList<GoatSystem> subSystems = new ArrayList<GoatSystem>();
    Joystick dualA, dualB;
    Compressor comp;

    public void robotInit() {

        subSystems.add(new Drive());

        comp = new Compressor();
        comp.start();

        dualA = new Joystick(0);
        dualB = new Joystick(1);

    }

    public void teleopPeriodic() {

        for(GoatSystem sub: subSystems) {
            sub.update(dualA, dualB);
            sub.dashboard();
        }

    }

}
