/**
 * Created by andreacifola on 20/12/16.
 */

function validate(form) {
    fail = validateName(form.forename.value);
    fail += validateSurname(form.surname.value);
    fail += validateEmail(form.email.value);
    fail += validateUsername(form.username.value);
    fail += validatePassword(form.password.value);
    fail += validateMatchPassword(form.password.value, form.rptpassword.value);
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