
public class Date implements Comparable<Date>
{
    private int year;
    private int month;
    private int day;
    
 
    Date(int m, int d, int y )
    {
    	year = y;
    	month = m;
    	day = d;
    }
    
   
    public int getYear()
    {
    	return year;
    }
    
    
    public int getMonth()
    {
    	return month;
    }
    
    
    public int getDay()
    {
    	return day;
    }
    
    
    public boolean checkDate(int m, int d, int y)
    {
    	return (year == y) && (month == m) && (day== d);
    }

	public int compareTo(Date other) {
		if(year < other.year) return -1;
		else if(year > other.year) return 1;
		else
		{
			if(month < other.month) return -1;
			else if(month > other.month) return 1;
			else
			{
				if(day < other.day) return -1;
				else if(day > other.day) return 1;
				else return 0;
			}
		}
	}
    
   
}