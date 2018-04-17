

<html>
<head>
</head>
<body>
	<form method="post" action="Insert.jsp">
		<table id="addtable">
			<tr>
				<th><h1 align="center">ADD TASK</h1></th>
			</tr>
			<tr>
				<td class="add"><label for="mtitle">Title</label></td>
				<td><input type="text" name="mtitle" ></td>
			</tr>
			<tr>
				<td class="add"><label for="mdescription">Description</label></td>
				<td><textarea rows="2" name="mdescription"></textarea></td>
			</tr>
			<tr>
				<td class="add"><label for="massignee">Assignee</label></td>
				<td><input type="text" name="massignee"></td>
			</tr>
			<tr>
				<td class="add"><label for="ehours">Estimated Hours</label></td>
				<td><input type="number" name="ehours"></td>
			</tr>
			<tr>
				<td class="add"><label for="startdate">Start Date</label></td>
				<td><input type="Date" name="startdate"></td>
			</tr>
			<tr>
				<td class="add"><label for="enddate">End Date</label></td>
				<td><input type="Date" name="enddate"></td>
			</tr>
			<tr>
				<td><input type="submit"  value="ok"></td>
				<td><input type="button" value="cancel"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>