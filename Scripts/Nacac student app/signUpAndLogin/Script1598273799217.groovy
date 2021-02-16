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

String usermail=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterEmail'()

String password=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterPassword'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterStudentType'()

String nameone=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterFirstName'()

String nametwo=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastName'()

String mobNum=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterStudentMobileNumber'()

String city=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterAddressDetails'()

WebUI.delay(7)

String dateOfBirth=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterDOB'()

String school=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastSchoolstudied'()

String programs=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterOrSelectPrograms'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectApplicantType'()

String highSchoolGraduationYear=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterHighSchoolGraduationYear'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterEnrollmentYear'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectEthnicityField'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectGender'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectReferredByOption'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.clickContinueAfterEnteringStudentDetails'()