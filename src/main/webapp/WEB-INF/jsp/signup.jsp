<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Uber-Fight : SignUp</title>
    <link type="text/css" rel="stylesheet" href="/css/form.css" />
    <link type="text/css" rel="stylesheet" href="/css/basic.css" />
</head>
<body>
<header>
    <img src="/pictures/logo_site.jpg" alt="logo"/>
    <h1>Uber fight</h1>
    <img src="/pictures/logo_site.jpg" alt="logo"/>
</header>
<hr>
<nav>
    <ul>
        <li><a href="subscriber_area">Subscriber Area</a></li>
        <li><a href="signup">Sign up</a></li>
        <li><a href="homepage">Homepage</a></li>
        <li><a href="profilstartup">Profil of the startup</a></li>
        <li><a href="whatwedo">What we do ?</a></li>
        <li><a href="cpe">Colaboration/ Partener/ employee candidates</a></li>
    </ul>
</nav>
<div>
<form method="post" action="signup">
    <fieldset>
        <legend>Sign up</legend>
        <p>Create an account</p>

        <label for="login">Login</label>
        <input type="text" id="login" name="login" size="20" maxlength="20" required/>
        <span class="error">${error['login']}</span>
        <br />
        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="20" required/>
        <span class="error">${error['password']}</span>
        <br/>
        <input type="submit" value="SignUp" class="sansLabel" />
        <br/>
        <p class="${empty error ? 'success' : 'erreur'}">${result}</p>
    </fieldset>
</form>
</div>
<p>
    <em>Your security is our priority !</em><br><br><br>
    We have more than 50 million uber fighters spread all over the world, all there to ensure the safety of our customers.
</p><br><br><br>
<em>You can trust us !</em>
<footer>
    Contact us:<br><br>
    <a href="mailto:amine.bouhtout@gmail.com">Send email</a><br>
    Phone number: <strong>+33785293250</strong>
</footer>
</body>
</html>
