import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

String ExpiredLabel = WebUI.getText(findTestObject('Requests/ExpiredCountDivision'))

String count = ExpiredLabel.substring(ExpiredLabel.indexOf('(') + 1, ExpiredLabel.indexOf(')'))

println(count)

if (count != 0) {
    WebUI.click(findTestObject('Object Repository/Requests/ExpiredRadioButton'))

    WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/FirstRequestInQueue'), 0, FailureHandling.OPTIONAL)

    WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/FirstRequestInQueue'), 0)

    WebUI.delay(4)

    //	String TimeOnVisitCard = driver.findElement(By.xpath("//span[@class='uservisit-scheduled-details action-buttons']["+i+"]")).getText()
    //	
    //	println TimeOnVisitCard
    WebUI.click(findTestObject('Requests/FirstUserProfileInRequests'))

    WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

    WebUI.verifyElementPresent(findTestObject('Requests/ExpectedExpiredTime'), 0)

    WebUI.refresh()

    WebUI.click(findTestObject('Object Repository/Requests/ExpiredRadioButton'))

    WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/FirstRequestInQueue'), 0, FailureHandling.OPTIONAL)

    WebUI.waitForElementPresent(findTestObject('Object Repository/Add Attendee/FirstRequestInQueue'), 0)

    WebUI.delay(4)

    //	String TimeOnVisitCard = driver.findElement(By.xpath("//span[@class='uservisit-scheduled-details action-buttons']["+i+"]")).getText()
    //	
    //	println TimeOnVisitCard
    WebUI.click(findTestObject('Requests/SecondUserProfileInRequestsQueue'))

    WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

    WebUI.verifyElementPresent(findTestObject('Requests/ExpectedExpiredTime'), 0)
}

