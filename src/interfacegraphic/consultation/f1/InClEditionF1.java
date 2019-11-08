package interfacegraphic.consultation.f1;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gestioncourse.CourseF1;
import gestioncourse.Edition;
import gestioncourse.EditionF1;
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

public class InClEditionF1 extends JFrame {

	private JPanel contentPane;
	private JList<String> listCl;
	private JComboBox<String> comboBox;
	private JLabel lblEdition;
	private JButton btnContinuer;

	/**
	 * Create the frame.
	 */
	public InClEditionF1(CourseF1 cf) {

		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(cf);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listCl = new JList<String>();

		// afficher info quand choisir

		listCl.setBounds(73, 83, 305, 286);
		contentPane.add(listCl);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					afficherClessement(cf.getEdition(comboBox.getSelectedIndex()));
				}
			}
		});
		comboBox.setBounds(97, 27, 169, 21);
		contentPane.add(comboBox);

		lblEdition = new JLabel("Edition : ");
		lblEdition.setBounds(41, 31, 46, 13);
		contentPane.add(lblEdition);

		btnContinuer = new JButton("Classement Etape");
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					EditionF1 etf = cf.getEdition(comboBox.getSelectedIndex());
					InClEtapeF1 inetf = new InClEtapeF1(etf);
					inetf.setVisible(true);
				}

			}
		});
		btnContinuer.setBounds(282, 27, 143, 21);
		contentPane.add(btnContinuer);
		init(cf);
	}

	private void init(CourseF1 c) {

		comboBox.removeAllItems();
		for (Edition ed : c.getListeEdition()) {
			EditionF1 edf = (EditionF1) ed;
			comboBox.addItem(edf.getAnnee());
		}
	}

	private void afficherClessement(EditionF1 ed) {
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (HashMap.Entry<Inscription, Integer> e : ed.getClassementGeneral()) {
			dlm.addElement(e.getKey().getCoureur().getNomCoureur() + "  " + e.getValue());
		}
		listCl.setModel(dlm);
	}

}
