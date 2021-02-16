import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateMeeting.getConvention'()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.click(findTestObject('NacacStudentApp/HomePageElements/SelectConventionInHomePage',['Name':conventionName]))

WebUI.delay(5)

//WebUI.click(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('NacacStudentApp/HomePageElements/CollegesTabInExhibitorsPage'),0)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/LoadMoreButton'), 5, FailureHandling.OPTIONAL)))
{
	WebUI.delay(3)
	
	String collegesCount=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/Colleges/CollegesCount'))
	
	println collegesCount
	
	int spaceIndex=collegesCount.indexOf(' ')
	 
	String collegesCountNoInString=collegesCount.substring(0,spaceIndex)
	
	int collegesCountNo=Integer.parseInt(collegesCountNoInString);
	
	def requiredNumber=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/NacacStudentApp/Colleges/CollegesCountVerifier'),0).size()
	
	if(!(collegesCountNo==requiredNumber))
	{
		KeywordUtil.markFailed("Colleges count is showing wrong, expeceted count is" +requiredNumber+" and actual count is "+collegesCountNo)
	}
}