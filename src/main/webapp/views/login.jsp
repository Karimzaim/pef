<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <spring:url value="/resources/css/main.css" var="maincss" />
    <link rel="stylesheet" href="${ maincss }" type="text/css"/>
    <title>loginto Welcome </title>
   </head>
   
   <body>
   
	<f:form action="${pageContext.request.contextPath}/login"	modelAttribute="abonnee"  method="post">
		
		 <div>
             <div  class="tete">                     
                 <f:input class="inputs1" path="pseudo" placeholder="Pseudo"/>
                 <f:input type="password" class="inputs2" path="password"  placeholder="password"/>                       
                 <input class="blogin" type="submit" value="Login" name="Login" />
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                 
                 </div>
                 <div class="body">
				   <p class="msg">bonjour </p>
				   <p class="msg1">creer votre compte </p>
				   <p class="msg1">C'est gratuit et le sera toujours.</p>
				 </div>
					 
             </div>
		
	</f:form>
	<br>
					
	
</body>
</html>





















