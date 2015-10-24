$( document ).ready( function ()
		{
                   
                       
                        
                    var result = "Ошибка! Заполните поле номер";
                    $('#start-search').click(function ()
                    {
                        var arr_error = [];
 
                       if (  $('#info_text1').val().length == 0 )
                       {
                          $('#info_text1').attr("class" , "input-error" );
                          arr_error[arr_error.length] = 1;
                       }
                       
                       if (  $('#info_text2').val().length == 0 )
                       {
                          $('#info_text2').attr("class" , "input-error" );
                          arr_error[arr_error.length] = 2;
                       }
                       
                       if (  $('#info_text3').val().length == 0 )
                       {
                           $('#info_text3').attr("class" , "input-error" );
                          arr_error[arr_error.length] = 3;
                       }
                       
                       if (  $('#info_text4').val().length == 0 )
                       {
                           $('#info_text4').attr("class" , "input-error" );
                          arr_error[arr_error.length] = 4;
                       }
                       
                       if (  $('#info_text5').val().length == 0 )
                       {
                           $('#info_text5').attr("class" , "input-error" );
                          arr_error[arr_error.length] = 5;
                       }

                        if ( arr_error.length >  0 )
                        {
                       var resValue = "Ошибка! Заполните данные в форме ";
                       for ( var i = 0; i < arr_error.length; i++ )
                       {
                           if ( i == arr_error.length - 1)
                           {
                               resValue = resValue.substr(0, resValue.length - 2 );
                                resValue += " и №" + arr_error[i] + " ! ";
                           }
                           else
                           {
                                resValue += "№" + arr_error[i] + " , ";
                            }
                       }
                       
                       $('#message-error').css("color", "red");
                        $('#message-error').text( resValue );
                        
                        $('#form_submit').submit(function(event)
                        {
                            event.preventDefault();
                        }); 
                    }
                    else
                    {
                          $('#form_submit').unbind('submit') ;
                    }
                       
                    } );
                });