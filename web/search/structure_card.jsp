<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="thumbnail">
    <div class="caption" style="margin-right: -2%">
        <div class="col-sm-10" style="display: inline-block; float: none; vertical-align: middle">
            <div class="row">
                <h4 class="card-title">${param.title}</h4>
                <h6>${param.address}</h6>
                <p class="card-text" align="justify">${param.description}</p>
            </div>
        </div><!--Lasciare questo commento così com'è, influenza in qualche modo il rendering
        --><div class="col-sm-2" style="display: inline-block; float: none;">
            <div class="row" style="text-align: center">
                <button class="btn btn-primary">Seleziona</button>
            </div>
        </div>
    </div>
</div>
