package com.CommonUtilities

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CreateconventionUsingSelfServeTool {
	Random rd= new Random()

	def num=rd.nextInt(10000)

	def conventionName='A TestConvention'+num

	@Keyword
	def GoToCreateConventionPage() {
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

		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/NewConventionButton'),0)

		WebUI.click(findTestObject('Object Repository/Self serve objects/NewConventionButton'))
	}
	@Keyword
	def EnterConventionNameAndDetails() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/ConventionName'),0)

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/ConventionName'),conventionName)

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickStartTime'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/StartTimeOfConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickstartTimeMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/StartTimeOfConventionMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickOnEndMonthField'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/DecemberOptionInEndDateField'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EndDateField'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EnddateLastDay'))

		String yearstring=WebUI.getText(findTestObject('Self serve objects/GetYearFromStartYearDropdown'))

		int year=Integer.parseInt(yearstring)

		def nextYear=year+1

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickEndYear'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/SelectEndyear',['EndYear':nextYear]))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickEndTime'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EndTimeOfConventionHour'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickEndTimeMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EndTimeOfConventionMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickTimeZoneOfConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/AmericaNewYorkZone'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/StudentCheckBoxOfCreateConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ParentCheckBoxOfCreateConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/TeacherCheckBoxOfCreateConvention'))

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'), Keys.chord(Keys.CONTROL, 'a'))

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'), Keys.chord(Keys.BACK_SPACE))

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'),'10')

		WebUI.click(findTestObject('Object Repository/Self serve objects/CreateConventionButton'))
	}
	@Keyword
	def EnterConventionNameAndDetailsFixedLength() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/ConventionName'),0)

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/ConventionName'),conventionName)

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickStartTime'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/StartTimeOfConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickstartTimeMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/StartTimeOfConventionMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickOnEndMonthField'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/DecemberOptionInEndDateField'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EndDateField'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EnddateLastDay'))

		String yearstring=WebUI.getText(findTestObject('Self serve objects/GetYearFromStartYearDropdown'))

		int year=Integer.parseInt(yearstring)

		def nextYear=year+1

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickEndYear'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/SelectEndyear',['EndYear':nextYear]))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickEndTime'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EndTimeOfConventionHour'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickEndTimeMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/EndTimeOfConventionMinute'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ClickTimeZoneOfConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/AmericaNewYorkZone'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/StudentCheckBoxOfCreateConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/ParentCheckBoxOfCreateConvention'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/TeacherCheckBoxOfCreateConvention'))

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'), Keys.chord(Keys.CONTROL, 'a'))

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'), Keys.chord(Keys.BACK_SPACE))

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/MaxSessionsInput'),'10')

		WebUI.sendKeys(findTestObject('Object Repository/Self serve objects/ConventionDurationMinutes'),'180')

		WebUI.click(findTestObject('Object Repository/Self serve objects/CreateConventionButton'))
	}
	@Keyword
	def SelectExhibitor() {
		String name=WebUI.getText(findTestObject('Object Repository/Self serve objects/GetConventionNameAftercreatedConvention'))

		int ind=name.indexOf("created")

		String convention=name.substring(0,ind);

		String ConventionNAME=convention.trim()

		//		GlobalVariable.createdConventionName=ConventionNAME

		WebUI.waitForElementPresent(findTestObject('Object Repository/Self serve objects/ViewExhibitorsButtonOfConvention',['conventionName':ConventionNAME]),0)

		WebUI.click(findTestObject('Object Repository/Self serve objects/ViewExhibitorsButtonOfConvention',['conventionName':ConventionNAME]))

		WebUI.click(findTestObject('Object Repository/Self serve objects/SelectinstitutionDropDown'))

		WebUI.click(findTestObject('Object Repository/Self serve objects/SelectInstitutionValue',['InstitutionName':GlobalVariable.InstitutionValue]))

		WebUI.click(findTestObject('Object Repository/Self serve objects/AddInstitutionButton'))

		return ConventionNAME
	}
}
