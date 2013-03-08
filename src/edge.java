
public class edge {
	
	int startingPoint;
	int endingPoint;
	double distance;
	double trafficSpeed;
	
	public edge()
	{
		
	}

	public void updateEdge(int startingPoint, int endingPoint, double distance, double trafficSpeed)
	{
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.distance = distance;
		this.trafficSpeed = trafficSpeed;
	}
	
	public double calcTime()
	{
		return distance/trafficSpeed;
	}
}
