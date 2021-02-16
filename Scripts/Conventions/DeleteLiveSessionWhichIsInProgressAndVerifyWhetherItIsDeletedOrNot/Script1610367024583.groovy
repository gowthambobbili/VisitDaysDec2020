import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

def conventionName=CustomKeywords.'com.CommonUtilities.CreateLiveSession.selectConvention'()

def meetname=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterLiveSessionDetailsAndTime'()

println conventionName

def ZoomId=CustomKeywords.'com.CommonUtilities.CreateLiveSession.enterZoomIdAndAddAssigne'()

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ThreeDotButtonInVideosPage'))

WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/DeleteVideoButtonInVideosPage'), 0)

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/DeleteVideoButtonInVideosPage'))

WebUI.delay(5)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/ViewLiveSessionHeader'),0,FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('live sessions which are in progress are getting deleted in admin app of live sessions page')
}

