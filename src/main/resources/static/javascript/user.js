function addUser() {

    let manualId =
        document.getElementById("manualId").value;

    let email =
        document.getElementById("email").value;

    fetch("/api/user", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            manualId,
            email
        })
    })
        .then(() => {

            document.getElementById("manualId").value = "";
            document.getElementById("email").value = "";

            loadUsers();
        });
}

function loadUsers() {

    fetch("/api/user")
        .then(res => res.json())
        .then(data => {

            let list =
                document.getElementById("userList");

            list.innerHTML = "";

            data.forEach(u => {

                list.innerHTML += `
                    <tr>

                        <td>${u.id}</td>

                        <td>${u.manualId}</td>

                        <td>${u.email}</td>

                        <td>

                            <button
                                class="edit-btn"
                                onclick="editUser(${u.id}, '${u.manualId}', '${u.email}')">
                                Edit
                            </button>

                            <button
                                class="delete-btn"
                                onclick="deleteUser(${u.id})">
                                Delete
                            </button>

                        </td>

                    </tr>
                `;
            });
        });
}

function deleteUser(id) {

    fetch(`/api/user/${id}`, {
        method: "DELETE"
    })
        .then(() => loadUsers());
}

function editUser(id, manualId, email) {

    let newManualId =
        prompt("Enter Manual ID", manualId);

    let newEmail =
        prompt("Enter Email", email);

    if (!newManualId || !newEmail) {
        return;
    }

    fetch("/api/user", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: id,
            manualId: newManualId,
            email: newEmail
        })
    })
        .then(() => loadUsers());
}

window.onload = function () {
    loadUsers();
};