package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import java.util.ArrayList;
import java.util.List;

import enstabretagne.base.logger.Logger;
import enstabretagne.simulation.components.IEntity;
import enstabretagne.simulation.components.data.SimFeatures;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.Expertise.BorderAndPathGenerator;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Robot;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Wall.Wall;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;

public class EntityVisionGood extends EntityVision  {
	
	EntityVisionFeature VFeat;
	EntityVisionInit ini;

	public EntityVisionGood(String name, SimFeatures features) {
		super(name, features);
	}
	
	@Override
	protected void AfterActivate(IEntity sender, boolean starting) {
		Logger.Detail(this, "AfterActivate", "Activation EntityVision", "test");	
	}
	
	protected Point3D positionR(){
		Robot r = (Robot) getParent();
		
		return r.getPosition();
	}
	
	
	public List<Point3D> VisibleZone(){
		
		List<Point3D> zone =Util.AbsoluteZone( Util.rectifi(positionR()));
		List<Point3D> VisibleZone =new ArrayList<Point3D>();
		
		
		@SuppressWarnings("unchecked")
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> (simo instanceof Wall) && ((Wall) simo).getType() == 2);
		List<Bounds> bounds = new ArrayList<Bounds>();
		
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}
		for (Point3D p:zone){
			
			boolean isAcessible = BorderAndPathGenerator.intervisibilityBetween(p, Util.rectifi(positionR()),
					bounds);
			if (isAcessible){
				VisibleZone.add(p);
				
			}
			
		}
		
		
		return VisibleZone;
		
	}

	public List<Point3D> AcessibleZone(){
	
		List<Point3D> zone =Util.AbsoluteZone( Util.rectifi(positionR()));
		List<Point3D> AcessibleZone =new ArrayList<Point3D>();
		
		
		@SuppressWarnings("unchecked")
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> (simo instanceof Wall) && ((Wall) simo).getType() == 2|| ((Wall) simo).getType() == 3);
		List<Bounds> bounds = new ArrayList<Bounds>();
		
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}
		for (Point3D p:zone){
			
			boolean isAcessible = BorderAndPathGenerator.intervisibilityBetween(p, Util.rectifi(positionR()),
					bounds);
			if (isAcessible){
				AcessibleZone.add(p);
				
			}
			
		}
		
		
		return AcessibleZone;
	
	}
	
	
}
