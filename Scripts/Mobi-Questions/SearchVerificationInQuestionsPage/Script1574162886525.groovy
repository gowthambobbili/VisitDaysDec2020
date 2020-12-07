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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
Random random = new Random()

WebUI.navigateToUrl(GlobalVariable.StagingUrl+"institutions/"+GlobalVariable.Institution+"/platform/mobi/questions")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/MobiPage/Questions/SearchBox'), "Search box is not present in the Mobi-questions page")

def numberOfQuestions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/AllQestionNames'), 0).size()

def questionToSearch = WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionName(index)', ["index":random.nextInt(numberOfQuestions)])).trim()

WebUI.sendKeys(findTestObject('Object Repository/MobiPage/Questions/SearchBox'), questionToSearch)

WebUI.delay(2)

numberOfQuestions = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/MobiPage/Questions/AllQestionNames'), 0).size()

def questionAfterFiltering

for(def i=1;i<=numberOfQuestions;i++)
{
	questionAfterFiltering = WebUI.getText(findTestObject('Object Repository/MobiPage/Questions/QuestionName(index)', ["index":i])).trim()
	if(!(questionAfterFiltering.contains(questionToSearch)))
	{
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop("When search for a question "+questionToSearch+" it shown the invalid search results. Actual: "+ questionAfterFiltering)
	}
}






