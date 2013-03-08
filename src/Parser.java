import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Parser 
{
	static Scanner s;
	static String linesInFile;

	public static graph readFromFile(File f) throws Exception
	
	{
		graph g = new graph();
		s = new Scanner(f);
		ignorePoundAndBlank();
		int numOfLocations;
		numOfLocations = Integer.parseInt(linesInFile);
		if (numOfLocations < 0)
		{
			throw new Exception();
		}
		g.updateNumOfLocations(numOfLocations);
		for (int i = 0; i < numOfLocations; i++)
		{
			ignorePoundAndBlank();
			vertex v = new vertex();
			v.updateVertex(i, linesInFile);
			g.addToVertex(v);
		}
		
		ignorePoundAndBlank();
		int numOfRoadSegments;
		numOfRoadSegments = Integer.parseInt(linesInFile);
		if (numOfRoadSegments < 0)
		{
			throw new Exception();
		}
		g.updateNumOfRoadSegments(numOfRoadSegments);
		for (int i = 0; i < numOfRoadSegments; i++)
		{
			ignorePoundAndBlank();
			edge e = new edge();
			Scanner scan = new Scanner(linesInFile);
			int startingPoint = scan.nextInt();
			if (startingPoint < 0)
			{
				throw new Exception();
			}
			int endingPoint = scan.nextInt();
			if (endingPoint < 0)
			{
				throw new Exception();
			}
			double distance = scan.nextDouble();
			if (distance < 0)
			{
				throw new Exception();
			}
			double trafficSpeed = scan.nextDouble();
			if (trafficSpeed < 0)
			{
				throw new Exception();
			}
			e.updateEdge(startingPoint, endingPoint, distance, trafficSpeed);
			g.addToEdge(e);
		}
		
		ignorePoundAndBlank();
		int numOfTrips;
		numOfTrips = Integer.parseInt(linesInFile);
		if (numOfTrips < 0)
		{
			throw new Exception();
		}
		g.updateNumOfTrips(numOfTrips);
		for (int i = 0; i < numOfTrips; i++)
		{
			ignorePoundAndBlank();
			trip t = new trip();
			Scanner scan = new Scanner(linesInFile);
			int startingPoint = scan.nextInt();
			if (startingPoint < 0)
			{
				throw new Exception();
			}

			int endingPoint = scan.nextInt();
			if (endingPoint < 0)
			{
				throw new Exception();
			}

			String typeOfTrip = scan.next();
			t.updateTrip(startingPoint, endingPoint, typeOfTrip);
			g.addToTrip(t);
			
		}
		
		return g;
		
	}
	
	public static void ignorePoundAndBlank()
	
	{
		linesInFile = s.nextLine();
		while (linesInFile.startsWith("#") || linesInFile.length() == 0)
		{
			linesInFile = s.nextLine();
		}
	}
	

}
