<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrarse</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Registro de Usuario</h1>
        <form action="register" method="post">
            <label for="fullname">Nombre Completo:</label>
            <input type="text" id="fullname" name="fullname" required><br>
            <label for="age">Edad:</label>
            <input type="number" id="age" name="age" required><br>
            <label for="sex">Sexo:</label>
            <select id="sex" name="sex" required>
                <option value="M">Masculino</option>
                <option value="F">Femenino</option>
            </select><br>
            <label for="height">Estatura (m):</label>
            <input type="number" step="0.01" id="height" name="height" required><br>
            <label for="username">Nombre de Usuario:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">Registrarse</button>
        </form>
    </div>
</body>
</html>
