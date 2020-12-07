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


suiteProperties.put('id', 'Test Suites/Add Visit To Itinerary Tests')

suiteProperties.put('name', 'Add Visit To Itinerary Tests')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DELL\\Downloads\\tests copy\\tests copy 14-4-2019\\Reports\\Add Visit To Itinerary Tests\\20190618_042702\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Add Visit To Itinerary Tests', suiteProperties, [new TestCaseBinding('Test Cases/Login and Logout/LoginAsSchoolAdmin', 'Test Cases/Login and Logout/LoginAsSchoolAdmin',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryConflictingTimesAndNonPublihedVisitsTest (Daily Visits)', 'Test Cases/AddVisitToItineraryConflictingTimesAndNonPublihedVisitsTest (Daily Visits)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryConflictingTimesAndNonPublihedVisitsTest (Events)', 'Test Cases/AddVisitToItineraryConflictingTimesAndNonPublihedVisitsTest (Events)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryConflictingTimesAndNonPublihedVisitsTest (Off-Campus)', 'Test Cases/AddVisitToItineraryConflictingTimesAndNonPublihedVisitsTest (Off-Campus)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationForCanceledUserProfiles(Daily visits)', 'Test Cases/AddVisitToItineraryOptionVerificationForCanceledUserProfiles(Daily visits)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationForCanceledUserProfiles(Event)', 'Test Cases/AddVisitToItineraryOptionVerificationForCanceledUserProfiles(Event)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationForCanceledUserProfiles(Off-Campus)', 'Test Cases/AddVisitToItineraryOptionVerificationForCanceledUserProfiles(Off-Campus)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInRegistrantThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Daily Visit)', 'Test Cases/AddVisitToItineraryOptionVerificationInRegistrantThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Daily Visit)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInRegistrantThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Event)', 'Test Cases/AddVisitToItineraryOptionVerificationInRegistrantThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Event)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInRegistrantThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Off-Campus)', 'Test Cases/AddVisitToItineraryOptionVerificationInRegistrantThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Off-Campus)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInRescheduledUserProfileThreeDotMenuAndRegisteredTab(Daily Visits)', 'Test Cases/AddVisitToItineraryOptionVerificationInRescheduledUserProfileThreeDotMenuAndRegisteredTab(Daily Visits)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInRescheduledUserThreeDotMenuInRegisteredTab(Daily Visits)', 'Test Cases/AddVisitToItineraryOptionVerificationInRescheduledUserThreeDotMenuInRegisteredTab(Daily Visits)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInUserProfileThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Daily Visit)', 'Test Cases/AddVisitToItineraryOptionVerificationInUserProfileThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Daily Visit)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInUserProfileThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Event)', 'Test Cases/AddVisitToItineraryOptionVerificationInUserProfileThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Event)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOptionVerificationInUserProfileThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Off-Campus)', 'Test Cases/AddVisitToItineraryOptionVerificationInUserProfileThreeDotMenuForRegistered,CheckInAndNotHereStatuses (Off-Campus)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryOverCapacityWarningVerification', 'Test Cases/AddVisitToItineraryOverCapacityWarningVerification',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryTestForRegistrantTypes (Daily Visits)', 'Test Cases/AddVisitToItineraryTestForRegistrantTypes (Daily Visits)',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryVerificationOfQuestionsWhichArePreviouslyNotCaptured', 'Test Cases/AddVisitToItineraryVerificationOfQuestionsWhichArePreviouslyNotCaptured',  null), new TestCaseBinding('Test Cases/AddVisitToItineraryWithChannelTestAndVerificationOfVisitAddingToTheItinerary', 'Test Cases/AddVisitToItineraryWithChannelTestAndVerificationOfVisitAddingToTheItinerary',  null), new TestCaseBinding('Test Cases/SearchVisitTypeTestInAddVisitToItineraryModal', 'Test Cases/SearchVisitTypeTestInAddVisitToItineraryModal',  null), new TestCaseBinding('Test Cases/Login and Logout/Logout', 'Test Cases/Login and Logout/Logout',  null), new TestCaseBinding('Test Cases/CloseBrowser', 'Test Cases/CloseBrowser',  null)])
