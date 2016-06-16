<%-- 
    Document   : doctor_home
    Created on : May 14, 2016, 4:57:08 PM
    Author     : Scorpius
--%>

<%@page import="DAO.patientD"%>
<%@page import="DAO.user_details"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="controllers.doctorDetailsC"%>
<%@page import="controllers.patient_doctorC"%>
<%@page import="DAO.doctor_details"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.userDetailsC"%>
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

        <title>Doctor Home</title>
    </head>
    <body class="bodyimage">

        <div>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Healthy Wealthy</a>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active"><a href="doctor_home.jsp">Home</a></li>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Account Settings</a></li>
                    <li id="logOut"><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>


                </ul>
                <script>

                    $("#logOut").click(function () {

                        $.post("logout_s", function (responseJson) {
                            window.location.href = "index.jsp";

                        });

                    });

                </script>





            </nav>
        </div>
        <div class="middle-box2">


            <h2>List of Patients</h2>

            <lable>Select Patient</lable>
            <select name="patients" id="pl">
                <!--                load from dB-->
                <%
                    String dr_name = (String) session.getAttribute("UserName");
                    int doctor_id = doctorDetailsC.getId(dr_name);
                    if (doctor_id != -999) {
                        ArrayList<patientD> list = new ArrayList<patientD>();
                        ArrayList<Integer> id = new ArrayList<Integer>();

                        id = patient_doctorC.returnListI(doctor_id);
                        if (id.size() != 0) {
                            list = userDetailsC.returnListP(id);

                            if (list.size() != 0) {
                                for (int i = 0; i < list.size(); i++) {

                                    String Pemail = list.get(i).getEmail();
                                    String Pname = list.get(i).getFullName();
                                    String lable1 = Pemail + "," + Pname;
                %>




                <option><%=lable1%></option>


                <%   }
                            }
                        }
                    }
                %> 



            </select>

            <lable>Select type</lable>
            <select name="type" id="type">
                <option>View Disease Details</option>
                <option>View Treatment Details</option>

            </select>

            <button type="button" id="viewD" class="btn btn-default">Enter</button> 
            <div class="middle-box2">
                <div id="txtHint">

                    <table id="Viewers" class="mytable">
                        <thead>
                            <tr>
                                <th>Disease Name</th>
                                <th>Date</th>
                                <th>Symptom</th>
                                <th>Description</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                
                
                 <div id="txtHint2">

                    <table id="Viewers2" class="mytable">
                        <thead>
                            <tr>
                                <th>Disease Name</th>
                                <th>Date</th>
                                <th>Treatment</th>
                                <th>Description</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>

                <div id="Noresult">

                    <p>      NO RESULT FOUND...... :( </p>
                </div>

            </div>




            <script>
                $('#txtHint').hide();
                $('#Noresult').hide();
                 $('#txtHint2').hide();
                 
                $("#viewD").click(function () {


                    var data = document.getElementById("pl").value + "," + document.getElementById("type").value
                    alert(data);
                    $.post("view_detailsD_s?q=" + data, function (responseJson) {
                       
        if(document.getElementById("type").value=="View Disease Details"){
        
                    if (responseJson != null) {

                            if ($('#Noresult').is(':visible')  )
                            {
                                $('#Noresult').hide();
                            }
                            if ($('#txtHint2').is(':visible')  )
                            {
                                $('#txtHint2').hide();
                            }
                                            $("#Viewers").find("tr:gt(0)").remove();
                                            var table1 = $("#Viewers");
                                            $.each(responseJson, function (key, value) {
                                                     var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                                        rowNew.children().eq(0).text(value['diseasename']);
                                                        rowNew.children().eq(1).text(value['date']);
                                rowNew.children().eq(2).text(value['symptoms']);
                                rowNew.children().eq(3).text(value['description']);
//                                    rowNew.children().eq(2).text(value = "Add");
                        
                                                        rowNew.appendTo(table1);
                                            });
                            $('#txtHint').show();
                                        } else {
                            if ($('#txtHint').is(':visible'))
                            {
                                $("#txtHint").hide();
                            }
                             if ($('#txtHint2').is(':visible')  )
                            {
                                $('#txtHint2').hide();
                            }
   
                            $('#Noresult').show();

                        }


        }else{
            
            if (responseJson != null) {

                            if ($('#Noresult').is(':visible')  )
                            {
                                $('#Noresult').hide();
                            }
                            if ($('#txtHint').is(':visible')  )
                            {
                                $('#txtHint').hide();
                            }
                                            $("#Viewers2").find("tr:gt(0)").remove();
                                            var table2 = $("#Viewers2");
                                            $.each(responseJson, function (key, value) {
                                                     var rowNew = $("<tr><td></td><td></td><td></td><td></td></tr>");
                                                        rowNew.children().eq(0).text(value['diseasename']);
                                                        rowNew.children().eq(1).text(value['date']);
                                rowNew.children().eq(2).text(value['treatment']);
                                rowNew.children().eq(3).text(value['description']);
//                                    rowNew.children().eq(2).text(value = "Add");
                        
                                                        rowNew.appendTo(table2);
                                            });
                            $('#txtHint2').show();
                                        } else {
                            if ($('#txtHint').is(':visible'))
                            {
                                $("#txtHint").hide();
                            }
                             if ($('#txtHint2').is(':visible')  )
                            {
                                $('#txtHint2').hide();
                            }
   
                            $('#Noresult').show();

                        }
            
            
            
            
        }







                    });

                });

            </script>

        </div>




    </body>
</html>
