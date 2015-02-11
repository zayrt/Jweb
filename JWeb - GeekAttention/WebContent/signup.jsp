<%@ include file="header.jsp" %>
<div class="wrapper col1">
  <div id="featured_slide"> 
    <div id="slider">
    	<form method="post" action="signup">
            <fieldset>
                <legend>Inscription</legend>
                Vous pouvez vous inscrire via ce formulaire.

				<TABLE style="border-width:0px;">
				<tr>
	                <td width="200px"><label for="email">Adresse email *</label></td>
	                <td ><input type="text" id="email" name="email" value="" size="20" maxlength="60" /></td>
	                <br />
                </tr>
				
				<tr>
	                <td><label for="password">Mot de passe *</label></td>
	                <td><input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" /></td>
	                <br />
                </tr>

				<tr>
	               <td> <label for="confirmation">Confirmation du mot de passe *</label></td>
	                <td><input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" /></td>
	                <br />
                </tr>

				<tr>
	               	<td><label for="name">Nom d'utilisateur</label></td>
	                <td><input type="text" id="nom" name="name" value="" size="20" maxlength="20" /></td>
	                <br />
                </tr>
                
                </TABLE>
				<input type="checkbox" name="newsletter" id="letter" value="oui"/> <label for="letter">Souscrire à la newletter</label>
				<br /><br />
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
       	 </form>
		</div>
	</div>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>