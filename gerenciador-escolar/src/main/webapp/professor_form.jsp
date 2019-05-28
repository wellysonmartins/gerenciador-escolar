<%-- 
    Document   : form_aluno
    Created on : 05/05/2019, 10:48:02
    Author     : alberto.torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="professorBean" class="br.projecao.ltpw.view.ProfessorBean" scope="session" />
 
 
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
   
                <div class="col text-right"> <a class="btn btn-sm" style="background-color: green; color: white" href="professor_lista.jsp" role="button">Listar Professores</a> &nbsp;</div>
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
        <p>&nbsp;&nbsp;&nbsp;Formulário de cadastro de novos professores no sistema</p> 
            </div>
        <form action="ProfessorSvl" method="post">
            
             <input type="hidden" class="form-control" id="id_professor" name="id_professor" value="${professor.idProfessor}">
          
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
                <label for="data_nascimento">Data de Nascimento</label>
                <input type="date" class="form-control" id="data_nascimento" name="data_nascimento" value="${professor.pessoa.dataNascimento}" required>
              </div>
              <div class="form-group col-md-6">
                <label for="genero">Gênero:</label>
                <select class="form-control" id="genero" name="genero" required>
                    <option selected>Selecione</option>
                    <c:forEach items="${professorBean.genero}" var="genero">
                        <option value="${genero.idGenero}" <c:if test = "${genero.idGenero == professor.pessoa.genero.idGenero}">selected</c:if>>${genero.descricao}</option>
                        
                    </c:forEach>
                  </select>
              </div>
            </div>
            
          
          <div class="form-row">
              <div class="form-group col-md-6">
                <label for="matricula">Matrícula</label>
                <input type="text" class="form-control" id="matricula" name="matricula" value="${professor.pessoa.matricula}" required>
              </div>
             <div class="form-group col-md-3">
                <label for="data_ingresso">Data de Ingresso</label>
                <input type="date" class="form-control" id="data_ingresso" name="data_ingresso"  value="${professor.pessoa.dataIngresso}" required>
              </div>

             <div class="form-group col-md-3">
                <label for="salario">Salário</label>
                <input type="text" class="form-control" id="salario" name="salario" value="${professor.salario}" required>
              </div>

            </div>   
 
            <div class="form-row">       
              <div class="form-group col-md-12">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${professor.pessoa.email}" required>
              </div>
            </div>
          
          
           <div class="form-row">
              <div class="form-group col-md-6">
                <label for="login">Login</label>
                <input type="text" class="form-control" id="login" name="login" value="${professor.pessoa.usuario}"  required>
              </div>
              <div class="form-group col-md-6">
                 <label for="pwd">Senha:</label>
                <input type="password" class="form-control" id="pwd" name="pwd" >
              </div>
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
