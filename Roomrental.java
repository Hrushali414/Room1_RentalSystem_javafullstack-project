package com.rental;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RoomServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String tenant = request.getParameter("tenant");
        String room = request.getParameter("room");
        String contact = request.getParameter("contact");
        String rent = request.getParameter("rent");

        out.println("<html><body style='font-family:Arial; background-color:#affec2;'>");
        out.println("<center>");
        out.println("<h2 style='color:purple;'>Room Rental Details Submitted Successfully!</h2>");
        out.println("<table border='1' cellpadding='10' style='background-color:white; border-radius:10px;'>");
        out.println("<tr><td><b>Tenant Name:</b></td><td>" + tenant + "</td></tr>");
        out.println("<tr><td><b>Room Number:</b></td><td>" + room + "</td></tr>");
        out.println("<tr><td><b>Contact Number:</b></td><td>" + contact + "</td></tr>");
        out.println("<tr><td><b>Rent Amount:</b></td><td>" + rent + "</td></tr>");
        out.println("</table>");
        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</center>");
        out.println("</body></html>");
    }
}