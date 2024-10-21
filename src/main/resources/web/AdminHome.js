const adminData = localStorage.getItem('userData');
if (adminData) {
    const admin = JSON.parse(adminData);
    console.log(admin)

    // Display the data on the page
    document.getElementById('operator').textContent = admin.operator;  // Adjust based on your JSON structure
    document.getElementById('email').textContent = 'You are logged in as: ' + admin.email;
    let table = document.getElementById("buslist")
    let tbody = document.createElement('tbody');
    let i = 1;
    if (admin["bus"] > 0) {
        document.getElementById("buslist").style.display = "inline-block"
        admin["bus"].forEach(bus => {
            let row = document.createElement('tr');
            let td = document.createElement("td");
            td.textContent = i++
            row.appendChild(td);
            let td1 = document.createElement("td");
            td1.textContent = bus.busno
            row.appendChild(td1);
            let td2 = document.createElement("td");
            td2.textContent = bus.seatcapacity
            row.appendChild(td2);
            let td3 = document.createElement("td");
            td3.textContent = bus.ac
            row.appendChild(td3);
            tdfetch("td", row).textContent = bus.schedule == null ? "not schedule" : bus.schedule.sourcecity;
            tdfetch("td", row).textContent = bus.schedule == null ? "not schedule" : bus.schedule.destinationcity;
            tdfetch("td", row).textContent = bus.schedule == null ? "not schedule" : bus.schedule.distance;
            tdfetch("td", row).textContent = bus.schedule == null ? "not schedule" : bus.schedule.estimatedtime;
            tbody.appendChild(row);
        });
        table.appendChild(tbody);
    }
} else {
    // Handle the case where there is no user data (e.g., user navigated directly to home page without logging in)
    alert('No user data found. Please log in.');
    window.location.href = 'index.html';  // Redirect to login page
}
function tdfetch(a, b) {
    td = document.createElement(a)
    b.appendChild(td)
    return td;
}
let addbus = document.getElementById("add-bus");
addbus.addEventListener("click", () => {
    window.location.href = 'addBus.html';


})



// document.addEventListener('DOMContentLoaded', () => {
//     // Retrieve the data from localStorage
//     const adminData = localStorage.getItem('userData');
//     if (adminData) {
//         const admin = JSON.parse(adminData);
//         console.log(admin)

//         // Display the data on the page
//         document.getElementById('operator').textContent = admin.operator;  // Adjust based on your JSON structure
//         document.getElementById('email').textContent = 'You are logged in as: ' + admin.email;
//         let table = document.getElementById("buslist")
//         const tbody = document.createElement('tbody');
//         admin["bus"].forEach(bus => {
//             const row = document.createElement('tr');
//             Object.values(bus).forEach(text => {
//                 const td = document.createElement('td');
//                 td.textContent = text;
//                 row.appendChild(td);
//             });
//             tbody.appendChild(row);
//         });
//         table.appendChild(tbody);

//         // Append the table to the tableContainer div
//         // document.getElementById('tableContainer').appendChild(table);
//     } else {
//         // Handle the case where there is no user data (e.g., user navigated directly to home page without logging in)
//         alert('No user data found. Please log in.');
//         window.location.href = 'index.html';  // Redirect to login page
//     }
// });