<%@ include file="header.jsp" %>
<div class="wrapper col1">
  <div id="featured_slide"> 
    <div id="slider">	
	<form method="post" action="signin">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
				<TABLE style="border-width:0px;">
				
				<tr>
	                <<td width="200px"><label for="email">Adresse email <span class="requis">*</span></label></td>
	                <td><input type="text" id="email" name="email" value="" size="20" maxlength="60" /></td>
	                <br />
                </tr>
                
				<tr>
	                <td><label for="password">Mot de passe <span class="requis">*</span></label></td>
	                <td><input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" /></td>
	                <br />
				</tr>
				</TABLE>
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
		</div>
	</div>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>