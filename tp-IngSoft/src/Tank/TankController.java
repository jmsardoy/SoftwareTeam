package Tank;

import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Beat.DJView;
import BeatBarView.BeatBarView;

public class TankController implements ControllerInterface{

	static TankModelInterface model;
	static TankAdapter tankAdapter;
	DJView djView;
	TankView tankView;
	
	public TankController(TankModelInterface model){
		this.model = model;
		tankAdapter = new TankAdapter(model);
		djView = new BeatBarView(this, tankAdapter);
		djView.createView();
		tankView = new TankView(this,model);
		tankView.createView();
		tankView.setVisible(true);
		
	}
	
	public TankController(BeatBarView v){
		if(tankAdapter != null){
			djView = v;
			((BeatBarView) djView).setModel(tankAdapter);
			((BeatBarView) djView).setController((ControllerInterface)this);
		}
		
	}
	
	
	public void simular(float valorMinimo,float consumo, float llenado){
		model.setParametros(valorMinimo, consumo, llenado);
		model.simular();
	}
	public void parar(){
		model.parar();
	}
	public void start() {
	}

	public void stop() {
	}

	public void increaseBPM() {
	}


	public void decreaseBPM() {
		
	}
	
	public void setBPM(int bpm) {
		
	}
	
	
	

}
