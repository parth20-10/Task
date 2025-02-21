<html>
<head><title>Netbanking Login</title></head>
<body>
    <h1>Login to Netbanking</h1>
    <form action="/login" method="post">
        Customer ID: <input type="text" name="customerId" required><br>
        Password: <input type="password" name="password" required><br>
        <button type="submit">Login</button>
    </form>
    <p style="color:red;">${error}</p>
    <p>Not registered? <a href="/signup">Sign Up</a></p>
</body>
</html>
