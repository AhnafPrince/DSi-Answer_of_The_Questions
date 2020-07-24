<%-- 
    Document   : Register
    Created on : Jul 22, 2020, 11:36:38 PM
    Author     : ahnaf
--%>

<%@page import="Servlets.Register"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
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

        <%-- Checking email avaiabilty --%>
        <script src="jquery.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".email").change(function () {
                    var email = $(this).val();

                    $(".estatus").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
                    $.ajax({
                        type: "POST",
                        url: "CheckEmail",
                        data: "email=" + email,
                        success: function (msg) {

                            $(".estatus").ajaxComplete(function (event, request, settings) {

                                $(".estatus").html(msg);

                            });
                        }
                    });
                });
            });

        </script>

    </head>
    <br>

    <center><h1><strong>Registration Panel</strong></h1></center>

    <br>

    <%-- if Registration failed showing the reason of failure --%>
    <%String s1 = (String) request.getAttribute("failedRegister");
        if (s1 != null) {%>

    <center><td> <font color=red><%=s1%></td> </center> 

    <%}%> 
    <br>
        <% String s2 = (String) request.getAttribute("wrongPassword");
            if (s2 != null) {%> 

        <center><td> <font color=red><%=s2%></td> </center> 

    <%}%>

    <br>

    <center>
        <form name="form" action="Register" method="POST">
            <div>
                <table>
                    <tr>

                        <td><b><pre><br>  Email</pre></b></td>
                        <td>

                            <%--
                            <input type="text" id="emailInput" class="form-control" name="email">
                            --%>
                            <input type="text" class="email" class="form-control" name="email"/> <span class="estatus"></span>

                        </td>

                    </tr>

                    <tr>

                        <td><b><pre><br>New Password </pre></b></td>
                        <td><input type="password" class="newPassword" class="form-control" name="newPassword"> <span class="pstatus"></span> </td> 

                    </tr>

                    <tr>

                        <td><b><pre><br>Confirm Password </pre></b></td>
                        <td><input type="password" class="confirmPassword" class="form-control" name="confirmPassword"> <span class="p2status"></span> </td> 

                    </tr>

                    <tr>
                        <td colspan="2" style="text-align: center"> <br> <input class="btn btn-success" type="submit" value="Register"></td>
                        <td colspan="2" style="text-align: justify"> <br> <input class="btn btn-success" type="reset" value="Clear"></td>
                    </tr>
                    <br>

                </table>
            </div>
        </form>
    </center>



</html>