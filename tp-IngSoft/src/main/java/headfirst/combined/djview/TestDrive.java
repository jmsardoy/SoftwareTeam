package main.java.headfirst.combined.djview;

public class TestDrive {

	public static void main(String[] args) {
		TankModel tankModel = new TankModel();
        ControllerInterface tankController = new TankController(tankModel);
        
        HeartModel heartModel = HeartModel.getInstance();
        ControllerInterface hearController = new HeartController(heartModel);
        
        BeatModelInterface model = new BeatModel();
		ControllerInterface beatController = new BeatController(model);
        
	}
}
