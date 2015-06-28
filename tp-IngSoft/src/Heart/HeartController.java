package Heart;

import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Beat.DJView;
import BeatBarView.BeatBarView;
  
public class HeartController implements ControllerInterface {
	static HeartModelInterface model;
	static HeartAdapter heartAdapter;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		heartAdapter = new HeartAdapter(model);
		view = new HeartView(this, heartAdapter);
        view.createView();
        view.createControls("Heart");
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
	
	public HeartController(BeatBarView v){
		if(heartAdapter != null){
			view = v;
			((BeatBarView) view).setModel(heartAdapter);
			((BeatBarView) view).setController((ControllerInterface)this);
		}
		
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
		model.pedirInstance();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



