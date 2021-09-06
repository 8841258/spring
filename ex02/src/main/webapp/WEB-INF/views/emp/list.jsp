<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">사원명단</h1>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<table id="board" class="table table-hover">
				<thead>
					<tr>
						<th>사원번호</th>
						<th>이름</th>
						<th>입사일</th>
						<th>이메일</th>
						<th>급여</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${list }">
						<tr>
							<td>${emp.employeeId }</td>
							<td><a href="/emp/read?employeeId=${emp.employeeId }">${emp.lastName }</a></td>
							<td><fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd" /></td>
							<td>${emp.email}</td>
							<td>${emp.salary}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<button class="btn btn-outline btn-info" onclick="location.href='/emp/registerForm'">등록</button>


		</div>
	</div>
</div>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>