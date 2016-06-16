<%-- 
    Document   : user_reports
    Created on : May 14, 2016, 4:55:13 PM
    Author     : Scorpius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>user_reports</title>

        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/style.css">
        <link rel="stylesheet" href="bootstrap/css/normalize.css">
        <link rel="stylesheet" href="bootstrap/css/style2.css">
        <link rel="stylesheet" href="bootstrap/css/mystyles.css">

        <!--        jquery Ui-->

        <link rel="stylesheet" href="bootstrap/jquery_ui/jquery-ui.min.css">
        <script src="bootstrap/jquery_ui/jquery.js"></script>
        <script src="bootstrap/jquery_ui/jquery-ui.min.js"></script>

    </head>
    <body class="bodyimage">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Healthy Wealthy</a>
            </div>

            <ul class="nav navbar-nav">
                <li><a href="user_home.jsp">Home</a></li>
                <li class="active"><a href="#">Reports</a></li>
                <li><a href="user_treatments.jsp">Treatments</a></li>
                <li><a href="#">Daily Details</a></li>
                <li><a href="user_profile_viewers.jsp">Profile Viewers</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Account Settings</a></li>


                <li id="logOut"><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>  
            <!--                <form action="logout_s" mehtod="post"> 
                           <button type="submit" class="btn btn-default">logout</button> 
                           </form>-->

        </nav>
        <script>

            $("#logOut").click(function () {
                $.post("logout_s", function (responseJson) {
                    window.location.href = "index.jsp";

                });

            });

        </script>

<div class="middle-box2">
            <div class="middle-box-head">
                <h1 class="headding-colour">Add your report here !</h1>
            </div>
     <form action="upload_report_S" method="post" enctype="multipart/form-data">
         <input name="image" type="file" accept="image/*" /> 
         <input class="button_123" type="submit" value="upload" />
            </form>   
        

</div>      
        
       
      





    </body>
</html>
