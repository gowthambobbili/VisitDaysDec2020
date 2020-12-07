import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))

WebUI.click(findTestObject('Object Repository/PersonIconObjects/MyTeamOption'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'))

WebUI.click(findTestObject('Object Repository/TeamManagement/Teams/CreateTeamBtn'))

Random Randvar = new Random()

Randvariable = Randvar.nextInt(1000)

def TeamName = 'Team' + Randvariable

def TeamBio = 'Team is created' + Randvariable

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamNameTextBoxInCreateTeamPage'), TeamName)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamBioTextFieldInCreteTeamPage'), TeamBio)

WebUI.click(findTestObject('TeamManagement/Teams/AddLaterButtonInTeamPhotoDivisionInCreateTeamPage'))

WebUI.click(findTestObject('TeamManagement/Teams/AddMembersButtonInMembersDivision'))

WebUI.waitForElementVisible(findTestObject('TeamManagement/Teams/SearchFiledInmembers'), 0)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/SearchFiledInmembers'), 'test user1')

WebUI.click(findTestObject('TeamManagement/Teams/AddIconInAddTeamMembersModal'))

WebUI.click(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'))

//WebUI.verifyElementNotVisible(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'))
WebUI.waitForElementVisible(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'), 0)

WebUI.click(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'), FailureHandling.STOP_ON_FAILURE)

//WebUI.scrollToElement(findTestObject('TeamManagement/Teams/CreateTeamBtn'), 0)

WebUI.click(findTestObject('Object Repository/Teams1/CreateTeamButtonInTeams'))

//WebUI.verifyElementNotPresent(findTestObject('TeamManagement/Teams/CreateTeamBtn'), 0)

def Object = new TestObject('CreatedTeamInTeamList')

Object.addProperty('xpath', ConditionType.EQUALS, ('//div[text()=\'' + TeamName) + '\']')

if (!(WebUI.verifyElementPresent(Object, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The created team is not shown in the Teams list')

	WebUI.takeScreenshot()
}
CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

if (WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'), 15, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('DailyVisitsPage/ShowFiltersButtonInDailyVisitsPage'))
}

WebUI.click(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'))

def object2 = new TestObject('Created team in User assigned filter')

object2.addProperty('xpath', ConditionType.EQUALS, ('//li[text()=\'' + TeamName) + '\']')

if (!(WebUI.verifyElementPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('The created tema is not shown in the user assigned filter of Daily visit page')
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.click(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'))

if (!(WebUI.verifyElementPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('The created tema is not shown in the user assigned filter of Daily visit page')
}
CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.click(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'))

if (!(WebUI.verifyElementPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('The created tema is not shown in the user assigned filter of Events page')
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.click(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'))

if (!(WebUI.verifyElementPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('The created tema is not shown in the user assigned filter of Off-Campus page')
}

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))

WebUI.click(findTestObject('Object Repository/PersonIconObjects/MyTeamOption'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'))


WebUI.click(Object)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Teams/DeleteTeamButtonInTeamDetailsPage'), 0)

WebUI.click(findTestObject('TeamManagement/Teams/DeleteTeamButtonInTeamDetailsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(4)

WebUI.verifyElementPresent(findTestObject('TeamManagement/Teams/DeleteButtonInDeleteTeamPopup'), 0)

WebUI.waitForElementVisible(findTestObject('TeamManagement/Teams/DeleteButtonInDeleteTeamPopup'), 0)

WebUI.click(findTestObject('TeamManagement/Teams/DeleteButtonInDeleteTeamPopup'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('TeamManagement/Teams/DeleteButtonInDeleteTeamPopup'), 0)

WebUI.waitForElementPresent(findTestObject('TeamManagement/Teams/CreateTeamButton'), 0)

if (!(WebUI.verifyElementNotPresent(Object, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The delted team is shown in the Teams list')

	WebUI.takeScreenshot()
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

WebUI.click(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'))

WebUI.delay(2)

if (!(WebUI.verifyElementNotPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('The Deleted team is still shown in the user assigned filter of Daily visit page')
}

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToEvents'()

WebUI.click(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'))

WebUI.delay(2)

if (!(WebUI.verifyElementNotPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('The Deleted team is still shown in the user assigned filter of Events page')
}


CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToOffCampus'()

WebUI.click(findTestObject('DailyVisitsPage/UserAssignedFilterInIndexPage'))

WebUI.delay(2)

if (!(WebUI.verifyElementNotPresent(object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailedAndStop('The Deleted team is still shown in the user assigned filter of Off-Campus page')
}

