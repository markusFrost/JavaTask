<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% out.println("");%></h1>
        
        <form method="POST" action="StringAnalysisServlet">
            <span>Текст1 :</span> &nbsp;<input type="text" name="text1" /> <br><br>
             <input type="submit" value="Поиск пересечений" /> <br><br>
        </form>
        
        <p>
            <%= request.getAttribute("message") %>
        </p>
    </body>
</html>