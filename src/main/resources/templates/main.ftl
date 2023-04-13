<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../static/css/style.css">
    <title>Гллавная страница</title>
</head>
<body>
    <form id="newNote">
        <input type="hidden" id="id_input">
        <input type="text" id="header_input" name="header" placeholder="Заголовок записки">
        <textarea rows="4" id="text_area" name="body" placeholder="Содержание записки"></textarea>
        <input type="submit" id="submit_btn" class="btn" value="Создать записку">
    </form>

    <table id="tableOfNotes">
        <tr>
            <th>Заголовок записки</th>
            <th>Содержание записки записки</th>
            <th>Дата</th>
        </tr>
    </table>
<script src="../static/js/main.js"></script>
</body>
</html>