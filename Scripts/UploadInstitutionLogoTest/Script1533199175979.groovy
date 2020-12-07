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

//WebUI.click(findTestObject('HomePageElements/SettingsLeftNav'))

WebUI.click(findTestObject('Object Repository/PersonIconObjects/PersonIcon'))

WebUI.click(findTestObject('Object Repository/SettingsPage/Settings'))

WebUI.click(findTestObject('SettingsPage/AccountBasicsNav'))

WebUI.waitForElementPresent(findTestObject('SettingsPage/Account Basics/EditButtonInInstitutionLogo'), 0)

WebUI.click(findTestObject('SettingsPage/Account Basics/EditButtonInInstitutionLogo'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('SettingsPage/Account Basics/UploadNewButtoninInstitutionLogoDivision'),
		'Upload new button is not present in Institution Logo division division in ;Account Basics page')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('SettingsPage/Account Basics/RemovePhotoButtonInInstitutionLogoDivision'),
		'Remove photo button is not present in Institution logo division ')

WebUI.click(findTestObject('SettingsPage/Account Basics/RemovePhotoButtonInInstitutionLogoDivision'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('SettingsPage/Account Basics/UploadButtonInInstitutionLogoDivision'),
		'After removing the institution logo Upload button is not shown in institution logo division')

not_run: WebUI.click(findTestObject('SettingsPage/Account Basics/UploadNewButtoninInstitutionLogoDivision'))

String userDir = System.getProperty('user.dir')

WebUI.uploadFile(findTestObject('SettingsPage/Account Basics/UploadZoneInInstitutionLogoDivision'), userDir + '\\VisitTypePhoto\\albright college.png')

WebUI.click(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('SettingsPage/Account Basics/SaveButtonInAccountBasicsDivision'), "In Account basics, after uploading the Institution logo and click Save button the button is not getting disabled and the modifications are not getting saved")

WebUI.verifyElementPresent(findTestObject('SettingsPage/Account Basics/InstitutionLogoInInstitutionLogoDivision'), 0)

