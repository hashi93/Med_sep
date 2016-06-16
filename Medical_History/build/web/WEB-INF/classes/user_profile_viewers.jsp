<%-- 
    Document   : user_account_settings
    Created on : May 14, 2016, 4:56:35 PM
    Author     : Scorpius
--%>

<%@page import="controllers.doctorDetailsC"%>
<%@page import="DAO.doctor_details"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.patient_doctorC"%>
<%@page import="controllers.userDetailsC"%>
<%@page import="java.sql.Connection"%>
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


        <script src="bootstrap/jquery/jquery-1.12.4.js"></script>
        <script src="bootstrap/jquery/jquery-1.12.4.min.js"></script>

        <style>


            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            tr:hover{background-color:#f5f5f5}
        </style>

        <title>User_Account_Settings</title>
    </head>
    <body class="bodyimage">

        <!--        navbar implementation-->
        <div>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Healthy Wealthy</a>
                </div>

                <ul class="nav navbar-nav">
                    <li><a href="user_home.jsp">Home</a></li>
                    <li><a href="#">Reports</a></li>
                    <li><a href="user_treatments.jsp">Treatments</a></li>
                    <li><a href="#">Daily Details</a></li>
                    <li class="active"><a href="#">Profile Viewers</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Account Settings</a></li>
                     <li id="logOut"><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>  
            </nav>
            
            <script>

            $("#logOut").click(function () {
                $.post("logout_s", function (responseJson) {
                    window.location.href = "index.jsp";

                });

            });

        </script>
            
            
            
        </div>
        <div class="middle-box2">
            <div class="middle-box-head" >

                <!--               <h1 class="headding-colour">Add details about illness</h1>-->

                <!--               <div class="middle-box2">-->
                <!--            onkeypress="myFunction(event)"-->
                <lable>Search</lable>
                <input type="text"  name="search" id="forSearch"   class="border-input"  />

            </div>
        </div>

    </div>
    <div class="middle-box2">
        <div id="txtHint">

            <table id="Viewers" class="mytable">
                <thead>
                    <tr>
                        <th>email</th>
                        <th>Full Name</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>

        <div id="Noresult">

            <p>      NO RESULT FOUND...... :( </p>
        </div>



        <script>

            $("#Viewers tbody").on('click', 'td', function () {
                var cellData = $(this).parent().children().val($(this)).html();
                alert(cellData);

                $.post("add_profile_viewers_S?q=" + cellData, function (responseJson) {
                });

                $(this).parent().children().remove();

            });

        </script>


        <script>

            $(document).ready(function () {
                $('#txtHint').hide();
                $('#Noresult').hide();

                $('#forSearch').keypress(function (e) {

                    if (e.keyCode == 13) {

                        $.post("find_Viewers_S?q=" + document.getElementById("forSearch").value, function (responseJson) {
                            if (responseJson != null) {

                                if ($('#Noresult').is(':visible'))
                                {
                                    $('#Noresult').hide();
                                }
                                                $("#Viewers").find("tr:gt(0)").remove();
                                                var table1 = $("#Viewers");
                                                $.each(responseJson, function (key, value) {
                                                         var rowNew = $("<tr><td></td><td></td></tr>");
                                                            rowNew.children().eq(0).text(value['userName']);
                                                            rowNew.children().eq(1).text(value['fullName']);
//                                    rowNew.children().eq(2).text(value = "Add");
                        
                                                            rowNew.appendTo(table1);
                                                });
                                $('#txtHint').show();
                                            } else {
                                if ($('#txtHint').is(':visible'))
                                {
                                    $("#txtHint").hide();
                                }
   
                                $('#Noresult').show();

                            }


                        });
                    }

                });

            });




        </script>









        <h2>Profile  VIewers</h2>

        <div>
            <table id="listOD">

                <thead>
                    <tr>
                        <th>email</th>
                        <th>Full name</th>

                    </tr>
                </thead>



                <%
                    String patient_name = (String) session.getAttribute("UserName");
                    int patient_id = userDetailsC.getId(patient_name);
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    ArrayList<doctor_details> listOfDoc = new ArrayList<doctor_details>();

                    list = patient_doctorC.returnListOfDoctors(patient_id);
                    listOfDoc = doctorDetailsC.returnListOfDoc(list);

                 for (int i = 0; i < listOfDoc.size(); i++) {%>
                <tbody>
                    <tr>
                        <td><%=listOfDoc.get(i).getUserName()%></td>
                        <td><%=listOfDoc.get(i).getFullName()%> </td>


                    </tr>
                </tbody>
                <%   }
                %>



            </table>
        </div>

        <script>

            $("#listOD tbody").on('click', 'td', function () {
                var cell = $(this).parent().children().val($(this)).html();
                alert(cell);

                $.post("remove_profile_viewers_S?data=" + cell, function (responseJson) {
                });


                $(this).parent().children().remove();

            });

        </script>


    </div>   
</body>
</html>
