
$(document).ready(function() {
	
	$("#table-persons i").click(function(event) {
		event.preventDefault();
		
		var person_id = $(this).parent().parent().data("person");
		var icon = $(this).attr("class");
		
		console.log("person_id: "+person_id);
		console.log("icon: "+icon);
		
		switch(icon){
		
		case "icon-edit":
			$("#modal-label").html("Editar Persona");
			$("#modal .modal-body").load("/personas/"+person_id, function() {
				person_edit();
				$("#modal").modal('show');
			});
			break;
		case "icon-trash":
			$.ajax({
				  type: "DELETE",
				  url: "/personas/"+person_id,
				  //data: ""
				}).done(function( msg ) {
					$("#content").load("/personas");
				});
			break;
		case "icon-certificate":
			$.ajax({
				type: "GET",
				dataType: "xml",
				//dataType: "json",
				url: "/personas/"+person_id,
				success: function(xml){
					
					//$xml = $(xml);
	                //console.log($xml.document);
					
					//alert($(xml));
	                //alert($(xml).text());
					//console.log($(xml).children());
	                //alert($(xml).html());
					//console.log(renderjson(xml));
					console.log(xml);
	                //console.log($(xml).text());
					//var win = window.open();
					//win.document.write(renderjson(xml));
					//win.document.write(xml);
					//win.focus();
				},
			});
		default:
			break;
		}
	});
	
	$("#btn-addperson").click(function(event) {
		event.preventDefault();
		$.get('/personas/crear', function(data) {
			  $("#modal-label").html("Crear Persona");
			  $("#modal .modal-body").html(data, function(){
				  $("#modal").modal('show');
			  });
			  person_edit();
		});
	});
});

function person_edit(){
	
	console.log("person edit");
	
	$("#form-person").validate({
		rules: {
			runnumber: "required",
			rundv: "required",
			firstname: "required",
			primarylastname: "required",
			secondlastname: "required",
			primarylastname: "required",
			genre: "required",
			birth: "required"
		},/*
		messages: {
				firstname: "Please specify your firstname",
				primarylastname: "Please specify your primary lastname",
				secondlastname: "Please specify your second lastname"
				
		},*/
		highlight: function(element) {
		    $(element).closest('.control-group').removeClass('success').addClass('error');
		},
		success: function(element) {
		    element
		    .addClass('valid')
		.closest('.control-group').removeClass('error').addClass('success');
		},
		submitHandler: function(form) {
		  $(form).ajaxSubmit();
		} 
		  
	});
	
	$("#btn-form-person").click( function(event) {
		event.preventDefault();
		var form = $(this).parent().parent();
		console.log('firstname='+$("#firstname").val()+'&primarylastname='+$("#primarylastname").val()+'&secondlastname='+$("#secondlastname").val()+'&runnumber='+$("#runnumber").val()+'&rundv='+$("#rundv").val()+'&genre='+$("#genre").val()+'&birth='+$("#birth").val()+'&nationality='+$("#nationality").val());
		if( $("#form-person").valid() == true )
			$.ajax({
				  type: form.attr("method"),
				  url: form.attr("action"),
				  data: 'firstname='+$("#firstname").val()+'&primarylastname='+$("#primarylastname").val()+'&secondlastname='+$("#secondlastname").val()+'&runnumber='+$("#runnumber").val()+'&rundv='+$("#rundv").val()+'&genre='+$("#genre").val()+'&birth='+$("#birth").val()+'&nationality='+$("#nationality").val()
				}).done(function( msg ) {
					$("#content").load("/personas");
					$("#modal").modal('hide');
				});
	});
	
	$("#dp-birth").datepicker({
	    format: "yyyy-mm-dd",
	    weekStart: 1,
	    todayBtn: true,
	    language: "es",
	    keyboardNavigation: false,
	    autoclose: true,
	    todayHighlight: true
	});
}


//Copyright © 2013 David Caldwell <david@porkrind.org>
//
// Permission to use, copy, modify, and/or distribute this software for any
// purpose with or without fee is hereby granted, provided that the above
// copyright notice and this permission notice appear in all copies.
//
// THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
// WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
// SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
// WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION
// OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN
// CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.

