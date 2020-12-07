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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateOffCampusWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

def visit = new TestObject('Created Visit In Index Page')

visit.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + VisitType) + '\']')

WebUI.click(visit)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The Add registrant button is not shown in the registered tab to add visitor directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

String Individual = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def IndObject = new TestObject('Registered Individual In Registered Tab')

IndObject.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + Individual) +
		'\']')

if (!(WebUI.verifyElementPresent(IndObject, 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('registered Individual Student is not shown in the registered tab')
}

def ThreeDotMenu = new TestObject('Three Dot Menu Of Registered Individual In Registered Tab')

ThreeDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Individual) + '\']/../..//i[text()=\'more_vert\']')

WebUI.click(ThreeDotMenu)

WebUI.click(findTestObject('DailyVisitsPage/Registered/RescheduleOptionIn3DotMenu'))

WebUI.waitForElementPresent(findTestObject('Requests/DayAndTimeInRescheduleModal'), 0)

WebUI.waitForElementVisible(findTestObject('Requests/CheckBoxInRescheduleModal'), 0)

WebUI.click(findTestObject('Requests/CheckBoxInRescheduleModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Requests/SelectADateToRescheduleCalendar'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/FirstAvailableDateInCalancerInRescheduleModal'),
		0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/FirstAvailableDateInCalancerInRescheduleModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInRescheduleModal'),
		0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Registered/FirstVisitTypeChechBoxInReschedulModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/FirstVisitTypeChechBoxInReschedulModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Requests/SelectNumberOfAttendeesDropdown'), 0)

WebUI.click(findTestObject('Requests/SelectNumberOfAttendeesDropdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Requests/SelectTwoInNumberOfAttendeesDropDown'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Requests/RescheduleButtonInRescheduleModal'), 0)

WebUI.click(findTestObject('Requests/RescheduleButtonInRescheduleModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Requests/RescheduleButtonInRescheduleModal'), 0)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

WebUI.verifyElementVisible(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

WebUI.verifyElementVisible(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(IndObject, 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('Rescheduled  Individual Student is not shown in the Cacneled tab')
}

WebUI.click(ThreeDotMenu)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('"Add Visit To Itinerary" option is not shown in The Reschedued Individual three dot menu')
}

WebUI.click(IndObject)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/ThreeDotMenuInUserProfile'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('Three dot menu is not shown in the Rescheduled individual user profile')
}

//WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))
def ThredotMenuOfRescheduledStudent = new TestObject('Three dot menu for rescheduled user')

ThredotMenuOfRescheduledStudent.addProperty('xpath', ConditionType.EQUALS, ('//h3[text()=\'' + VisitType) + '\']//parent::div/../..//i[text()=\'more_vert\']')

if (!(WebUI.verifyElementNotPresent(ThredotMenuOfRescheduledStudent, 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('In the rescheduled student profile three dot menu is shown for the rescheduled visit')
}

