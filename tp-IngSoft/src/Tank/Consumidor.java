package Tank;

public class Consumidor implements Runnable {
	
	TankModel model;
	
	public Consumidor(TankModel model){
		this.model = model;
	}

	
	public void run() {
		
		while(true){
			float consumeRate = model.getConsumeRate();
			consumeRate = (float) (Math.random()*(0.4*consumeRate) + 0.8*consumeRate);
			consumeRate = consumeRate/20;
			float retardo = (float) (Math.random()*(400) + 800)/20;
			for(int i = 0; i< 20; i++){
				model.consumir(consumeRate);
				try {
					Thread.sleep((long)retardo);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
