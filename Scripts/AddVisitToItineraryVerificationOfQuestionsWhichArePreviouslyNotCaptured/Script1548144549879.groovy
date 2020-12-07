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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

String SecondVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimesOtherThenDefaultTimes'(
		SecondVisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Group = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

def ThereDotMenu = new TestObject('ThreeDotMenuOFRegisteredGroup')

ThereDotMenu.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Group) + '\']/../..//i[text()=\'more_vert\']')

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

String Student = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def ThereDotMenuOfIndividual = new TestObject('ThreeDotMenuOFRegisteredStudent')

ThereDotMenuOfIndividual.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + Student) + '\']/../..//i[text()=\'more_vert\']')

not_run: WebUI.click(ThereDotMenu)

not_run: WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

not_run: WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

not_run: if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')
}

WebUI.refresh()

WebUI.delay(3)

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

//WebUI.waitForElementPresent(findTestObject('VisitTypesPage/QuestionsOption'), 0)

WebUI.delay(3)

//WebUI.click(findTestObject('VisitTypesPage/QuestionsOption'))

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

WebUI.waitForElementVisible(findTestObject('VisitTypesPage/QuestionSearchBox'), 0)

WebUI.waitForElementPresent(findTestObject('VisitTypesPage/FirstQuestionInQuestionsList'), 0)

WebUI.click(findTestObject('VisitTypesPage/Questions/GenderIndividualQuestionsInQuestions'))

WebUI.click(findTestObject('VisitTypesPage/UpdateButtonInQuestions'))

WebUI.sendKeys(findTestObject('VisitTypesPage/Questions/SearchBoxInUpdateQuestionsPage'), SecondVisitType.toLowerCase())

def ToggleButton = new TestObject('Toggle button in Questions')

ToggleButton.addProperty('xpath', ConditionType.EQUALS, ('//h4[text()=\'' + SecondVisitType) + '\']/../..//div[@class=\'x-toggle-btn x-toggle-light large\']')

WebUI.waitForElementVisible(ToggleButton, 0)

WebUI.click(ToggleButton)

WebUI.scrollToElement(findTestObject('VisitTypesPage/Questions/SaveButtonInQuestions'), 0)

WebUI.click(findTestObject('VisitTypesPage/Questions/SaveButtonInQuestions'))

