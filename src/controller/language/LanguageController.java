package controller.language;

import model.language.detailsLocation.EnglishLanguageDetailsLocation;
import model.language.detailsLocation.ItalianLanguageDetailsLocation;
import model.language.feedback.EnglishLanguageFeedback;
import model.language.feedback.ItalianLanguageFeedback;
import model.language.filteredSearchResultLocation.EnglishLanguageFilteredSearchResultLocation;
import model.language.filteredSearchResultLocation.ItalianLanguageFilteredSearchResultLocation;
import model.language.filteredSearchResultStructure.EnglishLanguageFilteredSearch;
import model.language.filteredSearchResultStructure.ItalianLanguageFilteredSearch;
import model.language.formLocation.EnglishLanguageFormLocation;
import model.language.formLocation.ItalianLanguageFormLocation;
import model.language.formStructure.EnglishLanguageFormStructure;
import model.language.formStructure.ItalianLanguageFormStructure;
import model.language.locationForStructure.EnglishLanguageLocationForStructure;
import model.language.locationForStructure.ItalianLanguageLocationForStructure;
import model.language.login.EnglishLanguageLogin;
import model.language.login.ItalianLanguageLogin;
import model.language.managementLocation.EnglishLanguageManagementLocation;
import model.language.managementLocation.ItalianLanguageManagementLocation;
import model.language.managementProfile.EnglishLanguageManagementProfile;
import model.language.managementProfile.ItalianLanguageManagementProfile;
import model.language.payment.EnglishLanguagePayment;
import model.language.payment.ItalianLanguagePayment;
import model.language.registration.EnglishLanguageRegistration;
import model.language.registration.ItalianLanguageRegistration;
import model.language.usersCommunicationForm.EnglishLanguageUsersCommunicationForm;
import model.language.usersCommunicationForm.ItalianLanguageUsersCommunicationForm;
import model.language.viewLocation.EnglishLanguageViewLocation;
import model.language.viewLocation.ItalianLanguageViewLocation;
import model.language.viewReservation.EnglishLanguageViewReservation;
import model.language.viewReservation.ItalianLanguageViewReservation;


public class LanguageController {

    public static void setItalianLanguage() {
        new ItalianLanguageFilteredSearch();
        new ItalianLanguageFormLocation();
        new ItalianLanguageFormStructure();
        new ItalianLanguageLogin();
        new ItalianLanguageManagementProfile();
        new ItalianLanguagePayment();
        new ItalianLanguageRegistration();
        new ItalianLanguageDetailsLocation();
        new ItalianLanguageLocationForStructure();
        new ItalianLanguageManagementLocation();
        new ItalianLanguageUsersCommunicationForm();
        new ItalianLanguageFeedback();
        new ItalianLanguageFilteredSearchResultLocation();
        new ItalianLanguageViewLocation();
        new ItalianLanguageViewReservation();

    }

    public static void setEnglishLanguage() {
        new EnglishLanguageFilteredSearch();
        new EnglishLanguageFormLocation();
        new EnglishLanguageFormStructure();
        new EnglishLanguageLogin();
        new EnglishLanguageManagementProfile();
        new EnglishLanguagePayment();
        new EnglishLanguageRegistration();
        new EnglishLanguageDetailsLocation();
        new EnglishLanguageLocationForStructure();
        new EnglishLanguageManagementLocation();
        new EnglishLanguageUsersCommunicationForm();
        new EnglishLanguageFeedback();
        new EnglishLanguageFilteredSearchResultLocation();
        new EnglishLanguageViewLocation();
        new EnglishLanguageViewReservation();

    }
}
