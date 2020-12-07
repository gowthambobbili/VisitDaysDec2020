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

WebUI.click(findTestObject('HomePageElements/ProfileAvatar'))

WebUI.click(findTestObject('ElementsUnderProfileAvatar/MyProfileOption'))

ActualFirstName = WebUI.getText(findTestObject('TeamManagement/Users/FirstNameInUserProfile'))

ActualLastName = WebUI.getText(findTestObject('TeamManagement/Users/LastNameInUserProfile'))

WebUI.click(findTestObject('TeamManagement/Users/EditButtonInUsreProfile'))

WebUI.clearText(findTestObject('TeamManagement/Users/FirstNameTextFieldInUserProfile'))

Random name = new Random()

String EditedFirstName = 'First name' + name.nextInt(500)

WebUI.sendKeys(findTestObject('TeamManagement/Users/FirstNameTextFieldInUserProfile'), EditedFirstName)

String EditedLastName = 'Last name' + name.nextInt(500)

WebUI.clearText(findTestObject('TeamManagement/Users/LastNameTextFieldInUserProfile'))

WebUI.sendKeys(findTestObject('TeamManagement/Users/LastNameTextFieldInUserProfile'), EditedLastName)

WebUI.clearText(findTestObject('TeamManagement/Users/RoleTextFieldInUserProfile'))

String Role = 'Role' + name.nextInt(500)

WebUI.sendKeys(findTestObject('TeamManagement/Users/RoleTextFieldInUserProfile'), Role)

WebUI.clearText(findTestObject('TeamManagement/Users/BioTextAreaInUserProfile'))

WebUI.sendKeys(findTestObject('TeamManagement/Users/BioTextAreaInUserProfile'), 'Test Bio')

WebUI.click(findTestObject('TeamManagement/Users/SaveButtonInUserProfile'))

WebUI.waitForElementNotPresent(findTestObject('TeamManagement/Users/SaveButtonInUserProfile'), 0)

WebUI.waitForElementPresent(findTestObject('TeamManagement/Users/EditButtonInUsreProfile'), 0)

WebUI.verifyElementText(findTestObject('TeamManagement/Users/FirstNameInUserProfile'), EditedFirstName)

WebUI.verifyElementText(findTestObject('TeamManagement/Users/LastNameInUserProfile'), EditedLastName)

WebUI.verifyElementText(findTestObject('TeamManagement/Users/RoleInUserProfile'), Role)

WebUI.verifyElementText(findTestObject('TeamManagement/Users/BioInUserProfile'), 'Test Bio')

WebUI.click(findTestObject('TeamManagement/Users/EditButtonInUsreProfile'))

WebUI.clearText(findTestObject('TeamManagement/Users/FirstNameTextFieldInUserProfile'))

WebUI.sendKeys(findTestObject('TeamManagement/Users/FirstNameTextFieldInUserProfile'), ActualFirstName)

WebUI.clearText(findTestObject('TeamManagement/Users/LastNameTextFieldInUserProfile'))

WebUI.sendKeys(findTestObject('TeamManagement/Users/LastNameTextFieldInUserProfile'), ActualLastName)

WebUI.click(findTestObject('TeamManagement/Users/SaveButtonInUserProfile'))

WebUI.waitForElementNotPresent(findTestObject('TeamManagement/Users/SaveButtonInUserProfile'), 0)

WebUI.waitForElementPresent(findTestObject('TeamManagement/Users/EditButtonInUsreProfile'), 0)

