<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp" %>
<%@ page import="com.uwb.entity.apartment.ApartmentIf"%>
<%@ page import="com.uwb.session.ApartmentServiceService"%>
<%@ page import="com.uwb.servicelocator.ServiceLocator"%>
<%@ page import= "com.uwb.entity.address.AddressIf"%>
<%@ page import="java.util.Collection"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="exportlinks">&nbsp;<a href="index.html"><strong>Home</strong></a>

</div>
<%
    String city = request.getParameter("city");
	
	if(city==null){
		city  = (String)session.getAttribute("city");
	}
    String state = request.getParameter("state");
    ApartmentServiceService aptService= (ApartmentServiceService)ServiceLocator.getService(ServiceLocator.APARTMENTSERVICE_SERVICE);
    Collection<AddressIf> addresses = aptService.findAddressByCity(city);
    List<ApartmentIf> list = new ArrayList<ApartmentIf>();
    for(AddressIf addr : addresses){
        ApartmentIf aptIf = aptService.getApartment(addr.getApartmentid());
        if(aptIf != null){
            list.add(aptIf);
        }
    }
   
    
    session.setAttribute("apartmentList", list);
	session.setAttribute("city", city);
    
            
%>
<display:table  id="parent" name="sessionScope.apartmentList" export="true" sort="list" pagesize="10">
  
  <display:column property="name" group="2" sortable="true" headerClass="sortable" href="aptDetails.jsp" paramId="id" paramProperty="primaryKey"/>
  <display:column property="owner" group="3" sortable="true" headerClass="sortable" />
  <display:column property="description" group="4" sortable="true" headerClass="sortable" />
 
  <display:column property="parking" group="6" sortable="true" headerClass="sortable" />
</display:table>
<%@ include file="footer.jsp" %>
