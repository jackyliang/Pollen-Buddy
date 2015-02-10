import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Pollen
{	
	/**
	 * TreeMap to hold Date and String objects
	 * Date corresponds to four dates that
	 */
	private static Map<Date, String> pollenMap = new TreeMap<Date, String>();
	
	private String location;
	private String pollenType;
	private int zipcode;
	
	public String getDateToday()
	{
		return Pollen.pollenMap.entrySet().iterator().next().getKey().toString();
	}
	
	public String getPollenType()
	{
		return this.pollenType;
	}
	
	public String getCity()
	{
		return this.location;
	}
	
	public int getZipcode()
	{
		return this.zipcode;
	}
	
	public Set<Date> getCorrespondingDate()
	{
		return Pollen.pollenMap.keySet();
	}
	
	public Collection<String> getPollenIndex()
	{
		return Pollen.pollenMap.values();
	}
	
	public void printDates()
	{
		SimpleDateFormat format = new SimpleDateFormat("EEEEE MMMM d yyyy");
		
		// iterating over my treemap
		
		for(Entry<Date, String> i : pollenMap.entrySet()) 
		{
			String key = format.format(i.getKey());
			String value = i.getValue();

			System.out.println(key + ": " + value);
		}
	}
	
	public Pollen(int zipcode)
	{
		
		try
		{
			this.zipcode = zipcode;
			Document doc;
			// pass address to 
			doc = Jsoup.connect("http://www.wunderground.com/DisplayPollen.asp?Zipcode=" + this.zipcode).get();
			
			if(doc.select("div.columns").first().text() == null)
			{
				System.exit(0);
				System.out.println("reach?");
			}
			
			// get "location" from XML
			Element location = doc.select("div.columns").first();
			System.out.println(this.location);
			
			// get "pollen type" from XML
			Element pollenType = doc.select("div.panel h3").first();
			this.pollenType = pollenType.text();
			
			SimpleDateFormat format = new SimpleDateFormat("EEE MMMM dd, yyyy");
			
			// add the four items of pollen and dates
			// to its respective list
			for(int i = 0; i < 4; i++)
			{
				Element dates = doc.select("td.text-center.even-four").get(i);
				Element levels = doc.select("td.levels").get(i);
				
				try
				{
					pollenMap.put(format.parse(dates.text()), levels.text());
				}
				catch (ParseException e)
				{
					System.exit(0);
					e.printStackTrace();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("reached 1");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Pollen pollenTracker = new Pollen(30001);
		
		SimpleDateFormat input = new SimpleDateFormat("EEE MMMM dd HH:mm:ss zzz yyyy");
		SimpleDateFormat output = new SimpleDateFormat("EEE MMMM dd, yyyy");
		
		try
		{
			Date formattedDate = input.parse(pollenTracker.getCorrespondingDate().toArray()[0].toString());
			// System.out.println(input.parse(pollenTracker.getCorrespondingDate().toArray()[0].toString()).toString());
			System.out.println("date:"+output.format(formattedDate));
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// pollenTracker.printDates();
	}

}
