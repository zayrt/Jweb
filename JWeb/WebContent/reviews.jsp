<%@ include file="header.jsp" %>

<!-- ####################################################################################################### -->
	<div class="wrapper col2">
  		<div id="container" class="clear"> 
    		<div id="portfolio" style="width: 20%;">
				<img height="150px" width="150px"src="<c:out value="${ product.image	}"/>" alt="<c:out value="${ product.image	}"/>" />
				<p class="name"><c:out value="${ product.nom	}"/>	<c:out value="${ product.prix }"/></p>
				<p class="readmore"><c:out value="${ product.description }"/></p>
				<c:forEach items="${ product.reviews }" var="review" varStatus="boucle">
					<p>${ review.name }[${ review.date }]: ${ review.review }</p>	
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