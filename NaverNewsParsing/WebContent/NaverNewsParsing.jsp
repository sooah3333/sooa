<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="UTF-8">
<head>
	<meta charset="utf-8">
  	<meta http-equiv="Content-Type" content="text/html">
  	<title>Naver News</title>
  	<!--  <link rel="stylesheet" href="./css/bootstrap.min.css">-->
  	<link rel="stylesheet" href="./css/style.css">
  	<link rel="stylesheet" href="./css/font-awesome.min.css">
  	<script type="text/javascript" src="./jquery/1.9.1/jquery.min.js"></script>
  	<script type="text/javascript" src="./js/NaverNewParsing.js"></script>
  	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
	<div id="content" class="content">
	
	<!--  2cb400-->
    	
    	
    	<div class="box">
    		<div class="headerContent">
    			<img src="./img/logo.png" align="absbottom">
    			<input type='text' id='search' class="inputtxt">
    			<input type='image' src='./img/search_btn.png' align="absbottom" value='search' onclick='Function()'>
      		</div>
     
      		<div id="navernews" ></div>
      		
      		<div class="btn">
      			<i class="fa fa-caret-left" style="font-size:36px;color:#2cb400" onclick="previous()"></i>
				<i class="fa fa-caret-right" style="font-size:36px;color:#2cb400" onclick="next()"></i>

			</div>
      	</div>
      	
      	
    </div>

</body>
</html>