function inputCheck() {
    $('#signUp :input').each(function(){
        if($(this).val() === "" ) {
            console.log($(this).val());
            return false;
        }
    });
    return true;
}

function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] === sParam) 
        {
            return sParameterName[1];
        }
    }
    return null;
}

$(document).ready(function() {
    $('#toTop').click(function() {
        scroll("#page-top");
    });
    
    var status = getUrlParameter('status');
    if(status !== null) {
        if(status === "success") {
            $.notify({
                message: 'Successfuly submited' 
            },{
                type: 'success',
                delay: '5000'
            });
        } else if (status === "failed") {
            $.notify({
                message: 'Failed to submit' 
            },{
                type: 'danger',
                delay: '5000'
            });
        }
    }
});