import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.SignupforStudentType'()

String usermail=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterEmail'()

String password=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterPassword'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterStudentType'()

String nameOne=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterFirstName'()

println nameOne

String nameTwo=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastName'()

println nameTwo

String mobNum=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterStudentMobileNumber'()

println mobNum

String city=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterAddressDetails'()

println city

WebUI.delay(7)

String dateOfBirth=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterDOB'()

println dateOfBirth

String school=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterLastSchoolstudied'()

println school

String programs=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterOrSelectPrograms'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectMajorsOptionFromDropDown'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectApplicantType'()

String highSchoolGraduationYear=CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterHighSchoolGraduationYear'()

println highSchoolGraduationYear

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.enterEnrollmentYear'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectEthnicityField'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectGender'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.selectReferredByOption'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.SignUpFlow.clickContinueAfterEnteringStudentDetails'()

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.Logout.logoutfromStudentApp'()

String[] inarray1 = new String[7]

inarray1[0]=nameOne

inarray1[1]=nameTwo

inarray1[2]=city

inarray1[3]=dateOfBirth

inarray1[4]=school

inarray1[5]=highSchoolGraduationYear

inarray1[6]=mobNum

CustomKeywords.'com.CommonUtilitiesofNACACstudentApp.LoginToStudentApp.loginToStudentApp'(usermail,password)

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/PersonIconAccountBasics'))

def Email=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/HomePageElements/GetEmaildetailsFromAccountBasicsPage'))

println Email

WebUI.click(findTestObject('Object Repository/NacacStudentApp/HomePageElements/personaldetails page/PersonalInfoTab'))

String firstName=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/FirstNameFIeld'),'value')

println firstName

String secondName=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/LastNameFIeld'),'value')

println secondName

String homeaddressline1=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/AddressLineOne'),'value')

println homeaddressline1

String homeAddressline2=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/AddressLineTwo'),'value')

println homeAddressline2

String cityName=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/cityField'),'value')

println cityName

String DOB=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/dobField'), 'value')

println DOB

String schoolName=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/CurrentOrLastSchoolField'), 'value')

println schoolName

String highSchoolYear=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/GraduationYearField'), 'value')

println highSchoolYear

String getMobNum=WebUI.getAttribute(findTestObject('Object Repository/NacacStudentApp/PersonalInfo/PhoneNumberField'), 'value')

println getMobNum

//def CurrentOrLastSchool=WebUI.getText(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/Current or Last School'))
WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FirstYearCollegeStudent'),0)

if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/NacacStudentApp/SignUpPage/InternationalStudent'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("international student type checkbox is not marked/checked in personal info page")
}

WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/spring2021'),0)

if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/NacacStudentApp/SignUpPage/spring2022'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("intended enrollment year checkbox is not marked/checked in personal info page")
}
WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/American or Indian checkbox'), 0)

if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/NacacStudentApp/SignUpPage/WhiteCheckBox'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("Ethnicity checkbox white is not marked/checked in personal info page")
}
WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FemaleOption'), 0)

if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/MaleOption'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("male checkbox/radio button is not marked/checked in personal info page")
}
WebUI.scrollToElement(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FriendsOption'), 0)

if(!(WebUI.verifyElementChecked(findTestObject('Object Repository/NacacStudentApp/SignUpPage/StudentdetailsPage/FriendsOption'), 0, FailureHandling.OPTIONAL)))
{
	KeywordUtil.markFailed("referal checkbox/radio button friends is not marked/checked in personal info page")
}

String[] inarray2 = new String[7]

inarray2[0]=firstName

inarray2[1]=secondName

inarray2[2]=cityName

inarray2[3]=DOB

inarray2[4]=schoolName

inarray2[5]=highSchoolYear

inarray2[6]=getMobNum

//Object[] array1 = {inarray1};  // array1 have only one element
//Object[] array2 = {inarray2};
//if (!(Arrays.equals(array1, array2)))
//{
//	KeywordUtil.markFailed("In personal info page details are showing incorrect")
//}
int sizeOfArray=inarray1.length

for(int i=0;i<sizeOfArray;i++)
{
	if(inarray1[i] != inarray2[i])
	{
		KeywordUtil.markFailed(inarray1[i]+" doesn't match with the "+inarray2[i])
	}
}

