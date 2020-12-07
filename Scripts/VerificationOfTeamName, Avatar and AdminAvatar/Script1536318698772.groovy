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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'com.CommonUtilities.LoginAsDifferentUserPermissions.NavigateToHomePage'()

WebUI.click(findTestObject('HomePageElements/MyTeamLeftNav'))

WebUI.click(findTestObject('TeamManagement/TeamsTab'))

WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamButton'))

Random RandNum = new Random()

String TeamName = 'TesetTeam' + RandNum.nextInt(100000)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamNameTextBoxInCreateTeamPage'), TeamName)

WebUI.sendKeys(findTestObject('TeamManagement/Teams/TeamBioTextFieldInTeamDetailsPage'), TeamBio)

WebUI.click(findTestObject('TeamManagement/Teams/AddNowButonInTeamPhotoDivision'))

String userDir = System.getProperty('user.dir')

WebUI.uploadFile(findTestObject('TeamManagement/Teams/UploadZoneInTeamPhotoDivisionInTeamDetailsPage'), userDir + '\\VisitTypePhoto\\albright college.png')

WebUI.click(findTestObject('VisitTypesPage/ApplyButtonInVisitTypePhotoPopup'))

String TeamImage = driver.findElement(By.xpath('//p[@class=\'margin-t-20 flex-center\']//img')).getAttribute('src')

WebUI.click(findTestObject('TeamManagement/Teams/AddMembersButtonButtonInCreateTeamButton'))

WebUI.click(findTestObject('DailyVisitsPage/AdminUserInAssignRequestOwnerList'))

WebUI.click(findTestObject('TeamManagement/Teams/DoneButtonInUpdateTeamMembersModal'))

String TeamMemberProfileWhileCreatingTeam = driver.findElement(By.xpath("//div[text()='Members']//../../..//div[@class='avatar margin-r-5']/img")).getAttribute('src')

WebUI.click(findTestObject('TeamManagement/Teams/SelectAllButtonInNotificationPreferancesDivision'))

WebUI.click(findTestObject('TeamManagement/Teams/CreateTeamButtonInCreateTeamPage'))

WebUI.verifyElementPresent(findTestObject('TeamManagement/Teams/SearchBoxInTeamsTab'), 0)

//String TeamAvatarInTeamsPage = driver.findElement(By.xpath("(//div[text()='"+TeamName+"']//parent::div//div[@class='avatar margin-r-5']/img)[1]")).getAttribute('src')

//div[text()='Members']//../../..//div[@class="avatar margin-r-5"]/img

String TeamMemberProfileInTeamsList = driver.findElement(By.xpath("(//div[text()='"+TeamName+"']//..//div[@class='avatar margin-r-5']/img)[2]")).getAttribute('src')

WebUI.verifyMatch(TeamMemberProfileWhileCreatingTeam, TeamMemberProfileInTeamsList, false)

driver.findElement(By.xpath("//div[text()='"+TeamName+"']")).isDisplayed()






