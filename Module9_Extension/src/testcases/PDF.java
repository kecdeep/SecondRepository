package testcases;
import java.io.BufferedInputStream;
import java.net.URL;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class PDF {
 
WebDriver driver;
 
@BeforeClass
public void setUp() {
	System.setProperty("webdriver.gecko.driver","D:\\Selenium3\\geckodriver.exe");
	driver =new FirefoxDriver();
}
 
@AfterClass
public void tearDown() {
driver.quit();
}
 
@Test
public void testPDFReader() throws Exception {
	
driver.get("http://www.vandevenbv.nl/dynamics/modules/SFIL0200/view.php?fil_Id=5515");
 
Thread.sleep(5000);
URL url = new URL(driver.getCurrentUrl());
BufferedInputStream fileToParse = new BufferedInputStream(
url.openStream());
 
PDFParser parser = new PDFParser(fileToParse);
parser.parse();
 
String output = new PDFTextStripper().getText(parser.getPDDocument());
System.out.println(output);
parser.getPDDocument().close();
}
}
