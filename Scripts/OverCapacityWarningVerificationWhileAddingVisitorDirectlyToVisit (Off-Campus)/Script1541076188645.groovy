import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInFilterWhileCreatingDailyVisit')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + VisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('EventsPage/DateFieldInCreateEventPage'), 0)

WebUI.click(findTestObject('EventsPage/DateFieldInCreateEventPage'))

WebUI.click(findTestObject('DailyVisitsPage/TomorrowStartDateInVisitTypeCalendar'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))
WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'), '1')

WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '10')

WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))

WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionOneInHowManyGuestsAreProspectiveStudentsAllowedToBring'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

//WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

//WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInDailyVisit'))

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'), 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/PublishButtonInConfirmationModal'))

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'), 0)

def CurrentUrl = WebUI.getUrl()

WebUI.navigateToUrl(GlobalVariable.EvrUrl)

CustomKeywords.'com.CommonUtilities.ConfirmationPage.CompleteRegistration'([VisitType], findTestObject('Object Repository/Add Attendee/OffCampusOptionInAddAttendee'))

WebUI.navigateToUrl(CurrentUrl)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)
//
//WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)
//
//if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/VisitAtCapacityHeadInVisitAtCapactyModal'),
//0, FailureHandling.OPTIONAL))) {
//	KeywordUtil.markFailed('Visit At Capaity Modal is not shown for the visit which is at capacity')
//
//	WebUI.takeScreenshot()
//}
//
//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'), 0)
//
//WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/Yes, AddRegistrantButtonInVisitAtCapacityModal'),
//		0)
//
//WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'), 0)
//
//WebUI.click(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'))
//
//WebUI.waitForElementNotPresent(findTestObject('DailyVisitsPage/Registered/No,DontAddButtonInVisitAtCapacityModal'), 0)
//
//WebUI.delay(2)

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

WebUI.scrollToElement(findTestObject('DailyVisitsPage/RegistrantsTabInVisitCard'), 0)

WebUI.refresh()

WebUI.click(findTestObject('DailyVisitsPage/RegistrantsTabInVisitCard'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), FailureHandling.STOP_ON_FAILURE)
//
//if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/Registered/VisitAtCapacityHeadInVisitAtCapactyModal'),
//0, FailureHandling.OPTIONAL))) {
//	KeywordUtil.markFailed('Visit At Capaity Modal is not shown for the visit which is at capacity')
//
//	WebUI.takeScreenshot()
//}
//
