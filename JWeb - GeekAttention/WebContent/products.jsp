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
	          	<li><a href="reviews?prod=${ products.id }"><img height="150px" width="150px"src="<c:out value="${ products.image	}"/>" alt="<c:out value="${ products.image	}"/>" />
	              <p class="name"><span style="color:black;"><c:out value="${ products.nom	}"/></span>	<span style="color:red;"><c:out value="${ products.prix }"/> euros</span></p>
	              <p><c:out value="${ products.description }"/></a></p>
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