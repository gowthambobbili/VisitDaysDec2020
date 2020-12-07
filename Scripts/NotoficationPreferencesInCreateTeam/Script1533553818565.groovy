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
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/TeamManagement/TeamsTab'))

WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamButton'), FailureHandling.STOP_ON_FAILURE)
//
Random Randvar = new Random()
//
Randvariable = Randvar.nextInt(1000)
//
def TeamName = 'Team' + Randvariable
//
def TeamBio = 'Team is created' + Randvariable
//
WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamNameTextBoxInCreateTeamPage'), TeamName)
//
WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamBioTextFieldInCreteTeamPage'), TeamBio)
//
WebUI.click(findTestObject('TeamManagement/Teams/AddLaterButtonInTeamPhotoDivisionInCreateTeamPage'))
//
WebUI.scrollToElement(findTestObject('TeamManagement/Teams/AddMembersButtonInMembersDivision'), 0)
//
WebUI.click(findTestObject('TeamManagement/Teams/AddMembersButtonButtonInCreateTeamButton'))
//
WebUI.waitForElementVisible(findTestObject('TeamManagement/Teams/SearchFiledInmembers'), 0)
//
WebUI.sendKeys(findTestObject('TeamManagement/Teams/SearchFiledInmembers'), 'test user1')
//
WebUI.delay(2)

//WebUI.click(findTestObject('Object Repository/Teams1/DoneButtonInTeams'))
//
//WebUI.click(findTestObject('TeamManagement/Teams/TestUser2InMembers'))
//
WebUI.click(findTestObject('TeamManagement/Teams/AddingIconInMembersInTeamCreation'))
//
WebUI.click(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'))
//
WebUI.waitForElementNotPresent(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'), 0)
//
WebUI.delay(2)
//
WebUI.waitForElementVisible(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'), 0)
//
WebUI.click(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'))
//
WebUI.click(findTestObject('Object Repository/Teams1/CreateTeamButtonInTeams'))
//
//WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamBtn'))
//
