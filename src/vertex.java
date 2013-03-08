import java.util.ArrayList;


public class vertex {
	
	int index;
	String name;
	ArrayList<vertex> vertexList = new ArrayList<vertex>();
	boolean kv = false;
	double dv = Integer.MAX_VALUE;
	int pv = -999;
	
	public vertex()
	{
		
	}
	
	public void updateVertex(int index, String name)
	{
		this.index = index;
		this.name = name;
	}
	
	public void addToVertexList(vertex v)
	{
		vertexList.add(v);
	}
	
	public void updateDv(double dv)
	{
		this.dv = dv;
	}
	
	public void updatePv(int pv)
	
	{
		this.pv = pv;
	}
	
}
