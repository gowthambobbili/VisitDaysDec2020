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

//CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.LoginToNacacStudentAppAsStudentInNewBrowser'()

WebUI.waitForPageLoad(0)

WebUI.waitForElementClickable(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsHomePage'), 0)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/EventsHomePage'))

WebUI.waitForPageLoad(0)

WebUI.delay(3)

println WebUI.getUrl()

println GlobalVariable.studenturl+"events"

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(WebUI.getUrl(), GlobalVariable.studenturl+"events", "When click Events top nav the Events page not opened")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/Events/WithSupportFromHeader'), "Sponsers header is not shown in events page")

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/VideosButtonInTopNav'))

WebUI.waitForPageLoad(0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(WebUI.getUrl(), GlobalVariable.studenturl+"videos", "When click Videos top nav the Events page not opened")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/Videos/ExploreVideosHeader'), "Explore Videos header is not shown in Videos page")

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/FavoritesInTopNav'))

WebUI.waitForPageLoad(0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(WebUI.getUrl(), GlobalVariable.studenturl+"favorites", "When click Favorites top nav the favorites page not opened")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/FavoriteHeaderInFavoritesPage'), "Favorites header is not shown in Favorites page")

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/ItinearariesTopNav'))

WebUI.waitForPageLoad(0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(WebUI.getUrl(), GlobalVariable.studenturl+"itineraries?activeTab=0", "When click My Schedule top nav the page is not opened")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/My Schedule/MyFairsOption'), "My Fairs tab is not shown in My Schedule page")

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/MyMeetingsOptionInItinenariesPage'))

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/AccountBasicsInTopNav'))

WebUI.waitForPageLoad(0)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyTextMatch'(WebUI.getUrl(), GlobalVariable.studenturl+"account/basics", "When click Account icon the page is not opened")

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresentAndStopExecutionIfFailed'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/AccountBasicsHeaderInAccountBasicspage'), "Account Basics hehader is not shown in Account page")






