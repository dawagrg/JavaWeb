<jsp:include page = "/components/header.jsp" />

<h2>
    Edit Topic
</h2>
    <form method = "post" action="topic">
        <input type="number" value="" name="id" readonly>
        <input type="text" value="" name="name">
        <button>Edit</button>
    </form>

<jsp:include page = "/components/footer.jsp" />