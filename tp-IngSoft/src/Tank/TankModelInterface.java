package Tank;

import Beat.BPMObserver;
import Beat.BeatObserver;

public interface TankModelInterface {
	
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
	void registerObserver(LevelObserver o);
	void removeObserver(LevelObserver o);
	void simular();
	void parar();
	void setParametros(float valorMinimo,float consumeRate,float fillRate);
	float getTankValue();
	boolean getEstadoBomba();
	boolean getDatosErroneos();
}