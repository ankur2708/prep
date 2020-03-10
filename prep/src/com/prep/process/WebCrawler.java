package com.prep.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	
	private Set<String> sitesVisited = new LinkedHashSet<String>();
	private String originSite;
	
	public WebCrawler(String originSite)
	{
		this.originSite = originSite;
	}
	
	public void crawl() throws Exception
	{
		//Time out for URL connection, 1000 ms
		System.setProperty("sun.net.client.defaultConnectTimeout", "1000");
		//Time out for read after connection established, 5000 ms
		System.setProperty("sun.net.client.defaultReadTimeout",    "5000");
		
		List<String> points = new LinkedList<String>();
		points.add(originSite);
		sitesVisited.add(originSite);
		int sitesVisitedSize = sitesVisited.size();
		
		while(!points.isEmpty())
		{
			//System.out.println(sitesVisited.size());
			if((sitesVisited.size() - sitesVisitedSize) >= 10)
			{
				sitesVisitedSize = sitesVisited.size();
				System.out.println("*************************sites visited:" + sitesVisited.size() + "*****************************************");
			}
			String site = points.remove(0);
			System.out.println("reading Site: " + site);
			try
			{
				fetch(site, points);
			}
			catch(Exception exp)
			{
				System.out.println("error while reading url:" + site);
				exp.printStackTrace();
				continue;
			}
			
		}
		
	}
	
	private void fetch(String site, List<String> points) throws Exception
	{
		URL url = new URL(site);
		InputStreamReader is = new InputStreamReader(url.openStream());
		String regexp = "(http|https)://(\\w+\\.)+(edu|com|gov|org)";
        Pattern pattern = Pattern.compile(regexp);
        
        BufferedReader reader = new BufferedReader(is);
        String line;
        while((line = reader.readLine()) != null)
        {
        	Matcher matcher = pattern.matcher(line);
        	while(matcher.find())
        	{
        		String nextSite = matcher.group();
        		if(!sitesVisited.contains(nextSite))
        		{
        			sitesVisited.add(nextSite);
        			points.add(nextSite);
        		}
        	}
        }
        
	}
		
	
	
	

}
