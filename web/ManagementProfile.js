function validate(form) {
   if(!validateName(form.names.value) || !validateName(form.surname.value) || !validateUsername(form.username.value)
       || !validatePassword(form.password.value) || !validateMatchPassword(form.password.value, form.rptpassword.value))
        return false;
    else {
        return true;
    }
}

/* Valid for name and surname */
function validateName(field) {
    if (field.trim() == ""){
        alert("Inserisci nome");
        return false;
    }
    else if (!/^[a-zA-Z]+$/.test(field)) {
        alert("Inserisci un nome valido");
        return false;
    }
        return true;
}

function validateUsername(field) {
    if (field.trim() == ""){
        alert("Inserisci username");
        return false;
    }
    else if (field.trim().length < 6){
        alert("Username deve avere almeno 6 caratteri");
        return false;
    }
    else if (/[^a-zA-Z0-9_-]/.test(field)){
        alert("Sono ammessi in username solo i seguenti caratteri: a-z, A-Z, 0-9, -,  _");
        return false;
    }
    return true;
}

function validatePassword(field) {
    if (field.trim() == ""){
        alert("Inserisci password");
        return false;
    }
    else if (field.trim().length < 6){
        alert("La password deve avere almeno 6 caratteri");
        return false;
    }
    else if (!/[a-z]/.test(field) || !/[A-Z]/.test(field) || !/[0-9]/.test(field)){
        alert("La password deve contenere almeno uno dei seguenti caratteri: a-z, A-Z, 0-9");
        return false;
    }
    return true;
}

function validateMatchPassword(field1, field2) {
    if (field1 === field2)
        return true;
    alert("Passwords don't match");
    return false;
}
