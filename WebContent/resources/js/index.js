getMeta();

function getMeta(){
	$.getJSON('metaData.do?', function(result) {
		console.log(result);
	});
}


function searchEmployee() {
	var mID = $("#searchBox input[name='mID']").val();
	console.log(mID);
	$.getJSON('findEmployee.do?mID=' + mID, function(result) {
		console.log(result);
	});
}
function saveEmployee() {
	var mID = $("#employeeForm input[name='mID']").val();
	var name = $("#employeeForm input[name='name']").val();
	var competency = $("#employeeForm input[name='competency']").val();
	var subpractice = $("#employeeForm input[name='subpractice']").val();
	var vertical = $("#employeeForm input[name='vertical']").val();
	var employeeDetails = {
		name : name,
		mID : mID,
		competency : competency,
		subpractice : subpractice,
		vertical : vertical
	};
	console.log(employeeDetails);
	$.post('saveEmployee.do', employeeDetails, function(result) {
		console.log(result);
		$("#notification").empty();
		$("#notification").text(result.message);
	}, 'json');
}