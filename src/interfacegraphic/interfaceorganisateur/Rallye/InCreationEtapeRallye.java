package interfacegraphic.interfaceorganisateur.Rallye;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestioncourse.Course;
import gestioncourse.Edition;
import gestioncourse.Etape;
import gestioncourse.EtapeRallye;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InCreationEtapeRallye extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNum;
	private JTextField textFieldH;
	private JTextField textFieldM;
	private JTextField txtS;
	
	
	
	public InCreationEtapeRallye(Edition ed, Course c) {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNum = new JLabel("Num : ");
		lblNum.setBounds(43, 31, 46, 13);
		contentPane.add(lblNum);
		
		JLabel labelTempsLimite = new JLabel("Temps Limite :");
		labelTempsLimite.setBounds(43, 73, 46, 13);
		contentPane.add(labelTempsLimite);
		
		JButton btnConfirmer = new JButton("Confirmer");
	
		//confirmer l'ajout
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ed.ajouterEtape(new EtapeRallye(Integer.valueOf(textFieldNum.getText()),Integer.valueOf(textFieldH.getText()), Integer.valueOf(textFieldM.getText()), Float.valueOf(textFieldH.getText())));			
				dispose();
			}
		});
		
		btnConfirmer.setBounds(129, 194, 85, 21);
		contentPane.add(btnConfirmer);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(92, 28, 96, 19);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
		
		textFieldH = new JTextField();
		textFieldH.setBounds(118, 70, 31, 19);
		contentPane.add(textFieldH);
		textFieldH.setColumns(10);
		
		JLabel lblH = new JLabel("H");
		lblH.setBounds(159, 73, 31, 13);
		contentPane.add(lblH);
		
		textFieldM = new JTextField();
		textFieldM.setBounds(184, 70, 46, 19);
		contentPane.add(textFieldM);
		textFieldM.setColumns(10);
		
		JLabel labelM = new JLabel("'");
		labelM.setBounds(253, 73, 46, 13);
		contentPane.add(labelM);
		
		txtS = new JTextField();
		txtS.setBounds(263, 70, 85, 19);
		contentPane.add(txtS);
		txtS.setColumns(10);
	}


}
