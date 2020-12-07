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

not_run: String VisitType = WebUI.callTestCase(findTestCase('Reusable Test Cases/GetExistingDailyVisitOrCreateANewDailyVisit'), 
    [:], FailureHandling.STOP_ON_FAILURE)

VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 
    'Add Registrant button not present in registrants tab of the visit')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

List<String> GroupResponces = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddGroupDirectlyToAVisitAndReturnResponces'()

String GroupLeaderSecondName = GroupResponces.get(0)

String GroupLeaderFirstName = 'Test'

String GroupLeaderFullName = (GroupLeaderFirstName + ' ') + GroupLeaderSecondName

String GroupLeaderEmail = GroupResponces.get(1)

String OrgName = GroupResponces.get(2)

WebUI.sendKeys(findTestObject('HomePageElements/GlobalSearchBox'), GroupLeaderEmail)

def GroupEmail = new TestObject('Group email search result in global search box')

GroupEmail.addProperty('xpath', ConditionType.EQUALS, ('//div[@class="search-subheader"]//strong[text()="' + GroupLeaderEmail) + 
    '"]')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(GroupEmail, 'After entering group email in gloabl srarch box the search results are not shown')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

List<String> IndividualResponces = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisitAndReturnAllAnswers'()

String SecondName = IndividualResponces.get(0)

String FirstName = 'Test'

String FullName = (FirstName + ' ') + SecondName

String Email = IndividualResponces.get(1)

println(Email)

println(FullName)

WebUI.sendKeys(findTestObject('HomePageElements/GlobalSearchBox'), FullName)

def IndividualEmail = new TestObject('Individual email search result in global search box')

IndividualEmail.addProperty('xpath', ConditionType.EQUALS, ('//div[@class="search-header"]//strong[text()="' + FullName) + 
    '"]')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(IndividualEmail, 'After entering Individual student email in gloabl srarch box, the search results are not shown')

WebUI.clearText(findTestObject('HomePageElements/GlobalSearchBox'))

WebUI.sendKeys(findTestObject('HomePageElements/GlobalSearchBox'), Email)

def IndividualName = new TestObject('Individual name search result in global search box')

IndividualName.addProperty('xpath', ConditionType.EQUALS, ('//div[@class="search-subheader"]//strong[text()="' + Email) + 
    '"]')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(IndividualName, 'After entering Individual student full name in gloabl search box, the search results are not shown')

