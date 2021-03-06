package clientExamSwing;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import clientswing.MainFrame;
import common.AddI;
import common.AddO;
import pojo.Question;
import pojo.ServerList;
import pojo.Studentreg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naruto
 */
public class Condexmmulans extends javax.swing.JFrame implements ActionListener {

	private long time = 0;
	private Timer tr;
	// int duration;
	private AddI serverObj;
	private AddO server1;
	private AddO server2;
	private Studentreg user;
	private List<Object> questionList;
	private Question ques;
	private int questionNo;
	List<String> options;
	String questiontext;
	Integer paperId;
	private Integer subId;

	public Condexmmulans(long duration, Studentreg user, AddI serverObj, AddO server1, AddO server2, int questionNo,
			ArrayList<Object> questionList, Integer paperId, Integer subId) {
		this.user = (Studentreg) user;
		this.questionList = questionList;
		this.ques = (Question) this.questionList.get(questionNo - 1);
		this.serverObj = serverObj;
		this.server1 = server1;
		this.server2 = server2;
		this.questionNo = questionNo;
		this.paperId = paperId;
		this.subId = subId;
		System.out.println("quid" + questionNo);
		System.out.println(duration);
		this.questiontext = this.ques.getQquestion();
		this.time = duration;
		initComponents();
		   setTitle("WELCOME TO ONLINE QUIZ SYSTEM ");
		tr = new Timer(1000, this);
	}

