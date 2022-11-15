$(document).ready(function(){

    clearMessages();
    var conversations = [];
    loadConversations();
  });

  function clearMessages(){
    $('#alert-success').hide();
    $('#alert-fail').hide();
    $('#alert-unexpected-fail').hide();
  }

  function executarJob(){

    $.get('http://localhost:8080/v1/conversations/batch', function(mensagem, status){

        clearMessages();

        if('COMPLETED' === mensagem){
            $('#alert-success').show();
        } else if('FAILED' === mensagem){
            $('#alert-fail').show();
        }else{
            $('#alert-unexpected-fail').show();
        }
    });
  }

  function loadConversation(){

    $('#table-conversation').find('tbody').each(function(){ this.remove();});

    $.get('http://localhost:8080/v1/conversation', function(result, status){
        
         conversations = result;

         $(conversations).each(
             
            function(){
              
                var $linha = $('<tr>');
                    var $id = $('<td>');
                    var $data = $('<td>');
                    var $status = $('<td>');
                    var $mensagem = $('<td>');

                $id.append(this.id);
                $data.append(this.data);
                $status.append(this.status);
                $mensagem.append(this.mensagem);

                $linha.append($id);
                $linha.append($data);
                $linha.append($status);
                $linha.append($mensagem);

                $tableConversation = $('#table-conversation');
                $tableConversation.append($linha);
            })
    });
}