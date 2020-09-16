<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/product/save" method="POST"
	modelAttribute="productForm">
	<div class="form-group">
		<label for="exampleInputEmail1">Product Code</label>
		<form:input path="productCode" required="required" type="text" class="form-control"
			id="exampleInputEmail1" aria-describedby="emailHelp" />
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Product Description</label>
		<form:input path="productDescription" required="required" type="text" class="form-control"
			id="exampleInputPassword1" />
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Product Price</label>
		<form:input path="productPrice" type="text" required="required" class="form-control"
			id="exampleInputPassword1" />
	</div>
	<form:button type="submit" class="btn btn-primary" value="Add">Add</form:button>
</form:form>