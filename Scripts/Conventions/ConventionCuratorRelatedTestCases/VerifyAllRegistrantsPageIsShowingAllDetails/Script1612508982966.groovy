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

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'),0,FailureHandling.OPTIONAL))
 {
	WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

	WebUI.waitForPageLoad(0)


if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/AllRegistrantsLeftNavInCurators'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('All registrants left nav is not shown in convention curators page')
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/AllRegistrantsLeftNavInCurators'))

WebUI.waitForPageLoad(0)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/AllRegistrantsHeader'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('All registrants Header is not shown in All registrants page')
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/FilterButtonInAllRegistrantsPage'))

WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/SearchByNameFieldInFilterModal'),0)

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/SearchByNameFieldInFilterModal'), 'RandomText123')

WebUI.delay(3)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/EmptyStateVerification'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('empty state is not shown when no search results found')
}
if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/ResetFiltersPage'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('Reset filters button is not shown in All registrants page')
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/ResetFiltersPage'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/ConventionCurators/AllRegistrantsPage/CloseFilterModal'))
}