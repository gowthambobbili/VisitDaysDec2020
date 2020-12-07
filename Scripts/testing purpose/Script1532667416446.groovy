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
import org.openqa.selenium.remote.server.DefaultDriverFactory as DefaultDriverFactory
import org.openqa.selenium.By as By

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

WebUI.waitForElementPresent(findTestObject('SettingsPage/AccountBasicsNav'), 0)

WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))

WebUI.waitForElementPresent(findTestObject('SettingsPage/Account Basics/EditButtonInInstitutionLogo'), 0)

WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInInstitutionLogo'), FailureHandling.STOP_ON_FAILURE)

String userDir = System.getProperty('user.dir')

WebUI.uploadFile(findTestObject('Object Repository/ElementsUnderProfileAvatar/My Profile/UploadZoneInAdminProfilePhoto'), 
    userDir + '\\VisitTypePhoto\\albright college.png')
 
WebUI.delay(2)

WebUI.verifyImagePresent(findTestObject('testing purpose'))

