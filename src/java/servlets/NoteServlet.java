/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 763198
 */
public class NoteServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader;
        reader = new BufferedReader(fileReader);

        Note note = new Note();

//        String test = reader.readLine();
        String title = reader.readLine();
        
        //splits note into an array of read lines broken up by html linebreak
        String[] contentRead = reader.readLine().split("<br>");

        
        String content = "";
        //if on the view page, does linebreaks via html tags
        if (request.getParameter("edit") == null)
        {
            for(String i:contentRead)
            {
                content += i;
                content += "<br>";
            }
        }
        //if on the edit page, does \n escaped linebreaks
        else
        {
            for(int i = 0;i < contentRead.length;i++)
            {
                content += contentRead[i];
                if(i != contentRead.length)
                    content += "\n";
            }
        }
        
        //sets title and content of note to javabean
        note.setTitle(title);
        note.setContent(content);

        request.setAttribute("note", note);
        reader.close();
        
        //checks if get request is for view or edit page before loading a page
        if (request.getParameter("edit") == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        PrintWriter writer;
        writer = new PrintWriter(new FileWriter(path, false));
        
        //splits the text box into an array of lines
        String title = request.getParameter("title");
        String[] content = request.getParameter("content").split("\n");
        
        writer.println(title);
        
        //splits lines into HTML linebreak delimited single string before writing to file
        String contentWrite = "";
        for(String i:content)
        {
            contentWrite += i.trim();
            contentWrite += "<br>";
        }
        writer.println(contentWrite);
        writer.close();
        
        //writes these to bean
        Note note = new Note();
        note.setTitle(title);
        note.setContent(contentWrite);
        
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
