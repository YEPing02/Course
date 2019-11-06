package interfacegraphic.interfaceorganisateur.F1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestioncourse.Course;
import gestioncourse.Edition;
import gestioncourse.EditionRallye;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InCreationEditionF1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldDf;
	private JLabel lblNum;
	private JTextField textFieldNum;
	/**
	 * Create the frame.
	 */
	public InCreationEditionF1(Course c) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Annee : ");
		lblNewLabel.setBounds(82, 53, 46, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date d\u00E9but : ");
		lblNewLabel_1.setBounds(82, 99, 46, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date fin : ");
		lblNewLabel_2.setBounds(82, 159, 46, 13);
		contentPane.add(lblNewLabel_2);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(138, 50, 96, 19);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);
		
		JTextField textFieldDd = new JTextField();
		textFieldDd.setBounds(138, 96, 96, 19);
		contentPane.add(textFieldDd);
		textFieldDd.setColumns(10);
		
		textFieldDf = new JTextField();
		textFieldDf.setBounds(138, 156, 96, 19);
		contentPane.add(textFieldDf);
		textFieldDf.setColumns(10);
		
		JButton btnConfirmer = new JButton("confirmer");
		
		//confirmer l'ajout
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.ajouterEditon(new EditionRallye(Integer.valueOf(textFieldNum.getText()), textFieldDd.getText(), textFieldDf.getText(), textFieldA.getText()));				
				dispose();
			}
		});
		btnConfirmer.setBounds(149, 213, 85, 21);
		contentPane.add(btnConfirmer);
		
		lblNum = new JLabel("Num : ");
		lblNum.setBounds(82, 30, 46, 13);
		contentPane.add(lblNum);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(138, 21, 96, 19);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
	}
}
