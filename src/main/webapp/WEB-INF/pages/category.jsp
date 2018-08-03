<div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ICD</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="category in categorys">
				<td>{{category.icd}}</td>
				<td>{{category.description}}</td>
			</tr>
		</tbody>
	</table>
</div>