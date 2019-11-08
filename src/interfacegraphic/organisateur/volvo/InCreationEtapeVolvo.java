package interfacegraphic.organisateur.volvo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestioncourse.Course;
import gestioncourse.CourseVolvo;
import gestioncourse.Edition;
import gestioncourse.EditionF1;
import gestioncourse.EditionVolvo;
import gestioncourse.Etape;
import gestioncourse.EtapeF1;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InCreationEtapeVolvo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNum;
	private JTextField textFieldH;
	private JTextField textFieldM;
	private JTextField txtS;

	public InCreationEtapeVolvo(EditionVolvo ed, CourseVolvo cv) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNum = new JLabel("Num : ");
		lblNum.setBounds(43, 31, 46, 13);
		contentPane.add(lblNum);

		JLabel labelTempsLimite = new JLabel("Temps Limite :");
		labelTempsLimite.setBounds(43, 73, 85, 13);
		contentPane.add(labelTempsLimite);

		JButton btnConfirmer = new JButton("Confirmer");

		// confirmer l'ajout
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ed.ajouterEtape(new EtapeF1(Integer.valueOf(textFieldNum.getText()),
						Integer.valueOf(textFieldH.getText()), Integer.valueOf(textFieldM.getText()),
						Float.valueOf(textFieldH.getText()), "test", "tes"));
				dispose();
			}
		});

		btnConfirmer.setBounds(118, 133, 85, 21);
		contentPane.add(btnConfirmer);

		textFieldNum = new JTextField();
		textFieldNum.setBounds(118, 28, 96, 19);
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
		textFieldM.setBounds(169, 70, 31, 19);
		contentPane.add(textFieldM);
		textFieldM.setColumns(10);

		JLabel labelM = new JLabel("'");
		labelM.setBounds(210, 73, 46, 13);
		contentPane.add(labelM);

		txtS = new JTextField();
		txtS.setBounds(220, 70, 60, 19);
		contentPane.add(txtS);
		txtS.setColumns(10);
	}

}
