import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.SelfServeUtilities.LoginToSelfServeTool'()

WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+GlobalVariable.Institution+'/institution_settings')

WebUI.waitForPageLoad(10)

def Button = WebUI.getText(findTestObject('Self serve objects/ButtonNameoFGivenSetting(setting)', ["setting": "messenger"])).trim().toLowerCase()

if(Button=='create')
{
	WebUI.click(findTestObject('Self serve objects/ButtonNameoFGivenSetting(setting)', ["setting": "messenger"]))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Self serve objects/InstitutionSettingHeader(setting)', ["setting":'messenger']), "When click 'Create' button in the messenger institution setting, the Messenger header is not shown")

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), "When click Create button of Messenger institution setting the value text box is not present")

	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/FlagValueDropdown'), 'true')

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "Create insitution setting button is not present in the While cretating Messenger setting")

	WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'))

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresentStopExecutionIfFailed'(findTestObject('Object Repository/Self serve objects/UpdateInstitutionSettingButton'), "When click Create institution button the button is not getting disappeared and the setting is not getting created")

	def ButtonNameAfterCreating = WebUI.getText(findTestObject('Self serve objects/ButtonNameoFGivenSetting(setting)', ["setting": "messenger"])).trim().toLowerCase()

	CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(ButtonNameAfterCreating, 'edit', "After creating messenger institution setting in the self-serve, the Edit button is not shown for the setting")

}