if (!(WebUI.verifyElementPresent(findTestObject('FlashMessage'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('After adding a question to a visit the \'Question added\' success flash message is not shown')
}

WebUI.delay(5)

WebUI.refresh()

WebUI.delay(6)

//WebUI.verifyElementNotPresent(findTestObject('FlashMessage'), 0)
//WebUI.waitForElementVisible(findTestObject('VisitTypesPage/QuestionsOption'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

//WebUI.click(findTestObject('VisitTypesPage/QuestionsOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('VisitTypesPage/Questions/GroupRadioButtonInQuestions'), 0)

WebUI.click(findTestObject('VisitTypesPage/Questions/GroupRadioButtonInQuestions'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('VisitTypesPage/FirstQuestionInQuestionsList'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/FirstQuestionInQuestionsList'), "When clicked on questions tab the questions are not shown")

WebUI.click(findTestObject('VisitTypesPage/Questions/ModeOfTransportationQuestionInQuestions'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('VisitTypesPage/UpdateButtonInQuestions'))

WebUI.sendKeys(findTestObject('VisitTypesPage/Questions/SearchBoxInUpdateQuestionsPage'), SecondVisitType.toLowerCase())

WebUI.waitForElementVisible(ToggleButton, 0)

WebUI.click(ToggleButton)

WebUI.scrollToElement(findTestObject('VisitTypesPage/Questions/SaveButtonInQuestions'), 0)

WebUI.click(findTestObject('VisitTypesPage/Questions/SaveButtonInQuestions'))

if (!(WebUI.verifyElementPresent(findTestObject('FlashMessage'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('After adding a question to a visit the \'Question added\' success flash message is not shown')
}

//WebUI.click(findTestObject('FlashMessage'), FailureHandling.OPTIONAL)
WebUI.verifyElementNotPresent(findTestObject('FlashMessage'), 0, FailureHandling.OPTIONAL)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')
}

WebUI.click(ThereDotMenu)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')
}

def checkbox = new TestObject('Visit Check box in Add Visit To Itinerary modal')

checkbox.addProperty('xpath', ConditionType.EQUALS, ('(//strong[text()=\'' + SecondVisitType) + '\']//following::input)[1]')

WebUI.waitForElementVisible(checkbox, 0)

WebUI.scrollToElement(checkbox, 0)

WebUI.click(checkbox)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ContinueButtonInAddVisitToItineraryModal'))

WebUI.delay(3)

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/GenderQuestionInAddVisitToItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('while Adding visit to a Group the questions which are specific to the individual (Gender) are shown in Add VIsit To Itinerary modal')
}

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/ModeOfTransportationGroupQuestionInAddVisitToItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('while Adding visit to a Group the questions which are not captured before are not shown in Add Visit To Itinerary modal (Transportation Method question is not shown)')
}

WebUI.click(findTestObject('DailyVisitsPage/Registered/ModeOfTransportQuestionDropdownInAddVisitToItineraryModal'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Registered/BusOptionsInModeOfTransportDropdown'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/BusOptionsInModeOfTransportDropdown'))

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), 0)

def GroupProfile = new TestObject('Registered group in registered tab')

GroupProfile.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + Group) +
		'\']')

WebUI.waitForElementVisible(GroupProfile, 0)

WebUI.click(GroupProfile)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/Details/ModeOfTransportationInUserProfile'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('The questions which are answers in Add To Itinerary modal are not shown in the group profile')
}

if (!(WebUI.verifyElementText(findTestObject('UserProfile/Details/ModeOfTransportationInUserProfile'), 'Bus', FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('The Questions which are answerd in Add Visit To Itinerary modal are shown empty responces in  group profile')
}

WebUI.refresh()

def IndividualProfile = new TestObject('Registered group in registered tab')

IndividualProfile.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' +
		Student) + '\']')

WebUI.click(ThereDotMenuOfIndividual)

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddVisitToItineraryOptionInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/SearchAvailableVisitTypesDropdownInAddToMyItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('"Add visit to itinerary" modal is not shown when clicked on "Add visit to itinerary" option in student three dot menu ')
}

WebUI.waitForElementVisible(checkbox, 0)

WebUI.scrollToElement(checkbox, 0)

WebUI.click(checkbox)

WebUI.click(findTestObject('DailyVisitsPage/Registered/ContinueButtonInAddVisitToItineraryModal'))

WebUI.delay(3)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/GenderQuestionInAddVisitToItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('while Adding visit to an Individual the questions which are not captured before are shown in Add Visit To Itinerary modal')
}

if (!(WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/ModeOfTransportationGroupQuestionInAddVisitToItineraryModal'),
0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('while Adding visit to an Individual the questions which are specific to Group are shown in Add Visit To Itinerary modal (Transportation Method question is shown)')
}

WebUI.click(findTestObject('DailyVisitsPage/Registered/GenderQuestionDropdownInAddVisitToItineraryModal'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Registered/MaleOptionInGenderDropdown'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/MaleOptionInGenderDropdown'))

WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'))

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Registered/AddVisitButtonInAddVIsitToItineraryModal'), 0)

WebUI.waitForElementVisible(IndividualProfile, 0)

WebUI.click(IndividualProfile)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/UserProfile/VisitsTabInUserProfile'))

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.click(findTestObject('UserProfile/DetailsTabInUserProfile'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/GenderInUserProfile'), 0, FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('The questions which are answered in Add Visit To Itinerary modal are not shown in Individual profile')
}

WebUI.scrollToElement(findTestObject('DailyVisitsPage/Registered/GenderInUserProfile'), 0)

WebUI.delay(5)

if (!(WebUI.verifyElementText(findTestObject('DailyVisitsPage/Registered/GenderInUserProfile'), 'Male', FailureHandling.OPTIONAL))) {
	WebUI.takeScreenshot()
	KeywordUtil.markFailed('The questions which are answered in Add Visit To Itinerary modal are shown empty responces in Individual profile')
}

