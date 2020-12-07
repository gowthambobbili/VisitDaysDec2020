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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateRequestDailyVisitWithFutureTimes'(VisitType)

WebUI.navigateToUrl(GlobalVariable.CurrentMobiUrl)

WebUI.waitForElementPresent(findTestObject('MobiPage/ScheduleAVisitButtonInAfterNavigatingToMobiUrl'), 0)

WebUI.click(findTestObject('MobiPage/ScheduleAVisitButtonInAfterNavigatingToMobiUrl'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))

WebUI.click(findTestObject('Add Attendee/RightArrowToNavigateNextDate'))

def RequestInMobi = new TestObject('Request visit in mobi')

RequestInMobi.addProperty('xpath', ConditionType.EQUALS, ('//strong[text()=\'' + VisitType) + '\']/../../../..//button[text()=\'Add to My Itinerary\']')

WebUI.click(RequestInMobi)

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

WebUI.click(findTestObject('Add Attendee/ExpectedEntryYearDropdown'))

WebUI.click(findTestObject('Add Attendee/2022OptionInExpectedEntryYear'))

WebUI.click(findTestObject('Add Attendee/CurrentOrLastSchoolDropDown'))

WebUI.sendKeys(findTestObject('Add Attendee/CurrentOrLastSchoolTextbox'), 'testschool')

WebUI.click(findTestObject('Add Attendee/FirsrtOptionInCurrentOrLastSchool'))

WebUI.click(findTestObject('Add Attendee/AcademicInterestsDropdown'))

WebUI.click(findTestObject('Add Attendee/FirstOptionInAcademicInterests'))

WebUI.click(findTestObject('Add Attendee/CompleteButtonInAddAttendee'))

WebUI.delay(3)

VisitTypeInConfirmationPage = WebUI.getText(findTestObject('MobiPage/FirstVisitTypeNameInConfirmationPage'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(VisitTypeInConfirmationPage, VisitType, 'Visit type name is shown incorrect when submitted a single request')

VisitTimesInConfirmationPage = WebUI.getText(findTestObject('MobiPage/FirstVisitTimesInConfirmationPage'))

println(VisitTimesInConfirmationPage)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(VisitTimesInConfirmationPage, '8:00 am - 9:00 am', 'Visit times are shown incorrect in the confirmation page when submitted a single request')

