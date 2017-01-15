<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="user_list_javascript.jsp"%>

<div class="row">
   <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
         <div class="x_title">
            <h2>
               <spring:message code="profile.list.title" />
            </h2>
            <ul class="nav navbar-right panel_toolbox">
               <li></li>
               <li><a href="javascript:findAllUser()"><i
                     class="fa fa-refresh"></i></a></li>
               <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
            </ul>
            <div class="clearfix"></div>
         </div>
         <div class="x_content">
            <p class="text-muted font-13 m-b-30">Responsive is an extension
               for DataTables that resolves that problem by optimising the table's
               layout for different screen sizes through the dynamic insertion and
               removal of columns from the table.</p>
            <table id="user_list"
               class="table table-striped table-bordered dt-responsive nowrap"
               cellspacing="0" width="100%">
               <thead>
                  <tr>
                     <th>ID</th>
                     <th>Name</th>
                     <th>Surname</th>
                     <th>Actions</th>
                  </tr>
               </thead>
               <tbody>
               </tbody>
            </table>
         </div>
      </div>
   </div>
</div>
