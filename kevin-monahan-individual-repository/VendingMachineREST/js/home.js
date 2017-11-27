$(document).ready(function() {

  getJunkFood();

//just a bunch of css stylings to make the page pretty
  $('.container').css("background-color", "red");
  $('.head').css("color", "indigo");
  $('body').css("background-color", "indigo");
  $('#balance').css("color", "indigo");
  $('#dollarBtn').css("background-color", "turquoise");
  $('#quarterBtn').css("background-color", "turquoise");
  $('#nickelBtn').css("background-color", "turquoise");
  $('#dimeBtn').css("background-color", "turquoise");
  $('#purchaseBtn').css("background-color", "turquoise");
  $('#changeBtn').css("background-color", "turquoise");
  $('#balance').css("color", "RoyalBlue");
  $('#changeOutput').css("color", "RoyalBlue");
  $('#message').css("color", "RoyalBlue");
  $('#itemNum').css("color", "RoyalBlue");

  //click function for completing the purchase. subtracts from item quantity on successful purchase
  $('#purchaseBtn').click(function() {
    $("#changeOutput").val('');
    var itemNum = $('#itemNum').val();
    var money = document.getElementById('balance').value;
    $.ajax({
      type: 'GET',
      url: 'http://localhost:8080/money/' + money + '/' + 'item/' + itemNum,
      success: function() {
        itemPrice = $('#item' + itemNum + 'Price').text();
        itemPriceInPennies = Math.round(parseFloat(itemPrice.substring(1,itemPrice.length)) * 100);
        money = Math.round(parseFloat(money) * 100);
        var currentBalance = ((money - itemPriceInPennies) / 100).toString();
        $('#balance').val(currentBalance);
        $('#message').val('Thank You!!!');
        getJunkFood();
      },
      error: function(response) {
        var obj = JSON.parse(response.responseText);
        $('#message').val(obj.message);
      }
    });
  });

  // click function for dispensing change.
  $('#changeBtn').click(function() {
    var pennyBalance = Math.round(parseFloat($('#balance').val()) * 100);
    var quarters = Math.floor(pennyBalance / 25);
    pennyBalance %= 25;
    var dimes = Math.floor(pennyBalance / 10);
    pennyBalance %= 10;
    var nickels = Math.floor(pennyBalance / 5);
    pennyBalance %= 5;
    var change = {"quarters":quarters, "dimes":dimes, "nickels":nickels,"pennies":pennyBalance};
    displayChange(change);
    $('#balance').val('0.00');
    $('#itemNum').val('');
    $('#message').val('');
  });

  //List of buttons for adding money to the wallet.
  $('#dollarBtn').click(function() {
    $("#changeOutput").val('');
    var balance = parseFloat(document.getElementById('balance').value) + 1.00;
    document.getElementById('balance').value = balance.toString();
  });
  $('#quarterBtn').click(function() {
    $("#changeOutput").val('');
    var balance = parseFloat($('#balance').val()) + .25;
    $('#balance').val(balance.toString());
  });
  $('#dimeBtn').on('click', function() {
    $("#changeOutput").val('');
    var balance = Math.round(parseFloat(document.getElementById('balance').value) * 100 + 10) / 100;
    document.getElementById('balance').value = balance.toString();
  });
  $('#nickelBtn').click(function() {
    $("#changeOutput").val('');
    var balance = Math.round(parseFloat($('#balance').val()) * 100 + 5) / 100;
    $('#balance').val(balance.toString());
  });
});

//loading items function.
function getJunkFood() {
  $('#junkFood').empty();
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/items',
    success: function(junkFood) {
      var rowNum = 0;
      for (i = 1; i <= junkFood.length; i++) {
        if ((i-1)%3 == 0) {
          rowNum++;
          $('#junkFood').append('<div id="row' + rowNum + '" class="row"></div>');
        }
        var itemButton = '<div class="col-sm-4"><div class="panel panel-default"><div class="panel-body">';
        itemButton += '<p class="text-left itemNumber">' + junkFood[i - 1].id + '</p>';
        itemButton += '<p class="text-center">' + junkFood[i - 1].name + '</p>';
        itemButton += '<p class="text-center" id="item' + i + 'Price">$' + junkFood[i - 1].price + '</p>';
        itemButton += '<br><p class="text-center">Quantity Left: ' + junkFood[i - 1].quantity + '</p>';
        itemButton += '</div></div></div>';
        $('#row' + rowNum).append(itemButton);
      }
      $('.panel-body').css("background-color", "green");
      $('.panel-body').hover(function() {
        $(this).css("background-color","blue");},
        function() {
          $(this).css("background-color","green");
        });
        $('.panel-body').click(function() {
          $('#itemNum').val($(this).find('.itemNumber').text());
        });
      },
      error: function() {
        alert('Error: Problem connecting to web service. Please try again later.');
      }
    });
  }
//function for outputting change.
  function displayChange(change) {
    var changeOutput = "" + change.quarters + " Quarters ";
    changeOutput += change.dimes + " Dimes ";
    changeOutput += change.nickels + " Nickels ";
    changeOutput += change.pennies + " Pennies";
    $('#changeOutput').val(changeOutput);
  }
