import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateMeeting.getConvention'()

//def videoName=CustomKeywords.'com.CommonUtilities.VideoLibrary.addVideoToVideoLibrary'()

def institutionName=CustomKeywords.'com.CommonUtilities.GetInstitutionName.getInstitutionNameFromAdminApp'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.delay(5)

//WebUI.click(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 2, FailureHandling.OPTIONAL)

while(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'),2,FailureHandling.OPTIONAL))
{

if(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 2, FailureHandling.OPTIONAL))
{
	CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'),0)
//	WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'),FailureHandling.OPTIONAL)

}
WebUI.delay(3)
WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 2, FailureHandling.OPTIONAL)
}
WebUI.waitForElementPresent(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]), 0)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]), 0)

//WebUI.click(findTestObject('NacacStudentApp/HomePageElements/CollegeName',['Exhibitor':institutionName]))

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/VideosTabInExhibitorsPage'))

def TotalVideosCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/NacacStudentApp/Videos/ExhibitorsVideosCount'), 0).size()

def ExhibitorVideosCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/NacacStudentApp/Videos/VerifyVideosInExhibitorsPage',['ExhibitorName':institutionName]),0).size()

if(!(TotalVideosCount==ExhibitorVideosCount))
{
	KeywordUtil.markFailed(institutionName+" is showing other exhibitors videos also")
}