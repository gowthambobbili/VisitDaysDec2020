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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.Logout'()

WebUI.waitForElementPresent(findTestObject('LoginPage/EmailTextBox'), 0)

WebUI.sendKeys(findTestObject('LoginPage/EmailTextBox'), findTestData('LoginData').getValue(2, 1))

WebUI.sendKeys(findTestObject('LoginPage/PasswordTextBox'), findTestData('LoginData').getValue(2, 2))

WebUI.click(findTestObject('LoginPage/SignInButton'))

WebUI.waitForElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/ThisMonthOptionInCalanderPopup'))

WebUI.delay(3)

if(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 0))
{
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/allvisittypes'))

WebUI.delay(3)

WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

if(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0, FailureHandling.OPTIONAL))
{

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/DuplicateDailyVIsitButton'), 0)

}

else
{
	println "There are no Visits to verify"
}