<%-- 
    Document   : stats
    Created on : Apr 16, 2021, 6:49:27 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">ORDER STATS</h1>

<form>
    <div class="form-group">
        <input placeholder="From date..." type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <input placeholder="To date..." type="date" name="toDate" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="Tra cuu" />
    </div>
</form>

<table class="table">
    <tr>
        <th>MA HOA DON</th>
        <th>TONG TIEN HOA DON</th>
        <th>NGAY TAO HOA DON</th>
        <th>TONG SAN PHAM</th>
    </tr>
    <c:forEach items="${dataStats}" var="stats">
    <tr>
        <td>${stats[0]}</td>
        <td>${stats[1]} VND</td>
        <td>${stats[2]}</td>
        <td>${stats[3]}</td>
    </tr>
    </c:forEach>
</table>

<div>
    <canvas id="myChart" width="400" height="400"></canvas>
</div>



<script src="https://cdn.jsdelivr.net/npm/chart.js@3.1.0/dist/chart.min.js">
    
</script>
<script>
    let d = [];
    <c:forEach items="${amounts}" var="c">
        d.push(${c})
    </c:forEach>
    console.info(d);
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
            label: '# of Votes',
            data: d,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
</script>