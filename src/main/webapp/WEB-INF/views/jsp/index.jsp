<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Democratic Restaurant</title>

<spring:url value="/resources/core/css/core.css" var="coreCss" />
<spring:url value="/resources/core/libs/bootstrap/dist/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<div class="container">
    <div class="col-md-4"></div>

    <div class="col-md-4">
         <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <span class="glyphicon glyphicon-arrow-right"></span>Em qual restaurante você deseja ir hoje?
                    </h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios">
                                    Good
                                </label>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios">
                                    Excellent
                                </label>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios">
                                    Bed
                                </label>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios">
                                    Can Be Improved
                                </label>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios">
                                    No Comment
                                </label>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="panel-footer">
                    <button type="button" class="btn btn-primary btn-sm">
                        Vote</button>
                    <a href="#">View Result</a></div>
            </div>
    </div>
</div>

<spring:url value="/resources/core/js/core.js" var="coreJs" />
<spring:url value="/resources/core/libs/jquery/dist/jquery.min.js" var="jquery" />
<spring:url value="/resources/core/libs/bootstrap/dist/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/libs/angular/angular.min.js" var="angularJs" />


<script src="${coreJs}"></script>
<script src="${jquery}"></script>
<script src="${bootstrapJs}"></script>
<script src="${angularJs}"></script>

</body>
</html>