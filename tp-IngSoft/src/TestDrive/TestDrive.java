package TestDrive;

import Beat.BeatController;
import Beat.BeatModel;
import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Heart.HeartController;
import Heart.HeartModel;
import Tank.TankController;
import Tank.TankModel;

public class TestDrive {

	
	public static void main(String[] args) {
		
		BeatModelInterface model = new BeatModel();
		ControllerInterface beatController = new BeatController(model);
		
		HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface heartController = new HeartController(heartModel);
        
        TankModel tankModel = new TankModel();
        ControllerInterface tankController = new TankController(tankModel);
        
	}

}
