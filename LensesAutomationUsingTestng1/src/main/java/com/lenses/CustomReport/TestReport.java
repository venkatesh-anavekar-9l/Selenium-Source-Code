package com.lenses.CustomReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestReport {

	public String uniqueFile(String fileN)
	{
		String fName="";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		System.out.println("Current data and Time--->"+dateFormat.format(cal.getTime()));
		System.out.println();
		String completeFileName="";
		System.out.println(fileN);
		String fileNames[]=fileN.split("\\.");
		
		System.out.println(fileNames.length);
		completeFileName=fileNames[0]+dateFormat.format(cal.getTime())+"."+fileNames[1];
		fName=completeFileName;
		System.out.println(completeFileName);
		return fName;
	}
	public FileWriter resultOutputFile(String filename){		
		
		FileWriter fileWritter=null;	
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String todayDate=dateFormat.format(cal.getTime());
		//System.out.println("Current data and Time--->"+dateFormat.format(cal.getTime()));

			try
			{	
				
				String spath="";
				try {
					spath=new java.io.File(".").getCanonicalPath()+"\\result\\"+filename;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					
				}
				System.out.println(spath);
				
				File file= new File(spath);
				if(!file.exists()){
					file.createNewFile();
					System.out.println("file created....");
				}
				else
				{
					System.out.println("file already present");
				}
				
				fileWritter = new FileWriter(file);
		        
				fileWritter.write("<html>");
				fileWritter.write("<head><title>Automation Result</title>");
				fileWritter.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
				fileWritter.write("<style>table,th,td{border:1px solid black;border-collapse:collapse;}th,"
		        		+ "td{padding:5px;}th{text-align:left;border-radius: 5px;}"
		        		+ ".tableColHeading{background: #245269;color: #E1EDF7;	font-size: 16px;font-weight: bold;border-radius: 5px;"
		        		+ "max-width: 16.66666666666667%;min-width: 16.66666666666667%;}"
		        		+ ".success{background: #33AD33;}"
		        		+ ".danger{background: #FF3333;}"
		        		+ ".warning{background: #EBC633;}"
		        		+ "table{min-width: 900px;	width: 100%;border-radius: 5px;}"
		        		+ ".automationTitle{padding: 10px;border-radius: 5px;}"
		        		+ ".Heading{text-align: center;	font-size: 35px;font-weight: bold;border-radius: 5px;border-bottom: 2px solid #245269;}"
		        		+ ".date{font-weight: normal;font-style: italic;font-size:14px;}"
		        		+ ".resultWrapper{padding:10px;border-radius: 5px;}"	        		
		        		
		        		+ "</style>");
				fileWritter.write("</head>");
				fileWritter.write("<body>");
				fileWritter.write("<div class=\"automationTitle\"><p class=\"Heading\">Automation Result("+todayDate+")<b class=\"date\"></b></p></div>");
				fileWritter.write("<div class=\"resultWrapper\">"
		        		+ "<table>"
		        			+ "<tr class=\"tableColHeading\"> "
		        				+ "<th>Test Case ID</th>"
		        				+ "<th>Test Description</th>"
		        				+ "<th>Result</th>"
		        				+ "<th>Expected</th>"
		        				+ "<th>Actual</th>"
		        				+ "<th>Comments</th>"
		        			+ "</tr>");
		        
		        
		       fileWritter.close();
		       
				
			}
			catch(Exception e)
			{
				
				System.out.println("Execpetion occured in resultOutputFile "+e);
			}
			return fileWritter;
		}
	
	public void addResult(FileWriter fwr,String tcid, String tcDesc,String result, String expected, String actual, String commnets,String file)
	{
		System.out.println("Result file writer...");
		try {
			String spath="";
			String resultClass="";
			if(result.equalsIgnoreCase("PASS"))
			{
				resultClass="success";
			}
			else if(result.equalsIgnoreCase("FAIL") && commnets.equalsIgnoreCase("NA")){
				resultClass="danger";
			}
			else if(result.equalsIgnoreCase("FAIL") || !(commnets.equalsIgnoreCase("NA")))
				
			{
				resultClass="danger";
			}
			
			try {
				spath=new java.io.File(".").getCanonicalPath()+"\\result\\"+file;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				
			}
			System.out.println("Output file--->"+spath);
			File file2= new File(spath);
			fwr = new FileWriter(file2,true);			
			fwr.write("<tr class=\""+resultClass+" tableColHeading\">"
						+ "<td>"+tcid+"</td>"
						+ "<td>"+tcDesc+"</td>"
						+ "<td>"+result+"</td>"
						+ "<td>"+expected+"</td>"
						+ "<td>"+actual+"</td>"
						+ "<td>"+commnets+"</td>"
					);
			fwr.write("</tr>");
			fwr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeOutputFile(FileWriter fwr,String file)
	{
		
		try {
			String spath="";
			try {
				spath=new java.io.File(".").getCanonicalPath()+"\\result\\"+file;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				
			}
			System.out.println("Output file--->"+spath);
			File file3= new File(spath);
			fwr = new FileWriter(file3,true);
			
			fwr.write("</table>");
			fwr.write("</div>");
			fwr.write("</body>");
			fwr.write("</html>");
			fwr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
       
	}
}
