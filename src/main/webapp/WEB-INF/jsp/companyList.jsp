<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Company List</title>
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
            $('#companyDataTable').DataTable();
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

    <h1 class="p-3"> Company List</h1>
    <form action="/filterCompanyList" method="">
        <input type="text" class="form-control input-sm" name="inputValue" placeholder="filtering by jpa query">
        <input type="submit" class="btn btn-info" value="Filter">
    </form>
    <br/>
    <form:form>


        <table class="table table-bordered" id="companyDataTable">
            <thead>
            <tr>
                <th>Company Id</th>
                <th>Company Name</th>
                <th>Company Street</th>
                <th>Company city</th>
                <th>Company owner name</th>
                <th>Company Products</th>
                <th>Is Approved</th>
                <th>Deny</th>
                <th>Approve</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="company" items="${list}">
                <tr>
                    <td>${company.id}</td>
                    <td>${company.companyName}</td>
                    <td>${company.street}</td>
                    <td>${company.city}</td>
                    <td>${company.companyOwners.firstName} ${company.companyOwners.lastName}</td>
                    <td><button type="button" class="btn btn-info">
                        <a href="/viewProducts/${company.id}">CompanyProducts</a>
                    </button></td>
                    <td>${company.status}</td>
                    <td><button type="button" class="btn btn-danger">
                        <a href="/deleteCompany/${company.id}">DENY</a>
                    </button></td>
                    <td><button type="button" class="btn btn-success">
                        <a href="/companyApprove/${company.id}">APPROVE</a>
                    </button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </form:form>

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