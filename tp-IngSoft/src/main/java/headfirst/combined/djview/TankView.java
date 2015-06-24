package main.java.headfirst.combined.djview;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

public class TankView extends JFrame implements LevelObserver{

	TankModelInterface model;
	TankController controller;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JProgressBar progressBar;
	private JLabel lblBomba;

	/**
	 * Create the frame.
	 */
	public TankView(TankController controller,TankModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((LevelObserver)this);
		
	}
	
public void createView(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	((JPanel)getContentPane()).setOpaque(false);
	ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/fon.png"));
	JLabel fondo= new JLabel(); fondo.setIcon(uno);
	getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
	fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
	contentPane.setLayout(null);
	
	progressBar = new JProgressBar();
	progressBar.setBounds(254, 83, 170, 168);
	progressBar.setValue(0);
	progressBar.setStringPainted(true);
	//progressBar.setForeground(SystemColor.textHighlight);
	//progressBar.setForeground(Color.blue);
	progressBar.setOrientation(SwingConstants.VERTICAL);
	
	contentPane.add(progressBar);
	
	textField = new JTextField();
	textField.setBounds(106, 83, 86, 20);
	contentPane.add(textField);
	textField.setColumns(10);
	
	JLabel lblMinLevel = new JLabel("Nivel minimo");
	lblMinLevel.setBounds(20, 86, 76, 14);
	contentPane.add(lblMinLevel);
	
	final JSlider slider = new JSlider();
	slider.setBounds(221, 82, 23, 169);
	slider.setValue(30);
	slider.setOrientation(SwingConstants.VERTICAL);
	contentPane.add(slider);
	
	JLabel lblConsumo = new JLabel("Consumo");
	lblConsumo.setBounds(20, 117, 64, 14);
	contentPane.add(lblConsumo);
	
	JLabel lblLlenado = new JLabel("Llenado");
	lblLlenado.setBounds(20, 148, 64, 14);
	contentPane.add(lblLlenado);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(106, 114, 86, 20);
	contentPane.add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(106, 145, 86, 20);
	contentPane.add(textField_2);
	
	final JButton btnSimular = new JButton("Simular");
	btnSimular.setBounds(20, 173, 172, 23);
	contentPane.add(btnSimular);
	
	final JButton btnParar = new JButton("Parar");
	btnParar.setBounds(20, 198, 172, 23);
	contentPane.add(btnParar);
	
	lblBomba = new JLabel("BOMBA");
	lblBomba.setBounds(71, 233, 100, 14);
	contentPane.add(lblBomba);

	//EVENTOS
	
	//Slider modifica valor minimo
	ChangeListener sliderListener = new ChangeListener(){
		public void stateChanged(ChangeEvent e){
			JSlider slider = (JSlider)e.getSource();
			if(!slider.getValueIsAdjusting())
				textField.setText(String.valueOf(slider.getValue()));
		}
	};
	slider.addChangeListener(sliderListener);
	
	//Botones
	
	ActionListener btnListener = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSimular){
				float nivelMinimo = Float.parseFloat(textField.getText());
				float consumo = Float.parseFloat(textField_1.getText());
				float llenado = Float.parseFloat(textField_2.getText());
				slider.setValue((int)nivelMinimo);
				controller.simular(nivelMinimo,consumo,llenado);
				//System.out.println(nivelMinimo+consumo+llenado);
			}
			
			if(e.getSource() == btnParar){
				controller.parar();
			}
		}
	};
	btnSimular.addActionListener(btnListener);
	btnParar.addActionListener(btnListener);
	
	//this.setVisible(true);
}


	public void updateLevel() {
		if(progressBar != null){
			progressBar.setValue((int)model.getTankValue());
			if(model.getEstadoBomba()){
				lblBomba.setText("BOMBA: ON");
			}
			else{
				lblBomba.setText("BOMBA: OFF");
			}
			
		}
		
	}
}