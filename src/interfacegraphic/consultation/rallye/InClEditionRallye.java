package interfacegraphic.consultation.rallye;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gestioncourse.CourseRallye;
import gestioncourse.Edition;
import gestioncourse.EditionRallye;
import gestioninscription.Inscription;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InClEditionRallye extends JFrame {

	private JPanel contentPane;
	private JList<String> listCl;
	private JComboBox<String> comboBox;
	private JLabel lblEdition;
	private JButton btnContinuer;

	/**
	 * Create the frame.
	 */
	public InClEditionRallye(CourseRallye cr) {

		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(cr);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listCl = new JList<String>();
		// afficher info quand choisir
		listCl.setBounds(66, 86, 329, 286);
		contentPane.add(listCl);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					afficherClessement(cr.getEdition(comboBox.getSelectedIndex()));
				}
			}
		});
		comboBox.setBounds(109, 27, 169, 21);
		contentPane.add(comboBox);

		lblEdition = new JLabel("Edition : ");
		lblEdition.setBounds(53, 31, 46, 13);
		contentPane.add(lblEdition);
		btnContinuer = new JButton("Classement Etape");
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					EditionRallye etf = cr.getEdition(comboBox.getSelectedIndex());
					InClEtapeRallye inetf = new InClEtapeRallye(etf);
					inetf.setVisible(true);
				}
			}
		});
		btnContinuer.setBounds(288, 27, 143, 21);
		contentPane.add(btnContinuer);
		init(cr);
	}

	private void init(CourseRallye c) {

		comboBox.removeAllItems();
		for (Edition ed : c.getListeEdition()) {
			EditionRallye edf = (EditionRallye) ed;
			comboBox.addItem(edf.getAnnee());
		}
	}

	private void afficherClessement(EditionRallye ed) {
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (HashMap.Entry<Inscription, Integer> e : ed.getClassementGeneral()) {
			dlm.addElement(e.getKey().getCoureur().getNomCoureur() + "  " + e.getValue());
		}
		listCl.setModel(dlm);
	}

}
