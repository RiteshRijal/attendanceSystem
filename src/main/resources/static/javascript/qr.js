window.onload=function () {
    loadSubjects();
}

function generateQR() {

    let subjectId = document.getElementById("qrSubject").value;
    let date = document.getElementById("qrDate").value;

    fetch(`/api/session/create?subjectId=${subjectId}&date=${date}`, {
        method: "POST"
    })
        .then(res => res.json())
        .then(session => {

            let qrUrl =
                `http://192.168.0.103:8080/mark.html?token=${session.token}`;

            document.getElementById("qrImage").src =
                `/api/qr?text=${encodeURIComponent(qrUrl)}`;
        });
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