package testClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageClasses.MainPage;
import pageClasses.SignInPage;
import pageClasses.SignUpPage;
import utils.ExcelUtility;

public class TestLa {
	
	String path = System.getProperty("user.dir");
	String chromePath = "C:\\selenium_java\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	MainPage objMainPage;
	SignInPage objSignInPage;
	SignUpPage objSignUpPage;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void gotoSignUpPage() {
		objMainPage = new MainPage(driver);
		objSignInPage = new SignInPage(driver);
		objMainPage.toSignInPage();
		objSignInPage.toSignUpPage();
	}
	
	@Test(dataProvider = "testData1")
	public void test1(String name, String email, String password) throws InterruptedException {
		objSignUpPage = new SignUpPage(driver);
		objSignUpPage.createNewUser(name, email, password);
	}

	@DataProvider(name = "testData1")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\kevin\\eclipse-workspace\\TestBrowserstackWithExcelData\\excel\\data.xlsx";
		String sheetName = "Sheet1";
		Object[][] data = testData(excelPath, sheetName);
		return data;
	}
	
	public Object[][] testData(String path, String sheet) {
		
		ExcelUtility excel = new ExcelUtility(path, sheet);
		
		int rowNo = excel.getRowCount();
		int colNo = excel.getColCount();
		
		Object[][] data = new Object[rowNo - 1][colNo];
		
		for(int i = 1; i < rowNo; i++) {
			for(int j = 0; j < colNo; j++) {
				String cellData = excel.getStringCellData(i, j);
				data[i - 1][j] = cellData;
			}
		}
		return data;
	}
}
