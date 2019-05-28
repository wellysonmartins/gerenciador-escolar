<%-- 
    Document   : form_aluno
    Created on : 05/05/2019, 10:48:02
    Author     : alberto.torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
<!DOCTYPE html>
<html>
    <head>

         <jsp:include page = "head.jsp" />
        
    </head>
    <body>
        <jsp:include page="topo.jsp"/>
          
         
   

        
    
    <div class="container my-4">
        
       
        
        
          <div class="container">
            
              
            <div class="form-row">
                
     <!--Mensagem de erro/sucesso--> 
     <c:if test = "${msg != null}">
        <div class="alert alert-success alert-dismissible">
          <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
          ${msg}
        </div>
      </c:if>
  
                
                
        <h2>&nbsp;Bem-vindo!!!</h2>
        
            </div>
              
        
        
    </div>
        
        
        
        
        
    </body>
</html>
