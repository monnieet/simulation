package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance;

import enstabretagne.monitor.implementation.FX3DMonitor2;
import enstabretagne.monitor.implementation.UniversalMonitor;

public class MainMouvementCollisionAvoidance {
	
	public static void main(String[] args) {
		boolean AFAP = false;

		if (AFAP) {
			UniversalMonitor um = new UniversalMonitor();
			um.loadExperiencePlanFromSettings();
			um.runPlan();
			um.exit();
		} else
			System.out.println("nique !!");
			FX3DMonitor2.launch(FX3DMonitor2.class, args);
		;
		
	}
	

}
