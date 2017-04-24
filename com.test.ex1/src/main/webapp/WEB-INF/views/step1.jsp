<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form id='frm' name='frm' method="post" action="login.do">
	<input type="text" id="id" name="id" />
	<input type="text" id="pw" name="pw" />
</form>

<a href="#this" class="btn" id="nextStep">다음</a>



<script type="text/javascript">
        $(document).ready(function(){
        	
            
        	$("#nextStep").on("click", function(e){ 
                e.preventDefault();
                document.frm.submit();
            });
            
     
        });
         
         
      
    </script>

</body>
</html>
