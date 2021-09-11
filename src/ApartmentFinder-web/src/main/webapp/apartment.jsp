<%@ include file="header.jsp" %>
<form action='/ApartmentFinder-web/saveApartment' method='post'>
<p>&nbsp;</p>
<div class="exportlinks">&nbsp;<a href="index.html"><strong>Home</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="initApartmentSearch.do"><strong>Apartment List </strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="address.jsp">Add Address</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="contact.jsp">Add Contact</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="units.jsp">Add Units</strong></a>
&nbsp;&nbsp;|&nbsp;&nbsp;<a href="deals.jsp">Add Deals</strong></a>
</div>
    <table bgcolor="white">
      <tbody>
          <tr>
             <%
                 String status = request.getParameter("status");
                 if(status!=null){
                 
                 
                 if(status.equalsIgnoreCase("success")){
                    %>
      <div class="status"> Successfully Added the new Apartment</div>
                    <%
                 }else if(status.equalsIgnoreCase("error")){
                    %>
                    <div class="status"> Failed to Add the new Apartment</div>
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
                      <table cellspacing="0" cellpadding="0" bgcolor="#fea">
                    
                        <tr >

                          <td width="23" align="center" nowrap height="15">Apartment Name <font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text" name="name" size="50"/>
                          </td>
                        </tr>
                        <tr >

                          <td width="23" align="center" nowrap height="15">Owner <font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text"  name="owner" size="50"/>
                          </td>
                        </tr>
                        <tr>

                          <td width="23" align="center" nowrap height="15">Description <font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text"  name="description" size="50"/>
                          </td>
                        </tr>
                        <tr >

                          <td width="23" align="center" nowrap height="15">Image Url <font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text"  name="imageurl" size="50"/>
                          </td>
                        </tr>
                        <tr >

                          <td width="23" align="center" nowrap height="15">Parking <font face="Verdana, Arial, Helvetica, sans-serif" size="2"></font>
                          </td>
                          <td colspan=2 width="354" height="15"><input type="text" name="parking" size="50"/>
                          </td>
                        </tr>
          </table>
        </td>
      </tr>
      <tr >
        <td>
          <div align="center"> &nbsp; </div>
        </td>
        <td>&nbsp;</td>
        <td align="right">
          <input type=submit value="Save" style="background-color:#39275B; width:50px;color:white;border: 1px solid"/>

        </td>
        <td>&nbsp;</td>
      </tr>
      </tbody>
    </table>
</form>

<%@ include file="footer.jsp" %>
