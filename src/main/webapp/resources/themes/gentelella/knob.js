/*
 Profile Manager - Copyright (C) 2016  Daniele Tellina

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

$(document).ready(function() {

   $('.knob').each(function(){
      // If checkbox doesn't exist in DOM
      $(this).val(parseInt(this.value * 100))
   });
   
   $(".knob").knob(
         {
            change : function(value) {
            },
            release : function(value) {
            },
            cancel : function() {
            },
            format : function(value) { return value + '%'; },
            draw : function() {
   
               // "tron" case
               if (this.$.data('skin') == 'tron') {
   
                  this.cursorExt = 0.3;
   
                  var a = this.arc(this.cv) // Arc
                  , pa // Previous arc
                  , r = 1;
   
                  this.g.lineWidth = this.lineWidth;
   
                  if (this.o.displayPrevious) {
                     pa = this.arc(this.v);
                     this.g.beginPath();
                     this.g.strokeStyle = this.pColor;
                     this.g.arc(this.xy, this.xy, this.radius - this.lineWidth,
                           pa.s, pa.e, pa.d);
                     this.g.stroke();
                  }
   
                  this.g.beginPath();
                  this.g.strokeStyle = r ? this.o.fgColor : this.fgColor;
                  this.g.arc(this.xy, this.xy, this.radius - this.lineWidth,
                        a.s, a.e, a.d);
                  this.g.stroke();
   
                  this.g.lineWidth = 2;
                  this.g.beginPath();
                  this.g.strokeStyle = this.o.fgColor;
                  this.g.arc(this.xy, this.xy, this.radius - this.lineWidth + 1
                        + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false);
                  this.g.stroke();
   
                  return false;
               }
            }
         });
   
   $("form").on('submit', function(e){

      var $form = $(this);
      // Iterate over all checkboxes in the table
      $('.knob').each(function(){
         // If checkbox doesn't exist in DOM
         $form.append(
            $('<input>')
               .attr('type', 'hidden')
               .attr('id', this.id)
               .attr('name', this.name)
               .val(this.value.substring(0, this.value.length-1) / 100)
         );
      });
   }); 
   
   
   
   
});