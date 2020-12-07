import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/Calendar Tests')

suiteProperties.put('name', 'Calendar Tests')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DELL\\Downloads\\tests copy\\tests copy 14-4-2019\\Reports\\Calendar Tests\\20190612_053156\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Calendar Tests', suiteProperties, [new TestCaseBinding('Test Cases/Login and Logout/LoginAsSchoolAdmin', 'Test Cases/Login and Logout/LoginAsSchoolAdmin',  null), new TestCaseBinding('Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryFirstDayInMonthView (Daily Visit)', 'Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryFirstDayInMonthView (Daily Visit)',  null), new TestCaseBinding('Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryFirstDayInMonthView (Events)', 'Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryFirstDayInMonthView (Events)',  null), new TestCaseBinding('Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryFirstDayInMonthView (Off-Campus)', 'Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryFirstDayInMonthView (Off-Campus)',  null), new TestCaseBinding('Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryLastDayInMonthView (Daily Visit)', 'Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryLastDayInMonthView (Daily Visit)',  null), new TestCaseBinding('Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryLastDayInMonthView (Events)', 'Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryLastDayInMonthView (Events)',  null), new TestCaseBinding('Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryLastDayInMonthView (Off-Campus)', 'Test Cases/Calendar TestCases/VerificationOfVisitsInCalenderForTheVeryLastDayInMonthView (Off-Campus)',  null), new TestCaseBinding('Test Cases/TodayButtonTestInCalendar', 'Test Cases/TodayButtonTestInCalendar',  null), new TestCaseBinding('Test Cases/Login and Logout/Logout', 'Test Cases/Login and Logout/Logout',  null), new TestCaseBinding('Test Cases/CloseBrowser', 'Test Cases/CloseBrowser',  null)])
