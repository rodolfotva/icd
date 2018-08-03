<div class="starter-template">
	<h1>ICD-10 version 2016</h1>
	<p class="lead">Use this site to search the ICD information.<br> You can search by the icd number or the description.</p>
</div>
<div class="row" style="padding-bottom: 50px">
	<form name="searchIcd">
		<div class="col-md-2"></div>
		<div class="col-md-3">
			<input type="text" class="form-control" placeholder="Search by ICD"  ng-model="icdSearch">
		</div>
		<div class="col-md-4">
			<input type="text" class="form-control" placeholder="Search by description" ng-model="descSearch">
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-default" ng-click="search()" ng-disabled="false">Search</button>
		</div>
	</form>
</div>			
<div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ICD</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="search in categorysSearch">
				<td>{{search.icd}}</td>
				<td>{{search.description}}</td>
			</tr>
		</tbody>
	</table>
</div>