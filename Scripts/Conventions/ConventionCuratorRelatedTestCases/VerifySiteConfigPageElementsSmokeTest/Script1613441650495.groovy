import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.CommonUtilities.Verifications
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

Verifications verify = new Verifications()

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'),0,FailureHandling.OPTIONAL))
 {
	WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

	WebUI.waitForPageLoad(0)
 }
 WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionSettingsLeftNav'))
 
 WebUI.delay(2)
 
 WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPageLeftNav'))
 
 WebUI.waitForPageLoad(0)
 
 def rootPath = "Object Repository/ConventionCurators/SiteConfigurationPage/"
 
 List homeElements= [
	 "Home page tab",
	 "Individual Convention Pages tab",
	 "Show Custom Label switch",
	 "Show custom headline on home page",
	 "Show custom messaging in tabs of convention pages"
	 ]
 for(element in homeElements) {
	 verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the My Account page the "+element+" is not present")
 }
 WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Individual Convention Pages tab'))
	 
 WebUI.delay(2)
 
 List individualConventionpageElements= [
	 "Show custom messaging in tabs of convention pages",
]
 for(element in individualConventionpageElements) {
	 verify.VerifyElementPresentAndStopExecutionIfFailed(findTestObject(rootPath+element),"In the My Account page the "+element+" is not present")
 }
// WebUI.click(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Videos Tab'))
// 
// WebUI.delay(2)
//
// if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/SiteConfigurationPage/Show filters for videos tab'),0,FailureHandling.OPTIONAL)))
// {
//	 KeywordUtil.markFailed("show filters for videos on/of switch is not shown in conventions page")
// }
 