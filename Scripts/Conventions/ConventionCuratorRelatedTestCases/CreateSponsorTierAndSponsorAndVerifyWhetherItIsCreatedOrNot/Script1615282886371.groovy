import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'),0,FailureHandling.OPTIONAL))
{
   WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

   WebUI.waitForPageLoad(0)
}
WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionSettingsLeftNav'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/SponsorsLeftNav'))

WebUI.waitForPageLoad(0)

def previousCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionCurators/Sponsors/getTitleCount'),0).size()

WebUI.scrollToElement(findTestObject('Object Repository/ConventionCurators/Sponsors/AddNewTier'), 0)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/AddNewTier'))

WebUI.delay(2)

Random rd=new Random()

def num=rd.nextInt(100)

String sponsorTierName="SponsorTier"+num;

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/Sponsors/EnterSponsorTierName'),sponsorTierName)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/SizeDropDown'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/MediumDisplaySizeOptionInDropDown'))

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/AddNewSponsorToTier'))

String userDir = System.getProperty('user.dir')

WebUI.uploadFile(findTestObject('Object Repository/ConventionCurators/Sponsors/BrowseButtonInUpdateLogoModal'), userDir + '\\Visitdaysimage.png')

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/Sponsors/SponsorUrlTextField'),"http://visitdays.com/")

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/AddButtpnInAddSponsorModal'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/SaveButton'))

def expectedCount=previousCount+1

def afterCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionCurators/Sponsors/getTitleCount'),0).size()

if(!(expectedCount==afterCount))
{
	KeywordUtil.markFailed("new tier is not created")
	
}

//WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/ThreeDotMenuOfConventionTier'))

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/Sponsors/ThreeDotMenuOfConventionTier'), 0)

WebUI.delay(2)

CustomKeywords.'com.CommonUtilities.ClickUsingJSExecutor.clickUsingJS'(findTestObject('Object Repository/ConventionCurators/Sponsors/DeleteLastTierOption'), 0)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/Ok delete button'))

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/SaveButton'))

WebUI.delay(5)

def afterDeletedCount=WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ConventionCurators/Sponsors/getTitleCount'),0).size()

if(!(afterDeletedCount==previousCount))
{
	KeywordUtil.markFailed("new tier is not deleted even after clicking on delete tier")
	
}
