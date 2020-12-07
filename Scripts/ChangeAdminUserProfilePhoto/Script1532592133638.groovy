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

WebUI.waitForElementPresent(findTestObject('ElementsUnderProfileAvatar/My Profile/ChangePictureFieldInAdminProfile'), 0)

WebUI.waitForElementClickable(findTestObject('ElementsUnderProfileAvatar/My Profile/ChangePictureFieldInAdminProfile'), 
    0)

WebUI.delay(2)

WebUI.mouseOver(findTestObject('ElementsUnderProfileAvatar/My Profile/ChangePictureFieldInAdminProfile'))

WebUI.click(findTestObject('ElementsUnderProfileAvatar/My Profile/ChangePictureFieldInAdminProfile'))

String userDir = System.getProperty('user.dir')

println(userDir + '\\VisitTypePhoto\\albright college.png')

WebUI.uploadFile(findTestObject('Object Repository/ElementsUnderProfileAvatar/My Profile/UploadZoneInAdminProfilePhoto'), 
    userDir + '\\VisitTypePhoto\\AdminProfilePicture.png')

WebUI.click(findTestObject('ElementsUnderProfileAvatar/My Profile/ApplyButtonInAdminProfilePhotoUploadPopup'))

WebUI.waitForElementPresent(findTestObject('ElementsUnderProfileAvatar/My Profile/ProfilePictureSavedFlashMessage'), 0)

WebUI.click(findTestObject('ElementsUnderProfileAvatar/My Profile/ProfilePictureSavedFlashMessage'), FailureHandling.STOP_ON_FAILURE)


