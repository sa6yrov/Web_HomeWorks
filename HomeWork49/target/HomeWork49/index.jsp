<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <title>Table</title>
        <meta charset="UTF-8">
    </head>

    <body>
        <table border="2" cellpadding="8" cellspacing="0" align="center">
            <caption>PRIME NUMBERS</caption>
            <%
                boolean b = true;
                ArrayList<Integer> numbers = new ArrayList<>();
                for (int i = 2; i <= 542; i++) {
                    for (int j = 2; j < i; j++) {
                        if (i % j == 0) {
                            b = false;
                            break;
                        }
                    }
                    if (b) numbers.add(i);
                    else b = true;
                }
                String htmlCode = "";
                int k = 0;
                for (int i = 0; i < 10; i++) {
                    htmlCode += "<tr>";
                    for (int j = 0; j < 10; j++) {
                        k++;
                        htmlCode += "<th>" + numbers.get(k);
                        htmlCode += "</th>";
                    }
                    htmlCode += "</tr>";
                }
            %>
            <%= htmlCode %>

        </table>
    </body>
</html>
