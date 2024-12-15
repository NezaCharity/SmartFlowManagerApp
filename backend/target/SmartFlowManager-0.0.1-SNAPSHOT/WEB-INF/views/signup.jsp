<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="/css/styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .signup-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #2980b9;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #3498db;
        }
        .error-message {
            color: red;
            text-align: center;
        }
        .success-message {
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h2>Sign Up</h2>
        <form action="/signup" method="POST">
            <!-- Username -->
            <div class="form-group">
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <!-- Password -->
            <div class="form-group">
                <input type="password" name="password" placeholder="Password" required>
            </div>
            <!-- Email -->
            <div class="form-group">
                <input type="email" name="email" placeholder="Email" required>
            </div>
            <!-- First Name -->
            <div class="form-group">
                <input type="text" name="first_name" placeholder="First Name">
            </div>
            <!-- Last Name -->
            <div class="form-group">
                <input type="text" name="last_name" placeholder="Last Name">
            </div>
            <!-- Phone -->
            <div class="form-group">
                <input type="text" name="phone" placeholder="Phone Number">
            </div>
            <!-- Role -->
            <div class="form-group">
                <select name="role_id" required>
                    <option value="" disabled selected>Select Role</option>
                    <option value="1">Admin</option>
                    <option value="2">User</option>
                </select>
            </div>
            <!-- Submit -->
            <div class="form-group">
                <button type="submit">Sign Up</button>
            </div>
            <!-- Error/Success Messages -->
            <c:if test="${not empty errorMessage}">
                <div class="error-message">
                    ${errorMessage}
                </div>
            </c:if>
            <c:if test="${not empty successMessage}">
                <div class="success-message">
                    ${successMessage}
                </div>
            </c:if>
        </form>
    </div>
</body>
</html>
