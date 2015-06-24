package main.java.headfirst.combined.djview;

public class TankTestDrive {

	public static void main(String[] args) {
		TankModel tankModel = new TankModel();
        ControllerInterface model = new TankController(tankModel);
	}

}
