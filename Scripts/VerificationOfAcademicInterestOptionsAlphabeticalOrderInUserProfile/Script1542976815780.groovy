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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By


WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), 0)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The Add Registrants button is not shown in the Registered tab to add visitors directly to the visit')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String Individual = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def student = new TestObject('Registed student n registered tab')

student.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + Individual) +
		'\']')

if (!(WebUI.verifyElementPresent(student, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('The registered student is not shown in the registered tab')

	WebUI.takeScreenshot()
}

WebUI.click(student)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.waitForElementVisible(findTestObject('PipelineTabInIndividualProfile'), 0)

WebUI.click(findTestObject('PipelineTabInIndividualProfile'), FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('UserProfile/EditButtonInDetailsTab'), 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('In the prospective student (Individual) profile Pipline, Edit button is not present')

	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('UserProfile/EditButtonInDetailsTab'))

WebUI.verifyElementPresent(findTestObject('UserProfile/Pipeline/AcademicInterestsDropdown'), 0)

WebUI.click(findTestObject('UserProfile/Pipeline/AcademicInterestsDropdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

int numebrofelements = driver.findElements(By.xpath("//li[@class='ember-power-select-option']")).size()

String[] myArray= new String[numebrofelements]

def Options = new TestObject("Option In Academic Interests dropdown")

for(int i = 1; i<=numebrofelements;i++)
{
	Options.addProperty("xpath", ConditionType.EQUALS, "//li[@class='ember-power-select-option']["+i+"]")

	myArray[i-1] = WebUI.getText(Options)

}

if(!(Arrays.equals(myArray, myArray.sort())))
{
	KeywordUtil.markFailed('Academic Interests options in user profile are not in Alphabetic order')

	WebUI.takeScreenshot()
}































