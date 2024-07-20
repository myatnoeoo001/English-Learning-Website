<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="./css/homepage.css">
</head>
<body>

	<header>
<input type="checkbox" name="" id="toggler">
<label for="toggler" class="fas fa-bars"></label>
<a href="#" class="logo"> E-Learning <span>.</span></a> 
<nav class="navbar">
<a href="#home">Home</a>
<a href="#login">Sign In</a>
<a href="#about">About</a>
<a href="#contact">Contact</a>
</nav>

</header>
<section class="home" id="home" style="background: url('./img/homepage.jpg') no-repeat;background-size: cover;background-position: center;">
<div class="content">
<h3>CRUDLIK for you</h3>

<p>Discover a world of training at CRUDLIK. From beginner basics to advanced topics, we've got you covered. The easy-to-use platform offers articles and related questions for every level. Join us today and start learning at your own pace!</p>
<!-- <form action="question.jsp" method="post"> <button class="btn">Start</button> </form> -->
</div>
</section>
<section class="login" id="login">
	
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="Register" method="post">
                <h1 class="sign">Create Account</h1>
               
                <div class="infield">
                    <input style="text-transform: none" type="text" placeholder="Name" name="name" />
                    <label></label>
                </div>
                <div class="infield">
                    <input type="text" placeholder="email" name="email"/>
                    <label></label>
                </div>
                <div class="infield">
                    <input type="password" placeholder="password" name="password"/>
                    <label></label>
                </div>
				<div class="infield">
                    <input type="password" placeholder="ComfirmPassword" name="cpassword"/>
                    <label></label>
                </div>
                <button class="btn">Start</button> 
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form action="Login" method="post">
                <h1 class="sign">Sign in</h1>
                <div class="infield">
                    <input type="email" placeholder="email" name="email"/>
                    <label></label>
                </div>
                <div class="infield">
                    <input type="password" placeholder="password" name="password" />
                    <label></label>
                </div>
                <a href="#" class="forgot">Forgot your password?</a>
                <button>Sign In</button>
            </form>
        </div>
        <div class="overlay-container" id="overlayCon">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button>Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button>Sign Up</button>
                </div>
            </div>
            <button id="overlayBtn"></button>
        </div>
    </div>
    <!-- js code -->
    <script>
        const container=document.getElementById('container');
        const overlayCon=document.getElementById('overlayCon');
        const overlayBtn=document.getElementById('overlayBtn');
        
        overlayBtn.addEventListener('click',()=>{
        container.classList.toggle('right-panel-active');
        overlayBtn.classList.remove('btnScaled');
        window.requestAnimationFrame(()=>{
            overlayBtn.classList.add('btnScaled');
        })
         } );

    </script>
</section>
<section class="about" id="about" >
<h1 class="heading"> <span>About</span> CRUDLIK</h1>
<div class="row">
<div class="video-container">
  <img src="./img/p3.jpg" alt="CRUDLIK" style="border-radius: 23px;">
</div>
 <div class="content">

<p>E-learning, short for electronic learning, refers to the use of electronic technologies to deliver educational content and facilitate learning.Focusing solely on reading content on the website can still offer valuable learning opportunities.Organizing the website into basic, intermediate, and advanced levels is a great way to cater to learners of different skill levels. </p>
<p>Providing paragraphs followed by related questions is a common format for reading comprehension exercises. Can structure the website to present the paragraphs followed by questions that assess comprehension, critical thinking, and analysis skills. Users can then answer the questions to test their understanding of the content. This format encourages active engagement with the material and reinforces learning objectives.</p>
<p>By offering content ranging from basic to advanced levels, users can start at their current proficiency level and gradually work their way up, acquiring new knowledge and skills along the way. This structured approach facilitates continuous learning and skill development, allowing users to "level up" their expertise over time.</p>
</div></div>
</sectoin>	
		<section class="about" id="contact">
  <h1 class="heading"> <span>Contact</span> Us</h1>
  <div class="row">
      <div class="con-info">
        <div class="box">
          <div class="icon">
              <i class="fa-solid fa-location-dot"></i>
          </div>
              <div class="text">
                  <h3>Address</h3>
                  <p>University of Computer Studies<br>Taunggyi,Myanmar</p>
              </div>
       </div>
          <div class="box">
              <div class="icon">
                  <i class="fa-solid fa-envelope"></i>
              </div>
                  <div class="text">
                      <h3>Email</h3>
                      <p>crudlik@gmail.com</p>
                  </div>
          </div>
          <div class="box">
              <div class="icon">
                  <i class="fa-solid fa-phone"></i>
              </div>
                  <div class="text">
                      <h3>Phone</h3>
                      <p>09-959498242,09-696328615</p>
              </div>
         
         </div>
      </div>
   <div class="content">
  
  <p>Have a question or feedback? We're here to help! Reach out to us using the following methods:</p>
  <p>Our website  is committed to providing excellent support and will respond to your inquiries as soon as possible. 
    Thank you for choosing CRUDLIK for your learning journey!</p>
  </div></div>
  </sectoin>	
	
</body>
</html>