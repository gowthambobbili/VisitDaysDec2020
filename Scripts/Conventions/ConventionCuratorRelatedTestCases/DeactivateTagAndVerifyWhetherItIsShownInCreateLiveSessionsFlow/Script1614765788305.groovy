import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'),0,FailureHandling.OPTIONAL))
{
   WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

   WebUI.waitForPageLoad(0)
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionSettingsLeftNav'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/TagsLeftNav'))

WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionCurators/Tags/ListOfTagsHeader'),0,FailureHandling.OPTIONAL)

if(!(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/Tags/ListOfTagsHeader'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed('List of tags header is not shown in tags page')
}

def beforeTagsCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionCurators/Tags/GetTagsCount'),0).size()

def tagName=CustomKeywords.'com.CommonUtilities.ConventionCurators.createTags'()

def afterTagsCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionCurators/Tags/GetTagsCount'),0).size()

if(beforeTagsCount==afterTagsCount)
{
	KeywordUtil.markFailed("new tag has not added to the list")
}

WebUI.click(findTestObject('Object Repository/ConventionCurators/Tags/DeactivateTagButton',['tagName':tagName]))

WebUI.click(findTestObject('Object Repository/ConventionCurators/Tags/Save button'))

WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink',['ConventionProvider':GlobalVariable.ConventionProvider]))

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/CreateButtonInLiveSessions'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ClickFirstConventionInCreatingLiveSessions'))

WebUI.scrollToElement(findTestObject('Object Repository/ConventionsPageAdmin/ClickOnTagsDropDown'), 0)

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ClickOnTagsDropDown'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/Tags/VerifyTagsInCreateLiveSessionFlow',['tagName':tagName]),0,FailureHandling.OPTIONAL))
{
	KeywordUtil.markFailed("The deactivated tag is still shown in the created convention flow")
}