import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After as After
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('HomePageElements/SwitchAccountsIcon'),
		"Switch Account icon is not present in the home page")

def CurrentInstitutionName = (WebUI.getText(findTestObject('Object Repository/HomePageElements/CurrentInstitutionName')).split("swap_horiz")[0]).trim()

WebUI.click(findTestObject('HomePageElements/SwitchAccountsIcon'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/SwitchAccountsModal'), "When click Switch Accounts icon, the Switch Accounts modal is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/CloseButton(X)'), "In the Switch accounts modal Close(X) button is not present")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/InstitutionInSwitchAccountsModal(institution)', ["institution":CurrentInstitutionName]), "The current active institution is not present in the Switch accounts modal")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/SelectedInsitution(institution)', ["institution":CurrentInstitutionName]), "In Switch Institutions modal, Check mark is not shown for the current active institution")


CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/SearchAccountsTextbox'), "Search Accounts search box is not present in the Switch institution modal")

WebUI.click(findTestObject('Object Repository/HomePageElements/Switch Account Objects/CloseButton(X)'))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/SwitchAccountsModal'), "When click CLose(X) button in Switch accounts modal the modal is not getting closed")

WebUI.waitForElementVisible(findTestObject('Object Repository/HomePageElements/SwitchAccountsIcon'), 0)

WebUI.click(findTestObject('Object Repository/HomePageElements/SwitchAccountsIcon'))

def InstituteToChange = WebUI.getText(findTestObject('HomePageElements/Switch Account Objects/FirstAccountOtherThanActive(currentInstitution)', ["currentInstitution":CurrentInstitutionName]))

WebUI.delay(3)

WebUI.click(findTestObject('HomePageElements/Switch Account Objects/FirstAccountOtherThanActive(currentInstitution)', ["currentInstitution":CurrentInstitutionName]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/SwitchAccountsModal'), "When select a institution in the Switch institution modal, the modal is not getting closed and the institution is not getting changed")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/SwitchAccountsIcon'), "After switching the account the Switch accounts icon is not in the home page")

WebUI.delay(15)

def InstitutionAfterSwitching = WebUI.getText(findTestObject('Object Repository/HomePageElements/CurrentInstitutionName').split("swap_horiz")[0]).trim()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(InstitutionAfterSwitching, InstituteToChange, "When select the institution "+InstituteToChange+" in the Switch account modal the insitution is not getting changed")

WebUI.click(findTestObject('Object Repository/HomePageElements/SwitchAccountsIcon'))

WebUI.waitForElementPresent(findTestObject('Object Repository/HomePageElements/Switch Account Objects/SwitchAccountsModal'), 0)

WebUI.click(findTestObject('Object Repository/HomePageElements/Switch Account Objects/InstitutionInSwitchAccountsModal(institution)', ["institution":CurrentInstitutionName]))

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/Switch Account Objects/SwitchAccountsModal'), "When select a institution in the Switch institution modal, the modal is not getting closed and the institution is not getting changed")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/HomePageElements/SwitchAccountsIcon'), "After switching the account the Switch accounts icon is not in the home page")

InstitutionAfterSwitching = WebUI.getText(findTestObject('Object Repository/HomePageElements/CurrentInstitutionName').split("swap_horiz")[0]).trim()

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(InstitutionAfterSwitching, CurrentInstitutionName, "When select the institution "+CurrentInstitutionName+" in the Switch account modal the insitution is not getting changed")




