<%@ include file="header.jsp" %>

<!-- ####################################################################################################### -->
	<div class="wrapper col2">
  		<div id="container" class="clear"> 
    		<div id="portfolio" style="width: 35%;margin: auto;">
				<img height="150px" width="150px"src="<c:out value="${ product.image	}"/>" alt="<c:out value="${ product.image	}"/>" />
				<p><span style="color:black;font-weight:bold;"><c:out value="${ product.nom	}"/></span>	<span style="color:red;"><c:out value="${ product.prix }"/> euro</span></p>
				<p><c:out value="${ product.description }"/></p>
				<c:forEach items="${ product.reviews }" var="review" varStatus="boucle">
					<p><br />
						<span style="color:brown;">
							${ review.name }<br />
						</span>
						<span style="margin-left: 1em;">
							${ review.review }</p>
						</span>
				</c:forEach>
			</div>
			<c:if test="${sessionScope.id != null}">
			<div style="width: 50%;">
			<form method="post" action="reviews?prod=${ product.id }">
				<fieldset>
                	<h2>Review</h2>
                	<p>Donnez votre avis sur nos produits !</p>

                	<label for="review">Votre avis <span class="requis">*</span></label>
                	<textarea id="rewiew" name="review" value="" rows="15" cols="80" ></textarea>
                	<br />

                	<input type="submit" value="Envoyer" class="sansLabel" />
            	</fieldset>
        	</form>
        	</c:if>
        	</div>
		</div>
	</div>
<!-- ####################################################################################################### -->

<%@ include file="footer.jsp" %>
</body>
</html>