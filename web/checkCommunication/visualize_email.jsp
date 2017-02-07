<%@ page import="bean.ListLetterBean" %>
<%@ page import="controller.communication.CommunicationController" %>
<%@ page import="querySQL.Query" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //TODO prendere username di sender dal login di Luca e username di receiver dal caso d'uso di Davide...
    try {
        ListLetterBean sendedLetters = new ListLetterBean();
        sendedLetters.setLetters(new CommunicationController().getEmailInfo("username", Query.findSenderNameAndSurname)); //TODO cambiare username
        session.setAttribute("sendedLettersBean", sendedLetters);

        ListLetterBean receivedLetters = new ListLetterBean();
        receivedLetters.setLetters(new CommunicationController().getEmailInfo("username", Query.findReceiverNameAndSurname)); //TODO cambiare username
        session.setAttribute("receivedLettersBean", receivedLetters);

    } catch (Exception e) {
        e.printStackTrace();
    }

    request.getRequestDispatcher("checkCommunication.jsp").forward(request, response);
%>


<script>

    /*var images = new Array(7);
     images[0] = "Images/lab1.jpeg";
     images[1] = "Images/lab2.jpeg";
     images[2] = "Images/lab3.jpeg";
     images[3] = "Images/lab4.jpeg";
     images[4] = "Images/lab5.jpeg";
     images[5] = "Images/lab6.jpeg";
     images[6] = "Images/lab7.jpeg";*/

    //cur_snd = array.size()-1
    num_snd = 1;

    //cur_rcv = array.size()-1
    num_rcv = 1;

    function goBackSended() {
        //var im = document.getElementById("image");
        if (cur_snd > 0) {
            //im.src = images[cur_snd - 1];
            cur_snd = cur_snd - 1;
        } else {
            alert("This is the first sended letter");
        }
    }

    function goForwardSended() {
        //var im = document.getElementById("image");
        if (cur_snd < num_snd) {
            //im.src = images[cur_snd + 1];
            cur_snd = cur_snd + 1;
        } else {
            alert("This is the last sended letter");
        }
    }


    function goBackReceived() {
        //var im = document.getElementById("image");
        if (cur_snd > 0) {
            //im.src = images[cur_snd - 1];
            cur_snd = cur_snd - 1;
        } else {
            alert("This is the first received letter");
        }
    }

    function goForwardReceived() {
        //var im = document.getElementById("image");
        if (cur_snd < num_rcv) {
            //im.src = images[cur_snd + 1];
            cur_snd = cur_snd + 1;
        } else {
            alert("This is the last received letter");
        }
    }
</script>