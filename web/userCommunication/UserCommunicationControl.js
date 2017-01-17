/**
 * Created by andreacifola on 22/12/16.
 */

function validateCommunication(form) {
    fail = validateObject(form.object.value);
    fail += validateText(form.texts.value);
    if (fail == "")
        return true;
    else {
        alert(fail);
        return false;
    }
}

function validateObject(field) {
    if (field.trim() == "")
        return ("L'oggetto della email è vuoto.\n");
    else
        return "";
}

function validateText(field) {
    if (field.trim() == "")
        return ("Non hai inserito alcun testo nella email.\n");
    else
        return "";
}