<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Donations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ecf0f1;
            color: #2c3e50;
        }
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #bdc3c7;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #2980b9;
            color: #ffffff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        a {
            color: #2980b9;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            color: #3498db;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">View Donations</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Donor ID</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Message</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${donations}" var="donation">
                <tr>
                    <td>${donation.id}</td>
                    <td>${donation.donorId}</td>
                    <td>${donation.amount}</td>
                    <td>${donation.donationDate}</td>
                    <td>${donation.donationMessage}</td>
                    <td><a href="/donations/detail/${donation.id}">View</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
