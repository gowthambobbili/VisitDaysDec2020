import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.concurrent.locks.Condition as Condition
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

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamButton'), FailureHandling.STOP_ON_FAILURE)

Random Randvar = new Random()

Randvariable = Randvar.nextInt(1000)

def TeamName = 'Team' + Randvariable

def TeamBio = 'Team is created' + Randvariable

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamNameTextBoxInCreateTeamPage'), TeamName)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamBioTextFieldInCreteTeamPage'), TeamBio)

WebUI.click(findTestObject('TeamManagement/Teams/AddLaterButtonInTeamPhotoDivisionInCreateTeamPage'))

WebUI.scrollToElement(findTestObject('TeamManagement/Teams/AddMembersButtonButtonInCreateTeamButton'), 0)

WebUI.click(findTestObject('Object Repository/Teams1/CreateTeamButtonInTeams'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Teams/FirstUserNameInAddMembersToTeamModal'),
		'There are no users shown in the \'Add Team Members modal\' to add')

def ImageSrc = null

def TeamMemberShortName

if(WebUI.verifyElementPresent(findTestObject('Object Repository/TeamManagement/Teams/ImageFieldOfTeamMemberWhileAddingMembersToTeam'), 5, FailureHandling.OPTIONAL))
{
	ImageSrc = WebUI.getAttribute(findTestObject('Object Repository/TeamManagement/Teams/ImageFieldOfTeamMemberWhileAddingMembersToTeam'), "src")
}
else
{
	TeamMemberShortName = WebUI.getText(findTestObject('TeamManagement/Teams/NameOnProfileOfFirstUserInAddTeamMembersModal'))
}

WebUI.click(findTestObject('TeamManagement/Teams/FirstUserInAddTeamMembersList'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'),
		'Done button is not present in the \'Add Team Members\' modal')

WebUI.click(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'))
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'),
		'After clicking Done button in Add Members modal the modal is not getting closed')

WebUI.waitForElementNotVisible(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'),
		'Select All button is not present in Notification Preferance division while creating Team')

WebUI.delay(2)

WebUI.click(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'))
CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Teams/CreateTeamBtn'),
		'Create Team button is not present in create a team page')
WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamBtn'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('TeamManagement/Teams/CreateTeamBtn'),
		'After entering all the fields and clicking the \'Create Team\' button, Create team page is still shown and the team is not getting closed')

WebUI.waitForElementPresent(findTestObject('TeamManagement/Teams/CreateTeamButton'), 0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/TeamManagement/Teams/TeamInTeamsList(TeamName)', ["TeamName":TeamName]), "The created team is not present in the Teams page")

if(ImageSrc==null)
{
	def TeamMemberSHortNameInTeamsPage = WebUI.getText(findTestObject('Object Repository/TeamManagement/Teams/TeamMemberShortNameInTeamsPage(TeamName)', ["TeamName":TeamName]))
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(TeamMemberSHortNameInTeamsPage, TeamMemberShortName, "The team member profile which is added while creating the team is not shown on the team in Teams page")
}
else
{
	def ImageSrcOfTeamMemberInTeamsPage = WebUI.getAttribute(findTestObject('Object Repository/TeamManagement/Teams/TeamMemberProfilePictureSrc(TeamName)', ["TeamName":TeamName]), "src")
	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ImageSrcOfTeamMemberInTeamsPage, ImageSrc, "The team member profile which is added while creating the team is not shown on the team in Teams page")
}

