
function showPassword(id) {
    let element = document.getElementById(id);
    if (element.type === "password")
         element.type = "text";
    else element.type = "password";
}

function recoverPassword() {
    alert(`The password is going to be consulted`);
    let username = document.querySelector('#user').value
    // Async request
    fetch(`/auth/recover?username=${username}`, { method: 'GET' })
        .then(rawResponse => rawResponse.text())
        .then(response => alert(`Your password is '${response}'`))
        .catch(error => console.log(error))
}
