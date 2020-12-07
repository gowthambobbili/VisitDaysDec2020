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

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToUsers'()

WebUI.click(findTestObject('Object Repository/TeamManagement/Users/FirstuserThreedotMenuInUsers'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Users/ChangePermissionLevelIcon'), "When click three dot menu of a user in users list, change permissions option is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Users/DeactivateUserOption'), "When click three dot menu of a user in users list, change permissions option is not shown")

WebUI.click(findTestObject('TeamManagement/Users/ChangePermissionLevelIcon'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Users/ChangePermissionsModal'), "When click Change permissions options the Change permissions modal is not shown")

WebUI.click(findTestObject('TeamManagement/Users/CancelButtonInChangePermissionsModal'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('TeamManagement/Users/CancelButtonInChangePermissionsModal'), "When click Cancel button in Change permissions modal, the modal is not getting closed")

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/TeamManagement/Users/FirstuserThreedotMenuInUsers'))

WebUI.click(findTestObject('TeamManagement/Users/DeactivateUserOption'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('TeamManagement/Users/DeactivatUserModal'), "When click Deativate user option, the Deactivate user modal is not shown")

WebUI.click(findTestObject('TeamManagement/Users/CancelButtonInDeactivateUserModal'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('TeamManagement/Users/CancelButtonInChangePermissionsModal'), "When click Cancel button in Deactivate User modal, the modal is not getting closed")









//}

