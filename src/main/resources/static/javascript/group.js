function loadSubjects() {

    fetch("/api/subjects")
        .then(res => res.json())
        .then(data => {

            let select =
                document.getElementById("subjectSelect");

            select.innerHTML = "";

            data.forEach(s => {

                select.innerHTML += `
                    <option value="${s.id}">
                        ${s.name}
                    </option>
                `;
            });

            loadGroupUsers();
        });
}

function loadUsers() {

    fetch("/api/user")
        .then(res => res.json())
        .then(data => {

            let select =
                document.getElementById("userSelect");

            select.innerHTML = "";

            data.forEach(u => {

                select.innerHTML += `
                    <option value="${u.id}">
                        ${u.manualId}
                    </option>
                `;
            });
        });
}

function loadGroupUsers() {

    let subjectId =
        document.getElementById("subjectSelect").value;

    fetch(`/api/group/subject/${subjectId}`)
        .then(res => res.json())
        .then(data => {

            let list =
                document.getElementById("groupList");

            list.innerHTML = "";

            data.forEach((g,index )=> {

                list.innerHTML += `
                    <tr>

                        <td>${index + 1}</td>

                        <td>
                            ${g.userDto.manualId}
                        </td>

                        <td>
                            ${g.userDto.email}
                        </td>

                        <td>

                            <button
                                class="delete-btn"
                                onclick="deleteGroup(${g.id})">
                                Remove
                            </button>

                        </td>

                    </tr>
                `;
            });
        });
}

function addGroupUser() {

    let subjectId =
        document.getElementById("subjectSelect").value;

    let userId =
        document.getElementById("userSelect").value;

    fetch("/api/group", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({

            subjectDto: {
                id: subjectId
            },

            userDto: {
                id: userId
            }
        })
    })
        .then(() => loadGroupUsers());
}

function deleteGroup(id) {

    fetch(`/api/group/${id}`, {
        method: "DELETE"
    })
        .then(() => loadGroupUsers());
}

window.onload = function () {

    loadSubjects();

    loadUsers();
};