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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantEventVisitTypeWithManualCheckin'()

CustomKeywords.'com.CommonUtilities.CreationOperations.CreateEventWithInstantVisitType'(VisitType)

String Single = 'Single'

String MainStudent = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
		VisitType, findTestObject('Add Attendee/EventsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

WebUI.refresh()

WebUI.waitForElementVisible(findTestObject('HomePageElements/AddAttendeeButton'), 0)

WebUI.delay(3)

String SecondStudemt = CustomKeywords.'com.CommonUtilities.ConfirmationPage.NavgateToConfirmationPageForIndividualRegistrationOInstantVisitWithRandomUserName'(
		VisitType, findTestObject('Add Attendee/EventsOptionInAddAttendee'), Single)

CustomKeywords.'com.CommonUtilities.Quit.CloseMobiInConfirmationPageForInstantBook'()

WebUI.waitForElementVisible(findTestObject('HomePageElements/AddAttendeeButton'), 0)

WebUI.waitForElementVisible(findTestObject('HomePageElements/GlobalSearchBox'), 0)

WebUI.sendKeys(findTestObject('HomePageElements/GlobalSearchBox'), MainStudent)

WebUI.delay(5)

WebUI.sendKeys(findTestObject('HomePageElements/GlobalSearchBox'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
/////////////

WebUI.verifyElementPresent(findTestObject('UserProfile/StudentNameInUserProfile'), 0)

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('UserProfile/StudentNameInUserProfile'), MainStudent)

WebUI.refresh()

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/DetailsTabInDailyVisitsPage'), 0)

WebUI.verifyElementPresent(findTestObject('DailyVisitsPage/RegisteredTab'), 0)

def Object = new TestObject('RegisteredStudentProfile')

Object.addProperty('xpath', ConditionType.EQUALS, ('(//div[text()=\'' + MainStudent) + '\'])[1]')

WebUI.verifyElementPresent(Object, 0)

def Object2 = new TestObject('SecondRegisteredStudentProfile')

Object2.addProperty('xpath', ConditionType.EQUALS, ('(//div[text()=\'' + SecondStudemt) + '\'])[1]')

WebUI.verifyElementPresent(Object2, 0)

WebUI.click(Object2)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/TopThreeDotMenuInUserProfile'), 0)

WebUI.waitForElementClickable(findTestObject('UserProfile/TopThreeDotMenuInUserProfile'), 0)

WebUI.click(findTestObject('UserProfile/TopThreeDotMenuInUserProfile'))

not_run: WebUI.verifyElementPresent(findTestObject('UserProfile/MainThreedotMenuInUserProfile'), 0)

not_run: WebUI.click(findTestObject('UserProfile/MainThreedotMenuInUserProfile'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('UserProfile/MergeOption'), 0)

WebUI.click(findTestObject('UserProfile/MergeOption'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('UserProfile/MergeAccountsHeaderInMergeAccountsModal'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/SearchStudentAccountSearchboxInMergeAccountsModal'), 0)

WebUI.waitForElementVisible(findTestObject('UserProfile/SearchStudentAccountSearchboxInMergeAccountsModal'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('UserProfile/SearchStudentAccountSearchboxInMergeAccountsModal'))

WebUI.sendKeys(findTestObject('UserProfile/SearchStudentAccountSearchboxInMergeAccountsModal'), MainStudent)

WebUI.delay(6)

WebElement GlobalSearchBox = driver.findElement(By.xpath('(//input[@class=\'aupac-typeahead ember-view tt-input form-control\'])[1]'))

GlobalSearchBox.sendKeys(Keys.ARROW_DOWN)

GlobalSearchBox.sendKeys(Keys.ENTER)

//WebUI.sendKeys(findTestObject('UserProfile/SearchStudentAccountSearchboxInMergeAccountsModal'), Keys.chord('',Keys.ARROW_RIGHT))
WebUI.verifyElementPresent(findTestObject('UserProfile/IUnderstandCheckBoxInMergeAccountsModal'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/DontMergeButtonInMergeAccountsModal'), 0)

WebUI.verifyElementPresent(findTestObject('UserProfile/MergeNowButtonInMergeAccountsModal'), 0)

WebUI.click(findTestObject('UserProfile/IUnderstandCheckBoxInMergeAccountsModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UserProfile/MergeNowButtonInMergeAccountsModal'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('UserProfile/MergeNowButtonInMergeAccountsModal'), 0)

WebUI.waitForElementPresent(findTestObject('DailyVisitsPage/RegisteredTab'), 0)
WebUI.refresh()

if (!(WebUI.verifyElementNotPresent(Object2, 0, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After Merging second student with Main student the second student profile is still shown which is expected to delete and not shown')

	WebUI.takeScreenshot()
}

WebUI.verifyElementPresent(Object, 0)

int NumberOfMainStudentProfilesAfterMerge = driver.findElements(By.xpath(('//span[@class="uservisit-flex-prop"]//div[text()=\'' + MainStudent) + '\']')).size()

if (!(WebUI.verifyMatch(NumberOfMainStudentProfilesAfterMerge.toString(), '1', false, FailureHandling.OPTIONAL))) {
	KeywordUtil.markFailed('After merging second student with Main student, the Main student profile shown twice in Registered tab')

	WebUI.takeScreenshot()
}

