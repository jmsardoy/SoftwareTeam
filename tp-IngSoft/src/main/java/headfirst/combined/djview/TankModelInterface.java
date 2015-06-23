package main.java.headfirst.combined.djview;

public interface TankModelInterface {
	
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
	void simular();
	void parar();

}
