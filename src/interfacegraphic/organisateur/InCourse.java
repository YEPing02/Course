package interfacegraphic.organisateur;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import donnee.Donnee;
import gestioncourse.Course;
import gestioncourse.CourseF1;
import gestioncourse.CourseRallye;
import gestioncourse.CourseVolvo;
import interfacegraphic.organisateur.f1.InEditionF1;
import interfacegraphic.organisateur.rallye.InEditionRallye;
import interfacegraphic.organisateur.volvo.InEditionVolvo;

import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
public class InCourse extends JFrame {
	private JPanel panel;
	private JTextField textFieldNom;
	private JList<String> listCourse;
	private JLabel lblTypeaffi;
	
	
	public InCourse(Donnee d) {
		
		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(d.getLstCourse());
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 419);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(213, 56, 46, 13);
		panel.add(lblNom);
		
		
		// passe à edition
		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.setEnabled(false);
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch (d.getCourse(listCourse.getSelectedIndex()).getClass().getSimpleName()) {
					case "CourseRallye": 
						System.out.println(1);
						CourseRallye cr=(CourseRallye) d.getCourse(listCourse.getSelectedIndex());
						InEditionRallye ieR = new InEditionRallye(cr);
						ieR.setVisible(true);
						break;
					case "CourseF1": 
						System.out.println(2);
						CourseF1 cf=(CourseF1) d.getCourse(listCourse.getSelectedIndex());
						InEditionF1 ieF = new InEditionF1(cf);
						ieF.setVisible(true);
						break;
					case "CourseVolvo": 
						System.out.println(2);
						CourseVolvo cv=(CourseVolvo) d.getCourse(listCourse.getSelectedIndex());
						InEditionVolvo iev = new InEditionVolvo(cv);
						iev.setVisible(true);
						break;
				}
				
				
			}
		});
		btnContinuer.setBounds(131, 332, 85, 21);
		panel.add(btnContinuer);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(269, 53, 140, 19);
		panel.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(listCourse.getSelectedIndex()!=-1) {
				d.getCourse(listCourse.getSelectedIndex()).setNomCourse(textFieldNom.getText());
				init(d.getLstCourse());
				}
			}
		});
		btnModifier.setBounds(259, 177, 85, 21);
		panel.add(btnModifier);
		
		JButton btnAjouter = new JButton("ajouter");
		
		
		
		// ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				InCreationCourse icc=new InCreationCourse(d);
				icc.setVisible(true);
			}
		});
		
		
		

		btnAjouter.setBounds(36, 332, 85, 21);
		panel.add(btnAjouter);
		
		JLabel lblType = new JLabel("Type : ");
		lblType.setBounds(213, 96, 46, 13);
		panel.add(lblType);
		
		lblTypeaffi = new JLabel("type");
		lblTypeaffi.setBounds(269, 96, 117, 13);
		panel.add(lblTypeaffi);
		listCourse = new JList();
		
		
		//afficher info quand choisir
		listCourse.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(listCourse.getSelectedIndex()!=-1) {
					btnModifier.setEnabled(true);
					btnContinuer.setEnabled(true);
					afficherCourseSelected(d.getCourse(listCourse.getSelectedIndex()));
				}
				else{
					btnModifier.setEnabled(false);
					btnContinuer.setEnabled(false);
				}
			}
		});
		listCourse.setBounds(36, 45, 167, 264);
		panel.add(listCourse);	
		
		init(d.getLstCourse());
	}
	

	
	public void init(ArrayList<Course> lstC) {
		// initialiser la liste des course
		DefaultListModel<String> dlm = new DefaultListModel<String>();// modèle qui va être affiché dans la liste
		for(Course c : lstC) {
			dlm.addElement(c.getNomCourse());		
		}
		listCourse.setModel(dlm);
		

	}
	
	private void afficherCourseSelected(Course c) {
		textFieldNom.setText(c.getNomCourse());
		lblTypeaffi.setText(c.getClass().getSimpleName());
	}
	
}


