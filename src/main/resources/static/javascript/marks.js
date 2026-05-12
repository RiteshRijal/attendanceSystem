window.onload = function () {

    const params = new URLSearchParams(window.location.search);
    const token = params.get("token");

    if (!token) {
        alert("Invalid QR token");
        return;
    }

    loadUsers(token);
};



function loadUsers(token) {

    fetch(`/api/session/token?token=${token}`, {
        method: "GET"
    })
        .then(res => res.json())
        .then(data => {

            let select = document.getElementById("userSelect");
            select.innerHTML = "";

            if (!data || data.length === 0) {
                select.innerHTML = `<option>No users found</option>`;
                return;
            }

            data.forEach(u => {
                select.innerHTML += `
                    <option value="${u.id}">
                        ${u.userDto?.manualId ?? 'Unknown'}
                    </option>
                `;
            });
        })
        .catch(err => {
            console.error("Error loading users:", err);
        });
}

function submitAttendance() {

    const token = new URLSearchParams(window.location.search).get("token");

    const userSubjectMapId = document.getElementById("userSelect").value;

    fetch("/api/attendance/mark", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            token,
            userSubjectMapDto: { id: userSubjectMapId }
        })
    })
        .then(async res => {

            if (res.ok) {
                alert("Attendance marked");

                document.querySelector("button").disabled = true;
                document.querySelector("button").innerText = "Already Marked";
            } else {
                const msg = await res.text();
                alert(msg);
                alert("already markerd")
            }
        });
}