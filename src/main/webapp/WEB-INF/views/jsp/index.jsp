<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Democratic Restaurant</title>
	<base href="/">
	<spring:url value="/resources/core/css/core.css" var="coreCss" />
	<spring:url value="/resources/core/libs/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
	
</head>

<body ng-app="restaurant" ng-controller="MainController"> 
	<div class="container">
		<div class="alert {{messageClass}}" role="alert">{{globalMessage}}</div>
		<div ng-view></div>
	</div>
</body>

<spring:url value="/resources/core/js/core.js" var="coreJs" />
<spring:url value="/resources/core/libs/jquery/dist/jquery.min.js" var="jquery" />
<spring:url value="/resources/core/libs/bootstrap/dist/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/libs/angular/angular.min.js" var="angularJs" />
<spring:url value="/resources/core/libs/angular-route/angular-route.min.js" var="angularRoute" />
<spring:url value="/resources/core/js/app.js" var="appJs" />
<spring:url value="/resources/core/js/appRoutes.js" var="appRoutes" />
<spring:url value="/resources/core/js/controllers/MainCtrl.js" var="mainCtrl" />
<spring:url value="/resources/core/js/controllers/ResultCtrl.js" var="resultCtrl" />


<script src="${coreJs}"></script>
<script src="${jquery}"></script>
<script src="${bootstrapJs}"></script>
<script src="${angularJs}"></script>
<script src="${angularRoute}"></script>
<script src="${appRoutes}"></script>
<script src="${mainCtrl}"></script>
<script src="${resultCtrl}"></script>
<script src="${appJs}"></script>

</body>
</html>