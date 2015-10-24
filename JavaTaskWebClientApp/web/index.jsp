<%@page import="ru.t_task.java_web_client.ItemWord"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тестовое задание</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>


</head>
<body>
    <!--  <h1>
    <% out.println("");%></h1>

<form method="POST" action="StringAnalysisServlet">
    <span>Текст1 :</span>
    &nbsp;
    <input type="text" name="text1" />
    <br>
    <br>
    <input type="submit" value="Поиск пересечений" />
    <br>
    <br></form>

<p>
    <%= request.getAttribute("message") %></p>
-->
<div id="block-content">
    <div class="row">
            <form id="form_submit" method="POST" action="StringAnalysisServlet">
        <div class="col-sm-8 col-sm-offset-3">
            <ul id="info-form">
                <li>
                    <label for="info_text1">Текст 1</label>
                    <textarea id="info_text1" class="input-msg" name="info_text1"></textarea>
                </li>
                <!--  -->
                <li>
                    <label for="info_text2">Текст 2</label>
                    <textarea id="info_text2" class="input-msg" name="info_text2"></textarea>
                </li>
                <!--  -->
                <li>
                    <label for="info_text3">Текст 3</label>
                    <textarea id="info_text3" class="input-msg" name="info_text3"></textarea>
                </li>
                <!--  -->
                <li>
                    <label for="info_text4">Текст 4</label>
                    <textarea id="info_text4" class="input-msg" name="info_text4"></textarea>
                </li>
                <!--  -->
                <li>
                    <label for="info_text5">Текст 5</label>
                    <textarea id="info_text5" class="input-msg" name="info_text5"></textarea>
                </li>
                <!--  -->

            </ul>

            <input type="submit" class="btn-primary" name="submit" id="start-search" value="Поиск пересечений" />

        </div>
                </form>
    </div>
    

     <% request.setAttribute("message1", null); %>
     <p id="message-error" style="color: white;">
        <%= request.getAttribute("message1")  %></p>

    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <div id="resuls-data">

                <table class="table table-bordered table-striped" id="table-result">
                    <thead>
                        <tr>
                                                    <th style="width:330px;">Слово</th>
                            <th>Количество текстов</th>
                            <th>Номера текстов</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                                            List<ItemWord> list = (List<ItemWord>) request.getAttribute("message");
                                            if ( list != null )
                                            {
                                            for ( ItemWord item : list )
                                            { %>
                                                <tr>
                            <td><%= item.getWord() %></td>
                            <td><%= item.getTextBlockCount() %></td>
                            <td><%= item.getTextBlockNumb() %></td>
                        </tr>   
                                            <% } 
                                            }%>                 
                    </tbody>
                </table>

            </div>
        </div>
    </div>

</div>

</body>
</html>