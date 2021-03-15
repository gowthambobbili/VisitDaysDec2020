import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

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

def firstLink="http://visitdays.com/"

def secondLink="http://qualitlabs.com/"

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/Sponsors/SponsorUrlTextField'),firstLink)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/AddButtpnInAddSponsorModal'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/SaveButton'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/EditSponsor'))

//WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/EditSponsorImage'))

String userDir2 = System.getProperty('user.dir')

WebUI.uploadFile(findTestObject('Object Repository/ConventionCurators/Sponsors/BrowseButtonInUpdateLogoModal'), userDir2 + '\\Visitdayslogo.png')

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/Sponsors/SponsorUrlTextField'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/Sponsors/SponsorUrlTextField'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/Sponsors/SponsorUrlTextField'),secondLink)

WebUI.click(findTestObject('Object Repository/ConventionCurators/Sponsors/UpdateButtonInAddSponsorModal'))

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