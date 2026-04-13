<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/components/header.jsp" />

<style>
    .error-container {
        text-align: center;
        padding: 60px 20px;
    }

    .error-code {
        font-size: 80px;
        font-weight: bold;
        color: #C62300;
    }

    .error-message {
        font-size: 24px;
        margin-top: 10px;
        color: #333;
    }

    .home-button {
        margin-top: 25px;
        padding: 12px 25px;
        background-color: #500073;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-weight: bold;
    }

    .home-button:hover {
        background-color: #2A004E;
    }
</style>

<div class="error-container">

    <div class="error-code">
        404
    </div>

    <div class="error-message">
        Oops! Page not found.
    </div>

    <p>
        The page you are looking for does not exist or has been moved.
    </p>

    <a href="dashboard" class="home-button">
        Go to Dashboard
    </a>

</div>

<jsp:include page="/components/footer.jsp" />