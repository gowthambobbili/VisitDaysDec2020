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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))

WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))

WebUI.verifyElementPresent(findTestObject('SettingsPage/Account Basics/MainContactEmailInAccountBasics'), 0)
//
MainContactEmail = WebUI.getText(findTestObject('SettingsPage/Account Basics/MainContactEmailInAccountBasics'))

String CurrentTime = CustomKeywords.'com.CommonUtilities.CurrenDateAndTime.GetCurrentTime'()

println CurrentTime

String Meridiem = CurrentTime.split(' ')[1]

String HoursString = CurrentTime.split(' ')[0]

int Hours = Integer.parseInt(HoursString)

String StartTime = Hours - 1

StartTime = ((StartTime.toString() + ':00') + Meridiem)

String EndTime = Hours + 1

EndTime = ((EndTime.toString() + ':00') + Meridiem)

WebUI.click(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'))

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

//==================
WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), StartTime)

WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), EndTime)

//==================
WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.delay(4)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

String VisitUrl = WebUI.getUrl()

String VisitId = VisitUrl.split('visits/')[1]

print(VisitUrl)

String MobiUrl = GlobalVariable.EvrUrl+ VisitId


WebUI.navigateToUrl(MobiUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

if (!(WebUI.verifyElementText(findTestObject('Add Attendee/Mobi/MessageInMobi'), 'Registration has closed for ' + VisitType, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('Registration Closed warning message not shown for the visit in progress, in Mobi')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('Add Attendee/Mobi/MainContactEmailInMobi'), MainContactEmail, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('Incorrect Main contact email is shown in Mobi Regstration full waring page')
	WebUI.takeScreenshot()
}

WebUI.navigateToUrl(VisitUrl)

//WebUI.switchToDefaultContent()

