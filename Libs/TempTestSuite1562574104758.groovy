import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/VisitDays Test Suit for SchoolAdminUsers')

suiteProperties.put('name', 'VisitDays Test Suit for SchoolAdminUsers')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DELL\\Downloads\\tests copy\\tests copy 14-4-2019\\Reports\\VisitDays Test Suit for SchoolAdminUsers\\20190708_042144\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/VisitDays Test Suit for SchoolAdminUsers', suiteProperties, [new TestCaseBinding('Test Cases/Login and Logout/LoginAsSchoolAdmin', 'Test Cases/Login and Logout/LoginAsSchoolAdmin',  null), new TestCaseBinding('Test Cases/CreateLocationInpuFieldsVerification', 'Test Cases/CreateLocationInpuFieldsVerification',  null), new TestCaseBinding('Test Cases/AddAttendeeButtonAccessibility', 'Test Cases/AddAttendeeButtonAccessibility',  null), new TestCaseBinding('Test Cases/LeftNavElementsNavigationVerification', 'Test Cases/LeftNavElementsNavigationVerification',  null), new TestCaseBinding('Test Cases/DuplicateNameCheckForVisitTypeCreation', 'Test Cases/DuplicateNameCheckForVisitTypeCreation',  null), new TestCaseBinding('Test Cases/EditorAndAdminUsersCreateVisitButtonsVerifcation', 'Test Cases/EditorAndAdminUsersCreateVisitButtonsVerifcation',  null), new TestCaseBinding('Test Cases/ActiveAndArchiveTabsVerification', 'Test Cases/ActiveAndArchiveTabsVerification',  null), new TestCaseBinding('Test Cases/CreateVisitTypeButtonVerification', 'Test Cases/CreateVisitTypeButtonVerification',  null), new TestCaseBinding('Test Cases/SelectVisitTypeCategoryVerification', 'Test Cases/SelectVisitTypeCategoryVerification',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationInGlobalSearch', 'Test Cases/EmptyStateVerificationInGlobalSearch',  null), new TestCaseBinding('Test Cases/GlobalSearchButtonAccessibility', 'Test Cases/GlobalSearchButtonAccessibility',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationInActiveAndArchivedTabsInVisitTypes', 'Test Cases/EmptyStateVerificationInActiveAndArchivedTabsInVisitTypes',  null), new TestCaseBinding('Test Cases/VisitTypeCategoryVerification', 'Test Cases/VisitTypeCategoryVerification',  null), new TestCaseBinding('Test Cases/NavigateToCreateVisitFlowAfterCreationOfVisitType', 'Test Cases/NavigateToCreateVisitFlowAfterCreationOfVisitType',  null), new TestCaseBinding('Test Cases/VerifictionForValidationCheckModalBeforeDeletingVisitType', 'Test Cases/VerifictionForValidationCheckModalBeforeDeletingVisitType',  null), new TestCaseBinding('Test Cases/VerifictionForValidationCheckModalBeforeArchivingVisitType', 'Test Cases/VerifictionForValidationCheckModalBeforeArchivingVisitType',  null), new TestCaseBinding('Test Cases/QuestionsSearchBoxtest', 'Test Cases/QuestionsSearchBoxtest',  null), new TestCaseBinding('Test Cases/PermissionLevelVerificationForUsersInUsersPage', 'Test Cases/PermissionLevelVerificationForUsersInUsersPage',  null), new TestCaseBinding('Test Cases/ChangePermisssionAndDeactivateUserOptionsVerification', 'Test Cases/ChangePermisssionAndDeactivateUserOptionsVerification',  null), new TestCaseBinding('Test Cases/AdminUserProfileAccessibilityInUsersPage', 'Test Cases/AdminUserProfileAccessibilityInUsersPage',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationWhenNoSearchResultsFoundInTeams', 'Test Cases/EmptyStateVerificationWhenNoSearchResultsFoundInTeams',  null), new TestCaseBinding('Test Cases/SearchAdminUserTest', 'Test Cases/SearchAdminUserTest',  null), new TestCaseBinding('Test Cases/EmptyStateerificationWhenNoSearchResultsFoundInActiveTabInUsers', 'Test Cases/EmptyStateerificationWhenNoSearchResultsFoundInActiveTabInUsers',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationInUsers', 'Test Cases/EmptyStateVerificationInUsers',  null), new TestCaseBinding('Test Cases/SearchTeamTest', 'Test Cases/SearchTeamTest',  null), new TestCaseBinding('Test Cases/SearchVisitTypeTest', 'Test Cases/SearchVisitTypeTest',  null), new TestCaseBinding('Test Cases/AdminUserMenuVerificaionInAllPages', 'Test Cases/AdminUserMenuVerificaionInAllPages',  null), new TestCaseBinding('Test Cases/EmailPreferencesAccessVerifiction', 'Test Cases/EmailPreferencesAccessVerifiction',  null), new TestCaseBinding('Test Cases/AdminUserProfileAccessibilityTest', 'Test Cases/AdminUserProfileAccessibilityTest',  null), new TestCaseBinding('Test Cases/AddingNewAdminUserTest', 'Test Cases/AddingNewAdminUserTest',  null), new TestCaseBinding('Test Cases/EditTeamDetailsVerification', 'Test Cases/EditTeamDetailsVerification',  null), new TestCaseBinding('Test Cases/ReadOnlyModalVerificationForEachLocation', 'Test Cases/ReadOnlyModalVerificationForEachLocation',  null), new TestCaseBinding('Test Cases/SearchLocationsTest', 'Test Cases/SearchLocationsTest',  null), new TestCaseBinding('Test Cases/LocationsSortingVerification', 'Test Cases/LocationsSortingVerification',  null), new TestCaseBinding('Test Cases/DeleteLocationTest', 'Test Cases/DeleteLocationTest',  null), new TestCaseBinding('Test Cases/UploadInstitutionLogoTest', 'Test Cases/UploadInstitutionLogoTest',  null), new TestCaseBinding('Test Cases/AddAllowedDomainTestInAccountBasics', 'Test Cases/AddAllowedDomainTestInAccountBasics',  null), new TestCaseBinding('Test Cases/CreateTeamUserFlowToNotSetTeamPhoto', 'Test Cases/CreateTeamUserFlowToNotSetTeamPhoto',  null), new TestCaseBinding('Test Cases/SetMainContactPhoneNumberTest', 'Test Cases/SetMainContactPhoneNumberTest',  null), new TestCaseBinding('Test Cases/NotoficationPreferencesInCreateTeam', 'Test Cases/NotoficationPreferencesInCreateTeam',  null), new TestCaseBinding('Test Cases/GeneratePreviewTestInMobi', 'Test Cases/GeneratePreviewTestInMobi',  null), new TestCaseBinding('Test Cases/QuestionsSearchEmptyStateMessageVerification', 'Test Cases/QuestionsSearchEmptyStateMessageVerification',  null), new TestCaseBinding('Test Cases/EditEventInDetailsPageTest', 'Test Cases/EditEventInDetailsPageTest',  null), new TestCaseBinding('Test Cases/EmailFieldShouldNotBeEditable', 'Test Cases/EmailFieldShouldNotBeEditable',  null), new TestCaseBinding('Test Cases/EmptyStateVerifiacationForVisitTypeSearch', 'Test Cases/EmptyStateVerifiacationForVisitTypeSearch',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationInAnaliticsVisitTypeFilter', 'Test Cases/EmptyStateVerificationInAnaliticsVisitTypeFilter',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationInVisitTypesWhenSearchResultsNotFound', 'Test Cases/EmptyStateVerificationInVisitTypesWhenSearchResultsNotFound',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationOfDateRangeFilterInIndexPage', 'Test Cases/EmptyStateVerificationOfDateRangeFilterInIndexPage',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationOfVisitTypeFilterInIndexPage', 'Test Cases/EmptyStateVerificationOfVisitTypeFilterInIndexPage',  null), new TestCaseBinding('Test Cases/EmptyStateVerificationWhenNoSearchResultsFoundInLocations', 'Test Cases/EmptyStateVerificationWhenNoSearchResultsFoundInLocations',  null), new TestCaseBinding('Test Cases/FiltersVerificationInIndexPage', 'Test Cases/FiltersVerificationInIndexPage',  null), new TestCaseBinding('Test Cases/VisitTypeNameOnVisitCardVerifiation', 'Test Cases/VisitTypeNameOnVisitCardVerifiation',  null), new TestCaseBinding('Test Cases/PreventingFromRemoveFiltersWhenAtleastOneFilterIsWasApplied', 'Test Cases/PreventingFromRemoveFiltersWhenAtleastOneFilterIsWasApplied',  null), new TestCaseBinding('Test Cases/VisitTypeCountVerificationOnQuestions', 'Test Cases/VisitTypeCountVerificationOnQuestions',  null), new TestCaseBinding('Test Cases/VisitTypeAndStatusFiltersVerification', 'Test Cases/VisitTypeAndStatusFiltersVerification',  null), new TestCaseBinding('Test Cases/ShowAndHideFiterTestInAnalytics', 'Test Cases/ShowAndHideFiterTestInAnalytics',  null), new TestCaseBinding('Test Cases/TodayShortCutTestInDateRangeCalander', 'Test Cases/TodayShortCutTestInDateRangeCalander',  null), new TestCaseBinding('Test Cases/VerificationOfWarningMessageWhileClosingMobi', 'Test Cases/VerificationOfWarningMessageWhileClosingMobi',  null), new TestCaseBinding('Test Cases/VerificatonOfGroupName, GuestCountAndBusIconInGroupProfile', 'Test Cases/VerificatonOfGroupName, GuestCountAndBusIconInGroupProfile',  null), new TestCaseBinding('Test Cases/Verify the Active and deactivated buttons in Team management', 'Test Cases/Verify the Active and deactivated buttons in Team management',  null), new TestCaseBinding('Test Cases/VisitCardStylingVerificationForDraft, PublishedAndCanceledVisits', 'Test Cases/VisitCardStylingVerificationForDraft, PublishedAndCanceledVisits',  null), new TestCaseBinding('Test Cases/CheckInAndNotHereVerificationInRegisteredTabForOff-Campus', 'Test Cases/CheckInAndNotHereVerificationInRegisteredTabForOff-Campus',  null), new TestCaseBinding('Test Cases/CheckInAndNotHereVerificationsInRegisteredTabForDailyVisits', 'Test Cases/CheckInAndNotHereVerificationsInRegisteredTabForDailyVisits',  null), new TestCaseBinding('Test Cases/CheckInAllAndNotHereAllVerificationInRegisteredTabForDailyVisits', 'Test Cases/CheckInAllAndNotHereAllVerificationInRegisteredTabForDailyVisits',  null), new TestCaseBinding('Test Cases/CheckInAndNotHereVerificationInRegisteredTabForEvents', 'Test Cases/CheckInAndNotHereVerificationInRegisteredTabForEvents',  null), new TestCaseBinding('Test Cases/CheckInAllAndNotHereAllVerificationsInRegisteredTabForOff-Campus', 'Test Cases/CheckInAllAndNotHereAllVerificationsInRegisteredTabForOff-Campus',  null), new TestCaseBinding('Test Cases/CheckInAllAndNotHereAllVerificationsInRegisteredTabForEvents', 'Test Cases/CheckInAllAndNotHereAllVerificationsInRegisteredTabForEvents',  null), new TestCaseBinding('Test Cases/EmptyState, 3DotMenuOptionsAndUserProfileAccessiblityTestInRegisteredTab', 'Test Cases/EmptyState, 3DotMenuOptionsAndUserProfileAccessiblityTestInRegisteredTab',  null), new TestCaseBinding('Test Cases/CancelButtonShouldNotSaveTheModificationsMadeInTimesAndBlackoutDatesInSummaryPage', 'Test Cases/CancelButtonShouldNotSaveTheModificationsMadeInTimesAndBlackoutDatesInSummaryPage',  null), new TestCaseBinding('Test Cases/ArchivedVisitTypeshouldNotShowWhileCreatingVisit', 'Test Cases/ArchivedVisitTypeshouldNotShowWhileCreatingVisit',  null), new TestCaseBinding('Test Cases/CancelRegistrationOfGroupTest', 'Test Cases/CancelRegistrationOfGroupTest',  null), new TestCaseBinding('Test Cases/CancelRegistrationOfIndividualTest', 'Test Cases/CancelRegistrationOfIndividualTest',  null), new TestCaseBinding('Test Cases/VerificationOfFirst, LastNameAndNumberOfGuestsInRegisteredIndividualStudentProfile', 'Test Cases/VerificationOfFirst, LastNameAndNumberOfGuestsInRegisteredIndividualStudentProfile',  null), new TestCaseBinding('Test Cases/VerificationOfFilterFiltersInIndexPage', 'Test Cases/VerificationOfFilterFiltersInIndexPage',  null), new TestCaseBinding('Test Cases/MergeRecordsTestForSameVisits (DailyVisits)', 'Test Cases/MergeRecordsTestForSameVisits (DailyVisits)',  null), new TestCaseBinding('Test Cases/MergeRecordsTestForSameVisits (Events)', 'Test Cases/MergeRecordsTestForSameVisits (Events)',  null), new TestCaseBinding('Test Cases/MergeRecordsTestForSameVisits (Off-Campus)', 'Test Cases/MergeRecordsTestForSameVisits (Off-Campus)',  null), new TestCaseBinding('Test Cases/CancelVisitTest (DailyVisits)', 'Test Cases/CancelVisitTest (DailyVisits)',  null), new TestCaseBinding('Test Cases/CancelVisitTest (Events)', 'Test Cases/CancelVisitTest (Events)',  null), new TestCaseBinding('Test Cases/CancelVisitTest (Off-Campus)', 'Test Cases/CancelVisitTest (Off-Campus)',  null), new TestCaseBinding('Test Cases/WhoYouWillMeetProfileTestsInMobiForDailyVisits', 'Test Cases/WhoYouWillMeetProfileTestsInMobiForDailyVisits',  null), new TestCaseBinding('Test Cases/WhoYouWillMeetProfileTestsInMobiForEvents', 'Test Cases/WhoYouWillMeetProfileTestsInMobiForEvents',  null), new TestCaseBinding('Test Cases/WhoYouWillMeetProfileTestsInMobiForOff-Campus', 'Test Cases/WhoYouWillMeetProfileTestsInMobiForOff-Campus',  null), new TestCaseBinding('Test Cases/VerificationOfOffCampusLocationsAndOnCampusLocationsWhileCreatingVisits', 'Test Cases/VerificationOfOffCampusLocationsAndOnCampusLocationsWhileCreatingVisits',  null), new TestCaseBinding('Test Cases/VisitorInsightsTestForDailyVisits', 'Test Cases/VisitorInsightsTestForDailyVisits',  null), new TestCaseBinding('Test Cases/VisitorInsightsTestForEvents', 'Test Cases/VisitorInsightsTestForEvents',  null), new TestCaseBinding('Test Cases/VisitorInsightsTestForOffCampus', 'Test Cases/VisitorInsightsTestForOffCampus',  null), new TestCaseBinding('Test Cases/DailyVisitsShouldNotShowInotherVisitCategoryIndexPage', 'Test Cases/DailyVisitsShouldNotShowInotherVisitCategoryIndexPage',  null), new TestCaseBinding('Test Cases/EventsShouldNotShowInotherVisitCategoryIndexPage', 'Test Cases/EventsShouldNotShowInotherVisitCategoryIndexPage',  null), new TestCaseBinding('Test Cases/Off-CampusVisitsShouldNotShowInotherVisitCategoryIndexPage', 'Test Cases/Off-CampusVisitsShouldNotShowInotherVisitCategoryIndexPage',  null), new TestCaseBinding('Test Cases/EditDailyVisitInDetailsPageTest', 'Test Cases/EditDailyVisitInDetailsPageTest',  null), new TestCaseBinding('Test Cases/EditOff-CampusInDetailsPageTest', 'Test Cases/EditOff-CampusInDetailsPageTest',  null), new TestCaseBinding('Test Cases/DeletedTeamsShouldNotShownInUserAssignedFilter', 'Test Cases/DeletedTeamsShouldNotShownInUserAssignedFilter',  null), new TestCaseBinding('Test Cases/EventEndTimeShouldNotBeEarlierThanStartTime', 'Test Cases/EventEndTimeShouldNotBeEarlierThanStartTime',  null), new TestCaseBinding('Test Cases/AssignedTeamsAndUsersAppearOnVisitCardAndStudentProfile (Event)', 'Test Cases/AssignedTeamsAndUsersAppearOnVisitCardAndStudentProfile (Event)',  null), new TestCaseBinding('Test Cases/AssignedTeamsAndUsersAppearOnVisitCardAndStudentProfile (Off-Campus)', 'Test Cases/AssignedTeamsAndUsersAppearOnVisitCardAndStudentProfile (Off-Campus)',  null), new TestCaseBinding('Test Cases/AssignedTeamsAndUsersAppearOnVisitCardAndUserProfile (Daily Visits)', 'Test Cases/AssignedTeamsAndUsersAppearOnVisitCardAndUserProfile (Daily Visits)',  null), new TestCaseBinding('Test Cases/FullCapacityOrFullRegistrationWarningsVerification(Daily Visits)', 'Test Cases/FullCapacityOrFullRegistrationWarningsVerification(Daily Visits)',  null), new TestCaseBinding('Test Cases/FullCapacityOrFullRegistrationWarningsVerification(Events)', 'Test Cases/FullCapacityOrFullRegistrationWarningsVerification(Events)',  null), new TestCaseBinding('Test Cases/FullCapacityOrFullRegistrationWarningsVerification(Off-Campus)', 'Test Cases/FullCapacityOrFullRegistrationWarningsVerification(Off-Campus)',  null), new TestCaseBinding('Test Cases/MobiRegistration_ClosedMessagingVerification (Daily Visits)', 'Test Cases/MobiRegistration_ClosedMessagingVerification (Daily Visits)',  null), new TestCaseBinding('Test Cases/MobiRegistration_ClosedMessagingVerification (Events)', 'Test Cases/MobiRegistration_ClosedMessagingVerification (Events)',  null), new TestCaseBinding('Test Cases/MobiRegistration_ClosedMessagingVerification (Off-Campus)', 'Test Cases/MobiRegistration_ClosedMessagingVerification (Off-Campus)',  null), new TestCaseBinding('Test Cases/MobiVisitIn_ProgressMessagingVerification (Daily Visit)', 'Test Cases/MobiVisitIn_ProgressMessagingVerification (Daily Visit)',  null), new TestCaseBinding('Test Cases/MobiVisitIn_ProgressMessagingVerification (Events)', 'Test Cases/MobiVisitIn_ProgressMessagingVerification (Events)',  null), new TestCaseBinding('Test Cases/MobiVisitIn_ProgressMessagingVerification (Off-Campus)', 'Test Cases/MobiVisitIn_ProgressMessagingVerification (Off-Campus)',  null), new TestCaseBinding('Test Cases/InvalidTimesVerificationWhileCreatingDailyVisit', 'Test Cases/InvalidTimesVerificationWhileCreatingDailyVisit',  null), new TestCaseBinding('Test Cases/InvalidTimesVerificationWhileCreatingEvent', 'Test Cases/InvalidTimesVerificationWhileCreatingEvent',  null), new TestCaseBinding('Test Cases/InvalidTimesVerificationWhileCreatingOff-Campus', 'Test Cases/InvalidTimesVerificationWhileCreatingOff-Campus',  null), new TestCaseBinding('Test Cases/VerificationOfVisitDateAndTimeOnPublishedVisits (Daily Visits)', 'Test Cases/VerificationOfVisitDateAndTimeOnPublishedVisits (Daily Visits)',  null), new TestCaseBinding('Test Cases/VerificationOfVisitDateAndTimeOnPublishedVisits (Events)', 'Test Cases/VerificationOfVisitDateAndTimeOnPublishedVisits (Events)',  null), new TestCaseBinding('Test Cases/VerificationOfVisitDateAndTimeOnPublishedVisits (Off-Campus)', 'Test Cases/VerificationOfVisitDateAndTimeOnPublishedVisits (Off-Campus)',  null), new TestCaseBinding('Test Cases/EditDailyVIsitInSummaryPage', 'Test Cases/EditDailyVIsitInSummaryPage',  null), new TestCaseBinding('Test Cases/EditEventInSummaryPage', 'Test Cases/EditEventInSummaryPage',  null), new TestCaseBinding('Test Cases/EditOff-CampusInSummaryPage', 'Test Cases/EditOff-CampusInSummaryPage',  null), new TestCaseBinding('Test Cases/EditPipelineValuesTest', 'Test Cases/EditPipelineValuesTest',  null), new TestCaseBinding('Test Cases/EditDetailsAndStatusTimestampsVerificationInUserProfile', 'Test Cases/EditDetailsAndStatusTimestampsVerificationInUserProfile',  null), new TestCaseBinding('Test Cases/VerificationOfStatusInStudentProfileWhenRegisteredFromMobi (Daily visits)', 'Test Cases/VerificationOfStatusInStudentProfileWhenRegisteredFromMobi (Daily visits)',  null), new TestCaseBinding('Test Cases/VerificationOfStatusInStudentProfileWhenRegisteredFromMobi (Events)', 'Test Cases/VerificationOfStatusInStudentProfileWhenRegisteredFromMobi (Events)',  null), new TestCaseBinding('Test Cases/VerificationOfStatusInStudentProfileWhenRegisteredFromMobi (Off-Campus)', 'Test Cases/VerificationOfStatusInStudentProfileWhenRegisteredFromMobi (Off-Campus)',  null), new TestCaseBinding('Test Cases/SearchVisitTypeTestInAddVisitToItineraryModal', 'Test Cases/SearchVisitTypeTestInAddVisitToItineraryModal',  null), new TestCaseBinding('Test Cases/AssignedUserIconShouldShowInVisitTypeVisitsPage (Daily Visit)', 'Test Cases/AssignedUserIconShouldShowInVisitTypeVisitsPage (Daily Visit)',  null), new TestCaseBinding('Test Cases/EnableQuestionTest', 'Test Cases/EnableQuestionTest',  null), new TestCaseBinding('Test Cases/AddingTeamMembersWhileCreatingTeam', 'Test Cases/AddingTeamMembersWhileCreatingTeam',  null), new TestCaseBinding('Test Cases/AssignedUserIconShouldShowInVisitTypeVisitsPage (Events)', 'Test Cases/AssignedUserIconShouldShowInVisitTypeVisitsPage (Events)',  null), new TestCaseBinding('Test Cases/AssignedUserIconShouldShowInVisitTypeVisitsPage (Off-Campus)', 'Test Cases/AssignedUserIconShouldShowInVisitTypeVisitsPage (Off-Campus)',  null), new TestCaseBinding('Test Cases/BackButtonShouldbeHiddenInEVRAndEVRCPages', 'Test Cases/BackButtonShouldbeHiddenInEVRAndEVRCPages',  null), new TestCaseBinding('Test Cases/CancelButtonShouldNotSaveTheModificationsMadeInTimesAndBlackoutDatesInSummaryPage', 'Test Cases/CancelButtonShouldNotSaveTheModificationsMadeInTimesAndBlackoutDatesInSummaryPage',  null), new TestCaseBinding('Test Cases/CapacityFilledAndCheckInBarVerificationOnVIsitCardInIndexPage (Daily Visits)', 'Test Cases/CapacityFilledAndCheckInBarVerificationOnVIsitCardInIndexPage (Daily Visits)',  null), new TestCaseBinding('Test Cases/CapacityFilledAndCheckInBarVerificationOnVIsitCardInIndexPage (Events)', 'Test Cases/CapacityFilledAndCheckInBarVerificationOnVIsitCardInIndexPage (Events)',  null), new TestCaseBinding('Test Cases/CapacityFilledAndCheckInBarVerificationOnVIsitCardInIndexPage (Off-Campus)', 'Test Cases/CapacityFilledAndCheckInBarVerificationOnVIsitCardInIndexPage (Off-Campus)',  null), new TestCaseBinding('Test Cases/CurrentCapacityFilterTestForSeatsAtCapacityAndRegistrationsAtCapacity', 'Test Cases/CurrentCapacityFilterTestForSeatsAtCapacityAndRegistrationsAtCapacity',  null), new TestCaseBinding('Test Cases/DeleteAllCanceledVisitsTest (Daily Visits)', 'Test Cases/DeleteAllCanceledVisitsTest (Daily Visits)',  null), new TestCaseBinding('Test Cases/DeleteAllCanceledVisitsTest (Events)', 'Test Cases/DeleteAllCanceledVisitsTest (Events)',  null), new TestCaseBinding('Test Cases/DeleteAllCanceledVisitsTest (Off-Campus)', 'Test Cases/DeleteAllCanceledVisitsTest (Off-Campus)',  null), new TestCaseBinding('Test Cases/DeleteAllDraftedVisitsTest (Daily Visits)', 'Test Cases/DeleteAllDraftedVisitsTest (Daily Visits)',  null), new TestCaseBinding('Test Cases/DeleteAllDraftedVisitsTest (Events)', 'Test Cases/DeleteAllDraftedVisitsTest (Events)',  null), new TestCaseBinding('Test Cases/DeleteAllDraftedVisitsTest (Off-Campus)', 'Test Cases/DeleteAllDraftedVisitsTest (Off-Campus)',  null), new TestCaseBinding('Test Cases/DetailsPageAndUnsavedChangesModalVerificationInUserprofile', 'Test Cases/DetailsPageAndUnsavedChangesModalVerificationInUserprofile',  null), new TestCaseBinding('Test Cases/DuplicateDailyVisitTest', 'Test Cases/DuplicateDailyVisitTest',  null), new TestCaseBinding('Test Cases/DuplicateEventTest', 'Test Cases/DuplicateEventTest',  null), new TestCaseBinding('Test Cases/DuplicateOff-CampusVisitTest', 'Test Cases/DuplicateOff-CampusVisitTest',  null), new TestCaseBinding('Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Daily Visit)', 'Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Daily Visit)',  null), new TestCaseBinding('Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Event)', 'Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Event)',  null), new TestCaseBinding('Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Off-Campus)', 'Test Cases/MergeUserInTheSameVisitAndVerifyStatusMessageInProfile (Off-Campus)',  null), new TestCaseBinding('Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType (Daily Visit)', 'Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType (Daily Visit)',  null), new TestCaseBinding('Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType( Event)', 'Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType( Event)',  null), new TestCaseBinding('Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType(Off-Campus)', 'Test Cases/Pre-fillVisitTypeAfterCreatingNewVisitType(Off-Campus)',  null), new TestCaseBinding('Test Cases/DeletedVisitTypesShouldNotShowInVisitTypeFilter', 'Test Cases/DeletedVisitTypesShouldNotShowInVisitTypeFilter',  null), new TestCaseBinding('Test Cases/EditNumberOfAttendeesInUserProfileTest', 'Test Cases/EditNumberOfAttendeesInUserProfileTest',  null), new TestCaseBinding('Test Cases/EmptyStateVerificatioInCheckInPage', 'Test Cases/EmptyStateVerificatioInCheckInPage',  null), new TestCaseBinding('Test Cases/GlobalSearchTest', 'Test Cases/GlobalSearchTest',  null), new TestCaseBinding('Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Daily Visits)', 'Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Daily Visits)',  null), new TestCaseBinding('Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Events)', 'Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Events)',  null), new TestCaseBinding('Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Off-Campus)', 'Test Cases/Mobi-MobileNumberValidationTestForInternationalNumber (Off-Campus)',  null), new TestCaseBinding('Test Cases/RegisteredGroupCountVerificationOnVisitCard', 'Test Cases/RegisteredGroupCountVerificationOnVisitCard',  null), new TestCaseBinding('Test Cases/RegisteredIndividualsAndCombinationOfGroupAndIndividualRegistrantsCountVerificaitonOnTheVisitCard', 'Test Cases/RegisteredIndividualsAndCombinationOfGroupAndIndividualRegistrantsCountVerificaitonOnTheVisitCard',  null), new TestCaseBinding('Test Cases/SearchVisitTypeWithUpperCaseLettersTestInQuestions', 'Test Cases/SearchVisitTypeWithUpperCaseLettersTestInQuestions',  null), new TestCaseBinding('Test Cases/Surveys -Student App Tests/Survey404PageVerification', 'Test Cases/Surveys -Student App Tests/Survey404PageVerification',  null), new TestCaseBinding('Test Cases/VerifyAccessiblityNeedQuestionShouldNotHaveButtonToEnableOrDisableIt', 'Test Cases/VerifyAccessiblityNeedQuestionShouldNotHaveButtonToEnableOrDisableIt',  null), new TestCaseBinding('Test Cases/VisitRegistrationStatusesVerificationInUserProfile', 'Test Cases/VisitRegistrationStatusesVerificationInUserProfile',  null), new TestCaseBinding('Test Cases/WhileCreatingDailyVisitValidationErrorShouldBeShownIfUserNotSelectsAtleastOneDay', 'Test Cases/WhileCreatingDailyVisitValidationErrorShouldBeShownIfUserNotSelectsAtleastOneDay',  null), new TestCaseBinding('Test Cases/EnableAndDisableAdminDigestEmailsTest', 'Test Cases/EnableAndDisableAdminDigestEmailsTest',  null), new TestCaseBinding('Test Cases/DraftedAndCanceledVisitsShouldNotShowInCheckInPage', 'Test Cases/DraftedAndCanceledVisitsShouldNotShowInCheckInPage',  null), new TestCaseBinding('Test Cases/AccessibilityNeedLabelVerification(Daily Visit)', 'Test Cases/AccessibilityNeedLabelVerification(Daily Visit)',  null), new TestCaseBinding('Test Cases/AccessibilityNeedLabelVerification(Event)', 'Test Cases/AccessibilityNeedLabelVerification(Event)',  null), new TestCaseBinding('Test Cases/AccessibilityNeedLabelVerification(Off-Campus)', 'Test Cases/AccessibilityNeedLabelVerification(Off-Campus)',  null), new TestCaseBinding('Test Cases/Login and Logout/Logout', 'Test Cases/Login and Logout/Logout',  null), new TestCaseBinding('Test Cases/CloseBrowser', 'Test Cases/CloseBrowser',  null)])
