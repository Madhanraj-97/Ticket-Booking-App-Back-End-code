let btn = document.getElementById("reg-btn");
document.writeln(oper)
document.writeln(mail)
document.writeln(pwd)
btn.addEventListener("click", () => {
    let adminObject = {
        operator: document.getElementById("operator").value,
        password: document.getElementById("pass").value,
        email: document.getElementById("email").value
    };
    fetch('http://localhost:8080/admin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(adminObject)
    })
        .then(response => response.json())
        .then(admin => {
            console.log(admin.data)
            localStorage.setItem('userData', JSON.stringify(admin.data));
            window.location.href = 'AdminHome.html';

        });
})