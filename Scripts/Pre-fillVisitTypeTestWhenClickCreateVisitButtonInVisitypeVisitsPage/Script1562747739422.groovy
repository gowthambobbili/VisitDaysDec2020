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

def DailyVisitsVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

def EventVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

def OffCammmpudVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToVisitTypes'()

VerifyPreFill(findTestObject('Object Repository/DailyVisitsPage/CreateDailyVisitHeader'), DailyVisitsVisitType, "Daily visit")

VerifyPreFill(findTestObject('Object Repository/EventsPage/CreateEventHeader'), EventVisitType, "Event")

VerifyPreFill(findTestObject('Object Repository/OffCampusPage/CreateOffCampusHeader'), OffCammmpudVisitType, "Off campus")

def VerifyPreFill(TestObject CreateVisitPageHeader, String VisitType, String VisitCategory)
{
	WebUI.click(findTestObject('Object Repository/VisitTypesPage/RequiredVisitType(VisitType)', ["VisitType":VisitType]))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/CreateNewVisitButtonInVisitsPage'), "When click visit type in visit types page, Create New visit button is not shown")
	WebUI.click(findTestObject('VisitTypesPage/CreateNewVisitButtonInVisitsPage'))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(CreateVisitPageHeader, "in visits tab of visit types page, When clicks Create New "+VisitCategory+" button the Create "+VisitCategory+" page is not opened")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/SelectedVisitTypeInVisitTypeDropdown'),
			"In visits tab of visit types, When click Create New "+VisitCategory+" button the visit type is not prefilled in the Create "+VisitCategory+" page")

	String PreFilledVisitType = WebUI.getText(findTestObject('DailyVisitsPage/SelectedVisitTypeInVisitTypeDropdown'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(PreFilledVisitType, VisitType, "In visits tab of visit types page, when click Craete "+VisitCategory+" button, incorrect visit type is pre-filler in create "+VisitCategory+" page")

	CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToVisitTypes'()
}






