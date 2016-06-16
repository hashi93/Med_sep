<%-- 
    Document   : user_daily_details
    Created on : May 14, 2016, 4:55:31 PM
    Author     : Scorpius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User_daily_details</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/style.css">
        <link rel="stylesheet" href="bootstrap/css/normalize.css">
        <link rel="stylesheet" href="bootstrap/css/style2.css">
        <link rel="stylesheet" href="bootstrap/css/mystyles.css">
        <!--        <link rel="stylesheet" href="bootstrap/datetime/time2CSS.css">-->
        <link rel="stylesheet" href="bootstrap/datetime2/jquery.datetimepicker.css">
        <!--        jquery Ui-->


        <link rel="stylesheet" href="bootstrap/jquery_ui/jquery-ui.min.css">
        <script src="bootstrap/jquery_ui/jquery.js"></script>
        <script src="bootstrap/jquery_ui/jquery-ui.min.js"></script>

        <!--         <script src="bootstrap/datetime/jquery-ui.js"></script>
                <script src="bootstrap/datetime/time_1.js"></script>-->

        <script src="bootstrap/datetime2/jquery.datetimepicker.full.min.js"></script>
        <script src="bootstrap/datetime2/jquery.datetimepicker.full.js"></script>

        <!--        chart-->
        <script src="bootstrap/chart/jquery.canvasjs.min.js"></script>



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

//                alert("logout");

                $.post("logout_s", function (responseJson) {
                    window.location.href = "index.jsp";
                });
            });
        </script>


        <div class="middle-box2">
            <div class="middle-box-head">
                <h1 class="headding-colour">Add daily details</h1>

            </div>
            <%  String msg = request.getParameter("message");
                    
                    if(msg!=null){

                    
    if (msg.equals("Idate")) {
                System.out.println("Idate");%>
                <h1>Invalid date has been entered !</h1>
<!--<script>
    alert("invalidD");
</script>-->

<% }else if(msg.equals("success")){ %>

<h1>Data saved successfully !</h1>




<%}else if(msg.equals("primary")){ %>
<h1>Data have already entered!</h1>


<% }} %>
               

            
            
            
            
            <form action="add_daily_details_S" mehtod="post">
                <div>



                    <lable>Select Date</lable>
                    <input type="text" name="date" id="date"  class="border-input" readonly />

                    <script>
                        $("#date").datepicker({
                            dateFormat: "yy/mm/dd"
                        });
                    </script>

                    <lable>Enter value </lable>
                    <input type="number" step="0.01" name="value" min="0"  class="border-input">

                    <lable>Select type</lable>
                    <select name="type">
                        <option value="weight">Weight (In KG)</option>
                        <option value="Water">Water Drank (In ML) </option>

                    </select>

                    <input type="submit" class="button_123"  value="save">

                </div>
            </form>

            <div class="middle-box-head">
                <h1 class="headding-colour">Show graphs</h1>
            </div>

            <lable>From : </lable>
            <input type="text" name="date1" id="date1"  class="border-input" readonly />
            <script>
                $("#date1").datepicker({
                    dateFormat: "yy/mm/dd"
                });
            </script>
            <lable>To : </lable>
            <input type="text" name="date2" id="date2"  class="border-input" readonly />
            <script>
                $("#date2").datepicker({
                    dateFormat: "yy/mm/dd"
                });
            </script>

            <lable>Select type</lable>
            <select name="setectType" id="Stype">
                <option value="weight">Weight</option>
                <option value="Water">Water Drank   </option>

            </select>

            <input type="button" name="graph" id="graph" class="button_123" value="show graph">

            <!--            show graph-->





            <script>

                $("#graph").click(function () {

                    if (document.getElementById("date1").value == '' || document.getElementById("date2").value == '') {
                        if ($('#showGraph').is(':visible')) {
                            $('#showGraph').hide();
                        }
                        $('#errorMsg').show();

                    } else {
                        var data = document.getElementById("Stype").value + "," + document.getElementById("date1").value + "," + document.getElementById("date2").value
                        alert(data)



                        $.post("show_graph_S?q=" + data, function (responseJson) {
                            if (responseJson != null) {
//
                                if ($('#errorMsg').is(':visible')) {
                                    $('#errorMsg').hide();
                                    $('#showGraph').show();
                                }

//                                var dataPoints = [
//                                    {x: new Date(2012, 00, 1), y: 450},
//                                    {x: new Date(2012, 01, 1), y: 414},
//                                    {x: new Date(2012, 02, 1), y: 520},
//                                    {x: new Date(2012, 03, 1), y: 460},
//                                    {x: new Date(2012, 04, 1), y: 450},
//                                    {x: new Date(2012, 05, 1), y: 500},
//                                    {x: new Date(2012, 06, 1), y: 480},
//                                    {x: new Date(2012, 07, 1), y: 480},
//                                    {x: new Date(2012, 08, 1), y: 410},
//                                    {x: new Date(2012, 09, 1), y: 500},
//                                    {x: new Date(2012, 10, 1), y: 480},
//                                    {x: new Date(2012, 11, 1), y: 510}
//                                ]
//                                datat = {x: new Date(2012, 00, 1), y: 450};
//                                alert(datat['x']);
                                var dataPoints = [];

                                 $.each(responseJson, function (key, value) {
//                                    data = {x: new Date(value['date']), y: value['value']};
                                    data = {lable: value['date'], y: value['value']};
                                    dataPoints.push(data);
                                   // alert(data['lable']);
                                });
                                //Better to construct options first and then pass it as a parameter
                                var options = {
                                    title: {
                                        text: "Chart"
                                    },
                                    animationEnabled: true,
                                    data: [
                                        {
                                            type: "spline", //change it to line, area, column, pie, etc
                                            dataPoints
//                                           
                                        }
                                    ]
                                };
                                $("#showGraph").CanvasJSChart(options);





                            } else {

                                if ($('#showGraph').is(':visible')) {
                                    $('#showGraph').hide();
                                    $('#errorMsg').show();
                                }


                            }





                        });
                    }
                });

            </script>
            <div id="errorMsg">
                <p>No result found with in given range :(</p>

            </div>
            <div id="showGraph" style="height: 300px; width: 100%;">


            </div>


        </div>
        <script>
            $('#errorMsg').hide();
//            $('#showGraph').hide();
        </script>


    </body>
</html>
