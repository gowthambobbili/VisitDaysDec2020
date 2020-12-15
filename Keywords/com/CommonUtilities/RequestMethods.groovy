package com.CommonUtilities
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


class RequestMethods {
	@Keyword
	def CreateSessionVisitTypeWithManualCheckin() {
		//WebUI.waitForElementPresent(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('CreateSessionsType/SessionOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('CreateSessionsType/ManualCheckinRadiobutton'))

		WebUI.click(findTestObject('CreateSessionsType/InPersonSelectOption'))

		WebUI.click(findTestObject('CreateSessionsType/OnlineCheckbox'))

		WebUI.sendKeys(findTestObject('CreateSessionsType/OnlineTextField'),'this is test description')

		WebUI.click(findTestObject('CreateSessionsType/NextButton'))

		WebUI.sendKeys(findTestObject('CreateSessionsType/Drecription'),'test description')

		WebUI.click(findTestObject('CreateSessionsType/SupportContentAddLater'))

		WebUI.click(findTestObject('CreateSessionsType/NextButton'))

		WebUI.click(findTestObject('CreateSessionsType/CreateVisit'))

		WebUI.click(findTestObject('CreateSessionsType/Addsessionsdialogue'))

		return VisitTypeName

	}

	@Keyword
	def CreateSessionVisitTypeWithKeywordCheckin() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('CreateSessionsType/SessionOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)


		WebUI.click(findTestObject('Object Repository/CreateSessionsType/KeywordCheckinRadioButton'))

		WebUI.click(findTestObject('CreateSessionsType/InPersonSelectOption'))

		WebUI.click(findTestObject('CreateSessionsType/OnlineCheckbox'))

		WebUI.sendKeys(findTestObject('CreateSessionsType/OnlineTextField'),'this is test description')

		WebUI.click(findTestObject('CreateSessionsType/NextButton'))

		WebUI.sendKeys(findTestObject('CreateSessionsType/Drecription'),'test description')

		WebUI.click(findTestObject('CreateSessionsType/SupportContentAddLater'))

		WebUI.click(findTestObject('CreateSessionsType/NextButton'))

		WebUI.click(findTestObject('CreateSessionsType/CreateVisit'))

		WebUI.click(findTestObject('CreateSessionsType/Addsessionsdialogue'))

		return VisitTypeName
	}

	@Keyword
	def CreateSessionVisitTypeWithAutomatedTextMessage() {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('CreateSessionsType/SessionOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)


		WebUI.click(findTestObject('Object Repository/CreateSessionsType/AutomatedTextMessageRadioButton'))

		WebUI.click(findTestObject('CreateSessionsType/InPersonSelectOption'))

		WebUI.click(findTestObject('CreateSessionsType/OnlineCheckbox'))

		WebUI.sendKeys(findTestObject('CreateSessionsType/OnlineTextField'),'this is test description')

		WebUI.click(findTestObject('CreateSessionsType/NextButton'))

		WebUI.sendKeys(findTestObject('CreateSessionsType/Drecription'),'test description')

		WebUI.click(findTestObject('CreateSessionsType/SupportContentAddLater'))

		WebUI.click(findTestObject('CreateSessionsType/NextButton'))

		WebUI.click(findTestObject('CreateSessionsType/CreateVisit'))

		WebUI.click(findTestObject('CreateSessionsType/Addsessionsdialogue'))

		return VisitTypeName
	}


	@Keyword
	def CreateRequestVisitType() {
		WebUI.click(findTestObject('Object Repository/HomePageElements/SchoolProdoutNav'))

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}



	@Keyword
	def CreateRequestVisitTypeWithIndividualRegistratType() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		//WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}


	@Keyword
	def CreateRequestEventVisitType() {
		WebUI.waitForElementPresent(findTestObject('HomePageElements/VisitTypesLeftNav'), 0)

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/eventOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddEventButtonInVisitTypeCreatedPopup'))

		return VisitTypeName
	}



	@Keyword
	def CreateRequestEventVisitTypeWithIndividualRegistrantType() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/eventOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		//WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddEventButtonInVisitTypeCreatedPopup'))

		return VisitTypeName
	}




