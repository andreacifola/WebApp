<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="sendedLettersBean" scope="session" class="bean.ListLetterBean"/>
<%Integer index = Integer.valueOf(request.getParameter("sended_email_index"));%>

<div class="thumbnail">
    <div class="caption" style="margin-right: -2%">
        <div class="col-sm-12" style="display: inline-block; float: none; vertical-align: middle">
            <div class="row">
                <div class="col-sm-0.5"></div>
                <div class="col-sm-11">
                    <label class="control-label col-sm-2" for="receiver">A:</label>
                    <div class="col-sm-10">
                        <input name="receiver" type="text" class="form-control input-sm" id="receiver"
                               value="<%=sendedLettersBean.getLetters().get(index).getUsername()%>"
                               style="background:linear-gradient(whitesmoke,white);" readonly>
                    </div>
                </div>
                <div class="col-sm-0.5"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-0.5"></div>
                <div class="col-sm-11">
                    <label class="control-label col-sm-2" for="object1">Oggetto:</label>
                    <div class="col-sm-10">
                        <input name="object1" type="text" class="form-control" id="object1"
                               value="<%=sendedLettersBean.getLetters().get(index).getObject()%>"
                               style="background:linear-gradient(whitesmoke,white);" readonly>
                    </div>
                </div>
                <div class="col-sm-0.5"></div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-0.5"></div>
                <div class="col-sm-11">
                    <label class="control-label col-sm-2" for="message1">Testo:</label>
                    <div class="col-sm-10">
                        <!-- Lasciare così la textarea altrimenti introduce spazi bianchi misteriosi-->
                        <textarea name="texts" class="form-control" rows="7" id="message1"
                                  style="resize:none; background:linear-gradient(whitesmoke,white);"
                                  readonly><%=sendedLettersBean.getLetters().get(index).getBody()%></textarea>
                    </div>
                </div>
                <div class="col-sm-0.5"></div>
            </div>
        </div>
    </div>
</div>