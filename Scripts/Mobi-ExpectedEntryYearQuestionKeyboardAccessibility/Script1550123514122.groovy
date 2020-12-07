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
import org.openqa.selenium.Keys as Keys

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

//not_run: String VisitType = WebUI.callTestCase(findTestCase('Reusable Test Cases/GetExistingDailyVisitOrCreateANewDailyVisit'),
//    [:], FailureHandling.STOP_ON_FAILURE)

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'),
		'Add Registrant button is not present in the Daily visit')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

if (!(WebUI.verifyElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After clicking Add Registrant ([+]) button Individual option is not shown in the Mobi')
}

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/RegisterButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/HowManyGuestsDropDown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInHowManyGuestsDropdown'))

if (WebUI.verifyElementPresent(findTestObject('Add Attendee/YesOptionInAccessibilityNeedForIndividual'), 3, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Add Attendee/NoRadioButtonInAccessibilityNeeds'))
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'), 3, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Add Attendee/DietaryNeedsDropdown'))

	WebUI.click(findTestObject('Object Repository/Add Attendee/NoneOptionsInDietaryNeedsDropdown'))
}

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

Random RandVar = new Random()

String SecondName = 'Name' + RandVar.nextInt(5000)

String Email = ('test' + RandVar.nextInt(10000)) + '@gmail.com'

WebUI.sendKeys(findTestObject('Add Attendee/FirstNameInStudentInformationPage'), 'Test')

WebUI.sendKeys(findTestObject('Add Attendee/LastNameInStudentInformationPage'), SecondName)

WebUI.sendKeys(findTestObject('Add Attendee/EmailInStudentInformationPage'), Email)

WebUI.sendKeys(findTestObject('Add Attendee/ContactNumberInStudentInformationPage'), '9898989898')

WebUI.click(findTestObject('Add Attendee/MonthDropDownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/JanuaryInMonthDropDown'))

WebUI.click(findTestObject('Add Attendee/DayDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/Day1InDayDropdown'))

WebUI.click(findTestObject('Add Attendee/YearDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/FirstYearInYearDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/HomeAddressInStudentInformationPage'), 'Test address 123')

WebUI.click(findTestObject('Add Attendee/CountryDropdownInStudentInformationPage'))

WebUI.click(findTestObject('Add Attendee/UnitedStatesOptionInCountryDropdown'))

WebUI.sendKeys(findTestObject('Add Attendee/CityOrTownInStudentInformationPage'), 'Test city')

WebUI.click(findTestObject('Add Attendee/StateOrProvinceDropdownInStudentInformationPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add Attendee/StateOrProvinceOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Add Attendee/ZipCodeInStudentInformationPage'), '50001')

WebUI.click(findTestObject('Object Repository/Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/ApplicationStatusDropdown'))

WebUI.click(findTestObject('Add Attendee/AppliedOptionInApplicationStatus'))

WebUI.click(findTestObject('Add Attendee/FreshmanOptionInWhatKindOfApplicantYouAre'))

WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))

WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'))

//WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), Keys.chord(Keys.SHIFT, Keys.TAB, Keys.ENTER))
WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), Keys.chord(Keys.SHIFT, Keys.TAB, Keys.ENTER))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/FirstOptionInPowerselectDropdown'),
		"Expected entry year question is not accessible through keyboard")

not_run: WebUI.click(findTestObject('Add Attendee/FirstYearInExpectedEntryYearDropDown'))

not_run: WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))

not_run: WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), 'testschool')

not_run: WebUI.click(findTestObject('Add Attendee/FirsrtOptionInCurrentOrLastSchool'))

not_run: WebUI.click(findTestObject('Add Attendee/AcademicInterestsDropdown'))

not_run: WebUI.click(findTestObject('Add Attendee/FirstOptionInAcademicInterests'))

not_run: WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

not_run: if (!(WebUI.verifyElementNotPresent(findTestObject('Object Repository/Add Attendee/IframeOfMobi'), 10, FailureHandling.OPTIONAL))) {
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Add Attendee/ExpectedEntryYearErrorField'),
			'Expected Entry Year drop down is not accessible through keyboard(Using TAB and ENTER keys')
}

