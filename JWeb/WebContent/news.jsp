<%@ include file="header.jsp" %>

<!-- MODIFIER LE CODE POUR LE RENDRE DYNAMIQUE EN JAVA -->
<!-- MODIFIER LE CODE POUR LE RENDRE DYNAMIQUE EN JAVA -->
<!-- MODIFIER LE CODE POUR LE RENDRE DYNAMIQUE EN JAVA -->


<div class="wrapper col1">
	<div class="news_content">
		 <p>	 
			  <c:forEach var="TheNews" items="${ TheNews }">
			  	<div class="admin">
	 				
	 			</div>
	 			<br/>
	 			<span style="font-size:20px;">
            		<c:out value="${ TheNews.message }" />
            	</span>
            	<span style="color:green;">
            		<c:out value="${ TheNews.date }" />
            	</span>
       		 	<br/><br/><br/>
       		 </c:forEach>
		 </p>	 
	</div> 
</div>



<!-- MODIFIER LE CODE POUR LE RENDRE DYNAMIQUE EN JAVA -->
<!-- MODIFIER LE CODE POUR LE RENDRE DYNAMIQUE EN JAVA -->
<!-- MODIFIER LE CODE POUR LE RENDRE DYNAMIQUE EN JAVA -->


<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
</body>
</html>