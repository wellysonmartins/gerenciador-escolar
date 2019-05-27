<%-- 
    Document   : form_aluno
    Created on : 05/05/2019, 10:48:02
    Author     : alberto.torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="alunoBean" class="br.projecao.ltpw.view.AlunoBean" scope="session" />
 
 
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
   
                <div class="col text-right"> <a class="btn btn-sm" style="background-color: green; color: white" href="aluno_lista.jsp" role="button">Listar Alunos</a> &nbsp;</div>
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
  
                
                
        <h2>&nbsp;Cadastro de Professor</h2>
        <p>&nbsp;&nbsp;&nbsp;Formulário de cadastro de novos alunos no sistema</p> 
            </div>
        <form action="AlunoSvl" method="post">
            
             <input type="hidden" class="form-control" id="id_professor" name="id_aluno" value="${professor.idProfessor}">
          
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" id="nome" name="nome" value="${professor.pessoa.nome}" required>
              </div>
              <div class="form-group col-md-6">
                <label for="sobrenome">Sobrenome</label>
                <input type="text" class="form-control" id="sobrenome" name="sobrenome" value = "${professor.pessoa.sobrenome}" required>
              </div>
            </div>
            
            
          
          <div class="form-row">
              <div class="form-group col-md-6">
                <label for="matricula">Salário</label>
                <input type="text" class="form-control" id="matricula" name="matricula" value="${professor.pessoa.matricula}" required>
              </div>
          
 
          
          
          <div class="form-row">       
                          <div class="form-group col-md-12">
                         <button type="submit" class="btn btn-default">Submit</button>
              </div>
            </div>
            
            
    

       </form>
        
        
        
    </div>
        
        
        
        
        
    </body>
</html>
