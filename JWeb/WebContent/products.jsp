<%@ include file="header.jsp" %>


<!-- ####################################################################################################### -->
<div class="wrapper col2">
  <div id="container" class="clear"> 
    <!-- ####################################################################################################### -->
    <div id="portfolio">
      <div class="portfoliocontainer clear">
        <div class="fl_left">
          <h2>Les produits Geek</h2>
          <p>Liste des produits de GeekAttention</p>
        </div>
        
        
        <div class="fl_right">
          <ul>
	          <c:forEach var="products" items="${ products }">
	          	<li><img height="150px" width="150px"src="<c:out value="${ products.image	}"/>" alt="<c:out value="${ products.image	}"/>" />
	              <p class="name"><c:out value="${ products.nom	}"/>	<c:out value="${ products.prix }"/></p>
	              <p class="readmore"><a href="reviews?prod=${ products.id }"><c:out value="${ products.description }"/></a></p>
	            </li>
	          </c:forEach>
          </ul>
        </div>
        
                    
      </div>
    </div>

  </div>
</div> -->
<!-- ####################################################################################################### -->
<%@ include file="footer.jsp" %>
</body>
</html>