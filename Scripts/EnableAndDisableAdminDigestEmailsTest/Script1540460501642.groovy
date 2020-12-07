import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.verifyElementPresent(findTestObject('HomePageElements/ProfileAvatar'), 0)

WebUI.click(findTestObject('HomePageElements/ProfileAvatar'))

WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/EmailSettingsOption'), 0)

WebUI.click(findTestObject('ElementsUnderProfileAvatar/EmailSettingsOption'), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.CommonUtilities.Verifications.VerifyElementPresent'(findTestObject('ElementsUnderProfileAvatar/Email Settings/EmailPreferancesHeader'),
		EmailPreferancesErrorMessage)

if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
0, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
			0)

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
			0)
} else {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
			0)

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
			0)
}

if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'), 0,
FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'),
			0)

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'), 0)
} else {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'), 0)

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'),
			0)
}

if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
0, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
			0)

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
			0)
} else {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
			0)

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
			0)
}

boolean flag = false

if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
0, FailureHandling.OPTIONAL)) {
	flag = true

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After clicking save preferences button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After unchecking the Daily digets and saved the checkbox box is still in enabled state')

		WebUI.takeScreenshot()
	}
}

if (flag == false) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After clicking save preferences button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After checking the Daily digets and saved the checkbox box is still in Unchecked state')

		WebUI.takeScreenshot()
	}
}

//WebUI.acceptAlert()
boolean flag1

if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'), 0,
FailureHandling.OPTIONAL)) {
	flag1 = true

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modify Weekly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After unchecking the Weekly  digets checkbox and saved the checkbox box is still in enabled state')

		WebUI.takeScreenshot()
	}
}

if (flag1 == false) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modifying Weekly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After checking the Weekly digets and saved the checkbox box is still in Unchecked state')

		WebUI.takeScreenshot()
	}
}

//WebUI.acceptAlert()

boolean flag2
if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'), 0,
FailureHandling.OPTIONAL)) {
	flag2 = true

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modify Monthly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After unchecking the Monthly digets checkbox and saved the checkbox box is still in enabled state')

		WebUI.takeScreenshot()
	}
}

if (flag2 == false) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modifying Monthly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After checking the Monthly digets and saved the checkbox box is still in Unchecked state')

		WebUI.takeScreenshot()
	}
}


//===================

boolean flag5 = false

if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
0, FailureHandling.OPTIONAL)) {
	flag5 = true

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After clicking save preferences button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After unchecking the Daily digets and saved the checkbox box is still in enabled state')

		WebUI.takeScreenshot()
	}
}

if (flag5 == false) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After clicking save preferences button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/DailyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After checking the Daily digets and saved the checkbox box is still in Unchecked state')

		WebUI.takeScreenshot()
	}
}


//========
boolean flag3

if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'), 0,
FailureHandling.OPTIONAL)) {
	flag3 = true

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modify Weekly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After unchecking the Weekly  digets checkbox and saved the checkbox box is still in enabled state')

		WebUI.takeScreenshot()
	}
}

if (flag3 == false) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modifying Weekly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/WeeklyDigestCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After checking the Weekly digets and saved the checkbox box is still in Unchecked state')

		WebUI.takeScreenshot()
	}
}

//WebUI.acceptAlert()

boolean flag4
if (WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'), 0,
FailureHandling.OPTIONAL)) {
	flag4 = true

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modify Monthly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementNotChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After unchecking the Monthly digets checkbox and saved the checkbox box is still in enabled state')

		WebUI.takeScreenshot()
	}
}

if (flag4 == false) {
	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxInEmailPreferances'))

	WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/SaveChangesButton'))

	if (!(WebUI.verifyElementPresent(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'),
	0, FailureHandling.OPTIONAL))) {
		KeywordUtil.markFailed('After modifying Monthly digest and clicking save changes button the Preferences saved flash message not shown')

		WebUI.takeScreenshot()
	}
	else
	{
		WebUI.click(findTestObject('ElementsUnderProfileAvatar/Email Settings/PreferenceSavedFlashMessage'))
	}

	if (!(WebUI.verifyElementChecked(findTestObject('ElementsUnderProfileAvatar/Email Settings/MonthlyDigestCheckBoxFieldCheckBoxField'),
	0))) {
		KeywordUtil.markFailed('After checking the Monthly digets and saved the checkbox box is still in Unchecked state')

		WebUI.takeScreenshot()
	}
}
