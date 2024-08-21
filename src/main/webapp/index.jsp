<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>
           <style>
              form {
                display: flex;
                flex-direction: column;
                gap: 10px;
                width: 350px;
              }
              input{
                padding: 10px;
              }
           </style>
        <body>
            <h2>Stock Entry</h2>
            <h2 id="${errorMessage}"></h2>
            <form action="/hello" method="post">
                stockId::<input type="text" name="stockid" />
                symbol::<input type="text" name="symbol" />
                company name::<input type="text" name="company" />
                current price::<input type="text" name="current" />
                Date::<input type="date" name="date" />
                <input type="submit" value="Submit" />
            </form>
            <ul>
                <c:forEach var="item" items="${itemList}">
                    <li>${item}</li>
                </c:forEach>
            </ul>
        </body>

        </html>