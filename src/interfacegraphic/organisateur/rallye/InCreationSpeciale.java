package interfacegraphic.organisateur.rallye;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gestioncourse.Course;
import gestioncourse.CourseRallye;
import gestioncourse.Edition;
import gestioncourse.EditionRallye;
import gestioncourse.Etape;
import gestioncourse.EtapeRallye;
import gestioncourse.Speciale;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InCreationSpeciale extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField textFieldH;
	private JTextField textFieldM;
	private JTextField txtS;

	/**
	 * Create the frame.
	 * 
	 * @param c
	 * @param ed
	 * @param et
	 */
	public InCreationSpeciale(EtapeRallye et, Edition ed, Course c) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTempsLimite = new JLabel("Temps Limite :");
		labelTempsLimite.setBounds(43, 73, 76, 13);
		contentPane.add(labelTempsLimite);

		textFieldH = new JTextField();
		textFieldH.setBounds(118, 70, 31, 19);
		contentPane.add(textFieldH);
		textFieldH.setColumns(10);

		JLabel lblH = new JLabel("H");
		lblH.setBounds(159, 73, 31, 13);
		contentPane.add(lblH);

		textFieldM = new JTextField();
		textFieldM.setBounds(169, 70, 31, 19);
		contentPane.add(textFieldM);
		textFieldM.setColumns(10);

		JLabel labelM = new JLabel("'");
		labelM.setBounds(207, 73, 46, 13);
		contentPane.add(labelM);

		txtS = new JTextField();
		txtS.setBounds(217, 70, 46, 19);
		contentPane.add(txtS, BorderLayout.EAST);
		txtS.setColumns(10);

		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				et.ajouterSpeciale(
						new Speciale(Integer.valueOf(txtNum.getText()), Integer.valueOf(textFieldH.getText()),
								Integer.valueOf(textFieldM.getText()), Integer.valueOf(txtS.getText())));
				dispose();
			}
		});
		btnConfirmer.setBounds(127, 161, 85, 21);
		contentPane.add(btnConfirmer);

		txtNum = new JTextField();
		txtNum.setBounds(118, 24, 96, 19);
		contentPane.add(txtNum);
		txtNum.setColumns(10);

		JLabel lblNum = new JLabel("Num : ");
		lblNum.setBounds(43, 27, 46, 13);
		contentPane.add(lblNum);
	}

	public JTextField getTextFieldH() {
		return textFieldH;
	}

	public JTextField getTextFieldM() {
		return textFieldM;
	}

	public JTextField getTxtS() {
		return txtS;
	}
}
