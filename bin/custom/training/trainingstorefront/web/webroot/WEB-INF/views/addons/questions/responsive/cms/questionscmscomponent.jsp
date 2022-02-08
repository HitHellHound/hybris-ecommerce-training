<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content">
    <h1>Questions(${questions.size()})</h1>
    <c:forEach items="${questions}" var="question">
        <p>
            <h3>${question.questionCustomerName}</h3>
            <div style="font-size: 12px">${question.question}</div>
            <h5>${question.answerCustomerName}</h5>
            <div style="font-size: 12px">${question.answer}</div>
        </p>
        <br>
    </c:forEach>
    <h1>End</h1>
</div>
