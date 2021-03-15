import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

if(WebUI.verifyElementPresent(findTestObject('TeamManagement/Teams/CommonObjectForAllTeamsInTheList'), 0, FailureHandling.OPTIONAL))
{

WebUI.waitForElementPresent(findTestObject('TeamManagement/SearchUsersSearchBoxInUsersActiveTab'), 0)

WebUI.click(findTestObject('TeamManagement/TeamsTextOnTeamsTopNav'))

WebUI.waitForElementVisible(findTestObject('TeamManagement/Teams/CommonObjectForAllTeamsInTheList'), 0)

WebDriver driver = DriverFactory.getWebDriver()

int count = driver.findElements(By.xpath('//div[@class=\'team-detail\']')).size()

println(count)

Random rand = new Random()

int random_num = rand.nextInt(count)

if(random_num<count)
{
	random_num = random_num+1
}
	
driver.findElement(By.xpath(('(//div[@class=\'team-detail\'])[' + random_num) + ']')).click()

String TeamName = driver.findElement(By.xpath('//div[text()="Team Name"]/../div[@class="col-xs-12 col-sm-8 text-wrap summary-content"]')).getText()

WebUI.click(findTestObject('TeamManagement/TeamsTab'))

WebUI.sendKeys(findTestObject('TeamManagement/Teams/SearchBoxInTeamsTab'), TeamName)

WebUI.delay(3)

int CountAfterSearch = driver.findElements(By.xpath('//div[@class=\'team-detail\']')).size()

for(int i=1;i<=CountAfterSearch;i++)
{
	String SearchResults = driver.findElement(By.xpath('(//div[@class="team-detail"])['+i+']')).getText()

	String expected = SearchResults.contains(TeamName)

	WebUI.verifyMatch(expected, 'true', false)

	String s3 = SearchResults.contains(TeamName)

	SearchResults.contains(TeamName)
}

}
else
{
	println "there are no teams presrnt unser Teams to verify search fuctionality"
}

