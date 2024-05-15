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
<form:form method="post" modelAttribute="companyFormModel" id="formCompany" >
    <div>
        <h1>Register</h1>
        <hr>
        <label for="companyName">Company Name:</label>
        <form:input path="companyName" type="text" name="name" id="companyName"/>
        <form:errors path="companyName" cssStyle="color: red"/>
        <hr>
        <h2>Company owner</h2>
        <hr>

        <label for="companyOwnerName">Owner Name:</label>
        <form:input path="companyOwnerName" type="text" name="companyOwnerName" id="companyOwnerName"/>
        <form:errors path="companyOwnerName" cssStyle="color: red"/>
        <br/>
        <label for="companyOwnerSurname">Owner surname:</label>
        <form:input path="companyOwnerSurname" type="text"  name="companyOwnerSurname" id="companyOwnerSurname"/>
        <form:errors path="companyOwnerSurname" cssStyle="color: red"/>
        <br/>
        <label for="companyOwnerEmail">Owner email:</label>
        <form:input path="companyOwnerEmail" type="text"  name="companyOwnerEmail" id="companyOwnerEmail"/>
        <form:errors path="companyOwnerEmail" cssStyle="color: red"/>
        <hr>
        <h2>Company address</h2>
        <hr>
        <label for="street">Street:</label>
        <form:input path="street" type="text"  name="street" id="street"/>
        <form:errors path="street" cssStyle="color: red"/>
        <br/>
        <label for="houseNumber">House Number:</label>
        <form:input path="houseNumber" type="text"  name="houseNumber" id="houseNumber"/>
        <form:errors path="houseNumber" cssStyle="color: red"/>
        <br/>
        <label for="apprtNumber">Apartment Number:</label>
        <form:input path="apprtNumber" type="text"  name="apprtNumber" id="apprtNumber"/>
        <form:errors path="apprtNumber" cssStyle="color: red"/>
        <br/>
        <label for="city">City:</label>
        <form:input path="city" type="text" name="city" id="city"/>
        <form:errors path="city" cssStyle="color: red"/>
        <br/>
        <label for="zipCode">Zip Code:</label>
        <form:input path="zipCode" type="number"  name="zipCode" id="zipCode"/>
        <form:errors path="zipCode" cssStyle="color: red"/>

        <hr>
        <h2>Account password</h2>
        <hr>

        <label for="password">Password:</label>
        <form:input path="password" type="password" name="password" id="password"/>
        <form:errors path="password" cssStyle="color: red"/>
        <br/>
        <label for="passwordRepeat">Repeat Password:</label>
        <form:input path="passwordRepeat" type="password" name="passwordRepeat" id="passwordRepeat"/>
        <form:errors path="passwordRepeat" cssStyle="color: red"/>

        <br>
        <form:button class="registerbtn" id="add">Add</form:button>
    </div>
</form:form>
</div>
</body>


