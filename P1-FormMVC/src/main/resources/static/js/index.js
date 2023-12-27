// <<- FUNCTIONS FOR 'index.html' AND 'indexAdvanced.html' ->>

// Show and hide 'passwd' and 'confirmPasswd' info
let showPasswords = (id1, id2) =>
    Array.of(
        document.getElementById(id1),
        document.getElementById(id2)
    ).forEach(element => {
        if (element.type === 'password')
            element.type = 'text';
        else element.type = 'password';
    });

// Check/Uncheck of 'selectedSemaphore' and 'selectedHobbies'
let checkAll = (name, mode) =>
    document.getElementsByName(name)
        .forEach(element => element.checked = mode);

// Select/Deselect of 'selectedMusic'
let selectAll = (id, mode) =>
    Array.from(document.getElementById(id).options)
        .forEach(option => option.selected = mode);

// Clear all field data
let clear = (id) => document.getElementById(id).value = "";

function clearAll() {
    clear('name');
    clear('passwd');
    clear('confirmPasswd');
    clear('document');
    clear('comments');

    document.getElementById('selectedCountry').selectedIndex = 0;
    document.getElementById('license').checked = false;

    checkAll('selectedSemaphore', false);
    checkAll('selectedHobbies', false);
    selectAll('selectedMusic', false);
}
