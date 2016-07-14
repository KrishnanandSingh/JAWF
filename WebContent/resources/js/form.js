getMeta();

function getMeta(){
	$(".notification").empty();
	$.getJSON('metaData.do?', function(result) {
		
		  $.each(result.competence, function(i, value) {
	            $('#idcompetence').append($('<option>').text(value).attr('value', value));
	        });
		  
		  $.each(result.subpractice, function(i, value) {
	            $('#idsubpractice').append($('<option>').text(value).attr('value', value));
	        });
		  
		  $.each(result.verticals, function(i, value) {
	            $('#idvertical').append($('<option>').text(value).attr('value', value));
	        });
	});
}


function searchEmployee() {
	$(".notification").empty();
	var mID = $("#searchBox input[name='mID']").val();
	$('#resultBox table').find('tbody').empty();
	$.getJSON('findEmployee.do?mID=' + mID, function(result) {
		
		var data='';
		data+='<tr><td>Employee ID</td><td>'+result.mID+'</td></tr>';
		data+='<tr><td>Name</td><td>'+result.name+'</td></tr>';
		data+='<tr><td>Competence Level</td><td>'+result.competency+'</td></tr>';
		data+='<tr><td>Sub Practice</td><td>'+result.subpractice+'</td></tr>';
		data+='<tr><td>Vertical</td><td>'+result.vertical+'</td></tr>';
	
		
		$('#resultBox table').append(data);
	});
}
function saveEmployee() {
	$(".notification").empty();
	var mID = $("#employeeForm input[name='mID']").val();
	var name = $("#employeeForm input[name='name']").val();
	var competency = $("#employeeForm select[name='competency']").val();
	var subpractice = $("#employeeForm select[name='subpractice']").val();
	var vertical = $("#employeeForm select[name='vertical']").val();
	
	var employeeDetails = {
		name : name.toUpperCase(),
		mID : mID,
		competency : competency,
		subpractice : subpractice,
		vertical : vertical
	};
	//console.log(employeeDetails);
	$.post('saveEmployee.do', employeeDetails, function(result) {
		$(".notification").empty();
		$(".notification").text(result.message);
	}, 'json');
	
}