package main.java.headfirst.combined.djview;

public class TankController implements ControllerInterface{

	TankModelInterface model;
	DJView djView;
	TankView tankView;
	
	public TankController(TankModelInterface model){
		this.model = model;
		djView = new DJView(this, new TankAdapter(model));
		djView.createView();
		//djView.createControls();
		//djView.disableStopMenuItem();
		//djView.disableStartMenuItem();
		tankView = new TankView(this,model);
		tankView.createView();
		tankView.setVisible(true);
		
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
