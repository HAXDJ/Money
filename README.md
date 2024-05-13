<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversor de Divisas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        h2 {
            color: #666;
        }
        ul {
            list-style-type: square;
            margin-left: 20px;
        }
        pre {
            background-color: #f4f4f4;
            padding: 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Conversor de Divisas</h1>
        
        <p>Este proyecto es un simple conversor de divisas que utiliza la API de ExchangeRate-API para obtener las tasas de cambio en tiempo real y realizar conversiones entre diferentes monedas.</p>

        <h2>Funcionalidades</h2>
        <ul>
            <li>Solicita al usuario la divisa que quiere convertir.</li>
            <li>Permite al usuario ingresar la cantidad a convertir.</li>
            <li>Pregunta al usuario a qué divisa desea convertir la cantidad ingresada.</li>
            <li>Realiza la conversión utilizando las tasas de cambio obtenidas de ExchangeRate-API.</li>
            <li>Muestra el resultado de la conversión.</li>
            <li>Pregunta al usuario si desea realizar otra conversión.</li>
        </ul>

        <h2>Cómo usar</h2>
        <ol>
            <li>Clona este repositorio en tu máquina local.</li>
            <li>Abre el proyecto en tu entorno de desarrollo preferido.</li>
            <li>Ejecuta el archivo <code>Converter.java</code>.</li>
            <li>Sigue las instrucciones que aparecen en la consola para realizar conversiones de divisas.</li>
        </ol>

        <h2>Requisitos</h2>
        <ul>
            <li>Java 11 o superior.</li>
            <li>Acceso a Internet para obtener las tasas de cambio de ExchangeRate-API.</li>
        </ul>

        <h2>Créditos</h2>
        <p>Este proyecto utiliza la biblioteca Gson para analizar la respuesta JSON de la API de ExchangeRate-API.</p>

        <h2>Contribuciones</h2>
        <p>Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor crea un fork del repositorio, realiza tus cambios y envía un pull request.</p>

        <h2>Licencia</h2>
        <p>Este proyecto está bajo la licencia <a href="LICENSE">MIT</a>.</p>
    </div>
</body>
</html>
