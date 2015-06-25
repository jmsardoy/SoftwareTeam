package main.java.headfirst.combined.djview;

public class TankController implements ControllerInterface{

	TankModelInterface model;
	DJView djView;
	TankView tankView;
	static TankAdapter tankAdapter;
	
	public TankController(TankModelInterface model){
		this.model = model;
		tankAdapter = new TankAdapter(model);
		djView = new DJView(this, tankAdapter);
		djView.createView();
		tankView = new TankView(this,model);
		tankView.createView();
		tankView.setVisible(true);
		
	}
	
	public TankController(DJView view){
		djView = view;
		djView.model = tankAdapter;
		djView.controller = this;
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
