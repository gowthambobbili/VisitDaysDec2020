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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String conventionName=CustomKeywords.'com.CommonUtilities.CreateNewConvention.createNewConventionWithUpcomingDates'()

WebUI.click(findTestObject('Object Repository/ConventionCurators/MyConventionsLeftNav'))

WebUI.waitForPageLoad(0)

WebUI.scrollToElement(findTestObject('Object Repository/ConventionCurators/ThreeDorMenuInConVentionsPageList',['ConventionName':conventionName]), 0, FailureHandling.OPTIONAL)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/ThreeDorMenuInConVentionsPageList',['ConventionName':conventionName]),0)

WebUI.delay(2)

if(!(WebUI.verifyElementPresent(findTestObject('ConventionCurators/ConventionStatsOptionInThreeDotMenu',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Convention stats ption is not shown after clicking on three dot menu")
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/LaunchCreatedConvention',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("launch option is not shown after clicking on three dot menu")
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/EditConvention',['ConventionName':conventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("edit option is not shown after clicking on three dot menu")
}
WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/EditConvention',['ConventionName':conventionName]),0)

String editedConventionName=CustomKeywords.'com.CommonUtilities.CreateNewConvention.editCreatedConvention'()

if(!(WebUI.verifyElementNotChecked(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AllowedRegistrantTypesHighSchoolCounselor'), 0)))
{
	KeywordUtil.markFailed("counselor checkbox is still in checked state even after edit")
}


if(!(WebUI.verifyElementNotChecked(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AllowedRegistrantsTypeParentOrGuardain'), 0)))
{
	KeywordUtil.markFailed("parent checkbox is still in checked state even after edit")
}

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

if(!(WebUI.verifyElementPresent(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':editedConventionName]),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("edited convention is not shown in the conventions app")
}


