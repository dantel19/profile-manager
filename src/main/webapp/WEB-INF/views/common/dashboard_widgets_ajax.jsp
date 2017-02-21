<script type="text/javascript" charset="utf-8">   
	$.ajax({
		type: "GET",
		url: "${pageContext.request.contextPath}/layout/dashboard/ajax/widget/profilechart",
		success: function(response) {
		    $("#profile_chart_widget").html( response );
		}
	});

	$.ajax({
		type: "GET",
		url: "${pageContext.request.contextPath}/layout/dashboard/ajax/widget/distances",
		success: function(response) {
		    $("#distances_widget").html( response );
		}
	});
</script>