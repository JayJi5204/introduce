$(function () {
  var $aside = $('aside'),
    $button = $aside.find('button'),
    $duration = 300;
  var $a = $button.find('a');

  $button.click(function () {
    $aside.toggleClass('open');

    if ($aside.hasClass('open')) {
      $aside.stop().animate({ left: '560px' }, $duration);
      $a.text('Close');
    } else {
      $aside.stop().animate({ left: '336px' }, $duration);
      $a.text('More');
    }
  });
});
