
    // Set new default font family and font color to mimic Bootstrap's default styling
    Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#292b2c';

    // Function to fetch data from the API and create the chart
    async function fetchChartData() {
      try {
        // Replace 'http://yourapi.com/data' with the actual URL of your API
        const response = await fetch('https://localhost:8080/api/video-game/consulta/sales-of-years');
        const data = await response.json();

        // Assuming the API returns an object with 'labels' and 'values' arrays
        const labels = data.labels; // Example: ["January", "February", "March", "April", "May", "June"]
        const values = data.values; // Example: [4215, 5312, 6251, 7841, 9821, 14984]

        // Create the chart with the fetched data
        var ctx = document.getElementById("myBarChart");
        var myBarChart = new Chart(ctx, {
          type: 'bar',
          data: {
            labels: labels,
            datasets: [{
              label: "Revenue",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: values,
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'month'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 6
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 15000,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
      } catch (error) {
        console.error('Error fetching chart data:', error);
      }
    }

    // Fetch data and create the chart when the page loads
    window.onload = fetchChartData;