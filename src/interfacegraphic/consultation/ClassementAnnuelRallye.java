package interfacegraphic.consultation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donnee.Donnee;
import gestioncourse.Annee;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ClassementAnnuelRallye extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JTextPane textPane;

	/**
	 * Create the frame.
	 */
	public ClassementAnnuelRallye(Donnee d) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblAnne = new JLabel("Ann\u00E9e : ");
		lblAnne.setBounds(70, 46, 46, 13);
		contentPane.add(lblAnne);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					Annee a = d.getAnnee(comboBox.getSelectedIndex());
					textPane.setText(a.afficheClassementAnnuelCoureur());
				}
			}

		});
		comboBox.setBounds(132, 42, 133, 21);
		contentPane.add(comboBox);

		textPane = new JTextPane();
		textPane.setBounds(70, 104, 309, 305);
		contentPane.add(textPane);
		init(d);

	}

	private void init(Donnee d) {
		// initialiser la liste des course
		for (Annee annee : d.getLstAnnee()) {
			comboBox.addItem(String.valueOf(annee.getAnnee()));
		}

	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public JTextPane getTextPane() {
		return textPane;
	}
}
