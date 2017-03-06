<script src="${pageContext.request.contextPath}/resources/themes/gentelella/vendors/Chart.js/Chart.min.js"></script>
<%@include file="profile_chart_javascript.jsp"%>

<div class="x_panel">
	<div class="x_title">
		<h2>
			Profile Graph <small>Similarity</small>
		</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
			<li><a class="close-link"><i class="fa fa-close"></i></a></li>
		</ul>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<span>Your Profile: <b>${bestProfile.name}</b><br />
		<br /></span>
		<canvas id="canvasDoughnut"></canvas>
		<br /><br />
		<div id="canvasDoughnut-Legend"></div>
	</div>
</div>