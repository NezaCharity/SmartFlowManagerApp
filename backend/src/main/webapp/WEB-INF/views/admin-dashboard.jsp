<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <header>
        <h1>Admin Dashboard</h1>
        <nav>
            <a href="/admin/manage-users">Manage Users</a> |
            <a href="/admin/donations">View Donations</a> |
            <a href="/logout">Logout</a>
        </nav>
    </header>
    <main>
        <h2>Welcome, Admin!</h2>
        <p>Use the navigation links above to manage the system.</p>
    </main>
</body>
</html>
