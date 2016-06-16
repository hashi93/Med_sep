<%-- 
    Document   : user_home
    Created on : May 13, 2016, 1:53:51 PM
    Author     : Scorpius
--%>

<%@page import="controllers.diseaseC"%>
<%@page import="DAO.disease"%>
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




        <title>user_home</title>

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




        <!--        <input hidden=""-->

        <!--        navbar implementation-->
        <div>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Healthy Wealthy</a>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="user_reports.jsp">Reports</a></li>
                    <li><a href="user_treatments.jsp">Treatments</a></li>
                    <li><a href="user_daily_details.jsp">Daily Details</a></li>
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
        </div>

        <script>

            $("#logOut").click(function () {

                $.post("logout_s", function (responseJson) {
                    window.location.href = "index.jsp";

                });

            });

        </script>




        <!--        add new disease -->



        <div class="middle-box2">
            <div class="middle-box-head">
                <h1 class="headding-colour">Add details about illness</h1>
            </div>
            <%  String addDis = request.getParameter("addDis");

                if (addDis != null) {

                    if (addDis.equals("success")) {
            %>
            <h1>Data saved successfully !</h1>

            <% } else if (addDis.equals("error")) { %>

            <h1>Error occurred !</h1>

            <% } else if (addDis.equals("invalid")) { %>
            <h1>Invalid date !</h1>

            <%}
                }%>




            <form action="add_new_disease_detail_S" mehtod="post">
                <div>






                    <lable>Disease Name</lable>
                    <input type="text" id="t1" name="disease_name" class="border-input" required />



                    <lable>Date</lable>
                    <input type="text" name="date" id="date"  class="border-input"  required />

                    <script>
                        $("#date").datepicker({
                            dateFormat: "yy/mm/dd"
                        });
                    </script>

                    <lable>Symptoms</lable>
                    <textarea name="symptoms"  id="t2" rows="5" cols="30"  class="border-input">
                    </textarea>

                    <lable>Description</lable>
                    <textarea name="description"  id="t3" rows="5" cols="30"  class="border-input">
                    </textarea>


                </div>

                <div>
                    <input type="button" id="clear" class="button_123" value="cancel">
                    <input type="submit" class="button_123"  value="save">
                </div>
                <script>

                    $("#clear").click(function () {

                        document.getElementById("t1").value = "";
                        document.getElementById("t2").value = "";
                        document.getElementById("t3").value = "";
                        document.getElementById("date").value = "";
                    });
                </script>

            </form>

            <h2>Past Details</h2>

            <div>
                <table id="listOD">

                    <thead>
                        <tr>
                            <th>Disease name</th>
                            <th>Date</th>
                            <th>Symptom</th>
                            <th>Description</th>
                              <th>Added By</th>
                            <th>Added On</th>


                        </tr>
                    </thead>



                    <%
                        String patient_name = (String) session.getAttribute("UserName");
                        int patient_id = userDetailsC.getId(patient_name);
    //                    ArrayList<Integer> list = new ArrayList<Integer>();
                        ArrayList<disease> listOfDis = new ArrayList<disease>();

    //                    list = patient_doctorC.returnListOfDoctors(patient_id);
                        listOfDis = diseaseC.returnListOfDis(patient_id);
                        if(listOfDis.size()!=0){
                    for (int i = 0; i < listOfDis.size(); i++) {%>
                    <tbody>
                        <tr>
                            <td><%=listOfDis.get(i).getDiseasename()%></td>
                            <td><%=listOfDis.get(i).getDate()%> </td>
                            <td><%=listOfDis.get(i).getSymptoms()%></td>
                            <td><%=listOfDis.get(i).getDescription()%> </td>
                            <td><%=listOfDis.get(i).getAddedBy()%></td>
                            <td><%=listOfDis.get(i).getAddedOn()%> </td>
                        </tr>
                    </tbody>
                    <%   } }
                    %>



                </table>
            </div>





        </div>

        <!--        former diseases-->




    </body>
</html>
