function addSubject() {

    let name = document.getElementById("subjectName").value;

    fetch("/api/subjects", {
        method: "POST", headers: {
            "Content-Type": "application/json"
        }, body: JSON.stringify({
            name: name
        })
    })
        .then(() => {

            document.getElementById("subjectName").value = "";

            loadSubjects();
        });
}

function loadSubjects() {

    fetch("/api/subjects")
        .then(res => res.json())
        .then(data => {

            let list =
                document.getElementById("subjectList");

            list.innerHTML = "";

            data.forEach(s => {

                list.innerHTML += `
                    <tr>

                        <td>${s.id}</td>

                        <td>${s.name}</td>

                        <td>

                            <button
                                class="edit-btn"
                                onclick="editSubject(${s.id}, '${s.name}')">
                                Edit
                            </button>

                            <button
                                class="delete-btn"
                                onclick="deleteSubject(${s.id})">
                                Delete
                            </button>

                        </td>

                    </tr>
                `;
            });
        });
}

function deleteSubject(id) {

    fetch(`/api/subjects/${id}`, {
        method: "DELETE"
    })
        .then(() => loadSubjects());
}

function editSubject(id, name) {

    let newName = prompt("Enter new subject name", name);

    if (!newName) {
        return;
    }

    fetch("/api/subjects", {
        method: "PUT", headers: {
            "Content-Type": "application/json"
        }, body: JSON.stringify({
            id: id, name: newName
        })
    })
        .then(() => loadSubjects());
}

loadSubjects();