package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import Tank.TankModel;

public class TankTest {

	TankModel tank;
	
	@Before
	public void setUp() {
		tank = new TankModel();
	}
	
	@Test
	public void gettersTest(){
		float valorMinimoExpected =(float) 12.56;
		float consumeRateExpected = (float)90.5;
		float fillRateExpected = (float) 5.9;
		tank.setParametros(valorMinimoExpected,consumeRateExpected,fillRateExpected);
		assertEquals(valorMinimoExpected ,tank.getValorMinimo(),0.000001);
		assertEquals(consumeRateExpected, tank.getConsumeRate(),0.000001);
		assertEquals(fillRateExpected, tank.getFillRate(),0.000001);
		
	}
	
	@Test
	public void datosErroneosTest(){
		tank.setParametros((float)12.56, (float)90.5, (float)5.9);
		assertEquals(false,tank.getDatosErroneos());
		tank.setParametros((float)150, (float)90.5, (float)5.9);
		assertEquals(true,tank.getDatosErroneos());
		tank.setParametros((float)-1, (float)90.5, (float)5.9);
		assertEquals(true,tank.getDatosErroneos());
		tank.setParametros((float)12.56, (float)-6, (float)5.9);
		assertEquals(true,tank.getDatosErroneos());
		tank.setParametros((float)12.56, (float)90.5, (float)-156.69);
		assertEquals(true,tank.getDatosErroneos());
		
	}
	@Test
	public void testConsumir(){
		for(int i = 0; i <100; i++){
			tank.llenar(i);
			float auxiliar = tank.getTankValue();
			float consumo = (float) Math.random()*100;
			tank.consumir(consumo);
			if(auxiliar - consumo < 0){
				assertEquals(0,tank.getTankValue(),0.000001);
				}
			else{
				assertEquals(auxiliar - consumo, tank.getTankValue(), 0.000001);
			}
			tank.consumir(101);
		}
	}
	
	@Test
	public void testLlenar(){
		tank.consumir(101);
		for(int i = 0; i < 120; i++){
			tank.llenar(i);
			if(i > 100){
				assertEquals(100,tank.getTankValue(),0.000001);
			}
			else{
				assertEquals(i,tank.getTankValue(),0.000001);
			}
			tank.consumir(i);
		}
	}
	@Test
	public void testBomba(){
		assertEquals(false,tank.getEstadoBomba());
		tank.setParametros(80,100,0); //parametros en los que la bomba deberia estar siempre prendida
		tank.simular();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertEquals(true,tank.getEstadoBomba());
		tank.parar();
		assertEquals(false,tank.getEstadoBomba());
		tank.consumir(101);
	}
	
	

}
