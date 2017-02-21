<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="profile_javascript.jsp"%>

<div class="row">
   <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
         <div class="x_title">
            <h2>
               <spring:message code="profile.detail.title" />
            </h2>
            <ul class="nav navbar-right panel_toolbox">
               <li><a class="collapse-link"><i
                     class="fa fa-chevron-up"></i></a></li>
            </ul>
            <div class="clearfix"></div>
         </div>
         <div class="x_content">
            <br />
            <form:form modelAttribute="profile" id="profile_form" action="${pageContext.request.contextPath}${requestScope.action}"  class="form-horizontal form-label-left" method="POST">
               <form:hidden path="id"/>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstname"><spring:message code="profile.firstname" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="firstname" type="text" name="firstname" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastname"><spring:message code="profile.lastname" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="lastname" type="text" name="lastname" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email"><spring:message code="profile.email" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="email" type="text" name="email" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password"><spring:message code="profile.password" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="password" type="password" name="password" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
                            
               <div class="ln_solid"></div>
               <div class="form-group">
                  <div
                     class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                     <form:button type="reset" class="btn btn-warning"><spring:message code="common.reset" /></form:button>
                     <a href="${pageContext.request.contextPath}${requestScope.action_cancel}" class="btn btn-info"><spring:message code="common.cancel"/></a>
                     <c:choose>
                        <c:when test="${requestScope.view_type == 'update'}">
                           <form:button type="submit" class="btn btn-success"><spring:message code="common.update" /></form:button>
                        </c:when>
                        <c:when test="${requestScope.view_type == 'create'}">
                           <form:button type="submit" class="btn btn-success"><spring:message code="common.create" /></form:button>
                        </c:when>
                        <c:when test="${requestScope.view_type == 'delete'}">
                           <form:button type="submit" class="btn btn-danger"><spring:message code="common.delete" /></form:button>
                        </c:when>
                     </c:choose>
                  </div>
               </div>
            </form:form>
         </div>
      </div>
   </div>
</div>