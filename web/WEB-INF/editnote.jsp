<%-- 
    Document   : editnote.jsp
    Created on : 20-Sep-2018, 12:46:33 PM
    Author     : 763198
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <form method="post" name="editnote">
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <div><b>Title: </b><input type="text" name="title" value="${note.title}"></div>
        <!--<div><b>Content:<br></b><input type="text" name="content" value=""></div>-->
        <div><textarea cols="50" rows="5" name="content">${note.content}</textarea></div>
        <input type="submit" value="save">
        </form>
    </body>
</html>
