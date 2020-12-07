import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

WebUI.waitForElementPresent(findTestObject('VisitTypesPage/QuestionsOption'), 0)

CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToQuestions'()

for(int j=0;j<=2;j++)
{
	if(j==1)
	{
		WebUI.click(findTestObject('VisitTypesPage/ActiveTabInQuestions'))
	}
	else if(j==2)
	{
		WebUI.click(findTestObject('VisitTypesPage/InActiveTabInQuestions'))
	}

	WebUI.waitForElementPresent(findTestObject('VisitTypesPage/FirstQuestionInQuestionsList'), 0)

	int CountOfQuestions = driver.findElements(By.xpath("//div[@class='vd-card __question-card__ef1a3 pointer-on-hover ember-view']")).size()

	for(int i=1;i<=CountOfQuestions;i++)
	{
		driver.findElement(By.xpath("(//div[@class='vd-card __question-card__ef1a3 pointer-on-hover ember-view']//div[2])["+i+"]")).isDisplayed()
	}

}















