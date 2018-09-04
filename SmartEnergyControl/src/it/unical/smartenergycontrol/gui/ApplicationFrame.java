package it.unical.smartenergycontrol.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import it.unical.smartenergycontrol.logic.Config;
import it.unical.smartenergycontrol.logic.Controller;
import it.unical.smartenergycontrol.logic.Programs;

public class ApplicationFrame extends JFrame {


	MoreThanOneFrame moreThanOneFrame;

	JPanel p;

	public JLabel lblShowData;
	JLabel lblSmartEnergyControl;
	JLabel lblThreeshold;
	JLabel lblTimeToUp;
	JLabel lblTimeToDown;

	JLabel lblProgram;

	public JLabel lblActualProgram;

	JTextArea txtThreeshoold;
	JTextArea txtTimeToUp;
	JTextArea txtTimeToDown;

	JButton plsAutomatic;
	JButton plsTimer;
	public JButton plsONOFF;
	public JButton plsMoreThanOne;
	JButton plsResetProgram;


	public ApplicationFrame() {
		super();

		moreThanOneFrame = new MoreThanOneFrame(this);
		moreThanOneFrame.setVisible(false);

		p = new JPanel();
		this.setContentPane(p);
		p.setLayout(null);

		this.setTitle("SmartEnergyControl");

		this.setLocation(1200, 50);
		this.setFocusable(true);
		this.setSize(600, 800);

		lblThreeshold = new JLabel("Threeshold");
		lblThreeshold.setBounds(320, 190, 250, 70);
		lblThreeshold.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 25));

		Toolkit TK = Toolkit.getDefaultToolkit();

		Dimension d = TK.getScreenSize();

		Color c = new Color(10, 100, 100);

		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** LBL SMART ENERGY CONTROL */
		lblSmartEnergyControl = new JLabel("SMART ENERGY CONTROL");
		lblSmartEnergyControl.setBounds(80, 10, 800, 50);
		lblSmartEnergyControl.setFont(
				new Font(lblSmartEnergyControl.getFont().getName(), lblSmartEnergyControl.getFont().getStyle(), 30));

		/** LBL Program */
		lblProgram = new JLabel("Program: ");
		lblProgram.setBounds(80, 90, 800, 50);
		lblProgram.setFont(
				new Font(lblSmartEnergyControl.getFont().getName(), lblSmartEnergyControl.getFont().getStyle(), 25));

		/** LBL Program */
		lblActualProgram = new JLabel("No Program");
		lblActualProgram.setBounds(280, 90, 800, 50);
		lblActualProgram.setFont(
				new Font(lblSmartEnergyControl.getFont().getName(), lblSmartEnergyControl.getFont().getStyle(), 25));

		/** LBL SMART ENERGY CONTROL */
		lblShowData = new JLabel("", SwingConstants.CENTER);
		lblShowData.setBounds(50, 160, 500, 70);
		lblShowData.setFont(new Font(lblShowData.getFont().getName(), lblShowData.getFont().getStyle(), 30));
		lblShowData.setBackground(Color.orange);

		lblShowData.setForeground(new Color(100, 100, 100));
		lblShowData.setOpaque(true);

		/** PLS AUTOMATIC */

		plsAutomatic = new JButton("Smart Control");
		plsAutomatic.setBounds(50, 275, 250, 50);
		plsAutomatic.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 25));

		/** PLS More THAN ONE */

		plsMoreThanOne = new JButton("More Smart Control");
		plsMoreThanOne.setBounds(100, 345, 400, 50);
		plsMoreThanOne.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 25));

		/** lbl threshuld */

		lblThreeshold = new JLabel("Threeshold");
		lblThreeshold.setBounds(320, 230, 250, 70);
		lblThreeshold.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 25));

		/** txt threshuld */

		txtThreeshoold = new JTextArea();
		txtThreeshoold.setBounds(320, 290, 200, 40);
		txtThreeshoold.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 25));

		/** PLS TIME */

		plsTimer = new JButton("Set time");
		plsTimer.setBounds(50, 475, 190, 70);
		plsTimer.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 25));

		/** lbl TIMETOUP */

		lblTimeToUp = new JLabel("Time on");
		lblTimeToUp.setBounds(260, 450, 190, 70);
		lblTimeToUp.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 25));

		/** txt SETTIME */

		txtTimeToUp = new JTextArea();
		txtTimeToUp.setBounds(260, 510, 140, 40);
		txtTimeToUp.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 25));

		/** lbl TIMETODOWN */

		lblTimeToDown = new JLabel("Time off");
		lblTimeToDown.setBounds(420, 450, 250, 70);
		lblTimeToDown.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 25));

		/** txt SETTIMETODOWN */

		txtTimeToDown = new JTextArea();
		txtTimeToDown.setBounds(420, 510, 140, 40);
		txtTimeToDown.setFont(new Font(lblThreeshold.getFont().getName(), lblThreeshold.getFont().getStyle(), 25));

		/** PLS ON-OFF */

		plsONOFF = new JButton("Manual On");
		plsONOFF.setBounds(50, 625, 500, 70);
		plsONOFF.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 25));

		/** PLS ResetPrograms */

		plsResetProgram = new JButton("Reset");
		plsResetProgram.setBounds(50, 725, 300, 50);
		plsResetProgram.setFont(new Font(plsAutomatic.getFont().getName(), plsAutomatic.getFont().getStyle(), 25));

		p.add(lblSmartEnergyControl);
		p.add(lblShowData);
		p.add(plsAutomatic);
		p.add(lblThreeshold);
		p.add(txtThreeshoold);
		p.add(plsTimer);
		p.add(txtTimeToUp);
		p.add(lblTimeToUp);
		p.add(plsONOFF);
		p.add(lblProgram);
		p.add(lblActualProgram);
		p.add(plsResetProgram);
		p.add(txtTimeToDown);
		p.add(lblTimeToDown);
		p.add(plsMoreThanOne);

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

				if (Programs.getInstance().isSmartControl()) {

					Programs.getInstance().setPorgrams(5);
					int threeshold = Integer.parseInt(txtThreeshoold.getText());
					Config.controller.smartOpenProgram(threeshold);

				}

				lblActualProgram.setText("SmartOpen");
				int threeshold = Integer.parseInt(txtThreeshoold.getText());
				System.out.println(threeshold + "   asdasdasdasdasd");

				Config.controller.smartOpenProgram(threeshold);

			}
		});

		plsMoreThanOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				moreThanOneFrame.setVisible(true);

			}
		});

		plsResetProgram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Programs.getInstance().setPorgrams(7);
				lblActualProgram.setText("No Program");
				Config.controller.dataARDUINOReset();

			}
		});

		plsTimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				lblActualProgram.setText("Timer");

				String timeup = txtTimeToUp.getText();
				timeup.trim();
				String[] partOfUp = timeup.trim().split(":");

				String timedown = txtTimeToDown.getText();
				timedown.trim();
				String[] partOfUDown = timedown.trim().split(":");

				if ((timeup.equals("") || timedown.equals(""))) {
					JOptionPane optionPane = new JOptionPane("1  You must insert Hours:Minutes to time on and time off",
							JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					return;
				}

				if ((timeup.trim().matches("\\d\\d:\\d\\d") && timedown.trim().matches("\\d\\d:\\d\\d"))) {

					System.out.println("Rispetta");
					Calendar c = Calendar.getInstance();
					Date s = c.getTime();

					System.out.println(s.getHours() + "----" + s.getMinutes());

					if ((Integer.parseInt(partOfUp[0]) >= 1 && Integer.parseInt(partOfUp[0]) <= 23)
							&& (Integer.parseInt(partOfUDown[0]) >= 1 && Integer.parseInt(partOfUDown[0]) <= 23)) {

						if ((Integer.parseInt(partOfUp[1]) >= 0 && Integer.parseInt(partOfUp[1]) <= 59)
								&& (Integer.parseInt(partOfUDown[1]) >= 0 && Integer.parseInt(partOfUDown[1]) <= 59)) {

							if (Integer.parseInt(partOfUp[0]) > Integer.parseInt(partOfUDown[0])) {

								JOptionPane optionPane = new JOptionPane(" Hours down, must be higher than hours up",
										JOptionPane.WARNING_MESSAGE);
								JDialog dialog = optionPane.createDialog("Warning!");
								dialog.setAlwaysOnTop(true); // to show top of all other application
								dialog.setVisible(true); // to visible the dialog
								return;
							}

							if (Integer.parseInt(partOfUp[0]) == Integer.parseInt(partOfUDown[0])) {

								if (Integer.parseInt(partOfUp[1]) > Integer.parseInt(partOfUDown[1])) {

									JOptionPane optionPane = new JOptionPane(
											" minutes down, must be higher than minute up if hours is equals",
											JOptionPane.WARNING_MESSAGE);
									JDialog dialog = optionPane.createDialog("Warning!");
									dialog.setAlwaysOnTop(true); // to show top of all other application
									dialog.setVisible(true); // to visible the dialog
									return;

								}
							}
							System.out.println("TUTTO OK.");

							Programs.getInstance().setPorgrams(5);
							Config.controller.timeControl(partOfUp, partOfUDown);

						} else {
							JOptionPane optionPane = new JOptionPane("You must insert Hours:Minutes, conrrectly",
									JOptionPane.WARNING_MESSAGE);
							JDialog dialog = optionPane.createDialog("Warning!");
							dialog.setAlwaysOnTop(true); // to show top of all other application
							dialog.setVisible(true); // to visible the dialog
							return;
						}

					} else {
						JOptionPane optionPane = new JOptionPane("You must insert Hours:Minutes, conrrectly",
								JOptionPane.WARNING_MESSAGE);
						JDialog dialog = optionPane.createDialog("Warning!");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog
						return;
					}

				} else {
					JOptionPane optionPane = new JOptionPane("2 You must insert Hours:Minutes to time on and time off",
							JOptionPane.WARNING_MESSAGE);
					JDialog dialog = optionPane.createDialog("Warning!");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					return;
				}

			}
		});

		txtTimeToUp.setToolTipText("Example: 16:52");
		txtTimeToDown.setToolTipText("Example: 17:53");

		plsONOFF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				lblActualProgram.setText("Manual");

				Config.controller.manualControl();

			}
		});

	}
	
	public MoreThanOneFrame getMoreThanOneFrame() {
		return moreThanOneFrame;
	}

	public static void main(String[] args) {
		ApplicationFrame a = new ApplicationFrame();

		a.setVisible(true);

	}

}
