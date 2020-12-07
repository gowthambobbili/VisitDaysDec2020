import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import java.util.concurrent.locks.Condition as Condition
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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
//import com.kms.katalon.keyword.datetime
import com.kms.katalon.keyword.datetime.DateTimeUtility

//import java.text.*
//import java.text.Format
//not_run: WebDriver driver = DriverFactory.getWebDriver()
//
////
////not_run: CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
////
////not_run: String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()
////
////not_run: CustomKeywords.'com.CommonUtilities.CreationOperations.CreateDailyVisitWithRequestVisitType'(VisitType)
////
////not_run: String StudentName = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationWithRandomUserName'(
////VisitType, findTestObject('Add Attendee/DailyVisitsOptionInAddAttendee'), 'multiple')
////
////not_run: CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPage'()
////
////not_run: CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()
////
////not_run: WebUI.delay(3)
////
////not_run: driver.findElement(By.xpath(('//span[text()=\'' + StudentName) + '\']')).isDisplayed()
////
////not_run: Date dNow = new Date()
////
////not_run: SimpleDateFormat ft = new SimpleDateFormat('hh a')
////
////not_run: println('Current Date: ' + ft.format(dNow))
////
////not_run: String dddd = ft.format(dNow).toString()
////
////not_run: println(dddd)
////=======================================
////
//not_run: CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/VisitTypeFilterInDailyisitsIndexPage'))
//
//not_run: WebUI.delay(3)
//
//not_run: WebUI.click(findTestObject('DailyVisitsPage/allvisittypes'))
//
//not_run: WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)
//
//not_run: String name
//
//not_run: int numebrofelements = driver.findElements(By.xpath('//h4[@class=\'visit-type-title\']')).size()
//
//not_run: String[] myArray = new String[]
//
//not_run: WebUI.delay(4)
//
//not_run: def ob = new TestObject('visit name')
//
//not_run: for (int i = 1; i <= numebrofelements; i++) {
//	ob.addProperty('xpath', ConditionType.EQUALS, ('(//h4[@class=\'visit-type-title\'])[' + i) + ']')
//
//	(myArray[(i - 1)]) = WebUI.getText(ob)
//
//	println(myArray[(i - 1)])
//}
//
//not_run: int len = myArray.length
//
//not_run: for (int j = 0; j < len; j++) {
//	println(myArray[j])
//}
//
//not_run: myArray.sort()
//
////Arrays.sort(myArray)
//not_run: for (int k = 0; k < len; k++) {
//	println(myArray[k])
//}
not_run: String na = WebUI.callTestCase(findTestCase('Sample'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: println(na)

not_run: def x = new TestObject('object')

not_run: x.addProperty('xpath', ConditionType.EQUALS, '//button[@class=\'btn btn-primary ember-view\']')

not_run: String color = WebUI.getCSSValue(x, 'background-color')

not_run: println(color)

not_run: WebUI.verifyElementPresent(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'), 0)

not_run: WebUI.click(findTestObject('VisitTypesPage/DetailsTabInVisitTypes'))

not_run: if (!(WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'),
0))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('The Edit link is not shown while editing the visit type in \'Registrant Type\' division')
}

not_run: WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'))

not_run: WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/EditButtonInRegistrantTypeFieldInSummaryPage'))

not_run: if (WebUI.verifyElementChecked(findTestObject('VisitTypesPage/VisitTypesSummaryPage/IndividualRegistrantTypeCheckboxInputField'),
3, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))
}

not_run: if (WebUI.verifyElementNotChecked(findTestObject('VisitTypesPage/VisitTypesSummaryPage/GroupRegistrantTypeCheckBoxInputField'),
0, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))
}

not_run: WebUI.click(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'))

not_run: if (!(WebUI.verifyElementNotPresent(findTestObject('VisitTypesPage/VisitTypesSummaryPage/SaveButtonInSummaryPage'),
0, FailureHandling))) {
	WebUI.takeScreenshot()

	KeywordUtil.markFailedAndStop('After editing the \'Registrant Type\' and cilcking the Save button the save button is not getting hiddne and the chages are not getting saved')
}

not_run: println(CustomKeywords.'com.CommonUtilities.Times.GetTimeForTodayDateInDayViewOfCalendar'())

not_run: println(CustomKeywords.'com.CommonUtilities.Times.GetTimeTodayHeaderInMonthViewOfCalendar'())

not_run: println(CustomKeywords.'com.CommonUtilities.Times.GetTomorrowDay'())

not_run: CustomKeywords.'com.CommonUtilities.Times.TestMethod'()

//String charset = (('A'..'Z') + ('0'..'9')).join()
//Integer length = 1000
//String randomString = RandomStringUtils.random(length, charset.toCharArray())
//println randomString
not_run: def ab = 2.4685

//
//not_run: println(Math.round(ab))
//
//
//
//Date date = new Date();
//Calendar cal = Calendar.getInstance();
//cal.setTime(date);
//cal.add(Calendar.DATE, -7);
//Date dateBefore30Days = cal.getTime();
//println dateBefore30Days
//SimpleDateFormat ft = new SimpleDateFormat ("MMM dd, yyyy");
//String CurrentDay =  ft.format(date)
/*
 Date date = new Date();
 Calendar c = Calendar.getInstance();
 c.setTime(date);
 int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
 c.add(Calendar.DATE, -i - 7);
 Date start = c.getTime();
 c.add(Calendar.DATE, 6);
 Date end = c.getTime();
 System.out.println(start + " - " + end);
 not_run: CustomKeywords.'com.CommonUtilities.Justfortesting.EventsTest'()
 //WebUI.verifyElementPresent(findTestObject('null', ['var':'Friday, May']), 0)
 DateTimeUtility var = new DateTimeUtility()
 println var.formatStringDate("2019-5-12", "yyyy-M-dd", "yyyy-MMM-dd")
 println CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.formatStringDate'("2019-5-12", "yyyy-M-dd", "yyyy-MMM-dd")
 */


Float.parseFloat(StartTime)




