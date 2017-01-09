/*  Profile Manager - Copyright (C) 2016  Daniele Tellina (http://www.daniele.tellina/).

    Profile Manager is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Profile Manager is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Profile Manager.  If not, see <http://www.gnu.org/licenses/>.
 */

var socket

$(document)
      .ready(
            function() {
               if (!("WebSocket" in window)) {
                  $('#chatLog, input, button, #examples').fadeOut("fast");
                  $('<p>Oh no, you need a browser that supports WebSockets. How about <a href="http://www.google.com/chrome">Google Chrome</a>?</p>')
                        .appendTo('#container');
               } else {
                  // The user has WebSockets

                 //listen();
               }

            });
var url = '192.168.0.78';
var cmdport = '8090';
var wsport = '8080';
var doc;

function bose(arg) {
   $("#target").load('http://' + url + ':' + cmdport + '/' + page);
}

function preset(el) {
   xml = '<key state="press" sender="Gabbo">PRESET_' + el.value + '</key>';
   post('key', xml);
   xml = '<key state="release" sender="Gabbo">PRESET_' + el.value + '</key>';
   post('key', xml);
}

function key(el) {
   xml = '<key state="press" sender="Gabbo">' + el.value + '</key>';
   post('key', xml);
   xml = '<key state="release" sender="Gabbo">' + el.value + '</key>';
   post('key', xml);
}

function post(page, str) {
   console.log(str);
   $.ajax({
      url : 'http://' + url + ':' + cmdport + '/' + page,
      processData : false,
      type : "POST",
      data : str,
      success : function(response) {
         console.log(response);
      },
      error : function(response) {
         console.log(response);
      }
   });
}
var connection;
function listen() {
   connection = new WebSocket('ws://' + url + ':' + wsport, "gabbo");
   connection.onopen = function() {
      $("#connstatus").text("Connection open. ");
   };
   connection.onmessage = function(e) {
      document.getElementById("messages").innerHTML += "<br /><br />";
      document.getElementById("messages").innerText += e.data;
   };
   connection.onclose = function() {
      $("#connstatus").append("Connection closed. ");
   }
   connection.onerror = function() {
      $("#connstatus").text("Connection error. ");
      setTimeout(listen, 1000);
   }
}

// on page load
function loaded() {
   doc = document.documentElement.outerHTML;
   listen();
   $("#info").text(url);
}

function connect() {
   var socket;
   var host = "ws://localhost:8000/socket/server/startDaemon.php";

   try {
      var socket = new WebSocket(host);

      message('<p class="event">Socket Status: ' + socket.readyState);

      socket.onopen = function() {
         message('<p class="event">Socket Status: ' + socket.readyState
               + ' (open)');
      }

      socket.onmessage = function(msg) {
         message('<p class="message">Received: ' + msg.data);
      }

      socket.onclose = function() {
         message('<p class="event">Socket Status: ' + socket.readyState
               + ' (Closed)');
      }

   } catch (exception) {
      message('<p>Error' + exception);
   }
}

function message(msg) {
   $('#chatLog').append(msg + '</p>');
}