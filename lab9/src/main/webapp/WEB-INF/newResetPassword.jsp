<%-- 
    Document   : newResetPassword
    Created on : 10-Apr-2022, 1:23:46 PM
    Author     : Cole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p> Enter your new password below </p>
        
        <form action="reset" method="post">
            <input type="hidden" name="uuid" id="uuid" value="${uuid}">
            <label for="email">You are changing the password for: </label>
            <input type="text" name="email" id="email" value="${email}" readonly>
            <label for="password">New Password: </label>
            <input type="password" name="password" id="password" required>
            <button type="submit">Change Password</button> 
            
        </form>
    </body>
</html>