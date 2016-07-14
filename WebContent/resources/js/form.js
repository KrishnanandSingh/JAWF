getMeta();

function getMeta(){
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
	var mID = $("#searchBox input[name='mID']").val();
	$.getJSON('findEmployee.do?mID=' + mID, function(result) {
		
		var data='';
		data+='<tr><td><label>Employee ID</label></td><td>'+result.mID+'</td></tr>';
		data+='<tr><td><label>Name</label></td><td>'+result.name+'</td></tr>';
		data+='<tr><td><label>Competence Level</label></td><td>'+result.competency+'</td></tr>';
		data+='<tr><td><label>Sub Practice</label></td><td>'+result.subpractice+'</td></tr>';
		data+='<tr><td><label>Vertical</label></td><td>'+result.vertical+'</td></tr>';
	
		$('#resultBox table').append(data);
	});
}
function saveEmployee() {
	var mID = $("#employeeForm input[name='mID']").val();
	var name = $("#employeeForm input[name='name']").val();
	var competency = $("#employeeForm select[name='competency']").val();
	var subpractice = $("#employeeForm select[name='subpractice']").val();
	var vertical = $("#employeeForm select[name='vertical']").val();
	var employeeDetails = {
		name : name,
		mID : mID,
		competency : competency,
		subpractice : subpractice,
		vertical : vertical
	};
	//console.log(employeeDetails);
	$.post('saveEmployee.do', employeeDetails, function(result) {
		console.log(result);
		$("#notification").empty();
		$("#notification").text(result.message);
	}, 'json');
}