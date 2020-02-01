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
                String htmlCode = "";
                for (int i = 2; i <= 100; i++) {
                    for (int j = 2; j < i; j++) {
                        htmlCode += "<tr>";
                        if (i % j == 0) {
                            b = false;
                            break;
                        }
                    }
                    htmlCode += "</tr>";
                    if (b){
                            for (int l = 0; l < 5; l++) {
                                htmlCode += "<td>" + i + "</td>";
                            }
                    }
                    else b = true;
                }
            %>
            <%= htmlCode %>

        </table>
    </body>
</html>
