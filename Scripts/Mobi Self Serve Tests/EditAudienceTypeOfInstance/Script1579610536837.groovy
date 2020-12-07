import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.MobiInstance.goToMobiScriptPage'()

def instanceDetails = CustomKeywords.'com.CommonUtilities.MobiInstance.createInstanceUsingApi'()

def instanceName = instanceDetails.instanceName

def instanceId = instanceDetails.id

WebUI.refresh()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.MobiInstance.selectAudience'("ind")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/UncheckedIndividualsCheckbox'), "While editing an instance, when disable the individual checkbox and click save button, the checkbox is still active")

CustomKeywords.'com.CommonUtilities.MobiInstance.selectAudience'("ind")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/IndividualsCheckbox'), "While editing an instance, when Enabled the individual checkbox and click save button, the checkbox is still active")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/GroupsCheckBox'), "While editing an instance with only groups audience, when Enabled the individual checkbox and click save button, the Groups checkbox is unchecked")

//Both -> Only groups

CustomKeywords.'com.CommonUtilities.MobiInstance.selectAudience'("grp")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/IndividualsCheckbox'), "While editing an instance with both audience, when disabled the group checkbox and click save button, the individual checkbox also unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementNotChecked'(findTestObject('Object Repository/MobiPage/Script/GroupsCheckBox'), "Whilie editing an instance with both audience, when unchecked the group checkbox and click save button, the groups checkbox is still shown as unchecked")









