<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Product List</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">

    <link rel="stylesheet"
          href="https://cdn.datatables.net/2.0.7/css/dataTables.bootstrap4.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/2.0.7/js/dataTables.js"></script>
    <script src="https://cdn.datatables.net/2.0.7/js/dataTables.bootstrap4.js"></script>

    <script>
        $(document).ready(function(){
            $('#productsDataTable').DataTable();
        })
    </script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

<div class="container">

    <h1 class="p-3"> Company Products List</h1>

    <form:form>

        <table class="table table-bordered" id="productsDataTable">
            <thead>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Type</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="product" items="${list}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.productType}</td>
                    <td><button type="button" class="btn btn-primary">
                        <a href="/editProduct/${product.id}">Edit</a>
                    </button></td>
                    <td><button type="button" class="btn btn-danger">
                        <a href="/deleteProduct/${product.id}">Delete</a>
                    </button></td>
                </tr>

            </c:forEach>
            </tbody>
        </table>

    </form:form>

    <button type="button" class="btn btn-primary btn-block">
        <a href="/addProduct">Add new Product</a>
    </button>

    <button type="button" class="btn btn-primary btn-block">
        <a href="/">HOME</a>
    </button>

    <button type="button" class="btn btn-primary btn-block">
        <a href="/logout">logout</a>
    </button>


</div>

<script th:inline="javascript">
    window.onload = function() {

        var msg = "${message}";

        if (msg == "Save Success") {
            Command: toastr["success"]("Item added successfully!!")
        } else if (msg == "Delete Success") {
            Command: toastr["success"]("Item deleted successfully!!")
        } else if (msg == "Delete Failure") {
            Command: toastr["error"]("Some error occurred, couldn't delete item")
        } else if (msg == "Edit Success") {
            Command: toastr["success"]("Item updated successfully!!")
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