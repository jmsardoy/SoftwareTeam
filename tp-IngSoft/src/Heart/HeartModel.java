package Heart;

import java.util.*;

import Beat.BPMObserver;
import Beat.BeatObserver;
import Tank.LevelObserver;

public class HeartModel implements HeartModelInterface, Runnable {
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	ArrayList levelObservers = new ArrayList();
	int time = 1000;
    int bpm = 90;
	Random random = new Random(System.currentTimeMillis());
	Thread thread;
	
	private static HeartModel instanciaUnica;
	private static int numeroDeLlamadas;
	
	private HeartModel(){
		thread = new Thread(this);
		thread.start();
		numeroDeLlamadas = 0;
	}
	
	public static HeartModel getInstance() {
		if(instanciaUnica == null){
			instanciaUnica = new HeartModel();
		}
		numeroDeLlamadas++;
		return instanciaUnica;
	}

	public void run() {
		int lastrate = -1;
		notifyBPMObservers();
		for(;;) {
			int change = random.nextInt(10);
			if (random.nextInt(2) == 0) {
				change = 0 - change;
			}
			int rate = 60000/(time + change);
			if (rate < 120 && rate > 50) {
				time += change;
				notifyBeatObservers();
				if (rate != lastrate) {
					lastrate = rate;
					notifyBPMObservers();
				}
			}
			try {
				Thread.sleep(time);
			} catch (Exception e) {}
		}
	}
	public int getHeartRate() {
		return 60000/time;
	}

	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}
	
	public void registerObserver(LevelObserver o) {
		levelObservers.add(o);
	}

	public void removeObserver(LevelObserver o) {
		int i = levelObservers.indexOf(o);
		if (i >= 0) {
			levelObservers.remove(i);
		}
	}
	
	public int getNumeroDeLlamadas(){
		return numeroDeLlamadas;
	}

	
	public HeartModel pedirInstance() {
		// TODO Auto-generated method stub
		HeartModel heart = getInstance();
		notifyBPMObservers();
		return heart;
	}
}
