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

String VisitType = CustomKeywords.'com.CommonUtilities.RequestMethods.CreateInstantVisitTypeWithMenualCheckin'()

CustomKeywords.'com.CommonUtilities.CreateVisitWithDifferentStatuses.CreateDailyVisitWithFutureTimes'(VisitType)

CustomKeywords.'com.CommonUtilities.FilterInIndexPage.ApplyFiltersInIndexPage'(VisitType)

WebUI.click(findTestObject('DailyVisitsPage/FirstVisitInVisitIndex'))

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String FirstStudentName = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def FirstStudent = new TestObject('Registered student in registered tab')

FirstStudent.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + FirstStudentName) + '\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(FirstStudent, 'Registered student is not shown in the registered tab')

WebUI.click(findTestObject('DailyVisitsPage/AddRegistrantButtonInRegisteredTab'))

String SecondStudentName = CustomKeywords.'com.CommonUtilities.AddVisitorDirectlyToTheVisit.AddIndividualDirectlyToTheVisit'()

def SecondStudent = new TestObject('Registered student in registered tab')

SecondStudent.addProperty('xpath', ConditionType.EQUALS, ('//span[@class=\'uservisit-flex-prop\']//div[text()=\'' + SecondStudentName) + '\']')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(SecondStudent, 'Registered student is not shown in the registered tab')

WebUI.click(FirstStudent)

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

WebUI.sendKeys(findTestObject('UserProfile/SearchStudentAccountSearchboxInMergeAccountsModal'), SecondStudentName)

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

if (!(WebUI.verifyElementNotPresent(FirstStudent, 15, FailureHandling.OPTIONAL))) {
    KeywordUtil.markFailed('After Merging second student with Main student the second student profile is still shown which is expected to delete and not shown')

    WebUI.takeScreenshot()
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(SecondStudent, 'After mering the merged profile is not present')


WebUI.delay(3)

WebUI.click(SecondStudent)

WebUI.waitForElementPresent(findTestObject('UserProfile/FirstVisitInUserProfileVisits'), 0)

int NumberOfVisitInProfile = driver.findElements(By.xpath(('//div[@class=\'visit-title-time\']//h3[text()=\'' + VisitType) + 
        '\']')).size()

if (NumberOfVisitInProfile > 1) {
    WebUI.takeScreenshot()

    KeywordUtil.markFailedAndStop(('After merging a visitor of a visit into another visitor of same visit, in the merged user profile same visit shows ' + 
        NumberOfVisitInProfile) + ' times')
}

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('UserProfile/StatusFieldInUserProfile'), 
    'After merging a user into another user of same visit then in the profile of the merged student status field is shown (After merging the status should not show)')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('UserProfile/Details/NotHereButtonInProfile'), 
    'After merging two users, \'Not Here\' button is not shown in the merged user profile')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('UserProfile/CheckInButtonInUserProfile'), 
    'After merging two users, \'Check In\' button is not shown in the merged user profile')

WebUI.click(findTestObject('UserProfile/Details/NotHereButtonInProfile'))

WebUI.delay(3)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('UserProfile/Details/NotHereButtonInProfile'), 
    'After merging two users, if user clicks "Not Here" still Check In and Note Here button is shown in the merged user profile')

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementNotPresent'(findTestObject('UserProfile/CheckInAllButtonInUserProfile'), 
    'After merging two users, if user clicks "Not Here" still Check In button is shown in the merged user profile')

