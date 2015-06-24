package main.java.headfirst.combined.djview;

public class Tank {
	float agua;
	
	public Tank(){
		agua = 0;
	}
	
	public synchronized void llenar(float incremento){
		if(incremento < 0){
			System.out.println("error, valor negativo para llenar tanque");
		}
		else{
			if(agua + incremento > 100){
				agua = 100;
			}
			else{
				agua = agua + incremento;
			}
			
		}
	}
	
	public synchronized void consumir(float consumo){
		if(consumo < 0 ){
			System.out.println("error, valor negativo para consumir");
		}
		else{
			if(agua-consumo< 0){
				agua = 0;
			}
			else{
				agua = agua-consumo;
			}
		}
	}
	
	public synchronized float getCantidadDeAgua(){
		return agua;
	}

}
