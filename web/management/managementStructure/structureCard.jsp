<%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 03/01/17
  Time: 05:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%structuresBean.setStructureSelected(Integer.valueOf(request.getParameter("structure_index")));%>

<div class="caption" style="margin-right: -0.7%">
    <div class="col-sm-10" style="display: inline-block; float: none; vertical-align: middle">
        <div class="row" style="text-align: center">
            <label><h3
                    class="card-title"><%= structuresBean.getStructures().get(structuresBean.getStructureSelected()).getName()%>
            </h3></label>
            <span class="glyphicon glyphicon-check" style="margin-left: 2%"></span>
            <h5 style="margin-top: -0.7%"><%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getAddress()%>
            </h5>
            <p class="card-text"
               align="justify"><%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getDescription()%>
            </p>
        </div>
    </div>
    <div class="row" style="display: inline-block; float: none;" style="text-align: right; horiz-align: right">
        <form method="post" action="/management/managementLocation/location.jsp">
            <button type="submit" name="structureindex" value="<%=structuresBean.getStructureSelected()%>"
                    class="btn btn-primary">Locazioni
            </button>
        </form>
    </div>
</div>



