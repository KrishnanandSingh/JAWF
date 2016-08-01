angular.module('empController.controllers',[]).
controller('searchController',function($scope,empService){
	
	$scope.employee = {};
	
	function validateEmployeeID(mID){
		$(".notification").empty();
		if (mID == '' || isNaN(mID)) {
			$(".notification").text('Incorrect input');
			return false;
		}
		return true;
	}
	
	$scope.findEmployee = function(){
		$('#resultBox table').hide();
		var mID = $("#searchBox input[name='mID']").val();
		if (validateEmployeeID(mID)){
			empService.findEmployee(mID).success(function(response){
				if (JSON.stringify(response) !== '{}') {
					$scope.employee = response;
					$('#resultBox table').show();
				}else{
					$(".notification").text('No details found for: ' + mID);
				}
			});
		}
	};
	
}).controller('saveController',function($scope,empService){
	$scope.subpracticeList = {};
	$scope.competenceList = {};
	$scope.verticalList = {};
	
	$scope.getMetaData = function() {
		$(".notification").empty();
		empService.getMeta().success(function(response){
			if (JSON.stringify(response) !== '{}') {
				$scope.subpracticeList = response.subpractice;
				$scope.competenceList = response.competence;
				$scope.verticalList = response.vertical;
			}else{
				$(".notification").text('No details found on server');
			}
		});
	};
	$scope.getMetaData();
	
	employeeDetails = {
			name : '',
			mID : '',
			competency : '',
			subpractice : '',
			vertical : ''
	};
	
	function validateEmployee() {
		if (employeeDetails.name == '' || employeeDetails.mID == ''
				|| employeeDetails.competency == ''
				|| employeeDetails.subpractice == ''
				|| employeeDetails.vertical == '') {
			return false;
		}
		if (isNaN(employeeDetails.mID)) {
			return false;
		}
		if (employeeDetails.name) {
			var matches = employeeDetails.name.match('[0-9]+');
			if (matches != null) {
				return false;
			}
		}
		return true;
	}

	$scope.saveEmployee = function () {
		$(".notification").empty();
		var mID = $("#employeeForm input[name='mID']").val();
		var name = $("#employeeForm input[name='name']").val();
		var competency = $("#employeeForm select[name='competency']").val();
		var subpractice = $("#employeeForm select[name='subpractice']").val();
		var vertical = $("#employeeForm select[name='vertical']").val();

		employeeDetails = {
			name : name.toUpperCase(),
			mID : mID,
			competency : competency,
			subpractice : subpractice,
			vertical : vertical
		};
		if (validateEmployee()) {
			empService.saveEmployee(employeeDetails).success(function(response){
				$(".notification").text(response.message);
			});
		} else {
			$(".notification").text('Incorrect input');
		}
	}
	
}).controller("employeesController",function($scope,empService){
	$scope.employeeList = {};
	$scope.showEmployees = false;
	findAllEmployees = function(){
		$(".notification").empty();
		$scope.showEmployees = !$scope.showEmployees;
		if($scope.showEmployees){
			empService.findAllEmployees().success(function(response){
				if (JSON.stringify(response) !== '{}') {
					$scope.employeeList = response;
				}else{
					$(".notification").text('No employees found');
				}
			});
		}
	};
	findAllEmployees();
	
});