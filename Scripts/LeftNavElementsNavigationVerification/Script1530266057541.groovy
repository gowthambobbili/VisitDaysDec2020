import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

/*
 * Verify the left nav elements are visisble
 */
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/CheckInLeftNav'), "Check in left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/CalendarLeftNav'), "Calendar left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/VisitsLeftNav'), "Visit left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/VisitTypesLeftNav'), "Visit types left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/RequestsOption'), "Requests left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/AnalyticsLeftNav'), "Analytics left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'), "Survey left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/MobiLeftNav'), "Mobi left nav is not present in the home page")

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/MyTeamLeftNav'), "My Team left nav is not present in the home page")

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/SettingsLeftNav'), "Settings left nav is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/PromoteIcon'), "Promote icon is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/PlatformIcon'), "Platform icon is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/LearnIcon'), "Learn icon is not present in the home page")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/VisitDaysLogoInHomePage'), "VisitDays logo is not present in the home page")

/*
 * Verify the sub left nav elements are not visisble before clicking the main left nav 
 */

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('HomePageElements/Visits/DailyVisitsLeftNav'), "In home page, Daily visits left nav is shown before clicking Visits nav")

//CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('HomePageElements/Visits/EventsLeftNav'), "In home page, Events left nav is shown before clicking Visits nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('HomePageElements/Visits/OffCampusLeftNav'), "In home page, Off Campus left nav is shown before clicking Visits nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Survey/SummaryLeftnav'), "In home page, Summary left nav is shown before clicking Survey nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Survey/Survey-QuestionsTab'), "In home page, Survey-Questions left nav is shown before clicking Survey nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Survey/ApplicantsAndYieldLeftNav'), "In home page, Applicants & Yield left nav is shown before clicking Survey nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Survey/PerformanceLeftNav'), "In home page, Performance left nav is shown before clicking Survey nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Survey/ResponsesLeftNav'), "In home page, Responses left nav is shown before clicking Survey nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Mobi/Mobi-QuestionsLeftNav'), "In home page, Mobi-Questions left nav is shown before clicking Mobi nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Mobi/Mobi-SettingsLeftNav'), "In home page, Mobi-Settings left nav is shown before clicking Mobi nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/My Team/UsersLeftNav'), "In home page, Users left nav is shown before clicking My Team nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/My Team/TeamsLeftNav'), "In home page, Teams left nav is shown before clicking My Team nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/My Team/InsightsLeftNav'), "In home page, Insights left nav is shown before clicking My Team nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Settings/AccountBasicsLeftNav'), "In home page, Account Basics left nav is shown before clicking Settings nav")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotVisible'(findTestObject('Object Repository/HomePageElements/Settings/LocationsLeftNav'), "In home page, Locations left nav is shown before clicking Settings nav")

/*
 * Click each left nav and verify the sub nav elements are visible
 */

