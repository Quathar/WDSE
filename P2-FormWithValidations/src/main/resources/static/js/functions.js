
// 'form.html' functions

    window.onload = function () {
        changeColor();
    }

    function changeColor() {
        document.getElementById('styles').href = document.getElementById('color').value;
    }

    function showPasswords(id1, id2) { // Show 'passwd' and 'confirmPasswd' inputs
        Array.of(document.getElementById(id1), document.getElementById(id2)).forEach(element => {
            if (element.type === "password")
                element.type = "text";
            else element.type = "password";
        });
    }

    function checkFirst(name) {
        document.getElementsByName(name)[0].checked = true
    }

    function checkAll(name, mode) { // Check/Uncheck of 'selectedGender' and 'selectedHobbies'
        document.getElementsByName(name).forEach(element => element.checked = mode);
    }

    function selectAll(id, mode) { // Select/Deselect of 'selectedMusic'
        Array.from(document.getElementById(id).options).forEach(option => option.selected = mode);
    }

    function clearAll() { // Clear all fields data
        document.getElementById('name').value = "";
        document.getElementById('passwd').value = "";
        document.getElementById('confirmPasswd').value = "";
        document.getElementById('birthdate').value = "";
        document.getElementById('age').value = "";
        document.getElementById('selectedCountry').selectedIndex = 0;
        document.getElementById('prefix').selectedIndex = 0;
        document.getElementById('mobilePhone').value = "";
        document.getElementById('email').value = "";
        document.getElementById('url').value = "";
        document.getElementById('document').value = "";
        document.getElementById('comments').value = "";

        checkAll('selectedGender', false);
        selectAll('selectedMusic', false);
        checkAll('selectedHobbies', false);
        checkAll('license', false);
    }
