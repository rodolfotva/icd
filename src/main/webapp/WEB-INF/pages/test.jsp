<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>  
    <title>:: ICD-10 ::</title>
    <link href="<c:url value="/resources/icd/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/icd/css/icd.css" />" rel="stylesheet">
    
    <script src="<c:url value="/resources/icd/js/jquery-min.js" />"></script>
    <script src="<c:url value="/resources/icd/js/bootstrap.js" />"></script>
    <script src="<c:url value="/resources/icd/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/icd/js/icd.js" />"></script>
    <script src="<c:url value="/resources/icd/js/controller/icd_controller.js" />"></script>
    <script src="<c:url value="/resources/icd/js/service/icd_service.js" />"></script>
    <script src="<c:url value="/resources/icd/js/directives/icd_directives.js" />"></script>

  </head>
  <body ng-app="icd" class="ng-cloak">
      <div class="generic-container" ng-controller="IcdController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Chapter Registration Form </span></div>
              <div class="formcontainer">
                  
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.chapter.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="numchap">Chapter Number</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.chapter.numchap" id="numchap" class="numchap form-control input-sm" placeholder="Enter your chapter number" required />
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.numchap.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                         
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="catini">Category Initial</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.chapter.catini" id="catini" class="form-control input-sm" placeholder="Enter your Category Initial."/>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="catfin">Category Final</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.chapter.catfin" id="catfin" class="form-control input-sm" placeholder="Enter your Category Final."/>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="description">Description</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.chapter.description" id="description" class="description form-control input-sm" placeholder="Enter the description" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.description.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.chapter.chapterId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                      
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Chapters </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Number</th>
                              <th>Initial Category</th>
                              <th>Final Category</th>
                              <th>Description</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="chapter in ctrl.chapters">
                              <td><span ng-bind="chapter.chapterId"></span></td>
                              <td><span ng-bind="chapter.numchap"></span></td>
                              <td><span ng-bind="chapter.catini"></span></td>
                              <td><span ng-bind="chapter.catfin"></span></td>
                              <td><span ng-bind="chapter.description"></span></td>
                              <td>
                             	 <button type="button" ng-click="ctrl.edit(chapter.chapterId)" class="btn btn-success custom-width">Edit</button>  
                             	 <button type="button" ng-click="ctrl.remove(chapter.chapterId)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
  </body>
</html>