WebUI.click(findTestObject('Object Repository/HomePageElements/VisitsLeftNav'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/Visits/DailyVisitsLeftNav'), "When click Visits lef nav the Daily visits options is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/Visits/EventsLeftNav'), "When click Visits lef nav the Events sub nav is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(findTestObject('Object Repository/HomePageElements/Visits/OffCampusLeftNav'), "When click Visits lef nav the Off campus sub nav is not shown")

Verify(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'), findTestObject('Object Repository/HomePageElements/Survey/SummaryLeftnav'), findTestObject('Object Repository/Survey-Admin App Objects/12MonthsTab'), 'Survey', 'Summary')
WebUI.delay(3)
Verify(null, findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYieldTab'), findTestObject('Object Repository/Survey-Admin App Objects/ApplicantsAndYield/AllReadyAppliedTab'), 'Survey', 'Appclicants & Yield')
WebUI.delay(3)
Verify(null, findTestObject('Object Repository/Survey-Admin App Objects/PerformanceTab'), findTestObject('Object Repository/Survey-Admin App Objects/Performance/DateRangeFilter'), 'Survey', 'Performancce')
WebUI.delay(3)
Verify(null, findTestObject('Object Repository/Survey-Admin App Objects/ResponseTab'), findTestObject('Object Repository/Survey-Admin App Objects/Response Page/DateRangeFilter'), 'Survey', 'Responses')
WebUI.delay(3)
Verify(null, findTestObject('Object Repository/Survey-Admin App Objects/Questions'), findTestObject('Object Repository/MobiPage/Questions/QuestionName'), 'Survey', 'Questions')
WebUI.delay(3)
//Verify(findTestObject('Object Repository/HomePageElements/MobiLeftNav'), findTestObject('Object Repository/HomePageElements/Mobi/Mobi-QuestionsLeftNav'), findTestObject('Object Repository/VisitTypesPage/Questions/GroupRadioButtonInQuestions'), 'Mobi', 'Mobi-Questions')
//
//Verify(null, findTestObject('Object Repository/HomePageElements/Mobi/Mobi-SettingsLeftNav'), findTestObject('Object Repository/MobiPage/GeneratePreviewButtonInMobi'), 'Mobi', 'Mobi-Settings')

Verify(findTestObject('Object Repository/HomePageElements/MyTeamLeftNav'), findTestObject('Object Repository/HomePageElements/My Team/InsightsLeftNav'), findTestObject('Object Repository/TeamManagement/Insights/DateRangeFilter'), 'My Team', 'Insights')

Verify(null, findTestObject('Object Repository/TeamManagement/UsersTab'), findTestObject('Object Repository/TeamManagement/InviteUserButtonInUsers'), 'My Team', 'Users')

Verify(null, findTestObject('Object Repository/TeamManagement/TeamsTab'), findTestObject('Object Repository/TeamManagement/Teams/CreateTeamButton'), 'My Team', 'Teams')

Verify(findTestObject('Object Repository/HomePageElements/SettingsLeftNav'), findTestObject('Object Repository/SettingsPage/LocationsTab'), findTestObject('Object Repository/SettingsPage/AddLocationButtonInLocaions'), 'Settings', 'Locations')

Verify(null, findTestObject('SettingsPage/AccountBasicsNav'), findTestObject('Object Repository/SettingsPage/Account Basics/EditButtonInInstitutionLogo'), 'Settings', 'Account Basics')






//def Verify(TestObject MainnavElement, TestObject subnavElement, TestObject ElementToVerifyNavigation, String MainNavName, String SubNavName)
//{
//	if(MainnavElement!=null)
//	{
//		WebUI.click(MainnavElement)
//	}
//	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementVisible'(subnavElement, "When click "+MainNavName+" lef nav the "+SubNavName+" sub nav is not shown")
//	WebUI.click(subnavElement)
//	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(ElementToVerifyNavigation, "When click "+SubNavName+" left nav, the "+SubNavName+" page is not opned")
//}










/*
 CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/VisitsLeftNav'), "Visits left nav is not present in the home page")
 WebUI.click(findTestObject('Object Repository/HomePageElements/VisitsLeftNav'))
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/Visits/DailyVisitsLeftNav'), "Daily visits left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/Visits/EventsLeftNav'), "Events left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/Visits/OffCampusLeftNav'), "Off Campus left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/VisitTypesLeftNav'), "Visit type left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/AnalyticsLeftNav'), "Analytics left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/MobiLeftNav'), "Mobi left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/PromoteIcon'), "Promote left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/MyTeamLeftNav'), "My Team left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/SettingsLeftNav'), "Settings left nav is not present in the home page")
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/VisitsLeftNav'), "Visits left nav is not present in the home page")
 WebUiBuiltInKeywords.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('VisitTypesPage/CreateVisitTypeButton'), "When click Visit type left nav the Create visit type button is not shown")
 WebUiBuiltInKeywords.click(findTestObject('HomePageElements/CalendarLeftNav'))
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Calendar/TodayButton'), "When click Calendar left nav, the calendar page is not opened")
 clickAndVerify(findTestObject('HomePageElements/Visits/DailyVisitsLeftNav'), findTestObject('DailyVisitsPage/CreateDailyVisitButton'), "When click Daily visits left nav, Create Daily visit button is not shown")
 clickAndVerify(findTestObject('HomePageElements/Visits/EventsLeftNav'), findTestObject('EventsPage/CreateEventButton'), "When click Events left nav, Create Event button is not shown")
 clickAndVerify(findTestObject('HomePageElements/Visits/OffCampusLeftNav'), findTestObject('OffCampusPage/CreateOffCampusButton'), "When click Off Campus left nav, Create Off Campus button is not shown")
 clickAndVerify(findTestObject('HomePageElements/AnalyticsLeftNav'), findTestObject('Object Repository/AnalyticsPage/ExportDataButtonInReports'), "When click Analytics left nav, the Analytics page is not opened")
 clickAndVerify(findTestObject('Object Repository/HomePageElements/SurveyLeftNav'), findTestObject('Object Repository/Survey-Admin App Objects/12MonthsTab'), "When click Surveys left nav, the Surveys page is not opened")
 clickAndVerify(findTestObject('HomePageElements/MobiLeftNav'), findTestObject('MobiPage/GeneratePreviewButtonInMobi'), "When click Mobi left nav, the Mobi page is not opened")
 clickAndVerify(findTestObject('HomePageElements/PromoteIcon'), findTestObject('Object Repository/PromotePage/CreateCampaignButton'), "When click Promote left nav, the Promote page is not opened")
 clickAndVerify(findTestObject('HomePageElements/MyTeamLeftNav'), findTestObject('TeamManagement/InviteUserButtonInUsers'), "When click My Team left nav, the My Team page is not opened")
 clickAndVerify(findTestObject('HomePageElements/SettingsLeftNav'), findTestObject('SettingsPage/AddLocationButtonInLocaions'), "When click Settings left nav, the Locations page is not opened")
 clickAndVerify(findTestObject('Object Repository/HomePageElements/VisitsLeftNav'), findTestObject('DailyVisitsPage/CreateDailyVisitButton'), "When click Daily visits left nav, the Locations page is not opened")
 def clickAndVerify(TestObject ElementToClick, TestObject ElementToVerify, String FailureDescription)
 {
 WebUI.click(ElementToClick)
 CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(ElementToVerify, FailureDescription)
 }
 */



