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

String LastDateInMonthViewOfCalender = CustomKeywords.'com.CommonUtilities.CalendarMethods.Testmethod'()

println(LastDateInMonthViewOfCalender)

String Day = LastDateInMonthViewOfCalender.split(' ')[1]

String Month = LastDateInMonthViewOfCalender.split(' ')[0]

String Year = LastDateInMonthViewOfCalender.split(' ')[2]

println('Day: ' + Day)

println('Month: ' + Month)

println('Year: ' + Year)

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithInstantVisitTypeAndProvidedMonthDateAndYear'(
		VisitType, Month, Day, Year)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersForSpecificDayInIndexPage'(VisitType, Month, Day, Year)

WebUI.click(findTestObject('HomePageElements/CalendarLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/TodayButton'), 'After clicking Calendar lef nav Calendar page is not getting opened')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/MonthTab'), 'Month tab is not present in "Calendar" page')

WebUI.click(findTestObject('Calendar/MonthTab'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('Calendar/MonthViewObject'), 'After clicking Month tab in Calendar page Month view is not getting opened')

WebUI.delay(3)

CustomKeywords.'com.CommonUtilities.CalendarMethods.VerifyVisitPresentInLastDayOfMonthView'(VisitType)







