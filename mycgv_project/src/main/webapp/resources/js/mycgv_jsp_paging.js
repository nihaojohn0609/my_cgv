//$(document).ready(function(){
function test(dbCount,pageSize,pageCount,page){
alert(dbCount+","+pageSize+","+pageCount+","+page);
	
	let fname = $("#fname").val();
		
	if(fname != ""){
		var pager = $('#ampaginationsm').pagination({
				
			    maxSize: 2,	    	// max page size
			    totals: pageCount,				// total rows	
			    page: page,					// initial page		
			    pageSize: pageSize,			// max number items per page
			
			    // custom labels		
			    lastText: '&raquo;&raquo;', 		
			    firstText: '&laquo;&laquo;',		
			    prevText: '&laquo;',		
			    nextText: '&raquo;',
					     
			    btnSize:'sm'	// 'sm'  or 'lg'		
			});
			
			
			jQuery('#ampaginationsm').on('am.pagination.change',function(e){
				   jQuery('.showlabelsm').text('The selected page no: '+e.page);
		           $(location).attr('href', "http://localhost:9000/mycgv_jsp/"+ fname + "?page="+e.page);         
		    });

	}
	
	}//f	
//}); //ready