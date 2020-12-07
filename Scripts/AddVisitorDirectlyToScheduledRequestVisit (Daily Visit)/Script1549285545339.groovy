import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateRequestVisitType'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateRequestDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/AddRegistrantButtonButtonForRequestVisit'), 
    'Add Registrant button is not present in the scheduled (request) visit')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonButtonForRequestVisit'))

CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

WebUI.click(findTestObject('DailyVisitsPage/ScheduleButtonOnFirstRequestUnderPendingTab'))

CustomKeywords.'com.CommonUtilities.ScheduleMethods.ScheduleARequest'()

WebUI.delay(4)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/InstantBookRadioButtonInRegistationMethodFilter'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 
    'After scheduling a visit the visit is not shown in the index page')

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 
    'Add Registrant button is not present in the scheduled (request) visit')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String IndividualRegistrant = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def RegistereIndividual = new TestObject('Registered individual user in Registered list')

RegistereIndividual.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + 
    IndividualRegistrant) + '\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(RegistereIndividual, 'When added an indivudal directly to a scheduled (request) visit then the user is not shown in  the Registered list')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Group = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

CustomKeywords.'com.CommonUtilities.NewMobiRegistration.switchToDefaultContent'()

def RegisteredGroup = new TestObject('Registered group in Registered list')

RegisteredGroup.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + Group) + 
    '\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(RegisteredGroup, 'When added a group directly to a scheduled (request) visit then the group is not shown in  the Registered list')

not_run: String TextOnRegisteredTab = WebUI.getText(findTestObject('DailyVisitsPage/RegisteredTab'))

not_run: TextOnRegisteredTab = (TextOnRegisteredTab.trim().split(' (')[1].split(') ')[0])

not_run: println(TextOnRegisteredTab)

not_run: CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(TextOnRegisteredTab, '2', 'When added an inddividual directly to a scheduled (request) visit then the count on the Registered tab is shown in correct, Expected count: 2, Actual count: ' + 
    TextOnRegisteredTab)

