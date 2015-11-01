<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<t:genericpage>
	<jsp:body>
 <section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
               	 <h1>Autentique para ter acesso ao sistema</h1>
                    <form autocomplete="off" id="login-form" method="post" action="${contextPath}/login" role="form">
                        <div class="form-group">
                            <label class="sr-only" for="email">Email</label>
                            <input placeholder="Login"  class="form-control" id="email" name="username">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="key">Password</label>
                            <input type="password" placeholder="Senha" class="form-control" id="key" name="password">
                        </div>
                        <div class="checkbox">
                            <span onclick="showPassword()" class="character-checkbox"></span>
                            <span class="label">Mostrar senha</span>
                        </div>
                        <input type="submit" value="Entrar" class="btn btn-custom btn-lg btn-block" id="btn-login">
                    </form>
                    <hr>
        	    </div>
    		</div> <!-- /.col-xs-12 -->
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>
    </jsp:body>
</t:genericpage>