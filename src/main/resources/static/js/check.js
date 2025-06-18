"use strict";

$(() => {
  $(".done").on("click", function () {
    const row = $(this).closest("tr");
    const title = row.find(".title");
    const description = row.find(".description");

    if ($(this).prop("checked") === true) {
      title.css("text-decoration", "line-through");
      description.css("text-decoration", "line-through");
    } else {
      title.css("text-decoration", "none");
      description.css("text-decoration", "none");
    }
  });
});
