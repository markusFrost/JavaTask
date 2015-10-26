$( document ).ready( function ()
		{   
                    $('#start-search').click(function ()
                    {
                        var isFormSubmit = true;
                        
                        var maxLength = 1000;
                        
                        $("#msgError1").hide();
                        $("#msgError2").hide();
                        $("#msgError3").hide();
                        $("#msgError4").hide();
                        $("#msgError5").hide();
                        
                        $('#info_text1').val( $('#info_text1').val().trim() );
                        $('#info_text2').val( $('#info_text2').val().trim() );
                         $('#info_text3').val( $('#info_text3').val().trim() );
                         $('#info_text4').val( $('#info_text4').val().trim() );
                         $('#info_text5').val( $('#info_text5').val().trim() );

                        //start search empty text fields and fields 
                        //where text length greate than 1000
                       if (  $('#info_text1').val().length == 0 )
                       {
                          $('#info_text1').attr("class" , "input-error" );
                          isFormSubmit = false;
                          $("#msgError1").toggle();
                          $("#msgError1").text( "Заполните поле №1 !" );
                       }
                       else if (  $('#info_text1').val().length > maxLength )
                       {
                          $('#info_text1').attr("class" , "input-error" );
                          isFormSubmit = false;
                          $("#msgError1").toggle();
                          $("#msgError1").text( "Длина текста должна быть не больше " + maxLength + " символов!" );
                       }
                       else
                       {
                            
                            $('#info_text1').attr("class" , "input-msg" );
                            $("#msgError1").hide();
                       }
                       
                       if (  $('#info_text2').val().length == 0 )
                       {
                          $('#info_text2').attr("class" , "input-error" );
                          isFormSubmit = false;
                          $("#msgError2").toggle();
                          $("#msgError2").text( "Заполните поле №2 !" );
                       }
                       else  if (  $('#info_text2').val().length > maxLength )
                       {
                            $('#info_text2').attr("class" , "input-error" );
                          isFormSubmit = false;
                          $("#msgError2").toggle();
                            $("#msgError2").text( "Длина текста должна быть не больше " + maxLength + " символов!" );
                       }
                       else
                       {
                            
                            $('#info_text2').attr("class" , "input-msg" );
                            $("#msgError2").hide();
                       }
                       
                       if (  $('#info_text3').val().length == 0 )
                       {
                           $('#info_text3').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError3").toggle();
                           $("#msgError3").text( "Заполните поле №3 !" );
                       }
                       else  if (  $('#info_text3').val().length > maxLength )
                       {
                            $('#info_text3').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError3").toggle();
                            $("#msgError3").text( "Длина текста должна быть не больше " + maxLength + " символов!" );
                       }
                       else
                       {
                           
                            $('#info_text3').attr("class" , "input-msg" );
                            $("#msgError3").hide();
                       }
                       
                       if (  $('#info_text4').val().length == 0 )
                       {
                           $('#info_text4').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError4").toggle();
                           $("#msgError4").text( "Заполните поле №4 !" );
                       }
                       else  if (  $('#info_text4').val().length > maxLength )
                       {
                           $('#info_text4').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError4").toggle();
                            $("#msgError4").text( "Длина текста должна быть не больше " + maxLength + " символов!" );
                       }
                       else
                       {
                            
                            $('#info_text4').attr("class" , "input-msg" );
                            $("#msgError4").hide();
                       }
                       
                       if (  $('#info_text5').val().length == 0 )
                       {
                           $('#info_text5').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError5").toggle();
                           $("#msgError5").text( "Заполните поле №5 !" );
                       }
                       else  if (  $('#info_text5').val().length > maxLength )
                       {
                            $('#info_text5').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError5").toggle();
                            $("#msgError5").text( "Длина текста должна быть не больше " + maxLength + " символов!" );
                       }
                       else
                       {
                            
                            $('#info_text5').attr("class" , "input-msg" );
                            $("#msgError5").hide();
                       }

                       if ( isFormSubmit )
                       {
                            $('#form_submit').unbind('submit') ; //allow to submit form
                            $("#table-result").css( "visibility", "visible" ); // show table
                        }
                        else
                        {
                         $("#table-result").css( "visibility", "hidden" ); // hide table
                        $('#form_submit').submit(function(event) //because there is errors block form subit
                        {
                            event.preventDefault();
                        }); 
                        }
                    
                       
                    } );
                    
                    $("#btn-clear-fields").click( function () // clear old values
                    {
                         $('#info_text1').val( "" );
                         $('#info_text2').val( "" );
                         $('#info_text3').val( "" );
                         $('#info_text4').val( "" );
                         $('#info_text5').val( "" );
                    });
                    
                });