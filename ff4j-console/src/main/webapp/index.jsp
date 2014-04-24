<%@ taglib prefix="ff4j" uri="http://www.ff4j.org/taglibs/ff4j" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>FF4J - Administration Console</title>
 <link href="css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
 padding-top: 60px;
 padding-bottom: 40px;
}
</style>
<script src="js/jquery.js"></script>
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Simple Web Application</a>
			</div>
		</div>
	</div>

	<div class="container">
	
	   <div class="jumbotron">
        
		<p> This a simple web application for <a href="http://ff4j.org">ff4j</a>. 
		
		<p>2 features are created <b>'sayHello'</b> and <b>'sayGoodBye'.</b>
		
		<p> 
		 <a href="<%=request.getContextPath()%>/ff4j-console" class="btn btn-primary" >
			<i class="icon-th-large icon-white"></i>&nbsp;Access Web Console
		</a>
		
	
		<p><br/><u>Below here sentences are displayed only if feature is enable using TAGLIB :</u> 	
		
		<ff4j:enable featureid="sayHello">
			<p class="alert alert-success">Hello visitor ! Feature 'sayHello' is enable
      	</ff4j:enable>
      	
      	<ff4j:enable featureid="sayGoodBye">
      		<p class="alert alert-success">Good Bye visitor !  Feature 'sayGoodbye' is enable
      	</ff4j:enable>
      </div>
      
	</div>
	
	</body>
</html>
