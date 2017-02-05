<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="information_javascript.jsp"%>

<div class="row">
   <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
         <div class="x_title">
            <h2>
               <spring:message code="information.list.title" />
            </h2>
            <ul class="nav navbar-right panel_toolbox">
               <li><a href="${pageContext.request.contextPath}/administration/information/create"><i class="fa fa-plus"></i></a></li>
               <li><a href="javascript:findAllInformation()"><i class="fa fa-refresh"></i></a></li>
               <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
            </ul>
            <div class="clearfix"></div>
         </div>
         <div class="x_content">
            <p class="text-muted font-13 m-b-30"></p>
            <table id="information_list"
               class="table table-striped table-bordered dt-responsive nowrap"
               cellspacing="0" width="100%">
               <thead>
                  <tr>
                  	 <th>id</th>
                     <th><spring:message code="information.description" /></th>
                     <th><spring:message code="common.actions" /></th>
                  </tr>
               </thead>
					<tfoot>
						<tr>
							<th></th>
							<th><spring:message code="common.search.by" /> <spring:message code="information.description" /></th>
							<th></th>
						</tr>
					</tfoot>
					<tbody>
              </tbody>
            </table>
         </div>
      </div>
   </div>
</div>
