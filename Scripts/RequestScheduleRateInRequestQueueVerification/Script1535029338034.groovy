import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

WebDriver driver = DriverFactory.getWebDriver()

DecimalFormat decimal = new DecimalFormat('0.00')

WebUI.click(findTestObject('Requests/AllReqestsInRequests'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/FirstRequestInQueue'), 0, FailureHandling.OPTIONAL)

WebUI.delay(5)

String PendingCount = WebUI.getText(findTestObject('Requests/PendingCountDivision'))

PendingCount = PendingCount.substring(PendingCount.indexOf('(') + 1)

PendingCount = PendingCount.substring(0, PendingCount.indexOf(')'))

int NumberOfPendingRequests = Integer.parseInt(PendingCount)

String ScheduledCount = WebUI.getText(findTestObject('Requests/ScheduledCountDivision'))

ScheduledCount = ScheduledCount.substring(ScheduledCount.indexOf('(') + 1)

ScheduledCount = ScheduledCount.substring(0, ScheduledCount.indexOf(')'))

int NumberOfScheduledRequests = Integer.parseInt(ScheduledCount)

String ExpiredCount = WebUI.getText(findTestObject('Requests/ExpiredCountDivision'))

ExpiredCount = ExpiredCount.substring(ExpiredCount.indexOf('(') + 1)

ExpiredCount = ExpiredCount.substring(0, ExpiredCount.indexOf(')'))

int NumberOfExpiredRequests = Integer.parseInt(ExpiredCount)

println(NumberOfScheduledRequests)

println(NumberOfPendingRequests)

println(NumberOfExpiredRequests)

String Result

try {
    Result = decimal.format((NumberOfScheduledRequests * 100) / ((NumberOfPendingRequests + NumberOfScheduledRequests) + 
        NumberOfExpiredRequests))
}
catch (ArithmeticException e) {
    e.printStackTrace()
} 
println Result
if(Result.contains(".00"))
{
	char [] ch=Result.toCharArray();
	String out="";
	for(int i=0;i<ch.length-3;i++)
	{
		out=out+ch[i];
	}
	Result=out;
	println Result
	
}
String ExpectedRequestScheduleRate = Result.toString() + '%'

println(ExpectedRequestScheduleRate)

RequestRateWithPercentageSign = WebUI.getText(findTestObject('Requests/RequestScheduleRateField'))

String ActualRequestScheduleRate = RequestRateWithPercentageSign.split('\n')[0]

println(ActualRequestScheduleRate)

//if(ActualRequestScheduleRate=='-%')
//{
//	ActualRequestScheduleRate = '0.00%'
//}

WebUI.verifyMatch(ActualRequestScheduleRate, ExpectedRequestScheduleRate, false)

