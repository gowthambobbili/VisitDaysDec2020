import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



CustomKeywords.'com.CommonUtilities.GetInstitutionName.getInstitutionNameFromAdminApp'()

WebUI.click(findTestObject('Object Repository/HomePageElements/PersonIcon'))

WebUI.click(findTestObject('Object Repository/HomePageElements/NacacConventionslink'))

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/Conventionsleftnav'))

WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/CreateButtonInLiveSessions'))

WebUI.waitForPageLoad(5)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionsPageAdmin/ConventionCardInLiveSessioncreation'),0,FailureHandling.OPTIONAL))
{
	def ConventionName=WebUI.getText(findTestObject('Object Repository/ConventionsPageAdmin/getNameOfFirstConvention'))
	
	WebUI.navigateToUrl(GlobalVariable.SelfServeUrl)
	
	WebUI.waitForPageLoad(0)
	
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/EmailTextBox'), 'test.user1@qualitlabs.com')
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Self serve objects/PasswordTextField'), "vGm4WD5Mwh5DcgtLXIeBlg==")
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/LoginButton'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/HomeInTopNav'),0)
	
	WebUI.navigateToUrl(GlobalVariable.SelfServeUrl+"convention_providers")
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/ShowDetailsOfConventionsProvider',['StudentUrlCheck':GlobalVariable.StudentUrlCheck]))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/ConventionsButtonOnTopNav'),0)
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/ConventionsButtonOnTopNav'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/ConventionsButtonOnTopNav'),0)
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/ConventionsButtonOnTopNav'))
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/EditConventionButtonInConventionspage',['ConventionName':ConventionName]))
	
//	WebUI.click(findTestObject('Object Repository/Self serve objects/clickStartYear'))
	
	String yearstring=WebUI.getText(findTestObject('Self serve objects/GetYearFromStartYearDropdown'))
	
	int year=Integer.parseInt(yearstring)
	
	def nextYear=year+1
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/ClickEndYear'))
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/SelectEndyear',['EndYear':nextYear]))
	
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'), Keys.chord(Keys.CONTROL, 'a'))
	
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'), Keys.chord(Keys.BACK_SPACE))
	
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'),'1000')
	
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/SessionDurationMinutes'), Keys.chord(Keys.CONTROL, 'a'))
	
	WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/SessionDurationMinutes'), Keys.chord(Keys.BACK_SPACE))
	
	WebUI.click(findTestObject('Object Repository/Self serve objects/UpdateConvention'))
	
	WebUI.delay(5)
	
}
else
{

CustomKeywords.'com.CommonUtilities.CreateconventionUsingSelfServeTool.GoToCreateConventionPage'()

CustomKeywords.'com.CommonUtilities.CreateconventionUsingSelfServeTool.EnterConventionNameAndDetails'()

CustomKeywords.'com.CommonUtilities.CreateconventionUsingSelfServeTool.SelectExhibitor'()

}
