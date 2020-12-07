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

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamButton'), FailureHandling.STOP_ON_FAILURE)

Random Randvar = new Random()

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamNameTextBoxInCreateTeamPage'), (TeamName + ' ') + Randvar.nextInt(
        1000))

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamBioTextFieldInCreteTeamPage'), (TeamBio + ' ') + Randvar.nextInt(
        1000))

WebUI.click(findTestObject('TeamManagement/Teams/AddNowButtonInTeamPhotoDivisionInCreateTeamPage'))

String userDir = System.getProperty('user.dir')

WebUI.uploadFile(findTestObject('TeamManagement/Teams/UploadZoneInTeamPhotoDivisionInTeamDetailsPage'), userDir + '\\VisitTypePhoto\\AdminProfilePicture.png')

WebUI.click(findTestObject('TeamManagement/Teams/ApplyButtonInTeamPhotoDivisionInTeamDetalsPage'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/Teams/TeamPhotoInCreateTeamPage'), 0)

