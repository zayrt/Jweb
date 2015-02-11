<%@ include file="header.jsp" %>

<div class="wrapper col1">
	<div class="news_content">
		 <p>	 
			  <c:forEach var="TheNews" items="${ TheNews }">
			  	<div class="admin">
	 				<span style="color:red;">
            			<c:out value="${ TheNews.auteur }" />
            		</span>
	 			</div>
	 			<div style="width:500px;margin:auto;">
		 			<span style="font-size:20px; margin:auto;">
	            		<c:out value="${ TheNews.message }" />
	            	</span>
            	</div>
            	<span style="color:green;">
            		<c:out value="${ TheNews.date }" />
            	</span>
       		 	<br/><br/><br/>
       		 </c:forEach>
		 </p>	 
	</div> 
</div>

<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
</body>
</html>