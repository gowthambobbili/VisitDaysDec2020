import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import java.text.NumberFormat as NumberFormat
import java.time.LocalDateTime as LocalDateTime
import java.util.concurrent.ConcurrentSkipListMap.KeySet as KeySet
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.After as After
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.openqa.selenium.remote.server.DefaultDriverFactory as DefaultDriverFactory
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

//
////WebDriver driver = DriverFactory.getWebDriver()
//
////Date today = Calendar.getInstance().getTime();
////
////println today.toString().split(" ")[2]
////String a = "mahesh (1)"
////
////int l = a.length()-2
////
////println a[l]
////WebUI.verifyElementChecked(null, 0)
//'Set viewport size 703x347'
//not_run: WebUI.setViewPortSize(400, 658)
//
//not_run: WebUI.delay(10)
//
////WebUI.sendKeys(findTestObject('Add Attendee/AddAttendeeSearchBox'), 'test name 1017')
//not_run: WebUI.delay(8)
//
//not_run: WebUI.sendKeys(findTestObject('Add Attendee/AddAttendeeSearchBox'), 'test name 1017')
//
//not_run: WebUI.delay(8)
//
////input[@placeholder="Search by name or email..."]
////Keys.chord('Text String',Keys.ARROW_RIGHT)
////Keys.chord('Text String',Keys.ARROW_RIGHT)
//not_run: WebElement test = driver.findElement(By.xpath('//input[@placeholder=\'Search by name or email...\']'))
//
//not_run: test.sendKeys(Keys.ARROW_RIGHT)
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/AssignNowInDailyVisit'), FailureHandling.STOP_ON_FAILURE)
//
//not_run: WebUI.sendKeys(findTestObject('DailyVisitsPage/SearchUserSearchboxInAssignUsersPage'), 'mahesh test')
//
//not_run: WebUI.delay(2)
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/AddSymbolOfMaheshTestInAssignUsersPage'))
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/YesSetCapacityOptionInDailyVisit'))
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'))
//
//not_run: WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaxNumberOfIndividualsAndGroupsAllowedTextbox'),
//'100')
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'))
//
//not_run: WebUI.sendKeys(findTestObject('DailyVisitsPage/Details Page/WhatIsTheMaximumCapacityForVisitTextbox'), '50')
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/Details Page/HowManyGuestsAreProspectiveStudentsAreAllowedToBringDropDown'))
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/Details Page/OptionFiveInHowManyGuestsAreAllowedDropDown'))
//
////Date dNow = new Date( );
////SimpleDateFormat ft =
////		new SimpleDateFormat ("hh a");
////
////System.out.println("Current Date: " + ft.format(dNow));
////
////String dddd = (ft.format(dNow)).toString();
////System.out.println(dddd);
//Date dt = new Date();
//LocalDateTime.from(dt.toInstant()).plusDays(1)
//LocalDateTime.from(dt.toInstant()).plusDays(1)
not_run: Date dt = new Date()

not_run: Calendar c = Calendar.getInstance()

not_run: c.setTime(dt)

not_run: c.add(Calendar.DATE, 1)

not_run: dt = c.getTime()

not_run: println(dt)

not_run: CustomKeywords.'com.CommonUtilities.Times.GetTimeForStatusTimeStampInUserProfile'()

not_run: CustomKeywords.'com.CommonUtilities.Times.GetTime'()

not_run: WebUI.clearText(findTestObject('DailyVisitsPage/DateRangeFilterTextField'))

not_run: WebUI.sendKeys(findTestObject('DailyVisitsPage/DateRangeFilterTextField'), ReturnDate)

not_run: CustomKeywords.'com.CommonUtilities.CreateVisitOrGetExistingVisit.CreateADailyVisitOrGetExistingVisit'()

not_run: WebUI.click(findTestObject('DailyVisitsPage/CheckInButton'))

not_run: WebUI.click(findTestObject('DailyVisitsPage/RegisteredTab'))

not_run: WebUI.waitForElementVisible(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'), 0)

not_run: WebUI.click(findTestObject('DailyVisitsPage/Registered/CancelRegistrationOptionIn3DotMenu'))

not_run: WebUI.waitForElementVisible(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), 0)

not_run: WebUI.click(findTestObject('UserProfile/CheckBoxInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementVisible(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'),
0)

not_run: WebUI.click(findTestObject('UserProfile/IUnderStoodThisActionCannotBeUndoneCheckBoxInCancelRegistrationModal'),
FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementClickable(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

not_run: WebUI.click(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementNotPresent(findTestObject('UserProfile/CancelNowButtonInCancelRegistrationModal'), 0)

not_run: WebUI.refresh()

not_run: WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/CanceledTab'), 0)

not_run: WebUI.waitForElementClickable(findTestObject('DailyVisitsPage/CanceledTab'), 0)

not_run: WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('DailyVisitsPage/CanceledTab'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.delay(30)

not_run: WebUI.clickOffset(findTestObject('null'), 10, 10)

not_run: CustomKeywords.'com.CommonUtilities.Testkeywords.Testoffset'(findTestObject('null'), 10, 10)

not_run: List<String> elements = CustomKeywords.'com.CommonUtilities.Testkeywords.testmethod'()

not_run: println(elements.get(0))

not_run: println(elements.get(1))

not_run: String name = 'Mahesh'

not_run: return name

not_run: WebUI.click(findTestObject('VisitTypesPage/CloseDaysBeforeVisitRadioButton'))

not_run: WebUI.sendKeys(findTestObject('VisitTypesPage/CloseRegistrationTextbox'), '')

not_run: WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

not_run: WebUI.click(findTestObject('DailyVisitsPage/IncreaseMinutesArrow'))

not_run: println(CustomKeywords.'com.CommonUtilities.CalendarMethods.MonthNumber'('Jul'))

//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
not_run: SimpleDateFormat dateFormat = new SimpleDateFormat('d MMM yyyy')

not_run: Calendar cal = Calendar.getInstance()

not_run: cal.set(Calendar.DAY_OF_MONTH, 9)

not_run: cal.set(Calendar.MONTH, 1)

not_run: cal.set(Calendar.YEAR, 2019)

not_run: cal.add(Calendar.DAY_OF_MONTH, 34)

not_run: println(dateFormat.format(cal.getTime()).toString())

WebUI.navigateToUrl("https://staging-s.visitdays.com/bbtesting/mobi")

WebUI.waitForPageLoad(60)

WebUI.delay(10)

WebUI.verifyElementPresent(findTestObject('MobiPage/ScheduleAVisitButtonInAfterNavigatingToMobiUrl'), 0)

WebUI.click(findTestObject('MobiPage/ScheduleAVisitButtonInAfterNavigatingToMobiUrl'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.switchToFrame(findTestObject('Add Attendee/IframeOfMobi'), 0)

WebUI.waitForElementPresent(findTestObject('Add Attendee/IndividualOptionInMobi'), 0)

WebUI.click(findTestObject('Add Attendee/IndividualOptionInMobi'))

WebUI.click(findTestObject('Add Attendee/NextButtonInAddAttendee'))


