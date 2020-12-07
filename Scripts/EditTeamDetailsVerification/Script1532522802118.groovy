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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import java.util.Random

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))

WebUI.click(findTestObject('Object Repository/PersonIconObjects/MyTeamOption'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'))

WebUI.click(findTestObject('Object Repository/TeamManagement/Teams/CreateTeamBtn'))

Random rd=new Random()

int num=rd.nextInt(1000)

def TeamName="TestTeam"+" "+num

WebUI.sendKeys(findTestObject('Object Repository/Teams1/TeamNameTextFeild'),TeamName)

WebUI.sendKeys(findTestObject('Object Repository/Teams1/TeamBioTextFeild'),"this is test bio")

WebUI.click(findTestObject('Object Repository/Teams1/AddLaterButtonInTeamsPhoto'))

WebUI.click(findTestObject('Object Repository/Teams1/AddTeamMembersButton'))

//WebUI.switchToFrame(findTestObject('Object Repository/Teams1/AddTeamMembersFrameAddress'), 0)

WebUI.sendKeys(findTestObject('Object Repository/Teams1/SearchUsersTextFieild'), "mahes")

WebUI.click(findTestObject('Object Repository/Teams1/PlusAddSymbolinFrame'))

WebUI.click(findTestObject('Object Repository/Teams1/DoneButtonInTeams'))

//WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Teams1/SelectAllInNotificationPreferences'))
findTestObject('Object Repository/Teams1/SelectTeam')
WebUI.click(findTestObject('Object Repository/Teams1/CreateTeamButtonInTeams'))

WebUI.click(findTestObject('Object Repository/Teams1/SelectTeam'))

WebUI.click(findTestObject('Object Repository/TeamManagement/Teams/EditButtonInTeamNameField'))

WebUI.click(findTestObject('Object Repository/TeamManagement/Teams/SaveButtonInTeamDetailsPage'))




