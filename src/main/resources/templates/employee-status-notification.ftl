<!DOCTYPE>
<html>
<head>
<title>Employee Status Notification</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<link href="https://fonts.googleapis.com/css?family=Titillium+Web&display=swap" rel="stylesheet">

		<style>
.jumbo {
text-align: center;
text-decoration: underline;
margin-bottom: 1em;
}

table {
font-family: arial, sans-serif;
border-collapse: collapse;
width: 100%;
}
td, th {
border: 1px solid #dddddd;
text-align: left;
padding: 8px;
word-break: break-all;
}

th {
text-align: center;
font-weight: bold;
}
tr:nth-child(even) {
background-color: #dddddd;
}

.header {
background-color: rgb(148, 110, 58);
color: #fff;
}

.success {
//background-color: rgba(0, 255, 0, 0.6);
}

.error {
color: rgba(255, 0, 0, 0.6);
}

</style>

</head>

<body>
<h2 class="jumbo">JOB Status</h2>
		<table>
			<thead>
				<tr class="header">
					<th width="5%">Id</th>
					<th width="15%">Name</th>
					<th width="10%">Date of Joining</th>
					<th width="10%">Date of Leave</th>
					<th width="10%">Total Experience</th>
					<th width="10%">Location</th>
					<th width="10%">Status</th>
					<th width="15%">Employee Type</th>
					<th width="15%">Skills</th>
				</tr>
			</thead>
			<tbody>
				<#list employeeStatuses as employeeStatus>

					<#assign status>error</#assign>
					<#if employeeStatus.status == 'Active'>
					  <#assign status>success</#assign>
					</#if>

					<tr class="${status}">
						<td>${employeeStatus.id}</td>
						<td>${employeeStatus.name}</td>
						<td>${employeeStatus.date_of_joining}</td>
						<td>${("${employeeStatus.date_of_leave}")!' '}</td>
						<td>${employeeStatus.total_experience}</td>
						<td>${employeeStatus.location}</td>
						<td>${employeeStatus.status}</td>
						<td>${employeeStatus.employee_type}</td>
						<td>${("${employeeStatus.skills}")!' '}</td>
					</tr>

				</#list>
			</tbody>
		</table>

	</body>

</html>