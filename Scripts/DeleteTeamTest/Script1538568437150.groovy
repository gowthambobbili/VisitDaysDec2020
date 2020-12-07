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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamButton'), FailureHandling.STOP_ON_FAILURE)

Random Randvar = new Random()

String NameOfTheTeam = (TeamName + ' ') + Randvar.nextInt(1000)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamNameTextBoxInCreateTeamPage'), NameOfTheTeam)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamBioTextFieldInCreteTeamPage'), TeamBio)

WebUI.click(findTestObject('TeamManagement/Teams/AddLaterButtonInTeamPhotoDivisionInCreateTeamPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/Teams/AddMembersButtonButtonInCreateTeamButton'), FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('TeamManagement/Teams/FirstUserInAddTeamMembersList'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'), 0)

WebUI.click(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/TeamsTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('TeamManagement/Teams/CreateTeamButton'), 0)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/SearchTeamsSearchBox'), NameOfTheTeam)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/TeamManagement/Teams/FirstTeamInTeamsList'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/Teams/DeleteTeamButtonInTeamDetailsPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('TeamManagement/Teams/DeleteButtonInDeleteTeamPopup'), 0)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('TeamManagement/Teams/SearchBoxInTeamsTab'), 0)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/SearchTeamsSearchBox'), NameOfTheTeam)

WebUI.delay(3)

WebUI.verifyElementNotPresent(findTestObject('TeamManagement/Teams/FirstTeamInTeamsList'), 0)

