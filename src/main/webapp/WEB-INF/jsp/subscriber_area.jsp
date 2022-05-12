<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Uber-Fight : Subscriber Area</title>
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
<h1>Welcome in your subscriber area ${user.login}</h1>
<p>In this area you can perform action such as change your password or delete your account</p>
<form method="post" action="changepassword">
    <fieldset>
        <legend>Change your password</legend>
        <label for="oldPassword">Old password</label>
        <input type="password" id="oldPassword" name="oldPassword" size="20" maxlength="60" required/>
        <br />

        <label for="newPassword">New password</label>
        <input type="password" id="newPassword" name="newPassword" value="" size="20" maxlength="20" required/>
        <p><span class="error">${changePassword['error']}</span><span class="success">${changePassword['success']}</span></p>

        <input type="submit" value="Change your password" class="sansLabel" />
    </fieldset>
</form>
<form method="get" action="logout">
    <input type="submit" value="Logout" id="logout"/>
</form>
<form method="get" action="delete">
    <p>If you want to delete your account click on the button below, but be aware that your account will be permanently deleted</p>
    <input type="submit" value="Delete my account" id="delete"/>
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

