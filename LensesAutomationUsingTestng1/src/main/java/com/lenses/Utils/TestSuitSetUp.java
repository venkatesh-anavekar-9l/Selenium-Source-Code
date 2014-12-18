package com.lenses.Utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.lenses.CustomReport.TestReport;
import com.lenses.TestdataTemplate.TestDataObj;
public class TestSuitSetUp{
	
	public static String mystring []= new String [10000];
	public static FileWriter fw=null;
	public static String uniqueFilename=null;
	String computername=null;
	String todayDateFormat=null;
	public static Map mMap = new HashMap<String, TestDataObj>();
	TestReport testReport= new TestReport();
	
	
	@BeforeSuite(alwaysRun=true)
	public void setupSuite() {
	  // public TestSuitSetUp() {
		String testResultFileName="AutomationResult.html";
		uniqueFilename=testReport.uniqueFile(testResultFileName);
		fw=testReport.resultOutputFile(uniqueFilename);
    	String sPath="";
		String filename="9lensesTestInputData.csv";
    	int linenumber=0;
    	String[] temp;
    	StringTokenizer st = null;
		try {
			sPath = new java.io.File(".").getCanonicalPath();
			System.out.println("Path: "+ sPath);
			
			FileInputStream file12 = new FileInputStream(sPath+"\\"+filename);
			DataInputStream in = new DataInputStream(file12);
			
			BufferedReader bufRdr = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while((line = bufRdr.readLine()) != null)
			{
				mystring[linenumber]=line;
				TestDataObj TestDataObject = new TestDataObj() ;
				temp=line.split(","); 
				System.out.println("inside");
				TestDataObject.setTestcaseID(temp[0]);
				TestDataObject.setFeatureName(temp[1]);
				TestDataObject.setTestPath(temp[2]);
				TestDataObject.setProfile(temp[3]);
				TestDataObject.setBrowser(temp[4]);
				TestDataObject.setUSGIP(temp[5]);
				TestDataObject.setUSGUserName(temp[6]);
				TestDataObject.setUSGPwd(temp[7]);
				TestDataObject.setUSGRootPwd(temp[8]);
				TestDataObject.setUsername(temp[9]);
				TestDataObject.setPassword(temp[10]);
				TestDataObject.setLoginURL(temp[11]);
				TestDataObject.setPacFile(temp[12]);
				TestDataObject.setPolicyID(temp[13]);
				TestDataObject.setPolicyName(temp[14]);
				TestDataObject.setParam0(temp[15]);
				TestDataObject.setParam1(temp[16]);
				TestDataObject.setParam2(temp[17]);
				TestDataObject.setParam3(temp[18]);
				TestDataObject.setParam4(temp[19]);
				TestDataObject.setParam5(temp[20]);
				TestDataObject.setParam6(temp[21]);
				TestDataObject.setParam7(temp[22]);
				TestDataObject.setParam8(temp[23]);
				TestDataObject.setParam9(temp[24]);
				TestDataObject.setParam10(temp[25]);
				TestDataObject.setParam11(temp[26]);
				TestDataObject.setParam12(temp[27]);
				TestDataObject.setParam13(temp[28]);
				TestDataObject.setParam14(temp[29]);
				TestDataObject.setParam15(temp[30]);
				
				mMap.put(temp[0], TestDataObject);
//				TestDataObject=null;
				linenumber++;
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    } 

@AfterSuite
public void afterSuite()
{
	testReport.closeOutputFile(fw, uniqueFilename);
}

}