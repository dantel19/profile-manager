<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<spring:message code="information.list.title" />
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content" style="display: none;">
				<p class="text-muted font-13 m-b-30"></p>
				<table id="information_list"
					class="table table-striped table-bordered dt-responsive th-noborder"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th></th>
							<th><spring:message code="information.description" /></th>
							<th><spring:message code="information.rank" /></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th class="hidden-pm"></th>
							<th></th>
							<th class="hidden-pm"></th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${profileInformationForm.informationList}"
							var="profileInformation" varStatus="status">
							<tr>
								<td class="dt-body-center sorting_1" tabindex="0"><input
									type="checkbox" name="check-me" class="flat" value="" checked />
									<input type="hidden"
									name="informationList[${status.index}].id.id_profile"
									value="${profileInformation.id.id_profile}" /> <input
									type="hidden"
									name="informationList[${status.index}].id.id_information"
									value="${profileInformation.id.id_information}" /></td>
								<td>${profileInformation.information.description}</td>
								<td class="text-center">
									<input
									type="text"
									class="custom-input-text"
									name="informationList[${status.index}].rank"
									value="${profileInformation.rank}" /></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
