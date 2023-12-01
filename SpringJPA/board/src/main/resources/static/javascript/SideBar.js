$(function () {
  var $aside = $('aside'),
    $button = $aside.find('button');
  var $a = $button.find('a');

  $button.click(function () {
    $aside.toggleClass('open');

    if ($aside.hasClass('open')) {
      $aside.css({ transform: 'translateX(100%)' });
      $a.text('Close');
    } else {
      $aside.css({ transform: 'translateX(0)' });
      $a.text('More');
    }
  });
});

$(function () {
  var $aside = $('aside');

  $('#cursor').click(function () {
    $aside.toggleClass('open');

    if ($aside.hasClass('open')) {
      $aside.css({ transform: 'translateX(100%)' });
    } else {
      $aside.css({ transform: 'translateX(0)' });
    }
  });
});
