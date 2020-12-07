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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

String Single = 'Single'

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.delay(2)

WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

//==================
WebUI.clearText(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), '11:00 PM')

WebUI.clearText(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), '11:45 PM')

//==================
WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '1')

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '10')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionOneInHowManyGuestsAreProspectiveStudentsAllowedToBring'))

//WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))
WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

WebUI.delay(4)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
    VisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), Single)

not_run: CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 
    'Add registrant button is not shown in the daily visit page')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Student = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

String VisitUrl = WebUI.getUrl()

String VisitId = VisitUrl.split('visits/')[1]

print(VisitUrl)

String MobiUrl = GlobalVariable.EvrUrl + VisitId

WebUI.navigateToUrl(MobiUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

if (!(WebUI.verifyElementText(findTestObject('Add Attendee/Mobi/MessageInMobi'), ('Registration for ' + VisitType) + ' has reached capacity', 
    FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('Registrations reached capacity warning message not shown in Mobi')

    WebUI.takeScreenshot()
}

WebUI.navigateToUrl(VisitUrl)

//WebUI.switchToDefaultContent()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.click(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/EditLinkInCapacityDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '10')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '1')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveButton'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Details Page/ThisInstanceOnlyRadioButtonInEditVisitModal'), 
    0)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/ThisInstanceOnlyRadioButtonInEditVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/Details Page/SaveNowButtonInEditVisitModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveNowButtonInEditVisitModal'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/Details Page/SaveButton'), 0)

WebUI.delay(2)

WebUI.navigateToUrl(MobiUrl)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

if (!(WebUI.verifyElementText(findTestObject('Add Attendee/Mobi/MessageInMobi'), ('Registration for ' + VisitType) + ' has reached capacity'))) {
    KeywordUtil.markFailed('Registration reached warning message not shown in Mobi')

    WebUI.takeScreenshot()
}

//WebUI.switchToDefaultContent()

