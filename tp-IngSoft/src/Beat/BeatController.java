package Beat;

import BeatBarView.BeatBarView;

  
public class BeatController implements ControllerInterface {
	static BeatModelInterface model;
	DJView view;
   
	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(this, model);
        view.createView();
        view.createControls("Beat");
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}
	
	public BeatController(BeatBarView v){
		if(model != null){
			view = v;
			((BeatBarView) view).setModel(model);
			((BeatBarView) view).setController((ControllerInterface)this);
		}
		
	}
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
}
