import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.Clipboard as Clipboard
import java.awt.datatransfer.DataFlavor as DataFlavor
import java.awt.datatransfer.Transferable as Transferable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import groovy.json.JsonSlurper as JsonSlurper
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

not_run: CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.LoginAsSchoolAdmin'()

not_run: CustomKeywords.'com.CommonUtilities.PageNavigations.NavigateToDailyVisits'()

not_run: WebUiBuiltInKeywords.waitForElementPresent(findTestObject('DailyVisitsPage/CreateDailyVisitButton'), 0)

not_run: WebUI.click(findTestObject('DailyVisitsPage/CreateDailyVisitButton'))

not_run: WebUiBuiltInKeywords.waitForElementPresent(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), 0)

not_run: WebUiBuiltInKeywords.click(findTestObject('DailyVisitsPage/VisitTypeFieldInDailyVisit'), FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'com.CommonUtilities.MultipleObjectOperations.GetVisitTypesFromVisitTypeDropDownWhileCreating'()
//List var = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/DailyVisitsPage/allvisittypes'), 0)
not_run: CustomKeywords.'com.CommonUtilities.MultipleObjectOperations.GetVisitTypesFromVisitTypeDropDownWhileCreating'()

//String[] allNames = new String[1000]
//for (int j = 0; j < var.size; j++)
//{
//	allNames[j] = var[j].getText()
//
//	println(var[j].getText())
//
//	println(j)
//}
//WebUI.click(findTestObject('HomePageElements/VisitTypesLeftNav'))
not_run: println(allNames[1])

not_run: println(allNames[2])

not_run: WebUI.delay(15)

not_run: WebUI.click(findTestObject('VisitTypesPage/AppcuesPopupbutton'))

not_run: WebUI.verifyElementPresent(findTestObject('AlbrightSelected'), 0)

not_run: WebUI.click(findTestObject('AlbrightCollege'))

not_run: WebUI.click(findTestObject('HomePageElements/ProfileAvatar'))

not_run: Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard()

not_run: Transferable t = cb.getContents(cb)

not_run: println(t.getTransferData(DataFlavor.stringFlavor))

not_run: CustomKeywords.'com.CommonUtilities.Promote.addColumn'(((['mahesh', 'ashraf', 'masthan']) as String[]))

println CustomKeywords.'com.CommonUtilities.ApiCalls.registerIndividual'(["visitId":"1813804", "visitTypeId":"119771"]).get("surveyCode")

