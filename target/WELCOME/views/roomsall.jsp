<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   	 <spring:url value="/resources/css/homcss.css" var="welcss" />
    <link rel="stylesheet" href="${ welcss }" type="text/css"/>
     
	 
    <!-- Favicon -->
    <link rel="shortcut icon" sizes="16x16 24x24 32x32 48x48 64x64" type="image/png"
        href="https://www.seoclerk.com/pics/643219-1IdkTg1543520708.png" />
    <!-- Favicon -->

    <!-- Bootstrap StyleSheet -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Bootstrap StyleSheet -->
    <!-- Awesome font -->
    <link rel="stylesheet" href="stylesheet/awesomefont/all.css">
    <script src="javascript/awesomefont/all.js"></script>
    <!-- Awesome font -->
    <style>
        body {
            padding-top: 2rem;
        }

        #buttonAdd {
            cursor: pointer;
        }
    </style>
    
   

<title>Welcome</title>
</head>
<body>

	<div id="bandeau">
		<p>
<a href="<c:url value='/welcome'/>" id="home">Home</a> <c:if test="${!empty abonne}">	 <label for="roomLabel" id="name1"><c:out value="${abonne.nom}"></c:out></label> <label for="roomLabel" id="name2"><c:out value="${abonne.prenom}"></c:out></label> </c:if>
		</p>

   
	</div >

	<div id="menu">
	  <h2 style="color:#008080; font-variant: normal; font-weight:900">Rooms</h2>
		<ul>
		<c:if test="${!empty roomse}">
		   <c:forEach items="${roomse}"  var="rms">
						   
			<li> <a class="lienrom" href="<c:url value='/hello/visiter/${rms.id_room}'/>">${rms.nomproduit_service}</a></li>
		  </c:forEach>
		</c:if>


		</ul>
	</div>
	
	<div id="contenu">
		<div id="contenu-lift">
		
			<main>
                <h2 style="color:#008080; font-variant: normal; font-weight:900">Echange</h2>
                  <c:if test="${!empty echangese}">
					<c:forEach items="${echangese}" var="echgs">
                
					<div class="row rounded border p-4">
                        <div class="col-md-8">
                                                    
                                                      	
                                <div class="row">
                                    <div style="margin-bottom:0px; padding-bottom :0px;" class="col-md-7">
                                        <p><label for="roomLabele"><b><c:out value="${echgs.room.nomproduit_service}"></c:out></b></label>  <label style="color:#808080; font-size:10px;"><b><c:out value="${echgs.dateHeur_msg }"></c:out></b></label></p>
                                        
                                    </div>
									<div class="col-md-7">
                                        <label for="roomLabele"><b><c:out value="${abonne.nom}"></c:out><c:out value="${abonne.prenom}"></c:out></b></label>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-md-10">
                                        <label for="contentMsg"><b>Contenue (<em>MSG</em>)</b></label>
                                        <p id="contentMsgControlTextarea" required><c:out value="${echgs.contenu}"></c:out></p>
                                    </div>
                                </div>
                                <br>
                                
                        </div>
                    </div>
                     </c:forEach>
               </c:if>
                              
               	<div class="row rounded border p-4">
                        <div class="col-md-8">
                            <f:form action="${pageContext.request.contextPath}/hello/adddechange/${idroom}"  modelAttribute="echanges">               	
                               
                           <f:input type="hidden" path="room"  value="${rm}" />
                           <f:input type="hidden" path="abonnee"  value="${abonne}" />
                                <div class="row">
                                    <div class="col-md-10">
                                        <label class="label"><b>Contenue (<em>MSG</em>)</b></label>
                                        <f:textarea path = "contenu" rows = "5" cols = "30" class="textarea"/>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-md-10" style="text-align: right">
                                        
                                        <button type="submit" class="btn btn-success" id="buttonAdd">
                                            <i class="fas fa-plus"></i>&nbsp;New Contenue
                                        </button>
                                    </div>
                                </div>
                              
                            </f:form>
                        </div>
                    </div>
                           
               
            </main>
			</div>
		
		
			<div id="contenu-right">
			<div >
                <div class="rounded border p-3">
                    <form>
                    <c:if test="${!empty abonne}">
                        <div class="form-group">
                           <label><h2 style="color:#008080;font-style: italic; font-weight:600; font-size=10px"><c:out value="${abonne.pseudo}"></c:out></h2></label>
                                                    
                        </div>
                        <div class="form-group">
                            <label for="whatsApp"><small><b><c:out value="${abonne.whatsapp}"></c:out></b></small></label>
                            
                        </div>
                        <div class="form-group">
                            <label for="birthDay"><small><b><c:out value="${abonne.datenaissance}"></c:out></b></small></label>
                            
                        </div>
                       
                        <div class="form-group">
                            <label for="pofission"><small><b><c:out value="${abonne.getProfession().getProfession()}"></c:out></b></small></label>
                            
                        </div>
                        <div class="form-group">
                            <label for="street"><small><b><c:out value="${abonne.getQuartier().getQuartier()}"></c:out></b></b></small></label>
                            
                        </div>
						 <div class="form-group">
                            <a for="street" href="#">modifier</a>                         
                        </div>
                       </c:if> 
                    </form>
                </div>
			</div>
		
		</div>
	</div>


</body>
</html>