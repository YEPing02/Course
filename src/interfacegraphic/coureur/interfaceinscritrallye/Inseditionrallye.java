package interfacegraphic.coureur.interfaceinscritrallye;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestioncourse.CourseRallye;
import gestioncourse.Edition;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Inseditionrallye extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldeditionchoisit;
	private JList listedition;
	private JButton btnContinuerSinscrire;
	private JLabel lblNomcourse;
	private JButton btnVoirVosConcurrents;
	private JButton btndelete;

	public Inseditionrallye(CourseRallye cr) {

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(cr);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVeuillezSlectionnerLe = new JLabel(
				"Veuillez s\u00E9lectionner l'Edition que vous souhaitez inscrire.");
		lblVeuillezSlectionnerLe.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblVeuillezSlectionnerLe.setBounds(54, 45, 315, 15);
		contentPane.add(lblVeuillezSlectionnerLe);

		listedition = new JList();
		listedition.setBounds(54, 70, 315, 89);
		contentPane.add(listedition);

		JLabel lblLeditionChoisite = new JLabel("L'Edition choisite");
		lblLeditionChoisite.setFont(new Font("ArialMT", Font.PLAIN, 12));
		lblLeditionChoisite.setBounds(54, 174, 108, 15);
		contentPane.add(lblLeditionChoisite);

		textFieldeditionchoisit = new JTextField();
		textFieldeditionchoisit.setBounds(155, 169, 191, 21);
		contentPane.add(textFieldeditionchoisit);
		textFieldeditionchoisit.setColumns(10);

		btnContinuerSinscrire = new JButton("Continuer \u00E0 s'inscrire ");
		btnContinuerSinscrire.setFont(new Font("Arial MT", Font.PLAIN, 12));
		btnContinuerSinscrire.setBounds(51, 199, 153, 23);
		contentPane.add(btnContinuerSinscrire);
		btnContinuerSinscrire.setEnabled(false);

		btnContinuerSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsCoueurVehi icv = new InsCoueurVehi();

				icv.setVisible(true);
			}
		});

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(54, 20, 54, 15);
		contentPane.add(lblCourse);

		lblNomcourse = new JLabel("----");
		lblNomcourse.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNomcourse.setBounds(106, 20, 191, 15);
		contentPane.add(lblNomcourse);

		btnVoirVosConcurrents = new JButton("Voir vos concurrents");
		btnVoirVosConcurrents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insvoirConcurrents ivc = new insvoirConcurrents();

				ivc.setVisible(true);

			}
		});
		btnVoirVosConcurrents.setFont(new Font("Arial MT", Font.PLAIN, 12));
		btnVoirVosConcurrents.setBounds(214, 199, 155, 23);
		contentPane.add(btnVoirVosConcurrents);
		btnVoirVosConcurrents.setEnabled(false);

		btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insdeletecoureur idc = new insdeletecoureur();

				idc.setVisible(true);

			}
		});
		btndelete.setEnabled(false);

		btndelete.setFont(new Font("Arial MT", Font.PLAIN, 12));
		btndelete.setBounds(383, 199, 93, 23);
		contentPane.add(btndelete);
		// init(cr);

		listedition.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (listedition.getSelectedIndex() != -1) {
					btnContinuerSinscrire.setEnabled(true);
					btnVoirVosConcurrents.setEnabled(true);
					btndelete.setEnabled(true);

					afficherEditionSelected(cr.getEdition(listedition.getSelectedIndex()));
				} else {
					btnContinuerSinscrire.setEnabled(false);

				}
			}

		});

	}

	private void init(CourseRallye c) {

		lblNomcourse.setText(c.getNomCourse());
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (Edition ed : c.getListeEdition()) {
			dlm.addElement("Edition " + ed.getNumEdition() + " " + ed.getAnnee());
		}
		listedition.setModel(dlm);
	}

	private void afficherEditionSelected(Edition ed) {
		textFieldeditionchoisit.setText(ed.getAnnee());

	}
}
