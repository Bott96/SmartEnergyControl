package it.unical.smartenergycontrol.gui;

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
import javax.swing.SwingConstants;

import it.unical.smartenergycontrol.logic.Controller;

public class ApplicationFrame extends JFrame {

	Controller controller;

	JPanel p;

	public JLabel lblShowData;
	JLabel lblSmartEnergyControl;
	JLabel lblThreeshold;
	JLabel lblTimeToUp;

	public JLabel lblProgram;

	JLabel lblActualProgram;

	JTextArea txtThreeshoold;
	JTextArea txtTime;

	JButton plsAutomatic;
	JButton plsTimer;
	JButton plsONOFF;

	public void setController(Controller c) {

		this.controller = c;

	}

	public ApplicationFrame() {
		super();

		p = new JPanel();/** lbl threshuld */

		lblThreeshold = new JLabel("Threeshold");
		lblThreeshold.setBounds(320, 190, 250, 70);
		lblThreeshold.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 30));

		this.setTitle("SmartEnergyControl");

		this.setLocation(1200, 50);
		this.setFocusable(true);

		Toolkit TK = Toolkit.getDefaultToolkit();

		Dimension d = TK.getScreenSize();
		this.setSize(600, 800);

		Color c = new Color(10, 100, 100);

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(1200, 50);
		this.setContentPane(p);
		p.setLayout(null);

		/** LBL SMART ENERGY CONTROL */
		lblSmartEnergyControl = new JLabel("SMART ENERGY CONTROL");
		lblSmartEnergyControl.setBounds(80, 10, 800, 50);
		lblSmartEnergyControl.setFont(
				new Font(lblSmartEnergyControl.getFont().getName(), lblSmartEnergyControl.getFont().getStyle(), 30));

		/** LBL Program */
		lblProgram = new JLabel("Program: ");
		lblProgram.setBounds(80, 90, 800, 50);
		lblProgram.setFont(
				new Font(lblSmartEnergyControl.getFont().getName(), lblSmartEnergyControl.getFont().getStyle(), 30));

		/** LBL Program */
		lblActualProgram = new JLabel(" Off ");
		lblActualProgram.setBounds(280, 90, 800, 50);
		lblActualProgram.setFont(
				new Font(lblSmartEnergyControl.getFont().getName(), lblSmartEnergyControl.getFont().getStyle(), 30));

		/** LBL SMART ENERGY CONTROL */
		lblShowData = new JLabel("", SwingConstants.CENTER);
		lblShowData.setBounds(50, 160, 500, 70);
		lblShowData.setFont(new Font(lblShowData.getFont().getName(), lblShowData.getFont().getStyle(), 40));
		lblShowData.setBackground(Color.orange);
		lblShowData.setForeground(new Color(100, 100, 100));
		lblShowData.setOpaque(true);

		/** PLS AUTOMATIC */

		plsAutomatic = new JButton("Automatic");
		plsAutomatic.setBounds(50, 275, 250, 70);
		plsAutomatic.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 30));

		/** lbl threshuld */

		lblThreeshold = new JLabel("Threeshold");
		lblThreeshold.setBounds(320, 250, 250, 70);
		lblThreeshold.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 30));

		/** txt threshuld */

		txtThreeshoold = new JTextArea("");
		txtThreeshoold.setBounds(320, 310, 200, 40);
		txtThreeshoold.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 30));

		/** PLS TIME */

		plsTimer = new JButton("Set time");
		plsTimer.setBounds(50, 475, 250, 70);
		plsTimer.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 30));

		/** lbl TIMETOUP */

		lblTimeToUp = new JLabel("Threeshold");
		lblTimeToUp.setBounds(320, 450, 250, 70);
		lblTimeToUp.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 30));

		/** txt SETTIME */

		txtTime = new JTextArea("");
		txtTime.setBounds(320, 510, 200, 40);
		txtTime.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 30));

		/** PLS ON-OFF */

		plsONOFF = new JButton("MANUAL ON");
		plsONOFF.setBounds(50, 675, 500, 70);
		plsONOFF.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 30));

		p.add(lblSmartEnergyControl);
		p.add(lblShowData);
		p.add(plsAutomatic);
		p.add(lblThreeshold);
		p.add(txtThreeshoold);
		p.add(plsTimer);
		p.add(txtTime);
		p.add(lblTimeToUp);
		p.add(plsONOFF);
		p.add(lblProgram);
		p.add(lblActualProgram);

		plsAutomatic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (txtThreeshoold.getText().equals("")) {
					JOptionPane optionPane = new JOptionPane("You must insert Threeshold", JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					return;
				}

				lblActualProgram.setText("SmartOpen");
				int threeshold = Integer.parseInt(txtThreeshoold.getText());
				System.out.println(threeshold+"   asdasdasdasdasd");

				
				controller.smartOpenProgram(threeshold);

			}
		});

	}

	public static void main(String[] args) {
		ApplicationFrame a = new ApplicationFrame();

		a.setVisible(true);

	}

}
