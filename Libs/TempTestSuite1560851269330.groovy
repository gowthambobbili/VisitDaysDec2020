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


suiteProperties.put('id', 'Test Suites/Requests Feature Test Suit')

suiteProperties.put('name', 'Requests Feature Test Suit')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DELL\\Downloads\\tests copy\\tests copy 14-4-2019\\Reports\\Requests Feature Test Suit\\20190618_054749\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Requests Feature Test Suit', suiteProperties, [new TestCaseBinding('Test Cases/Login and Logout/LoginAsSchoolAdmin', 'Test Cases/Login and Logout/LoginAsSchoolAdmin',  null), new TestCaseBinding('Test Cases/VerificationOfItineraryPopoverForRequestsWhileAddingOff-CampusRequest', 'Test Cases/VerificationOfItineraryPopoverForRequestsWhileAddingOff-CampusRequest',  null), new TestCaseBinding('Test Cases/VerificationOfItineraryPopoverForRequestsWhileAddingDailyVisitRequest', 'Test Cases/VerificationOfItineraryPopoverForRequestsWhileAddingDailyVisitRequest',  null), new TestCaseBinding('Test Cases/VerificationOfItineraryPopoverForRequestsWhileAddingEventRequest', 'Test Cases/VerificationOfItineraryPopoverForRequestsWhileAddingEventRequest',  null), new TestCaseBinding('Test Cases/VeificationOfPendingRequestsInRequests, RequestNotificaionsAndRedDotForDailyVisits', 'Test Cases/VeificationOfPendingRequestsInRequests, RequestNotificaionsAndRedDotForDailyVisits',  null), new TestCaseBinding('Test Cases/VeificationOfPendingRequestsInRequestsQueue, RequestNotificaionsAndRedDotForEvents', 'Test Cases/VeificationOfPendingRequestsInRequestsQueue, RequestNotificaionsAndRedDotForEvents',  null), new TestCaseBinding('Test Cases/VisitTypeFilterTestInRequestsQueue', 'Test Cases/VisitTypeFilterTestInRequestsQueue',  null), new TestCaseBinding('Test Cases/ExpiredRequestsInConsumerUserProfilesTest', 'Test Cases/ExpiredRequestsInConsumerUserProfilesTest',  null), new TestCaseBinding('Test Cases/SchedulePendingRequestInUserProfileWhenItineraryIsOneRequestAndMultippleRequests', 'Test Cases/SchedulePendingRequestInUserProfileWhenItineraryIsOneRequestAndMultippleRequests',  null), new TestCaseBinding('Test Cases/SchedulePendingRequestOfEventWhenNoOtherRequestsOnThatDay', 'Test Cases/SchedulePendingRequestOfEventWhenNoOtherRequestsOnThatDay',  null), new TestCaseBinding('Test Cases/SchedulePendingRequestOfDailyVisitWhenNoOtherRequestsOnThatDay', 'Test Cases/SchedulePendingRequestOfDailyVisitWhenNoOtherRequestsOnThatDay',  null), new TestCaseBinding('Test Cases/SchedulePendingRequestOfOff-CampusWhenNoOtherRequestsOnThatDay', 'Test Cases/SchedulePendingRequestOfOff-CampusWhenNoOtherRequestsOnThatDay',  null), new TestCaseBinding('Test Cases/AllRequestsInRequestsVerificationForDifferentPermissionLevels', 'Test Cases/AllRequestsInRequestsVerificationForDifferentPermissionLevels',  null), new TestCaseBinding('Test Cases/ScheduledRequestsInRequestsQueueTestForOff-Campus', 'Test Cases/ScheduledRequestsInRequestsQueueTestForOff-Campus',  null), new TestCaseBinding('Test Cases/ScheduledRequestsInRequestsQueueTestForEvents', 'Test Cases/ScheduledRequestsInRequestsQueueTestForEvents',  null), new TestCaseBinding('Test Cases/ScheduledRequestsInRequestsQueueTestForDailyVisits', 'Test Cases/ScheduledRequestsInRequestsQueueTestForDailyVisits',  null), new TestCaseBinding('Test Cases/RequestScheduleRateInRequestQueueVerification', 'Test Cases/RequestScheduleRateInRequestQueueVerification',  null), new TestCaseBinding('Test Cases/VerificationOFLabelsOnRequestVisitCardOfDailyVisits', 'Test Cases/VerificationOFLabelsOnRequestVisitCardOfDailyVisits',  null), new TestCaseBinding('Test Cases/VerificationOfLabelsOnRequestCardsOfEvents', 'Test Cases/VerificationOfLabelsOnRequestCardsOfEvents',  null), new TestCaseBinding('Test Cases/VerificationOfLabelsOnRequestCardOfOff-Campus', 'Test Cases/VerificationOfLabelsOnRequestCardOfOff-Campus',  null), new TestCaseBinding('Test Cases/RequestAndScheduleWhenitIneraryIsCombinationOfRequestAndInstantDailyVisit', 'Test Cases/RequestAndScheduleWhenitIneraryIsCombinationOfRequestAndInstantDailyVisit',  null), new TestCaseBinding('Test Cases/RequestAndScheduleWhenitIneraryIsCombinationOfRequestAndInstantOffCampus', 'Test Cases/RequestAndScheduleWhenitIneraryIsCombinationOfRequestAndInstantOffCampus',  null), new TestCaseBinding('Test Cases/RequestWithAllWaysToMeetShouldNotPreventTheRegistrations', 'Test Cases/RequestWithAllWaysToMeetShouldNotPreventTheRegistrations',  null), new TestCaseBinding('Test Cases/Login and Logout/Logout', 'Test Cases/Login and Logout/Logout',  null), new TestCaseBinding('Test Cases/CloseBrowser', 'Test Cases/CloseBrowser',  null)])
