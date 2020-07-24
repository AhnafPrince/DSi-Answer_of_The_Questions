<%-- 
    Document   : UserProfile
    Created on : Jul 23, 2020, 6:28:24 PM
    Author     : ahnaf
--%>
<%@page import="java.lang.String"%>
 
<%@page import="Servlets.Register"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"> 
        <style>
            to{
                padding: 10px;
            }

            div{
                width: 60%;
                border: 2px solid black;
                border-radius: 5px;
                background-color: grey;
            }
        </style>

    </head>
    <body>

        <br><br>



    <center><h1><strong>User Profile</strong></h1></center> 
    <br>

    <%-- if login failed showing the reason of failure --%>
    <% String s = (String) request.getAttribute("LoginSuccess");%>


    <br><br><br>

    <center>
        <div>
            <table>
                <tr>
                <br>
                <td><b><pre><br>Email Address  </pre></b></td>
                <td><%= s%></td>

                </tr>
            </table>
        </div>

    </center>



</body>
</html>
