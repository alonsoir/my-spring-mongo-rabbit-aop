<div id="editDialog" title="Edit this item" style="display: none">
	<form id="editForm">
		<table>
			<thead>
				<tr>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Name:</td>
					<td><input type="text" id="aname" name="aname" /></td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><input type="text" id="adate" name="adate" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" id="adescription" name="adescription" /></td>
				</tr>
				<tr>
					<td>Prize:</td>
					<td><input type="text" id="aprize" name="aprize" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save" /> <input
						id="editCancel" type="button" value="Cancel" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<script type="text/javascript">
	$(function() {
		// Convert links to buttons
		$('input:submit, #editCancel').button();

		//Convert text input to jQuery DatePicker
		// This helps us add date entries to text inputs
		$("#edate").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : 'yy-mm-dd'
		});
	});

	$('#editCancel').click(function() {
		$('#editDialog').dialog("close");
	});

	$("#editForm").submit(
			function() {
				$.post("${rootUrl}items/edit", {
					id : $('input:radio[name=eventRadio]:checked').val(),
					name : $('#editForm #ename').val(),
					date : new Date($('#editForm #edate').val()).toISOString(),
					description : $('#editForm #adescription').val(),
					prize : $('#editForm #aprize').val()
				}, function(result) {
					// close parent dialog
					$("#editDialog").dialog("close");

					if (result.success == true) {
						$("#genericDialog").text("Updated event saved");
						$("#genericDialog").dialog({
							title : 'Success',
							modal : true,
							buttons : {
								"Ok" : function() {
									$("#genericDialog").dialog("close");
								}
							}
						});
						// retrieve all records
						$.getRecords('#eventTable', '${rootUrl}items/getall', [
								'id', 'name', 'description', 'prize' ],
								null);
					} else {
						$("#genericDialog").text("Unable to update item!");
						$("#genericDialog").dialog({
							title : 'Error',
							modal : true,
							buttons : {
								"Ok" : function() {
									$("#genericDialog").dialog("close");
								}
							}
						});

					}
				});
				return false;
			});
</script>