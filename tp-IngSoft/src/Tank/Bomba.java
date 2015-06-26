package Tank;

public class Bomba implements Runnable{

	TankModel model;
	boolean prendida;
	public Bomba(TankModel model){
		this.model = model;
		prendida = false;
	}

	public void run() {
		while(true){
			if(model.getTankValue() < model.getValorMinimo()){
				prendida = true;
			}
			if(model.getTankValue()==100){
				prendida = false;
			}
			if(prendida == true){
				float fillValue = model.getFillRate();
				fillValue = fillValue/20;
				for(int i =0; i<20;i++){
					if(model.getTankValue() < model.getValorMinimo()){
						prendida = true;
					}
					if(model.getTankValue()==100){
						prendida = false;
					}
					model.llenar(fillValue);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
			
		}
		
	}
	public void apagarBomba(){
		prendida = false;
	}
	
	public boolean getPrendida(){
		return prendida;
	}

}
