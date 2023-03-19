<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.account.role != 'ROLE_ADMIN'}">
    <jsp:forward page="/home/index.do"/>
</c:if>
<c:if test="${sessionScope.account.role == 'ROLE_ADMIN'}">
    <form action="<%=request.getContextPath()%>/uploadFile" method="post" enctype="multipart/form-data" >
			<label>Upload file : </label>
			<input type="file" value="Upload file" name="hinhanh"  /> <br />
                        <input type="hidden" value="${product.productId}" name="id"/>
                        <input type="text"  name="fileName"/>
			<input type="submit" value="Thực hiện" name="thuchien"  />
		</form>                             

</c:if>