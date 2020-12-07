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


suiteProperties.put('id', 'Test Suites/VisitDays Test Suit for SchoolAdminUsers')

suiteProperties.put('name', 'VisitDays Test Suit for SchoolAdminUsers')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DELL\\Downloads\\tests copy\\tests copy 14-4-2019\\Reports\\VisitDays Test Suit for SchoolAdminUsers\\20190716_044449\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/VisitDays Test Suit for SchoolAdminUsers', suiteProperties, [new TestCaseBinding('Test Cases/Login and Logout/LoginAsSchoolAdmin', 'Test Cases/Login and Logout/LoginAsSchoolAdmin',  null), new TestCaseBinding('Test Cases/DetailsPageAndUnsavedChangesModalVerificationInUserprofile', 'Test Cases/DetailsPageAndUnsavedChangesModalVerificationInUserprofile',  null), new TestCaseBinding('Test Cases/DuplicateDailyVisitTest', 'Test Cases/DuplicateDailyVisitTest',  null), new TestCaseBinding('Test Cases/DuplicateEventTest', 'Test Cases/DuplicateEventTest',  null), new TestCaseBinding('Test Cases/DuplicateOff-CampusVisitTest', 'Test Cases/DuplicateOff-CampusVisitTest',  null), new TestCaseBinding('Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Daily Visit)', 'Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Daily Visit)',  null), new TestCaseBinding('Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Event)', 'Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Event)',  null), new TestCaseBinding('Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Off-Campus)', 'Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Off-Campus)',  null), new TestCaseBinding('Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType (Daily Visit)', 'Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType (Daily Visit)',  null), new TestCaseBinding('Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType( Event)', 'Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType( Event)',  null), new TestCaseBinding('Test Cases/RegisteredIndividualsAndCombinationOfGroupAndIndividualRegistrantsCountVerificaitonOnTheVisitCard', 'Test Cases/RegisteredIndividualsAndCombinationOfGroupAndIndividualRegistrantsCountVerificaitonOnTheVisitCard',  null), new TestCaseBinding('Test Cases/DeletedVisitTypesShouldNotShowInVisitTypeFilter', 'Test Cases/DeletedVisitTypesShouldNotShowInVisitTypeFilter',  null), new TestCaseBinding('Test Cases/EditNumberOfAttendeesInUserProfileTest', 'Test Cases/EditNumberOfAttendeesInUserProfileTest',  null), new TestCaseBinding('Test Cases/EmptyStateVerificatioInCheckInPage', 'Test Cases/EmptyStateVerificatioInCheckInPage',  null), new TestCaseBinding('Test Cases/GlobalSearchTest', 'Test Cases/GlobalSearchTest',  null), new TestCaseBinding('Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Daily Visits)', 'Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Daily Visits)',  null), new TestCaseBinding('Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Events)', 'Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Events)',  null), new TestCaseBinding('Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Off-Campus)', 'Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Off-Campus)',  null), new TestCaseBinding('Test Cases/RegisteredGroupCountVerificationOnVisitCard', 'Test Cases/RegisteredGroupCountVerificationOnVisitCard',  null), new TestCaseBinding('Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType(Off-Campus)', 'Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType(Off-Campus)',  null), new TestCaseBinding('Test Cases/SearchVisitTypeWithUpperCaseLettersTestInQuestions', 'Test Cases/SearchVisitTypeWithUpperCaseLettersTestInQuestions',  null), new TestCaseBinding('Test Cases/Surveys -Student App Tests/Survey404PageVerification', 'Test Cases/Surveys -Student App Tests/Survey404PageVerification',  null), new TestCaseBinding('Test Cases/VerifyAccessiblityNeedQuestionShouldNotHaveButtonToEnableOrDisableIt', 'Test Cases/VerifyAccessiblityNeedQuestionShouldNotHaveButtonToEnableOrDisableIt',  null), new TestCaseBinding('Test Cases/VisitRegistrationStatusesVerificationInUserProfile', 'Test Cases/VisitRegistrationStatusesVerificationInUserProfile',  null), new TestCaseBinding('Test Cases/WhileCreatingDailyVisitValidationErrorShouldBeShownIfUserNotSelectsAtleastOneDay', 'Test Cases/WhileCreatingDailyVisitValidationErrorShouldBeShownIfUserNotSelectsAtleastOneDay',  null), new TestCaseBinding('Test Cases/EnableAndDisableAdminDigestEmailsTest', 'Test Cases/EnableAndDisableAdminDigestEmailsTest',  null), new TestCaseBinding('Test Cases/DraftedAndCanceledVisitsShouldNotShowInCheckInPage', 'Test Cases/DraftedAndCanceledVisitsShouldNotShowInCheckInPage',  null), new TestCaseBinding('Test Cases/AccessibilityNeedLabelVerification(Daily Visit)', 'Test Cases/AccessibilityNeedLabelVerification(Daily Visit)',  null), new TestCaseBinding('Test Cases/AccessibilityNeedLabelVerification(Event)', 'Test Cases/AccessibilityNeedLabelVerification(Event)',  null), new TestCaseBinding('Test Cases/AccessibilityNeedLabelVerification(Off-Campus)', 'Test Cases/AccessibilityNeedLabelVerification(Off-Campus)',  null), new TestCaseBinding('Test Cases/Pre-fillVisitTypeTestWhenClickCreateVisitButtonInVisitypeVisitsPage', 'Test Cases/Pre-fillVisitTypeTestWhenClickCreateVisitButtonInVisitypeVisitsPage',  null), new TestCaseBinding('Test Cases/Login and Logout/Logout', 'Test Cases/Login and Logout/Logout',  null), new TestCaseBinding('Test Cases/CloseBrowser', 'Test Cases/CloseBrowser',  null)])
