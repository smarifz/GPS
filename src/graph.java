import java.util.ArrayList;


public class graph
{
	ArrayList<vertex> vertex = new ArrayList<vertex>();
	ArrayList<edge> edge = new ArrayList<edge>();
	ArrayList<trip> trip = new ArrayList<trip>();
	int numOfLocations;
	int numOfRoadSegments;
	int numOfTrips;
	
	public graph()
	{
		
	}
	
	public void updateNumOfLocations(int numOfLocations)
	{
		this.numOfLocations = numOfLocations;
	}
	
	public void updateNumOfRoadSegments(int numOfRoadSegments)
	{
		this.numOfRoadSegments = numOfRoadSegments;
	}
	
	public void updateNumOfTrips(int numOfTrips)
	{
		this.numOfTrips = numOfTrips;
	}
	
	public void addToVertex(vertex v)
	{
		vertex.add(v);
	}
	
	public void addToEdge(edge e)
	{
		edge.add(e);
	}
	
	public void addToTrip(trip t)
	
	{
		trip.add(t);
	}
	
	public edge getEdge(vertex x, vertex y)
	
	{
		for (int i = 0; i < edge.size(); i++)
		{
			if (edge.get(i).startingPoint == x.index && edge.get(i).endingPoint == y.index)
			{
				return edge.get(i);
			}
				
		}
		return null;
	}
	
	public void updateGraph()
	{
		for (int i = 0; i < edge.size(); i++)
		{
			int edgeStart = edge.get(i).startingPoint;
			int edgeEnd = edge.get(i).endingPoint;
			vertex.get(edgeStart).addToVertexList(vertex.get(edgeEnd));
			
			
		}
	}

}
