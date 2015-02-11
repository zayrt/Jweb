<%@ include file="../header.jsp" %>

<div class="wrapper col1">
  <div id="featured_slide">
	<h3><strong>Interface Administrateur</strong></h3>
	  <form method="post" action="controle_news">
	            <fieldset>
	                <legend>Rédaction des News</legend>
	                <p>Ici, vous pouvez rédiger la prochaine nouveauté.</p>

	                <textarea name="news" cols="50" rows="7"> </textarea>
	                <br /><br />
	
	
	                <input type="submit" value="Envoyer" style="margin-left:120px;"/>
	                <br />
	            </fieldset>
	   </form>
		
	   <span style="float:right; margin-top:-180px">
	  		<form method="post" action="controle_ban">
	            <fieldset>
	                <legend>Gestion des membres</legend>
	                <p>Entrez le nom de l'utilisateur à bannir</p>
					<input type="text" name="acc"/>
	
	                <input type="submit" value="Bannir" style="margin-left:120px;"/>
	                <br />
	            </fieldset>
	  		</form>
	   </span>
	</div>
</div>

<%@ include file="../footer.jsp" %>

</body>
</html>