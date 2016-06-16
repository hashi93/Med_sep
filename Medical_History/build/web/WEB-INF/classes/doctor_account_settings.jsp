<%-- 
    Document   : doctor_account_settings
    Created on : May 14, 2016, 4:57:26 PM
    Author     : Scorpius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/style.css">
        <link rel="stylesheet" href="bootstrap/css/normalize.css">
        <link rel="stylesheet" href="bootstrap/css/style2.css">
        <link rel="stylesheet" href="bootstrap/css/mystyles.css">
        
        <title>Doctor_Account_settings</title>
    </head>
    <body class="bodyimage">
        
         <!--        navbar implementation-->
        <div>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Healthy Wealthy</a>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">Reports</a></li>
                    <li><a href="#">Treatments</a></li>
                    <li><a href="#">Daily Details</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="user_account_settings.jsp"><span class="glyphicon glyphicon-user"></span> Account Settings</a></li>


                    <!--            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>-->
                </ul>  
                <form action="logout_s" mehtod="post"> 
               <button type="submit" class="btn btn-default">logout</button> 
               </form>

            </nav>
        </div>
        
        
        
        
        
    </body>
</html>