	public void setParentFrame(JFrame f) {
		parent = f;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
	
		finish = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		question = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		next = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		timeleft = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		userlb = new javax.swing.JLabel();
		queno1 = new javax.swing.JLabel();
		cboption1 = new javax.swing.JCheckBox();
		cboption2 = new javax.swing.JCheckBox();
		cboption3 = new javax.swing.JCheckBox();
		cboption4 = new javax.swing.JCheckBox();
		questionno = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}

			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		finish.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		finish.setText("FINISH");
		finish.setEnabled(false);
		finish.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				finishActionPerformed(evt);
			}
		});

		this.options = Arrays.asList((ques.getQoption()).split("\\s*~\\s*"));

		jLabel6.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		jLabel6.setText("Option1:");

		jLabel7.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		jLabel7.setText("Option2:");

		jLabel8.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		jLabel8.setText("Option3:");

		jLabel9.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		jLabel9.setText("Option4:" );

		question.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		question.setText("Question:" );

		jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jTextArea1.setText(this.questiontext);
		jTextArea1.setEditable(false);
		jScrollPane1.setViewportView(jTextArea1);

		next.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		next.setText("NEXT");
		next.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextActionPerformed(evt);
			}
		});

		timeleft.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		timeleft.setText("timeleft");

		jLabel4.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
		jLabel4.setText("Quiz:" + this.paperId);

		jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		jLabel2.setText("Username:");

		userlb.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		userlb.setText(this.user.getSname());

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap().addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(userlb)
						.addGap(187, 187, 187).addComponent(jLabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
						.addComponent(timeleft).addGap(19, 19, 19)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4).addComponent(timeleft))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2).addComponent(userlb))
												.addContainerGap()))));

		queno1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		queno1.setText("Questionnumber:");

		cboption1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		cboption1.setText( options.get(0));

		cboption2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		cboption2.setText( options.get(0));

		cboption3.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		cboption3.setText( options.get(0));

		cboption4.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		cboption4.setText(options.get(0));

		questionno.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		questionno.setText(Integer.toString(this.questionNo));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(queno1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												questionno, javax.swing.GroupLayout.PREFERRED_SIZE, 74,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addComponent(jLabel6)
														.addGap(23, 23, 23).addComponent(cboption1))
												.addGroup(layout.createSequentialGroup().addGap(85, 85, 85)
														.addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(finish))))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(question)
								.addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										525, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(19, 19, 19))
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel7).addComponent(jLabel8).addComponent(jLabel9))
								.addGap(23, 23, 23)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
										.addComponent(cboption2).addComponent(cboption3).addComponent(cboption4))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(queno1, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(questionno))
						.addGap(27, 27, 27)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(question))
						.addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(cboption1))
						.addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(cboption2))
						.addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8).addComponent(cboption3))
						.addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(cboption4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(next).addComponent(finish))
						.addGap(45, 45, 45)));
		if (this.questionList.size() == questionNo) {
		//	JOptionPane.showMessageDialog(this, "IN last question");
			finish.setEnabled(true);
			next.setEnabled(false);
		}

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		// TODO add your handling code here:
		// parent.setVisible(true);
		this.dispose();
	}// GEN-LAST:event_formWindowClosing

	private void nextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nextActionPerformed
		String solution = "";
		
		if (cboption1.isSelected())
			solution += "1~";// this is for save option
		if (cboption2.isSelected())
			solution += "2~";
		if (cboption3.isSelected())
			solution += "3~";
		if (cboption4.isSelected())
			solution += "4~";
		if (solution.length() == 0) {
			solution = "NOTATTEMPTED";
		}
		Integer result = 0;
		boolean flag = true;
		while (flag) {

			try {
				/// *****Add code only here////

				result = this.serverObj.submitQuestion((Integer) this.user.getSid(), this.questionNo, solution, this.paperId,
						this.subId);

				System.out.println("making submit question");
				flag = false;

			} catch (Exception e) {
				System.out.println("will get new serverobject and the recall the function again");
				ServerList serving = null;
				try {
					System.out.println("Calling server");
					serving = server1.giveServer();
					System.out.println("After call server");

				} catch (Exception ex) {
					System.err.println("Server1 failed to give server calling server2");
					try {
						serving = server2.giveServer();
					} catch (Exception ex2) {
						JOptionPane.showMessageDialog(this,"No server to serve at this moment try again Later");
						System.err.println("NO SERVER TO SERVE");
						// TODO ADD OPOP
						System.exit(1);
					}
				}
				//
				System.out.println("Getting new server obj");
				this.serverObj = null;

				try {
					Registry registrymain = LocateRegistry.getRegistry(serving.getMainIP(), serving.getMainPORT());
					this.serverObj = (AddI) registrymain.lookup(serving.getMainOBJ());
				} catch (Exception exxs) {
					// TODO: handle exception
				}
			}
		} // }
		if (result == -1) {
			JOptionPane.showMessageDialog(this, "Some Poblem with DB");
		} else {
			long duration = time;
			int frametype = ((Question) questionList.get(this.questionNo)).getQtype();
			
			Integer paperId = this.paperId;
			Integer subId = this.subId;
			this.questionNo++;
			System.out.println(this.questionNo);
			if (frametype == 1) {
				Condexmmultype f = new Condexmmultype(duration, user, serverObj, server1, server2, this.questionNo,
						(ArrayList<Object>) questionList, paperId, subId);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				f.setParentFrame(parent);
				f.setExtendedState(Frame.MAXIMIZED_BOTH);
			//	this.setVisible(false);
				this.dispose();
			} else if (frametype == 2) {
				Condexmmulans f = new Condexmmulans(duration, user, serverObj, server1, server2, this.questionNo,
						(ArrayList<Object>) questionList, paperId, subId);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				f.setParentFrame(parent);
				 f.setExtendedState(Frame.MAXIMIZED_BOTH);
			//	this.setVisible(false);
				this.dispose();
			} else if (frametype == 3) {
				Condexmsub f = new Condexmsub(duration, user, serverObj, server1, server2, this.questionNo,
						(ArrayList<Object>) questionList, paperId, subId);
				f.setLocationRelativeTo(null);
				f.setParentFrame(parent);
				f.setVisible(true);
				f.setExtendedState(Frame.MAXIMIZED_BOTH);
			//	this.setVisible(false);
				this.dispose();
			}
		}

	}// GEN-LAST:event_nextActionPerformed

	private void finishActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_finishActionPerformed
		System.out.println("Finsih");

		String solution = "";
		
		if (cboption1.isSelected())
			solution += "1~";// this is for save option
		if (cboption2.isSelected())
			solution += "2~";
		if (cboption3.isSelected())
			solution += "3~";
		if (cboption4.isSelected())
			solution += "4~";
		if (solution.length() == 0) {
			solution = "NOTATTEMPTED";
		}
		Integer result = 0;
		boolean flag = true;
		while (flag) {

			try {
				/// *****Add code only here////

				result = this.serverObj.submitQuestion((Integer) this.user.getSid(), -1, solution, this.paperId, this.subId);

				System.out.println("making submit question");
				flag = false;

			} catch (Exception e) {
				System.out.println("will get new serverobject and the recall the function again");
				ServerList serving = null;
				try {
					System.out.println("Calling server");
					serving = server1.giveServer();
					System.out.println("After call server");

				} catch (Exception ex) {
					System.err.println("Server1 failed to give server calling server2");
					try {
						serving = server2.giveServer();
					} catch (Exception ex2) {
						// TODO EXIT POPUP
						JOptionPane.showMessageDialog(this,"No server to serve at this moment try again Later");
						System.err.println("NO SERVER TO SERVE");
						// TODO ADD OPOP
						System.exit(1);
					}
				}
				//
				System.out.println("Getting new server obj");
				this.serverObj = null;

				try {
					Registry registrymain = LocateRegistry.getRegistry(serving.getMainIP(), serving.getMainPORT());
					this.serverObj = (AddI) registrymain.lookup(serving.getMainOBJ());
				} catch (Exception exxs) {
					// TODO: handle exception
				}
			}
		} // }
		if (result == -1) {
			JOptionPane.showMessageDialog(this, "Some Poblem with DB");
		} else {
			JOptionPane.showMessageDialog(this, "Goto Home");
			MainFrame f = new MainFrame(serverObj,server1,server2,true); f.setLocationRelativeTo(null);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			f.setExtendedState(MAXIMIZED_BOTH);
			dispose();
		}

		// TODO add your handling code here:
	}// GEN-LAST:event_finishActionPerformed

	private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
		// jLabel1.setText("Duration : " + duration + " Minutes");
		tr.start();
		updateLabel();
	}// GEN-LAST:event_formWindowOpened

	private void updateLabel() {
		timeleft.setText("Time Remaining : " + time / 60 + " Minutes " + time % 60 + " Seconds");
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JCheckBox cboption1;
	private javax.swing.JCheckBox cboption2;
	private javax.swing.JCheckBox cboption3;
	private javax.swing.JCheckBox cboption4;
	private javax.swing.JButton finish;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JButton next;
	private javax.swing.JLabel queno1;
	private javax.swing.JLabel question;
	private javax.swing.JLabel questionno;
	private javax.swing.JLabel timeleft;
	private javax.swing.JLabel userlb;
	// End of variables declaration//GEN-END:variables
	private JFrame parent;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (time >= 1) {
			time--;
		}
		updateLabel();
		if (time == 0) {
			tr.stop();

			System.out.println("Finsih");

			String solution = "";
			
			if (cboption1.isSelected())
				solution += "1~";// this is for save option
			if (cboption2.isSelected())
				solution += "2~";
			if (cboption3.isSelected())
				solution += "3~";
			if (cboption4.isSelected())
				solution += "4~";
			if (solution.length() == 0) {
				solution = "NOTATTEMPTED";
			}
			Integer result = 0;
			boolean flag = true;
			while (flag) {

				try {
					/// *****Add code only here////

					result = this.serverObj.submitQuestion((Integer) this.user.getSid(), -2, solution, this.paperId,
							this.subId);

					System.out.println("making submit question");
					flag = false;

				} catch (Exception ex) {
					System.out.println("will get new serverobject and the recall the function again");
					ServerList serving = null;
					try {
						System.out.println("Calling server");
						serving = server1.giveServer();
						System.out.println("After call server");

					} catch (Exception exx) {
						System.err.println("Server1 failed to give server calling server2");
						try {
							serving = server2.giveServer();
						} catch (Exception ex2) {
							// TODO EXIT POPUP
							JOptionPane.showMessageDialog(this,"No server to serve at this moment try again Later");
							System.err.println("NO SERVER TO SERVE");
							// TODO ADD OPOP
							System.exit(1);
						}
					}
					//
					System.out.println("Getting new server obj");
					this.serverObj = null;

					try {
						Registry registrymain = LocateRegistry.getRegistry(serving.getMainIP(), serving.getMainPORT());
						this.serverObj = (AddI) registrymain.lookup(serving.getMainOBJ());
					} catch (Exception exxs) {
						// TODO: handle exception
					}
				}
			}
			if (result == -1) {
				JOptionPane.showMessageDialog(this, "Some Poblem with DB");
			} else {

				JOptionPane.showMessageDialog(this, "Goto Home");
				MainFrame f = new MainFrame(serverObj,server1,server2,true); f.setLocationRelativeTo(null);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				f.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}

		}

	}

}