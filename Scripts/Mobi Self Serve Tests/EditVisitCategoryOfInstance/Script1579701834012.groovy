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

CustomKeywords.'com.CommonUtilities.MobiInstance.selectvisitCategory'("event")

CustomKeywords.'com.CommonUtilities.MobiInstance.selectvisitCategory'("off")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), "While editing an instance with all visit categories, When disable the Event and Teavel checkboxes and click Save button, the Daily checkbox also shown as unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementNotChecked'(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), "While editing an instance with all visit categories, When disable the Event and Teavel checkboxes and click Save button, the Event checkbox also shown as checked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementNotChecked'(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), "While editing an instance with all visit categories, When disable the Event and Teavel checkboxes and click Save button, the Travel checkbox also shown as checked")

CustomKeywords.'com.CommonUtilities.MobiInstance.enableVisitTypeCategory'("all")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), "While editing an instance with Daily visit category, When enable remaining two checkboxes and click Save button then the Daily checkbox is unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), "While editing an instance with Daily visit category, When enable remaining two checkboxes and click Save button then the Event checkbox is shown as unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), "While editing an instance with Daily visit category, When enable remaining two checkboxes and click Save button then the Travel checkbox is shown as unchecked")

// All -> Event

CustomKeywords.'com.CommonUtilities.MobiInstance.selectvisitCategory'("daily")

CustomKeywords.'com.CommonUtilities.MobiInstance.selectvisitCategory'("off")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementNotChecked'(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), "While editing an instance with all visit categories, When disbale Daily and Travel checkboxes and click Save button then the Daily checkbox is shown as checked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), "While editing an instance with all visit categories, When disbale Daily and Travel checkboxes and click Save button then the Event checkbox is shown as Unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementNotChecked'(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), "While editing an instance with all visit categories, When disbale Daily and Travel checkboxes and click Save button then the Travel checkbox is shown as checked")

CustomKeywords.'com.CommonUtilities.MobiInstance.enableVisitTypeCategory'("all")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), "While editing an instance with Event visit category, When enable remaining two checkboxes and click Save button then the Daily checkbox is unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), "While editing an instance with Event visit category, When enable remaining two checkboxes and click Save button then the Event checkbox is shown as unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), "While editing an instance with Event visit category, When enable remaining two checkboxes and click Save button then the Travel checkbox is shown as unchecked")

//All to Travel

CustomKeywords.'com.CommonUtilities.MobiInstance.selectvisitCategory'("daily")

CustomKeywords.'com.CommonUtilities.MobiInstance.selectvisitCategory'("event")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementNotChecked'(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), "While editing an instance with all visit categories, When disbale Daily and Event checkboxes and click Save button then the Daily checkbox is shown as checked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), "While editing an instance with all visit categories, When enable remaining two checkboxes and click Save button then the Event checkbox is shown as Unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementNotChecked'(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), "While editing an instance with all visit categories, When enable remaining two checkboxes and click Save button then the Travel checkbox is shown as checked")

CustomKeywords.'com.CommonUtilities.MobiInstance.enableVisitTypeCategory'("all")

CustomKeywords.'com.CommonUtilities.MobiInstance.clickSaveButton'()

CustomKeywords.'com.CommonUtilities.MobiInstance.clickThreeDotMenu'(instanceName, instanceId)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Script/SaveButton'), "When click Edit button for an instance, the save button is not shown")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/DailyCheckbox'), "While editing an instance with Event visit category, When enable remaining two checkboxes and click Save button then the Daily checkbox is unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/EventCheckbox'), "While editing an instance with Event visit category, When enable remaining two checkboxes and click Save button then the Event checkbox is shown as unchecked")

CustomKeywords.'com.CommonUtilities.Verifications.verifyElementChecked'(findTestObject('Object Repository/MobiPage/Script/TravelCheckbox'), "While editing an instance with Event visit category, When enable remaining two checkboxes and click Save button then the Travel checkbox is shown as unchecked")





