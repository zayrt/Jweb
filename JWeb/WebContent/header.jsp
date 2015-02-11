<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GeekAttention</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script type="text/javascript" src="layout/scripts/jquery.min.js"></script>
<!-- tabs -->
<script type="text/javascript" src="layout/scripts/jquery.ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $("#tabcontainer").tabs({
        event: "click"
    });
});
</script>
<!-- / tabs -->
<script type="text/javascript" src="layout/scripts/jquery-photostack.js"></script>
<!-- coinslider -->
<script type="text/javascript" src="layout/scripts/jquery-coin-slider.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $('#portfolioslider').coinslider({
        width: 480,
        height: 280,
        navigation: false,
        links: false,
        hoverPause: true
    });
});
</script>
<!-- / coinslider -->
</head>
<body id="top">
<div class="wrapper col1">
  <div id="header" class="clear">
    <div class="fl_left">
      <h1><a href="index.jsp">GeekAttention</a></h1>
      <p>Site de vente pour les Geekounets</p>
    </div>
  </div>
</div>

<!-- ####################################################################################################### -->

<div class="wrapper col1">
  <div id="topbar" class="clear">
    <ul id="topnav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="controle_news">News</a></li>
	  <c:choose>
		<c:when test="${sessionScope.email == null}">
      	<li><a href="signup">S'enregistrer</a></li>
      	<li><a href="signin">Se connecter</a></li>
      	</c:when>
      	<c:otherwise>
      	<li><a href="signout">Se deconnecter</a></li>
      	<li style="color: red;">Bonjour <c:out value="${sessionScope.name}"/> !</li>
      	</c:otherwise>
      </c:choose>
    </ul>
    <form action="#" method="post" id="search">
      <fieldset>
        <legend>Site Search</legend>
        <input type="text" value="Search Our Website&hellip;" onfocus="this.value=(this.value=='Search Our Website&hellip;')? '' : this.value ;" />
        <input type="image" id="go" src="layout/images/search.gif" alt="Search" />
      </fieldset>
    </form>
  </div>
</div>
<c:forEach items="${ messages }" var="message" varStatus="boucle">
		<p>${ boucle.count }. ${ message }</p>
</c:forEach>