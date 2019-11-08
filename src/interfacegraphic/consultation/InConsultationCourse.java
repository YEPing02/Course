package interfacegraphic.consultation;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import donnee.Donnee;
import gestioncourse.Course;
import gestioncourse.CourseF1;
import gestioncourse.CourseRallye;
import gestioncourse.CourseVolvo;
import interfacegraphic.consultation.f1.*;
import interfacegraphic.consultation.rallye.InClEditionRallye;
import interfacegraphic.consultation.volvo.InClEditionVolvo;
import interfacegraphic.organisateur.rallye.InEditionRallye;

import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

public class InConsultationCourse extends JFrame {
	private JPanel panel;
	private JList<String> listCourse;
	private JLabel lblListeDesCourses;
	private JButton btnClassementAnnuelDe;

	public InConsultationCourse(Donnee d) {

		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(d.getLstCourse());
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 456);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		// passe à edition
		JButton btnContinuer = new JButton("Consulter");
		btnContinuer.setEnabled(false);
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (d.getCourse(listCourse.getSelectedIndex()).getClass().getSimpleName()) {
				case "CourseRallye":
					System.out.println(1);
					CourseRallye cr = (CourseRallye) d.getCourse(listCourse.getSelectedIndex());
					InClEditionRallye ieR = new InClEditionRallye(cr);
					ieR.setVisible(true);
					break;
				case "CourseF1":
					CourseF1 cf = (CourseF1) d.getCourse(listCourse.getSelectedIndex());
					InClEditionF1 icledf = new InClEditionF1(cf);
					icledf.setVisible(true);
					break;
				case "CourseVolvo":
					CourseVolvo cv = (CourseVolvo) d.getCourse(listCourse.getSelectedIndex());
					InClEditionVolvo icledv = new InClEditionVolvo(cv);
					icledv.setVisible(true);
					break;
				}

			}
		});
		btnContinuer.setBounds(136, 344, 85, 21);
		panel.add(btnContinuer);
		listCourse = new JList();

		listCourse.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listCourse.getSelectedIndex() != -1) {
					btnContinuer.setEnabled(true);
				} else {
					btnContinuer.setEnabled(false);
				}
			}
		});
		listCourse.setBounds(70, 70, 212, 264);
		panel.add(listCourse);

		lblListeDesCourses = new JLabel("Liste des Courses : ");
		lblListeDesCourses.setBounds(70, 47, 119, 13);
		panel.add(lblListeDesCourses);

		btnClassementAnnuelDe = new JButton("Classement Annuel de Rallye");
		btnClassementAnnuelDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassementAnnuelRallye cla = new ClassementAnnuelRallye(d);
				cla.setVisible(true);
			}
		});
		btnClassementAnnuelDe.setBounds(70, 16, 212, 21);
		panel.add(btnClassementAnnuelDe);

		init(d.getLstCourse());
	}

	public void init(ArrayList<Course> lstC) {
		// initialiser la liste des course
		DefaultListModel<String> dlm = new DefaultListModel<String>();// modèle qui va être affiché dans la liste
		for (Course c : lstC) {
			dlm.addElement(c.getNomCourse());
		}
		listCourse.setModel(dlm);

	}

}
