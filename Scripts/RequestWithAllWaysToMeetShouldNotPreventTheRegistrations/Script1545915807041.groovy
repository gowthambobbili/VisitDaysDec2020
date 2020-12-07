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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitTypeWithMenualCheckinAndAllWaysToMeet'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateRequestDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

CustomKeywords.'com.CommonUtilities.MobiRegistrations.RegisterAGroupRequestThroughMobiAndReturnTheStudetName'(VisitType,
	findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/RegistrationSubmitterHeaderInConfirmationPageOfMobi'),
	'While registering a Group request with >1 ways to meet options then the mobi is not getting closed in the final step')


//
//String Student = CustomKeywords.'com.CommonUtilities.MobiRegistrations.RegisterAnIndividualRequestThroughMobiAndReturnTheStudetName'(
//		VisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'))
//
//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Add Attendee/RegistrationSubmitterHeaderInConfirmationPageOfMobi'),
//		'While registering an Individual request with >1 ways to meet options then the mobi is not getting closed in the final step')
