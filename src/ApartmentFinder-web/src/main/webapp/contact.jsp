<%@ include file="header.jsp" %>
<form action='/ApartmentFinder-web/saveContact' method='post'>
<html:hidden property="mode"/>
<html:errors/>
<p>&nbsp;</p>
<div class="exportlinks">&nbsp;<a href="index.html"><strong>Home</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initApartmentSearch.do"><strong>Apartment List </strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="address.jsp">Add Address</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="contact.jsp">Add Contact</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="units.jsp">Add Units</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="deals.jsp">Add Deals</strong></a>
</div>
    <table bgcolor="#f0e0a0">
      <tbody>
          <tr>
             <%
                 String status = request.getParameter("status");
                 if(status != null){
                 if(status.equalsIgnoreCase("success")){
                    %>
      <div class="status"> Successfully Added the new Contact</div>
                    <%
                 }else if(status.equalsIgnoreCase("error")){
                    %>
                    <div class="status"> Failed to Add the new Contact</div>
                    <%
                 }else{
                    %>
                    <div class="status"> Failed to due to Exception</div>
                    <%
                 }
                }
             %> 
          </tr>
      <tr>
        <td colspan="4">
                      <table cellspacing="0" cellpadding="0" bgcolor="#eeeeee">
                      <html:hidden property="id"/>
                      
                        <tr bgcolor="#eeeee">
                          
                          <td width="23" align="center" nowrap height="15">Representative<font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text" name="representative" size="50"/>
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                         
                          <td width="23" align="center" nowrap height="15">Phone Number<font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text" name="phone" size="50"/>
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                         
                          <td width="23" align="center" nowrap height="15">Email<font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text" name="email" size="50"/>
                          </td>
                        </tr>
                        <tr bgcolor="#eeeee">
                          <td width="23" align="center" nowrap height="15">Open Hour<font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text" name="openhour" size="50"/>
                          </td>
                        </tr>
                        
                        <tr bgcolor="#eeeee">
                          
                          <td width="23" align="center" nowrap height="15">Apartment ID<font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text" name="apartmentid" size="50"/>
                          </td>
                        </tr>
                        
          </table>
        </td>
      </tr>
      <tr bgcolor="#f0e0a0">
        <td>
          <div align="center"> &nbsp; </div>
        </td>
        <td>&nbsp;</td>
        <td align="right">
          <input type="submit" value="Save"/>
          
        </td>
        <td>&nbsp;</td>
      </tr>
      </tbody>
    </table>
</form>
<html:javascript formName="contactForm" />
<%@ include file="footer.jsp" %>
