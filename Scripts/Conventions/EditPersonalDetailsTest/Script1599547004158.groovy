import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToNacacHomePage'()

WebUI.waitForElementPresent(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonIconAccountBasics'),0)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonIconAccountBasics'))

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/PersonalInfoTab'))

def firstName=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/FirstnameDetails'))

def lastName=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/lastName'))

def addressLine1=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/AddressLineOne'))

def addressLine2=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/AddressLine2'))

def city=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/CityField'))

Random rd=new Random()

def edit=rd.nextInt(1000)

def firstNameEdit=firstName+edit

def lastNameEdit=lastName+edit

def addressLine1Edit=addressLine1+edit

def addressLine2Edit=addressLine2+edit

def cityEdit=city+edit

WebUI.clearText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/FirstnameDetails'))

WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/FirstnameDetails'),firstNameEdit)

WebUI.clearText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/lastName'))

WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/lastName'),lastNameEdit)

WebUI.clearText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/AddressLineOne'))

WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/AddressLineOne'),addressLine1Edit)

WebUI.clearText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/AddressLine2'))

WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/AddressLine2'),addressLine2Edit)

WebUI.clearText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/CityField'))

WebUI.sendKeys(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/CityField'),cityEdit)

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/SaveDetailsButton'), 10)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/SaveDetailsButton'))







