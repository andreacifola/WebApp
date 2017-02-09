<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<jsp:useBean id="logged_user" scope="session" class="model.User"/>

<%Integer index = Integer.valueOf(request.getParameter("structure_index"));%>
<div class="thumbnail">
    <div class="caption" style="margin-right: -2%">
        <div class="col-sm-10" style="display: inline-block; float: none; vertical-align: middle">
            <div class="row">
                <label><h4 class="card-title"><%=structuresBean.getStructures().get(index).getName()%></h4></label>
                <span class="glyphicon glyphicon-check" style="margin-left: 2%"></span>
                <h6><%=structuresBean.getStructures().get(index).getAddress()%></h6>
                <p class="card-text" align="justify"><%=structuresBean.getStructures().get(index).getDescription()%></p>
            </div>
        </div><!--Lasciare questo commento così com'è, influenza in qualche modo il rendering
        --><div class="col-sm-2" style="display: inline-block; float: none;">
            <div class="row" style="text-align: center">
                <form method="get" action="location_search.jsp">
                    <button type="submit" name="structureindex" value="<%=index%>" hidden class="btn btn-primary">Seleziona</button>
                </form>
            </div>
        </div>
    </div>
</div>
