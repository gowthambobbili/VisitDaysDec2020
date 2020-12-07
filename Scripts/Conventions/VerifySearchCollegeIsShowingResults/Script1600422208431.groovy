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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateMeeting.getConvention'()

def institutionName=CustomKeywords.'com.CommonUtilities.VideoLibrary.getInstitutionName'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.delay(5)

WebElement element = WebUiCommonHelper.findWebElement(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.delay(4)

WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/HomePageElements/SearchByCollege'),institutionName)

WebUI.delay(4)

if(!(WebUI.verifyElementPresent(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]),, 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("the searched college is not shown means search functionality may not working in colleges tab")
}