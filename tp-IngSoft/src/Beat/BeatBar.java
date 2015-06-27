package Beat;
  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BeatBar extends JProgressBar implements Runnable { 
    JProgressBar progressBar;
	Thread thread;
	boolean on = true;

	public BeatBar() {
		thread = new Thread(this);
		setMaximum(100);
		thread.start();
	}

	public void run() {
		for(;;) {
			boolean isOn;
			synchronized(BeatBar.class){
				isOn = on;
			}
			if(isOn){
				int value = getValue();
				value = (int)(value * .75);
				setValue(value);
				repaint();
				try {
					Thread.sleep(50);
				} catch (Exception e) {};
			}
			else
			{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public synchronized void stop(){
		on = false;
	}
	public synchronized void resume(){
		on = true;
	}
}
