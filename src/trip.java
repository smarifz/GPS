
public class trip {
	
	int startingPoint;
	int endingPoint;
	String typeOfTrip;
	
	public trip()
	{
		
	}
	
	public void updateTrip(int startingPoint, int endingPoint, String typeOfTrip)
	{
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.typeOfTrip = typeOfTrip;
	}
	
	public boolean isD()
	{
		if (typeOfTrip.equals("D"))
			return true;
		else return false;
			
	}		


}
