(function() {
  $(document).ready(function() {
    var skycons;
    $(".navbar-docs li.dropdown > a").click(function(e) {
      e.preventDefault();
      $(this).next('ul').slideToggle(300);
      return $(this).parent('li').toggleClass("dropup");
    });
    $(".sparkline-bar").sparkline([160, 220, 260, 120, 320, 260, 300, 160, 240, 100], {
      type: "bar",
      height: 50,
      barSpacing: 4,
      barWidth: 8,
      barColor: "#f5af50"
    });
    $(".sparkline-line").sparkline([160, 240, 250, 280, 300, 250, 230, 200, 280, 380], {
      type: "line",
      width: "150",
      height: "50",
      lineColor: "#a5e1ff",
      fillColor: "rgba(241, 251, 255, 0.9)",
      lineWidth: 2
    });
    $(".easy-pie-chart").easyPieChart({
      size: 120,
      lineWidth: 10,
      lineCap: "square",
      barColor: "#81e970",
      animate: 800,
      scaleColor: false
    });
    $(".select2").select2();
    $(".sparkline-pie").sparkline([2, 8, 6, 10], {
      type: "pie",
      height: "120",
      width: "120",
      sliceColors: ["#a0eeed", "#81e970", "#f5af50", "#f46f50"]
    });
    if (document.getElementById("rain")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("rain"), Skycons.RAIN);
      skycons.play();
    }
    if (document.getElementById("cloudy")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("cloudy"), Skycons.CLOUDY);
      skycons.play();
    }
    if (document.getElementById("partly-cloudy-day")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("partly-cloudy-day"), Skycons.PARTLY_CLOUDY_DAY);
      skycons.play();
    }
    if (document.getElementById("partly-cloudy-night")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("partly-cloudy-night"), Skycons.PARTLY_CLOUDY_NIGHT);
      skycons.play();
    }
    if (document.getElementById("sleet")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("sleet"), Skycons.SLEET);
      skycons.play();
    }
    if (document.getElementById("clear-day")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("clear-day"), Skycons.CLEAR_DAY);
      skycons.play();
    }
    if (document.getElementById("clear-night")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("clear-night"), Skycons.CLEAR_NIGHT);
      skycons.play();
    }
    if (document.getElementById("wind")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("wind"), Skycons.WIND);
      skycons.play();
    }
    if (document.getElementById("snow")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("snow"), Skycons.SNOW);
      skycons.play();
    }
    if (document.getElementById("fog")) {
      skycons = new Skycons({
        color: "black"
      });
      skycons.add(document.getElementById("fog"), Skycons.FOG);
      return skycons.play();
    }
  });

}).call(this);
