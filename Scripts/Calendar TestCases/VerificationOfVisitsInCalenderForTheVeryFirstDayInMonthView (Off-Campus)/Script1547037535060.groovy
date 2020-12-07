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

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('HomePageElements/CalendarLeftNav'), 
    'Calendar lef nav is not present')

WebUI.click(findTestObject('HomePageElements/CalendarLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/TodayButton'), 'After clicking Calendar lef nav Calendar page is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/MonthTab'), 'Month tab is not present in "Calendar" page')

WebUI.click(findTestObject('Calendar/MonthTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/MonthViewObject'), 'After clicking Month tab in Calendar page Month view is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/ForwardArrowInCalendarHeader'), 
    'Forward arrow(>) is not present in Month view of calendar to switch months')

WebUI.click(findTestObject('Calendar/ForwardArrowInCalendarHeader'))

WebUI.delay(2)

String FirstDayInMonthView = WebUI.getText(findTestObject('Calendar/FirstDayInMonthView'))

String Day = FirstDayInMonthView.split(' ')[1]

String Month = FirstDayInMonthView.split(' ')[0]

String Year = CustomKeywords.'com.CommonUtilities.CalendarMethods.ReturnMonthHeader'('Y')

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantOffCampusVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateOffCampusVisitWithInstantVisitTypeAndProvidedMonthAndDate'(
    VisitType, Month, Day)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersForSpecificDayInIndexPage'(VisitType, Month, Day, Year)

WebUI.click(findTestObject('HomePageElements/CalendarLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/TodayButton'), 'After clicking Calendar lef nav Calendar page is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/MonthTab'), 'Month tab is not present in "Calendar" page')

WebUI.click(findTestObject('Calendar/MonthTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/MonthViewObject'), 'After clicking Month tab in Calendar page Month view is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/ForwardArrowInCalendarHeader'), 
    'Forward arrow(>) is not present in Month view of calendar to switch months')

WebUI.click(findTestObject('Calendar/ForwardArrowInCalendarHeader'))

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.CalendarMethods.VerifyVisitPresentInFirstDayOfMonthView'(VisitType)

