package Heart;

import Beat.BPMObserver;
import Beat.BeatObserver;
import Tank.LevelObserver;

public interface HeartModelInterface {
	int getHeartRate();
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
	void registerObserver(LevelObserver o);
	void removeObserver(LevelObserver o);
	HeartModel pedirInstance();
	int getNumeroDeLlamadas();
}
