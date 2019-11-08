package interfacegraphic.organisateur.rallye;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestioncourse.Course;
import gestioncourse.CourseRallye;
import gestioncourse.Edition;
import gestioncourse.EditionRallye;
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

	public InCreationEtapeRallye(EditionRallye ed, CourseRallye c) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNum = new JLabel("Num : ");
		lblNum.setBounds(43, 31, 46, 13);
		contentPane.add(lblNum);

		JButton btnConfirmer = new JButton("Confirmer");

		// confirmer l'ajout
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtapeRallye etr = new EtapeRallye(Integer.valueOf(textFieldNum.getText()));
				ed.ajouterEtape(etr);
				dispose();
			}
		});

		btnConfirmer.setBounds(104, 124, 85, 21);
		contentPane.add(btnConfirmer);

		textFieldNum = new JTextField();
		textFieldNum.setBounds(118, 28, 96, 19);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);

	}

}
