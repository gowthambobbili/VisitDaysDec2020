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

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterFirstName'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastName'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterAddressDetails'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterDOB'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastSchoolstudied'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectApplicantType'()
