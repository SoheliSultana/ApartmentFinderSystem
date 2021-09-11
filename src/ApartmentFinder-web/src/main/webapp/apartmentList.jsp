<%@ include file="header.jsp" %>
<%@ page import="com.uwb.entity.apartment.ApartmentIf"%>
<%@ page import="com.uwb.session.ApartmentServiceService"%>
<%@ page import="com.uwb.servicelocator.ServiceLocator"%>
<%@ page import="java.util.Collection"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="exportlinks">&nbsp;<a href="index.jsp"><strong>Index</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initApartmentSearch.do"><strong>Apartment List</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initApartment.do?id=null&"><strong> Apartment</strong></a>
</div>

<%
try{
    ApartmentServiceService aptService= (ApartmentServiceService)ServiceLocator.getService(ServiceLocator.APARTMENTSERVICE_SERVICE);
    Collection<ApartmentIf> listApt = aptService.getApartmentList();
	
    session.setAttribute("apartmentList", listApt);
    
            
%>

<display:table  id="parent" name="sessionScope.apartmentList" export="true" sort="list" pagesize="10">
  <display:column property="id" group="1" sortable="true" headerClass="sortable" />
  <display:column property="name" group="2" sortable="true" headerClass="sortable"/>
  <display:column property="owner" group="3" sortable="true" headerClass="sortable" />
  <display:column property="description" group="4" sortable="true" headerClass="sortable" />
  <display:column property="imageurl" group="5" sortable="true" headerClass="sortable" />
  <display:column property="parking" group="6" sortable="true" headerClass="sortable" />
</display:table>
<%}catch(Exception ex){
 ex.printStackTrace();
}

%>
<%@ include file="footer.jsp" %>
