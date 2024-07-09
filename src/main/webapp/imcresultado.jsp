<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>IMC</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Calcula tu IMC</h1>

        <div class="content">
            <form action="imcresultado" method="post">
                <label for="weight">Ingresa tu peso (kg):</label>
                <input type="number" step="0.1" id="weight" name="weight" required><br>
                <button type="submit">Calcular</button>
            </form>
            
            <div class="user-info">
                <h2>Datos del Usuario</h2>
                <p>Nombre completo: ${fullname}</p>
                <p>Edad: ${age}</p>
                <p>Sexo: ${sex}</p>
                <p>Estatura: ${height} m</p>
                <p>IMC: ${imc}</p>
            </div>
            
            <div class="imc-results">
                <h2>Historial de IMC</h2>
                <table>
                    <tr>
                        <th>IMC</th>
                        <th>Fecha</th>
                    </tr>
                    <tr>
                <td>${entry.imc}</td>
                <td>${entry.imcDate}</td>
            </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
