/**
 * Created by andreacifola on 22/12/16.
 */

function validateManag(form) {
    fail = validateDescription(form.description.value);
    fail += validateRooms(form.rooms.value);
    fail += validateGuests(form.guests.value);
    fail += validateBeds(form.guests.value);
    fail += validateBaths(form.baths.value);
    fail += validatePrice(form.price.value);
    if (fail == "")
        return true;
    else {
        alert(fail);
        return false;
    }
}

function validateDescription(field) {
    if (field.trim() == "")
        return ("No name was entered.\n");
    else
        return "";
}

function validateRooms(field) {
    if (field.trim() == "")
        return ("Enter number for rooms, not characters.\n");
    else if (!/^[0-9]+$/.test(field))
        return ("Enter only numbers for rooms.\n");
    else
        return "";
}

function validateGuests(field) {
    if (field.trim() == "")
        return ("Enter number for guests, not characters.\n");
    else if (!/^[0-9]+$/.test(field))
        return ("Enter only numbers for guests.\n");
    else
        return "";
}

function validateBeds(field) {
    if (field.trim() == "")
        return ("Enter number for beds, not characters.\n");
    else if (!/^[0-9]+$/.test(field))
        return ("Enter only numbers for beds.\n");
    else
        return "";
}

function validateBaths(field) {
    if (field.trim() == "")
        return ("Enter number for baths, not characters.\n");
    else if (!/^[0-9]+$/.test(field))
        return ("Enter only numbers for baths.\n");
    else
        return "";
}

function validatePrice(field) {
    if (field.trim() == "")
        return ("Enter number for price, not characters.\n");
    else if (!/^[0-9]+$/.test(field))
        return ("Enter only numbers for price.\n");
    else
        return "";
}