import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/AddAttendeeButton'),
		'Add Attendee button is not present in home page')

WebUI.click(findTestObject('HomePageElements/AddAttendeeButton'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/IframeOfMobi'),
		'Mobi is not opened')

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/IndividualOptionInMobi'),
		'Individual Option is not shown in the mobi')

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/NextButtonInAddAttendee'),
		'"Next" button is not show in the first page of Mobi')

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'),
		'Off-Campus tab is not present in Mobi')

WebUI.click(findTestObject('Add Attendee/OffCampusOptionInAddAttendee'))

String ExpectedTime = CustomKeywords.'com.CommonUtilities.Times.GetDateInRequiredFormat'('EEEE, MMMM d')

def TimeStampOnOffCampusVisitInMobi = new TestObject('Time stamp on off campus visit in mobi')

TimeStampOnOffCampusVisitInMobi.addProperty('xpath', ConditionType.EQUALS, ('//strong[text()=\'' + VisitType) + '\']/../../../..//div[@class=\'mobi-visit-type--visitdate\']')

ActualTime = WebUI.getText(TimeStampOnOffCampusVisitInMobi)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ActualTime, ExpectedTime, 'The date on off-campus visit shown incorrect in mobi Expected: '+ExpectedTime+', Actual: '+ActualTime)

