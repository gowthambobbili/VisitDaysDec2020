import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'),
		"Add registrant button([+]) is not present in the daily visit page")

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Student = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

//WebUI.waitForElementVisible(findTestObject('HomePageElements/AddAttendeeButton'), 0)
//WebUI.waitForElementClickable(findTestObject('HomePageElements/AddAttendeeButton'), 0)
//String Student = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
//    VisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

def student = new TestObject('Registered Student profile in registered tab')

student.addProperty('xpath', ConditionType.EQUALS, ('//div[@class=\'uservisit-entry-content\']//div[text()=\'' + Student) +'\']')

if (!(WebUI.verifyElementPresent(student, 0))) {
	KeywordUtil.markFailedAndStop('The registered student is not shown in the registered tab')

	WebUI.takeScreenshot()
}

WebUI.click(student)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'))

WebUI.click(findTestObject('UserProfile/EditButtonInDetailsTab'))

WebUI.clearText(findTestObject('UserProfile/FirstNameTextBoxInDetailsTab'))

WebUI.sendKeys(findTestObject('UserProfile/FirstNameTextBoxInDetailsTab'), 'edit')

WebUI.clearText(findTestObject('UserProfile/LastNameTextBoxInDetailsPage'))

WebUI.sendKeys(findTestObject('UserProfile/LastNameTextBoxInDetailsPage'), 'test')

WebUI.clearText(findTestObject('UserProfile/CellPhoneNumberTextFieldInDetailsTab'))

WebUI.sendKeys(findTestObject('UserProfile/CellPhoneNumberTextFieldInDetailsTab'), '4444444444')

WebUI.click(findTestObject('UserProfile/Details/MonthDropdownInDateOfBirthField'))

WebUI.click(findTestObject('UserProfile/Details/FebruaryOption'))

WebUI.click(findTestObject('UserProfile/Details/DateDropdownInDateOfBirthField'))

WebUI.click(findTestObject('UserProfile/Details/Option2InDateDropdown'))

WebUI.click(findTestObject('UserProfile/Details/YearDropdownInDateOfBirthField'))

WebUI.click(findTestObject('UserProfile/Details/Option1995InYearDropdown'))

WebUI.clearText(findTestObject('UserProfile/Details/HomeAddressTextField'))

WebUI.sendKeys(findTestObject('UserProfile/Details/HomeAddressTextField'), 'edit test')

WebUI.clearText(findTestObject('UserProfile/Details/CityOrTownTextField'))

WebUI.sendKeys(findTestObject('UserProfile/Details/CityOrTownTextField'), 'edit city')

WebUI.clearText(findTestObject('UserProfile/Details/StateOrProvinceTextbox'))

WebUI.sendKeys(findTestObject('UserProfile/Details/StateOrProvinceTextbox'), 'AL')

WebUI.clearText(findTestObject('UserProfile/Details/ZipCodeTextField'))

WebUI.sendKeys(findTestObject('UserProfile/Details/ZipCodeTextField'), '50003')

WebUI.clearText(findTestObject('UserProfile/Details/CountryTextfield'))

WebUI.sendKeys(findTestObject('UserProfile/Details/CountryTextfield'), 'India')

WebUI.click(findTestObject('UserProfile/SaveButtonInDetailsTab'))

if (!(WebUI.verifyElementNotPresent(findTestObject('UserProfile/SaveButtonInDetailsTab'), 0))) {
	KeywordUtil.markFailedAndStop('After editng details and clicking save button the Save and Cancel buttons are not getting disappeared and the changes are not getting saved')

	WebUI.takeScreenshot()
}

WebUI.delay(3)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/FirstName'), 'edit', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng, the First name is not getting updated in Details page')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/LastName'), 'test', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng, the Last name is not getting updated in Details page')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/CellPhoneNumber'), '4444444444', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng, the Cell phone number is not getting updated in Details page')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/DateOfBirth'), 'February 02, 1995', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng, the Last name is not getting updated in Details page')

	WebUI.takeScreenshot()
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/HomeAddress'), 'edit test\nedit city\nAL\n50003\nIndia',
FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After editng, the Address is not getting updated in Details page')

	WebUI.takeScreenshot()
}

String ActualName = WebUI.getText(findTestObject('UserProfile/NameInProfilePicture'))

if (!(WebUI.verifyElementText(findTestObject('UserProfile/NameInProfilePicture'), 'ET'))) {
	KeywordUtil.markFailed('The name in profile picture is expected  to show "ET" but it shown as: ' + ActualName)

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/VisitsTabInUserProfile'))

WebUI.click(findTestObject('UserProfile/CheckInButtonInUserProfile'))

WebUI.waitForElementPresent(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), 0)

WebUI.delay(3)

String Status = WebUI.getText(findTestObject('UserProfile/StatusFieldInUserProfile'))

println(Status)

String CurrentTime = CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

WebUI.verifyElementText(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), CurrentTime)

if (!(WebUI.verifyElementText(findTestObject('UserProfile/StatusFieldInUserProfile'), 'check\ntest user1 checked in', FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After admin changes the status the status is shown incorrect in user profile (not shows admins\'s name in status)')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/ChangeStatusLinkInUserProfile'))

WebUI.waitForElementVisible(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('UserProfile/Yes,ChangeButtonnInChangeStatusModalInUserProfile'), 0)

WebUI.delay(3)

String CurrentTime1 = CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

//WebUI.verifyElementText(findTestObject('UserProfile/StatusTimeFieldInUseProfile'), CurrentTime1)

if (!(WebUI.verifyElementText(findTestObject('Object Repository/UserProfile/StatusFieldInUserProfile'), 'block\ntest user1 marked not here',
FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After admin changes the status the status is shown incorrect in user profile (not shows admins\'s name in status)')
	WebUI.takeScreenshot()
}

