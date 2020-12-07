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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitTypeWithInPersonWaysToMeet = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitTypeWithInPersonWaysToMeet)

String VisitTypeWithallWaysToMeet = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckinWithAllWaysToMeet'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimesOtherThenDefaultTimes'(
		VisitTypeWithallWaysToMeet)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitTypeWithInPersonWaysToMeet)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Individual = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def ThereDotMenu = new TestObject('ThreeDotMenuOFRegisteredStudent')

ThereDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Individual) + '\']/../..//i[text()=\'more_vert\']')

WebUI.click(ThereDotMenu)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')

	WebUI.takeScreenshot()
}

WebUI.delay(2)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
		0)

TestObject PhoneCheckbox = CustomKeywords.'com.CommonUtilities.DynamicObjectCreation.CreateObjectForCheckboxInAddVisitToItineraryModal'(
		PhoneCheckboxInAddVisitToItineraryModal, PhoneCheckbox, VisitTypeWithallWaysToMeet)

TestObject OnlineCheckbox = CustomKeywords.'com.CommonUtilities.DynamicObjectCreation.CreateObjectForCheckboxInAddVisitToItineraryModal'(
		OnlineCheckboxInAddVisitToItineraryModal, OnlineCheckbox, VisitTypeWithallWaysToMeet)

TestObject InPersonCheckbox = CustomKeywords.'com.CommonUtilities.DynamicObjectCreation.CreateObjectForCheckboxInAddVisitToItineraryModal'(
		InPersonCheckboxInAddVisitToItineraryModal, InPersonCheckbox, VisitTypeWithallWaysToMeet)

if (!(WebUI.verifyElementChecked(InPersonCheckbox, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('While adding visit to the itinerary of in person ways to meet enabled all inperson checkboxes in the Add to my itinerary modal list should be in enabled state but the Inp Person checkbox is not enabled')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementNotClickable(PhoneCheckbox, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('"Phone checkbox" in add visit to itinerary modal is not disabled even though there are conflicting ways to meet exist')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementNotClickable(OnlineCheckbox, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('"Online checkbox" in add visit to itinerary modal is not disabled even though there are conflicting ways to meet exist')

	WebUI.takeScreenshot()
}

WebUI.delay(2)

int NumberOfElements = driver.findElements(By.xpath('//div[@class=\'header-box\']//strong')).size()

//def VisitTypeName = new TestObject('VisitTypeNameInAddVisitToItineraryModal')
//VisitTypeName.addProperty("xpath", ConditionType.EQUALS, "(//div[@class='header-box']//strong)["+i+"]")
int i

String VisitTypeName1

def VisitType = new TestObject('VisitTypeNameInAddVisitToItineraryModal')

for (i = 1; i <= NumberOfElements; i++) {
	VisitType.addProperty('xpath', ConditionType.EQUALS, ('(//div[@class=\'header-box\']//strong)[' + i) + ']')

	VisitTypeName1 = WebUI.getText(VisitType)

	if (VisitTypeName1.toLowerCase() == VisitTypeWithallWaysToMeet.toLowerCase()) {
		break
	}
}

def checkbox = new TestObject('Checkbox in Add visit to itinerary modal')

checkbox.addProperty('xpath', ConditionType.EQUALS, ('(//div[@class=\'margin-t-bottom-10 flex-center\']//input)[' + i) +
		']')

WebUI.click(checkbox)

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/ContinueButtonInAddVisitToItineraryModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ContinueButtonInAddVisitToItineraryModal'))

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), 0)

def Student = new TestObject('RegisteredStudemtProfile')

Student.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Individual) + '\']')

WebUI.click(Student)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

//div[@class="visit-detail-header flex-stretch"]//h3[text()='Test Visit Type36808']
def CurretVisitType = new TestObject('Current Visit type in student profile after adding visit to itinerary')

CurretVisitType.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'visit-detail-header flex-stretch\']//h3[text()=\'' +
		VisitTypeWithInPersonWaysToMeet) + '\']')

if (!(WebUI.verifyElementPresent(CurretVisitType, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed(((('After adding a visit to the itinerary of ' + Individual) + ' The current visit type ') +
			VisitTypeWithInPersonWaysToMeet) + ' is not shown in the profile')

	WebUI.takeScreenshot()
}

def CurretVisitTimes = new TestObject('Current Visit type times in student profile after adding visit to itinerary')

CurretVisitTimes.addProperty('xpath', ConditionType.EQUALS, ('//h3[text()=\'' + VisitTypeWithInPersonWaysToMeet) + '\']/..//span')

String CurrentVisitTimesInStudentProfile = WebUI.getText(CurretVisitTimes)

if (!(WebUI.verifyMatch(CurrentVisitTimesInStudentProfile, '8:00 AM - 9:00 AM', false, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed(((('After adding a visit to the itinerary of ' + Individual) + ' The current visit type ') +
			VisitTypeWithInPersonWaysToMeet) + ' times are shown incorrect in the profile')

	WebUI.takeScreenshot()
}

def NewlyAddedVisitType = new TestObject('Current Visit type in student profile after adding visit to itinerary')

NewlyAddedVisitType.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'visit-detail-header flex-stretch\']//h3[text()=\'' +
		VisitTypeWithallWaysToMeet) + '\']')

if (!(WebUI.verifyElementPresent(NewlyAddedVisitType, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed(((('After adding a visit to the itinerary of ' + Individual) + ' The newly added visit type ') +
			VisitTypeWithallWaysToMeet) + ' is not shown in the profile')

	WebUI.takeScreenshot()
}

def NewlyAddedVisitTimes = new TestObject('Current Visit type times in student profile after adding visit to itinerary')

NewlyAddedVisitTimes.addProperty('xpath', ConditionType.EQUALS, ('//h3[text()=\'' + VisitTypeWithallWaysToMeet) + '\']/..//span')

String NewlyAddedVisitTimesInStudentProfile = WebUI.getText(NewlyAddedVisitTimes)

if (!(WebUI.verifyMatch(NewlyAddedVisitTimesInStudentProfile, '10:00 AM - 11:00 AM', false, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed(((('After adding a visit to the itinerary of ' + Individual) + ' The current visit type ') +
			VisitTypeWithallWaysToMeet) + ' times are shown incorrect in the profile')

	WebUI.takeScreenshot()
}

