package clientswing;
//by latest by 9/11/2018 

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

import common.AddI;
import common.AddO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import pojo.ServerList;
import pojo.Teacherreg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naruto
 */
public class TeacherMain extends javax.swing.JFrame implements ActionListener {

	Timer tr;
	Teacherreg user = null;
	private List<Object> subs;
	// int n;
	// ArrayList button = new ArrayList<string>();//this is for passing the object
	// in arratylist
	// ArrayList button;
	// add.ar
	// int k=5;
	/*
	 * ArrayList<Integer> arrli; JButton[] buttons;
	 */
	private AddI serverObj;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addpaper;
	private javax.swing.JButton addque;
	private javax.swing.JButton addta;
	private javax.swing.JButton genresult;
	private javax.swing.JButton logout;
	private java.awt.Panel panel1;
	private javax.swing.JLabel timer;
	private javax.swing.JLabel username;
	private javax.swing.JLabel welcome;
	// End of variables declaration//GEN-END:variables
	private JFrame child;

	/**
	 * Creates new form TeacherMain
	 * 
	 * @param user
	 * @param serverObj
	 * @param server2
	 * @param server1
	 * @throws RemoteException
	 */
	AddO server1, server2;

	public TeacherMain(Teacherreg user, AddI serverObj, AddO server1, AddO server2) throws RemoteException {
		this.user = user;
		this.serverObj = serverObj;
		this.server1 = server1;
		this.server2 = server2;

		/*
		 * this.arrli = new ArrayList<>(2); int size1 = arrli.size(); this.buttons = new
		 * JButton[size1];
		 * 
		 * 
		 * arrli.add(1); arrli.add(2); arrli.add(3);
		 */
		// this.button = new ArrayList<String>();
		
		
		boolean flag = true;

		// RMI CALL
		while (flag) {

			try {
				/// *****Add cone only here////
				subs = this.serverObj.getTeacherSubjects(user.getTid());
				System.out.println("making call");
				flag = false;

			} catch (Exception ee) {
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
		}
		if(subs==null) {
			JOptionPane.showMessageDialog(this,"No Subject Added by you during registration Register again.");
		}
		else {
		initComponents();
		  setTitle("WELCOME TO ONLINE QUIZ SYSTEM ");
		showTime();
		tr = new Timer(1000, this);
		tr.start();
		// panel2working();
		}
	}

	public void setChild(JFrame child) {
		this.child = child;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tr) {
			showTime();
		}

	}
	/*
	 * welcome.setText("Welcome,"); //label1 for welcome string
	 * jLabel2.setText("Available test for you:");
	 * if(e.getActionCommand().equals("myButton"))//here lable3 is student name {
	 * username.setText(studentname.getText()); }
	 * 
	 * String str = "string of student name  "; username.setText(str);
	 */

	public void setParentFrame(JFrame f) {
		JFrame parent = f;
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		// TODO add your handling code here:
		this.dispose();
	}// GEN-LAST:event_formWindowClosing

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panel1 = new java.awt.Panel();
		welcome = new javax.swing.JLabel();
		username = new javax.swing.JLabel();
		timer = new javax.swing.JLabel();
		logout = new javax.swing.JButton();
		addque = new javax.swing.JButton();
		addpaper = new javax.swing.JButton();
		addta = new javax.swing.JButton();
		genresult = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		welcome.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		welcome.setText("Username:");

		username.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		username.setText(user.getTname());

		timer.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
		timer.setText("timer");

		logout.setText("Logout");
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame f = new MainFrame(serverObj,server1,server2,true); f.setLocationRelativeTo(null);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				f.setExtendedState(MAXIMIZED_BOTH);
				dispose();
			}
		});
		javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
		panel1.setLayout(panel1Layout);
		panel1Layout.setHorizontalGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panel1Layout.createSequentialGroup().addComponent(welcome)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(username)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229,
												Short.MAX_VALUE)
										.addComponent(timer).addContainerGap())
								.addGroup(panel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
												javax.swing.GroupLayout.PREFERRED_SIZE)))));
		panel1Layout.setVerticalGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(welcome).addComponent(username).addComponent(timer))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						panel1Layout.createSequentialGroup().addContainerGap(56, Short.MAX_VALUE)
								.addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		welcome.getAccessibleContext().setAccessibleName("Welcome");

		addque.setText("Add Questions");
		addque.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addqueActionPerformed(evt);
			}
		});

		addpaper.setText("Add Paper");
		addpaper.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addpaperActionPerformed(evt);
			}
		});

		addta.setText("For Add T.A");
		addta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addtaActionPerformed(evt);
			}
		});

		genresult.setText("Generating result");
		genresult.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				genresultActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(addque, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(genresult, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addta, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(20, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addque, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addta, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(genresult, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void addqueActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addqueActionPerformed
		// TODO add your handling code here:
		Questionpanel f = new Questionpanel(subs, user, serverObj, server1, server2);
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setLocationRelativeTo(null);
		f.setParentFrame(this);
		f.setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_addqueActionPerformed

	private void addpaperActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addpaperActionPerformed
		Addpaperques f = new Addpaperques(subs, user, serverObj, server1, server2);
		f.setLocationRelativeTo(null);
		f.setParentFrame(this);
		f.setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_addpaperActionPerformed

	private void addtaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addtaActionPerformed

		Addta f = new Addta(subs, user, serverObj, server1, server1);
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setLocationRelativeTo(null);
		f.setParentFrame(this);
		f.setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_addtaActionPerformed

	private void genresultActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_genresultActionPerformed
		// genresult f = new genresult();
		
		
		boolean flag = true;

 		List result =null;
 		// RMI CALL
 		while (flag) {

 			try {
 				Integer tid = null;
 				Integer pid = null;
 				/// *****Add cone only here////
 				result = this.serverObj.getPaperforResult(user.getTid());
 				System.out.println("making call");
 				flag = false;

 			} catch (Exception ee) {
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
 		}
 		if(result==null) {
 			JOptionPane.showMessageDialog(this, "No paper in the list");
 		}
		
		TeacherExcel f = new TeacherExcel(result, user, serverObj, server1, server1);
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setLocationRelativeTo(null);
		f.setParentFrame(this);
		f.setVisible(true);
		this.setVisible(false);
	}// GEN-LAST:event_genresultActionPerformed

	void showTime() {
		Date d = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss a");
		String str = fmt.format(d);
		timer.setText(str);
	}
}
