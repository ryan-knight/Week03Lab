<%-- 
    Document   : viewnote.jsp
    Created on : 20-Sep-2018, 12:46:17 PM
    Author     : 763198
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week 3 Lab Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <div><b>Title: </b>${note.title}</div>
        <div><b>Content:<br></b>${note.content}</div>
        <a href="note?edit">Edit</a>
    </body>
</html>
