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

Random Var = new Random()

String LocationName = 'Location' + Var.nextInt(10000)

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateLocation'(LocationName)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitTypeInVisitTypeDropDownInCreateDailyVisitPage'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/NoVisitTypeModal'), 8, FailureHandling.OPTIONAL))
{
	WebUI.waitForElementVisible(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), 0)
	WebUI.click(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), "When clicked 'Not now' button in no visit types modal, the modal is not getting closed")
	CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), 0)
	WebUI.delay(5)
}

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)


WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/CreatedOnCampusLocationInDailyVisitLocationDropDown',['LocationName':LocationName]), 10)


if (!(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/CreatedOnCampusLocationInDailyVisitLocationDropDown',['LocationName':LocationName]), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('Created On-Campus location is not shown in locations dropdown while creating DailyVisit')
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.verifyElementPresent(findTestObject('EventsPage/CreateEventButton'), 0)

WebUI.click(findTestObject('EventsPage/CreateEventButton'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitTypeInVisitTypeDropDownInCreateDailyVisitPage'))


if(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/NoVisitTypeModal'), 5, FailureHandling.OPTIONAL))
{
	WebUI.waitForElementVisible(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), 0)
	WebUI.click(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), "When clicked 'Not now' button in no visit types modal, the modal is not getting closed")
	CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), 0)
	WebUI.delay(5)
}

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Object Repository/DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitTypeInVisitTypeDropDownInCreateDailyVisitPage'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))


WebUI.waitForElementPresent(findTestObject('Object Repository/DailyVisitsPage/CreatedOnCampusLocationInDailyVisitLocationDropDown',['LocationName':LocationName]), 10)


if (!(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/CreatedOnCampusLocationInDailyVisitLocationDropDown',['LocationName':LocationName]), 0, FailureHandling.OPTIONAL))) {

	KeywordUtil.markFailedAndStop('Created On-Campus location is not shown in locations dropdown while creating Event')
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.verifyElementPresent(findTestObject('OffCampusPage/CreateOffCampusButton'), 0)
WebUI.click(findTestObject('OffCampusPage/CreateOffCampusButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitTypeInVisitTypeDropDownInCreateDailyVisitPage'))


if(WebUI.verifyElementPresent(findTestObject('Object Repository/DailyVisitsPage/NoVisitTypeModal'), 0, FailureHandling.OPTIONAL))
{
	WebUI.waitForElementVisible(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), 0)
	WebUI.click(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), "When clicked 'Not now' button in no visit types modal, the modal is not getting closed")
	CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/DailyVisitsPage/NotNowButtonInNoVisitTypesModal'), 0)
	WebUI.delay(5)
}

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

def object2 = new TestObject('OnCampusLocationInLocationsDropdownWhileCreatingOff-CampusVisit')

object2.addProperty('xpath', ConditionType.EQUALS, ('//p[@class=\'location-dropdown\']//strong[text()=\'' + LocationName) +'\']')

if (!(WebUI.verifyElementNotPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('On-Campus location is shown in locations dropdown while creating Off-Cmapus visit')
}

String OffCampusLocationName = 'Location' + Var.nextInt(10000)

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusLocation'(OffCampusLocationName)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.verifyElementPresent(findTestObject('OffCampusPage/CreateOffCampusButton'), 0)

WebUI.click(findTestObject('OffCampusPage/CreateOffCampusButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitTypeInVisitTypeDropDownInCreateDailyVisitPage'))



WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

def object3 = new TestObject('Off-CampusLocationInLocationsDropdownWhileCreatingOff-CampusVisit')

object3.addProperty('xpath', ConditionType.EQUALS, ('//p[@class=\'location-dropdown\']//strong[text()=\'' + OffCampusLocationName) +'\']')

if (!(WebUI.verifyElementPresent(object3, 5, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('Created Off-Campus location is not shown in locations dropdown while creating Off-Cmapus visit')
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.verifyElementPresent(findTestObject('EventsPage/CreateEventButton'), 0)

WebUI.click(findTestObject('EventsPage/CreateEventButton'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitTypeInVisitTypeDropDownInCreateDailyVisitPage'))


WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

def object4 = new TestObject('Off-CampusLocationInLocationsDropdownWhileCreatingEvent')

object4.addProperty('xpath', ConditionType.EQUALS, ('//p[@class=\'location-dropdown\']//strong[text()=\'' + OffCampusLocationName) +'\']')

if (!(WebUI.verifyElementNotPresent(object4, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('Off-Campus location is shown in locations dropdown while creating Event')
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/VisitTypeFieldInDailyVisit'))

WebUI.click(findTestObject('Object Repository/DailyVisitsPage/FirstVisitTypeInVisitTypeDropDownInCreateDailyVisitPage'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

def object5 = new TestObject('Off-CampusLocationInLocationsDropdownWhileCreatingDailyVisit')

object5.addProperty('xpath', ConditionType.EQUALS, ('//p[@class=\'location-dropdown\']//strong[text()=\'' + OffCampusLocationName) +'\']')

if (!(WebUI.verifyElementNotPresent(object5, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('Off-Campus location is shown in locations dropdown while creating DailyVisit')
}

