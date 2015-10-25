$( document ).ready( function ()
		{   
                    $('#start-search').click(function ()
                    {
                        var isFormSubmit = true;
                        
                        $("#msgError1").hide();
                        $("#msgError2").hide();
                        $("#msgError3").hide();
                        $("#msgError4").hide();
                        $("#msgError5").hide();

                       if (  $('#info_text1').val().length == 0 )
                       {
                          $('#info_text1').attr("class" , "input-error" );
                          isFormSubmit = false;
                          $("#msgError1").toggle();
                       }
                       else
                       {
                            $('#info_text1').val( $('#info_text1').val().trim() );
                            $('#info_text1').attr("class" , "input-msg" );
                            $("#msgError1").hide();
                       }
                       
                       if (  $('#info_text2').val().length == 0 )
                       {
                          $('#info_text2').attr("class" , "input-error" );
                          isFormSubmit = false;
                          $("#msgError2").toggle();
                       }
                       else
                       {
                            $('#info_text2').val( $('#info_text2').val().trim() );
                            $('#info_text2').attr("class" , "input-msg" );
                            $("#msgError2").hide();
                       }
                       
                       if (  $('#info_text3').val().length == 0 )
                       {
                           $('#info_text3').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError3").toggle();
                       }
                       else
                       {
                            $('#info_text3').val( $('#info_text3').val().trim() );
                            $('#info_text3').attr("class" , "input-msg" );
                            $("#msgError3").hide();
                       }
                       
                       if (  $('#info_text4').val().length == 0 )
                       {
                           $('#info_text4').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError4").toggle();
                       }
                       else
                       {
                            $('#info_text4').val( $('#info_text4').val().trim() );
                            $('#info_text4').attr("class" , "input-msg" );
                            $("#msgError4").hide();
                       }
                       
                       if (  $('#info_text5').val().length == 0 )
                       {
                           $('#info_text5').attr("class" , "input-error" );
                           isFormSubmit = false;
                           $("#msgError5").toggle();
                       }
                       else
                       {
                            $('#info_text5').val( $('#info_text5').val().trim() );
                            $('#info_text5').attr("class" , "input-msg" );
                            $("#msgError5").hide();
                       }

                       if ( isFormSubmit )
                       {
                            $('#form_submit').unbind('submit') ;
                            $("#table-result").css( "visibility", "visible" );
                        }
                        else
                        {
                         $("#table-result").css( "visibility", "hidden" );
                        $('#form_submit').submit(function(event)
                        {
                            event.preventDefault();
                        }); 
                        }
                    
                       
                    } );
                    
                    $("#btn-clear-fields").click( function ()
                    {
                         $('#info_text1').val( "" );
                         $('#info_text2').val( "" );
                         $('#info_text3').val( "" );
                         $('#info_text4').val( "" );
                         $('#info_text5').val( "" );
                    });
                    
                });