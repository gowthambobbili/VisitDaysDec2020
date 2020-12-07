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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitType'(VisitType)

CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
		VisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/VisitorInsightsOptionInDailyVisits'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitorInsightsOptionInDailyVisits'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/EntryType'), 10)

CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
		'Entry Type')

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/ExpectedEntryYear'), 5)

CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
		'Expected Entry Year')

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/ApplicationStatus'),5)

CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
		'Application Status')

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/CurrentSchool'), 5)

CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
		'Current School')

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/AcademicInterest'), 5)

CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
		'Academic Interest')

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/Location'), 5)

//CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
//		'Location')
//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/AccessibilityNeeded'), 1)
//
//CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
//		'Accessibility Needed')
WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/DietaryNeeds'), 10)

CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
		'Dietary Needs')

//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/DateOfBirth'), 1)
//
//CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
//		'Date of Birth')
//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/EatingLunch'), 1)

not_run: CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'('Eating Lunch')

not_run: WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/GuestAccessibilityNeeded'), 1)

not_run: CustomKeywords.'com.CommonUtilities.VerifyNumberOfOptionsPresentInVisitorInsights.VerificationOfNumberOfOptionsInVisitorInsights'(
'Guest Accessibility Needed')

//WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Visitor Insights/AccessibilityNeeded'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Visitor Insights/DateOfBirth'), 0)

//WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Visitor Insights/EatingLunch'), 0)

 WebUI.click(findTestObject('DailyVisitsPage/Visitor Insights/EntryType'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/EntryTypeHeader'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('Entry type data is not populated in visitor insights')

} else {
	if (!(WebUI.verifyTextPresent('Freshman', false, FailureHandling.OPTIONAL))) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop('incorrect data populated for Entry type in visitor insights')
	}
}

//=======
WebUI.click(findTestObject('DailyVisitsPage/Visitor Insights/ExpectedEntryYear'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/ExpectedEntryYearHeader'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('Expected Entry Year data is not populated in visitor insights')
}
else {
	String Year = CustomKeywords.'com.CommonUtilities.Times.GetDateInRequiredFormat'('yyyy')
	println Year
	println WebUI.getText(findTestObject('DailyVisitsPage/Visitor Insights/ExpectedEntryYearExpectedValue'))
	WebUI.delay(2)
	if(!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Visitor Insights/ExpectedEntryYearExpectedValue'), Year, FailureHandling.OPTIONAL)))
	{
		KeywordUtil.markFailedAndStop('incorrect data populated for Expected entry year in visitor insights')
		WebUI.takeScreenshot()
	}
}


//=======
WebUI.click(findTestObject('DailyVisitsPage/Visitor Insights/ApplicationStatus'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/ApplicationStatusHeader'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailedAndStop('Application Status data is not populated in visitor insights')

	WebUI.takeScreenshot()
}

else {
	if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/ApplicationStatusExpectedValue'), 0, FailureHandling.OPTIONAL))) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop('incorrect data populated for Application Status in visitor insights')
	}
}

//=======
WebUI.click(findTestObject('DailyVisitsPage/Visitor Insights/CurrentSchool'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/PasrOrCurrentSchoolHeader'), 0))) {
	KeywordUtil.markFailedAndStop('Current School data is not populated in visitor insights')
	WebUI.takeScreenshot()
}

//=======
WebUI.click(findTestObject('DailyVisitsPage/Visitor Insights/AcademicInterest'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/AcademicInterestHeader'), 0))) {
	KeywordUtil.markFailedAndStop('Academic Interests data is not populated in visitor insights')

	WebUI.takeScreenshot()
} else {
	if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/AcademicInterestExpectedValue'), 0, FailureHandling.OPTIONAL))) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop('incorrect data populated for Academic Interests in visitor insights')
	}
}

//=======
WebUI.click(findTestObject('DailyVisitsPage/Visitor Insights/Location'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/LocationHeader'), 0))) {
	KeywordUtil.markFailedAndStop('Location data is not populated in visitor insights')

	WebUI.takeScreenshot()
} else {
	if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/LocationExpectedValue'), 0, FailureHandling.OPTIONAL))) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop('incorrect data populated for Location in visitor insights')
	}
}

//=======
WebUI.click(findTestObject('DailyVisitsPage/Visitor Insights/DietaryNeeds'))

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/DietaryNeedsHeader'), 0))) {
	KeywordUtil.markFailedAndStop('Dietary Needs data is not populated in visitor insights')

	WebUI.takeScreenshot()
} else {
	if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Visitor Insights/DietaryNeedsExpectedValue'), 0, FailureHandling.OPTIONAL))) {
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop('incorrect data populated for Dietary Needs in visitor insights')
	}
}