// Usage
// -----
// The module exports one entry point, the `renderjson()` function. It takes in
// the JSON you want to render as a single argument and returns an HTML
// element.
//
// Theming
// -------
// The HTML output uses a number of classes so that you can theme it the way
// you'd like:
//     .disclosure    ("⊕", "⊖")
//     .syntax        (",", ":", "{", "}", "[", "]")
//     .string        (includes quotes)
//     .number
//     .boolean
//     .key           (object key)
//     .keyword       ("null", "undefined")
//     .object.syntax ("{", "}")
//     .array.syntax  ("[", "]")

exports = {};
exports.renderjson = renderjson = (function() {
    var themetext = function(/* [class, text]+ */) {
        var spans = [];
        while (arguments.length)
            spans.push(append(span(Array.prototype.shift.call(arguments)),
                              text(Array.prototype.shift.call(arguments))));
        return spans;
    };
    var append = function(/* el, ... */) {
        var el = Array.prototype.shift.call(arguments);
        for (var a=0; a<arguments.length; a++)
            if (arguments[a].constructor == Array)
                append.apply(this, [el].concat(arguments[a]));
            else
                el.appendChild(arguments[a]);
        return el;
    };
    var prepend = function(el, child) {
        el.insertBefore(child, el.firstChild);
        return el;
    }
    var isempty = function(obj) { for (var k in obj) if (obj.hasOwnProperty(k)) return false;
                                  return true; }
    var text = function(txt) { return document.createTextNode(txt) };
    var div = function() { return document.createElement("div") };
    var span = function(classname) { var s = document.createElement("span");
                                     if (classname) s.className = classname;
                                     return s; };
    var A = function A(txt, classname, callback) { var a = document.createElement("a");
                                                   if (classname) a.className = classname;
                                                   a.appendChild(text(txt));
                                                   a.href = '#';
                                                   a.onclick = function() { callback(); return false; };
                                                   return a; };

    function _renderjson(json, indent, dont_indent) {
        var my_indent = dont_indent ? "" : indent;

        if (json === null) return themetext(null, my_indent, "keyword", "null");
        if (json === void 0) return themetext(null, my_indent, "keyword", "undefined");
        if (typeof(json) != "object") // Strings, numbers and bools
            return themetext(null, my_indent, typeof(json), JSON.stringify(json));

        var disclosure = function(open, close, type, builder) {
            var content;
            var empty = span(type);
            var show = function() { if (!content) append(empty.parentNode,
                                                         content = prepend(builder(),
                                                                           A(renderjson.hide, "disclosure",
                                                                             function() { content.style.display="none";
                                                                                          empty.style.display="inline"; } )));
                                    content.style.display="inline";
                                    empty.style.display="none"; };
            append(empty,
                   A(renderjson.show, "disclosure", show),
                   themetext(type+ " syntax", open),
                   A(" ... ", null, show),
                   themetext(type+ " syntax", close));

            var el = append(span(), text(my_indent.slice(0,-1)), empty);
            if (renderjson.show_by_default)
                show();
            return el;
        };

        if (json.constructor == Array) {
            if (json.length == 0) return themetext(null, my_indent, "array syntax", "[]");

            return disclosure("[", "]", "array", function () {
                var as = append(span("array"), themetext("array syntax", "[", null, "\n"));
                for (var i=0; i<json.length; i++)
                    append(as,
                           _renderjson(json[i], indent+"    "),
                           i != json.length-1 ? themetext("syntax", ",") : [],
                           text("\n"));
                append(as, themetext(null, indent, "array syntax", "]"));
                return as;
            });
        }

        // object
        if (isempty(json))
            return themetext(null, my_indent, "object syntax", "{}");

        return disclosure("{", "}", "object", function () {
            var os = append(span("object"), themetext("object syntax", "{", null, "\n"));
            for (var k in json) var last = k;
            for (var k in json)
                append(os, themetext(null, indent+"    ", "key", '"'+k+'"', "object syntax", ': '),
                       _renderjson(json[k], indent+"    ", true),
                       k != last ? themetext("syntax", ",") : [],
                       text("\n"));
            append(os, themetext(null, indent, "object syntax", "}"));
            return os;
        });
    }

    var renderjson = function renderjson(json)
    {
        var pre = append(document.createElement("pre"), _renderjson(json, ""));
        pre.className = "renderjson";
        return pre;
    }
    renderjson.set_icons = function(show, hide) { renderjson.show = show;
                                                  renderjson.hide = hide;
                                                  return renderjson; };
    renderjson.set_show_by_default = function(show) { renderjson.show_by_default = show;
                                                      return renderjson; };
    renderjson.set_icons('⊕', '⊖');
    renderjson.set_show_by_default(false);
    return renderjson;
})();