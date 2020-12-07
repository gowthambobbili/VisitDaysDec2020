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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/DateRangeFilterInDailyVisitsPage'))

StartMonthAndYear = WebUI.getText(findTestObject('DailyVisitsPage/MonthAndYearInStartDateCalendarInDateRangeCalendar'))

EndMonthAndYear = WebUI.getText(findTestObject('DailyVisitsPage/MonthAndYearInEndDateCalendarInDateRangeCalendar'))

Date Var = Calendar.getInstance().getTime()

String Today = Var.toString().split(' ')[2]

int IntegerYear = Integer.parseInt(StartMonthAndYear.split(' ')[1])

String Year = IntegerYear + 2

String StartDate = ((((StartMonthAndYear.split(' ')[0]) + ' ') + Today) + ', ') + Year

println(StartDate)

String EndDate = ((((EndMonthAndYear.split(' ')[0]) + ' ') + Today) + ', ') + Year

println(EndDate)

WebUI.clearText(findTestObject('DailyVisitsPage/StartDateTextboxInDateRangeFilter'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/StartDateTextboxInDateRangeFilter'), StartDate)

WebUI.clearText(findTestObject('DailyVisitsPage/EndDateTextboxInDateRangeFilter'))

WebUI.sendKeys(findTestObject('DailyVisitsPage/EndDateTextboxInDateRangeFilter'), EndDate)

WebUI.click(findTestObject('DailyVisitsPage/ApplyButtonInDateRangeFilter'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0)

WebUI.refresh()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/StartDateTextboxInDateRangeFilter'), 0)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/EmptyStateMessageInVisitIndexPage'), 0)

