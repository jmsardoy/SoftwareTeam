package main.java.headfirst.combined.djview;

import java.util.ArrayList;

public class TankModel implements TankModelInterface{
	
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	ArrayList levelObservers = new ArrayList();
	
	private float valorMinimo;
	private float consumeRate;
	private float fillRate;
	
	Tank tank;
	Consumidor consumidor;
	Bomba bomba;
	
	Thread consumidorThread;
	Thread bombaThread;
	
	public TankModel(){
		tank = new Tank();
		valorMinimo = 0;
		consumeRate = 0;
		fillRate = 0;
		consumidor = new Consumidor(this);
		bomba = new Bomba(this);
		
	}
		
	public void simular() {
		consumidorThread = new Thread(consumidor);
		bombaThread = new Thread(bomba);
		consumidorThread.start();
		bombaThread.start();
	
	}

	@SuppressWarnings("deprecation")
	public void parar() {
		bomba.apagarBomba();
		consumidorThread.stop();
		bombaThread.stop();

		
	}
	
	public synchronized float getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public float getConsumeRate() {
		return consumeRate;
	}

	public void setConsumeRate(float consumeRate) {
		this.consumeRate = consumeRate;
	}
	public float getFillRate() {
		return fillRate;
	}

	public void setFillRate(float fillRate) {
		this.fillRate = fillRate;
	}
	
	public float getTankValue(){
		return tank.getCantidadDeAgua();
	}
	public void setParametros(float valorMinimo, float consumeRate, float fillRate){
		this.setValorMinimo(valorMinimo);
		this.setConsumeRate(consumeRate);
		this.setFillRate(fillRate);
	}
	
	

	public void consumir(float cantidad){
		tank.consumir(cantidad);
		notifyLevelObservers();
	}
	
	public void llenar(float cantidad){
		tank.llenar(cantidad);
		notifyLevelObservers();
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
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
		
	}

	
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
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
	
	public void notifyLevelObservers() {
		for(int i = 0; i < levelObservers.size(); i++) {
			LevelObserver observer = (LevelObserver)levelObservers.get(i);
			observer.updateLevel();
		}
	}
	
	public Tank getTank(){
		return tank;
	}
	
	public boolean getEstadoBomba(){
		return bomba.getPrendida();
	}
	

	


}
