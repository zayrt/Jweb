<%@ include file="header.jsp" %>
	<form method="post" action="signin">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br />

                <label for="password">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
	<%@ include file="footer.jsp" %>
</body>
</html>