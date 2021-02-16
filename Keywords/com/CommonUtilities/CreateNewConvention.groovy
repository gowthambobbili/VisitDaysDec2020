package com.CommonUtilities

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class CreateNewConvention {
	Random rd=new Random()
	def conventionName="testConvention"+rd.nextInt(100000)

	def editedConventionName="editedConvention"+rd.nextInt(100000)
	Date dNow = new Date()
	Date tomorow = new Date(dNow.getTime() + (1000 * 60 * 60 * 24))
	SimpleDateFormat ft =new SimpleDateFormat ("MM/dd/yyyy")

	String startDate=(ft.format(tomorow)).toString()

	Date dayAfterTomorow=new Date(dNow.getTime() + (1000 * 60 * 60 * 48))

	String endDate=(ft.format(dayAfterTomorow)).toString()


	@Keyword
	def createNewConventionWithUpcomingDates() {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'),0,FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/ConventionCurators/ConventionCuratorsleftNav'))

			WebUI.waitForPageLoad(0)

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionButton'))

			WebUI.waitForElementPresent(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/ConventionNameField'),0)

			WebUI.setText(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/ConventionNameField'),conventionName)

			WebUI.setText(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/StartDateField'),startDate)

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/StartTimeField'),'12')

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/StartTimeField'),'00')

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/StartTimeField'),'A')

			WebUI.setText(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/EndDateField'),endDate)

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/EndTimeField'),'12')

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/EndTimeField'),'00')

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/EndTimeField'),'P')

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/Timezonefield'))

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/NewYorkTimezone'))

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AddLogoButton'))

			String userDir = System.getProperty('user.dir')

			WebUI.uploadFile(findTestObject('Object Repository/ConventionsPageAdmin/BrowsePhotoAddress'),userDir + '\\Visitdayslogo.png')

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ApplybuttoninPhotoUpload'))

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/HeaderImageAddButton'))

			String userDir1 = System.getProperty('user.dir')

			WebUI.uploadFile(findTestObject('Object Repository/ConventionsPageAdmin/BrowsePhotoAddress'),userDir1 + '\\Visitdaysimage.png')

			WebUI.click(findTestObject('Object Repository/ConventionsPageAdmin/ApplybuttoninPhotoUpload'))

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'), Keys.chord(Keys.CONTROL, 'a'))

			WebUI.delay(2)

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'), Keys.chord(Keys.BACK_SPACE))

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'),'120')

			WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxSessionsPerExhibitorField'),'1000')

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AllowedRegistrantsTypeParentOrGuardain'))

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AllowedRegistrantsTypeStudent'))

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AllowedRegistrantTypesHighSchoolCounselor'))

			WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/SaveButton'))

			WebUI.delay(4)

			return conventionName
		}
	}
	@Keyword
	def editCreatedConvention() {
		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/ConventionNameField'), Keys.chord(Keys.CONTROL, 'a'))

		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/ConventionNameField'), Keys.chord(Keys.BACK_SPACE))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/ConventionNameField'),editedConventionName)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'), Keys.chord(Keys.CONTROL, 'a'))

		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'), Keys.chord(Keys.BACK_SPACE))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxTimeField'),'105')

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxSessionsPerExhibitorField'), Keys.chord(Keys.CONTROL, 'a'))

		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxSessionsPerExhibitorField'), Keys.chord(Keys.BACK_SPACE))

		WebUI.sendKeys(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/MaxSessionsPerExhibitorField'),'900')


		WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AllowedRegistrantTypesHighSchoolCounselor'))

		WebUI.uncheck(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/AllowedRegistrantsTypeParentOrGuardain'))

		WebUI.click(findTestObject('Object Repository/ConventionCurators/CreateNewConventionFlow/SaveButton'))

		WebUI.delay(4)

		return editedConventionName
	}
}
