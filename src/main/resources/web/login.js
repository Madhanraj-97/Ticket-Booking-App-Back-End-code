let log = document.getElementById("login").onclick = function () {

        let email = document.getElementById("email").value;
        let pwd = document.getElementById("password").value;
        console.log(email);
        console.log(pwd);
        
        fetch('http://localhost:8080/admin/login?email=nationaltravels@gmail&password=National@123')
                .then((res) => res.json())
                .then((admin) =>{
                        console.log(admin.data);
                        localStorage.setItem('userData', JSON.stringify(admin.data));
                        window.location.href = 'AdminHome.html';
                })

};

// let email=document.getElementById("email");
// let pwd=document.getElementById("password");
// console.log(email);
// console.log(pwd);
// log.addEventListener("click", fetch('http://localhost:8080/admin/login?email=${email}&password=${pwd}')
//     .then((res) => {console.log(res);
//     }).catch((error)=>{
//         console.log(error);
//     }));
//         fetch('http://localhost:8080/admin/login?email='+email+'&password=' + pwd)
        //                 .then((res) => {
        //                         if (res.success) {  // the server response contains a success field
        //                                 console.log(res.data.operator);
        //                                 // Store the data in localStorage
        //                                 localStorage.setItem('userData', JSON.stringify(res.json().data));
        //                                 // Redirect to the next page
        //                                 window.location.href = 'AdminHome.html';  // Change 'home.html' to the desired page URL
        //                         } else {
        //                                 // Handle login failure (e.g., show an error message to the user)
        //                                 alert('Login failed invalid email or password ');  // the server response contains a message field
        //                         }
        //                 })
        //                 .catch((error) => {
        //                         console.error('There has been a problem with your fetch operation:', error);
        //                         // Optionally, show a user-friendly error message
        //                         alert('An error occurred while logging in. Please try again later.');
        //                 });
        // };

