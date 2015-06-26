package Heart;

import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Beat.DJView;
	

public class HeartView extends DJView{
	
	public HeartView(ControllerInterface controller, BeatModelInterface model){
		super(controller, model);
		
	}
	
	public void updateBPM() {
		if (model != null) {
			int bpm = model.getBPM();
			if (bpm == 0) {
				if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("offline");
				}
			} else {
				if (bpmOutputLabel != null) {
					int num = model.getNumeroDeLlamadas();
					if(num<0){
						bpmOutputLabel.setText("Current BPM: " + model.getBPM());
					}
					if(num>0){
						bpmOutputLabel.setText("Intentos: " + String.valueOf(num));
					}
				}
			}
		}
	}

}
