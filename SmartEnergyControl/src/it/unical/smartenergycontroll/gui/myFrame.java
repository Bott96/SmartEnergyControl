package it.unical.smartenergycontroll.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import it.unical.smartenergycontroll.logic.Controller;

public class myFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2889065122470823581L;

	Controller controller;

	JPanel P;
	JButton plsTelosConnect, plsArduinoConnect, plsStartApplication;
	JLabel lblTelosBConfiguration;
	JLabel lblArduinoConfiguration;
	public JLabel lblTelosbResponce;
	JLabel lblTelosSerialPort;
	JLabel lblArduinoSerialPort;
	public JLabel lblArduinoResponce;
	JTextArea txtserialPortTelosb;
	JTextArea txtserialPortArduino;

	ApplicationFrame applicationFrame;

	boolean ArduinoComunicationSetted = false, telosbComunicationSetted = false;

	public myFrame(ApplicationFrame a) {
		super();
		applicationFrame = a;
		applicationFrame.setController(controller);

		// setLayout(manager);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		plsTelosConnect = new JButton("Start Telosb Connection");
		plsTelosConnect.setBounds(50, 100, 500, 100);

		plsArduinoConnect = new JButton("Start Arduino Connection");
		plsStartApplication = new JButton("Start Application");

		this.setTitle("SmartEnergyControll");

		this.setLocation(1200, 50);

		Toolkit TK = Toolkit.getDefaultToolkit();

		Dimension d = TK.getScreenSize();
		this.setSize(600, 800);

		Color c = new Color(10, 100, 100);

		P = new JPanel();
		P.setLayout(null);
		/****************** LABEL TELOSB CONFIGRATION ****************************/
		lblTelosBConfiguration = new JLabel("TELOSB CONFIGURATION");
		lblTelosBConfiguration.setBounds(120, 10, 800, 50);
		lblTelosBConfiguration.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 25));

		/****************** LABEL TELOSB SERIAL PORT ****************************/

		lblTelosSerialPort = new JLabel("SERIAL PORT");
		lblTelosSerialPort.setBounds(10, 75, 800, 50);
		lblTelosSerialPort.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 25));

		/****************** TEXTBOX SERIALPORT TELOSB ****************************/

		txtserialPortTelosb = new JTextArea();
		txtserialPortTelosb.setBounds(10, 125, 190, 50);

		txtserialPortTelosb.setText("/dev/ttyUSB0");
		txtserialPortTelosb.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 25));

		/****************** BUTTON TELOSB START CONNECTION ****************************/

		// lblTelosSerialPort = new JLabel("SERIAL PORT");
		plsTelosConnect.setBounds(220, 95, 350, 80);
		plsTelosConnect.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 21));

		/*************************************************
		 * ARDUINO
		 **********************************************************************/

		/****************** LABEL ARDUINO CONFIGRATION ****************************/

		lblArduinoConfiguration = new JLabel("ARDUINO CONFIGURATION");
		lblArduinoConfiguration.setBounds(120, 290, 800, 50);
		lblArduinoConfiguration.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 25));

		/****************** LABEL ARDUINO SERIAL PORT ****************************/

		lblArduinoSerialPort = new JLabel("SERIAL PORT");
		lblArduinoSerialPort.setBounds(10, 355, 800, 50);
		lblArduinoSerialPort.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 25));

		/****************** TEXTBOX SERIALPORT ARDUINO ****************************/

		txtserialPortArduino = new JTextArea();
		txtserialPortArduino.setBounds(10, 405, 190, 50);
		txtserialPortArduino.setText("/dev/ttyACM0");
		txtserialPortArduino.setFont(
				new Font(lblArduinoSerialPort.getFont().getName(), lblArduinoSerialPort.getFont().getStyle(), 25));

		/******************
		 * BUTTON ARDUINO START CONNECTION
		 ****************************/

		plsArduinoConnect.setBounds(220, 375, 350, 80);
		plsArduinoConnect.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 21));

		/****************** LABEL ARDUINO RESPONCE ****************************/

		lblArduinoResponce = new JLabel("");
		lblArduinoResponce.setBounds(150, 475, 800, 50);
		lblArduinoResponce.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 25));

		/****************** LABEL TELOSB RESPONCE ****************************/

		lblTelosbResponce = new JLabel("");
		this.setTitle("SmartEnergyControll");

		this.setLocation(1200, 50);
		lblTelosbResponce.setBounds(150, 200, 800, 50);
		lblTelosbResponce.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 25));

		/************** START BUTTON ******************/

		plsStartApplication.setBounds(50, 565, 500, 80);
		plsStartApplication.setFont(
				new Font(lblTelosBConfiguration.getFont().getName(), lblTelosBConfiguration.getFont().getStyle(), 21));

		this.setBackground(c);
		this.setContentPane(P);

		plsArduinoConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String connectionPort = txtserialPortArduino.getText();
				controller.startArduinoConnection(connectionPort);
				ArduinoComunicationSetted = true;

			}
		});

		plsTelosConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String connectionPort = txtserialPortTelosb.getText();
				controller.startTelosbConnection(connectionPort);
				telosbComunicationSetted = true;

			}
		});

		plsStartApplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!ArduinoComunicationSetted && !telosbComunicationSetted) {
					JOptionPane optionPane = new JOptionPane(
							"You must connect the end devices before start appliacation", JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog

				} else {
					setVisible(false);
					applicationFrame.setVisible(true);
				}

			}
		});

		P.add(lblTelosBConfiguration);
		P.add(lblArduinoConfiguration);
		P.add(lblTelosSerialPort);
		P.add(txtserialPortTelosb);
		P.add(lblArduinoSerialPort);
		P.add(txtserialPortArduino);
		P.add(plsArduinoConnect);
		P.add(plsTelosConnect);
		P.add(plsStartApplication);
		P.add(lblArduinoResponce);
		P.add(lblTelosbResponce);

		controller = new Controller(this);
		applicationFrame.setController(controller);
		
	}
	
	public Controller getController() {
		return controller;
	}
	
	public ApplicationFrame getApplicationFrame() {
		return applicationFrame;
	}

}
