import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ahsan_lab13 
{
	private ArrayList<Integer> fileValues;
	
	public void readData(String filename)
	{
		fileValues = new ArrayList<>();
		
		try
	    {
	      BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
	      String inn;	      
	      
	      while( (inn = input.readLine()) != null)
	      {
	    	  fileValues.add(Integer.parseInt(inn));
	      }
	      
	      input.close();
	      System.out.println(fileValues);
	      
	    }
		
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	}
	
	public long getTotalCount()
	{
		return fileValues.stream().count();
	}
	
	public long getOddCount()
	{
		return fileValues.stream().filter(x -> x % 2  == 1).count();
	}

	public long getEvenCount()
	{
		return fileValues.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return fileValues.stream().filter(x -> x > 5 ).distinct().count();
	}
	
	public Integer[] getResult1()
	{
		return fileValues.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return fileValues.stream().limit(50).map(x -> x*x).map(x -> x*3).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return fileValues.stream().filter(x -> x % 2  == 1).map( x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}	
	
}
