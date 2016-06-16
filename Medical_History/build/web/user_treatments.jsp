<%-- 
    Document   : user_treatments
    Created on : May 14, 2016, 4:53:36 PM
    Author     : Scorpius
--%>

<%@page import="controllers.treatmentC"%>
<%@page import="DAO.treatments"%>
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
        
        
        <title>User_treatments</title>
        
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
       
        
         <!--        navbar implementation-->
        <div>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Healthy Wealthy</a>
                </div>

                <ul class="nav navbar-nav">
                    <li ><a href="user_home.jsp">Home</a></li>
                    <li><a href="#">Reports</a></li>
                    <li class="active"><a href="#">Treatments</a></li>
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
                <h1 class="headding-colour">Add details about treatment</h1>
            </div>
            <form action="add_new_treatment_detail_S" mehtod="post">
                <div>

                    <lable>Disease Name</lable>
                    <input type="text"  name="disease_name" class="border-input"  />



                           <lable>Date</lable>
                           <input type="text" name="date" id="date"  class="border-input"  />
                               
                    <script>
                        $("#date").datepicker({
                            
                            dateFormat: "yy/mm/dd"
                        });
                    </script>

                    <lable>Treatment</lable>
                    <textarea name="treatment" rows="5" cols="30"  class="border-input">
                    </textarea>

                    <lable>Description</lable>
                    <textarea name="description" rows="5" cols="30"  class="border-input">
                    </textarea>

                </div>

                <div>
                    <input type="button"  class="button_123" value="cancel">
                    <input type="submit" class="button_123"  value="save">
                </div>
            </form>
                
                 <h2>Past Details</h2>

            <div>
                <table id="listOD">

                    <thead>
                        <tr>
                            <th>Disease name</th>
                            <th>Date</th>
                            <th>Treatment</th>
                            <th>Description</th>
                              <th>Added By</th>
                            <th>Added On</th>


                        </tr>
                    </thead>



                    <%
                        String patient_name = (String) session.getAttribute("UserName");
                        int patient_id = userDetailsC.getId(patient_name);
    //                    ArrayList<Integer> list = new ArrayList<Integer>();
                        ArrayList<treatments> listOfT = new ArrayList<treatments>();

    //                    list = patient_doctorC.returnListOfDoctors(patient_id);
                        listOfT = treatmentC.returnListOfT(patient_id);
                        if(listOfT.size()!=0){
                    for (int i = 0; i < listOfT.size(); i++) {%>
                    <tbody>
                        <tr>
                            <td><%=listOfT.get(i).getDiseasename()%></td>
                            <td><%=listOfT.get(i).getDate()%> </td>
                            <td><%=listOfT.get(i).getTreatment()%></td>
                            <td><%=listOfT.get(i).getDescription()%> </td>
                            <td><%=listOfT.get(i).getAddedBy()%></td>
                            <td><%=listOfT.get(i).getAddedOn()%> </td>
                        </tr>
                    </tbody>
                    <%   } }
                    %> 



                </table>
            </div>
                
                
                
                
                
        </div>

            
            
            
            
            
            
            
            
            
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
