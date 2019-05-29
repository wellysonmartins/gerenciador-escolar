<%-- 
    Document   : form_aluno
    Created on : 05/05/2019, 10:48:02
    Author     : alberto.torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="turmaBean" class="br.projecao.ltpw.view.TurmaBean" scope="session" />
 
 
<!DOCTYPE html>
<html>
    <head>

         <jsp:include page = "head.jsp" />
        
    </head>
    <body>
        <jsp:include page="topo.jsp"/>
          
         
   

        
    
    <div class="container my-4">
        
       
        
        
          <div class="container">
            <div class="row">
   
                <div class="col text-right"> <a class="btn btn-sm" style="background-color: green; color: white" href="turma_lista.jsp" role="button">Listar Turmas</a> &nbsp;</div>
                <br>
            </div>
              
            <div class="form-row">
                
     <!--Mensagem de erro/sucesso--> 
     <c:if test = "${msg != null}">
        <div class="alert alert-success alert-dismissible">
          <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
          ${msg}
        </div>
      </c:if>
  
                
                
        <h2>&nbsp;Cadastro de Turma</h2>
        <p>&nbsp;&nbsp;&nbsp;Formulário de cadastro de novas turmas no sistema</p> 
            </div>
                
        
        
    </div>
        
        
        
        
        
    </body>
</html>
