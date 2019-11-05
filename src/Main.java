import java.awt.EventQueue;

import donnee.Donnee;
import interfacegraphic.interfaceorganisateur.*;

public class Main {
	public static void main(String[] arg) {
		Donnee d= new Donnee();
		InCourse ic= new InCourse(d);
		ic.setVisible(true);
			
	}
}
