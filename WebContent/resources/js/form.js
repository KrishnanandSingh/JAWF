getMeta();
employeeDetails = {
	name : '',
	mID : '',
	competency : '',
	subpractice : '',
	vertical : ''
};

function getMeta() {
	$(".notification").empty();
	$.getJSON('metaData.do?', function(result) {

		$.each(result.competence, function(i, value) {
			$('#idcompetence').append(
					$('<option>').text(value).attr('value', value));
		});

		$.each(result.subpractice, function(i, value) {
			$('#idsubpractice').append(
					$('<option>').text(value).attr('value', value));
		});

		$.each(result.verticals, function(i, value) {
			$('#idvertical').append(
					$('<option>').text(value).attr('value', value));
		});
	});
}

function searchEmployee() {
	$(".notification").empty();
	var mID = $("#searchBox input[name='mID']").val();
	$('#resultBox table').find('tbody').empty();
	if (mID == '' || isNaN(mID)) {
		$(".notification").text('Incorrect input');
		return false;
	}
	$.getJSON('findEmployee.do?mID=' + mID, function(result) {
		$(".notification").empty();
		if (JSON.stringify(result) !== '{}') {

			var data = '';
			data += '<tr><td>Employee ID</td><td>' + result.mID + '</td></tr>';
			data += '<tr><td>Name</td><td>' + result.name + '</td></tr>';
			data += '<tr><td>Competence Level</td><td>' + result.competency
					+ '</td></tr>';
			data += '<tr><td>Sub Practice</td><td>' + result.subpractice
					+ '</td></tr>';
			data += '<tr><td>Vertical</td><td>' + result.vertical
					+ '</td></tr>';

			$('#resultBox table').append(data);

		} else {
			$(".notification").text('No details found for: ' + mID);

		}
	});
}
function saveEmployee() {
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
		// console.log(employeeDetails);
		$.post('saveEmployee.do', employeeDetails, function(result) {
			$(".notification").text(result.message);
		}, 'json');
	} else {
		$(".notification").text('Incorrect input');
	}
}
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