<div class="row">
	<div ng-repeat="group in groups" class="col-md-6 group-row">
		<div class="row">
			<div class="col-md-12">
				<span ng-click="categoryGo(group)" class="chapterTitle">Group {{group.catini}} to {{group.catfin}}</span>
				<br />
				<span>{{group.description}}</span>
			</div>
		<div>
	</div>
</div>