<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>Add ToDo Item</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</head>
<body>

<div class="container">

    <h1 class="p-3"> ADD PRODUCT </h1>

    <form:form action="/saveProduct" method="post" modelAttribute="product">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="productName">Product Name:</label>
                <div class="col-md-6">
                    <form:input type="text" path="productName" id="productName"
                                class="form-control input-sm" />
                    <form:errors path="productName" cssStyle="color: red"/>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="productName">Product Name:</label>
                <div class="col-md-6">
                        <form:select class="form-control input-sm" path="productType" id="productType">
                            <form:option value="NONE"> --SELECT--</form:option>
                            <form:options items="${types}"></form:options>
                        </form:select>
                    <form:errors path="productType" cssStyle="color: red"/>

                </div>
            </div>
        </div>


        <div class="row p-2">
            <div class="col-md-2">
                <button type="submit" value="Register" class="btn btn-success">Save</button>
            </div>
        </div>

    </form:form>

</div>

<script th:inline="javascript">
    window.onload = function() {

        var msg = "${message}";
        console.log(msg);
        if (msg == "Save Failure") {
            Command: toastr["error"]("Something went wrong with the save.")
        }

        toastr.options = {
            "closeButton": true,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "preventDuplicates": false,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
    }
</script>

</body>

</html>