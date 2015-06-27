package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import Heart.HeartModel;


public class SingletonTest {

	
	private HeartModel heart;
	
	
	@Before
	public void setUp(){
		heart = HeartModel.getInstance();
	}
	@Test
	public void NumeroDeLlamadasTest() {
		int expected = heart.getNumeroDeLlamadas();
		for(int i = 0; i<10;i++){
			HeartModel.getInstance();
		}
		assertEquals(expected+10, heart.getNumeroDeLlamadas());
	}
	
	@Test
	public void instanceTest(){
		HeartModel instance = HeartModel.getInstance();
		assertEquals(instance, HeartModel.getInstance());
	}

}
