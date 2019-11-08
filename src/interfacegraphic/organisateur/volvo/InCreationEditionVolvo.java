package interfacegraphic.organisateur.volvo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestioncourse.CourseVolvo;
import gestioncourse.EditionVolvo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InCreationEditionVolvo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldDf;
	private JLabel lblNum;
	private JTextField textFieldNum;

	/**
	 * Create the frame.
	 */
	public InCreationEditionVolvo(CourseVolvo cv) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Annee : ");
		lblNewLabel.setBounds(82, 53, 46, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Date d\u00E9but : ");
		lblNewLabel_1.setBounds(82, 76, 67, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date fin : ");
		lblNewLabel_2.setBounds(82, 99, 46, 13);
		contentPane.add(lblNewLabel_2);

		textFieldA = new JTextField();
		textFieldA.setBounds(150, 50, 96, 19);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);

		JTextField textFieldDd = new JTextField();
		textFieldDd.setBounds(150, 73, 96, 19);
		contentPane.add(textFieldDd);
		textFieldDd.setColumns(10);

		textFieldDf = new JTextField();
		textFieldDf.setBounds(150, 99, 96, 19);
		contentPane.add(textFieldDf);
		textFieldDf.setColumns(10);

		JButton btnConfirmer = new JButton("confirmer");

		// confirmer l'ajout
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cv.ajouterEditon(new EditionVolvo(Integer.valueOf(textFieldNum.getText()), textFieldDd.getText(),
						textFieldDf.getText(), textFieldA.getText()));
				dispose();
			}
		});
		btnConfirmer.setBounds(117, 172, 85, 21);
		contentPane.add(btnConfirmer);

		lblNum = new JLabel("Num : ");
		lblNum.setBounds(82, 30, 46, 13);
		contentPane.add(lblNum);

		textFieldNum = new JTextField();
		textFieldNum.setBounds(150, 27, 96, 19);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
	}
}
