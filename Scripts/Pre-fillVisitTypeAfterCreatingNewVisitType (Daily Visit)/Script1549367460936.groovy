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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

PrefilledDataVerification(VisitType, 'r')

WebUI.refresh()

PrefilledDataVerification(VisitType, 'r', "(After page reload)")

String InstantVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

PrefilledDataVerification(InstantVisitType, 'i')

WebUI.refresh()

PrefilledDataVerification(InstantVisitType, 'i', "(After page reload)")

def PrefilledDataVerification(String VisitType, String RegistrationMethodOfVisitType, String RefreshMessage='') {
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CreateDailyVisitHeader'),
			'While creating Daily visit visit type if user clicks \'Create Daily Visit\' button then Create Daily Visit page is not opened ')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'),
			'While creating Daily visit visit type if user clicks \'Create Daily Visit\' button then Visit type drop down is not shown in Create daily visit page '+RefreshMessage)

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/SelectedVisitTypeInVisitTypeDropdown'),
			'While creating Daily visit visit type if user clicks \'Create Daily Visit\' button then Visit type is not pre-filled and it shows empty'+RefreshMessage)

	String PreFilledVisitType = WebUI.getText(findTestObject('DailyVisitsPage/SelectedVisitTypeInVisitTypeDropdown'))

	WebUI.verifyMatch(PreFilledVisitType, VisitType, false)

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/RegistrantTypeInCreateDailyVisitPage'),
			'In the prefilled data for visit type \'Registrant Type\' is not shown incorrect')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/RegistrationMethodInCreateDailyVisitPage'),
			'In the prefilled data for visit type \'Registration Method\' is not shown incorrect')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CheckInMethodInCreateDailyVisitPage'),
			'In the prefilled data for visit type \'Check In Method\' is not shown incorrect')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/DescriptionInCreateDailyVisitPage'),
			'In the prefilled data for visit type \'Description\' is not shown incorrect')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/CloseRegistrationOnInCreateDailyVisitPage'),
			'In the prefilled data for visit type \'Close Registration On\' is not shown incorrect')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/WaysToMeetInCreateDailyVisitPage'),
			'In the prefilled data for visit type \'Ways To Meet\' is not shown incorrect')

	String RegistrantType = WebUI.getText(findTestObject('DailyVisitsPage/RegistrantTypeInCreateDailyVisitPage'))

	RegistrantType = RegistrantType.trim()

	String RegistrationMethod = WebUI.getText(findTestObject('DailyVisitsPage/RegistrationMethodInCreateDailyVisitPage'))

	RegistrationMethod = RegistrationMethod.trim()

	String CheckInMethod = WebUI.getText(findTestObject('DailyVisitsPage/CheckInMethodInCreateDailyVisitPage'))

	CheckInMethod = CheckInMethod.trim()

	String Description = WebUI.getText(findTestObject('DailyVisitsPage/DescriptionInCreateDailyVisitPage'))

	Description = Description.trim()

	String CloseRegistrationOn = WebUI.getText(findTestObject('DailyVisitsPage/CloseRegistrationOnInCreateDailyVisitPage'))

	CloseRegistrationOn = CloseRegistrationOn.trim()

	String waysToMeet = WebUI.getText(findTestObject('DailyVisitsPage/WaysToMeetInCreateDailyVisitPage'))

	waysToMeet = waysToMeet.trim()

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(RegistrantType, 'Individuals And Groups', 'In the pre-filled data \'Registrant Type\' shows incorret')

	if (RegistrationMethodOfVisitType == 'r') {
		CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(RegistrationMethod, 'Request', 'In the pre-filled data \'Registration Method\' shows incorret')
	} else {
		CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(RegistrationMethod, 'Instant Book', 'In the pre-filled data \'Registration Method\' shows incorret')
	}

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(CheckInMethod, 'Manual Check In Only', 'In the pre-filled data \'Check In Method\' shows incorret')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(Description, 'This is the test descripton', 'In the pre-filled data \'Description\' shows incorret')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(CloseRegistrationOn, '0 Days Before Visit', 'In the pre-filled data \'Close Registration On\' shows incorret')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(waysToMeet, 'In Person', 'In the pre-filled data \'Ways To Meet\' shows incorret')
}

