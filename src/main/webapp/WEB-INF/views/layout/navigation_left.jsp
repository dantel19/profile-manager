<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<div class="col-md-3 left_col">
	<div class="left_col scroll-view">
	    <div class="navbar nav_title" style="border: 0;">
           <a href="${pageContext.request.contextPath}/dashboard" class="site_title">
           		<i class="fa fa-users"></i> <span><spring:message code="common.application.title" /></span>
           </a>
        </div>

        <div class="clearfix"></div>
		
        <%-- menu profile quick info --%>
        <div class="profile">
           <div class="profile_pic">
              <img src="${pageContext.request.contextPath}/resources/images/user-template_2.jpg" alt="<security:authentication property="principal.user.firstname" /> <security:authentication property="principal.user.lastname" />" class="img-circle profile_img">
           </div>
           <div class="profile_info">
              <span><spring:message code="common.welcome" />,</span>
              <h2><security:authentication property="principal.user.firstname" /> <security:authentication property="principal.user.lastname" /></h2>
           </div>
        </div>
        <%-- /menu profile quick info --%>
        
        <%-- sidebar menu --%>
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
			<div class="menu_section">
			    <h3 class="fa fa-info-circle"></h3>
				<ul class="nav side-menu">
                    <li><a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-laptop"></i>Dashboard</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/information/update"><i class="fa fa-list-ol"></i>My Profile</a></li>
				</ul>
            	<security:authorize access="hasAnyRole('administrator')">
				<ul class="nav side-menu">
                    <li><a><i class="fa fa-bug"></i> Administration <span class="fa fa-chevron-down"></span></a>
						   <ul class="nav child_menu">
							   <li><a href="${pageContext.request.contextPath}/administration/user/list">User</a></li>
							   <li><a href="${pageContext.request.contextPath}/administration/profile/list">Profile</a></li>
							   <li><a href="${pageContext.request.contextPath}/administration/information/list">Information</a></li>
							   <li><a href="${pageContext.request.contextPath}/administration/category/list">Category</a></li>
						   </ul>
                    </li>
				</ul>
            	</security:authorize>
            </div>
		</div>
		<%-- /sidebar menu --%>

		<%-- /menu footer buttons --%>
		<div class="sidebar-footer hidden-small">
			<a href="${pageContext.request.contextPath}/user/update" data-toggle="tooltip" data-placement="top" title="<spring:message code="common.settings" />" style="width: 50%;"> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span></a> 
            <%--<a data-toggle="tooltip" data-placement="top" title="FullScreen"> <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span> </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock"> <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span></a>--%>
            <a href="${pageContext.request.contextPath}/j_spring_security_logout" data-toggle="tooltip" data-placement="top" title="<spring:message code="common.signout" />" style="width: 50%;"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span></a>
		</div>
      
		<%-- /menu footer buttons --%>
	</div>
</div>
