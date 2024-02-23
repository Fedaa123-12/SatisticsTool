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
    
<!-- Style -->
<link rel="stylesheet" href="fonts/icomoon/style.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/CSS.css">
<title>User profile</title>

<script> 

</script> 
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
        <article class="card-body mx-auto" style="max-width: 600px;">
        <!-- Checks the user acces level -->
	        <c:if test="${sessionScope.logged_in != null}">
		        <c:choose>
					<c:when test="${sessionScope.access_level == 'Admin'}">
			        	<div class="form-group">
			        		<form action = "./getAllUsers" method = "get">
								<button type="submit" class="btn btn-primary btn-block">Manage Users</button>
							</form>
						</div>
						<div class="form-group">
							<a href = "getAllTopics"><button type="submit" class="btn btn-primary btn-block">Manage Topics</button></a>
						</div>
						<div class="form-group">
							<a href = "createTopic.jsp"><button type="submit" class="btn btn-primary btn-block">Create Topics</button></a>
						</div>
						<div class="form-group">
							<form action = "./userUpdateDetailsGetDetails" method = "post">
								<button type="submit" class="btn btn-primary btn-block" name = "update" value="${user_ID}">Edit Details</button>
							</form>
						</div>
						<div class="form-group">
							<form action = "./viewAllComplaints" method = "post">
								<button type="submit" class="btn btn-primary btn-block" name = "update">View Complaints</button>
							</form>
						</div>
						<div class="form-group">
							<a href = "getBookmarks?user_ID=${user_ID}"><button type="submit" class="btn btn-primary btn-block">Bookmarks</button></a>
						</div>
					</c:when>
					
					
					
					
					<c:when test="${sessionScope.access_level == 'Teacher'}">
						<div class="form-group">
							<a href = "getAllTopics"><button type="submit" class="btn btn-primary btn-block">Manage Topics</button></a>
						</div>
						<div class="form-group">
							<a href = "createTopic.jsp"><button type="submit" class="btn btn-primary btn-block">Create Topics</button></a>
						</div>
						<div class="form-group">
							<a href = "teacherClasses?email=${user_email}"><button type="submit" class="btn btn-primary btn-block">Class Management</button></a>
						</div>
						<div class="form-group">
							<form action = "./userUpdateDetailsGetDetails" method = "post">
								<button type="submit" class="btn btn-primary btn-block" name = "update" value="${user_ID}">Edit Details</button>
							</form>
						</div>
						<div class="form-group">
							<a href = "getBookmarks?user_ID=${user_ID}"><button type="submit" class="btn btn-primary btn-block">Bookmarks</button></a>
						</div>
					</c:when>
					
					
					
					
					
				<c:when test="${sessionScope.access_level == 'Student'}">
					<div class="form-group">
						<a href = "getClassUserIn?user_email=${user_email}"><button type="submit" class="btn btn-primary btn-block">Class I am in</button></a>
					</div>
					<div class="form-group">
						<form action = "./userUpdateDetailsGetDetails" method = "post">
							<button type="submit" class="btn btn-primary btn-block" name = "update" value="${user_ID}">Edit Details</button>
						</form>
					</div>
					<div class="form-group">
						<a href = "getBookmarks?user_ID=${user_ID}"><button type="submit" class="btn btn-primary btn-block">Bookmarks</button></a>
					</div>
				</c:when>
				</c:choose>
			</c:if>
		
		

		</article>
			<c:if test="${sessionScope.logged_in == null}">
				<h1 class="card-title mt-3 text-center">Please Login to view this page</h1>
			</c:if>


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