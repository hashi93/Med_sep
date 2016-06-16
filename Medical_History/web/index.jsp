<%-- 
    Document   : index
    Created on : May 2, 2016, 9:26:49 PM
    Author     : Scorpius
--%>

<%--<%@page import="java.nio.file.Files.exists(Path, LinkOption[])"%>
<%@page import="java.nio.file.Files.exists(Path, LinkOption[])"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="bootstrap/css/style.css">

        <link rel="stylesheet" href="bootstrap/css/normalize.css">
        <link rel="stylesheet" href="bootstrap/css/style2.css">

    </head>
    <body class="bodyimage">


        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="single-page-nav sticky-wrapper" id="tmNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="#home">Homepage</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#getstarted">Get Started</a></li>
                        <li><a href="#contact">Contact</a></li>

                    </ul>
                </div>
            </div>
        </nav>

        <div id="home">
            <header id="header-area" class="intro-section">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 text-center">
                            <div class="header-content">

                                <h1>Healthy Wealthy</h1>
                                <h4>Stay Strong Live Strong</h4>

                            </div>
                        </div>
                    </div>
                </div>
            </header>
        </div>

        <div id="about">
            <section id="services-area" >

                <div class="col-sm-12 text-center inner our-service">
                    <div class="service"  style="margin-top: 40px;">
                        <h1>Our Services</h1>
                        <p>jfhsjhfskjfsdlkfls;dkflsdkf.</p>
                    </div>
                </div>

            </section>
            <!-- Start Testimornial Area -->
            <section id="testimornial-area">
                <div class="container">
                    <div class="row text-center">
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                            <div class="testimonial-content">
                                <img src="img/tile1.jpg" alt="Image">
                                <h2>function One</h2>
                                <p>kjdkajdklsjdlsjdklsa</p>
                                <br>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                            <div class="testimonial-content">
                                <img src="img/tile6.jpg" alt="Image">
                                <h2>function Two</h2>
                                <p>hdjsdhkjkdjskldjsljskldsk</p>

                                <br>
                                <p id="redd"></p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                            <div class="testimonial-content">
                                <img src="img/tile4.jpg" alt="Image">
                                <h2>function three</h2>
                                <p>saidsidhsahdjsahdjkashdkjas.</p>
                                <br>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                            <div class="testimonial-content">
                                <img src="img/tile5.jpg" alt="Image">
                                <h2>function four</h2>
                                <p>cvsdfgdgfdgfdgfghgfj.</p>

                                <br>
                                <p id="dets"></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="tm-box">
                                <img src="img/tile3.jpg" alt="Image" class="img-responsive">
                                <div class="tm-box-description">
                                    <h2>About Us</h2>
                                    <p class="tm-box-p">fksdfklsdjfjsd;lfjdlsjfldjflkdjgkljfdkgfjgkdjgkfdjgfkldjgkfdjgkdfjglkfdj</p>
                                    <p class="tm-box-p">gdskfsdkfsdnfmsdfmdmdsf,ds,.fmsd,.mf,.dsmf,sdmfsdf,mfd,fmsdfm,f</p>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Testimornial Area -->
        </div>

        <div id="getstarted" style="padding-top: 60px;">
            <div class="form" >

                <ul class="tab-group">
                    <li class="tab active"><a href="#signup">Sign Up</a></li>
                    <li class="tab"><a href="#login">Log In</a></li>
                </ul>

                <div class="tab-content">
                    <div id="signup">
                        <h1>Sign Up for Free</h1>

                        <%  String msign = request.getParameter("msign");

                            if (msign != null) {

                                if (msign.equals("primary")) {
                                    System.out.println("Idate");%>
                       
                        <script>
                            alert("User already exists  !");
                        </script>


                        <%}
                            } %>

                        <%  String mlog = request.getParameter("log");

                            if (mlog != null) {

                                if (mlog.equals("invalid")) {
                        %>
                        <script>
                            alert("Invalid Login information !");
                        </script>



                        <%}
                            } %>




                        <form action="add_new_user_S" method="post">

                            <div class="top-row">
                                <div class="field-wrap">

                                    <label>
                                        First Name<span class="req">*</span>
                                    </label>

                                    <input type="text" name="firstName" required autocomplete="off" />
                                </div>

                                <div class="field-wrap">
                                    <label>
                                        Last Name<span class="req">*</span>
                                    </label>
                                    <input type="text" name="lastName" required autocomplete="off"/>
                                </div>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Email Address<span class="req">*</span>
                                </label>
                                <input type="email" name="emailAddress" required autocomplete="off"/>
                            </div>



                            <div class="field-wrap">
                                <label>
                                    User Type<span class="req">*</span>
                                </label><br>
                            </div>

                            <div>
                                <input type="radio" name="user type"  value="Patient" checked><span style="color:gray;font-weight:bold;font-size:150%">Patient</span>
                                <input type="radio" name="user type" value="Doctor"><span style="color:gray;font-weight:bold;font-size:150%">Doctor</span><br>
                            </div> 



                            <div class="field-wrap">
                                <label>
                                    Set A Password<span class="req">*</span>
                                </label>
                                <input type="password" name="password" required autocomplete="off"/>
                            </div>

                            <button type="submit" class="button button-block"/>Get Started</button>

                        </form>

                    </div>

                    <div id="login">
                        <h1>Welcome Back!</h1>





                        <form action="user_login_S" method="POST">

                            <div class="field-wrap">
                                <label>
                                    Email Address<span class="req">*</span>
                                </label>
                                <input type="email" name="user_name" required autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Password<span class="req">*</span>
                                </label>
                                <input type="password" name="password" required autocomplete="off"/>
                            </div>

                            <p class="forgot"><a href="#">Forgot Password?</a></p>

                            <button type="submit" class="button button-block"/>Log In</button>

                        </form>

                    </div>

                </div><!-- tab-content -->

            </div> <!-- /form -->
            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

            <script src="bootstrap/js/index.js"></script>



        </div>




        <div id="contact">
            <!-- Start Contact Area -->
            <section id="contact-area" class="contact-section">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 text-center inner">
                            <div class="contact-content">
                                <h1>contact form</h1>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <p>fld;kld;kvlcvlcmv,cmxvmcxl.</p>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="#" method="post" class="contact-form">
                                <div class="col-sm-6 contact-form-left">
                                    <div class="form-group">
                                        <input name="name" type="text" class="form-control" id="name" placeholder="Name">
                                        <input type="email" name="email" class="form-control" id="mail" placeholder="Email">
                                        <input name="subject" type="text" class="form-control" id="subject" placeholder="Subject">
                                    </div>
                                </div>
                                <div class="col-sm-6 contact-form-right">
                                    <div class="form-group">
                                        <textarea name="message" rows="6" class="form-control" id="comment" placeholder="Your message here..."></textarea>
                                        <button type="submit" class="btn btn-default">Send</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End Contact Area -->
        </div>

        <script src="bootstrap/js/jquery-1.11.2.min.js"></script>
        <script src="bootstrap/js/jquery.scrollUp.min.js"></script> <!-- https://github.com/markgoodyear/scrollup -->
        <script src="bootstrap/js/jquery.singlePageNav.min.js"></script> <!-- https://github.com/ChrisWojcik/single-page-nav -->
        <script src="bootstrap/js/parallax.js-1.3.1/parallax.js"></script> <!-- http://pixelcog.github.io/parallax.js/ -->



        <p>Message: ${param.msg}</p>
        <!--         <script type="text/javascript">
              function alertA(){
                  alert("Already exists");
              }
          
          </script>
          
        <%String m = "${param.msg}"; %>
        <%if (m.equals("User already exists")) { %>
              
        <script> alertA();</script>-->

        <% }%>
    </body>
</html>
