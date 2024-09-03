<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bar Graph</title>
    <style>
        .bar-container {
            width: 100%;
            display: flex;
            justify-content: space-around;
            align-items: flex-end;
            height: 300px;
            border: 1px solid #ccc;
            padding: 10px;
        }
        .bar {
            width: 50px;
            background-color: mediumseagreen;
            color: white;
            text-align: center;
            line-height: 20px;
            margin: 0 5px;
            border-radius: 5px;
        }
        .bar-label {
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="bar-container" id="bar-container"></div>

    <script>
        // Data for the bar graph
        const data = [
            { label: '1', value: 58 },
            { label: '2', value: 25 },
            { label: '3', value: 26 },
            { label: '4', value: 12 },
            { label: '5', value: 2 },
            { label: '6', value: 1 }
        ];

        // Get the container where bars will be added
        const container = document.getElementById('bar-container');

        // Calculate the maximum value for scaling
        const maxValue = Math.max(...data.map(item => item.value));

        // Create bars
        data.forEach(item => {
            const bar = document.createElement('div');
            const barHeight = (item.value / maxValue) * 100; // Scale height
            bar.style.height = `${barHeight}%`;
            bar.className = 'bar';
            bar.innerHTML = `${item.value}<div class="bar-label">${item.label}</div>`;
            container.appendChild(bar);
        });
    </script>
</body>
</html>
