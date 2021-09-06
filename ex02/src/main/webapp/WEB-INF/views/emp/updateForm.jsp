<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<!-- 성, 이메일, 휴대폰 번호만 고칠 수 있음~~~~ -->
<div class="row">
	<div class="col-lg-6">
		<form role="form" method="POST" action="/emp/register">
			<div class="form-group">
				<label>사원번호<strong class="text-danger">**</strong></label> <input class="form-control" id="employeeId"
					name="employeeId" value="${emp.employeeId }"  disabled>
			</div>
			<div class="form-group">
				<label>이름</label> <input class="form-control" id="firstName"
					name="firstName" value="${emp.firstName }"  disabled>
			</div>
			<div class="form-group">
				<label>성<strong class="text-danger">**</strong></label> <input class="form-control" id="lastName"
					name="lastName" value="${emp.lastName }"  placeholder="필수" required>
			</div>
			<div class="form-group">
				<label>이메일<strong class="text-danger">**</strong></label> <input class="form-control" id="email"
					name="email" value="${emp.email }"  placeholder="필수" required>
			</div>
			<div class="form-group">
				<label>휴대폰 번호</label> <input class="form-control" id="phoneNumber"
					name="phoneNumber" value="${emp.phoneNumber }" >
			</div>
			<div class="form-group">
				<label>입사일<strong class="text-danger">**</strong></label> <input class="form-control" id="hireDate"
					name="hireDate" value="${emp.hireDate }"  disabled>
			</div>
			<div class="form-group">
				<label>직무번호<strong class="text-danger">**</strong></label> <input class="form-control" id="jobId"
					name="jobId" value="${emp.jobId }"  disabled>
			</div>
			<div class="form-group">
				<label>급여</label> <input class="form-control" id="salary"
					name="salary" value="${emp.salary }"  disabled>
			</div>
			<div class="form-group">
				<label>커미션</label> <input class="form-control" id="commissionPct"
					name="commissionPct" value="${emp.commissionPct }"  disabled>
			</div>
			<div class="form-group">
				<label>매니저 번호</label> <input class="form-control" id="managerId"
					name="managerId" value="${emp.managerId }"  disabled>
			</div>
			<div class="form-group">
				<label>부서 번호</label> <input class="form-control" id="departmentId"
					name="departmentId" value="${emp.departmentId }"  disabled>
			</div>

			<button class="btn btn-outline btn-info">등록</button>
			<button class="btn btn-default" type="button" onclick="">취소</button>
		</form>
	</div>
</div>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>