import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.junit.Test as Test
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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String DailyVisitVisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EndTimeFieldInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/SundayCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/MondayCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/TuesdayCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/WednesdayCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ThursdayCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FridayCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/SaturCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EveryDayCheckBoxInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'))

def object = new TestObject('VisitTypeInVisitTypeDropdown')

object.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + DailyVisitVisitType) + '\']')

WebUI.click(object)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/DateRangeLabel'), 0)

WebUI.click(findTestObject('DailyVisitsPage/StartDateFiledInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/StartDateInVisitTypeCalanderWhileCreatingVT'))

WebUI.click(findTestObject('DailyVisitsPage/EndDateFieldInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/endDateInCalanderWhileCreatingDV'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddBlockoutDatesButtonInCreateDailyVisitButton'), 0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/StatTimeFieldInDailyVisit'), 0)

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/SecondStartTimeFieldInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/SecondEndTimeFieldInCreateDailyVisitPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RemoveButtonInAddAnotherTimeDivision'), 0)

WebUI.click(findTestObject('DailyVisitsPage/RemoveButtonInAddAnotherTimeDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/SecondStartTimeFieldInCreateDailyVisitPage'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/SecondEndTimeFieldInCreateDailyVisitPage'), 0)

WebUI.verifyElementNotPresent(findTestObject('DailyVisitsPage/RemoveButtonInAddAnotherTimeDivision'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AddAnotherTimeButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

//WebUI.clearText(findTestObject('DailyVisitsPage/SecondStartTimeFieldInCreateDailyVisitPage'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.sendKeys(findTestObject('DailyVisitsPage/SecondStartTimeFieldInCreateDailyVisitPage'), '9:00 AM')
//
//WebUI.clearText(findTestObject('DailyVisitsPage/SecondEndTimeFieldInCreateDailyVisitPage'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.sendKeys(findTestObject('DailyVisitsPage/SecondEndTimeFieldInCreateDailyVisitPage'), '10:00 AM')
WebUI.scrollToElement(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/LocationFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/FirstLocationInCreateDailyVisiyPage'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NoCapacityButtonInDailyVisit'))

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.scrollToElement(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), 0)

WebUI.click(findTestObject('DailyVisitsPage/AssignLaterButtonInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('DailyVisitsPage/NextButtonInDailyVisit'))

WebUI.verifyElementText(findTestObject('DailyVisitsPage/Summary Page/VisitType'), DailyVisitVisitType)

WebUI.verifyElementText(findTestObject('DailyVisitsPage/Summary Page/FirstTimeInTimeDivision'), '08:00 AM - 09:00 AM')

WebUI.verifyElementText(findTestObject('DailyVisitsPage/Summary Page/SecondTimeInTimeDivision'), '08:00 AM - 09:00 AM')

