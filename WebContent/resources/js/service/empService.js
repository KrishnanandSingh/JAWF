angular.module('empServices.services', []).factory('empService',
function($http) {
	this.findEmployee = function(mID) {
		return $http({
			method : 'GET',
			url : 'findEmployee.do?mID=' + mID
		});
	}
	this.getMeta = function() {
		return $http({
			method : 'GET',
			url : 'metaData.do'
		});
	}
	this.saveEmployee = function(employeeDetails) {
		return $http({
			method : 'POST',
			url : 'saveEmployee.do',
			data: $.param(employeeDetails),
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		});
	}
	
	return this;
});