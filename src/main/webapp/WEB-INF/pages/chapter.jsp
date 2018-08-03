<div class="row">
	<div ng-repeat="chapter in chapters" class="col-md-4 chapter-row" >
		<div class="row">
			<div class="col-md-3">
				<span class="chapterNumber">{{chapter.numchap}}</span>
			</div>
			<div class="col-md-9">
				<span ng-click="groupGo(chapter.chapterId)" class="chapterTitle">Chapter {{chapter.numchap}}</span>
				<br />
				<span>{{chapter.description}}</span>
			</div>
		<div>
	</div>
</div>