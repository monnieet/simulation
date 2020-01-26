package de.vogella.algorithms.dijkstra.model.jfxmodel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;
import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.IEdge;
import de.vogella.algorithms.dijkstra.model.IVertex;
import de.vogella.algorithms.dijkstra.model.Vertex;
import de.vogella.algorithms.dijkstra.model.jfxmodel.Point3DEdge;
import de.vogella.algorithms.dijkstra.model.jfxmodel.Point3DVertex;
import javafx.geometry.Point3D;


public class DijkstraGraph {

  private List<IVertex> nodes;
  private List<IEdge> edges;
  private Graph graph;
  
  private void set_graph(){
	  graph = new Graph(nodes, edges);
  }
  
  private Graph get_graph(){
	  
	  return graph;
  }
  
  public DijkstraGraph(Point3D p) {
	  nodes = new ArrayList<IVertex>();
	  edges = new ArrayList<IEdge>();
	  nodes.add(new Point3DVertex(p));
	  
	  
		
	}
  
  private void addLane(Point3DVertex s,Point3DVertex t) {
	  	if(!nodes.contains(s)) nodes.add(s);
	  	if(!nodes.contains(t)) nodes.add(t);

	  	Point3DEdge e1 = new Point3DEdge(s,t); 
	  	Point3DEdge e2 = new Point3DEdge(t,s); 
	  	
	    edges.add(e1);
	    edges.add(e2);

  }
  
  public void addMultipleLane(Point3DVertex source,List<Point3DVertex> t){
	  
	  for (Point3DVertex a : t){
		  addLane(source,a);
	  }
	  
	  
  }
  
  
  public  LinkedList<IVertex> shorterPath(Point3DVertex source, Point3DVertex arrival) {
    	

    // Lets check from location Loc_1 to Loc_10
    Graph graph = new Graph(nodes, edges);
    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
    dijkstra.execute(source);
    LinkedList<IVertex> path =  dijkstra.getPath(arrival);
        
    for (IVertex vertex : path) {
      System.out.println(vertex);
    }
    
    return path;
    
  }

  
}

