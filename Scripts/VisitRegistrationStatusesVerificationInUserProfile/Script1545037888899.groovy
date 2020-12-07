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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.waitForElementClickable(findTestObject('HomePageElements/ProfileAvatar'), 0)

WebUI.click(findTestObject('HomePageElements/ProfileAvatar'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('ElementsUnderProfileAvatar/MyProfileOption'), 0)

WebUI.click(findTestObject('ElementsUnderProfileAvatar/MyProfileOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/My Profile/EditButtonInAdminProfile'), 0)

String FirstName = WebUI.getText(findTestObject('UserProfile/Details/FirstName'))

String LastName = WebUI.getText(findTestObject('UserProfile/Details/LastName'))

WebUI.click(findTestObject('UserProfile/OffsetFromUserprofile'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('ElementsUnderProfileAvatar/My Profile/EditButtonInAdminProfile'),
		'After clickin away from My Profile the profile is not getting closed')

String AdminName = (FirstName + ' ') + LastName

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'),
		'Add Registrant button is not present in registrants tab of the visit')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Student = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

TestObject CreatedStudent = CustomKeywords.'com.CommonUtilities.DynamicObjectCreation.CreateRegistrantObjectAndVerifyPresence'(
		Student, 'Registred Individual In Registrered tab')

WebUI.click(CreatedStudent)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('UserProfile/FirstVisitInUserProfileVisits'),
		'After clicking on user in registered tab the user profile is not shown')

WebUI.click(findTestObject('UserProfile/CheckInButtonInUserProfile'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'),
		'After clicking the Checkin button in user profile Change status link not shown')

String StatusAfterCheckin = WebUI.getText(findTestObject('UserProfile/StatusFieldInUserProfile'))

println(StatusAfterCheckin)

if(!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'check\n' + AdminName + ' checked in', FailureHandling.OPTIONAL)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("After marking the registration as Chech in the status is shown incorrect in the profile")
}


WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/Yes,ChangeButtonInChangeStatusModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/Yes,ChangeButtonInChangeStatusModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/Yes,ChangeButtonInChangeStatusModal'), 0)

WebUI.delay(4)

String StatusAfterMarkingNotHere = WebUI.getText(findTestObject('UserProfile/StatusFieldInUserProfile'))

println StatusAfterMarkingNotHere

if(!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'block\n' + AdminName + ' marked not here', FailureHandling.OPTIONAL)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("After marking the registration as Not Here the status is shown incorrect in the profile")
}

WebUI.click(findTestObject('UserProfile/ThreeDotMenuInUserProfile'))

WebUI.delay(3)

WebUI.waitForElementClickable(findTestObject('UserProfile/CancleRegistrationOptionInUsereProfile'), 0)

WebUI.waitForElementVisible(findTestObject('UserProfile/CancleRegistrationOptionInUsereProfile'), 0)

WebUI.click(findTestObject('UserProfile/CancleRegistrationOptionInUsereProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Registered/IUnderstandThisActionCheckBoxInCancelRegitrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

String StatusAfterCancelingRegistration = WebUI.getText(findTestObject('UserProfile/StatusFieldInUserProfile'))

println StatusAfterCancelingRegistration

if(!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'close\n'+AdminName+' canceled registration', FailureHandling.OPTIONAL)))
{
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop("After caneling the registration the status is shown incorrect in the profile")
}

