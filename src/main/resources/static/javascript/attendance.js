window.onload = function () {

    loadSubjects();

    setTodayDate();
};

function setTodayDate() {

    document.getElementById("attDate").value =
        new Date().toISOString().split("T")[0];
}

function loadSubjects() {

    fetch("/api/subjects")
        .then(res => res.json())
        .then(data => {

            let select =
                document.getElementById("qrSubject");

            select.innerHTML = "";

            data.forEach(s => {

                select.innerHTML += `
                    <option value="${s.id}">
                        ${s.name}
                    </option>
                `;
            });

            onSubjectChange();
        });
}

function onSubjectChange() {

    loadUsersBySubject();

    loadAttendance();
}

function loadUsersBySubject() {

    let subjectId =
        document.getElementById("qrSubject").value;

    fetch(`/api/group/subject/${subjectId}`)
        .then(res => res.json())
        .then(data => {

            let select =
                document.getElementById("userSubjectSelect");

            select.innerHTML = "";

            data.forEach(u => {

                select.innerHTML += `
                    <option value="${u.id}">
                        ${u.userDto.manualId}
                    </option>
                `;
            });
        });
}

function saveAttendance() {

    let dto = {

        userSubjectMapDto: {
            id: document.getElementById("userSubjectSelect").value
        },

        date: document.getElementById("attDate").value,

        isPresent: true
    };

    fetch("/api/attendance", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dto)
    })
        .then(() => loadAttendance());
}

function formatDate(dateString) {

    let date = new Date(dateString);

    let day = String(date.getDate()).padStart(2, '0');

    let month = date.toLocaleString('default', {
        month: 'short'
    });

    let year = date.getFullYear();

    return `${day} ${month} ${year}`;
}

function loadAttendance() {

    let subjectId =
        document.getElementById("qrSubject").value;

    let date =
        document.getElementById("attDate").value;

    if (!subjectId || !date) return;

    fetch(`/api/attendance/filter?subjectId=${subjectId}&date=${date}`)
        .then(res => res.json())
        .then(data => {

            let table =
                document.getElementById("attendanceTable");

            table.innerHTML = "";

            data.forEach((a, index) => {

                table.innerHTML += `
                    <tr>
                        <td>${index + 1}</td>
                        <td>${a.userSubjectMapDto.subjectDto.name}</td>
                        <td>${a.userSubjectMapDto.userDto.manualId}</td>
                        <td>${formatDate(a.date)}</td>
                    </tr>
                `;
            });
        });
}