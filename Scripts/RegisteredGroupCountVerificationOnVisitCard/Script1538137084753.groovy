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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.omg.CORBA.Object as Object
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(DailyVisitVisitType)

String Single = 'Single'

//============Group Verification====================//

String OrganisationName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForGroupRequestWithUserNameForInstantBook'(
		DailyVisitVisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 10, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), FailureHandling.OPTIONAL)
}

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))

driver.findElement(By.xpath(('//li[text()=\'' + DailyVisitVisitType) + '\']')).click()

WebUI.delay(4)

//WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))
//
//WebUI.delay(4)
WebUI.click(findTestObject('DailyVisitsPage/StatusFilterInIndexPage'))

WebUI.click(findTestObject('DailyVisitsPage/ActiveOptionInStatusFilter'))

WebUI.delay(4)

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

WebUI.click(findTestObject('DailyVisitsPage/TodayShortCutInCalander'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

//h4[text()='Test Visit Type44249']/../../../..//p[text()='Prosp. Students']/..//h3
def Object = new TestObject('PropectiveStudentCountOnVisitCard')

Object.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + DailyVisitVisitType) + '\']/../../../..//p[text()=\'Prosp. Students\']/..//h3')

String ProspectiveStudentsCountOnVisitCardForGroupAndIndividualCombination = WebUI.getText(Object)

String ExpectedProspectedStudentCountOnVisitCardForGroupAndIndividualCombination = '3'

WebUI.verifyMatch(ProspectiveStudentsCountOnVisitCardForGroupAndIndividualCombination, ExpectedProspectedStudentCountOnVisitCardForGroupAndIndividualCombination,
		false)

Object1 = new TestObject('GuestCountOnVisitCard')

Object1.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + DailyVisitVisitType) + '\']/../../../..//p[text()=\'Guests\']/..//h3')

String GuestCountOnVisitCardForGroupAndIndividualCombination = WebUI.getText(Object1)

String ExpectedGuestCountOnVisitCardForGroupAndIndividualCombination = '3'

WebUI.verifyMatch(GuestCountOnVisitCardForGroupAndIndividualCombination, ExpectedGuestCountOnVisitCardForGroupAndIndividualCombination,
		false)

Object2 = new TestObject('TotalRegistrantsCountOnVisitCard')

Object2.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + DailyVisitVisitType) + '\']/../../../..//p[text()=\'Total Registrants\']/..//h3')

String TotalCountOnVisitCardForGroupAndIndividualCombination = WebUI.getText(Object2)

String ExpectedTotalCountOnVisitCardForGroupAndIndividualCombination = '6'

WebUI.verifyMatch(TotalCountOnVisitCardForGroupAndIndividualCombination, ExpectedTotalCountOnVisitCardForGroupAndIndividualCombination,
		false)


def object3 = new TestObject("CapacityFilledEmptyStateOnVisitCard")

object3.addProperty("xpath", ConditionType.EQUALS, "//h4[text()='"+DailyVisitVisitType+"']/../../..//p[text()='Capacity Filled']/..//h3[text()='-%']")

if(!(WebUI.verifyElementPresent(object3, 0)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailed("Capacity Filled Empty State is not shown")
}




















