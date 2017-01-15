<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<div class="top_nav">
	<div class="nav_menu">
		<nav>
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li class=""><a href="javascript:;"
					class="user-profile dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> <img
						src="${pageContext.request.contextPath}/resources/images/user-template_2.jpg"
						alt=""><security:authentication property="principal.user.name" /> <security:authentication property="principal.user.surname" /> <span class=" fa fa-angle-down"></span>
				</a>
					<ul class="dropdown-menu dropdown-usermenu pull-right">
						<li><a href="javascript:;"> Profile</a></li>
						<li><a href="${pageContext.request.contextPath}/user/update?id=<security:authentication property="principal.user.id" />"><span><spring:message code="common.settings" /></span></a></li>
						<li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><i class="fa fa-sign-out pull-right"></i> <spring:message code="common.signout" /></a></li>
					</ul></li>

				<li role="presentation" class="dropdown"><a href="javascript:;"
					class="dropdown-toggle info-number" data-toggle="dropdown"
					aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span
						class="badge bg-green">6</span>
				</a>
					<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
						role="menu">
						<li><a> <span class="image"><img
									src="${pageContext.request.contextPath}/resources/images/user-template_1.png"
									alt="Profile Image" /></span> <span> <span>John Smith</span> <span
									class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li><a> <span class="image"><img
									src="${pageContext.request.contextPath}/resources/images/user-template_1.png"
									alt="Profile Image" /></span> <span> <span>John Smith</span> <span
									class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li><a> <span class="image"><img
									src="${pageContext.request.contextPath}/resources/images/user-template_1.png"
									alt="Profile Image" /></span> <span> <span>John Smith</span> <span
									class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li><a> <span class="image"><img
									src="${pageContext.request.contextPath}/resources/images/user-template_1.png"
									alt="Profile Image" /></span> <span> <span>John Smith</span> <span
									class="time">3 mins ago</span>
							</span> <span class="message"> Film festivals used to be
									do-or-die moments for movie makers. They were where... </span>
						</a></li>
						<li>
							<div class="text-center">
								<a> <strong>See All Alerts</strong> <i
									class="fa fa-angle-right"></i>
								</a>
							</div>
						</li>
					</ul></li>
			</ul>
		</nav>
	</div>
</div>