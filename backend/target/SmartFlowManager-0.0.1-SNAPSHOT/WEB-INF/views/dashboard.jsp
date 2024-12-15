<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
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
        .dashboard-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        .dashboard-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .dashboard-container p {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h2>Welcome to Your Dashboard</h2>
        <p>Hello, ${user.username}!</p>
        <p>Your email: ${user.email}</p>
        <p>Your role: ${user.role}</p>
        <a href="/logout">Logout</a>
    </div>
</body>
</html>
