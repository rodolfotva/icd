<div class="starter-template">
	<h1>ICD-10 version 2016</h1>
	<p class="lead">Use this site to search the ICD information.<br> You can check using the classification.</p>
</div>
<div class="bread">
<span class="breadStep" ng-if="chapterBread != ''" ng-click="chapterGo(chapterBread)"> Chapters > </span>
<span class="breadStep" ng-if="chapterBread != ''" ng-click="groupGo(chapterBread)" >Chapter {{chapterBread}}</span>
<span class="breadStep" ng-if="groupBread != ''"> > </span>
<span class="breadStep" ng-bind="groupBread"></span>
</div>
<div ng-switch="steps">
	<div ng-switch-when="chapter" chapter-page></div>
	<div ng-switch-when="group" group-page></div>
	<div ng-switch-when="category" category-page></div>
</div>