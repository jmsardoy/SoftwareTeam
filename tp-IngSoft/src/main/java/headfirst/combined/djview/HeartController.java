package main.java.headfirst.combined.djview;
  
public class HeartController implements ControllerInterface {
	static HeartModelInterface model;
	DJView view;
	static HeartAdapter heartAdapter;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		heartAdapter = new HeartAdapter(model);
		view = new DJView(this, heartAdapter);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
	public HeartController(DJView view){
		this.view = view;
		this.view.model = heartAdapter;
		this.view.controller = this;
	}
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		model.pedirInstance();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



