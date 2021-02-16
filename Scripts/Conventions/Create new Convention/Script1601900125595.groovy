import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



CustomKeywords.'com.CommonUtilities.GetInstitutionName.getInstitutionNameFromAdminApp'()

WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink',['ConventionProvider':GlobalVariable.ConventionProvider]))

//WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/CreateButtonInLiveSessions'))

WebUI.waitForPageLoad(5)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/ConventionCardInLiveSessioncreation'),0,FailureHandling.OPTIONAL))
{
	def ConventionName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/getNameOfFirstConvention'))
	
	WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))
	
	WebUI.waitForPageLoad(0)
	
	WebUI.click(findTestObject('Object Repository/ConventionCurators/conventionNameInList',['conventionName':ConventionName]))
	
	WebUI.waitForPageLoad(0)
	
	WebUI.scrollToElement(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'), 0, FailureHandling.OPTIONAL)
	
	WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'), Keys.chord(Keys.CONTROL, 'a'))
	
	WebUI.delay(2)
	
	WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'), Keys.chord(Keys.BACK_SPACE))
	
	WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'),'120')
	
	WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/SaveButton'))
	
}
else
{

def conventionName=CustomKeywords.'com.CommonUtilities.CreateNewConvention.createNewConventionWithUpcomingDates'()

}
