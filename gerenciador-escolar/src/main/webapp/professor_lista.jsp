<%-- 
    Document   : usuario_lista
    Created on : 05/05/2019, 11:13:30
    Author     : alberto.torres
--%>

<%@page import="br.projecao.ltpw.model.Aluno"%>
<%@page import="java.util.List"%>
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
         
    


        
        <div class="container">
            <div class="row">
   
                <div class="col text-right"> <a class="btn btn-sm" style="background-color: green; color: white" href="aluno_form.jsp" role="button">Novo Aluno</a> &nbsp;</div>
             </div>
  <h2>Professores</h2>
  <p>Lista de professores cadastrados no sistema</p>   
  
    <!--Mensagem de erro/sucesso--> 
     <c:if test = "${msg != null}">
        <div class="alert alert-success alert-dismissible">
          <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
          ${msg}
        </div>
      </c:if>
        <!--Mensagem de erro/sucesso--> 
     <c:if test = "${msg_erro != null}">
        <div class="alert alert-danger alert-dismissible">
          <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
          ${msg_erro}
        </div>
      </c:if>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Sobrenome</th>
        <th>Email</th>
        <th>Alterar/Remover</th>
      </tr>
    </thead>
    <tbody>
    

        
    <c:forEach items="${professorBean.aluno}" var="aluno">

   
      <tr>
        <td>${professor.pessoa.nome}</td>
        <td>${professor.pessoa.sobrenome}</td>
        <td>${professor.pessoa.email}</td>
        <td><a href="AlunoSvl?op=1&id=${professor.idProfessor}"><i class='far fa-edit' style='color:black'></i></a> &nbsp;  
            <a href="AlunoSvl?op=2&id=${professor.idProfessor}"><i class='fas fa-trash' style='color:black'></i></a> 
        
        </td>
         
      </tr>
    </c:forEach>
  
    </tbody>
  </table>
</div>
        
        
    </body>
</html>
