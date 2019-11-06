package interfacegraphic.interfaceorganisateur;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donnee.Donnee;
import gestioncourse.*;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InCreationCourse extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBoxlistType;


	/**
	 * Create the frame.
	 */
	public InCreationCourse(Donnee d) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(84, 62, 46, 13);
		contentPane.add(lblNom);
		
		JLabel lblType = new JLabel("Type : ");
		lblType.setBounds(68, 130, 46, 13);
		contentPane.add(lblType);
		
		comboBoxlistType = new JComboBox();
		comboBoxlistType.setBounds(143, 126, 115, 21);
		contentPane.add(comboBoxlistType);
		
		textField = new JTextField();
		textField.setBounds(148, 59, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConfirmer = new JButton("confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=textField.getText();
				switch (getComboBoxlistType().getSelectedIndex()) {
				case 0:
					d.ajoutCourse(new CourseRallye(n));
					break;
				case 1:
					d.ajoutCourse(new CourseF1(n));
					break;
				}
				dispose();
			}
		});
		btnConfirmer.setBounds(127, 214, 85, 21);
		contentPane.add(btnConfirmer);
		
		init(d.getLstType());
		
	}

	public void init(ArrayList<String> lstType) {
		for(String s : lstType) {
			getComboBoxlistType().addItem(s);
		}
	}
	public JComboBox getComboBoxlistType() {
		return comboBoxlistType;
	}
}
