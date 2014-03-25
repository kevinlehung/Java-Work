$(function(){
	$('#inplaceediting-about-me-content').editable({placement:'bottom'});
	
    $('#inplaceediting-about-me').click(function(e) {
        e.stopPropagation();
        e.preventDefault();
        $('#inplaceediting-about-me-content').editable('toggle');
    });

    $('#inplaceediting-service-content').editable({placement:'bottom'});
	
    $('#inplaceediting-service').click(function(e) {
        e.stopPropagation();
        e.preventDefault();
        $('#inplaceediting-service-content').editable('toggle');
    });

    $("#education-daterange").daterangepicker({
        format: "MM/DD/YYYY"
    }, function(start, end) {
        return $("#education-daterange").parent().find("input").first().val(start.format("MMMM D, YYYY") + " - " + end.format("MMMM D, YYYY"));
    });
    $("#employment-daterange").daterangepicker({
        format: "MM/DD/YYYY"
    }, function(start, end) {
        return $("#employment-daterange").parent().find("input").first().val(start.format("MMMM D, YYYY") + " - " + end.format("MMMM D, YYYY"));
    });
    
    $('#inplaceediting-skills').editable({
        inputclass: 'input-large',
        select2: {
            tags: ['html', 'javascript', 'css', 'ajax'],
            tokenSeparators: [","]
        }
    });
    
    $('#inplaceediting-skills-link').click(function(e) {
        e.stopPropagation();
        e.preventDefault();
        $('#inplaceediting-skills').editable('toggle');
    });
});

