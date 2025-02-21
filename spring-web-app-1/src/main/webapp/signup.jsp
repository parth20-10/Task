<html>
<head><title>Sign Up</title></head>
<body>
    <h1>Register for Netbanking</h1>
    <form action="/register" method="post">
        Customer ID: <input type="text" name="customerId" required><br>
        Name: <input type="text" name="name" required><br>
        Password: <input type="password" name="password" required><br>
        Confirm Password: <input type="password" name="confirmPassword" required><br>
        <button type="submit">Register</button>
    </form>
    <p style="color:red;">${error}</p>
</body>
</html>
