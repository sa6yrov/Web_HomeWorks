package com;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
            printWriter.print("<html> <body> <table border=\"2\" cellpadding=\"8\" cellspacing=\"0\" align=\"center\">\n" +
                    "<caption>PRIME NUMBERS</caption>");
        boolean b = true;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 542; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) numbers.add(i);
            else b = true;
        }
        int k = 0;
        for (int i = 0; i < 10; i++) {
            printWriter.print("<tr>");
            for (int j = 0; j < 10; j++) {
                k++;
                printWriter.print("<th>" + numbers.get(k) + "</th>");
            }
            printWriter.print("</tr>");
        }
        printWriter.print("</table></body></html>");
    }
}
