<div id="deleteDialog" title="Delete this item" style="display: none">
	<p>Are you sure you want to delete this item?</p>
	<form id="deleteForm">
		<table>
			<thead>
				<tr>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td><input type="submit" value="Delete" /> <input
						id="deleteCancel" type="button" value="Cancel" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<script type="text/javascript"> 
$(function() {
	// Convert links to buttons
	$('input:submit, #deleteCancel').button();
});

$('#deleteCancel').click(function() { 
	$('#deleteDialog').dialog("close");
});

$("#deleteForm").submit(function() { 
	$.post("${rootUrl}items/delete", { 
		id: $('input:radio[name=eventRadio]:checked').val()},
		function(result){
			// close parent dialog
			$("#deleteDialog").dialog("close"); 
			
			if (result.success == true) {
				$("#genericDialog").text("item has been deleted");
				$("#genericDialog").dialog( 
						{	title: 'Success',
							modal: true,
							buttons: {"Ok": function()  {
								$("#genericDialog").dialog("close");} 
							}
						});
				// retrieve all records
				$.getRecords('#eventTable', '${rootUrl}items/getall', 
						['id', 'name', 'description', 'prize'], 
						null);
			} else {
				$("#genericDialog").text("Unable to update item!");
				$("#genericDialog").dialog( 
						{	title: 'Error',
							modal: true,
							buttons: {"Ok": function()  {
								$("#genericDialog").dialog("close");} 
							}
						});

			}
	});
	return false;
});
</script>