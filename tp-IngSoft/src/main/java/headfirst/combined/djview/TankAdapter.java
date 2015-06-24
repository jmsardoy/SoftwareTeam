package main.java.headfirst.combined.djview;

public class TankAdapter implements BeatModelInterface {
	TankModelInterface tank;
 
	public TankAdapter(TankModelInterface tank) {
		this.tank = tank;
	}

    public void initialize() {}
  
    public void on() {}
  
    public void off() {}
   
	public int getBPM() {
		return (int)(tank.getTankValue());
	}
  
    public void setBPM(int bpm) {}
   
	public void registerObserver(BeatObserver o) {
		tank.registerObserver(o);
	}
    
	public void removeObserver(BeatObserver o) {
		tank.removeObserver(o);
	}
     
	public void registerObserver(BPMObserver o) {
		tank.registerObserver(o);
	}
  
	public void removeObserver(BPMObserver o) {
		tank.removeObserver(o);
	}

	public void registerObserver(LevelObserver o) {
		tank.registerObserver(o);
	}

	public void removeObserver(LevelObserver o) {
		tank.removeObserver(o);
	}
	
	public int getNumeroDeLlamadas() {
		return -1;
	}
	public boolean getEstadoBomba(){
		return tank.getEstadoBomba();
	}
}
