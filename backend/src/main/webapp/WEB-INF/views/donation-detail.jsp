<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donation Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ecf0f1;
            color: #2c3e50;
        }
        .details-container {
            width: 50%;
            margin: 50px auto;
            background: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #2980b9;
        }
        p {
            font-size: 16px;
            line-height: 1.5;
            margin-bottom: 10px;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            background-color: #2980b9;
            color: #ffffff;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
        }
        a:hover {
            background-color: #3498db;
        }
    </style>
</head>
<body>
    <div class="details-container">
        <h1>Donation Details</h1>
        <p><strong>ID:</strong> ${donation.id}</p>
        <p><strong>Donor ID:</strong> ${donation.donorId}</p>
        <p><strong>Amount:</strong> ${donation.amount}</p>
        <p><strong>Date:</strong> ${donation.donationDate}</p>
        <p><strong>Message:</strong> ${donation.donationMessage}</p>
        <a href="/donations/view">Back to Donations</a>
    </div>
</body>
</html>
