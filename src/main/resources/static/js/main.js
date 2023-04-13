const btn = document.getElementById("submit_btn");
btn.addEventListener("click", async e => {
    e.preventDefault();
    const submitBtn = document.getElementById("submit_btn");
    const id = document.getElementById("id_input").value;
    const header = document.getElementById("header_input").value;
    const body = document.getElementById("text_area").value;

    if(header){
        const res = await fetch("/addnote", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            //навания переменных в фигурных скобках должны соответствовать
            //названию полей в сущности
            body: JSON.stringify({id, header, body})
        });

        const note = await res.json();
        console.log(note.id);
        console.log(id);
        console.log(note.id === +id);
        if(note.id === +id) {
            getAllNotes();
        } else {
            noteToHTML(note);
        }

        //делаем пустыми значения формы
        if(submitBtn.value === "Редактировать"){

        }
        document.getElementById("id_input").value = 0;
        document.getElementById("header_input").value = "";
        document.getElementById("text_area").value = "";
    }
});


//асинхронная функция получающая данные о всех записках
async function getAllNotes(){
    const res = await fetch("/getnotes");
    const notes = await res.json();

    notes.forEach(note => noteToHTML(note));
}

//функция, вызываемая при полной загрузке страницы
window.addEventListener("DOMContentLoaded", getAllNotes);

//функция, добавляющая HTML разметку вместе с полученными данными в нужное место
function noteToHTML(note){
    const noteList = document.getElementById("tableOfNotes");

    noteList.insertAdjacentHTML('beforeend', `
        <tr id="note${note.id}">
            <td>${note.header}</td>
            <td>${note.body}</td>
            <td>${note.dateTime}</td>
            <td><button onclick="updateNoteById(${note.id})" type="button" class="btn">Изменить</button></td>
            <td><button onclick="deleteNoteById(${note.id})" type="button" class="btn">Удалить</button></td>
        </tr>`)
}

async function deleteNoteById(id){
    const res = await fetch(`/deletenote/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })

    if(res.status === 200){
        document.getElementById(`note${id}`).remove();
    }
}

async function updateNoteById(id){
    const res = await fetch(`/updatenote/${id}`);
    const note = await res.json();

    document.getElementById("id_input").value = note.id;
    document.getElementById("header_input").value = note.header;
    document.getElementById("text_area").value = note.body;
    document.getElementById("submit_btn").value = "Редактировать";
}