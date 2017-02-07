/**
 * Created by andreacifola on 20/12/16.
 */

function validateUser(form) {
    fail = validateName(form.forename.value);
    fail += validateSurname(form.surname.value);
    fail += validateCity(form.city.value);
    fail += validateAddress(form.address.value);
    fail += validateDate(form.date.value);
    fail += getAge(form.date.value);
    fail += validateEmail(form.email.value);
    fail += validateUsername(form.username.value);
    fail += validatePassword(form.password.value);
    fail += validateMatchPassword(form.password.value, form.rptpassword.value);
    fail += validateIBAN(form.iban.value);
    if (fail == "")
        return true;
    else {
        alert(fail);
        return false
    }
}

function validateName(field) {
    if (field.trim() == "")
        return ("No name was entered.\n");
    else if (!/^[a-zA-Z]+$/.test(field))
        return ("Enter only letters for name.\n");
    else
        return ("");
}

function validateSurname(field) {
    if (field.trim() == "")
        return ("No surname was entered.\n");
    else if (!/^[a-zA-Z]+$/.test(field))
        return ("Enter only letters for surname.\n");
    else
        return ("");
}

function validateCity(field) {
    if (field.trim() == "")
        return ("No city was entered.\n");
    else if (!/^[a-zA-Z]+$/.test(field))
        return ("Enter only letters for city.\n");
    else
        return ("");
}

function validateAddress(field) {
    if (field.trim() == "")
        return ("No address was entered.\n");
    else
        return ("");
}

function getAge(field) {
    var today = new Date();
    var date = field.split("/"); //date is given mm/dd/yyyy, but we want dd/mm/yyyy!
    var month = date[0];
    var day = date[1];
    var year = date[2];
    var birthDate = new Date(day + "/" + month + "/" + year);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    if (age < 18)
        return ("You don't have major age!\n");
    else
        return ("");
}

function validateDate(field) {
    if (field.trim() == "")
        return ("No date was entered.\n");
    else
        return ("");
}

function validateEmail(field) {
    if (field.trim() == "") return "No Email was entered.\n";
    else if (!((field.indexOf(".") > 0) && (field.indexOf("@") > 0)) || /[^a-zA-Z0-9.@_-]/.test(field))
        return "The Email address is invalid.\n";
    return "";
}

function validateUsername(field) {
    if (field.trim() == "")
        return "No Username was entered.\n";
    else if (field.trim().length < 6)
        return "Usernames must be at least 6 characters.\n";
    else if (/[^a-zA-Z0-9_-]/.test(field))
        return "Only a-z, A-Z, 0-9, - and _ allowed in Usernames.\n";
    return ""
}

function validatePassword(field) {
    if (field.trim() == "") return "No Password was entered.\n";
    else if (field.trim().length < 6)
        return "Passwords must be at least 6 characters.\n";
    else if (!/[a-z]/.test(field) || !/[A-Z]/.test(field) || !/[0-9]/.test(field))
        return "Passwords require one each of a-z, A-Z and 0-9.\n";
    return ""
}

function validateMatchPassword(field1, field2) {
    if (field1 === field2)
        return ("");
    return ("Passwords don't match");
}

function validateIBAN(field) {
    if (field.trim() == "")
        return "No IBAN was entered.\n";
    else if (!/[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}/.test(field))
        return "Check right sequence for IBAN.\n";
    return ""
}