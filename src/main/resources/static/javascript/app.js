// ----------------------
// PAGE SWITCHING
// ----------------------
function showPage(pageId) {
    document.querySelectorAll('.page').forEach(p => {
        p.classList.remove('active');
    });
    document.getElementById(pageId).classList.add('active');
}

// ----------------------
// SUBJECTS
// ----------------------
function addSubject() {
    let name = document.getElementById("subjectName").value;

    fetch("/api/subjects", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({name: name})
    }).then(loadSubjects);
}

function loadSubjects() {
    fetch("/api/subjects")
        .then(res => res.json())
        .then(data => {

            let list = document.getElementById("subjectList");
            let select = document.getElementById("subjectSelect");

            list.innerHTML = "";
            select.innerHTML = "";

            data.forEach(s => {
                list.innerHTML += `<li>${s.name}</li>`;
                select.innerHTML += `<option value="${s.id}">${s.name}</option>`;
            });
        });
}

// ----------------------
// USERS
// ----------------------
function addUser() {
    let manualId = document.getElementById("manualId").value;
    let email = document.getElementById("email").value;

    fetch("/api/users", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({manualId, email})
    }).then(loadUsers);
}

function loadUsers() {
    fetch("/api/users")
        .then(res => res.json())
        .then(data => {

            let list = document.getElementById("userList");
            let select = document.getElementById("userSelect");

            list.innerHTML = "";
            select.innerHTML = "";

            data.forEach(u => {
                list.innerHTML += `<li>${u.manualId} | ${u.email}</li>`;
                select.innerHTML += `<option value="${u.id}">${u.manualId}</option>`;
            });
        });
}

// ----------------------
// ATTENDANCE
// ----------------------
function saveAttendance() {

    let dto = {
        userDto: {
            id: document.getElementById("userSelect").value
        },
        subjectDto: {
            id: document.getElementById("subjectSelect").value
        },
        date: document.getElementById("attDate").value,
        isPresent: document.getElementById("isPresent").checked
    };

    fetch("/api/attendance", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(dto)
    }).then(loadAttendance);
}

function loadAttendance() {
    fetch("/api/attendance")
        .then(res => res.json())
        .then(data => {

            let table = document.getElementById("attendanceTable");
            table.innerHTML = "";

            data.forEach(a => {

                table.innerHTML += `
                    <tr>
                        <td>${a.subjectDto?.name || a.subjectDto?.id}</td>
                        <td>${a.userDto?.manualId || a.userDto?.id}</td>
                        <td>${a.date}</td>
                        <td>${a.isPresent ? "Present" : "Absent"}</td>
                    </tr>
                `;
            });
        });
}

// ----------------------
// INIT
// ----------------------
loadSubjects();
loadUsers();
loadAttendance();

showPage("subjectPage");