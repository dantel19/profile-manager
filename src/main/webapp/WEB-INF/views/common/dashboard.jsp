<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="dashboard_widgets_ajax.jsp"%>

<div class="row">
	<div class="col-xs-12 col-sm-6 col-md-6">
		<div id="profile_chart_widget"></div>
	</div>
	
	<div class="col-xs-12 col-sm-6 col-md-6">
		<div id="distances_widget"></div>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div id="last_information_widget"><%@include file="widgets/last_information.jsp"%></div>
	</div>
</div>