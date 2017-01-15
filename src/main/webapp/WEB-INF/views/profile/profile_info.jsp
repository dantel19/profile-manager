<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="profile_list_javascript.jsp"%>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>${profileDetail.name}</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li></li>
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<div class="col-md-3 col-sm-3 col-xs-12 profile_left">
					<div class="profile_img">
						<div id="crop-avatar">
							<!-- Current avatar -->
							<img class="img-responsive avatar-view"
								src="${pageContext.request.contextPath}/resources/images/profiles/profile_green.jpg"
								alt="Profile Detail" title="Profile Detail">
						</div>
					</div>

					<br />

					<ul class="list-unstyled user_data">
						<li><i class="fa fa-info-circle user-profile-icon"></i>
							Description Code: ${profileDetail.description}</li>
						<li><i class="fa fa-location-arrow user-profile-icon"></i>
							Name: ${profileDetail.name}</li>
					</ul>

					<br />

				</div>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<div class="profile_title">
						<div class="col-md-12">
							<h2>
								<spring:message code="profile.detail.title" />
							</h2>
						</div>
					</div>
					<br />
					<br /> <span>Lorem ipsum dolor sit amet, consectetur
						adipisci elit, sed eiusmod tempor incidunt ut labore et dolore
						magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem
						ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi
						consequatur. Quis aute iure reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat
						cupiditat non proident, sunt in culpa qui officia deserunt mollit
						anim id est laborum.</span>
				</div>
			</div>
		</div>
	</div>
</div>