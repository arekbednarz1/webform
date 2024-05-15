<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <form:form method="post" modelAttribute="adminFormModel" id="formCompany" >
            <div>
                <h1>Register</h1>
                <hr>
                <label for="name">Name:</label>
                <form:input path="name" type="text" name="name" id="name"/>
                <form:errors path="name" cssStyle="color: red"/>
                <br>
                <label for="surname">Surname:</label>
                <form:input path="surname" type="text" name="surname" id="surname"/>
                <form:errors path="surname" cssStyle="color: red"/>
                <br>
                <label for="email">Email:</label>
                <form:input path="email" type="text" name="email" id="email"/>
                <form:errors path="email" cssStyle="color: red"/>
                <br>
                <label for="password">Password:</label>
                <form:input path="password" type="text" name="password" id="password"/>
                <form:errors path="password" cssStyle="color: red"/>
                <br>
                <label for="passwordRepeat">Repeat password:</label>
                <form:input path="passwordRepeat" type="text" name="passwordRepeat" id="passwordRepeat"/>
                <form:errors path="passwordRepeat" cssStyle="color: red"/>

                <br>
                <form:button class="registerbtn" id="add">Add</form:button>
            </div>
            </form:form>
        </div>
</body>
