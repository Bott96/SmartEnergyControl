package it.unical.smartenergycontrol.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import it.unical.smartenergycontrol.logic.Config;
import it.unical.smartenergycontrol.logic.Controller;
import it.unical.smartenergycontrol.logic.Programs;

public class MoreThanOneFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int h = 100;
	int h1 = 250;
	int h2 = 400;
	int h3 = 550;
	int h4 = 650;

	ApplicationFrame app;
	Controller controller;

	JPanel p;
	public JLabel lblShowData;

	JLabel lblRegisterYourDevice;

	JLabel lblfirstDevice;

	JLabel lblName1;
	JLabel lblMaxKw1;
	JLabel lblPriority1;

	JTextArea txtName1;
	JTextArea txtMaxKw1;
	JComboBox<Integer> cmbPriority1;

	JButton plsRegister1;

	JLabel lblSecondDevice;

	JLabel lblName2;
	JLabel lblMaxKw2;
	JLabel lblPriority2;

	JTextArea txtName2;
	JTextArea txtMaxKw2;
	JComboBox<Integer> cmbPriority2;

	JButton plsRegister2;

	JLabel lblThirdDevice;

	JLabel lblName3;
	JLabel lblMaxKw3;
	JLabel lblPriority3;

	JTextArea txtName3;
	JTextArea txtMaxKw3;
	JComboBox<Integer> cmbPriority3;

	JButton plsRegister3;

	JButton plsRun;

	JButton plsBack;

	JButton plsReset;

	public MoreThanOneFrame(ApplicationFrame app) {
		super();
		this.app = app;

		System.out.println("SONO UQI");

		p = new JPanel();
		this.setContentPane(p);
		p.setLayout(null);

		this.setTitle("More Element");

		this.setLocation(1200, 50);
		this.setSize(600, 800);
		this.setFocusable(true);

		/** LBL SMART ENERGY CONTROL */
		lblShowData = new JLabel("", SwingConstants.CENTER);
		lblShowData.setBounds(50, 80, 500, 70);
		lblShowData.setFont(new Font(lblShowData.getFont().getName(), lblShowData.getFont().getStyle(), 30));
		lblShowData.setBackground(Color.orange);
		lblShowData.setForeground(new Color(100, 100, 100));
		lblShowData.setOpaque(true);

		/** LBL SMART ENERGY CONTROL */
		lblRegisterYourDevice = new JLabel("REGISTER YOUR DEVICES");
		lblRegisterYourDevice.setBounds(80, 10, 800, 50);
		lblRegisterYourDevice.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 30));

		lblfirstDevice = new JLabel("Device A");
		lblfirstDevice.setBounds(230, 60 + h, 180, 50);
		lblfirstDevice.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		lblName1 = new JLabel("Name");
		lblName1.setBounds(20, 100 + h, 120, 50);
		lblName1.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		txtName1 = new JTextArea("Condizionatore");
		txtName1.setBounds(20, 140 + h, 150, 30);
		txtName1.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		lblMaxKw1 = new JLabel("Max KW");
		lblMaxKw1.setBounds(200, 100 + h, 120, 50);
		lblMaxKw1.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		txtMaxKw1 = new JTextArea("250");
		txtMaxKw1.setBounds(200, 140 + h, 150, 30);
		txtMaxKw1.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		lblPriority1 = new JLabel("Priority");
		lblPriority1.setBounds(355, 100 + h, 120, 50);
		lblPriority1.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		cmbPriority1 = new JComboBox<>();
		cmbPriority1.addItem(1);
		cmbPriority1.addItem(2);
		cmbPriority1.addItem(3);
		cmbPriority1.setBounds(380, 140 + h, 50, 30);
		cmbPriority1.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		plsRegister1 = new JButton("Set");
		plsRegister1.setBounds(480, 140 + h, 100, 30);
		plsRegister1.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		/** SECOND DEVICE */

		lblSecondDevice = new JLabel("Device B");
		lblSecondDevice.setBounds(230, 60 + h1, 180, 50);
		lblSecondDevice.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		lblName2 = new JLabel("Name");
		lblName2.setBounds(20, 100 + h1, 120, 50);
		lblName2.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		txtName2 = new JTextArea("STUFA");
		txtName2.setBounds(20, 140 + h1, 150, 30);
		txtName2.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		lblMaxKw2 = new JLabel("Max KW");
		lblMaxKw2.setBounds(200, 100 + h1, 120, 50);
		lblMaxKw2.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		txtMaxKw2 = new JTextArea("250");
		txtMaxKw2.setBounds(200, 140 + h1, 150, 30);
		txtMaxKw2.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		lblPriority2 = new JLabel("Priority");
		lblPriority2.setBounds(355, 100 + h1, 120, 50);
		lblPriority2.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		cmbPriority2 = new JComboBox<>();
		cmbPriority2.addItem(1);
		cmbPriority2.addItem(2);
		cmbPriority2.addItem(3);
		cmbPriority2.setBounds(380, 140 + h1, 50, 30);
		cmbPriority2.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		plsRegister2 = new JButton("Set");
		plsRegister2.setBounds(480, 140 + h1, 100, 30);
		plsRegister2.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		/** THIRD DEVICE */

		lblThirdDevice = new JLabel("Device C");
		lblThirdDevice.setBounds(230, 60 + h2, 180, 50);
		lblThirdDevice.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		lblName3 = new JLabel("Name");
		lblName3.setBounds(20, 100 + h2, 120, 50);
		lblName3.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		txtName3 = new JTextArea("Compressore");
		txtName3.setBounds(20, 140 + h2, 150, 30);
		txtName3.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		lblMaxKw3 = new JLabel("Max KW");
		lblMaxKw3.setBounds(200, 100 + h2, 120, 50);
		lblMaxKw3.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		txtMaxKw3 = new JTextArea("350");
		txtMaxKw3.setBounds(200, 140 + h2, 150, 30);
		txtMaxKw3.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		lblPriority3 = new JLabel("Priority");
		lblPriority3.setBounds(355, 100 + h2, 120, 50);
		lblPriority3.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		cmbPriority3 = new JComboBox<>();
		cmbPriority3.addItem(1);
		cmbPriority3.addItem(2);
		cmbPriority3.addItem(3);
		cmbPriority3.setBounds(380, 140 + h2, 50, 30);
		cmbPriority3.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		plsRegister3 = new JButton("Set");
		plsRegister3.setBounds(480, 140 + h2, 100, 30);
		plsRegister3.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 22));

		plsRun = new JButton("Run");
		plsRun.setBounds(210, 60 + h3, 180, 50);
		plsRun.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		plsBack = new JButton("Back");
		plsBack.setBounds(30, 60 + h4, 180, 50);
		plsBack.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		plsReset = new JButton("Reset");
		plsReset.setBounds(390, 60 + h4, 180, 50);
		plsReset.setFont(
				new Font(lblRegisterYourDevice.getFont().getName(), lblRegisterYourDevice.getFont().getStyle(), 25));

		p.add(lblRegisterYourDevice);
		p.add(lblShowData);
		p.add(lblName1);
		p.add(lblfirstDevice);
		p.add(txtName1);
		p.add(lblMaxKw1);
		p.add(txtMaxKw1);
		p.add(lblPriority1);
		p.add(cmbPriority1);
		p.add(plsRegister1);

		p.add(lblName2);
		p.add(lblSecondDevice);
		p.add(txtName2);
		p.add(lblMaxKw2);
		p.add(txtMaxKw2);
		p.add(lblPriority2);
		p.add(cmbPriority2);
		p.add(plsRegister2);

		p.add(lblName3);
		p.add(lblThirdDevice);
		p.add(txtName3);
		p.add(lblMaxKw3);
		p.add(txtMaxKw3);
		p.add(lblPriority3);
		p.add(cmbPriority3);
		p.add(plsRegister3);

		p.add(plsRun);
		p.add(plsBack);
		p.add(plsReset);

		plsBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Programs.getInstance().setPorgrams(7);
				app.lblActualProgram.setText("No Program");
				Config.controller.dataARDUINOReset();

				setVisible(false);
				app.setVisible(true);

			}
		});

		plsReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Programs.getInstance().setPorgrams(7);
				Config.controller.dataARDUINOReset();

				Config.controller.lock.lock();
				Config.chiudiMoreThanOne = true;
				Config.controller.c.signalAll();
				Config.controller.lock.unlock();

				// Config.controller.managerDevice.reset();
			}
		});

		plsRegister1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Config.controller.managerDevice.AddDevice(11, txtName1.getText(), Integer.parseInt(txtMaxKw1.getText()),
						Integer.parseInt(cmbPriority1.getSelectedItem().toString()));

			}
		});

		plsRegister2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Config.controller.managerDevice.AddDevice(12, txtName2.getText(), Integer.parseInt(txtMaxKw2.getText()),
						Integer.parseInt(cmbPriority2.getSelectedItem().toString()));

			}
		});

		plsRegister3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Config.controller.managerDevice.AddDevice(13, txtName3.getText(), Integer.parseInt(txtMaxKw3.getText()),
						Integer.parseInt(cmbPriority3.getSelectedItem().toString()));

			}
		});

		plsRun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Programs.getInstance().setPorgrams(3);
				Config.controller.moreThanOneOpen();

			}
		});

	}

	public static void main(String[] args) {

		MoreThanOneFrame m = new MoreThanOneFrame(null);
		m.setVisible(true);

	}

}
