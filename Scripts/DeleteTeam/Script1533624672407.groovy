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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'))

WebUI.waitForElementPresent(findTestObject('TeamManagement/Teams/SearchTeamsSearchBox'), 0)

WebDriver driver = DriverFactory.getWebDriver()

def count = driver.findElements(By.xpath('//div[@class=\'team-detail\']')).size()

Random var = new Random()

rand = var.nextInt(count)

driver.findElement(By.xpath(('(//div[@class=\'team-detail\'])[' + rand) + ']')).click()

String TeamName = driver.findElement(By.xpath('//div[@class=\'team-detail\']')).getText()

println(TeamName)

String Team = TeamName.split('\n')[1]

WebUI.scrollToElement(findTestObject('TeamManagement/Teams/DeleteTeamButtonInTeamDetailsPage'), 0)

WebUI.click(findTestObject('TeamManagement/Teams/DeleteTeamButtonInTeamDetailsPage'))

WebUI.delay(3)

WebUI.click(findTestObject('TeamManagement/Teams/DeleteButtonInDeleteTeamPopup'))

WebUI.refresh()

WebUI.click(findTestObject('TeamManagement/TeamsTab'))

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('TeamManagement/Teams/SearchTeamsSearchBox'), 0)

WebUI.click(findTestObject('TeamManagement/Teams/SearchBoxInTeamsTab'))

WebUI.sendKeys(findTestObject('TeamManagement/Teams/SearchTeamsSearchBox'), Team)

WebUI.delay(2)

WebUI.verifyTextNotPresent(Team, false)

