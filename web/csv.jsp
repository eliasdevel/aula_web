<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div id="csv-content">
    <c:out value = "${data}"/>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        alert(document.getElementById("csv-content").innerHTML);
        var encodedUri = "data:application/csv;charset=utf-8,"+encodeURI(document.getElementById("csv-content").innerHTML);
        var link = document.createElement("a");
        link.setAttribute("href", encodedUri);
        link.setAttribute("download", "my_data.csv");
        document.body.appendChild(link); // Required for FF
        link.click();
    });
</script>
