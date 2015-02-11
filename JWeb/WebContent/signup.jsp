<%@ include file="header.jsp" %>
	<form method="post" action="signup">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br />

                <label for="password">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

                <label for="name">Nom d'utilisateur</label>
                <input type="text" id="nom" name="name" value="" size="20" maxlength="20" />
                <br />
				<input type="checkbox" name="newsletter" id="letter" value="oui"/> <label for="letter">Souscrire à la newletter</label>
				<br />
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
        </form>
	<%@ include file="footer.jsp" %>
</body>
</html>