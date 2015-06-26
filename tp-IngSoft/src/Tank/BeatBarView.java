package Tank;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Beat.BPMObserver;
import Beat.BeatBar;
import Beat.BeatController;
import Beat.BeatModelInterface;
import Beat.BeatObserver;
import Beat.ControllerInterface;
import Beat.DJView;
import Heart.HeartController;
import Heart.HeartView;

public class BeatBarView extends HeartView implements LevelObserver{
	
	BeatBarView thisView = this;

	public BeatBarView(ControllerInterface controller, BeatModelInterface model) {
		super(controller, model);
	}
	
    public void createView() {
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        
        menuBar = new JMenuBar();
        menu = new JMenu("Modelo");
        startMenuItem = new JMenuItem("Tank");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	new TankController(thisView);
            	setBeatBarToDefault();
            	updateLevel();
            }
        });
        stopMenuItem = new JMenuItem("Beat");
        menu.add(stopMenuItem); 
        stopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	new BeatController(thisView);
            	setBeatBarToDefault();
            	updateBPM();
            }
        });
        JMenuItem exit = new JMenuItem("Heart");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	new HeartController(thisView);
            	setBeatBarToDefault();
            	updateBPM();
            }
        });

        menu.add(exit);
        menuBar.add(menu);
        viewFrame.setJMenuBar(menuBar);
	}
    
	public void updateLevel(){
		if(beatBar != null){
			beatBar.stop();
			beatBar.setValue(model.getBPM());
			bpmOutputLabel.setText("Tank Level " + model.getBPM());
		}
		
	}
	
	public void setModel(BeatModelInterface m){
		model.removeObserver((BeatObserver)thisView);
		model.removeObserver((BPMObserver)thisView);
		model.removeObserver((LevelObserver)thisView);
		model = m;
		model.registerObserver((BeatObserver)thisView);
		model.registerObserver((BPMObserver)thisView);
		model.registerObserver((LevelObserver)thisView);
	}
	
	public void setController(ControllerInterface c){
		controller = c;
	}
	
	public void setBeatBarToDefault(){
		beatBar.resume();
		//beatBar = new BeatBar();
		beatBar.setValue(0);
		bpmOutputLabel.setText("offline");
	}
	

}
