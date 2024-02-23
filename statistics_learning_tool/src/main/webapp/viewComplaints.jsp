<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix ="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<!-- Style -->
<link rel="stylesheet" href="fonts/icomoon/style.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/CSS.css">
<title>Register</title>
</head>
<body>
<!-- Header -->
 <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
          </div>
        </div>
        <div class="site-mobile-menu-body"></div>
      </div>
      <header class="site-navbar js-sticky-header site-navbar-target" role="banner">
        <div class="container">
          <div class="row align-items-center position-relative">
            <div class="site-logo">
              <a href="index.jsp" class="text-black"><span class="text-primary">Statistics</span></a>
            </div>
            <div class="col-12">
              <nav class="site-navigation text-right ml-auto " role="navigation">

                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                  <li><a href="index.jsp" class="nav-link">Home</a></li>
                  <c:if test="${sessionScope.logged_in == null}">
					<li><a href="login.jsp" class="nav-link">Login</a></li>
                  	<li><a href="register.jsp" class="nav-link">Register</a></li>
                  </c:if>
                  <c:if test="${sessionScope.logged_in != null}">
                  	<li><a href="user_page.jsp" class="nav-link">Profile</a></li>
                  	<li><a href="logout" class="nav-link">Logout</a></li>
                  </c:if>
                </ul>
              </nav>
            </div>
            <div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>
          </div>
        </div>
      </header>
<!-- Header -->	
<div class="table-responsive card-body mx-auto" style="max-width: 85%;">
<table class="table">
<tr>
	<th>Complaint ID</th>
	<th>Complaint Subject</th>
	<th>Complaint Description</th>
	<th>Read</th>
</tr>

<c:forEach items="${allComplaints}" var="c">
	<tr>
		<td>${c.complaint_ID}</td>
		<td>${c.complaint_subject}</td>
		<td>${c.complaint_description}</td>
		<td>
			<form action="./deleteComplaint" method="post">
				<button class='deleteBtn btn btn-outline-danger' name="delete" value="${c.complaint_ID}">Delete</button>
			</form>
		</td>
	</tr>
</c:forEach>

</table>
</div>















<!-- footer -->
 <footer class="text-center text-lg-start text-dark" >
    <!-- Section: Links  -->
      <div class="container text-center text-md-start">
        <!-- Grid row -->
        <div class="row">
          <!-- Grid column -->
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold">Useful links</h6>
            <hr
                class="mb-4 mt-0 d-inline-block mx-auto"
                style="width: 60px; background-color: #7c4dff; height: 2px"
                />
            <p>
            <c:if test="${sessionScope.logged_in != null}">
              <p><a href="userComplaints.jsp" class="text-dark">Submit Complaint</a></p>
            </c:if>
			<c:if test="${sessionScope.logged_in != null}">
              <a href="user_page.jsp" class="text-dark">Your Account</a>
            </c:if>
            <c:if test="${sessionScope.logged_in == null}">
              <a href="login.jsp" class="text-dark">Your Account</a>
            </c:if>
            </p>
            
          </div>
          <!-- Grid column -->
          <!-- Grid column -->
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold">Contact</h6>
            <hr
                class="mb-4 mt-0 d-inline-block mx-auto"
                style="width: 60px; background-color: #7c4dff; height: 2px"
                />
            <p><i class="fas fa-home mr-3"></i> Manchester, UK</p>
            <p><i class="fas fa-envelope mr-3"></i> info@Admin.com</p>
            <p><i class="fas fa-print mr-3"></i> +44 9866823932</p>
            
          </div>
          <!-- Grid column -->
        </div>
        <!-- Grid row -->
      </div>
    <!-- Section: Links  -->
  </footer>
  <!-- Footer -->


<!-- Script tags -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/main.js"></script>
<script src="js/script.js"></script>
</body>
</html>