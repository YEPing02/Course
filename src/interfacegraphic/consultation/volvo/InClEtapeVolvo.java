package interfacegraphic.consultation.volvo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestioncourse.Course;
import gestioncourse.CourseF1;
import gestioncourse.Edition;
import gestioncourse.EditionF1;
import gestioncourse.EditionVolvo;
import gestioncourse.Etape;
import gestioncourse.EtapeF1;
import gestioncourse.EtapeVolvo;
import gestioninscription.Inscription;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class InClEtapeVolvo extends JFrame {
	private JPanel contentPane;
	private JLabel lblEdition;
	private JLabel labelNum;
	private JList<String> listCl;
	private JComboBox<String> comboBoxEtape;
	private JLabel lblEtape;

	/**
	 * Create the frame.
	 * 
	 * @param ed
	 */
	public InClEtapeVolvo(EditionVolvo ed) {
		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(ed);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listCl = new JList<String>();

		listCl.setBounds(41, 101, 251, 280);
		contentPane.add(listCl);

		lblEdition = new JLabel("Edition : ");
		lblEdition.setBounds(41, 21, 68, 13);
		contentPane.add(lblEdition);

		labelNum = new JLabel("No.");
		labelNum.setBounds(119, 21, 46, 13);
		contentPane.add(labelNum);

		comboBoxEtape = new JComboBox<String>();
		comboBoxEtape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxEtape.getSelectedIndex() != -1) {
					EtapeVolvo etv = (EtapeVolvo) ed.getEtapeT(comboBoxEtape.getSelectedIndex());
					afficherClassement(etv);
				}

			}
		});
		comboBoxEtape.setBounds(83, 44, 209, 21);
		contentPane.add(comboBoxEtape);

		lblEtape = new JLabel("Etape : ");
		lblEtape.setBounds(41, 44, 46, 13);
		contentPane.add(lblEtape);

		init(ed);
	}

	private void init(EditionVolvo e) {
		comboBoxEtape.removeAllItems();
		for (int i = 0; i < e.getListeEtapeT().size(); i++) {
			EtapeVolvo etf = (EtapeVolvo) e.getListeEtapeT().get(i);
			comboBoxEtape.addItem(String.valueOf(etf.getNumEtapeT()));
		}
	}

	private void afficherClassement(EtapeVolvo et) {
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (String e : et.affichierClassementPoint()) {
			dlm.addElement(e);
		}
		listCl.setModel(dlm);
		// faut afficher les point
	}

}
