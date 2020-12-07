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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

String ImgAttributeInAdminProfile

String DefaultAdminUserProfile

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

String Flag

if (WebUI.verifyElementPresent(findTestObject('Object Repository/ElementsUnderProfileAvatar/AdminProfilePictureDivision'),
0)) {
	ImgAttributeInAdminProfile = WebUI.getAttribute(findTestObject('Object Repository/ElementsUnderProfileAvatar/AdminProfilePictureDivision'),
			'src')

	Flag = 'profilepic'
} else {
	DefaultAdminUserProfile = WebUI.getText(findTestObject('Object Repository/ElementsUnderProfileAvatar/DefaultUserProfileIfNOProfilePictureIsUploaded'))

	Flag = 'defaultprofilepic'
}

CustomKeywords.'com.CommonUtilities.NavigationFlows.NavigateToRequestQueue'()

WebUI.click(findTestObject('Requests/ExpiredRadioButton'))

WebUI.waitForElementPresent(findTestObject('Add Attendee/FirstRequestInQueueOrEmptyStateInRequests'), 0)

if (WebUI.verifyElementPresent(findTestObject('Add Attendee/FirstRequestInQueue'), 0, FailureHandling.OPTIONAL)) {
	int NumberOfRequestsInExpired = driver.findElements(By.xpath('(//div[@class=\'request-queue padding-bottom-12 space-between row\'])')).size

	if (Flag == 'profilepic') {
		for (int i = 1; i <= NumberOfRequestsInExpired; i++) {
			String ImgAttributeInRequests = driver.findElement(By.xpath('//span[@class=\'user-name\']/../../../..//img')).getAttribute(
					'src')

			if (ImgAttributeInRequests == ImgAttributeInAdminProfile) {
				driver.findElement(By.xpath(('(//div[@class=\'request-queue padding-bottom-12 space-between row\']//div[@class=\'registered-user\'])[' +
						i) + ']')).click()

				WebUI.verifyElementPresent(findTestObject('Requests/ScheduleLinkInStudentProfile'), 0)

				WebUI.click(findTestObject('Requests/ScheduleLinkInStudentProfile'))

				WebUI.verifyElementPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0)
				break

			}

		}
	}

	else if (Flag == 'defaultprofilepic')
	{

		driver.findElement(By.xpath("//div[text()='"+DefaultAdminUserProfile+"']/../../../../../../../../../..//span[@class='user-name']"))

		WebUI.verifyElementPresent(findTestObject('Requests/ScheduleLinkInStudentProfile'), 0)

		WebUI.click(findTestObject('Requests/ScheduleLinkInStudentProfile'))

		WebUI.verifyElementPresent(findTestObject('Requests/ScheduleRequestHeaderInRequestScheduleModal'), 0)

	}
	else
	{
		WebUI.click(findTestObject('Requests/UserNameOfFirstReqestInExpredList'))
		WebUI.verifyElementNotPresent(findTestObject('Requests/ScheduleLinkInStudentProfile'), 0)
	}
}
else
{
	println "There are no expired requests present under expired tab"
}