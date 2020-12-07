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
import com.kms.katalon.core.testobject.ConditionType
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

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 10, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('ItemInPowerSelectDropdown(Item)',["Item":DailyVisitVisitType]), "The created daily visit type is not shown in the visit type dropdown in index page")

WebUI.click(findTestObject('ItemInPowerSelectDropdown(Item)',["Item":DailyVisitVisitType]))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0)

String EventVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestEventVisitType'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

def object = new TestObject("VisitTypeInFilter")

object.addProperty("xpath", ConditionType.EQUALS, "//li[text()='"+EventVisitType+"']")

WebUI.click(object)

//driver.findElement(By.xpath(('//li[text()=\'' + EventVisitType) + '\']')).click()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0)

String OffCampusVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestOffCampusVisitType'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

//driver.findElement(By.xpath(('//li[text()=\'' + OffCampusVisitType) + '\']')).click()

WebUI.click(findTestObject('ItemInPowerSelectDropdown(Item)',["Item":OffCampusVisitType]))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0)

