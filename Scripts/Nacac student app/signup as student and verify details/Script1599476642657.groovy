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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.SignupforStudentType'()

def usermail=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterEmail'()

def password=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterPassword'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterStudentType'()

def nameone=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterFirstName'()

def nametwo=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastName'()

def city=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterAddressDetails'()

WebUI.delay(7)

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterDOB'()

def school=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastSchoolstudied'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectApplicantType'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.Logout.logoutfromStudentApp'()

def map1=[:]

map1["mail"]=usermail

map1["1stname"]=nameone

map1["2ndname"]=nametwo

map1["city"]=city

map1["school"]=school

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.LoginToStudentApp.loginToStudentApp'(usermail,password)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonIconAccountBasics'))

def Email=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/GetEmaildetailsFromAccountBasicsPage'))

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/PersonalInfoTab'))

def firstname=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FirstnameTextField'))

def secondname=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/LastNameTextField'))

def Homeaddressline1=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/AddressLineOne'))

def HomeAddressline2=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/AddressLineTwo'))

def cityname=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/CityTextField'))

def CurrentOrLastSchool=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/Current or Last School'))

def map2=[:]

map2["mail"]=Email

map2["1stname"]=firstname

map2["2ndname"]=secondname

map2["city"]=cityname

map2["school"]=CurrentOrLastSchool

def static equals(Map map1, Map map2) {
	if (!map2.keySet().containsAll(map1.keySet())) return false
map1.every { it.value == map2[it.key] }


}

