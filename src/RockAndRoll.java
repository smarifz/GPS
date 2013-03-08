import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class RockAndRoll 
{
	static graph graph;

	public static void main (String[] args)
	{
		graph = new graph();
		File f = new File(args[0]);
		try {
			graph = Parser.readFromFile(f);
			graph.updateGraph();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < graph.trip.size(); i++)
		{
			dijkstraAlgo(graph.trip.get(i));
		}
	}

	public static void dijkstraAlgo(trip t)
	{
		ArrayList<vertex> vertex = graph.vertex;

		for (int i= 0; i < graph.numOfLocations; i++)
		{
			vertex.get(i).kv = false;
			vertex.get(i).pv = -999;
			vertex.get(i).dv = Integer.MAX_VALUE;
		}

		minHeap h = new minHeap(graph.numOfLocations);
		vertex.get(t.startingPoint).updateDv(0);
		h.add(vertex.get(t.startingPoint));

		while (!h.isEmpty())
		{
			vertex v = h.remove();
			if (!v.kv)
			{

				v.kv = true;
				for (int i = 0; i < v.vertexList.size(); i++)
				{

					vertex w = v.vertexList.get(i);
					if (w.dv > (v.dv + calcCost(v, w, t)))
					{
						w.dv = v.dv + calcCost(v, w, t);
						w.updatePv(v.index);
						h.add(w);
					}
				}
			}

		}


		print(t,vertex);
	}

	public static double calcCost(vertex x, vertex y, trip t)
	{
		if (t.isD())
		{
			edge e = graph.getEdge(x, y);
			return e.distance;
		}
		else
		{
			edge e = graph.getEdge(x, y);
			return e.calcTime();
		}
	}

	public static String time (double time)
	{
		int hr;
		int min;
		int sec;
		hr = (int)time;
		time = (time - hr) * 60;
		min = (int)time;
		time = (time - min) * 60;
		sec = (int)time;

		String fullTime = "";

		if (hr == 0)
		{
			if (min == 0)
			{
				fullTime = sec + " secs";
			}
			else 
			{
				fullTime = min + " mins" + sec + " secs";
			}
		}
		else 
		{
			fullTime = hr + " hrs" +  min + " mins " + sec + " secs";
		}

		return fullTime;
	}

	public static String formatDouble (double d)
	{
		DecimalFormat df = new DecimalFormat("#.#");
		return df.format(d);
	}

	public static void print(trip t, ArrayList<vertex> vAL)
	{
		ArrayList<edge> eList = new ArrayList<edge>();
		ArrayList<vertex> vList = new ArrayList<vertex>();
		double total = 0.0;
		vertex tracker = vAL.get(t.endingPoint);
		while (tracker.index != t.startingPoint)
		{
			vList.add(tracker);
			vertex tempVertex = vAL.get(tracker.pv);
			edge tempEdge = graph.getEdge(tempVertex, tracker);
			eList.add(tempEdge);
			//eList.add(g.getEdge(vAL.get(tracker.pv), tracker));
			tracker = vAL.get(tracker.pv);
		}

		if (vList.size() != 0)
		{
			for (int i = 0; i < eList.size(); i++)
			{
				if (t.isD())
				{
					total = total + eList.get(i).distance;
				}
				else
				{
					total = total + eList.get(i).calcTime();
				}
			}
			if (t.isD())
			{
				System.out.println("Shortest distance from " + vAL.get(t.startingPoint).name
						+ " to " + vAL.get(t.endingPoint).name);
			}
			else
			{
				System.out.println("Shortest driving time from " + vAL.get(t.startingPoint).name
						+ " to " + vAL.get(t.endingPoint).name);
			}

			System.out.println("Begin at " + vAL.get(t.startingPoint).name);

			for (int i = vList.size() - 1; i >= 0; i--)
			{
				if (t.isD())
				{
					System.out.println("Continue to " + vList.get(i).name + "("
							+ eList.get(i).distance + " miles)");
				}
				else
				{
					System.out.println("Continue to " + vList.get(i).name + "("
							+ eList.get(i).distance + " miles @ "
							+ eList.get(i).trafficSpeed + " MPH = "
							+ time(eList.get(i).calcTime()) + ")");
				}
			}

			if (t.isD())
			{
				System.out.println("Total distance: " + formatDouble(total));
			}
			else
			{
				System.out.println("Total time: " + formatDouble(total));
			}
			System.out.println();
		}

	}

}
