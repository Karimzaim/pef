
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
     <head>
        <title> welcome </title>

        <spring:url value="/resources/css/main.css" var="maincss" />
        <link rel="stylesheet" href="${ maincss }" type="text/css"/>
        <!--Favicon tags-->
	       <link rel="icon" type="image/png" href="/image/w.png">
        <!--End favicon tags-->
    </head>
    <body>
       <form>
          <div>
               <div  class="tete">
                   <a class="liencr" href="<c:url value='/login'/>">login</a>
				  					                        
                </div>
				<div class="body">
				   <p class="msg">bonjour </p>
				   <p class="msg1">creer votre compte </p>
				   <p class="msg1">C'est gratuit et le sera toujours.</p>
				  <a  class="lienc" href="<c:url value='/hello/create'/>">neuvau abonnee</a>
				 </div>
         </div>
       </form>
    </body>
</html>

