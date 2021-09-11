<%@page import="com.uwb.entity.contact.ContactIf"%>
<%@page import="com.uwb.entity.address.AddressIf"%>
<%@page import="com.uwb.entity.units.UnitsIf"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.uwb.entity.apartment.ApartmentIf"%>
<%@ page import="com.uwb.session.ApartmentServiceService"%>
<%@ page import="com.uwb.servicelocator.ServiceLocator"%>
<%@ page import= "com.uwb.entity.units.UnitsIf"%>
<%@ page import="java.util.Collection"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ include file="header.jsp" %>

<div class="exportlinks">&nbsp;<a href="searchResult.jsp"><strong>Back To Search Result</strong></a>

</div>
<%
    String aptId = request.getParameter("id");
   
    ApartmentServiceService aptService= (ApartmentServiceService)ServiceLocator.getService(ServiceLocator.APARTMENTSERVICE_SERVICE);
    Collection<UnitsIf> units = aptService.findUnitsByApertmentid(Integer.parseInt(aptId));
    ApartmentIf apt = aptService.getApartment(Integer.parseInt(aptId));
    Collection<AddressIf> addresses = aptService.findAddressByApartmentid(Integer.parseInt(aptId));
    
    Collection<ContactIf> contacts = aptService.findContactByApartmentid(Integer.parseInt(aptId));
    AddressIf address = addresses.iterator().next();
    ContactIf contact = contacts.iterator().next();
    session.setAttribute("apartmentList", units);
    String printName = "<div><h4>"+ apt.getName()+ "</h4></div>";
    out.println(printName);
    out.println( "<div><h4>"+ address.getAddresscol()+ "</h4></div>");
    out.println("<br/>");
    out.println("<table><tr>");
    printName = "<td><div><img src='" +apt.getImageurl()+"' height='200' width='250'></div></td>";
    out.println(printName);
	String info = "<div id='info'><table><tr><td><img src='/ApartmentFinder-web/images/cooling.png'></td><td>Cooling:</td><td>Central</td></tr>";
info = info + "<tr><td><img src='/ApartmentFinder-web/images/heating.png'></td><td>Heating:</td><td>Central</td></tr>";
info = info + "<tr><td><img src='/ApartmentFinder-web/images/laundry.png'></td><td>Laundry:</td><td>In Unit</td></tr>";
info = info + "<tr><td><img src='/ApartmentFinder-web/images/parking.png'></td><td>Parking:</td><td>2 Space Available</td></tr>";
info = info + "<tr><td><img src='/ApartmentFinder-web/images/pets.png'></td><td>Pets:</td><td>Cats & Dogs</td></tr>";
info = info + "<tr><td><img src='/ApartmentFinder-web/images/deposit.png'></td><td>Deposit:</td><td>$500</td></tr>";
info = info + "</table></div>";
printName = "<td>"+info +"</td>";
    out.println(printName);
    String printContact = "<div id='contact'><table><th>Contact Us</th><tr><td>";
    printContact = printContact + "Representative: " + contact.getRepresentative()+"</td></tr>";
    printContact = printContact + "<tr><td>Phone Number: " + contact.getPhone()+"</td></tr>";
    printContact = printContact + "<tr><td>Email: " + contact.getEmail()+"</td></tr>";
    printContact = printContact + "<tr><td>Open Hours: " + contact.getOpenhour()+"</td></tr>";
    printContact = printContact + "</table></div>";
    printName = "<td><div>"+printContact +"</div></td>";
    out.println(printName);
    out.println("</tr></table>");
   
    
            
%>
<display:table  id="parent" name="sessionScope.apartmentList" export="true" sort="list" pagesize="10">
  
  <display:column property="number" group="2" sortable="true" headerClass="sortable" />
  <display:column property="type" group="3" sortable="true" headerClass="sortable" />
  <display:column property="rent" group="4" sortable="true" headerClass="sortable" />
 
  <display:column property="squareft" group="6" sortable="true" headerClass="sortable" />
  <display:column property="avalibility" group="6" sortable="true" headerClass="sortable" />
</display:table>
<%@ include file="footer.jsp" %>

