<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     
    <title>Abonnees</title>
    
    <!-- Bootstrap StyleSheet -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Bootstrap StyleSheet -->

    <!-- External ressources -->
    <link rel="stylesheet" href="stylesheet/global.css">
    <script src="/resources/javascript/validateWhatsAppField.js"></script>
    <!-- External ressources -->

   
   </head>
   
   <body>
   
   
     
	<f:form action="${pageContext.request.contextPath}/hello/inscrier"	modelAttribute="abonnee" method="post">	
          	
	<div class="body">
                 <div class="row">
                    <p>  <h1 class="text-primary">Iscrier vous chez nous ...</h1>
                </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="FirstName">Nom <sup class="requiredSymbole" style="color: red;">*</sup></label>
                            <f:input type="text" path="nom" class="form-control form-control-sm"  placeholder="nom" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="LastName">Prenom <sup class="requiredSymbole" style="color: red;">*</sup></label>
                            <f:input type="text" path="prenom" class="form-control form-control-sm" placeholder="Last name" />
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="Pseudo">Pseudo <sup class="requiredSymbole" style="color: red;">*</sup></label>
                            <f:input type="text" path="pseudo" class="form-control form-control-sm" placeholder="Pseudo" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="PseudoID">Mot de passe <sup class="requiredSymbole" style="color: red;">*</sup></label>
                            <f:input type="password" path="password" class="form-control form-control-sm" placeholder="password" />
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            
                            <label for="Birthday">Date naissance<sup class="requiredSymbole" style="color: red;">*</sup></label>
                            <f:input path="datenaissance" type="date"  class="form-control form-control-sm"  />
                             
                        </div>
                       <div class="form-group col-md-6">
                            <label for="Birthday">sexe<sup class="requiredSymbole" style="color: red;">*</sup></label>
                            <f:select path="sexe"   class="form-control form-control-sm">      

                                      <f:option  value="homme" >Homme</f:option>
                                      <f:option  value="femme" >Femme</f:option>
                                   
                              </f:select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="LastWhatsApp">WhatsApp</label>
                            <f:input type="tel" path="whatsapp" class="form-control form-control-sm"  placeholder="+212 6 XX XX XX XX" pattern="(\+212|0)(|6|5)([ \-_/]*)(\d[ \-_/]*){9}" />
                        </div>
                    </div>
                    
                   <div class="form-row">
                        <div class="form-group col-md-12">                           
                            <label >Profession <sup class="requiredSymbole" style="color: red;">*</sup></label>      
                                                  
                             <c:if test="${!empty professions}">
                              <f:select path="profession"   class="form-control form-control-sm">      
                                                                                      
                                   <c:forEach  items="${professions}"  var="prf">
                                      <f:option  value="${prf.profession}" >${prf.profession}</f:option>
                                      
                                   </c:forEach>
                                   
                              </f:select>
                            </c:if>
                            
                        </div>
                    </div>
                    
                      <div class="form-row">
                        <div class="form-group col-md-12">                           
                            <label >Quartiers <sup class="requiredSymbole" style="color: red;">*</sup></label>      
                                                  
                             <c:if test="${!empty quartiers}">
                              <f:select path="quartier"   class="form-control form-control-sm">      
                                                                                      
                                   <c:forEach  items="${quartiers}"  var="qrt">
                                      <f:option  value="${qrt}" >${qrt.quartier}</f:option> 
                                   </c:forEach>
                                   
                              </f:select>
                            </c:if>
                            
                        </div>
                    </div> 
                    
                    <div class="form-row">
                        <label for="Description">(<span class="requiredSymbole">*</span>): <small> <b>Required field.</b></small></label>
                    </div>
                    <div class="form-row">
                        <div class="col-md2">
                        
                            <input type="submit" value="inscrier" class="form-control btn btn-primary btn-sm" >
                            
                        </div>
                    </div>

         
    </div>
		</f:form>
</body>
</html>
