<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="styles.css"> <!-- Your CSS file -->
</head>
<body>
    <div class="container">
        <h2>Forgot Your Password?</h2>
        <p>Please enter your email address to receive a password reset link.</p>
        
        <form action="forgot-password" method="POST">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required="required" placeholder="Enter your email address">
            </div>
            <button type="submit">Send Reset Link</button>
        </form>
        
        <c:if test="${not empty errorMessage}">
            <div class="error">
                ${errorMessage}
            </div>
        </c:if>
    </div>
</body>
</html>