	@Keyword
	def CreateRequestOffCampusVisitType() {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		//		not_run: WebUI.delay(15)
		//
		//		not_run: WebUI.click(findTestObject('VisitTypesPage/AppcuesPopupbutton'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/CreateVisitTypeButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(10000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'))

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.delay(2)

		//WebUI.click(findTestObject('VisitTypesPage/AddNowButtonInPhotoDvision'))

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		//WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('VisitTypesPage/AddOffCampusButtonInVisitTypeCretedModal'))

		return VisitTypeName

	}



	@Keyword
	def CreateRequestOffCampusVisitTypeWithIndividualRegistrantType() {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		//		not_run: WebUI.delay(15)
		//
		//		not_run: WebUI.click(findTestObject('VisitTypesPage/AppcuesPopupbutton'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/CreateVisitTypeButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(10000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		//WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/RequestRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'))

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.delay(2)

		//WebUI.click(findTestObject('VisitTypesPage/AddNowButtonInPhotoDvision'))

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		//WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('VisitTypesPage/AddOffCampusButtonInVisitTypeCretedModal'))

		return VisitTypeName

	}

	//===================instant methods==================//


	@Keyword
	def CreateInstantOffCampusVisitTypeWithManualCheckin() {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/CreateVisitTypeButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(10000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.delay(2)

		//WebUI.click(findTestObject('VisitTypesPage/AddNowButtonInPhotoDvision'))

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		//WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('VisitTypesPage/AddOffCampusButtonInVisitTypeCretedModal'))

		return VisitTypeName

	}




	@Keyword
	def CreateInstantOffCampusVisitTypeWithCloseRegistration(int NumberOfDays) {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/CreateVisitTypeButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(10000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.delay(2)

		//WebUI.click(findTestObject('VisitTypesPage/AddNowButtonInPhotoDvision'))

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		//WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/CloseDaysBeforeVisitRadioButton'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/CloseRegistrationTextbox'), NumberOfDays.toString())

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('VisitTypesPage/AddOffCampusButtonInVisitTypeCretedModal'))

		return VisitTypeName

	}



	@Keyword
	def CreateInstantOffCampusVisitTypeWithManualCheckinWithGroupRegistrantType() {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/CreateVisitTypeButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(10000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		//WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.delay(2)

		//WebUI.click(findTestObject('VisitTypesPage/AddNowButtonInPhotoDvision'))

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		//WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('VisitTypesPage/AddOffCampusButtonInVisitTypeCretedModal'))

		return VisitTypeName

	}





	@Keyword
	def CreateInstantVisitTypeWithKeywordCheckin() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}



	@Keyword
	def CreateInstantVisitTypeWithMenualCheckin() {

		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}



	@Keyword
	def CreateInstantVisitTypeWithNumberOfDaysToCloseRegistration(int NumberOfDays) {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/CloseDaysBeforeVisitRadioButton'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/CloseRegistrationTextbox'), NumberOfDays.toString())

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}










	@Keyword
	def CreateInstantVisitTypeWithMenualCheckinWithAllWaysToMeet() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/OnlineCheckbox'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), VisitTypeName)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/PhoneCheckbox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/PhoneCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/PhonewaysToMeetDescription'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/PhonewaysToMeetDescription'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}



	@Keyword
	def CreateRequestVisitTypeWithMenualCheckinAndAllWaysToMeet() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/RequestRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/OnlineCheckbox'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/OnlineWaysToMeetDescriptionTextfield'), VisitTypeName)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/PhoneCheckbox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/PhoneCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/PhonewaysToMeetDescription'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/PhonewaysToMeetDescription'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}





	@Keyword
	def CreateInstantVisitTypeWithMenualCheckinAndGroupRegistrantType() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		//WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddDailyVisitButtonInVisitTypeCretedModal'))

		return VisitTypeName
	}






	@Keyword
	def CreateInstantVisitTypeAndBeInVisitTypesPage() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/DailyVisitsOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'))

		WebUI.waitForElementNotPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		return VisitTypeName
	}



	@Keyword
	def CreateInstantEventVisitTypeWithKeywordCheckin()
	{
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/eventOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddEventButtonInVisitTypeCreatedPopup'))

		return VisitTypeName
	}



	@Keyword
	def CreateInstantEventVisitTypeWithManualCheckin() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/eventOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddEventButtonInVisitTypeCreatedPopup'))

		return VisitTypeName
	}





	@Keyword
	def CreateInstantEventVisitTypeWithCloseRegistration(int NumberOfDays) {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))
		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/eventOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/CloseDaysBeforeVisitRadioButton'))

		WebUI.sendKeys(findTestObject('VisitTypesPage/CloseRegistrationTextbox'), NumberOfDays.toString())

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddEventButtonInVisitTypeCreatedPopup'))

		return VisitTypeName
	}




	@Keyword
	def CreateInstantEventVisitTypeWithManualCheckinAndGroupRegistrantType() {
		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/eventOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(100000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		//WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.delay(2)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InPersonCheckBox'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InPersonCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		WebUI.click(findTestObject('VisitTypesPage/AddEventButtonInVisitTypeCreatedPopup'))

		return VisitTypeName
	}







	@Keyword
	def CreateInstantOffCampusVisitTypeWithKeywordCheckin() {

		//		WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('HomePageElements/VisitTypesLeftNav'),0)

		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/CreateVisitTypeButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateVisitTypeButton'))

		WebUI.click(findTestObject('VisitTypesPage/OffCampusOption'))

		WebUI.click(findTestObject('VisitTypesPage/GetStartedButton'))

		Random rand = new Random()

		def random_num = rand.nextInt(10000)

		def VisitTypeName = 'Test Visit Type' + random_num

		WebUI.sendKeys(findTestObject('VisitTypesPage/VisitTypeNameFieldInDailyVisitVT'), VisitTypeName)

		WebUI.click(findTestObject('VisitTypesPage/IndividualsRegistrantTypeCheckBox'))

		WebUI.click(findTestObject('VisitTypesPage/GroupsRegistrantTypeCheckbox'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/InstantBookRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/InstantBookRadioButton'))

		WebUI.scrollToElement(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/AutomatedTextMessageRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/KeywordCheckInRadioBtton'))

		//WebUI.click(findTestObject('VisitTypesPage/ManualCheckInOnlyRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.delay(2)

		//WebUI.click(findTestObject('VisitTypesPage/AddNowButtonInPhotoDvision'))

		//WebUI.uploadFile(findTestObject('VisitTypesPage/UploadZoneForVisitTypePhoto'), 'D:\\VisitDays-Automation\\tests\\VisitTypePhoto\\albright college.png')

		WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonINPhotoDivision'))

		//WebUI.waitForElementVisible(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.scrollToElement(findTestObject('VisitTypesPage/DescriptionTextField'), 0)

		WebUI.sendKeys(findTestObject('VisitTypesPage/DescriptionTextField'), 'This is the test descripton ')

		WebUI.scrollToElement(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CloseDayofVisitRadioButton'))

		WebUI.click(findTestObject('VisitTypesPage/NextButtonInCreatingDailyVisitsVisitTypePage'))

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.waitForElementClickable(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'), 0)

		WebUI.click(findTestObject('VisitTypesPage/CreateButtonInVisitTypeSummaryPage'))

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.verifyElementPresent(findTestObject('VisitTypesPage/VisitTypeCreatedPopup'), 0)

		WebUI.waitForElementPresent(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), 0)

		//WebUI.click(findTestObject('VisitTypesPage/AddLaterButtonInVisitTypeCreatedModal'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('VisitTypesPage/AddOffCampusButtonInVisitTypeCretedModal'))

		return VisitTypeName

	}


}


