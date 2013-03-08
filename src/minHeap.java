

public class minHeap{

	vertex[] vertexHeap;
	int size;

	public minHeap (int totalVertex)
	{
		size = 0;
		vertexHeap = new vertex[totalVertex + 1];

	}

	public boolean isEmpty()
	{
		if (size == 0)
		{
			return true;
		}

		else
			return false;
	}

	public int getSize()
	{
		return size;
	}

	public void add (vertex v)
	{
		int tracker = size + 1;
		vertexHeap[tracker] = v;
		while (tracker > 1)
		{
			if (vertexHeap[tracker].dv < vertexHeap[tracker/2].dv)
			{
				vertex temp = vertexHeap[tracker];
				vertexHeap[tracker] = vertexHeap[tracker/2];
				vertexHeap[tracker/2] = temp;

			}
			tracker = tracker/2;

		}
		size++;	
	}

	public vertex remove()
	{
		vertex min = vertexHeap[1];
		vertexHeap[1] = vertexHeap[size];
		vertexHeap[size] = null;

		for (int i = 1; i < size/2; i++)
		{
			if (vertexHeap[(2*i)+1] != null)
			{
				if (vertexHeap[(2*i)].dv < vertexHeap[(2*i)+1].dv)
				{
					if (vertexHeap[(2*i)].dv < vertexHeap[i].dv)
					{
						vertex temp = vertexHeap[(2*i)];
						vertexHeap[(2*i)] = vertexHeap[i];
						vertexHeap[i] = temp;

					}



				}
				else
				{
					if (vertexHeap[(2*i)+1].dv < vertexHeap[i].dv)
					{
						vertex temp = vertexHeap[(2*i)+1];
						vertexHeap[(2*i)+1] = vertexHeap[i];
						vertexHeap[i] = temp;
					}

				}

			}
			else 
			{
				if (vertexHeap[(2*i)] != null)
				{
					if (vertexHeap[(2*i)].dv < vertexHeap[i].dv)
					{
						vertex temp = vertexHeap[(2*i)];
						vertexHeap[(2*i)] = vertexHeap[i];
						vertexHeap[i] = temp;

					}
				}
			}
		}
		size--;
		return min;

	}

}
