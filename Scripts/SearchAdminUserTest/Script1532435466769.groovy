import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.locks.Condition

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return
import org.junit.After
import org.openqa.selenium.By as By


Random rand = new Random()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToUsers'()

int NumberOfListElements = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/TeamManagement/Users/UsersCommonObjects'), 0).size()

String SearchText = WebUI.getText(findTestObject('Object Repository/TeamManagement/Users/UserInTheList(index)', ["index": rand.nextInt(NumberOfListElements)+1]))

WebUI.sendKeys(findTestObject('TeamManagement/SearchUsersSearchBoxInUsersActiveTab'), SearchText)

WebUI.delay(2)

int NumberOfSearchResults = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/TeamManagement/Users/UsersCommonObjects'), 10).size()
println NumberOfSearchResults
String SearchResult

for(int i=1;i<=NumberOfSearchResults;i++)
{
	SearchResult = WebUI.getText(findTestObject('Object Repository/TeamManagement/Users/UserInTheList(index)', ["index": rand.nextInt(NumberOfSearchResults)+1]))

	if(!(SearchText.equalsIgnoreCase(SearchResult)))
	{
		WebUI.takeScreenshot()
		KeywordUtil.markFailedAndStop("When search in users  page, incorrect search results are shown")
	}
}
