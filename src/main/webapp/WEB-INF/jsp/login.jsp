<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

    <link href="../../resources/css/register.css" rel="stylesheet" type="text/css">

</head>

<body>
    <div class="container">
        <form method="post" >
            <h1>Login</h1>
            <hr>

            <input type="text" id="username" id="email" name="username" placeholder="email"/>
            <hr>

            <input type="password" id="password" name="password" placeholder="password"/>
            <hr>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="registerbtn" type="submit">login</button>
        </form>
    </div>
</body>